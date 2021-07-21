/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosordenamiento.Registros;

/**
 *
 * @author luis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class BurbReg extends JPanel implements ActionListener{

String res;
JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar, mostrar2,salir;

public BurbReg(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  BURBUJA CON REGISTROS    "));
sal.setEditable(false);


bot=new JPanel();
bot.setLayout(new GridLayout(2,0));
introducir=new JButton("Ingresar");
introducir.setBackground(Color.BLUE);
introducir.setForeground(Color.WHITE);
introducir.addActionListener(this);

mostrar=new JButton("Mostrar "
        + "Alumnos");
mostrar.setBackground(Color.BLUE);
mostrar.setForeground(Color.WHITE);
mostrar.addActionListener(this);

mostrar2=new JButton("Mostrar "
        + "Apellido");
mostrar2.setBackground(Color.BLUE);
mostrar2.setForeground(Color.WHITE);
mostrar2.addActionListener(this);

salir=new JButton("Salir");
salir.setBackground(Color.BLUE);
salir.setForeground(Color.WHITE);
salir.addActionListener(this);

bot.add(introducir);
bot.add(mostrar);
bot.add(mostrar2);
bot.add(salir);

add(sal,BorderLayout.CENTER);
add(bot,BorderLayout.EAST);

}

   String[]nombre;
   String[]apellido;
    

    public void leerDatos(){
         nombre=new String[5];
         for(int i=0;i<nombre.length;i++) {
		        
    nombre[i]=JOptionPane.showInputDialog(null,"Introduzca Nombre Alumno","",
            JOptionPane.INFORMATION_MESSAGE);
         }
         apellido=new String[5];
         for(int j=0;j<apellido.length;j++){
             
    apellido[j]=JOptionPane.showInputDialog(null,"Introduzca Apellido Alumno","",
            JOptionPane.INFORMATION_MESSAGE);       
         } 
     }

    
     public void ordenar() {
         for(int j=0;j<4;j++) {
             for(int i=0;i<4-j;i++) {
                 if (nombre[i].compareTo(nombre[i+1])>0) {
                     String aux;
                     aux=nombre[i];
                     nombre[i]=nombre[i+1];
                     nombre[i+1]=aux;
                 }
             }
         }
     }
  
   public void ordenarApe() {
         for(int j=0;j<4;j++) {
             for(int i=0;i<4-j;i++) {
                 if (apellido[i].compareTo(apellido[i+1])>0) {
                     String aux;
                     aux=apellido[i];
                     apellido[i]=apellido[i+1];
                     apellido[i+1]=aux;
                 }
             }
         }
     }
     
   
     
    
@Override
public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
leerDatos();
}

if(ev.getSource()==mostrar){

int i;	

sal.append("ALUMNOS:" + "\n");

for( i=0;i<nombre.length;i++){
sal.append(" " + nombre[i] + "\n"
         +apellido[i] + " " ) ;
}

sal.append("\n" + "\n");


sal.append("ALUMNOS ANTES DE ORDENAR:" + "\n");

for( i=0;i<nombre.length;i++){
sal.append(" " + nombre[i] + "  " + " " ) ;
}
sal.append("\n" + "\n");

sal.append("ALUMNOS DESPUES DE ORDENAR:" + "\n");

ordenar();
for( i=0;i<nombre.length;i++){
sal.append(" " + nombre[i] + "  " + " " ) ;
}

sal.append("\n" + "\n");
sal.append(" ");


}

if(ev.getSource()==mostrar2){

int i;	
sal.append("APELLIDOS ANTES DE ORDENAR:" + "\n");

for( i=0;i<apellido.length;i++){
sal.append(" " + apellido[i] + "  " + " " ) ;
}
sal.append("\n" + "\n");

sal.append("APELLIDOS DESPUES DE ORDENAR:" + "\n");

    ordenarApe();
for( i=0;i<apellido.length;i++){
sal.append(" " + apellido[i] + "  " + " " ) ;
}

sal.append("\n" + "\n");

sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");

}

if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}//fin clase