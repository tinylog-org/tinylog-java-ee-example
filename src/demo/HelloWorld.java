package demo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pmw.tinylog.Logger;
import org.pmw.tinylog.LoggingContext;

@WebServlet("/")
public class HelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String ip = request.getHeader("X-FORWARDED-FOR"); // Client IP for proxies and load balancers
		if (ip == null) {
			ip = request.getRemoteAddr(); // Client IP is remote address
		}
		LoggingContext.put("ip", request.getRemoteAddr());

		Logger.info("Handle request");
		response.getWriter().append("<h1>Hello World</h1>");
		Logger.info("Done request");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}

}
