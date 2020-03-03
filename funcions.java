import java.util.Scanner;
public class funcions {

  /**
  		 <h1>GESTIÓ D'UNA LLISTA AMB FUNCIONS</h1>
       Un programa per a gestionar una llista formada
       pels cognoms dels alumnes de la classe.
       Totes les operacions es faran per mitjà de FUNCIONS
       que hem implementat.
       @author Aleix Algueró, Isaac Brull i Marc España
       */



  		/**Funció per a mostrar les opcions i demanar-ne una
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
      * @param nE :int (número d'elements)
      * @param llista : la llista dels cognoms
      * @return un int (la posició escrita per l'usuari)
      * Funció: l'usuari escriurà una posició i si és correcta es guardarà
      "posició" i la funció la retornarà
      */
      public static int demPos(int nE, String[] llista) {
          Scanner sc = new Scanner(System.in);
          System.out.println("Escriu una posició:");
  				int posicio;
          while (true) {
              posicio = sc.nextInt();
              if (posicio >= 0 && posicio <= nE) {
                  break;
              } else {
                  System.out.println("Posició incorrecta. Torna a introduir:");
              }
          }
  				return posicio;
      }

      /**Funció per a demanar l'element
  		 *
  		 * @return element : el String escrit per l'usuari
  		 * Funció: demana un String a l'usuari
  		 */
  		public static String demEle() {
  				Scanner sc = new Scanner(System.in);
          String element ="";
  				do {
  						System.out.println("Introdueix un element: (Sense Comilles)");
  						element = sc.nextLine();
  				} while (element.length() < 1);

  				return element;
  		}

      /**Funció d'INSERIR
      * @param x : aquí es guarda l'"element" que ens retorna la funció anterior (demEle)
      * @param p0 : la posició
      * @param cgnm : la llista
      * @param c : int que utilitzem com a comptador
      * @return int : número d'elements
      * Funció: s'insereix l'element escrit per l'usuari i es borra l'últim
      */
      public static int funcIns(String x, int p0, String[] cgnm, int c) {
        Scanner sc = new Scanner(System.in);
        String siono; /*guardarà la resposta que escrigui l'usuari quan
        se li pregunte si vol borrar l'últim element*/

        if(c==10) { //la llista està plena
            do {
                System.out.println("La llista està plena, vols que borrem l'últim element "+
                "o no efectuar la acció ( si / no ) ?");
                siono = sc.next();
            } while(!(siono.equals("si") || siono.equals("no")));

            if (siono.equals("no")) {
                System.out.println("OK. Imprimint la llista...\n");
            }else{//sobrescrivim l'element d'aquella posició per l'entrat, i movem la resta cap a la dreta
                for (int e = c+1; e>p0; e--) {
                    cgnm[e] = cgnm[e-1];
                }
                cgnm[p0] = x;
            }
        }else{//si la llista no està plena

            for (int e = c; e>p0; e--) {
                cgnm[e] = cgnm[e-1];
            }
            cgnm[p0] = x;
        }

        c++;
        System.out.println(c);
        return c;
      }


