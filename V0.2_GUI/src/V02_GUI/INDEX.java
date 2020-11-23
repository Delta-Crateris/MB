/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V02_GUI;

import GUI.GUI;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

public class INDEX {

    private String Documento = "";
    private String Titulo = "";
    private String Texto = "";
    private String Cadena = "";
    private int cont = 1;
    GUI g;

    public INDEX(GUI g) {
        this.g = g;
    }

    public void setCadena(String cad) {
        Cadena = cad;
    }

    public String getCadena() {
        return Cadena;
    }

    public String getDocumento() {

        return Documento;

    }

    public void setDocumento(String D) {
        Documento = D;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Te) {
        Texto = Te;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Ti) {
        Titulo = Ti;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int c) {
        cont = c;
    }

    public void enviarcadena() {
        String cadena = "";
        /* System.out.println("CONSOLA");
        System.out.println("\nDocumento :" + Documento);
        System.out.println("\nTitulo: " + Titulo);
        System.out.println("\nTexto: " + Texto);
        System.out.println("\n********************************************\n");
        System.out.println("Indexando documento:" + cont + "\n");
        System.out.println("Documento :" + cont + " indexado con éxito\n");
        System.out.println("********************************************");
         */

        cadena = ("\nDocumento :" + getDocumento());
        cadena = cadena + ("\nTitulo: " + getTitulo());
        cadena = cadena + ("\nTexto: " + getTexto());
        cadena = cadena + ("\n------------------------------------------------------\n");
        cadena = cadena + ("Indexando documento:" + getCont() + "\n");
        cadena = cadena + ("Documento :" + getCont() + " indexado con éxito\n");
        cadena = cadena + ("********************************************");
        setCadena(cadena);
    }

    /**
     *
     * @param fichero
     * @throws SolrServerException
     * @throws IOException
     *
     * Método al que se le pasa un string "fichero" con la ruta del fichero a
     * indexar. Se crea un buffer que lee línea por linea ese fichero. Se hacen
     * una serie de comprobaciones para saber si es el primer documento del
     * fichero, o si es documento diferente al primero. Se sigue in patrón para
     * indexar y mostrar en la GUI el contenido del fichero. El patrón sigue la
     * estructura que se detalla a continuación.
     */
    /**
     * ESTRUCTURA DEL TEXTO: DOCUMENTesp+esp+esp+esp+NUM_DOCUMENTO TITULO_TEXTO
     *
     * TEXTO ********************************************-> DELIMITADOR TEXTOS
     */
    /**
     * DELIMITADORES: Del_Documento= "DOCUMENT ";
     *
     * @throws org.apache.solr.client.solrj.SolrServerException
     */
    public void indexar(String fichero) throws SolrServerException, IOException {
        HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr/ejemploConsulta").build();
        String fic = fichero;
        // String fic = fichero;
        FileReader file = new FileReader(fic);
        BufferedReader bf = new BufferedReader(file);

        String cadena = "";

        int i = 1;
        String asteriscos = "********************************************";
        int j = 0;

        while ((cadena = bf.readLine()) != null) {
            //System.out.println("Cadena contiene: "+cadena + "\n");
            if (j == 0 && cont == 1) {
                Documento = Documento + cadena;
                setDocumento(Documento);
            }
            if (((j == 1) || j == 2 || cadena.contentEquals(".")) && cont == 1) {
                Titulo = Titulo + cadena;
                setDocumento(Titulo);
            }

            if (((j > 2) && (!cadena.equals(asteriscos))) && cont == 1) {
                Texto = Texto + cadena;
                setTexto(Texto);
            }

            if (j == 1 && cont > 1) {
                Documento = Documento + cadena;
                setDocumento(Documento);
            }
            if (((j == 2) || j == 3 || cadena.contentEquals(".")) && cont > 1) {
                Titulo = Titulo + cadena;
                setDocumento(Titulo);
            }

            if (((j > 3) && (!cadena.equals(asteriscos))) && cont > 1) {
                Texto = Texto + cadena;
                setTexto(Texto);
            }
            if (cadena.equals("********************************************")) {
                j = 0;

                /*Mostrando texto modo consola*/
               // System.out.println("CONSOLA");
                System.out.println("\nDocumento :" + Documento);
                System.out.println("\nTitulo: " + Titulo);
                System.out.println("\nTexto: " + Texto);
                System.out.println("\n********************************************\n");
                System.out.println("Indexando documento:" + cont + "\n");
                enviarcadena();
                g.MostrarTexto2(getCadena());

                /*Mostrando texto modo GUI*/
                //System.out.println("GUI");
                //
                //Sentencias para acceder a Solr e indexar
                SolrInputDocument doc = new SolrInputDocument();
                doc.addField("Documento", Documento);
                doc.addField("Titulo", Titulo);
                doc.addField("Texto", Texto);
                solr.add(doc);
                solr.commit();
                //solr.close();*/
                /*System.out.println("Documento :" + cont + " indexado con éxito\n");
                System.out.println("********************************************");*/
                Documento = "";
                Titulo = "";
                Texto = "";
                cont++;
                setCont(cont);
            }
            j++;

        }

        solr.close(); //Cerramos la conexión con Solr.
    }

}
