import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Fuel {

    synchronized int calucla(float tempo,float tempoPorVolta, float quantoPorVolta){
        int litros;
        tempo = tempo * 60 - 120; //Passsar de minutos para segundos - 2 mins da primeira volta
        tempoPorVolta *= 60;
        int numeroDeVoltas = (int) Math.ceil(tempo/tempoPorVolta);
        litros = (int) Math.ceil(numeroDeVoltas*quantoPorVolta);
        return litros;
    }
}

class Main {
    public static void main(String[] args) {
        JLabel labelM = new JLabel("Tempo total de corrida: ");
        labelM.setBounds(50,20,200,30);

        JFrame f=new JFrame("Acc Fuel Calculator");
        final TextField tf = new TextField();
        f.add(labelM);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tf.setBounds(50,50, 200,30);

        JLabel label2 = new JLabel("Tempo medio por volta: ");
        f.add(label2);

        label2.setBounds(50,120,200,30);

        final TextField tf2 = new TextField();
        tf2.setBounds(50,150, 200,30);

        JLabel label3 = new JLabel("Consumo medio por volta: ");
        label3.setBounds(50,220,200,30);
        final TextField tf3 = new TextField();
        tf3.setBounds(50,250, 200,30);

        //float consumo = Float.parseFloat(tf3.getText());
        //

        final TextField resultado = new TextField();
        resultado.setBounds(50,350, 200,30);
        Button e=new Button("Calcular");
        JLabel label4 = new JLabel("Numero de litros necessarios: ");
        label4.setBounds(50,320,200,30);
        e.setBounds(50,400,200,30);
        e.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText(tf.getText());
                tf2.setText(tf2.getText());
                tf3.setText(tf3.getText());
                System.out.println(tf.getText() + "\n" + tf2.getText() + "\n" + tf3.getText());
                float tempoTotal = Float.parseFloat(tf.getText());
                float tempoMedio = Float.parseFloat(tf2.getText());

                float consumo = Float.parseFloat(tf3.getText());
                Fuel k = new Fuel();
                int ret = k.calucla(tempoTotal,tempoMedio,consumo);
                resultado.setText(String.valueOf(ret));
            }
        });
        f.add(label3);
        f.add(label4);

        f.add(e);f.add(tf);f.add(tf2);f.add(tf3);f.add(resultado);
        f.setSize(400,600);
        f.setLayout(null);
        f.setVisible(true);

    }
}
