package directoryControls;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class NVTC_BIGDATA_DIRECTORYServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		resp.getWriter().println("<h1>How is it going world?! this site is under construction</h1>");
	}
}