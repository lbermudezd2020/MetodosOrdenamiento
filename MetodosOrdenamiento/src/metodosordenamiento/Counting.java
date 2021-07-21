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
import javax.swing.*;


public class Counting extends JPanel implements ActionListener {
 
private static int q[],ql[];
int[] arr;
int max;
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir;


public Counting(){
setLayout(new BorderLayout());	
max=35;	
arr=new int[max];	
interfaz();
	
}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("     ORDENAMIENTO COUNTING-SORT     "));
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
		
}//fin interfaz();

public void vector(){
for(int i=0;i<arr.length;i++){
arr[i] = (int) (Math.random()*80)+1; 
  	
}

}


    public static void sort( int[] arr )

    {

        int N = arr.length;

        if (N == 0)

            return;

        /** find max and min values **/

        int max = arr[0], min = arr[0];

        for (int i = 1; i < N; i++)

        {

            if (arr[i] > max)

                max = arr[i];

            if (arr[i] < min)

                min = arr[i];

        }

        int range = max - min + 1;

 

        int[] count = new int[range];

        /** make count/frequency array for each element **/

        for (int i = 0; i < N; i++)

            count[arr[i] - min]++;

        /** modify count so that positions in final array is obtained **/

        for (int i = 1; i < range; i++)

            count[i] += count[i - 1];

        /** modify original array **/

        int j = 0;

        for (int i = 0; i < range; i++)

            while (j < count[i])

                arr[j++] = i + min;

    }    

	
public void actionPerformed(ActionEvent ev) {
if(ev.getSource()==introducir){
sal.setText( " " );
vector();

System.out.println("fase 1");
}
if(ev.getSource()==mostrar){
sal.append("ANTES DE ORDENAR:" + "\n");
for (int i=0;i < arr.length;i++){  
System.out.print(arr[i]+" ");
sal.append(" " + arr[i] + " " + " " );
}	

sal.append("\n"+"\n");
sal.append("DESPUES DE ORDENAR:" + "\n");
sort(arr);
for (int i=0;i < arr.length;i++){  
  sal.append(" " + arr[i] + " " + " " );

}
sal.append("\n" + "\n");

sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR INVERTIDO:" + "\n");
sort(arr);
int i;
for( i=arr.length-1;i>=0;i--){
sal.append(" " + arr[i] + "  " + " " ) ;
}


sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append(" ");
sal.append(" ");
long t1 = System.nanoTime();
sort(arr);
long t2 = System.nanoTime();
sal.append("EL TIEMPO EN ORDENAR ES:" + "\n");
double time = (double )((t1-t2));
sal.append("" + time + "  nanosegundos" );
}	


if(ev.getSource()==salir){
System.exit(0);

}
}// fin actionPerformed

}//fin clase