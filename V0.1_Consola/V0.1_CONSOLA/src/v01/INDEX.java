/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v01;


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
    private int cont = 1;


    public void indexar() throws SolrServerException, IOException {
       
        FileReader file = new FileReader("D:\\Juan Antonio\\Universidad\\Asignaturas\\Universidad 20-21\\MB\\Practicas2021\\P1_Consola\\Practica1\\src\\Ejemplos\\LISA0.001");
        BufferedReader bf = new BufferedReader(file);

        String cadena = "";

        /**
         * ESTRUCTURA DEL TEXTO: DOCUMENTesp+esp+esp+esp+NUM_DOCUMENTO
         * TITULO_TEXTO
         *
         * TEXTO ********************************************-> DELIMITADOR
         * TEXTOS
         */
        /**
         * DELIMITADORES: Del_Documento= "DOCUMENT ";
         *
         */
        int i = 1;
        String asteriscos = "********************************************";
        int j = 0;

        while ((cadena = bf.readLine()) != null) {
            //System.out.println("Cadena contiene: "+cadena + "\n");
            if (j == 0 && cont == 1) {
                Documento = Documento + cadena;
                
            }
            if (((j == 1) || j == 2 || cadena.contentEquals(".")) && cont == 1) {
                Titulo = Titulo + cadena;
              
            }

            if (((j > 2) && (!cadena.equals(asteriscos))) && cont == 1) {
                Texto = Texto + cadena;
                
            }

            if (j == 1 && cont > 1) {
                Documento = Documento + cadena;
                
            }
            if (((j == 2) || j == 3 || cadena.contentEquals(".")) && cont > 1) {
                Titulo = Titulo + cadena;
                
            }

            if (((j > 3) && (!cadena.equals(asteriscos))) && cont > 1) {
                Texto = Texto + cadena;
                
            }
            if (cadena.equals("********************************************")) {
                j = 0;

                /*Mostrando texto modo consola*/
                System.out.println("CONSOLA");
                System.out.println("\nDocumento :" + Documento);
                System.out.println("\nTitulo: " + Titulo);
                System.out.println("\nTexto: " + Texto);
                System.out.println("\n********************************************\n");
                System.out.println("Indexando documento:" + cont + "\n");




                //Sentencias para acceder a Solr e indexar
                 HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr/Practica1").build();
                SolrInputDocument doc = new SolrInputDocument();
                doc.addField("Documento", Documento);
                doc.addField("Titulo", Titulo);
                doc.addField("Texto", Texto);
                solr.add(doc);
                solr.commit();
                solr.close();
                System.out.println("Documento :" + cont + " indexado con éxito\n");
                System.out.println("********************************************");


                
                Documento = "";
                Titulo = "";
                Texto = "";
                cont++;

            }
            j++;

        }
    }
    
    

}
