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

public class SumaDigNum extends JPanel implements ActionListener{
public static BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));

int aux,n;
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir;

public SumaDigNum(){
setLayout(new BorderLayout());	   
interfaz1();
}


public void interfaz1(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder(" SUMA DIGITOS DE UN NUMERO "));
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

public int sumar_dig(int n){
    int suma=0; 
	    while(n!=0){ 
	    	suma=suma+(n%10);
	    	n=n/10;
	    }
     
    return suma;       
}


 public int sumar_digRECU (int n){
	if (n == 0)      //caso base
	    return n;
	else
	    return sumar_digRECU (n / 10) + (n % 10);
    }
       


@Override
public void actionPerformed(ActionEvent ev){
    
if(ev.getSource()==introducir){
try{
n=Integer.parseInt
(JOptionPane.showInputDialog(null,"introduce un numero","SUMA DIGITOS"
,JOptionPane.INFORMATION_MESSAGE));	
}catch(Exception e){
JOptionPane.showMessageDialog(null,"introduce un valor numerico"
,"Error",JOptionPane.ERROR_MESSAGE);	
}
}

    
if(ev.getSource()==mostrar){

sal.append("\n" + "\n");
sal.append("ITERATIVO:" + "\n");

sal.append("Resultado(" + n + ")=" + sumar_dig(n)) ;

sal.append("\n" + "\n");
sal.append("RECURSIVO:" + "\n");

sal.append(("Resultado(" + n + ")=" + sumar_digRECU(n)));

}


if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase
