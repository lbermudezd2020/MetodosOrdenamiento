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
import java.util.Stack;

public class BusDES extends JPanel implements ActionListener{

JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar,salir;
int number_of_nodes, source;

public BusDES(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  BUSQUEDA DFS    "));
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

public class DFS{

    private Stack<Integer> stack;

    public DFS(){

        stack = new Stack<Integer>();

    }

    
    public void dfs(int adjacency_matrix[][], int source){

        int number_of_nodes = adjacency_matrix[source].length - 1;
        int visited[] = new int[number_of_nodes + 1];		
        int element = source;		

        int i = source;		
  sal.append("\n" + "\n");
        sal.append(element + "\t");		
  sal.append("\n" + "\n");
        visited[source] = 1;		

        stack.push(source);

 

        while (!stack.isEmpty()){

            element = stack.peek();
            i = element;	
	    while (i <= number_of_nodes)

	    {

     	        if (adjacency_matrix[element][i] == 1 && visited[i] == 0)

	        {

                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                   sal.append(element + "\t");
  
	            continue;

                }

                i++;

	    }

            stack.pop();	

        }	
    }
}    


 public void mainDFS(){

int adjacency_matrix[][] = new int[number_of_nodes + 1][number_of_nodes + 1];

	    for (int i = 1; i <= number_of_nodes; i++)
	        for (int j = 1; j <= number_of_nodes; j++)

                    adjacency_matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Ingrese Matriz",""
         ,JOptionPane.INFORMATION_MESSAGE));
 


            source = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Ingrese Origen",""
         ,JOptionPane.INFORMATION_MESSAGE));
 

            sal.append("El DFS del gráfo está dado por");
       sal.append("\n" + "\n");
       
            DFS dfs = new DFS();
            dfs.dfs(adjacency_matrix, source);					
	
    }	



@Override
public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
    number_of_nodes = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Numero de NODOS",""
         ,JOptionPane.INFORMATION_MESSAGE));

}

if(ev.getSource()==mostrar){
mainDFS();
}

if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase