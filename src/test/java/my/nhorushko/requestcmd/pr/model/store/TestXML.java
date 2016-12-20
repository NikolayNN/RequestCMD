package my.nhorushko.requestcmd.pr.model.store;

import com.thoughtworks.xstream.XStream;
import my.nhorushko.requestcmd.pr.model.Request;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nikol on 12/18/2016.
 */
public class TestXML {
    private final String FILE_NAME = "test_xml_987";
    private File testXMLFile;
    private Request testRequest1;
    private Request testRequest2;
    private List<Request> requests;

    public TestXML() {
        testRequest1 = new Request("testName1", "testDescription1", new Date(1482049021000l));
        testRequest2 = new Request("testName2", "testDescription2", new Date(1482020021000l));
        requests = new ArrayList<>();
        requests.add(testRequest1);
        requests.add(testRequest2);
        testXMLFile = new File(FILE_NAME);
    }

    public void createFile(){
        XStream xStream = new XStream();
        try (FileOutputStream fs = new FileOutputStream(FILE_NAME)){
            xStream.toXML(requests, fs);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<Request> readFile(){
        XStream xStream = new XStream();
        List<Request> result = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(FILE_NAME)){
            if(fis.available() == 0){
                return result;
            }
            result = (List<Request>) xStream.fromXML(fis, result);
        }catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void deleteFile(){
        testXMLFile.delete();
    }
}
