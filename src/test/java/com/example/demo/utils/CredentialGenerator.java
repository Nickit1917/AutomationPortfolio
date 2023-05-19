package com.example.demo.utils;

import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

//This has been implemented following the DOM method of parsing. It might be more efficient to try the SAX method in the future.
//
//
//For attention
public class CredentialGenerator {

    //Sets the base directory for the current deployment
    private static final String baseDir = System.getProperty("user.dir");

    //2D array of test credentials for BasicAuthTest.java
    @DataProvider(name = "basicAuth")
    public static Object[][] credentialParser(String dataPath) throws Exception{
        File inputFile = new File(baseDir + dataPath);
        // Create a new DocumentBuilderFactory and DocumentBuilder to parse the XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parse the XML file and normalize the document
        Document doc = builder.parse(inputFile);
        doc.getDocumentElement().normalize();
        // Get all the "credential" nodes in the XML file
        NodeList nodeList = doc.getElementsByTagName("credential");
        // Define a 2D array to hold the test data, with a row for each testcase and columns for the username and password
        Object[][] creds = new Object[nodeList.getLength()][2];
        // Iterate over each credential node
        for (int i=0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            // Check if the node is an element node
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                // Get the value of the "username" and "password" elements for the current credential pair and store them in the data array
                creds[i][0] = element.getElementsByTagName("username").item(0).getTextContent();
                creds[i][1] = element.getElementsByTagName("password").item(0).getTextContent();
            }

        }
        //Return Basic Auth Credentials
        return creds;
    }
    @DataProvider(name = "invalidCreds")
    public static Object[][] getInvalidCreds() throws Exception{
        return credentialParser("/src/test/java/com/example/demo/resources/InvalidAuthCredentials.xml");
    }

    @DataProvider(name = "validCreds")
    public static Object[][] getValidCreds() throws Exception{
        return credentialParser("/src/test/java/com/example/demo/resources/ValidAuthCredentials.xml");
    }
}
