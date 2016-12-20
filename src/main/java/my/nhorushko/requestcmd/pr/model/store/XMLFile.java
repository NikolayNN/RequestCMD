package my.nhorushko.requestcmd.pr.model.store;

import com.thoughtworks.xstream.XStream;
import my.nhorushko.requestcmd.pr.model.Request;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikol on 12/18/2016.
 */
public class XMLFile {
    public String fileName;

    public XMLFile(String fileName) {
        this.fileName = fileName;
    }

    public List<Request> readXMLFile() {
        XStream xStream = new XStream();
        List<Request> result = new ArrayList<>();
        try(FileInputStream fis = getFileInputStream(fileName)){
            if(fis.available() == 0){
                return result;
            }
            result = (List<Request>) xStream.fromXML(fis, result);
        }catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return result;
    }

    public FileInputStream getFileInputStream(String fileName) throws FileNotFoundException {
        return new FileInputStream(fileName);
    }

    public void writeXMLFile(List<Request> requests){
        XStream xStream = new XStream();
        try (FileOutputStream fs = getFileOutputStream(fileName)){
            xStream.toXML(requests, fs);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public FileOutputStream getFileOutputStream(String fileName) throws FileNotFoundException {
        return new FileOutputStream(fileName);
    }
}
