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


public class Selection extends JPanel implements ActionListener {
 
int n;
static int arrayEntrada[];
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir;

public Selection(){
setLayout(new BorderLayout());	
n=35;	
arrayEntrada=new int[n];	

interfaz();
}//fin constructor


public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("     ORDENAMIENTO SELECTION-SORT    "));
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
	
}// fin interfaz();

public void vector(){
for(int i=0;i<arrayEntrada.length;i++){

arrayEntrada[i] = (int) (Math.random()*80)+1; 
  	
}

}


public static void SelectionSort( int n[]){
    
    
    int n1 = 0;
    int n2 = 0;
     for( int i = 0; i < n.length-1; i++ ) {
            int menor = n[i];
            int pos = i;

            for( int j = i + 1; j < n.length; j++ ) {
                if( n[j] < menor ) {
                    menor = n[j];
                    pos = j;
                    n1++;
                }
            }
            n[pos] = n[i];
            n[i] = menor;
            n2++;
        }
    
   }
    



public void actionPerformed(ActionEvent ev) {
if(ev.getSource()==introducir){
sal.setText( " " );
vector();

System.out.println("fase 1");
}

if(ev.getSource()==mostrar){
sal.append("ANTES DE ORDENAR:" + "\n");
for (int i=0;i < arrayEntrada.length;i++){  
sal.append(" " + arrayEntrada[i] + " " + " " );
}	
sal.append("\n"+"\n");

sal.append("DESPUES DE ORDENAR:" + "\n");
SelectionSort(arrayEntrada);
for (int i=0;i <arrayEntrada.length;i++){  
System.out.print(arrayEntrada[i]+" ");
sal.append(" " + arrayEntrada[i] + " " + " " );
}	
sal.append("\n" + "\n");

sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR INVERTIDO:" + "\n");
SelectionSort(arrayEntrada);
int i;
for( i=arrayEntrada.length-1;i>=0;i--){
sal.append(" " + arrayEntrada[i] + "  " + " " ) ;
}


sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append(" ");
sal.append(" ");


long t1 = System.nanoTime();
SelectionSort(arrayEntrada);
long t2 = System.nanoTime();
sal.append("EL TIEMPO EN ORDENAR ES:" + "\n");
double time = (double )((t1-t2));
sal.append("" + time + "  nanosegundos" );
}	
	

if(ev.getSource()==salir){
System.exit(0);

}
}//fin actionPerformed

}//fin c