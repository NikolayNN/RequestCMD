package my.nhorushko.requestcmd.pr.model.store;

import my.nhorushko.requestcmd.pr.model.Request;
import my.nhorushko.requestcmd.pr.model.requestfilters.RequestFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikol on 12/17/2016.
 */
public class XmlManager implements Storeable {
    XMLFile xmlFile;
    List<Request> requests;

    public XmlManager(XMLFile xmlFile) {
        this.xmlFile = xmlFile;
        requests = new ArrayList<>();
    }

    public void addRequest(Request request) {
        requests = xmlFile.readXMLFile();
        requests.add(request);
        xmlFile.writeXMLFile(requests);
    }

    public void updateRequest(Request oldRequest, Request newRequest) {
        requests = xmlFile.readXMLFile();
        deleteRequest(oldRequest.getName());
        addRequest(newRequest);
        xmlFile.writeXMLFile(requests);
    }

    private Request findRequestByName(String name) {
        for (Request request : requests) {
            if(request.getName().equalsIgnoreCase(name)){
                return request;
            }
        }
        throw  new  RuntimeException("ERROR. Request with name '" + name + "'" + " can't found");
    }

    public void deleteRequest(String name) {
        requests = xmlFile.readXMLFile();
        requests.remove(findRequestByName(name));
        xmlFile.writeXMLFile(requests);
    }

    public List<Request> receiveRequests() {
        requests = xmlFile.readXMLFile();
        return requests;
    }

    public Request receiveRequest(String name) {
        requests = xmlFile.readXMLFile();
        return findRequestByName(name);
    }

    public List<Request> receiveRequestWith(String condition) {
        requests = xmlFile.readXMLFile();
        for (Request request : requests) {

        }
        return null;
    }

    public void addComment(String name, String comment) {
        requests = xmlFile.readXMLFile();
        findRequestByName(name).addComment(comment);
        xmlFile.writeXMLFile(requests);
    }
}
