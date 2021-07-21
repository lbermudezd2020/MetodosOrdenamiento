/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolesExpMin;

/**
 *
 * @author luis
 */

import javax.swing.*;
import java.awt.*;


public class MenuArbolesExMi{

private JTabbedPane tabbedPane; 
JFrame ven;


public MenuArbolesExMi(){
ven=new JFrame("Menu Arboles de Expancion Minima");
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


tabbedPane.addTab("PRIM",
null,
new Prim(),
"PRIM");

tabbedPane.addTab("DIJKSTRA",
null,
new PrinDijkstra(),
"DIJKSTRA");

tabbedPane.addTab("BELLMAN-FORD",
null,
new BellmanFord(),
"BELLMAN-FORD");

tabbedPane.addTab("KRUSKAL",
null,
new Kruskal(),
"KRUSKAL");

}



}//fin clase.