package gov.noaa;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * The type Jaxbxmlto java.
 */
public class JAXBXMLToJava {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args) {

        try {

            System.out.println("Result: " + args);

            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            // specify the location and name of xml file to be read
            //File XMLfile = new File("<?xml version='1.0'?><dwml version='1.0' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='https://graphical.weather.gov/xml/DWMLgen/schema/DWML.xsd'><latLonList>43.1866,-89.452</latLonList></dwml>");

            // this will create Java object - dwmlType from the XML file
            //DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(XMLfile);
            DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(args));

            System.out.println("Lat/Long.....: " + dwml.getLatLonList());


        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

    }
}