/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Matuz
 */

import java.awt.Color;
import javax.swing.JFrame; //Para la ventana
import javax.swing.JLabel; //Datos de salida
import javax.swing.JButton; //Para botones
import javax.swing.JTextField; //Para caja de texto
import java.awt.event.ActionListener; //Para el escuchador
import java.awt.event.ActionEvent; //Eventos
import javax.swing.JOptionPane;

public class Comprobador_Palabras extends JFrame implements ActionListener{
    
    private JLabel mensaje;
    private JButton boton;
    private JTextField caja;
    private JTextField longitud;
    private JTextField palindromo;
    private JTextField inversa;
    private JTextField repetida;
    
    public Comprobador_Palabras(){
        super();
        configurarVentana();
        crearComponentes();
    }
    
    private void configurarVentana(){
        this.setTitle("Comprobador palabras"); //Titulo de la ventana
        this.setSize(500,500); //Tamaño con ancho y altura
        this.setLocationRelativeTo(null); //Para que la colocacion de la pantalla sea relativa
        this.setLayout(null); //Para la acomodación de las cosas dentro de la ventana
        this.setResizable(true); //Modificación del tamaño de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar ventana
    }
    
    private void crearComponentes(){
        mensaje = new JLabel(); //Se crea el objeto JLabel
        mensaje.setText("Palabra:"); // Se crea el texto a mostrar
        mensaje.setBounds(90,50, 300, 30); // Posición X e Y del texto y su tamaño.
        mensaje.setForeground(Color.BLACK); //Color del texto
        this.add(mensaje); //Añadir el texto a la ventana
        
        mensaje = new JLabel();
        mensaje.setText("Longitud: ");
        mensaje.setBounds(50,150,300,30);
        this.add(mensaje);
        
        longitud = new JTextField();
        longitud.setBounds(150,150,200,30);
        longitud.setEnabled(false);
        this.add(longitud);
        
        mensaje = new JLabel();
        mensaje.setText("Palindromo: ");
        mensaje.setBounds(50,200,300,30);
        this.add(mensaje);
        
        palindromo = new JTextField();
        palindromo.setBounds(150,200,200,30);
        palindromo.setEnabled(false);
        this.add(palindromo);
       
        mensaje = new JLabel();
        mensaje.setText("Inversa: ");
        mensaje.setBounds(50,250,300,30);
        this.add(mensaje);
        
        inversa = new JTextField();
        inversa.setBounds(150,250,200,30);
        inversa.setEnabled(false);
        this.add(inversa);
        
        mensaje = new JLabel();
        mensaje.setText("Repetida: ");
        mensaje.setBounds(50,300,300,30);
        this.add(mensaje);
        
        repetida = new JTextField();
        repetida.setBounds(150,300,200,30);
        repetida.setEnabled(false);
        this.add(repetida);
        
        caja = new JTextField();
        caja.setBounds(150,50,200,30);
        this.add(caja);
        
        boton = new JButton();
        boton.setText("Verificar");
        boton.setBounds(150,100,100,30);
        boton.addActionListener(this);
        this.add(boton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String resultado = caja.getText(); //Obtiene el texto que se encuentra en la cajita de texto 
        //Verificacion de longitud
        
        String[] resultadoArray = resultado.toUpperCase().split(" ");
        String palabraSinEspacios="";
        int numCaracteres=0;
        for(int i=0;i<resultadoArray.length;i++){
            numCaracteres+= resultadoArray[i].length();
            palabraSinEspacios+=resultadoArray[i];
        }
        longitud.setText("" + numCaracteres);
        
        //Verificacion de palindromo e inversa
        
        char[] palabraNormal = palabraSinEspacios.toCharArray();
        char[] palabraInversa = new char[palabraNormal.length];
        
        int j=0;
        String palabraReves="";
        for(int i=palabraNormal.length-1;i>=0;i--){
            palabraInversa[j] = palabraNormal[i];
            palabraReves+=palabraInversa[j];
            j++;
        }
      
        inversa.setText(palabraReves.toUpperCase());
        
        int contador=0;
        for(int i=0; i<palabraNormal.length;i++){
            if(palabraNormal[i] == palabraInversa[i]){
                contador++;
            }
        }
        if(contador==palabraNormal.length){
            palindromo.setText("SI");
        }
        else{
            palindromo.setText("NO");
        }
        
        
        //Verificacion de letra mas repetida
            int[] repeticiones = new int[palabraNormal.length];
            for(int i=0;i<repeticiones.length;i++){
                repeticiones[i]=0;
            }
            char aux;
            
            for(int i=0;i<palabraNormal.length;i++){
                aux=palabraNormal[i];
                for(int x=0;x<palabraNormal.length;x++){
                    if(aux==palabraNormal[x]){
                        repeticiones[i]++;
                    }
                }
            }
            
            int maximo=0;
            int posicion=0;
            for(int i=0;i<repeticiones.length;i++){
                if(maximo<repeticiones[i]){
                    maximo = repeticiones[i];
                    posicion=i;
                }
            }
            
            repetida.setText("Letra: " + palabraNormal[posicion] + " se repite: " + maximo + " veces");
    }
    
    public static void main(String[] args){
        Comprobador_Palabras ventana = new Comprobador_Palabras();
        ventana.setVisible(true);
    }
    
}
