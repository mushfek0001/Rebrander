package net.therap.rebrander.parser;

import net.therap.rebrander.filehandler.XmlFileHandler;
import net.therap.rebrander.customexceptions.RebrandingExceptions;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: mushfekur
 * Date: 9/26/13
 * Time: 9:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class XmlParsingHandler implements ParsingHandler {
    private XmlFileHandler xmlFileHandler;
    private File file;
    private DocumentBuilder documentBuilder;
    private Document document;

    public XmlParsingHandler() {
    }

    public XmlParsingHandler(String filePath) {
        this.xmlFileHandler = new XmlFileHandler(filePath);
        xmlFileHandler.loadFile();
    }

    public void setDocumentBuilder() {
        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.documentBuilder = dBuilder;
        } catch (Exception e) {
            new RebrandingExceptions("Exception while setting DocumentBuilder." + e);
        }
    }

    public void setDocument() {
        try {
            Document doc = documentBuilder.parse(xmlFileHandler.getFile());
            doc.getDocumentElement().normalize();
            xmlFileHandler.setDocument(doc);
            this.document = doc;
        } catch (Exception e) {
            new RebrandingExceptions("Exception while setting Document." + e);
        }
    }

    public XmlFileHandler getXmlFileHandler() {
        return xmlFileHandler;
    }

    public void setXmlFileHandler(XmlFileHandler xmlFileHandler) {
        this.xmlFileHandler = xmlFileHandler;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}