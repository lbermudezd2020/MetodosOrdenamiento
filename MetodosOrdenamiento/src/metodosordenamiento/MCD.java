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



public class MCD extends JPanel implements ActionListener{
public static BufferedReader ent = new BufferedReader(new InputStreamReader(System.in));

int aux,n,n2;
int tabla[];
String res;
JTextArea sal;
JPanel bot;
JButton introducir,mostrar, grafica,salir;

public MCD(){
setLayout(new BorderLayout());	   
interfaz1();
}


public void interfaz1(){
//antes aqui iva el setLayout()	
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder(" MCD "));
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


  
 static int mcm(int a, int b){
        int multiplo;
        if (a>b)
            multiplo=a;
        else
            multiplo=b;
        
        while (multiplo%a!=0 || multiplo%b!=0)
            multiplo++;      
        return multiplo;
    }
 
static int mcdRecu(int a, int b){
    if(a<b)
    return a;
    else if(b==0)
        return a;
    else
        return mcdRecu(b, a % b);
    
}



public void actionPerformed(ActionEvent ev){
    
if(ev.getSource()==introducir){
sal.setText( " " );
try{
n=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce primer numero","MCD"
,JOptionPane.INFORMATION_MESSAGE));
n2=Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce segundo numero","MCD"
,JOptionPane.INFORMATION_MESSAGE));
}catch(Exception e){
JOptionPane.showMessageDialog(null,"introduce un valor numerico"
,"Error",JOptionPane.ERROR_MESSAGE);	
}
}


if(ev.getSource()==mostrar){

sal.append("\n" + "\n");
sal.append("ITERATIVO:" + "\n");

sal.append("Resultado(" + n +")("+ n2 +") =" + mcm(n,n2)) ;

sal.append("\n" + "\n");
sal.append("RECURSIVO:" + "\n");

sal.append(("Resultado(" + n +")("+ n2 +") =" + mcdRecu(n,n2)));

}


if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase

