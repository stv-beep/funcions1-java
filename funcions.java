import java.util.Scanner;
public class funcions {

  /**
  		 *<h1>GESTIÓ D'UNA LLISTA AMB FUNCIONS</h1>
       *Un programa per a gestionar una llista formada
       pels cognoms dels alumnes de la classe.
       Totes les operacions es faran per mitjà de FUNCIONS
       que hem implementat.
       @author Aleix Algueró, Isaac Brull i Marc España
       */

       

  		/**
       * Funció per a mostrar les opcions i demanar-ne una
   		 * @param opcions1 : la llista de les opcions
  		 * @return opc : un char, escrit per l'usuari
  		 * Funció: Mostra opcions per pantalla,
       * recull quina opció escull l'usuari que haurà
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

  		/**Funció per a demanar la posició
      * @param  numEle :int (número d'elements)
      * @param llista : la llista dels cognoms
      * @return un int (la posició escrita per l'usuari)
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

      /**Funció per a demanar l'element
  		 * @param element : element que escriura el user
  		 * @return element : el String escrit per l'usuari
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

      /**Funció d'INSERIR
      * @param x : aquí es guarda l'"element" que ens retorna la funció anterior
      * @param p0 : la posició
      * @param cgnm : la llista
      * @param c : int que utilitzem per als bucles
      * @return String : la llista
      * Funció: s'insereix l'element escrit per l'usuari i es borra l'últim
      */
      public static String funcIns(String x, int p0, String[] cgnm, int c) {
        Scanner sc = new Scanner(System.in);
        String xd = "";//el que retornarà la Funció
        String siono;
        for (c =0; c<cgnm.length;c++) {
          if (cgnm[c]!=null) {
            c++;
          }
        }

        if(c==cgnm.length) {
            do {
                System.out.println("La llista esta plena, vols que borrem l'ultim element \" "+cgnm[cgnm.length-1]+" \" o no efectuar la acció ( si / no ) ?");
                siono = sc.nextLine();
            } while(!(siono.equals("si") || siono.equals("no")));

            if (siono.equals("no")) {
                System.out.println("OK");

            }else{
                for (int e = c-1; e>p0; e--) {
                    cgnm[e] = cgnm[e-1];
                }
                cgnm[p0] = x;
            }
        }else{
            for (int e = c; e>p0; e--) {
                cgnm[e] = cgnm[e-1];
            }
            cgnm[p0] = x;
        }

        for(int e = 0; e<c-1; e++) {
          System.out.println(cgnm[e]);
          xd = cgnm[e];
        }

        return xd;
      }


  		/**Funció de localitzar element

  		 * @param elem : un string que serà l'element a buscar
       * @param cognoms2 : la llista
       * @param i : un int amb el que recorrerem la llista
  		 * @return int : la posició de l'element
  		 * Funció: trobar a quina posició està l'element entrat per l'usuari
  		 */
  		public static int funcLoc(String elem, String[] cognoms2, int i) {
  				Scanner sc = new Scanner(System.in);
  				int loc = 0;
  				/*Preguntem l'element*/
  				elem = demEle(elem);

  				for (i = 0; i < cognoms2.length-1; i++) {//recorrem la llista

  						if (cognoms2[i] != null && cognoms2[i].equals(elem)) {
  								System.out.println("L'element " + elem + " es troba a la posició " + i + ".");

  						} else if (i >= cognoms2.length-1) {
  								System.out.println("L'element " + elem + " no es troba a la llista cognoms.");
  						}
  						loc = i;
  				}
  				return loc;
  		}

  		/**Funció de recuperar element
  		 * @param p : un int que determinarà la posició a buscar
       * @param coknoms : la llista
       * @param n : int com a iterador del bucle per a incrementar-se fins a la posició
  		 * @return String : retornarà l'element i a part, s'imprimirà per pantalla l'element que està a la posició p
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


  		/**Funció de Suprimir
       * @param cogn : llista
       * @param p1 : (int) la posició
       * @param numEle : número d'elemnts
  		 * @return String[] : la llista. Imprimir la llista en la ultima posició lliure
  		 * Funció: Suprimix un element de la llista
  		 */
  		public static String[] funcSupr(String[] cogn, int p1,int numEle) {

  						for (int y = p1; y < numEle-1; y++) {
  								cogn[y] = cogn[y + 1];
  						}
  						cogn[numEle-1] = null;
  						numEle--;
  						System.out.println("L'element de la posició " + p1 + " ha estat eliminat");
  						funcImpr(cogn,numEle);
  						return cogn;
  		}

  		/**Funció PrimerDarrer
  		 * @param cogs : la llista
       * @param q : (int)
  		 * @return String . l'element en la posició triada (String) i imprimit per pantalla
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

  		/**Funció d'imprimir llista
       * @param cognoms3 : la llista
       * @param p3 : un int que indicara l'índex de la llista
  		 * @return : Resultat per pantalla (Void), els elements amb les seves posicions
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

  		/**Funció per a saber si la llista està buida o no
  		 * @param cognomsl : la llista
       * @param num_elements  : (int) el comptador d'elements de la llista
  		 * @return boolean : un booleà que ens dirà si la llista està buida (true) o no (false)
  		 * FUNCIÓ: inidicarà si a la llista hi ha valors o no, comptant-los
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

  		/**Funció ANULAR
  		 * @param subnom : la llista dels cognoms
       * @param nE : int del número d'elements
  		 * @return String[] : la llista, i un missatge per pantalla dient que la llista ha estat buidada
  		 * Funció: es convertiran en null tots els elements de la llista
  		 */
  		public static String[] funcNull(String[] subnom, int nE) {
  				nE = 0;
  				for (String e : subnom) {
  						if (e != null) {
  								nE++;
  						}
  				}

  				for (int i = 0; i < nE; i++) {
  						subnom[i] = null;
  				}
  				System.out.println("La llista (cognoms) ha estat buidada.");
  				for (String e : subnom) {
  						if (e != null) {
  								nE++;
  								System.out.print(e);
  						}
  				}
  				return subnom;
  		}

  		/**Funció ORDENAR
       * @param cognLlis : la llista
       * @param w : int per a recorrer la llista al imprimir
  		 * @return String[] : la llista d'elements ordenada alfabeticament
  		 * Funció: s'ordenaran alfabeticament tots els element de la llista,
       * comparant-se entre ells.
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
              //public static String funcIns(String x, int p0, String[] cgnm, int c)
                  funcIns(demEle(element),demPos(numEle,cognoms),cognoms,n1);
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
