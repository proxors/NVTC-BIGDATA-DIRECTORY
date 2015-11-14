/**
 * 
 */
package directoryControls;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.*;

import directoryModel.*;

public class SubmitCompanyServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		
		//Extract Company info
		String companyName = request.getParameter("companyName");
		String website = request.getParameter("website");
		String telephone = request.getParameter("telephone");
		String description = request.getParameter("companyDescription");
		String address1 = request.getParameter("companyAddress1");
		String address2 = request.getParameter("companyAddress2");
		String city = request.getParameter("companyCity");
		String state = request.getParameter("companyState");
		String zipcode = "" + request.getParameter("companyZip");
		
		
		//extract primary categories
		String primaryCategoryDropdown = request.getParameter("category_dropdown");//first level of primary category
		String primarySecondLevel = request.getParameter("subcategory");//get the input from the second level of primary category
		String primaryThirdLevel = request.getParameter("primary3rdLevel");//get the input from the third level other
		String primaryFourthLevel = request.getParameter("primary4thLevel");
		String [] primaryCategories = {primaryCategoryDropdown,primarySecondLevel,primaryThirdLevel,primaryFourthLevel};
		
		
		System.out.println("Primary Cat: " + primaryCategoryDropdown + 
				"\nPrimary Cat Second: " + primarySecondLevel + 
				"\nPrimary Cat Third: " + primaryThirdLevel + 
				"\nPrimary Cat 4th:" + primaryFourthLevel );
		System.out.println();
		
    	PointOfContact poc = EntityCreator.createPointOfContact(firstName, lastName, email);
		Company aCompany = EntityCreator.createCompany(companyName, website, description);
		aCompany.setTelephone(telephone);
		
		
		//while(!data.isEmpty()){
			//System.out.println(data.get("companyName"));
		//}
		
		
//		System.out.println("First name: " + firstName + "\nlastName: " + lastName + "\nemail: " + email);		
//		System.out.println("company name: " + companyName + "\nwebsite: " + website + "\ntelephone: " + telephone + "\nDescription: " + description + 
//				"\nAddress1: " + address1 + "\nAddress2: " + address2 + "\ncity: " + city + "\nstate: " + state + "\nzipcode: " + zipcode + "\nPrimary Cat: " +primaryCategory+
//				"\nPCat Second Level:" + primaryCategorySecond + "\nPCat Third: " + primaryCategoryThird);
	
		/*String username = request.getParameter("username");
		String answerText = request.getParameter("answer-text");
		String answerCode = request.getParameter("answer-code");
		//Luis, changed questionId to long because that is the datatype the datastore uses.
		long questionId = Long.parseLong(request.getParameter("qid"));
		//create the answer
		Answer a = Answer.createAnswer(username, answerText, answerCode);
		//@Luis: update the question with the answer specified, this was done as a single static method so that only one instance of the persistence manager is used.
		Question.updateQuestionWithAnswer(questionId, a);
		//after saving the answer to the question, go back to the view .jsp
		response.sendRedirect("/view.jsp?qid=" + questionId);*/		
	}

}
