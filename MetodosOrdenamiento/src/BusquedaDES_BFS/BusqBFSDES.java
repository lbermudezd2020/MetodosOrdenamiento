/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusquedaDES_BFS;

/**
 *
 * @author luis
 */

import javax.swing.*;
import java.awt.*;


public class BusqBFSDES{
		

private JTabbedPane tabbedPane; 
JFrame ven;


public BusqBFSDES(){
ven=new JFrame("BUSQUEDA BFS | DES");
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


tabbedPane.addTab("BUSQUEDA BFS",
null,
new BusBFS(),
"BUSQUEDA BFS");


tabbedPane.addTab("BUSQUEDA DES",
        null,
        new BusDES(),
"BUSQUEDA DES"
        );


}


}//fin clase.