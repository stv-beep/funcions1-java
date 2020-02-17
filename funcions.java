import java.util.Scanner;
public class funcions {
public static Scanner sc = new Scanner(System.in);
public static String opcio;
public final int mida = 10;
public static String[] cognoms = {"Algueró","Ferre","Bayo","Falco","Fernandez","Didouh","Garcia","El Khattabi","Aloy","Brull"};//Elements:10
public static boolean running = true;
public static String element, x; //element
public static int pos, p; //posició
public static int num_elements;


/*****FUNCIONS****/


/*Pel que fa al codi, en concret hem de tenir una funció per presentar el menú:
char menu(String[ ] opcions)*/
//el menú se te que arreglar
public static void Menu(){
System.out.println("Opcions del programa: ");
System.out.println("____________________________________");
String opcions[] = new String [12];
opcions[0] = "\"i\": Inserir (element,posició) --- NO FUNCIONA";
opcions[1] = "\"l\": Localitzar (element)      --- NO FUNCIONA BÉ";
opcions[2] = "\"r\": Recuperar (posició)       --- OPERATIU";
for (String z : opcions) {
  if (z!=null) {
  System.out.println(z);}
}
opcio = sc.next();
return;}

/*Demanar element*/
public static String entradaElement() {
  System.out.println("Introdueix un element: (Sense Comilles)" );
  element = sc.nextLine();
  return element; //retorna el String element, entrat pel user
}


/*Demanar posició*/
public static int entradaPos() { //funció que retornarà posició entrada pel user
  System.out.println("Introdueix una posició: ");
  pos = sc.nextInt();
  return pos; //retorna la posició

}

public static void main(String[] args){
  while (running) {

Menu();

/*COMPTADOR. S'ha de canviar de puesto i posar-lo a cada operació, o fer una funció en ell*/
num_elements = 0;//per a que comenci a comptar des del principi i per a que no es sumin elements de més cada vegada que es completi el bucle for.
for (String e : cognoms) {
    if(e!=null) {
        num_elements++;
    }
}

switch(opcio) {
case "i":
System.out.println("cas 1");
break;

case "l"://Localitzar
System.out.println("Localitzar");
do {
x = entradaElement();
} while (x == null || x.length()<1);
for(int i = 0; i<cognoms.length; i++) {

    if (i == num_elements) {
        System.out.println("L'element "+x+" no es troba a la llista ");
        break;
    }
    if ( cognoms[i] != null && cognoms[i].equals(x)) {
      System.out.println( "L'element "+x+" es troba a la posició "+i+"" ); break;}
}
break;



case "r": //Recuperar
System.out.println("Recuperar");
while (true) {
  p = entradaPos();//guardem a la variable "p" el que ens retorna la funció
  if (p >= 0 && p < cognoms.length && p <= num_elements) {
      break;
  }else{
      System.out.println( "Posició Incorrecta/Posicions anteriors buides" );
  }

}
if (cognoms[p] == null) {
    System.out.println("La posició " +p+" es buida" );
}else{
    System.out.println("A la posició " +p+" es troba l'element: "+cognoms[p]+".");

}

break;


case "x":
System.out.println("Vinga dw");
running = false;
break;
}

}


}

}
