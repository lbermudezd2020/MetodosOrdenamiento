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

public class Merge extends JPanel implements ActionListener{

 
int n;
int array[];
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir,grafica;


public Merge(){
setLayout(new BorderLayout());	
n=35;	
array=new int[n];	
interfaz();	
}



public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("     ORDENAMIENTO MERGE-SORT     "));
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
   
array[i] = (int) (Math.random()*80)+1; 
  	
}

}




public static void mergeSort(int array[],int lo, int n){
int low = lo;
int high = n;
if (low >= high) {
return;
}

int middle = (low + high) / 2;
mergeSort(array, low, middle);
mergeSort(array, middle + 1, high);

int end_low = middle;
int start_high = middle + 1;
while ((lo <= end_low) && (start_high <= high)) {
if (array[low] < array[start_high]) {
low++;
} else {
int Temp = array[start_high];
for (int k = start_high- 1; k >= low; k--) {
array[k+1] = array[k];
}
array[low] = Temp;
low++;
end_low++;
start_high++;
}
}
}//fin mergeSort(); 



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
mergeSort(array,0, array.length-1);
for (int i=0;i < array.length;i++){  
//System.out.print(array[i]+" ");
sal.append(" " + array[i] + " " + " " );

}
sal.append("\n" + "\n");

sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR INVERTIDO:" + "\n");
mergeSort(array,0, array.length-1);
int i;
for( i=array.length-1;i>=0;i--){
sal.append(" " + array[i] + "  " + " " ) ;
}


sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append(" ");
sal.append(" ");



long t1 = System.nanoTime();
mergeSort(array,0, array.length-1);
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