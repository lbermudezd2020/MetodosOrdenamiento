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


public class Burbuja extends JPanel implements ActionListener{

int aux,n;
int tabla[];
int tabla2[];
String res;
JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar, grafica,salir;


public Burbuja(){
setLayout(new BorderLayout());	   
n=35;
tabla = new int[n];
aux=0;
interfaz();

}

public void interfaz(){
//antes aqui iva el setLayout()	
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  METODO DE ORDENAMIENTO BURBUJA    "));
sal.setEditable(false);


bot=new JPanel();
bot.setLayout(new GridLayout(2,0));


introducir=new JButton("Iniciar");
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
	
for(int i=0;i<tabla.length;i++){
   
tabla[i] = (int) (Math.random()*80)+1; 
  	
}

}



public void burbuja(){
    
for(int i=0;i<tabla.length-1;i++){	

for(int j=i+1;j<tabla.length;j++){

if (tabla[i]>tabla[j]){	
    
aux=tabla[j];
tabla[j]=tabla[i];
tabla[i]=aux;
}
}
}
}


public void actionPerformed(ActionEvent ev){
    
    
if(ev.getSource()==introducir){
sal.setText( " " );
vector();
}

if(ev.getSource()==mostrar){
int i;	
sal.append("ANTES DE ORDENAR:" + "\n");

for( i=0;i<tabla.length;i++){
sal.append(" " + tabla[i] + "  " + " " ) ;
}
sal.append("\n" + "\n");

sal.append("DESPUES DE ORDENAR:" + "\n");
burbuja();

for( i=0;i<tabla.length;i++){
sal.append(" " + tabla[i] + "  " + " " ) ;
}

sal.append("\n" + "\n");

sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");
sal.append("DESPUES DE ORDENAR INVERTIDO:" + "\n");
burbuja();

for( i=tabla.length-1;i>=0;i--){
sal.append(" " + tabla[i] + "  " + " " ) ;
}


sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append(" ");
sal.append(" ");
long t1 = System.nanoTime();
burbuja();
long t2 = System.nanoTime();
sal.append("EL TIEMPO EN ORDENAR ES:" + "\n");
double time = (double )((t1-t2));
sal.append("" + time + "  Nanosegundos" );

}

if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase