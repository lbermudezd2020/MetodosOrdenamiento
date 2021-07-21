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

public class Factorial extends JPanel implements ActionListener{
public static BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));

int aux,n;
JTextArea sal;
JPanel bot;
JButton introducir,mostrar,salir;

public Factorial(){
setLayout(new BorderLayout());	   
interfaz1();
}


public void interfaz1(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder(" FACTORIAL "));
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


  public int factorial(int n){
    int fact=1;
    int i;
    if (n==0)
        fact=1;
    else
        for(i=1;i<=n;i++)
            fact=fact*i;
 return fact;
}
   public int factorialrecursivo(int n){
    if (n==0)
        return 1;
    else
        return n*(factorial(n-1));
}
       


public void actionPerformed(ActionEvent ev){
    
if(ev.getSource()==introducir){
try{
n=Integer.parseInt
(JOptionPane.showInputDialog(null,"introduce un numero","Factorial"
,JOptionPane.INFORMATION_MESSAGE));	
}catch(Exception e){
JOptionPane.showMessageDialog(null,"introduce un valor numerico"
,"Error",JOptionPane.ERROR_MESSAGE);	
}
}

    
if(ev.getSource()==mostrar){

sal.append("\n" + "\n");
sal.append("ITERATIVO:" + "\n");

sal.append("Resultado(" + n + ")=" + factorial(n)) ;

sal.append("\n" + "\n");
sal.append("RECURSIVO:" + "\n");

sal.append(("Resultado(" + n + ")=" + factorialrecursivo(n)));

}


if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase
