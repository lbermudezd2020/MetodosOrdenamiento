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


public class Prim extends JPanel implements ActionListener{


JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar,salir;
int V = 0;


public Prim(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  PRIM "));
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
 
 

int minKey(int key[], Boolean mstSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min)
            {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    void printMST(int parent[], int n, int graph[][])
    {
        sal.append("BORDE   PESO");
       sal.append("\n" + "\n");

        for (int i = 1; i < V; i++)
           sal.append(parent[i]+" --> "+ i +"  \n  "+" ="+graph[i][parent[i]]);
    }


    void primMST(int graph[][])
    {
        int parent[] = new int[V];
        int key[] = new int [V];
        Boolean mstSet[] = new Boolean[V];
        for (int i = 0; i < V; i++)
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;    
        parent[0] = -1; 

        for (int count = 0; count < V-1; count++)
        {
           
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++)

              
                if (graph[u][v]!=0 && mstSet[v] == false &&
                    graph[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
        }

        printMST(parent, V, graph);
    }

    public void mainPrim (){
            
        int numeros[][] = new int[5][5];
        sal.append("Ingrese datos de los PESOS");
        for (int h = 0; h < numeros.length; h++) {
            for (int j = 0; j < numeros.length; j++) {
                numeros[h][j] = Integer.parseInt(JOptionPane.showInputDialog
        (null,"INGRESE EL PESO",""
         ,JOptionPane.INFORMATION_MESSAGE));
 
            }
        }
        //sal.append("\nPESOS");
        for (int[] num : numeros) {
            for (int elem : num) {
               // System.out.print(elem + "\t"); 
            }
        
              primMST(numeros);
        
    }
    }

    
@Override
public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
  
 V=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero de Vertices",""
,JOptionPane.INFORMATION_MESSAGE));
}

if(ev.getSource()==mostrar){    
  mainPrim();
}

if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase