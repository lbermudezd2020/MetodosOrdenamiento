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


public class QuickReg extends JPanel implements ActionListener{

String res;
JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar, mostrar2,salir;


public QuickReg(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
//antes aqui iva el setLayout()	
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  QUICK-SORT CON REGISTROS    "));
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
     int length;

    public void leerDatos() {
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

    
     void sort(String array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        this.nombre = array;
        this.length = array.length;
        quickSort(0, length - 1);
    }
    
    
void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.nombre[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (this.nombre[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.nombre[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    } 
    
void exchangeNames(int i, int j) {
        String temp = this.nombre[i];
        this.nombre[i] = this.nombre[j];
        this.nombre[j] = temp;
    }

  
void sort2(String array[]) {
        if (array == null || array.length == 0) {
            return;
        }
        this.apellido = array;
        this.length = array.length;
        quickSort(0, length - 1);
    }
    
    
void quickSort2(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        String pivot = this.apellido[lowerIndex + (higherIndex - lowerIndex) / 2];

        while (i <= j) {
            while (this.apellido[i].compareToIgnoreCase(pivot) < 0) {
                i++;
            }

            while (this.apellido[j].compareToIgnoreCase(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchangeNames2(i, j);
                i++;
                j--;
            }
        }
        if (lowerIndex < j) {
            quickSort(lowerIndex, j);
        }
        if (i < higherIndex) {
            quickSort(i, higherIndex);
        }
    } 
    
void exchangeNames2(int i, int j) {
        String temp = this.apellido[i];
        this.apellido[i] = this.apellido[j];
        this.apellido[j] = temp;
    }



public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
leerDatos();
}

if(ev.getSource()==mostrar){

int i;	

sal.append("ALUMNOS:" + "\n");

for( i=0;i<nombre.length;i++){
sal.append(" " + nombre[i] + "\n"
        + "\n" +apellido[i] + " " ) ;
}

sal.append("\n" + "\n");


sal.append("ALUMNOS ANTES DE ORDENAR:" + "\n");

for( i=0;i<nombre.length;i++){
sal.append(" " + nombre[i] + "  " + " " ) ;
}
sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append("\n" + "\n");

sal.append("ALUMNOS DESPUES DE ORDENAR:" + "\n");

sort(nombre);
for( i=0;i<nombre.length;i++){
sal.append(" " + nombre[i] + "  " + " " ) ;
}

sal.append("\n" + "\n");
sal.append(" ");


}
sal.append(" ");
sal.append(" ");
sal.append("\n" + "\n");

if(ev.getSource()==mostrar2){

int i;	
sal.append("APELLIDOS ANTES DE ORDENAR:" + "\n");

for( i=0;i<apellido.length;i++){
sal.append(" " + apellido[i] + "  " + " " ) ;
}

sal.append("\n" + "\n");
sal.append("\n" + "\n");
sal.append("\n" + "\n");

sal.append("APELLIDOS DESPUES DE ORDENAR:" + "\n");
sort2(apellido);
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