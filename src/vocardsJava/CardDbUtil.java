package vocardsJava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CardDbUtil {

	private DataSource dataSource;

	public CardDbUtil(DataSource theDataSource) {

		this.dataSource = theDataSource;
	}

	public List<Card> getCards() throws Exception {

		List<Card> cards = new ArrayList<>();

		// Get a connection
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRes = null;

		try {
			myConn = dataSource.getConnection();

			// Create an sql statement
			String sql = "select * from card";
			myStmt = myConn.createStatement();

			// execute sql query
			myRes = myStmt.executeQuery(sql);

			// process the resultset
			while (myRes.next()) {

				// Retrieve data from result row

				int id = myRes.getInt("id");
				String mot = myRes.getString("mot");
				String tMot = myRes.getString("tMot");
				String type = myRes.getString("type");
				String tType = myRes.getString("tType");
				String syno = myRes.getString("syno");
				String tSyno = myRes.getString("tSyno");
				String phrase = myRes.getString("phrase");
				String tPhrase = myRes.getString("tPhrase");
				int auteurId = myRes.getInt("auteurId");

				// create new student object
				Card tempCard = new Card(id, mot, tMot, type, tType, syno, tSyno, phrase, tPhrase, auteurId);
				// add it to the list cards
				cards.add(tempCard);

			}
			return cards;
		} finally {
			// Clear JDBC objects
			close(myConn, myStmt, myRes);
		}

	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRes) {
		try {

			if (myConn != null) {
				myConn.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (myRes != null) {
				myRes.close();

			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	public void addCard(Card theCard) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		// Get a connection

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into card " + "(mot, tMot, type, tType, syno, tSyno, phrase, tPhrase) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the student
			myStmt.setString(1, theCard.getMot());
			myStmt.setString(2, theCard.gettMot());
			myStmt.setString(3, theCard.getType());
			myStmt.setString(4, theCard.gettType());
			myStmt.setString(5, theCard.getSyno());
			myStmt.setString(6, theCard.gettSyno());
			myStmt.setString(7, theCard.getPhrase());
			myStmt.setString(8, theCard.gettPhrase());

			// execute sql insert
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteCard(String cardId) throws Exception {
		// Convert cardId to int
		int id = Integer.parseInt(cardId);

		Connection myConn = null;
		PreparedStatement myStmt = null;
		// Get a connection
		try {
			myConn = dataSource.getConnection();
			// create statement to delete this id
			String sql = "delete from card where id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			// Set params
			myStmt.setInt(1, id);

			// execute query
			myStmt.execute();
		} finally {
			// Clean JDBC objects
			close(myConn, myStmt, null);
		}

	}

	public Card getCard(String theCardId) throws Exception {
		Card theCard = null;

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRes = null;

		// Convert cardId to int
		int cardId = Integer.parseInt(theCardId);

		// Get a connection
		try {
			myConn = dataSource.getConnection();
			// create statement to delete this id
			String sql = "select * from card where id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			// Set params
			myStmt.setInt(1, cardId);

			// execute query
			myRes = myStmt.executeQuery();

			// retrieve data from resultset
			if (myRes.next()) {
				int id = myRes.getInt("id");
				String mot = myRes.getString("mot");
				String tMot = myRes.getString("tMot");
				String type = myRes.getString("type");
				String tType = myRes.getString("tType");
				String syno = myRes.getString("syno");
				String tSyno = myRes.getString("tSyno");
				String phrase = myRes.getString("phrase");
				String tPhrase = myRes.getString("tPhrase");

				theCard = new Card(id, mot, tMot, type, tType, syno, tSyno, phrase, tPhrase, 0);
			} else {
				throw new Exception("Couldn't find the Card id: " + cardId);
			}

			return theCard;

		} finally {
			// Clean JDBC objects
			close(myConn, myStmt, null);
		}

	}

	public void updateCard(Card theCard) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		// Get a connection

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "UPDATE card " + "SET mot=?, tMot=?, type=?, tType=?, syno=?, tSyno=?, phrase=?, tPhrase=? "
					+ "WHERE id=?";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the student
			myStmt.setString(1, theCard.getMot());
			myStmt.setString(2, theCard.gettMot());
			myStmt.setString(3, theCard.getType());
			myStmt.setString(4, theCard.gettType());
			myStmt.setString(5, theCard.getSyno());
			myStmt.setString(6, theCard.gettSyno());
			myStmt.setString(7, theCard.getPhrase());
			myStmt.setString(8, theCard.gettPhrase());
			myStmt.setInt(9, theCard.getId());
			// execute sql insert
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}

	}

}
