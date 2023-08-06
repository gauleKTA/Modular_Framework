package commonLibs.contracts;

import java.util.Set;

public interface IWindow {
	public void switchToAnyWindow(String windowhandle) throws Exception;

	public void switchToAnyWindow(int chidWindowIndex) throws Exception;

	public String getWindowhandle() throws Exception;

	public Set<String> getWindowHandels() throws Exception;
}
