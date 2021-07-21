/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusquedaDES_BFS;

/**
 *
 * @author luis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.Queue;

public class BusBFS extends JPanel implements ActionListener{

JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar,salir;
int number_no_nodes, source;

public BusBFS(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  BUSQUEDA BFS    "));
sal.setEditable(false);

bot=new JPanel();
bot.setLayout(new GridLayout(2,0));

introducir=new JButton("Ingresar");
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

public class BFS{ 

    private Queue<Integer> queue;
    public BFS(){

        queue = new LinkedList<Integer>();

    }

    public void bfs(int adjacency_matrix[][], int source){

        int number_of_nodes = adjacency_matrix[source].length - 1;
        int[] visited = new int[number_of_nodes + 1];
        int i, element;

        visited[source] = 1;
        queue.add(source);

        while (!queue.isEmpty())

        {

            element = queue.remove();
            i = element;
                   sal.append("\n" + "\n");

             sal.append(i + "\t");
                    sal.append("\n" + "\n");

            while (i <= number_of_nodes)
            {

                if (adjacency_matrix[element][i] == 1 && visited[i] == 0){

                    queue.add(i);
                    visited[i] = 1;
                }

                i++;
            }
        }
    }
}

    
    public void mainBFS(){

       int adjacency_matrix[][] = new int[number_no_nodes + 1][number_no_nodes + 1];

            for (int i = 1; i <= number_no_nodes; i++)
                for (int j = 1; j <= number_no_nodes; j++)

                    adjacency_matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Ingrese Matriz",""
         ,JOptionPane.INFORMATION_MESSAGE));

            source = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Ingrese Origen",""
         ,JOptionPane.INFORMATION_MESSAGE));

       sal.append("EL RECORRIDO DE BFS:  ");
       sal.append("\n" + "\n");

            BFS bfs = new BFS();

            bfs.bfs(adjacency_matrix, source);

    }
     
    
@Override
public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
    number_no_nodes = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Numero de NODOS",""
         ,JOptionPane.INFORMATION_MESSAGE));

}

if(ev.getSource()==mostrar){
mainBFS();
}

if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase