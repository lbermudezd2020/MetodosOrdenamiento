/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosordenamiento;

/**
 *
 * @author luis
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import javax.swing.*;
import java.util.Random;

public class Heap extends JPanel implements ActionListener{

int[] arr;
int array[];
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir,grafica;


public Heap(){
setLayout(new BorderLayout());	
n=40;	
array=new int[n];	
interfaz();	
}



public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("     ORDENAMIENTO HEAP-SORT     "));
sal.setEditable(false);

bot=new JPanel();
bot.setLayout(new GridLayout(2,0));
introducir=new JButton("Introducir");
introducir.setBackground(Color.BLUE);
introducir.setForeground(Color.WHITE);
introducir.addActionListener(this);

mostrar=new JButton("Mostrar");
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



public void vector(){
for(int i=0;i<array.length;i++){
   
array[i] = (int) (Math.random()*40)+1; 
  	
}

}
   
    private static int[] a;

    private static int n;

    private static int   left;

    private static int   right;

    private static int   largest;

 

    public void buildheap(int[] a)

    {


        for (int i = n / 2; i >= 0; i--)

        {

            maxheap(a, i);

        }

    }

 

    public void maxheap(int[] a, int i)

    {

        left = 2 * i;

        right = 2 * i + 1;

        if (left <= n && a[left] > a[i])

        {

            largest = left;

        } else

        {

            largest = i;

        }

 

        if (right <= n && a[right] > a[largest])

        {

            largest = right;

        }

        if (largest != i)

        {

            exchange(i, largest);

            maxheap(a, largest);

        }

    }

 

    public static void exchange(int i, int j)

    {

        int t = a[i];

        a[i] = a[j];

        a[j] = t;

    }

 

    public void sort(int[] a0)

    {

        a = a0;

        buildheap(a);

 

        for (int i = n; i > 0; i--)

        {

            exchange(0, i);

            n = n - 1;

            maxheap(a, 0);

        }

    }




public void actionPerformed(ActionEvent ev) {
if(ev.getSource()==introducir){
sal.setText( " " );
vector();
}

if(ev.getSource()==mostrar){
sal.append("ANTES DE ORDENAR:"  + "\n");
for (int i=0;i < array.length;i++){  
//System.out.print(array[i]+" ");
sal.append(" " + array[i] + " " + " " );
}
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR:" + "\n");

       

        int N = 60;
        int[] sequence = new int[N];
        
         for (int i = 0; i < N; i++)

            sequence[i] = (int) ((Math.random()*40)+1); 

                sort(sequence); 

for (int i=0;i < sequence.length;i++){  
sal.append(" " + sequence[i] + " " + " " );
                            System.out.print(sequence[i] + " ");

}
sal.append("\n" + "\n");

sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR INVERTIDO:" + "\n");
                sort(sequence); 
int i;
for( i=sequence.length-1;i>=0;i--){
sal.append(" " + sequence[i] + "  " + " " ) ;
                            System.out.print(sequence[i] + " ");

}


sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append(" ");
sal.append(" ");
long t1 = System.nanoTime();
        sort(sequence);        
long t2 = System.nanoTime();
sal.append("EL TIEMPO EN ORDENAR ES:" + "\n");
double time = (double )((t1-t2));
sal.append("" + time + "  nanosegundos" );
}	


if(ev.getSource()==salir){
System.exit(0);

}	
	
}//fin actionPerformed


}// fin clase