import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/count")
public class CountServlet extends HttpServlet {

    public int count = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        String reset = request.getParameter("reset");
        response.setContentType("text/html");
        // This method executes whenever the servlet is hit
        // increment Count
        PrintWriter out = response.getWriter();
        if (reset != null) {
            count = 0;
            out.print(reset);
        }
            count++;
            String title = "<h1>Total Number of Hits " + count + "</h1>";
            out.println(title);

    }
}
