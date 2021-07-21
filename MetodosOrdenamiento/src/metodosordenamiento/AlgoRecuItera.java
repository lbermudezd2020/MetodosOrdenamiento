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


public class AlgoRecuItera {

		

private JTabbedPane tabbedPane; 
JFrame ven;


public AlgoRecuItera(){
ven=new JFrame("Algoritmos Recursivos|Iterativos");
ven.setLayout(new BorderLayout());
interfaz1();
ven.getContentPane().add(tabbedPane);
ven.pack();
ven.setBackground(Color.WHITE);
ven.setVisible(true);
ven.setSize(1000, 600);
ven.setResizable(false);
}


public void interfaz1(){
tabbedPane = new JTabbedPane(SwingConstants.NORTH);
tabbedPane.setBackground(Color.blue);
tabbedPane.setForeground(Color.white);


tabbedPane.addTab("Fibonacci",
null,
new fibonacci(),
"Fibonacci");

tabbedPane.addTab("Factorial",
null,
new Factorial(),
"Factorial");

tabbedPane.addTab("MCD",
null,
new MCD(),
"MCD");

tabbedPane.addTab("SUMA DIGITOS DE UN NUMERO",
null,
new SumaDigNum(),
"SUMA DIGITOS DE UN NUMERO");

tabbedPane.addTab("MULTIPLICA ELEMENTOS VECTOR",
null,
new MultElemenVector(),
"MULTIPLICA ELEMENTOS VECTOR");


}


}//fin clase.