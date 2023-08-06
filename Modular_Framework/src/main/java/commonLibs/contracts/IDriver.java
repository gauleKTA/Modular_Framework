package commonLibs.contracts;
//Interface is like blueprint of class that defines abstract methods
//All the methods inside interface are called abstract methods.
//These abstract methods only have deceleration here. Implementation has been done in different package.
public interface IDriver {
public void navigateToFirstUrl(String url) throws Exception;
public String getTitle() throws Exception;
public String getCurrentUrl() throws Exception;
public String getPageSource() throws Exception;
public void navigateToURL(String url) throws Exception;
public void navigateForward() throws Exception;
public void navigateBackward() throws Exception;
public void refresh() throws Exception;
public void closeBrowser() throws Exception;
public void closeAllBrowser() throws Exception;
}
