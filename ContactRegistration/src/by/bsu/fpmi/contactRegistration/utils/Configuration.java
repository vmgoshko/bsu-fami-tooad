package by.bsu.fpmi.contactRegistration.utils;


public class Configuration {

    private String contextPath;
    private String xmlStorage;
    private String companyXSLT;
    private String hobbyXSLT;
    private String succsssXSLT;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getXmlStorage() {
        return xmlStorage;
    }

    public void setXmlStorage(String xmlStorage) {
        this.xmlStorage = xmlStorage;
    }

    public String getCompanyXSLT() {
        return companyXSLT;
    }

    public void setCompanyXSLT(String companyXSLT) {
        this.companyXSLT = companyXSLT;
    }

    public String getHobbyXSLT() {
        return hobbyXSLT;
    }

    public void setHobbyXSLT(String hobbyXSLT) {
        this.hobbyXSLT = hobbyXSLT;
    }

    public String getSuccsssXSLT() {
        return succsssXSLT;
    }

    public void setSuccsssXSLT(String succsssXSLT) {
        this.succsssXSLT = succsssXSLT;
    }
}
