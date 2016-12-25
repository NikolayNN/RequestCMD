package my.nhorushko.requestcmd.pr.model.store;

import my.nhorushko.requestcmd.pr.model.Request;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Nikol on 12/18/2016.
 */
public class XmlManagerTest {
    private XMLFile xmlFile;
    private XmlManager manager;
    private Request testRequest1 = new Request("testName1", "testDescription1", new Date());
    private Request testRequest2 = new Request("testName2", "testDescription2", new Date());
    private Request testUpdateRequest = new Request("updRequest", "updDescription", new Date());
    private List<Request> requestList;

    @Before
    public void setup(){
        xmlFile = mock(XMLFile.class);
        manager = new XmlManager(xmlFile);
        requestList = new ArrayList<>();
        requestList.add(testRequest1);
        requestList.add(testRequest2);
    }

    @Test
    public void addRequest() {
        //given
        when(xmlFile.readXMLFile()).thenReturn(new ArrayList<Request>());
        ArrayList expected = new ArrayList();
        expected.add(testRequest1);

        //when
        manager.addRequest(testRequest1);

        //then
        verify(xmlFile).writeXMLFile(expected);
    }

    @Test
    public void deleteRequest(){
        //given
        when(xmlFile.readXMLFile()).thenReturn(requestList);
        List<Request> expected = new ArrayList<>();
        expected.add(testRequest2);
        //when
        manager.deleteRequest(testRequest1.getName());
        //then
        verify(xmlFile).writeXMLFile(expected);
    }
    @Test(expected = RuntimeException.class)
    public void deleteRequestWrongRequestName(){
        //given
        when(xmlFile.readXMLFile()).thenReturn(requestList);
        //when
        manager.deleteRequest("wrong name");
    }

    @Test
    public void updateRequest(){
        //given
        when(xmlFile.readXMLFile()).thenReturn(requestList);
        List<Request> expected = new ArrayList<>();
        expected.add(testRequest2);
        expected.add(testUpdateRequest);
        //when
        manager.updateRequest(testRequest1.getName(), testUpdateRequest);
        //then
        assertEquals(expected, manager.receiveRequests());
    }

    @Test
    public void receiveRequest(){
        when(xmlFile.readXMLFile()).thenReturn(requestList);
        assertEquals(testRequest1, manager.receiveRequest(testRequest1.getName()));
    }

    @Test
    public void receiveRequests(){
        when(xmlFile.readXMLFile()).thenReturn(requestList);
        assertEquals(requestList, manager.receiveRequests());
    }

    @Test
    public void addComment(){
        //given
        when(xmlFile.readXMLFile()).thenReturn(requestList);
        //when
        manager.addComment(testRequest1.getName(), "testComment");
        //then
        verify(xmlFile).writeXMLFile(requestList);
    }








}