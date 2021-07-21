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


public class fibonacci extends JPanel implements ActionListener{
public static BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));

int aux,n;
int tabla[];
String res;
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir;

public fibonacci(){
setLayout(new BorderLayout());	   
interfaz1();
}



public void interfaz1(){
//antes aqui iva el setLayout()	
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder(" FIBONACCI "));
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


 public static int FibonacciIterativo(int n, int arr[]){
         for(int i = 0; i < n; i++)
            if(i < 2)
               arr[i] = 1;
            else
               arr[i] = arr[i-1] + arr[i-2];
         return arr[n-1];
      }
       public static int FibonacciRecursivo(int n){
         if(n < 2)
            return 1;
         else
            return FibonacciRecursivo(n-1) + FibonacciRecursivo(n-2);
      }




public void actionPerformed(ActionEvent ev){
  
    
    
if(ev.getSource()==introducir){
sal.setText( " " );

try{
n=Integer.parseInt
(JOptionPane.showInputDialog(null,"introduce un numero","Fibonacci"
,JOptionPane.INFORMATION_MESSAGE));	
}catch(Exception e){
JOptionPane.showMessageDialog(null,"introduce un valor numerico"
,"Error",JOptionPane.ERROR_MESSAGE);	
}
}

    
if(ev.getSource()==mostrar){

int arr[] = new int [n];
sal.append("\n" + "\n");
sal.append("ITERATIVO:" + "\n");
sal.append("Resultado(" + n + ")=" + FibonacciIterativo(n, arr)) ;

sal.append("\n" + "\n");
sal.append("RECURSIVO:" + "\n");
sal.append(("Resultado(" + n + ")=" + FibonacciRecursivo(n-1)));

}


if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase