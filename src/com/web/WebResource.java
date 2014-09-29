package com.web;

import com.util.ClassUtil;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.net.URL;

/**
 * @author ksipe
 */
public class WebResource {

    private Class webinfLibClass;
    private File webRoot;


    /**
     * This only works if the class that is being referenced is from a jar in the WEB-INF/lib directory
     *
     * @param webinfLibClass
     */
    public WebResource(Class webinfLibClass) {
        this.webinfLibClass = webinfLibClass;
    }

    /**
     * expects a resource relative to webroot such as static/common/reset.css and will return true if it exists
     *
     * @param resource
     * @return
     */
    public boolean exists(String resource) {
        boolean exists = false;
        if (webRoot == null) {
            webRoot = getWebRootFromWebInfLibClass(webinfLibClass);
        }
        if (webRoot != null) {
            File resourceFile = new File(webRoot, resource);
            exists = resourceFile.exists();
        }
        return exists;
    }

    /**
     * intended to be handed a class that is from a jar that is in the WEB-INF/lib directory
     * It provides the webroot of the web application.
     *
     * @param clazz
     * @return
     */
    public File getWebRootFromWebInfLibClass(Class clazz) {
        String dirName = null;
        try {
            dirName = getWebRootName(clazz);
        } catch (Exception e) {
        }
        return dirName == null ? null : new File(dirName);
    }

    public String getWebRootName(Class clazz) {
        String classFileName = ClassUtil.getFileName(clazz);
        StringBuilder classFile = new StringBuilder(classFileName).append(".class");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(classFile.toString());
        return parseWebRootLocation(url.getFile());
    }

    private String parseWebRootLocation(String fileRoot) {
        String fileName = "";
        if (StringUtils.isNotBlank(fileRoot) && fileRoot.contains("/WEB-INF/")) {
            fileName = fileRoot.substring(0, fileRoot.indexOf("/WEB-INF/"));

            if (StringUtils.isNotBlank(fileName)) {
                final String filePrefix = "file:";
                if (fileName.contains(filePrefix)) {
                    fileName = fileName.substring(filePrefix.length());
                }
            }
        }
        return fileName;
    }
}
