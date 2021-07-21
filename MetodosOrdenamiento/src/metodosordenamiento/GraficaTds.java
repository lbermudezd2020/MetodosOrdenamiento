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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class GraficaTds extends JPanel implements ActionListener{

JTextArea sal;
JPanel bot,gra;
JButton mostrar,salir;

public GraficaTds(){
setLayout(new BorderLayout());	  
interfaz();
}


public void interfaz(){
//antes aqui iva el setLayout()	
sal=new JTextArea(15,35);
sal.setBorder(BorderFactory.createTitledBorder("  GRAFICA METODOS DE ORDENAMIENTO  "));
sal.setEditable(false);

bot=new JPanel();
bot.setLayout(new GridLayout(2,0));

mostrar=new JButton("Mostrar");
mostrar.setBackground(Color.BLUE);
mostrar.setForeground(Color.WHITE);
mostrar.addActionListener(this);

salir=new JButton("Salir");
salir.setBackground(Color.BLUE);
salir.setForeground(Color.WHITE);
salir.addActionListener(this);

bot.add(mostrar);
bot.add(salir);

add(sal,BorderLayout.CENTER);
add(bot,BorderLayout.EAST);

}


@Override
public void actionPerformed(ActionEvent ev){

    if(ev.getSource()==mostrar){
        
    DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
    
    long t11 = System.nanoTime();
        Burbuja burbuja = new Burbuja();
    long t21 = System.nanoTime();
    double timebur = (double )((t11-t21));
    
    long t12 = System.nanoTime();
        QuickSort quickSort = new QuickSort();
    long t22 = System.nanoTime();
    double timequick = (double )((t12-t22));
    
    long t13 = System.nanoTime();
        ShellSort shellSort = new ShellSort();
    long t23 = System.nanoTime();
    double timeshell = (double )((t13-t23));
    
    long t14 = System.nanoTime();
        Radix radix = new Radix();
    long t24 = System.nanoTime();
    double timeradi = (double )((t14-t24));
    
    long t15 = System.nanoTime();
        Merge merge = new Merge();
    long t25 = System.nanoTime();
    double timemerge = (double )((t15-t25));
    
    long t16 = System.nanoTime();
        Counting counting = new Counting();
    long t26 = System.nanoTime();
    double timecoun = (double )((t16-t26));
    
    long t17 = System.nanoTime();
        Selection selection = new Selection();
    long t27 = System.nanoTime();
    double timeselec = (double )((t17-t27));
   
    long t18 = System.nanoTime();
        Insertion insertion = new Insertion();
    long t28 = System.nanoTime();
    double timeinser = (double )((t18-t28));
    
    long t19 = System.nanoTime();
        Bucket bucket = new Bucket();
    long t29 = System.nanoTime();
    double timebuk = (double )((t19-t29));
    
    long t110 = System.nanoTime();
        Heap heap = new Heap();
    long t210 = System.nanoTime();
    double timeheap = (double )((t110-t210));

    
    dataset.addValue(timebur, "Burbuja", "");
    dataset.addValue(timequick, "Quick", "");
    dataset.addValue(timeshell, "Shell", "");
    dataset.addValue(timeradi, "Radix", "");
    dataset.addValue(timemerge, "Merge", "");
    dataset.addValue(timecoun, "Counting", "");
    dataset.addValue(timeselec, "Selection", "");
    dataset.addValue(timeinser, "Insertion", "");
    dataset.addValue(timebuk, "Bucket", "");
    dataset.addValue(timeheap, "Heap", "");
   
    JFreeChart grafica = ChartFactory.createBarChart3D(
    "Grafica Metodos de Ordenamiento", // El titulo de la gráfica
    "Metodo", // Etiqueta de categoria
    "Nanos Segundos", // Etiqueta de valores
    dataset, 
    PlotOrientation.VERTICAL, // orientacion
    true, // Incluye Leyenda
    true, // Incluye tooltips
    false // URLs?
    );
     
    // Creación del panel con el gráfico
    ChartPanel p = new ChartPanel(grafica);
    p.setVisible(true);
    p.setSize(1100, 520);
    sal.add(p);
    sal.repaint();
}
    
if(ev.getSource()==salir){
System.exit(0);

}

}//fin actionPerformed

}