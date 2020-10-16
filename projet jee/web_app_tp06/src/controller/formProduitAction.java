package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produit;

/**
 * Servlet implementation class formProduitAction
 */
@WebServlet("/formProduitAction")
public class formProduitAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public formProduitAction() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println("pppppppppppppppppppppppp");
		// Objet d'ecriture
		PrintWriter out = response.getWriter();
		// R�cup�rer la valeur du param�tre "id"
		String i = request.getParameter("id");
		// Afficher la valeur du param�tre "id"
		System.out.println("La valeur de id  est:" + i);
		// R�cup�rer la valeur du param�tre "code"
		String c = request.getParameter("code");
		// Afficher la valeur du param�tre "code"
		System.out.println("La valeur de code est:" + c);
		// R�cup�rer la valeur du param�tre "designation"
		String d = request.getParameter("designation");
		// Afficher la valeur du param�tre "designation"
		System.out.println("La valeur de designation est:" + d);
		// R�cup�rer la valeur du param�tre "prix"
		String p = request.getParameter("prix");
		// Afficher la valeur du param�tre "prix"
		System.out.println("La valeur de prix est:" + p);
		// R�cup�rer la valeur du param�tre "designation"
		String ca = request.getParameter("categorie");
		// Afficher la valeur du param�tre "categorie"
		System.out.println("La valeur de categorie est:" + ca);
		
		// R�cup�rer la valeur du param�tre "validite"
		String v = request.getParameter("validite");
		// Afficher la valeur du param�tre "validite"
		System.out.println("La valeur de validite est:" + v);

		// D�clarer une collection pour stocker les messages d'erreur
		ArrayList<String> erreurs = new ArrayList<String>();
		// cr�ation d'un objet "Produit"
		Produit produit = new Produit(Integer.parseInt(i), c, d, Double.parseDouble(p),ca);
		// test des valeurs des param�tres
		if (i == null || i.equals("")) 
			{
		     erreurs.add("Veuillez remplir le champ 'id' ");
			}
				
		if	(c == null || c.equals(""))
			{
		     erreurs.add("Veuillez remplir le champ 'code' ");
			}
		if	(d == null || d.equals(""))
			{
		     erreurs.add("Veuillez remplir le champ 'designation' ");
			} 
		if	(p == null || p.equals(""))
			{
		     erreurs.add("Veuillez remplir le champ 'prix' ");
			}
		if(ca == null || ca.equals(""))
			{
		     erreurs.add("Veuillez remplir le champ 'categorie' ");
			}
		if(v == null || v.equals(""))
		{
	     erreurs.add("Veuillez remplir le champ 'validite' ");
		}
		else
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				java.util.Date dv=sdf.parse(v);
				java.util.Date now =new Date();
				 System.out.println("date validite : " + sdf.format(dv));
			     System.out.println("date now : " + sdf.format(now));
			  // passer la valeur de validite au bean
                 produit.setValidite(dv);

			     
			     if (! (now.compareTo(dv) > 0)) {
			    	 erreurs.add("Date de validit� sup�rieure ou �gale � la date actuelle... ");
			     }
				
			} catch (ParseException e) {
				System.out.println("Probl�me de format de date...");
			}
		}
		// si te tableau des erreurs est non vide
		if (!erreurs.isEmpty())
		{
			// Placer le bean "produit" comme un attribut  dans l'objet "request"
			request.setAttribute("bean", produit);
			// Placer la variable "e" comme un attribut nomm� "erreur" dans l'objet "request"
			request.setAttribute("erreurs", erreurs);

			// Se rediriger vers la page "formProduit.jsp"
			request.getRequestDispatcher("formProduit.jsp").forward(request, response);
		}
		else
		{
		// Ecrire du code HTML en cas de succ�s de validation
		out.println("<html><body>");
		out.println("<h1>Validation avec succ�s...</h1>");
		out.println("</body></html>");
		}
	}

}
