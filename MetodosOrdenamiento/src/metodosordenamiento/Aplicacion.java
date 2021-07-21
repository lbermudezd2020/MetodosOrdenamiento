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
import ArbolesExpMin.MenuArbolesExMi;
import BusquedaDES_BFS.BusqBFSDES;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import metodosordenamiento.Registros.MenuSisAltas;

public class Aplicacion {

    public static void main(String args[]) {

        Aplicacion app = new Aplicacion();
        app.ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JTabbedPane tabbedPane;
    JFrame ven;

    public Aplicacion() {
        ven = new JFrame("PROYECTO: PROGRAMACION AVANZADA");
        ven.setLayout(new BorderLayout());
        interfaz();
        ven.getContentPane().add(tabbedPane);
        ven.pack();
        ven.setBackground(Color.WHITE);
        ven.setVisible(true);
        ven.setSize(1350, 700);
        ven.setResizable(false);

    }

    public void interfaz() {

        tabbedPane = new JTabbedPane(SwingConstants.NORTH);
        tabbedPane.setBackground(Color.blue);
        tabbedPane.setForeground(Color.white);

        tabbedPane.addTab("Burbuja",
                null,
                new Burbuja(),
                "Uso del metodo burbuja");

        tabbedPane.addTab("Quick sort",
                null,
                new QuickSort(),
                "Uso del metodo quicksort");

        tabbedPane.addTab("Shell sort",
                null,
                new ShellSort(),
                "Uso del metodo shellsort");

        tabbedPane.addTab("Radix sort",
                null,
                new Radix(),
                "Uso del metodo  Radix sort");

        tabbedPane.addTab("Merge sort",
                null,
                new Merge(),
                "Uso del metodo de intercalacion directa");

        tabbedPane.addTab("Counting Sort",
                null,
                new Counting(),
                "Uso del metodo de CountingSort");

        tabbedPane.addTab("Selection Sort",
                null,
                new Selection(),
                "Uso del metodo de Selection Sort");

        tabbedPane.addTab("Insertion Sort",
                null,
                new Insertion(),
                "Uso del metodo de Insertion Sort");

        tabbedPane.addTab("Bucket Sort",
                null,
                new Bucket(),
                "Uso del metodo de Bucket Sort");

        tabbedPane.addTab("Heap Sort",
                null,
                new Heap(),
                "Uso del metodo de Heap Sort");

        tabbedPane.addTab("Grafica Metodos",
                null,
                new GraficaTds(),
                "Mostrar Grafica");

        menu();
    }

    private void menu() {

        JMenuBar mb = new JMenuBar();
        JMenu ayuda = new JMenu("Algoritmos Recursivos|Iterativos");
        JMenu otro = new JMenu("Sistema Altas");
        JMenu busqueda = new JMenu("Busqueda DES|BFS");
        JMenu arboles = new JMenu("Arboles de Expanción Miníma");

        JMenuItem acerca = new JMenuItem("Mostrar");
        JMenuItem acerca2 = new JMenuItem("Mostrar");
        JMenuItem acerca3 = new JMenuItem("Mostrar");
        JMenuItem acerca4 = new JMenuItem("Mostrar");

        acerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                AlgoRecuItera algoRecuItera = new AlgoRecuItera();

            }
        });

        acerca2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                MenuSisAltas menuSisAltas = new MenuSisAltas();

            }
        });

        acerca3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                BusqBFSDES busqbfsdes = new BusqBFSDES();

            }
        });

        acerca4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                MenuArbolesExMi menuArbol = new MenuArbolesExMi();

            }
        });

        ayuda.add(acerca);
        otro.add(acerca2);
        busqueda.add(acerca3);
        arboles.add(acerca4);
        mb.add(ayuda);
        mb.add(otro);
        mb.add(busqueda);
        mb.add(arboles);
        ven.setJMenuBar(mb);
    }
}
