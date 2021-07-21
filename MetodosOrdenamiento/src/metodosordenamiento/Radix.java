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


public class Radix extends JPanel implements ActionListener {

private static int q[],ql[];
int[] arr;
int n;
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir;


public Radix(){
setLayout(new BorderLayout());	
n=35;	
arr=new int[n];	
interfaz();
	
}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("     ORDENAMIENTO RADIX-SORT     "));
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

static{
q = new int[256];
ql = new int[256];
for(int i=0;i<q.length;q[i++] = -1);
}

public static void radixSort(int[] arr){
int i,j,k,l,np[][] = new int[arr.length][2];
for(k=0;k<2;k++){
for(i=0;i<arr.length;np[i][0]=arr[i],np[i++][1]=-1)
if(q[j=((255<<(k<<3))&arr[i])>>(k<<3)]==-1)
ql[j] = q[j] = i;
else
ql[j] = np[ql[j]][1] = i;
for(l=q[i=j=0];i<q.length;q[i++]=-1)
for(l=q[i];l!=-1;l=np[l][1])
arr[j++] = np[l][0];
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
for (int i=0;i < arr.length;i++){  
System.out.print(arr[i]+" ");
sal.append(" " + arr[i] + " " + " " );
}	

sal.append("\n"+"\n");

sal.append("DESPUES DE ORDENAR:" + "\n");
radixSort(arr);
for (int i=0;i < arr.length;i++){  
System.out.print(arr[i]+" ");
sal.append(" " + arr[i] + " " + " " );
}
sal.append("\n" + "\n");

sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR INVERTIDO:" + "\n");
radixSort(arr);
int i;
for( i=arr.length-1;i>=0;i--){
sal.append(" " + arr[i] + "  " + " " ) ;
}


sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append(" ");
sal.append(" ");


long t1 = System.nanoTime();
radixSort(arr);
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