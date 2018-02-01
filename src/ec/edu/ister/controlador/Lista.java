/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.controlador;

import ec.edu.ister.modelo.Nodo;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB1PC14
 */
public class Lista {
    
  public Nodo inicio;
 public Nodo fin;
 
 public Lista(){
  inicio=fin=null;
 }
 
 public void iniciar(String texto){
  inicio=fin=null;//En caso de usarse nuevamente, se borra el contenido de la Lista anterior
  Nodo nuevo;
  int i;
  for(i=0;i<texto.length();i++){
   agregarOrdenado(texto.charAt(i));//Agrega los valores del String en orden al momento de inicializar
  }
  
 }
 
 public void agregarNodo(char a){//Funcion que agrega un Nodo al final de la lista
  Nodo nuevo=new Nodo(fin,null,a);
  if(fin!=null){
   fin.setSiguiente(nuevo);
   fin=nuevo;
  }else{
   inicio=fin=nuevo;
  }
 }
 
 public void imprimir(){//Funcion que imprime la Lista de inicio a fin
  Nodo aux=inicio;
  int cont=1;
  while(aux!=null){
   JOptionPane.showMessageDialog(null,cont+""+aux.getInfo());
   cont++;
   aux=aux.getSiguiente();
  }
 }
 
 public void agregarOrdenado(Character valor){//Funcion que agrega un nodo a lista alfabéticamente a-z
  Nodo nuevo=new Nodo(valor);
  if(inicio==null){//Compara si la lista esta vacia
   agregarNodo(valor);
  }else{
   if(valor.compareTo(inicio.getInfo())<=0){//Compara si el caracter es menor que el inicio a<z
    nuevo.setSiguiente(inicio);
    inicio.setAnterior(nuevo);
    inicio=nuevo;
   }else{
    if(valor.compareTo(fin.getInfo())>=0){//compara si el caracter es mayor que el fin z>a
     agregarNodo(valor);
    }else{
     Nodo aux=inicio;
     while(aux.getSiguiente()!=null){
       if(valor.compareTo(aux.getSiguiente().getInfo())<0){//Busca en la lista hasta su final un valor mayor que el del caracter para su ingreso
        break;
       }
      aux=aux.getSiguiente();
     }if(aux.getSiguiente()!=null){//Si existe el valor esperado
      if(valor.compareTo(aux.getSiguiente().getInfo())<0){//Se ingresa el valor a la lista y se realizan las conecciones necesarias
       nuevo.setAnterior(aux);
       nuevo.setSiguiente(aux.getSiguiente());
       aux.getSiguiente().setAnterior(nuevo);
       aux.setSiguiente(nuevo);
      }
     }
    }
   }
  }
 }
 public  void menu(){
    
    int op;
    
    do {   
        
       op=Integer.parseInt( JOptionPane.showInputDialog("Ingrese el Item \n\n"
               + "  . . . . . . . . . .  MENU  . . . . . . . . . . \n\n"
               +"1.Generar Lista en base a una cadena de caracteres\n"
               + "2.Imprimir Lista\n"
               + "3.- SALIR....\n\n"));
        
       switch(op){
            case 1:
              iniciar(JOptionPane.showInputDialog("Ingrese la palabra para generar la lista"));
               break; 
           case 2:
            imprimir();
               break;
          
       }       
    }while (op!=3); 
}
 }