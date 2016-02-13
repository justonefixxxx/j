package com.levelup.cr.dao.fs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 8/17/13
 * Time: 11:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class FSNodeAccessor {

    public final static String PROPERTIES_EXTENSION = ".properties";
    public final static String NODELIST_EXTENSION = ".nodelist";

    private String ROOT_DIRECTORY;
    private String nodeName;
    private String path;
    private File nodeDirectory;
    private File nodelistFile;
    private File propertiesFile;
    private Boolean isInitialized;


    public FSNodeAccessor() {

    }

    public boolean init() throws IOException {
        if (ROOT_DIRECTORY!=null || path==null || nodeName==null || nodeName.isEmpty()){
            return false;
        }
        File parentDirectory =new File(ROOT_DIRECTORY+File.pathSeparator+path);
        if (!parentDirectory.exists()) {
            throw new FileNotFoundException("Parent directory doesn't exist!");
        }
        nodeDirectory = new File(ROOT_DIRECTORY+File.pathSeparator+path+File.pathSeparator+nodeName);
        if (nodeDirectory.exists() && !nodeDirectory.isDirectory()) {
            return false;
        }
        if (!nodeDirectory.exists()){
            nodeDirectory.mkdir();
        }
        nodelistFile = new File(ROOT_DIRECTORY+File.pathSeparator+path+File.pathSeparator+nodeName
                +File.pathSeparator+nodeName+NODELIST_EXTENSION);
        if (!nodelistFile.exists()){
            nodelistFile.createNewFile();
        }

        propertiesFile = new File(ROOT_DIRECTORY+File.pathSeparator+path+File.pathSeparator+nodeName
                +File.pathSeparator+nodeName+PROPERTIES_EXTENSION);
        if (!propertiesFile.exists()){
            propertiesFile.createNewFile();
        }
        return true;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getNodeDirectory() {
        return nodeDirectory;
    }

    public void setNodeDirectory(File nodeDirectory) {
        this.nodeDirectory = nodeDirectory;
    }

    public File getNodelistFile() {
        return nodelistFile;
    }

    public void setNodelistFile(File nodelistFile) {
        this.nodelistFile = nodelistFile;
    }

    public File getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(File propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

    public Boolean getInitialized() {
        return isInitialized;
    }

    public void setInitialized(Boolean initialized) {
        isInitialized = initialized;
    }
}
