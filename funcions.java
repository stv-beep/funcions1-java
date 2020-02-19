import java.util.Scanner;
public class funcions {

/*****FUNCIONS****/
/**Pel que fa al codi, en concret hem de tenir una funció per presentar el menú:
char menu(String[ ] opcions)*/
/*Mostra opcions per pantalla, recull quina opció escull l'usuari q haurà
de ser de tipus char, torna aquest char*/
public static char Menu(String[] opcions){
  System.out.println("Opcions del programa: ");
  System.out.println("____________________________________");
  /*Imprimim opcions*/
  for (String z : opcions) {
    System.out.println(z); }

  /*Demanar una opció*/
	Scanner sc = new Scanner(System.in);
  String opcio = sc.next();
  char opc = opcio.charAt(0);
  return opc;
}

/*Funció per a demanar la llista*/
/*
* ENTRADA: no res, la llista l'escriurà l'usuari
* SORTIDA: un booleà que indicarà si la llista és correcta o no
* FUNCIÓ: Indica si el nom de la llista escrit per l'usuari és el correcte o no
*/
public static boolean entradaLlista(String llista){
  Scanner sc = new Scanner(System.in);
  System.out.println("Escriu la llista que vols imprimir:");
  System.out.println("Llista disponible: \"cognoms\".");
  llista = sc.next();
  boolean comprovacio;
  if (llista.contains("cognoms")) {
    comprovacio = true;

  } else { comprovacio = false;
    System.out.println("La llista que has escrit no existeix, torna-ho a provar!");
  }
  return comprovacio;
}




/*Funció d'imprimir llista*/
/*Entrada: String[] a imprimir
* Sortida: Resultat per pantalla (Void)
* Funció: Mostra per pantalla els elements de l'array*/
public static void funcImpr(String[] cognoms) {


  int num_elements = 0;

  if (llistaBuida(cognoms,num_elements)==false) {
       for (String j : cognoms) {
       if(j!=null) {
           num_elements++;
       }
	  System.out.println("L'element "+(num_elements-1)+" és "+j+".");
      }
	 } else {
    System.out.println("Llista buida!");
	        }
	return;
}




/*Funció per a saber si la llista està buida o no*/
/** boolean llistaBuida(String[ ] llista, int elements) que ens digui si la llista està buida o no. Aquesta funció s'utilitza com a funció auxiliar en moltes altres funcions.*/
/*ENTRADA: llista i int (num_elements)
* SORTIDA: un booleà que ens dirà si la llista està buida (true) o no (false)
* FUNCIÓ: inidicarà si a la llista hi ha valors o no
*/
public static boolean llistaBuida(String[ ] cognoms, int num_elements) {
    /*comptador d'elements*/
    boolean buit;//indicarà si la llista està buida o no
    num_elements = 0;
    for (String e : cognoms) {
        if(e!=null) {
            num_elements++; //contem els elements
        }
    }
    if (num_elements<1) { //la llista està buida
      buit = true;
      System.out.println(buit);
    } else { //la llista no està buida
      buit = false;
      System.out.println(buit);
    }
    return buit;
}

/*Funció ANULAR*/
public static void funcNull(String[] cognoms) {
  int num_elements = 0;
  for (String e : cognoms) {
      if(e!=null) {
          num_elements++;
      }
  }

  for (int i = 0; i<num_elements; i++) {
      cognoms[i] = null;
  }
  System.out.println("La llista (cognoms) ha estat buidada.");
    for (String e : cognoms) {
      if(e!=null) {
          num_elements++;
          System.out.print(e);
      }
  }
  return;
}


  /*MAIN*/
  public static void main(String[] args){
  /**Variables*/
  /*array de les opcions del menú, que s'imprimiran per pantalla*/
  String[] opcions = {"\"i\": Inserir (element,posició) --- NO OPERATIU",
  "\"l\": Localitzar (element)      --- NO OPERATIU",
  "\"r\": Recuperar (posició)       --- NO OPERATIU",
  "\"s\": Suprimir (posició)        --- OPERATIU*",
  "\"d\": SuprimirDada (element)    --- NO OPERATIU",
  "\"a\": Anul·lar                  --- OPERATIU",
  "\"p\": PrimerDarrer              --- NO OPERATIU",
  "\"m\": Imprimir                  --- OPERATIU",
  "\"o\": Ordenar                   --- NO OPERATIU",
  "\"x\": Sortir                    --- OPERATIU"};

  int mida = 10;
  String[] cognoms = {"Algueró","Brull","El Khattabi","Ferre","Castells","Falco","Fernandez","España","Didouh","Garcia"};//Elements:10
  boolean running = true;
  String element, x; //element
  int pos, p; //posició
  int num_elements = 0; //comptador d'elements
  String nomllista;
  String llista =""; //nom de la llista
  String primerDarrer;
  boolean comprovacioList;
  Scanner sc = new Scanner(System.in);

do{
    char opc1 = Menu(opcions);


    switch (opc1) {
    case 'i':
    System.out.println(cognoms.length);
    System.out.println("stv");

    break;

    case 'a': //anul·lar
    do {
      comprovacioList = entradaLlista(llista);
    } while (comprovacioList != true);
    funcNull(cognoms);
    break;

    case 'm': //imprimir
    do {
      comprovacioList = entradaLlista(llista);
    } while (comprovacioList != true);

    funcImpr(cognoms);
    System.out.println();
    break;

    case 'b': //cas de prova per a comprovar el funcionament de la funció llistaBuida
    llistaBuida(cognoms, num_elements);

    break;



    case 'x':
    System.out.println("Vinga dw");
    System.out.println("____________________________________");
    running = false;
    break;

    default:
    break;
    }


}while(running);



}
}