  		/**Funció de localitzar element
  		 * @param elem : un string que serà l'element a buscar
       * @param cognoms2 : la llista
       * @param c : número d'elements vàlids
  		 * @return int : la posició de l'element
  		 * Funció: torna la posició en la que es troba l'element, i si no el troba torna ""-1"
  		 */
  		public static int funcLoc(String elem, String[] cognoms2, int c) {

  				for (int i = 0; i < c; i++) {//recorrem la llista

  						if (cognoms2[i].equals(elem)) {

                  return i;
  						}
  				}
  				return -1;
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
  				String z = "";

          for (n = 0; n<=p;n++) { //incrementem la N fins a la posició
  				if (coknoms[p] == null) { //si la posició és nula

              return z;
  				} else if (n == p) {

  						z = coknoms[p];
              return z;
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
  		public static int funcSupr(String[] cogn, int p1,int numEle) {

  						for (int y = p1; y < numEle-1; y++) {
  								cogn[y] = cogn[y + 1];
  						}
  						cogn[numEle-1] = null;
  						numEle--;


  						return numEle;
  		}

      /**Funció de Suprimir dada
       * @param cokn : llista
       * @param elm5 : (String) element que vols suprimir
       * @param numE : número d'elemnts
       * @return String[] : la llista. Imprimir la llista en la ultima posició lliure
       * Funció: Suprimix un element de la llista
       */
       public static int funcSD(String[] cokn, String elm5, int numE) {

         for (int i = 0; i < numE; i++) {
             if (elm5.equals(cokn[i])) {

                 cokn[i] = "";

                 for (int z = i; z < numE - 1; z++) {
                     cokn[z] = cokn[z + 1];
                 }
                 cokn[numE - 1] = null;//borrem l'últim element ja que està copiat
             }

         }

         numE--;



         return numE;
     }


  		/**Funció PrimerDarrer
  		 * @param cogs : la llista
       * @param q : (int) iterador del bucle
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

  						primerDarrer = cogs[0];
            return primerDarrer;

  				} else if (pd.equals("darrer")) {
            for (int i = q-1; i>=0;i--){//comencem a llegir la llista des de darrera
              if (cogs[i]!=null) {
                  primerDarrer = cogs[i];

                  return primerDarrer;
              }

  				}

  		}
      return primerDarrer;
    }

  		/**Funció d'imprimir llista
       * @param cognoms3 : la llista
       * @param compt : un int que indicara l'índex de la llista
  		 * No retorna res : Resultat per pantalla (Void), els elements amb les seves posicions
  		 * Funció: llegeix tota la llista i mostra tots els elements amb la seva posició
  		 */
  		public static void funcImpr(String[] cognoms3, int compt) {

  				for (int i= 0 ; i < compt; i++) {
            if (cognoms3[i]!=null) {

  						System.out.println("L'element " + i + " és " + cognoms3[i] + ".");
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
  		 * @return int : el número d'elements, que sirà 0
  		 * Funció: es convertiran en null tots els elements de la llista
  		 */
  		public static int funcNull(String[] subnom, int nE) {

  				for (int i = 0; i < nE; i++) {
  						subnom[i] = null;

  				}

          nE = 0;
          System.out.println(nE);
  				return nE;
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
  				for (int i = 0; i <= w - 1; i++) {
  						//Compara el primer amb la resta
  						for (int j = i+1; j < w - 1; j++) {
  								//utilitzem compareTO per a que compare les Strings
  								if (cognLlis[j].compareTo(cognLlis[j + 1]) > 0) {
  										cognOrde = cognLlis[j];
  										cognLlis[j] = cognLlis[j + 1];
  										cognLlis[j + 1] = cognOrde;
  								}
  						}
  				}
  				return cognLlis;
  		}


  		/*MAIN*/
  		public static void main(String[] args) {
  				/**
  				 * Variables
  				 */
  				/*array de les opcions del menú, que s'imprimiran per pantalla*/
  				String[] opcions = {"\"i\": Inserir",
  						            "\"l\": Localitzar",
  						            "\"r\": Recuperar",
  						            "\"s\": Suprimir",
  						            "\"d\": SuprimirDada",
  						            "\"a\": Anul·lar",
  						            "\"p\": PrimerDarrer",
  						            "\"m\": Imprimir",
  						            "\"o\": Ordenar",
  						            "\"x\": Sortir"};

  				final int mida = 10;
  				String cognoms[] = new String[mida];
  				boolean running = true;//per al do { } while del switch
  				String x, element = " "; //element
  				int pos = 0; //posició
  				int numEle = 0; //comptador d'elements
  				int n1 = 0; //variable auxiliar
          String PD =""; //primerdarrer
  				Scanner sc = new Scanner(System.in);

  				do {
  						char opc1 = Menu(opcions);

  						switch (opc1) {
  						case 'i': //inserir
              //public static String funcIns(String x, int p0, String[] cgnm, int c)
                x = demEle();//element que ens retorna la funció demEle
                pos = demPos(numEle,cognoms); //posició que retorna la funció demPos
                  numEle = funcIns(x,pos,cognoms,numEle);
                  System.out.println("Imprimint la llista...\n");
                  funcImpr(cognoms,numEle);
              break;

  						case 'l': //Localitzar
  								if (llistaBuida(cognoms, numEle) == false) {
                    element = demEle();
  									n1 = funcLoc(element, cognoms, numEle);
                    if (n1 > -1) {
                      System.out.println("L'element " + element + " es troba a la posició " + n1 + ".");
                    } else { System.out.println("L'element " + element +" no s'ha trobat.");}
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								break;

  						case 'r': //recuperar
  								if (llistaBuida(cognoms, numEle) == false) {
                    pos = demPos(numEle,cognoms);
  									x = funcRecu(pos, cognoms, n1);
                    if (x == null) { System.out.println("La posició " + pos + " està buida.");
                  } else { System.out.println("A la posició " + pos + " es troba l'element: " + cognoms[pos]);
                }
  								} else {
  										System.out.println("No podràs recuperar res. La llista està buida!");
  								}
  								break;

  						case 's'://suprimir
  								if (llistaBuida(cognoms, numEle) == false) {
                    pos = demPos(numEle,cognoms);
  										numEle = funcSupr(cognoms, pos,numEle);
                      //if (cognoms[pos] =)
                      System.out.println("L'element de la posició " + pos + " ha estat eliminat. Desplaçant els elements següents...");
                      funcImpr(cognoms,numEle);
  								} else {
  										System.out.println("La llista està buida!");
  								}

  								break;

                  case 'd': //suprimir dada
                        if (llistaBuida(cognoms, numEle) == false) {
                            x = demEle();
                            numEle = funcSD(cognoms, x, numEle);

                            System.out.println("L'alumne " + x + " s'ha eliminat");
                             System.out.println("Movent les posicions posteriors... \n");
                              funcImpr(cognoms, numEle);
                               System.out.println();
                        } else {
                            System.out.println("La llista està buida!");
                        }
                        break;

  						case 'a': //anul·lar
  								if (llistaBuida(cognoms, numEle) == false) {

                    numEle = funcNull(cognoms, numEle);
                    System.out.println("La llista (cognoms) ha estat buidada.");
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								break;

  						case 'p': //primerDarrer
  								if (llistaBuida(cognoms, numEle) == false) {
  										PD = funcPD(cognoms, numEle);
                        System.out.println(PD);
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								System.out.println();
  								break;

  						case 'm': //imprimir
  								/*comprovem si la llista està buida amb la funció llistaBuida*/
  								if (llistaBuida(cognoms, numEle) == false) {
  										System.out.println();
  										funcImpr(cognoms, numEle);
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								System.out.println();
  								break;

  						case 'o': //Ordenar
  								if (llistaBuida(cognoms, numEle) == false) {
  										System.out.println();
  										funcOrde(cognoms, numEle);
                      //Va imprimint la llista amb els cognoms ordenats i amb el numero davant
                      funcImpr(cognoms, numEle);
  								} else {
  										System.out.println("La llista està buida!");
  								}
  								System.out.println();
  								break;
  						case 'x':
  								System.out.println("Fins la pròxima :)");
  								System.out.println("____________________________________");
  								running = false;
  								break;

  						default:
  								break;
  						}

  				} while (running);

  		}
  }
