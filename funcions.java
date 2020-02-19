import java.util.Scanner;
public class funcions {

/*****FUNCIONS****/


/**Pel que fa al codi, en concret hem de tenir una funció per presentar el menú:
char menu(String[ ] opcions)*/
/*Mostra opcions per pantalla, recull quina opció escull l'usuari q haurà
de ser de tipus char, torna aquest char*/
public static char Menu(String[] opcions, String opcio){
System.out.println("Opcions del programa: ");
System.out.println("____________________________________");
/*Imprimim opcions*/
for (String z : opcions) {
  System.out.println(z);
}
/*Demanar una opció*/
Scanner sc = new Scanner(System.in);
opcio = sc.next();
char opc = opcio.charAt(0);
return opc;}

/*Demanar element*/
public static String entradaElement() {
  System.out.println("Introdueix un element: (Sense Comilles)" );
  element = sc.nextLine();
  return element; //retorna el String element, entrat pel user
}


/**Demanar posició*/
/*ENTRADA: la posició escrita per l'usuari ja declarada dalt.
SORTIDA: la posició de tipus enter.
FUNCIONAMENT: guarda la posició escrita per l'usuari a la variable "pos"
 i retorna aquest int quan es crida la funció.*/
public static int entradaPos() { //funció que retornarà posició entrada pel user
  System.out.println("Introdueix una posició: ");
  pos = sc.nextInt();
  return pos; //retorna la posició
}

/*Demanar llista*/
//en certs problemes, i segurament la eliminaré ja que no és necessaria xq només tenim una llista.
public static void entradaLlista() {
  System.out.println("Introdueix una llista: ");
  while(true) {
      nomllista = sc.nextLine();
      if (nomllista.contains("cognoms")) {
        break;
      }else{
          System.out.println("Aquesta llista no existeix, torna a introduir una altra."+  " (cognoms) " );
      }
  }
  return;
}

/*Suprimir*/
  public static int entradaSuprimir() { //funció que retornarà posició entrada pel user
 System.out.println("Introdueix una posició: ");
 pos = sc.nextInt();
 return pos; //retorna la posició
}

/*SuprimirData*/
//public static String nomSuprimir()

/*l'estic fent a l'eclipse*/


/*Funció ANULAR*/
public static void funcNull() {

  for (int e = 0; e<num_elements; e++) {
      cognoms[e] = null;
  }
  System.out.println("La llista (cognoms) ha estat buidada.");
  return;
}


/*Funció PrimerDarrer*/
public static void funcioPD() {
  do {
      System.out.println( "Opcions: \"primer\" o \"darrer\"" );
      primerDarrer = sc.next();
  } while(!(primerDarrer.equals("primer")||primerDarrer.equals("darrer")));
  if (primerDarrer.equals("primer")) {
      System.out.println(cognoms[0]);
  } else if (primerDarrer.equals("darrer")) {
      System.out.println(cognoms[num_elements-1] );
  }
  return;
}

/*Funció imprimir llista*/
/*Entrada: String[] a imprimir i int num (num_elements)
* Sortida: Resultat per pantalla (Void)
* Funció: Mostra per pantalla els elements de l'array*/
public static void funcioImpr() {
if (num_elements > 0) {
  int num = 0;
for (String j : cognoms) {

  num++;
  System.out.println("L'element "+(num-1)+" és "+j+".");
}
} else {
  System.out.println("Llista buida!");
}

return;
}





/*MAIN*/
public static void main(String[] args){
/**Variables*/
/*array de les opcions del menú, que s'imprimiran per pantalla*/
String[] opcions = {"\"i\": Inserir (element,posició) --- NO FUNCIONA",
"\"l\": Localitzar (element)      --- NO FUNCIONA BÉ",
"\"r\": Recuperar (posició)       --- OPERATIU",
"\"s\": Suprimir (posició)        --- OPERATIU*",
"\"d\": SuprimirDada (element)    --- NO OPERATIU",
"\"a\": Anul·lar                  --- OPERATIU",
"\"p\": PrimerDarrer              --- NO FUNCIONA BÉ",
"\"m\": Imprimir                  --- OPERATIU",
"\"o\": Ordenar                   --- NO OPERATIU",
"\"x\": Sortir                    --- OPERATIU"};
char opc;
String opcio;
int mida = 10;
String[] cognoms = {"Algueró","Ferre","Bayo","Falco","Fernandez","Didouh","Garcia","El Khattabi","Aloy","Brull"};//Elements:10
boolean running = true;
String element, x; //element
int pos, p; //posició
int num_elements = 0; //comptador d'elements
String nomllista, llista; //nom de la llista
String primerDarrer;
Scanner sc = new Scanner(System.in);




  while (running) {

Menu(opcions);




/*COMPTADOR. S'ha de canviar de puesto i posar-lo a cada operació, o fer una funció en ell*/
num_elements = 0;
for (String e : cognoms) {
    if(e!=null) {
        num_elements++;
    }
}

switch(opc) {
case 'i':
System.out.println("Inserir: ");
break;

case 'l'://Localitzar
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


case 'r': //Recuperar
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
    System.out.println();
}else{
    System.out.println("A la posició " +p+" es troba l'element: "+cognoms[p]+".");
    System.out.println();

}
break;
case 's': //Suprimir
                    p = entradaSuprimir();


                   if (p <= 10 && p >= 0) {
                       System.out.println("Quina llista?" );
                       String taula = sc.next();

                       if (taula.equals("cognoms")) {
                           cognoms[p] = "";
                           System.out.println("Dada borrada, ara la posicio " + p + " esta lliure" );

                       } else {
                           System.out.println("Aquesta taula no existeix" );

                       }

                   } else {
                       System.out.println("Aquesta posicio no es valida");

                   }
                   funcioImpr();

                     break;

case 'a': //ANULAR
funcNull();



break;

case 'p': //primerDarrer
System.out.println("PrimerDarrer");
  entradaLlista();
  funcioPD(); //crido a la funció
break;


case 'm'://Imprimir
funcioImpr();

System.out.println(cognoms.length);//llargada de la llista per a fer proves
break;


case 'x':
System.out.println("Vinga dw");
System.out.println("____________________________________");
running = false;
break;

default:
break;
}

}


}

}
