
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

/**
 * Servlet implementation class PatientManager
 */
@WebServlet("/PatientManager")
public class PatientManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Prescription> fg = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient connection = ConnectionManager.getMongo();

		MongoDatabase db = ConnectionManager.getDb("Patient");
		MongoCollection<Document> collection = db.getCollection("laugh");

		if (request.getParameter("btn") != null) {
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String address = request.getParameter("address");
			Patient l = new Patient(name, age, address);
			String name1 = request.getParameter("name1");
			String description = request.getParameter("description");
			l.Prescribe.add(new Prescription(name1, description));

			BasicDBList prs = new BasicDBList();
			for (Prescription p : l.Prescribe) {

				prs.add(new BasicDBObject("name", p.getName()).append("description", p.getDescription()));

			}

			Document d = new Document("name", name).append("age", age).append("address", address).append("Prescription",
					prs);
			collection.insertOne(d);
		} else if (request.getParameter("btn2") != null) {
			String key = request.getParameter("update");
			String name3 = request.getParameter("name2");
			String desc = request.getParameter("descript");
			Prescription s = new Prescription(name3, desc);
			ArrayList pDoc = null;
			MongoCursor<Document> cursor = collection.find(Filters.eq("name", key)).iterator();
			ArrayList<Prescription> presc = new ArrayList<Prescription>();
			while (cursor.hasNext()) {
				Document document = (Document) cursor.next();
				pDoc = (ArrayList) document.get("Prescription");
				System.out.println(pDoc);
			}
			for (Object p : pDoc) {
				Document d = (Document) p;
				System.out.println(d);
				System.out.println(d.get("name"));
				presc.add(new Prescription(d.getString("name"), d.getString("description")));
			}
			presc.add(s);

			BasicDBList prs3 = new BasicDBList();
			for (Prescription p : presc) {
				prs3.add(new BasicDBObject("name", p.getName()).append("description", p.getDescription()));

				System.out.println(p.name.toString() + "  " + p.Description.toString());
			}

			collection.updateOne(Filters.eq("name", key), Updates.set("Prescription", prs3));
		}

		else if (request.getParameter("btn3").equals("Search")) {
			String j = request.getParameter("search");
			System.out.println("inside search....");
			List<Patient> fd = new ArrayList<>();
			Patient s = null;
			System.out.println(j);
			MongoCursor<Document> d = collection.find(Filters.eq("name",j.trim())).iterator();
			System.out.println(d.hasNext());
			while (d.hasNext()) {
				System.out.println("      inside loop.");
				Document docs = (Document) d.next();
				s = new Patient(docs.getString("name"), docs.getString("age"), docs.getString("address"));
				ArrayList gf=(ArrayList) docs.get("Prescription");
				for(Object i:gf) {
					Document hj=(Document) i;
					s.Prescribe.add(new Prescription(hj.getString("name"),hj.getString("description")));
					System.out.println(s);
				}
				fd.add(s);
			}
			
			request.setAttribute("lol", fd);
			request.setAttribute("Prescribe",s.Prescribe);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
