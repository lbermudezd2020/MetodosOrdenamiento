/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesExpMin;

/**
 *
 * @author luis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;




public class BellmanFord extends JPanel implements ActionListener{


JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar,salir;
public static final int MAX_VALUE = 999;
int numberofvertices = 0;
int source;



public BellmanFord(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  BELLMAN- FORD "));
sal.setEditable(false);


bot=new JPanel();
bot.setLayout(new GridLayout(2,0));
introducir=new JButton("Iniciar");
introducir.setBackground(Color.BLUE);
introducir.setForeground(Color.WHITE);
introducir.addActionListener(this);

mostrar=new JButton("Mostrar ");
mostrar.setBackground(Color.BLUE);
mostrar.setForeground(Color.WHITE);
mostrar.addActionListener(this);

salir=new JButton("Salir");
salir.setBackground(Color.BLUE);
salir.setForeground(Color.WHITE);
salir.addActionListener(this);

bot.add(introducir);
bot.add(mostrar);
bot.add(salir);

add(sal,BorderLayout.CENTER);
add(bot,BorderLayout.EAST);

}

public class Bellman{
    public int distances[];
    public int numberofvertices;

 
    public Bellman(int numberofvertices){
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];

    }

    public void BellmanFordEvaluation(int source, int adjacencymatrix[][]){

        for (int node = 1; node <= numberofvertices; node++){
            distances[node] = MAX_VALUE;
        }

        distances[source] = 0;
        for (int node = 1; node <= numberofvertices - 1; node++){
            for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++){
                for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++){
                    if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE){
                        if (distances[destinationnode] > distances[sourcenode] 
                                + adjacencymatrix[sourcenode][destinationnode])
                            distances[destinationnode] = distances[sourcenode]
                                + adjacencymatrix[sourcenode][destinationnode];

                    }
                }
            }
        }


        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++){
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++){
                if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE){
                    if (distances[destinationnode] > distances[sourcenode]
                           + adjacencymatrix[sourcenode][destinationnode])
                                           sal.append("\n" + "\n");
                        sal.append("EL GRAFO CONTIENE NEGATIVOS");

                }
            }
        }


        for (int vertex = 1; vertex <= numberofvertices; vertex++){
                   sal.append("\n" + "\n");

             sal.append("Distancia del origen " 
                     + source + " a "
                      + vertex + " es " 
                     + distances[vertex]);
                    sal.append("\n" + "\n");

        }
    }
    
}

    public void mainBell(){

        int adjacencymatrix[][] = new int[numberofvertices + 1][numberofvertices + 1];
        for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++){
            for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++){
                adjacencymatrix[sourcenode][destinationnode] = Integer.parseInt
        (JOptionPane.showInputDialog
        (null,"Ingrese La Matriz de Adyacencia",""
         ,JOptionPane.INFORMATION_MESSAGE));
 	        if (sourcenode == destinationnode){
                    adjacencymatrix[sourcenode][destinationnode] = 0;
                    continue;
                }

                if (adjacencymatrix[sourcenode][destinationnode] == 0){
                    adjacencymatrix[sourcenode][destinationnode] = MAX_VALUE;
                }
            }
        }

        source = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Ingrese el Origen",""
         ,JOptionPane.INFORMATION_MESSAGE));

        Bellman bellmanford = new Bellman(numberofvertices);
        bellmanford.BellmanFordEvaluation(source, adjacencymatrix);
       	
    }

    
@Override
public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
      numberofvertices = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Numero de Vertices",""
         ,JOptionPane.INFORMATION_MESSAGE));
 
}

if(ev.getSource()==mostrar){
    mainBell();
}

if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase