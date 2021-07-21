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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class Kruskal extends JPanel implements ActionListener{

JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar,salir;
int adjacency_matrix[][];
int number_of_vertices;
public int adjacencyMatrix[][];
    public static final int MAX_VALUE = 999;



public Kruskal(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder(" KRUSKAL "));
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

 

public class KruskalAlgorithm{

    private LinkedList<Edge> edges;
    private int numberOfVertices;
    private int visited[];
    private int spanning_tree[][];


    public KruskalAlgorithm(int numberOfVertices){

        this.numberOfVertices = numberOfVertices;
        edges = new LinkedList<Edge>();
        visited = new int[this.numberOfVertices + 1];
        spanning_tree = new int[numberOfVertices + 1][numberOfVertices + 1];

    }


    public void kruskalAlgorithm(int adjacencyMatrix[][]){

        boolean finished = false;
        for (int source = 1; source <= numberOfVertices; source++){
            for (int destination = 1; destination <= numberOfVertices; destination++){
                if (adjacencyMatrix[source][destination] != MAX_VALUE && source != destination){
                    Edge edge = new Edge();
                    edge.sourcevertex = source;
                    edge.destinationvertex = destination;
                    edge.weight = adjacencyMatrix[source][destination];
                    adjacencyMatrix[destination][source] = MAX_VALUE;
                    edges.add(edge);
                }
            }
        }

        Collections.sort(edges, new EdgeComparator());
        CheckCycle checkCycle = new CheckCycle();
        for (Edge edge : edges){
            spanning_tree[edge.sourcevertex][edge.destinationvertex] = edge.weight;
            spanning_tree[edge.destinationvertex][edge.sourcevertex] = edge.weight;
            if (checkCycle.checkCycle(spanning_tree, edge.sourcevertex)){

                spanning_tree[edge.sourcevertex][edge.destinationvertex] = 0;
                spanning_tree[edge.destinationvertex][edge.sourcevertex] = 0;
                edge.weight = -1;
                continue;
            }

            visited[edge.sourcevertex] = 1;
            visited[edge.destinationvertex] = 1;
            for (int i = 0; i < visited.length; i++){

                if (visited[i] == 0){
                    finished = false;
                    break;
                } else

                {

                    finished = true;

                }

            }

            if (finished)
                break;
        }

      sal.append("El Arbol es:  ");
       sal.append("\n" + "\n");

        for (int i = 1; i <= numberOfVertices; i++)

           sal.append("\t" + i);
        for (int source = 1; source <= numberOfVertices; source++){
       sal.append("\n" + "\n");

            sal.append(source + "\t");
                   sal.append("\n" + "\n");

            for (int destination = 1; destination <= numberOfVertices; destination++){
                
                sal.append(spanning_tree[source][destination] + "\t");
            }

       sal.append("\n" + "\n");
        }
    }
}

 

class Edge{

    int sourcevertex;
    int destinationvertex;
    int weight;
}

 

class EdgeComparator implements Comparator<Edge>{

    @Override
    public int compare(Edge edge1, Edge edge2){
        if (edge1.weight < edge2.weight)
            return -1;
        if (edge1.weight > edge2.weight)
            return 1;
        return 0;
    }
}

 

class CheckCycle{
    private Stack<Integer> stack;
    public int adjacencyMatrix[][];
    
    public CheckCycle(){
        stack = new Stack<Integer>();
    }


    public boolean checkCycle(int adjacency_matrix[][], int source){
        boolean cyclepresent = false;
        int number_of_nodes = adjacency_matrix[source].length - 1;
        adjacencyMatrix = new int[number_of_nodes + 1][number_of_nodes + 1];
       
         int visited[] = new int[number_of_nodes + 1];
         int element = source;
         int i = source;
         visited[source] = 1;
         stack.push(source);

         while (!stack.isEmpty()){

             element = stack.peek();
             i = element;
             while (i <= number_of_nodes){
                 if (adjacencyMatrix[element][i] >= 1 && visited[i] == 1){
                     if (stack.contains(i)){
                         cyclepresent = true;
                         return cyclepresent;
                     }
                 }

                 if (adjacencyMatrix[element][i] >= 1 && visited[i] == 0){

                     stack.push(i);
                     visited[i] = 1;
                     adjacencyMatrix[element][i] = 0;
                     adjacencyMatrix[i][element] = 0;
                     element = i;
                     i = 1;
                     continue;
                  }

                  i++;

             }

             stack.pop();
        }
        return cyclepresent;
    }

}



 public void mainKrus(){ 
 
        adjacency_matrix = new int[number_of_vertices + 1][number_of_vertices + 1];

        for (int i = 1; i <= number_of_vertices; i++){
            for (int j = 1; j <= number_of_vertices; j++){
                adjacency_matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Ingresa el peso",""
         ,JOptionPane.INFORMATION_MESSAGE));
 
                if (i == j){
                    adjacency_matrix[i][j] = 0;
                    continue;
                }

                if (adjacency_matrix[i][j] == 0){
                    adjacency_matrix[i][j] = MAX_VALUE;
                }
            }
        }

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(number_of_vertices);
        kruskalAlgorithm.kruskalAlgorithm(adjacency_matrix);

    }
    
@Override
public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
    number_of_vertices = Integer.parseInt(JOptionPane.showInputDialog
        (null,"Numero de Vertices",""
         ,JOptionPane.INFORMATION_MESSAGE));
}

if(ev.getSource()==mostrar){
  mainKrus();
}

if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase