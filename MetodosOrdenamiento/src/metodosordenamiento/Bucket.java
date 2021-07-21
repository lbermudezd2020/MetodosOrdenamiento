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
import javax.swing.*;


public class Bucket extends JPanel implements ActionListener{

 
int n;
int array[];
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,grafica,salir;


public Bucket(){
setLayout(new BorderLayout());	
n=20;	
array=new int[n];	

interfaz();	
}


public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("     ORDENAMIENTO BUCKET-SORT     "));
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
   
array[i] = (int) (Math.random()*60)+1; 
  	
}

}

    static int[] sort(int[] sequence, int maxValue) 

    {


        int[] Bucket = new int[maxValue + 1];

        int[] sorted_sequence = new int[sequence.length];

 

        for (int i = 0; i < sequence.length; i++)

            Bucket[sequence[i]]++;

 

        int outPos = 0;

        for (int i = 0; i < Bucket.length; i++)

            for (int j = 0; j < Bucket[i]; j++)

                sorted_sequence[outPos++] = i;

 

        return sorted_sequence;

    }

 

    static int printSequence(int[] sorted_sequence) 

    {

        for (int i = 0; i < sorted_sequence.length; i++)

            System.out.print(sorted_sequence[i] + " ");
    return 0;

    }

 

    static int maxValue(int[] sequence) 

    {

        int maxValue = 0;

        for (int i = 0; i < sequence.length; i++)

            if (sequence[i] > maxValue)

                maxValue = sequence[i];

        return maxValue;

    }

 
    
public void actionPerformed(ActionEvent ev) {
if(ev.getSource()==introducir){
sal.setText( " " );
vector();

System.out.println("fase 1");
}

if(ev.getSource()==mostrar){
sal.append("ANTES DE ORDENAR:"  + "\n");
for (int i=0;i < array.length;i++){  
System.out.print(array[i]+" ");
sal.append(" " + array[i] + " " + " " );
}
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR:" + "\n");
         int N = 20;

        int[] sequence = new int[N];

        for (int i = 0; i < N; i++)

            sequence[i] = (int) ((Math.random()*40)+1); 

        int maxValue = maxValue(sequence);

 printSequence(sort(sequence, maxValue));



sal.append("\n" + "\n");

long t1 = System.nanoTime();

 printSequence(sort(array, n));


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