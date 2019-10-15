package vocardsJava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Define Datasource / connection pool for Resource injection

	@Resource(name = "jdbc/vocards")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// step 1 : Setup the PrintWriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		// step 2 : get a connection to the database
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRes = null;

		try {
			myConn = dataSource.getConnection();

			// step 3:Create an sql statement
			String sql = "select * from card";
			myStmt = myConn.createStatement();
			// step 4 :execute sql query
			myRes = myStmt.executeQuery(sql);
			// step 5 :process the resultset
			while (myRes.next()) {
				String mot = myRes.getString("mot");
				out.println(mot);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
