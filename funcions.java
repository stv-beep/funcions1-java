import java.util.Scanner;
public class funcions {

  /**
  		 * ***FUNCIONS***
  		 */
  		/**
  		 * Pel que fa al codi, en concret hem de tenir una funció per presentar el
  		 * menú: char menu(String[ ] opcions)
  		 */

  		/*
  		 * Entrada: la llista de les opcions
  		 * Sortida: un char, escrit per l'usuari
  		 * Funció: Mostra opcions per pantalla, recull quina opció escull l'usuari q haurà
  		   de ser de tipus char, torna aquest char
  		 */
  		public static char Menu(String[] opcions1) {
  				System.out.println("Opcions del programa: ");
  				System.out.println("____________________________________");
  				/*Imprimim opcions*/
  				for (String z : opcions1) {
  						System.out.println(z);
  				}

  				/*Demanar una opció*/
  				Scanner sc = new Scanner(System.in);
  				String opcio = sc.next();
  				char opc = opcio.charAt(0);
  				return opc;
  		}

  		/*Funció per a demanar la posició
      * Entrada: un int (número d'elements) i la llista
      * Sortida: un int (la posició escrita per l'usuari)
      * Funció: l'usuari escriurà una posició i si és correcta es guardarà
      "posició" i la funció la retornarà
      */
      public static int demPos(int numEle, String[] llista) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Escriu una posició:");
  				int posicio;
          while (true) {
              posicio = sc.nextInt();
              if (posicio >= 0 && posicio <= numEle && posicio < llista.length) {
                  break;
              } else {
                  System.out.println("Posició incorrecta. Torna a introduir:");
              }
          }
  				return posicio;
      }

      /*Funció per a demanar l'element*/
  		/*
  		 * Entrada: un String
  		 * Sortida: el String escrit per l'usuari
  		 * Funció: demana un String a l'usuari
  		 */
  		public static String demEle(String element) {
  				Scanner sc = new Scanner(System.in);
  				do {
  						System.out.println("Introdueix un element: (Sense Comilles)");
  						element = sc.nextLine();
  				} while (element.length() < 1);

  				return element;
  		}

  		/*Funció de localitzar element*/
  		/*
  		 * Entrada: un string que serà l'element a buscar, el String[] de la llista i un int
  		 * Sortida: s'imprimirà per pantalla la posició de l'element (Void)
  		 * Funció: trobar a quina posició està l'element entrat per l'usuari
  		 */
  		public static int funcLoc(String elem, String[] cognoms2, int i) {
  				Scanner sc = new Scanner(System.in);
  				int loc = 0;
  				/*Preguntem l'element*/
  				elem = demEle(elem);

  				for (i = 0; i < cognoms2.length-1; i++) {


  						if (cognoms2[i] != null && cognoms2[i].equals(elem)) {
  								System.out.println("L'element " + elem + " es troba a la posició " + i + ".");

  						} else if (i >= cognoms2.length-1) {
  								System.out.println("L'element " + elem + " no es troba a la llista cognoms.");

  						}


  						loc = i;
  				}
  				return loc;
  		}

  		/*Funció de recuperar element*/
  		/*
  		 * Entrada: un int que determinarà la posició a buscar, el String[] de la llista
       i un int per a incrementar-se fins a la posició
  		 * Sortida: retornarà l'element i a part, s'imprimirà per pantalla l'element que està a la posició p
  		 * Funció: trobar quin element de "coknoms" està a la posició p, incrementant la N fins a arribar a
       la posició.
  		 */
  		public static String funcRecu(int p, String[] coknoms, int n) {
  				Scanner sc = new Scanner(System.in);
  				String z = "";

          for (n = 0; n<=p;n++) { //incrementem la N fins a la posició
  				if (coknoms[p] == null) { //si la posició és nula
  						System.out.println("La posició " + p + " està buida.");
              break;
  				} else if (n == p) {
  						System.out.println("A la posició " + p + " es troba l'element: " + coknoms[p]);

  						z = coknoms[p];
  				      }
          }
  				return z;
  		}


  		/*Funció de Suprimir*/
  		/*Entrada: Escriure la posició de l'element que volem Suprimir
  		 * Sortida: Imprimir la llista en la ultima posició lliure
  		 * Funció: Suprimix un element de la llista
  		 */
  		public static int funcSupr(String[] cogn, int p1,int numEle) {

  						for (int y = p1; y < numEle-1; y++) {
  								cogn[y] = cogn[y + 1];
  						}
  						cogn[numEle-1] = null;
  						numEle--;
  						System.out.println("L'element de la posició " + p1 + " ha estat eliminat");
  						funcImpr(cogn,numEle);
  						return numEle;
  		}

  		/*Funció PrimerDarrer*/
  		/*
  		 * Entrada: String[] dels cognoms i int
  		 * Sortida: l'element en la posició triada (String) i imprimit per pantalla
  		 * Funció: mostrarà quin és el primer o últim element de la llista
  		 */
  		public static String funcPD(String[] cogs, int q) {
  				Scanner sc = new Scanner(System.in);
  				String pd;
  				String primerDarrer = "";
  				do {
  						System.out.println("Opcions: \"primer\" o \"darrer\"");
  						pd = sc.next();
  				} while (!(pd.equals("primer") || pd.equals("darrer")));
  				if (pd.equals("primer")) {
  						System.out.println(cogs[0]);
  						primerDarrer = cogs[0];
  				} else if (pd.equals("darrer")) {
            for (q = 0; q<cogs.length-1;q++){
              if (cogs[q]!=null) {
                q++;
              }
              primerDarrer = cogs[q];
            }
  						System.out.println(primerDarrer);

  				}
  				return primerDarrer;
  		}

  		/*Funció d'imprimir llista*/
  		/*
  		 * Entrada: String[] a imprimir, amb un int que indicara l'índex
  		 * Sortida: Resultat per pantalla (Void), els elements amb les seves posicions
  		 * Funció: llegeix tota la llista i mostra tots els elements amb la seva posició
  		 */
  		public static void funcImpr(String[] cognoms3, int p3) {

  				for (p3 = 0 ; p3 < cognoms3.length; p3++) {
            if (cognoms3[p3]!=null) {

  						System.out.println("L'element " + p3 + " és " + cognoms3[p3] + ".");
  				}}
  				/*No poso cap altra condició ja que tenim una funció per a comprovar
  				   si la llista està buida o no*/

  		}

  		/*Funció per a saber si la llista està buida o no*/
  		/**
  		 * boolean llistaBuida(String[ ] llista, int elements) que ens digui si la
  		 * llista està buida o no. Aquesta funció s'utilitza com a funció auxiliar
  		 * en moltes altres funcions.
  		 */
  		/*ENTRADA: llista i int (num_elements)
  		 * SORTIDA: un booleà que ens dirà si la llista està buida (true) o no (false)
  		 * FUNCIÓ: inidicarà si a la llista hi ha valors o no
  		 */
  		public static boolean llistaBuida(String[] cognomsl, int num_elements) {
  				/*comptador d'elements*/
  				boolean buit;//indicarà si la llista està buida o no
  				num_elements = 0;
  				for (String e : cognomsl) {
  						if (e != null) {
  								num_elements++; //contem els elements
  						}
  				}
  				if (num_elements < 1) { //la llista està buida
  						buit = true;
  				} else { //la llista no està buida
  						buit = false;
  				}
  				return buit;
  		}

  		/*Funció ANULAR*/
  		/* Entrada: String[] dels cognoms i int del número d'elements
  		 * Sortida: la llista, i un missatge per pantalla dient que la llista ha estat buidada
  		 * Funció: es convertiran en null tots els elements de la llista
  		 */
  		public static String[] funcNull(String[] cognoms, int num_elements) {
  				num_elements = 0;
  				for (String e : cognoms) {
  						if (e != null) {
  								num_elements++;
  						}
  				}

  				for (int i = 0; i < num_elements; i++) {
  						cognoms[i] = null;
  				}
  				System.out.println("La llista (cognoms) ha estat buidada.");
  				for (String e : cognoms) {
  						if (e != null) {
  								num_elements++;
  								System.out.print(e);
  						}
  				}
  				return cognoms;
  		}

  		/*Funció ORDENAR
       * Entrada: la llista i un int per a recorrer la llista al imprimir
  		 * Sortida: la llista d'elemetns ordenada alfabeticament
  		 * Funció: s'ordenaran alfabeticament tots els element de la llista
  		 */
  		public static String[] funcOrde(String[] cognLlis, int w) {

  				String cognOrde;
  				//Va comparan el primer amb el segon
  				for (int i = 1; i <= cognLlis.length - 1; i++) {
  						//Compara el primer amb la resta
  						for (int j = 0; j < cognLlis.length - 1; j++) {
  								//utilitzem compareTO per a que compare les Strings
  								if (cognLlis[j].compareTo(cognLlis[j + 1]) > 0) {
  										cognOrde = cognLlis[j];
  										cognLlis[j] = cognLlis[j + 1];
  										cognLlis[j + 1] = cognOrde;
  								}
  						}
  				}//Va imprimint la llista amb els cognoms ordenats i amb el numero davan
  				for (w = 0; w < cognLlis.length; w++) {
  						System.out.println(w + " " + cognLlis[w]);
  				}
  				return cognLlis;
  		}


  		/*MAIN*/
  		public static void main(String[] args) {
  				/**
  				 * Variables
  				 */
  				/*array de les opcions del menú, que s'imprimiran per pantalla*/
  				String[] opcions = {"\"i\": Inserir          --- NO OPERATIU",
  						            "\"l\": Localitzar       --- TÉ IMPERFECCIONS",
  						            "\"r\": Recuperar        --- OPERATIU",
  						            "\"s\": Suprimir         --- OPERATIU",
  						            "\"d\": SuprimirDada     --- NO OPERATIU",
  						            "\"a\": Anul·lar        --- OPERATIU",
  						            "\"p\": PrimerDarrer     --- OPERATIU",
  						            "\"m\": Imprimir         --- OPERATIU",
  						            "\"o\": Ordenar          --- OPERATIU",
  						            "\"x\": Sortir           --- OPERATIU"};

  				final int mida = 10;
  				//String cognoms[] = new int[mida];
  				String[] cognoms = {"Algueró", "Brull", "El Khattabi", "Ferre", "Castells", "Falco", "Fernandez", "España", "Didouh", "Garcia"};//Elements:10
  				boolean running = true;
  				String x, element = " "; //element
  				int pos = 0; //posició
  				int numEle = cognoms.length; //comptador d'elements
  				String nomllista;
  				String llista = ""; //nom de la llista
  				int n1 = 0;
  				//String primerDarrer;
  				boolean comprovacioList;// on guardarem el boolea que ens retornarà la funcio llistaBuida
  				Scanner sc = new Scanner(System.in);

  				do {
  						char opc1 = Menu(opcions);

  						switch (opc1) {
  						case 'i': //inserir

  								break;

  						case 'l': //Localitzar
  								if (llistaBuida(cognoms, numEle) == false) {
  										funcLoc(element, cognoms, n1);
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								break;

  						case 'r': //recuperar
  								if (llistaBuida(cognoms, numEle) == false) {
  										funcRecu(demPos(numEle,cognoms), cognoms, n1);
  								} else {
  										System.out.println("No podràs recuperar res. La llista està buida!");
  								}
  								break;

  						case 's'://suprimir
  								if (llistaBuida(cognoms, numEle) == false) {
  										funcSupr(cognoms, demPos(numEle,cognoms),numEle);
  								} else {
  										System.out.println("La llsita està buida!");
  								}
  								break;

  						case 'a': //anul·lar
  								if (llistaBuida(cognoms, numEle) == false) {
  										funcNull(cognoms, n1);
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								break;

  						case 'p': //primerDarrer
  								if (llistaBuida(cognoms, n1) == false) {
  										funcPD(cognoms, numEle);
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								System.out.println();
  								break;

  						case 'm': //imprimir
  								/*comprovem si la llista està buida amb la funció llistaBuida*/
  								if (llistaBuida(cognoms, numEle) == false) {
  										System.out.println();
  										funcImpr(cognoms, pos);
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								System.out.println();
  								break;

  						case 'b': //cas de prova per a comprovar el funcionament de la funció llistaBuida
  								llistaBuida(cognoms, numEle);

  								break;
  						case 'o': //Ordenar
  								if (llistaBuida(cognoms, numEle) == false) {
  										System.out.println();
  										funcOrde(cognoms, n1);
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								System.out.println();
  								break;
  						case 'x':
  								System.out.println("Vinga dw");
  								System.out.println("____________________________________");
  								running = false;
  								break;

  						default:
  								break;
  						}

  				} while (running);

  		}
  }
