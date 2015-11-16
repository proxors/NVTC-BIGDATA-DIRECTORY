package directoryModel;
import com.google.appengine.api.datastore.Key;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.*;
/**
 * 
 * @author Luis
 *
 *The purpose of this class is to model a big data entity (company) for storage in the directory
 */
@PersistenceCapable
public class Company {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;//note the variable name has key all lower caps. while the type is Key
	
	@Persistent private String name;	
	@Persistent private String website;
	@Persistent private String telephone;
	@Persistent private String description;
	
	@Persistent	private Address companyAddress;
	
	@Persistent private Category primaryCategory;
	
	@Persistent private Category secondaryCategory;
	
	@Persistent private Category tertiaryCategory;
	
	@Persistent private PointOfContact poc;
	
	@Persistent private String specialty1;
	@Persistent private String specialty2;
	@Persistent private String specialty3;
	
	
	
	public Company(){
		this("company name", "www.example.com", "a description");
	}
	
	public Company(String aName, String website, String description){
		this.name = aName;
		this.website = website;
		this.telephone = "555-555-5555";
		this.description = description;
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)throws IllegalArgumentException { 
		if(Utility.isStringDataValid(name)){
			this.name = name;			
		}else{
			throw new IllegalArgumentException("Invalid string input");
		}
		
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return this.website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getTelephone(){
		return this.telephone;
	}
	
	public void setTelephone(String aPhone){
		this.telephone = aPhone;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) throws IllegalArgumentException {
		if(Utility.isStringDataValid(description)){
			this.description = description;			
		}else{
			throw new IllegalArgumentException("Invalid string input");
		}
	}

	/**
	 * @return the addressList
	 */
	public Address getAddress() {
		return this.companyAddress;
	}

	/**
	 * 
	 * Method to set an entire list of addresses
	 * @param addressList the addressList to set
	 */
	public void setAddress(Address address) {
		this.companyAddress = address;
	}

	/**
	 * Method to get the list of primary categories.
	 * @return the primaryCategories
	 */
	public Category getPrimaryCategory() {
		return this.primaryCategory;
	}

	/**
	 * @param primaryCategories the primaryCategories to set
	 */
	public void setPrimaryCategory(Category primaryCategory) {
		this.primaryCategory = primaryCategory;
	}
	
	public static Category createCategory(String type, String catDescription, String hierarchy){
		return new Category(type, catDescription, hierarchy);
	}

	/**
	 * 
	 * @return
	 */
	public Category getSecondaryCategory() {
		return this.secondaryCategory;
	}

	/**
	 * @param secondaryCategories the secondaryCategories to set
	 */
	public void setSecondaryCategory(Category secondaryCategory) {
		this.secondaryCategory = secondaryCategory;
	}
	
	

	/**
	 * @return the tertiaryCategories
	 */
	public Category getTertiaryCategory() {
		return this.tertiaryCategory;
	}

	/**
	 * @param tertiaryCategories the tertiaryCategories to set
	 */
	public void setTertiaryCategories(Category tertiaryCategory) {
		this.tertiaryCategory = tertiaryCategory;
	}

	/**
	 * @return the pointOfContactList
	 */
	public PointOfContact getPointOfContact() {
		return this.poc;
	}

	/**
	 * @param pointOfContactList the pointOfContactList to set
	 */
	public void setPointOfContact(PointOfContact poc) {
		this.poc = poc;
	}
	

	/**
	 * @return the specialty1
	 */
	public String getSpecialty1() {
		return specialty1;
	}

	/**
	 * @param specialty1 the specialty1 to set
	 */
	public void setSpecialty1(String specialty1) {
		this.specialty1 = specialty1;
	}

	/**
	 * @return the specialty2
	 */
	public String getSpecialty2() {
		return specialty2;
	}

	/**
	 * @param specialty2 the specialty2 to set
	 */
	public void setSpecialty2(String specialty2) {
		this.specialty2 = specialty2;
	}

	/**
	 * @return the specialty3
	 */
	public String getSpecialty3() {
		return specialty3;
	}

	/**
	 * @param specialty3 the specialty3 to set
	 */
	public void setSpecialty3(String specialty3) {
		this.specialty3 = specialty3;
	}

	/**
	 * @return the key
	 */
	public Key getKey() {
		return this.key;
	}

	/**
	 * Returns a string representation of company.
	 */
	public String toString(){
		String output = "Point of Contact Information\n"
				+ "First Name: " + poc.getFirstName() + "- Last Name: " + poc.getLastName() + "\n"
				+ "Email: " + poc.getEmail() + "\n"
				+ "Company Information\n"
				+ "Company Name: " + this.getName() + " Company Website: " + this.getWebsite() + "\n"
				+ "Company Telephone: " + this.getTelephone() + "\n"
				+ "Company Description: " + this.getDescription() + "\n"
				+ "Address 1: \n"
				+ this.getAddress().getStreetName() + "\n"
				+ this.getAddress().getCity() + ", " + this.getAddress().getState() + " " + this.getAddress().getZipcode() + "\n"
			    + "Category Info: \n"
			    + "Primary Category: " + this.getPrimaryCategory().getCategoryName() + "\n"
			    + "Secondary Category: " + this.getSecondaryCategory().getCategoryName() + "\n"
			    + "Tertiary Category: " + this.getTertiaryCategory().getCategoryName() + "\n"
			    + "Specialty Info:\n"
			    + "Specialty 1: " + this.getSpecialty1() + "\n"
			    + "Specialty 2: " + this.getSpecialty2() + "\n"
			    + "Specialty 3: " + this.getSpecialty3() + "\n";		;
		
		return output;
	}
	
}
	
		