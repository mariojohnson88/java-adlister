import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Here we annotate the class with "@WebServlet" to specify the URL it maps to. This is also one of three things needed to create a servlet. EX: http://localhost:8080/hello
@WebServlet("/hello")
//Here our class extends "HttpServlet" this is one of three things needed to create a servlet
public class HelloWorldServlet extends HttpServlet {
    //Implement a protected doGet and/or doPost method that accepts two parameters: HttpServletRequest, and HttpServletResponse. Again one of three things need to create a servlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html");
//        Put the value of getWriter in a variable PrintWriter, which is a class built into java
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello World!</h1>");
        if (name != null) {
            String world = "<h1>Hello " + name + "!</h1>";
            out.println(world);
        } else {
            String message = "<h1>Hello World !</h1>";
            out.println(message);
        }
    }
}
