package vocardsJava;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CardControllerServlet
 */
@WebServlet("/CardControllerServlet")
public class CardControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CardDbUtil cardDbUtil;

	@Resource(name = "jdbc/vocards")
	private DataSource dataSource;

	// init methodu ilk calistirilan yerdir
	@Override
	public void init() throws ServletException {

		super.init();

		// Create our Card Db Util and pass in connection pool
		try {

			cardDbUtil = new CardDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");

			// route to the appropriate method
			switch (theCommand) {

			case "ADD":
				addCard(request, response);
				break;

			default:
				listCards(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");

			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}

			// route to the appropriate method
			switch (theCommand) {

			case "LIST":
				listCards(request, response);
				break;
			case "LOAD":
				loadCard(request, response);
				break;

			case "UPDATE":
				updateCard(request, response);
				break;

			case "DELETE":
				deleteCard(request, response);
				break;

			default:
				listCards(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void addCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data

		String mot = request.getParameter("mot");
		String tMot = request.getParameter("tMot");
		String type = request.getParameter("type");
		String tType = request.getParameter("tType");
		String syno = request.getParameter("syno");
		String tSyno = request.getParameter("tSyno");
		String phrase = request.getParameter("phrase");
		String tPhrase = request.getParameter("tPhrase");

		// create a new student object
		Card theCard = new Card(mot, tMot, type, tType, syno, tSyno, phrase, tPhrase);

		// add the student to the database
		cardDbUtil.addCard(theCard);

		// send back to main page (the student list)
		// SEND AS REDIRECT to avoid multiple-browser reload issue
		response.sendRedirect(request.getContextPath() + "/CardControllerServlet?command=LIST");

	}

	private void updateCard(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read info from form data
		int id = Integer.parseInt(request.getParameter("cardId"));
		String mot = request.getParameter("mot");
		String tMot = request.getParameter("tMot");
		String type = request.getParameter("type");
		String tType = request.getParameter("tType");
		String syno = request.getParameter("syno");
		String tSyno = request.getParameter("tSyno");
		String phrase = request.getParameter("phrase");
		String tPhrase = request.getParameter("tPhrase");

		// create a new student object
		Card theCard = new Card(id, mot, tMot, type, tType, syno, tSyno, phrase, tPhrase,0);
		// perform update to database
		cardDbUtil.updateCard(theCard);
		// Send them back to the LIST page
		listCards(request, response);
	}

	private void loadCard(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get the id from link
		String theCardId = request.getParameter("cardId");

		// Get data from database
		Card theCard = cardDbUtil.getCard(theCardId);

		// Place this card to request attribute
		request.setAttribute("THE_CARD", theCard);

		// Send to JSP page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-card-form.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get the id from link
		String id = request.getParameter("cardId");

		// delete card from database
		cardDbUtil.deleteCard(id);

		// send to LIST
		listCards(request, response);
	}

	private void listCards(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get the cards from db
		List<Card> cards = cardDbUtil.getCards();
		// add cards to request object
		request.setAttribute("CARD_LIST", cards);
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-cards.jsp");
		dispatcher.forward(request, response);

	}

}
