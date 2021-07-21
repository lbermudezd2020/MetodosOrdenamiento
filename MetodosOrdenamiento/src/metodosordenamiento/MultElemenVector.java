/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosordenamiento;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author luis
 */

public class MultElemenVector extends JPanel implements ActionListener{
public static BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));

int arr[], num;
int numero;
int i;

JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir;

public MultElemenVector(){
setLayout(new BorderLayout());	   
interfaz1();
}


public void interfaz1(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder(" MULTIPLICA ELEMENTOS DE UN VECTOR "));
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


 public int multiplicarRecur (int vec [], int tam)
    {
	if (tam == 0)
	    return (vec [0]);
	return (vec [tam] * multiplicarRecur (vec, tam - 1));
    }
       



public void actionPerformed(ActionEvent ev){
    
if(ev.getSource()==introducir){
    sal.setText( " " );

try{
       
 
num = Integer.parseInt
(JOptionPane.showInputDialog(null,"introduce tamaño","MultVector"
,JOptionPane.INFORMATION_MESSAGE)); 
arr = new int[num];

String dato;


for( int i = 0; i < arr.length; i ++ )
{
// Leer datos del usuario, el dato ingresado se almacena en un String
dato = JOptionPane.showInputDialog( "Ingrese dato Nro "+ ( i + 1 ) );
// Convertimos el dato ingresado en un int
numero = Integer.parseInt( dato );
// Guardamos el dato ingresado en el vector
arr[ i ] = numero;
}    
}catch(Exception e){
JOptionPane.showMessageDialog(null,"introduce un valor numerico"
,"Error",JOptionPane.ERROR_MESSAGE);	
}
}

    
if(ev.getSource()==mostrar){
    
sal.append("\n" + "\n");
sal.append("ITERATIVO:" + "\n");

sal.append("Resultado(" + num + " " +  "  )=" + multiplicarRecur(arr, numero)) ;


sal.append("\n" + "\n");
sal.append("RECURSIVO:" + "\n");
sal.append("Resultado(" + num + ") =" + multiplicarRecur(arr, numero) );

}


if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase