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
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class PrinDijkstra extends JPanel implements ActionListener{

JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar,salir;
int num =0;
int adjacency_matrix[][];
int number_of_vertices;
int source = 0;
int edgeDistance = -1;
int newDistance = -1;

public PrinDijkstra(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  DIJKSTRA "));
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
 

public class DijkstraQueue{

    private int distances[];
    private Queue<Integer> queue;
    private Set<Integer> settled;
    private int number_of_nodes;
    private int adjacencyMatrix[][];


    public DijkstraQueue(int number_of_nodes){

        this.number_of_nodes = number_of_nodes;
        distances = new int[number_of_nodes + 1];
        settled = new HashSet<Integer>();
        queue = new LinkedList<Integer>();
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];

    }

 

    public void dijkstra_algorithm(int adjacency_matrix[][], int source){

        int evaluationNode;

        for (int i = 1; i <= number_of_nodes; i++)
            for (int j = 1; j <= number_of_nodes; j++)
                adjacencyMatrix[i][j] = adjacency_matrix[i][j];

 

        for (int i = 1; i <= number_of_nodes; i++)

        {

            distances[i] = Integer.MAX_VALUE;

        }

 

        queue.add(source);
        distances[source] = 0;

 

        while (!queue.isEmpty()){

            evaluationNode = getNodeWithMinimumDistanceFromQueue();
            settled.add(evaluationNode);
            evaluateNeighbours(evaluationNode);

        }
    }

 

    private int getNodeWithMinimumDistanceFromQueue(){

        int min ;
        int node = 0;

        Iterator<Integer> iterator = queue.iterator();
        node = iterator.next();
        min = distances[node];


        for (int i = 1; i <= distances.length; i++)

        {

            if (queue.contains(i))

            {

                if (distances[i] <= min)

                {

                    min = distances[i];

                    node = i;			

                }

            }

        }

        queue.remove(node);

        return node;

    }

 

    private void evaluateNeighbours(int evaluationNode)

    {

        int edgeDistance = -1;

        int newDistance = -1;

 

        for (int destinationNode = 1; destinationNode <= number_of_nodes; destinationNode++)

        {

            if (!settled.contains(destinationNode))

            {

                if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE)

                {

                    edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];

                    newDistance = distances[evaluationNode] + edgeDistance;

                    if (newDistance < distances[destinationNode])

                    {

                        distances[destinationNode] = newDistance;

                    }

                    queue.add(destinationNode);

                }

            }

        }

    }

}

 public void mainDijk(){

        try

        {
            adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];

            for (int i = 1; i <= number_of_vertices; i++)

            {

                for (int j = 1; j <= number_of_vertices; j++)

                {

                    adjacency_matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Ingresa el PESO",""
         ,JOptionPane.INFORMATION_MESSAGE));

                    if (i == j)

                    {

                        adjacency_matrix[i][j] = 0;

                        continue;

                    }

                    if (adjacency_matrix[i][j] == 0)

                    {

                        adjacency_matrix[i][j] = Integer.MAX_VALUE;

                    }
                }
            }

            source = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Ingresa el ORIGEN",""
         ,JOptionPane.INFORMATION_MESSAGE));

            DijkstraQueue dijkstrasQueue = new DijkstraQueue(number_of_vertices);
            dijkstrasQueue.dijkstra_algorithm(adjacency_matrix, source);


           sal.append("El Camino mas CORTO ES: ");
       sal.append("\n" + "\n");

            for (int i = 1; i <= dijkstrasQueue.distances.length - 1; i++)

            {
       sal.append("\n" + "\n");

                 sal.append(source + " a " + i + " es" +"-->"+ dijkstrasQueue.distances[i]);
       sal.append("\n" + "\n");

            }

        } catch (InputMismatchException inputMismatch)

        {


        }
    }



  
@Override
public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
 
          number_of_vertices = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Numero de Vertices",""
         ,JOptionPane.INFORMATION_MESSAGE));
}

if(ev.getSource()==mostrar){
  mainDijk();
}

if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase