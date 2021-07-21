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


public class MergeReg extends JPanel implements ActionListener{

    

String res;
JTextArea sal;
JPanel bot,gra;
JButton introducir,mostrar, mostrar2,salir;


public MergeReg(){
setLayout(new BorderLayout());	   
interfaz();

}

public void interfaz(){
//antes aqui iva el setLayout()	
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  MERGE-SORT CON REGISTROS    "));
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
         nombre=new String[2];
         for(int i=0;i<nombre.length;i++) {
		        
    nombre[i]=JOptionPane.showInputDialog(null,"Introduzca Nombre Alumno","",
            JOptionPane.INFORMATION_MESSAGE);
         }
         apellido=new String[2];
         for(int j=0;j<apellido.length;j++){
             
    apellido[j]=JOptionPane.showInputDialog(null,"Introduzca Apellido Alumno","",
            JOptionPane.INFORMATION_MESSAGE);       
         }
    
    
         
     }


    public static String[] mergeSort(String[] list) {
        String [] sorted = new String[list.length];
        if (list.length == 1) {
            sorted = list;
        } else {
            int mid = list.length/2;
            String[] left = null; 
            String[] right = null;
            if ((list.length % 2) == 0) {
                left = new String[list.length/2];
                right = new String[list.length/2];
            } else { 
                left = new String[list.length/2];
                right = new String[(list.length/2)+1];
            }
            int x=0;
            int y=0;
            for ( ; x < mid; x++) {
                left[x] = list[x];
            }
            for ( ; x < list.length; x++) {
                right[y++] = list[x];
            }
            left = mergeSort(left);
            right = mergeSort(right);
            sorted = mergeArray(left,right);
        }

        return sorted;
    }

    private static String[] mergeArray(String[] left, String[] right) {
        String[] merged = new String[left.length+right.length];
        int lIndex = 0;
        int rIndex = 0;
        int mIndex = 0;
        int comp = 0;
        while (lIndex < left.length || rIndex < right.length) {
            if (lIndex == left.length) {
                merged[mIndex++] = right[rIndex++];
            } else if (rIndex == right.length) {
                merged[mIndex++] = left[lIndex++];
            } else {  
                comp = left[lIndex].compareTo(right[rIndex]);
                if (comp > 0) {
                    merged[mIndex++] = right[rIndex++];
                } else if (comp < 0) {
                    merged[mIndex++] = left[lIndex++];
                } else { 
                    merged[mIndex++] = left[lIndex++];
                }
            }   
        }
        return merged;
    }

   



public void actionPerformed(ActionEvent ev){
       
if(ev.getSource()==introducir){
leerDatos();
}

if(ev.getSource()==mostrar){

int i;	

sal.append("ALUMNOS:" + "\n");

for( i=0;i<nombre.length;i++){
sal.append(" " + nombre[i]
        + "\n" +apellido[i] + " " ) ;
}

sal.append("\n" + "\n");


sal.append("ALUMNOS ANTES DE ORDENAR:" + "\n");

for( i=0;i<nombre.length;i++){
sal.append(" " + nombre[i] + "  " + " " ) ;
}
sal.append("\n" + "\n");

sal.append("ALUMNOS DESPUES DE ORDENAR:" + "\n");

String[] sortedArray = mergeSort(nombre);

for( i=0;i<sortedArray.length;i++){
sal.append(" " + sortedArray[i] + "  " + " " ) ;
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

sal.append(" ");
sal.append(" ");

sal.append("APELLIDOS DESPUES DE ORDENAR:" + "\n");

String[] sortedArray = mergeSort(apellido);
for( i=0;i<sortedArray.length;i++){
sal.append(" " + sortedArray[i] + "  " + " " ) ;
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
