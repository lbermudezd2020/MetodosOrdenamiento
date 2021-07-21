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


public class MenuSisAltas{

		

private JTabbedPane tabbedPane; 
JFrame ven;


public MenuSisAltas(){
ven=new JFrame("Menu de Altas");
ven.setLayout(new BorderLayout());
interfaz2();
ven.getContentPane().add(tabbedPane);
ven.pack();
ven.setBackground(Color.WHITE);
ven.setVisible(true);
ven.setSize(1360, 700);
ven.setResizable(false);
}


public void interfaz2(){
tabbedPane = new JTabbedPane(SwingConstants.NORTH);
tabbedPane.setBackground(Color.blue);
tabbedPane.setForeground(Color.white);


tabbedPane.addTab("Burbuja con Regsitros",
null,
new BurbReg(),
"Uso del metodo burbuja Con Registros");


tabbedPane.addTab("Quick-Sort con Registros",
null,
new QuickReg(),
"Uso del metodo Quick-Sort Con Registros");

tabbedPane.addTab("Merge-Sort con Registros",
null,
new MergeReg(),
"Uso del metodo Merge-Sort Con Registros");

tabbedPane.addTab("Insertion-Sort con Registros",
null,
new InsertReg(),
"Uso del metodo Insertion-Sort Con Registros");

tabbedPane.addTab("Selection-Sort con Registros",
null,
new SelecReg(),
"Uso del metodo Selection-Sort Con Registros");

tabbedPane.addTab("Shell-Sort con Registros",
null,
new ShellReg(),
"Uso del metodo Shell-Sort Con Registros");

}



}//fin clase.