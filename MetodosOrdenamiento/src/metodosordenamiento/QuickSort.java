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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuickSort extends JPanel implements ActionListener{

int n;
int arrNumeros[ ];
int arrNumerosOrdenados[ ];
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir;

public QuickSort(){
setLayout(new BorderLayout());	
n=35;	
arrNumeros=new int[n];
interfaz(); 
}//fin constructor.	


public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("     ORDENAMIENTO QUICK-SORT     "));
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
for(int i=0;i<arrNumeros.length;i++){
arrNumeros[i] = (int) (Math.random()*80)+1; 
  	
}

}



public int[] quicksort(int[] a, int izq,int der){
int i=izq;
int j = der;
int centro = a[(izq+der)/2];
do{

while(a[i] < centro){
i++;
}
while(a[j] > centro){
j--;
}
if (i <= j){
int aux = a[i];
a[i] = a[j];
a[j] = aux;
i++;
j--;
}
}while (i <= j);
if(izq < j){
quicksort(a,izq,j);
}
if(i < der){
quicksort(a,i,der);
}
return a;
}


public void actionPerformed(ActionEvent ev) {
if(ev.getSource()==introducir){
sal.setText( " " );
vector();

}

if(ev.getSource()==mostrar){
	
sal.append("ANTES DE ORDENAR:" + "\n");
for(int i=0;i<arrNumeros.length;i++){
sal.append(" " + arrNumeros[i] + "  " + " " ) ;
}
sal.append("\n"+"\n");
sal.append("DESPUES DE ORDENAR:" + "\n");

int arrNumerosOrdenados[ ]=quicksort(arrNumeros,0,arrNumeros.length-1);
for(int i=0;i<arrNumerosOrdenados.length;i++){
sal.append(" " + arrNumerosOrdenados[i] + " " + " " );
}
sal.append("\n" + "\n");

sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR INVERTIDO:" + "\n");
quicksort(arrNumeros,0,arrNumeros.length-1);
int i;
for( i=arrNumerosOrdenados.length-1;i>=0;i--){
sal.append(" " + arrNumerosOrdenados[i] + "  " + " " ) ;
}


sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append(" ");
sal.append(" ");
long t1 = System.nanoTime();
quicksort(arrNumeros,0,arrNumeros.length-1);
long t2 = System.nanoTime();
sal.append("EL TIEMPO EN ORDENAR ES:" + "\n");
double time = (double )((t1-t2));
sal.append("" + time + "  nanosegundos" );

}	

if(ev.getSource()==salir){
System.exit(0);

}


}//fin actionPerformed


}//fin clase quicksort