package es.mcg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import es.mcg.data.Competition;
import es.mcg.errors.CompetitionsError;

public class CompetitionsStatsBomb {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) throws CompetitionsError {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        File file = null, file2 = null;
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        List<Competition> competitionsData = null;
        Competition competition = null;

        try 
        {
            file = new File("competitions.xml");
            file2 = new File("competiciones.txt");
            fileWriter = new FileWriter(file2);
            printWriter = new PrintWriter(fileWriter);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element rootElement = document.getDocumentElement();
            NodeList nodeListCompetition = rootElement.getElementsByTagName("competition");
            competitionsData = new ArrayList<Competition>();
            for(int i = 0; i < nodeListCompetition.getLength(); i++)
            {
                competition = new Competition();

                Element nodeCompetition = (Element) nodeListCompetition.item(i);

                competition.setCompetition_id(Integer.valueOf(nodeCompetition.getElementsByTagName("competition_id").item(0).getTextContent()));
                competition.setSeason_id(Integer.valueOf(nodeCompetition.getElementsByTagName("season_id").item(0).getTextContent()));
                competition.setCountry_name(nodeCompetition.getElementsByTagName("competition_name").item(0).getTextContent());
                competition.setCompetition_name(nodeCompetition.getElementsByTagName("competition_name").item(0).getTextContent());
                competition.setCompetition_gender(nodeCompetition.getElementsByTagName("competition_gender").item(0).getTextContent());
                competition.setCompetition_youth(Boolean.valueOf(nodeCompetition.getElementsByTagName("competition_youth").item(0).getTextContent()));
                competition.setCompetition_international(Boolean.valueOf(nodeCompetition.getElementsByTagName("competition_international").item(0).getTextContent()));
                competition.setSeason_name(nodeCompetition.getElementsByTagName("season_name").item(0).getTextContent());
                String match_updated = nodeCompetition.getElementsByTagName("match_updated").item(0).getTextContent();
                String match_updated_360 = nodeCompetition.getElementsByTagName("match_updated_360").item(0).getTextContent();
                String match_available_360 = nodeCompetition.getElementsByTagName("match_available_360").item(0).getTextContent();
                String match_available = nodeCompetition.getElementsByTagName("match_available").item(0).getTextContent();
                competition.setMatch_updated(LocalDateTime.parse(match_updated));
                competition.setMatch_updated_360(LocalDateTime.parse(match_updated_360));
                if(match_available_360 == null || match_available_360.equals(""))
                {
                    competition.setMatch_available_360(null);
                }
                else
                {
                    competition.setMatch_available_360(LocalDateTime.parse(match_available_360));
                }
                competition.setMatch_available(LocalDateTime.parse(match_available));

                competitionsData.add(competition);
            }
            printWriter.println("Nombre de las competiciones femeninas: {");
            for(int i = 0; i < competitionsData.size(); i++)
            {
                if(competitionsData.get(i).getCompetition_gender().equals("female"))
                {
                    printWriter.println(competitionsData.get(i).getCompetition_name());
                }
            }
            printWriter.println("}");
            printWriter.println("Nombre de las competiciones que realizan en Europa y son internacionales: {");
            for(int i = 0; i < competitionsData.size(); i++)
            {
                if(competitionsData.get(i).getCountry_name().equals("Europe") && competitionsData.get(i).getCompetition_international())
                {
                    printWriter.println(competitionsData.get(i).getCompetition_name());
                }
            }
            printWriter.println("}");
            printWriter.println("Nombre de las competiciones que tienen partidos disponibles 360: {");
            for(int i = 0; i < competitionsData.size(); i++)
            {
                if(competitionsData.get(i).getMatch_available_360() != null)
                {
                    printWriter.println(competitionsData.get(i).getCompetition_name());
                }
            }
            printWriter.println("}");
        }
        catch (ParserConfigurationException | SAXException | IOException xmlException) 
        {
            LOGGER.error("Ha ocurrido durante el parseo de los datos del fichero XML");
            throw new CompetitionsError("El proceso se ha detenido inesperadamente debido a un error", xmlException);
        }
        finally
        {
            if(printWriter != null)
            {
                printWriter.close();
            }
            if(fileWriter != null)
            {
                try 
                {
                    fileWriter.close();    
                } 
                catch (IOException ioException) 
                {
                    throw new CompetitionsError("No se ha podido cerrar el flujo de escritura del fichero", ioException);
                }
            }
        }
    }
}
