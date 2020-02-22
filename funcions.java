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
* ENTRADA: un string escrit per l'usuari
* SORTIDA: un booleà que indicarà si la llista és correcta o no
* FUNCIÓ: Indica si el nom de la llista escrit per l'usuari és el correcte o no
*/
public static boolean entradaLlista(String llista){
  Scanner sc = new Scanner(System.in);
  System.out.println("Escriu una llista:");
  System.out.println("Llista disponible: \"cognoms\".");
  llista = sc.next();
  boolean comprovacio;
  do {
  if (llista.contains("cognoms")) {
    comprovacio = true;

  } else { comprovacio = false;
    System.out.println("La llista que has escrit no existeix, torna-ho a provar!");
    break;
  }
} while (!(llista.contains("cognoms")));
  return comprovacio;
}


/*Funció de localitzar element*/
/*
* Entrada: un string que serà l'element a buscar i el String[] de la llista
* Sortida: s'imprimirà per pantalla la posició de l'element (Void)
* Funció: trobar a quina posició està l'element entrat per l'usuari
*/
public static void funcLoc(String elem, String[] cognoms) {
  /*Comptador d'elements*/
  int num_elem =0;
  for (String u : cognoms) {
  if(u!=null) {
      num_elem++;
  }}
  String nomllista1;
  Scanner sc = new Scanner(System.in);
  do {
  System.out.println("Escriu una llista:");
  System.out.println("Llista disponible: \"cognoms\".");
  nomllista1 = sc.next();
  } while (!(nomllista1.contains("cognoms")));
  /*Preguntem l'element*/
  do {
      System.out.println("Introdueix un element: (Sense Comilles)");
      elem= sc.nextLine();
  } while(elem.length()<1);
  for(int i = 0; i<num_elem; i++) {

      if (i == num_elem) {
          System.out.println("L'element "+elem+" no es troba a la llista "+nomllista1+".");
          break;
      }
      if ( cognoms[i] != null && cognoms[i].equals(elem)) {System.out.println("L'element "+elem+" es troba a la posició "+i+"."); break;}
  }

  return;
}






/*Funció de recuperar element*/
/*
* Entrada: un int que determinarà la posició a buscar, i el String[] de la llista
* Sortida: s'imprimirà per pantalla l'element que està a la posició p
* Funció: trobar quin element està a la posició p
*/
public static void funcRecu(int p, String[] cognoms) {
  String nomllista1;
  Scanner sc = new Scanner(System.in);
  do {
  System.out.println("Escriu una llista:");
  System.out.println("Llista disponible: \"cognoms\".");
  nomllista1 = sc.next();
} while (!(nomllista1.contains("cognoms")));//mentres nomllista1 no contingui "cognoms" el do s'executarà
  System.out.println("Escriu una posició:");
  while (true) {
    p = sc.nextInt();
    if (p >= 0 && p < cognoms.length) {
        break;
    }else{
        System.out.println("Posició Incorrecta/Posicions anteriors buides");
    }
}
if (cognoms[p] == null) {
    System.out.println("La posició " +p+" està buida.");
}else{
    System.out.println("A la posició " +p+" es troba l'element: "+cognoms[p]);

}
return;
}



/*Funció PrimerDarrer*/
/*
* Entrada: String[] dels cognoms
* Sortida: Imprimir l'element per pantalla  (Void)
* Funció: mostrarà quin és el primer o últim element de la llista
*/
public static void funcPD(String[] cognoms) {
  /*Nom de la llista*/
  Scanner sc = new Scanner(System.in);
  String nomllista1 = "";
  entradaLlista(nomllista1);
  /*Comptador*/
  int nE = 0;
  if (llistaBuida(cognoms,nE)==false) {
       for (String w : cognoms) {
       if(w!=null) {
           nE++;
       }}}
  /*Primer o darrer*/
  String pd = sc.next();
  String primerDarrer = "";
  do {
      System.out.println("Opcions: \"primer\" o \"darrer\"");
      pd = sc.next();
  } while(!(pd.equals("primer")||pd.equals("darrer")));
  if (pd.equals("primer")) {
      System.out.println(cognoms[0]);
      //primerDarrer = cognoms[0];
  } else if (pd.equals("darrer")) {
      System.out.println(cognoms[nE-1]);
      //primerDarrer = cognoms[nE-1];
  }




  return;
}




/*Funció d'imprimir llista*/
/*Entrada: String[] a imprimir
* Sortida: Resultat per pantalla (Void)
* Funció: Mostra per pantalla els elements de l'array*/
public static void funcImpr(String[] cognoms) {

//falta l'entrada de l'usuari

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
public static boolean llistaBuida(String[] cognoms, int num_elements) {
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
    } else { //la llista no està buida
      buit = false;
    }
    return buit;
}

/*Funció ANULAR*/
/* Entrada: String[] dels cognoms
* Sortida: un missatge per pantalla dient que la llista ha estat buidada
* Funció: es convertiran en null tots els elements de la llista
*/
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
  String[] opcions = {"\"i\": Inserir (element,posició)   --- NO OPERATIU",
  "\"l\": Localitzar (element, llista)--- NO FUNCIONA BÉ",
  "\"r\": Recuperar (posició, llista) --- OPERATIU",
  "\"s\": Suprimir (posició)          --- NO OPERATIU",
  "\"d\": SuprimirDada (element)      --- NO OPERATIU",
  "\"a\": Anul·lar                    --- OPERATIU",
  "\"p\": PrimerDarrer                --- NO OPERATIU",
  "\"m\": Imprimir                    --- OPERATIU",
  "\"o\": Ordenar                     --- NO OPERATIU",
  "\"x\": Sortir                      --- OPERATIU"};

  int mida = 10;
  String[] cognoms = {"Algueró","Brull","El Khattabi","Ferre","Castells","Falco","Fernandez","España","Didouh","Garcia"};//Elements:10
  boolean running = true;
  String x, element =" "; //element
  int pos = 0; //posició
  int numEle = 0; //comptador d'elements
  String nomllista;
  String llista =""; //nom de la llista
  //String primerDarrer;
  boolean comprovacioList;// on guardarem el boolea que ens retornarà la funcio entradaLlista
  boolean buit0; // si la llista està buida o no
  Scanner sc = new Scanner(System.in);

do{
    char opc1 = Menu(opcions);


    switch (opc1) {
    case 'i': //inserir
    System.out.println(cognoms.length);
    System.out.println("stv");
    break;

    case 'l': //Localitzar
    funcLoc(element, cognoms);

    break;
    case 'r': //recuperar
    funcRecu(pos, cognoms);

    break;

    case 'a': //anul·lar
    do {
      comprovacioList = entradaLlista(llista);
    } while (comprovacioList != true);

    llistaBuida(cognoms, numEle);
      if ((llistaBuida(cognoms, numEle)==false)) {
    funcNull(cognoms);
      } else {
        System.out.println("La llsita ja està buida!");
      }
    break;

    case 'p': //primerDarrer
    do {
    comprovacioList = entradaLlista(llista);
    } while (comprovacioList == false);
    funcPD(cognoms);
    break;

    case 'm': //imprimir
    do {
      comprovacioList = entradaLlista(llista);
    } while (comprovacioList != true);

    funcImpr(cognoms);

    System.out.println();
    break;

    case 'b': //cas de prova per a comprovar el funcionament de la funció llistaBuida
    llistaBuida(cognoms, numEle);

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
