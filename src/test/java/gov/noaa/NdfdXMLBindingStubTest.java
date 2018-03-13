package gov.noaa;

import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class NdfdXMLBindingStubTest {

    @Test
    void latLonListZipCode() throws Exception {

        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String results = binding.latLonListZipCode("53597");

        String results2 = binding.latLonListZipCode("53503");

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        DwmlType latlong = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(results));

        assertEquals("43.1866,-89.452", latlong.getLatLonList());

        DwmlType latlong2 = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(results2));

        assertEquals("43.1633,-89.9132", latlong2.getLatLonList());

    }
}