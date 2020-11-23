/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package V02_GUI;

import GUI.GUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;

/**
 *
 * @author Delta-Crateris
 */
public class CONSULTA {

    GUI g;
    private String cad = "";

    public CONSULTA(GUI g) {
        this.g = g;
    }

    public void setCadena(String cad) {
        this.cad = cad;
    }

    public String getCadena() {
        return this.cad;
    }

    public void RealizarConsulta() throws FileNotFoundException, IOException, SolrServerException {
        //String fic = fichero;
        // String fic = fichero;
        FileReader file = new FileReader("D:\\Juan Antonio\\Universidad\\Asignaturas\\Universidad 20-21\\MB\\Practicas2021\\V0.2_GUI\\src\\Ejemplos\\LISA.QUE");
        BufferedReader bf = new BufferedReader(file);
        String cadena = "";
        int contador = 1;
        String consulta = "";
        int delimitador = 1;
        String[] CadenaConsulta;

        HttpSolrClient solr = new HttpSolrClient.Builder("http://localhost:8983/solr/ejemploConsulta").build();

        while ((cadena = bf.readLine()) != null) {
            String Contadorcadena = Integer.toString(contador);
            CadenaConsulta = cadena.split(" ");
            //System.out.println(cadena);

            if (cadena.contains(Contadorcadena)) {
                //System.out.println("LINEA PRINCIPAL:" + contador);
                //System.out.println("Linea: " + contador + " contiene");
                /* for (int i = 0; i < CadenaConsulta.length; i++) {
                    System.out.println(CadenaConsulta[i]);

                }*/
                consulta = "";
            } else if (cadena.contains(". #")) {
                // System.out.println("LINEA FINAL");
                // System.out.println("Linea: " + contador + " contiene");
                //System.out.println("LINEA FINAL");
                for (int i = 0; i < CadenaConsulta.length - 1; i++) {
                    // System.out.println(CadenaConsulta[i]);
                    consulta = consulta + CadenaConsulta[i];
                    //  g.MostrarTexto(consulta);
                }

                System.out.println("LA CONSULTA ES:\n" + consulta);
                g.MostrarTexto("LA CONSULTA ES:\n" + consulta + "\n");

                /*SolrQuery query = new SolrQuery();
                query.setQuery("text:" + consulta);
                QueryResponse rsp = solr.query(query);
                SolrDocumentList docs = rsp.getResults();

                System.out.println("\n EL RESULTADO ES:\n");
                g.MostrarTexto("\n EL RESULTADO ES:\n");
                String resultado = "";
                for (int i = 0; i < docs.size(); i++) {
                    System.out.println(docs.get(i));
                    resultado = resultado + docs.get(i);
                }
                g.MostrarTexto(resultado + "\nr");
                System.out.println("\n*******************************\n");*/
                consulta = "";
            } else {

                for (int i = 1; i < CadenaConsulta.length; i++) {
                    //System.out.println(CadenaConsulta[i]);
                    consulta = consulta + " " + CadenaConsulta[i];

                }

            }
            contador++;

        }//fin while

    }
}
