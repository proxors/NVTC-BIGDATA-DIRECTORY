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
	
	@Persistent public static final int MAX_NUM_ADDRESS = 2;		
	@Persistent public static final int MAX_NUM_PRIMARY_CATEGORIES = 4;	
	@Persistent public static final int MAX_NUM_SECONDARY_CATEGORIES = 4;
	@Persistent public static final int MAX_NUM_TERTIARY_CATEGORIES = 4;
	@Persistent public static final int MAX_NUM_POINT_CONTACTS = 3;
	@Persistent public static final int MAX_NUM_SPECIALIZATIONS = 3;
	
	@Persistent	private List<Address> addressList;
	
	@Persistent private List<Category> primaryCategories;
	
	@Persistent private List<Category> secondaryCategories;
	
	@Persistent private List<Category> tertiaryCategories;
	
	@Persistent private List<PointOfContact> pointOfContactList;
	
	@Persistent private List<CompanySpecialization> specializations;
	
	
	Company(){
		this("company name", "www.example.com", "a description");
	}
	
	Company(String aName, String website, String description){
		this.name = aName;
		this.website = website;
		this.telephone = "555-555-5555";
		this.description = description;
		this.addressList = new ArrayList<Address>(MAX_NUM_ADDRESS);
		this.primaryCategories = new ArrayList<Category>(MAX_NUM_PRIMARY_CATEGORIES);
		this.secondaryCategories = new ArrayList<Category>(MAX_NUM_SECONDARY_CATEGORIES);
		this.tertiaryCategories = new ArrayList<Category>(MAX_NUM_TERTIARY_CATEGORIES);
		this.pointOfContactList = new ArrayList<PointOfContact>(MAX_NUM_POINT_CONTACTS);
		this.specializations = new ArrayList<CompanySpecialization>(MAX_NUM_SPECIALIZATIONS);
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
	public List<Address> getAddressList() {
		return addressList;
	}

	/**
	 * 
	 * Method to set an entire list of addresses
	 * @param addressList the addressList to set
	 */
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	/**
	 * Method to add an address to the address list.
	 * @param address
	 * @return
	 */
	public void addAdress(Address address){
		if(addressList.size() < MAX_NUM_ADDRESS){
			addressList.add(address);			
		}
		
	}

	/**
	 * Method to get the list of primary categories.
	 * @return the primaryCategories
	 */
	public List<Category> getPrimaryCategories() {
		return primaryCategories;
	}

	/**
	 * @param primaryCategories the primaryCategories to set
	 */
	public void setPrimaryCategories(List<Category> primaryCategories) {
		this.primaryCategories = primaryCategories;
	}
	
	public static Category createCategory(String type, String catDescription){
		return new Category(type, catDescription);
	}
	
	public void addPrimaryCategory(Category primCat){
		if(primaryCategories.size() < MAX_NUM_PRIMARY_CATEGORIES ){
			primaryCategories.add(primCat);
		}
	}

	/**
	 * @return the secondaryCategories
	 */
	public List<Category> getSecondaryCategories() {
		return secondaryCategories;
	}

	/**
	 * @param secondaryCategories the secondaryCategories to set
	 */
	public void setSecondaryCategories(List<Category> secondaryCategories) {
		this.secondaryCategories = secondaryCategories;
	}
	
	public void addSecondaryCategory(Category secondCat){
		if(secondaryCategories.size() < MAX_NUM_SECONDARY_CATEGORIES ){
			secondaryCategories.add(secondCat);
		}
	}

	/**
	 * @return the tertiaryCategories
	 */
	public List<Category> getTertiaryCategories() {
		return tertiaryCategories;
	}

	/**
	 * @param tertiaryCategories the tertiaryCategories to set
	 */
	public void setTertiaryCategories(List<Category> tertiaryCategories) {
		this.tertiaryCategories = tertiaryCategories;
	}
	
	public void addTertiaryCategory(Category tertiaryCat){
		if(tertiaryCategories.size() < MAX_NUM_TERTIARY_CATEGORIES ){
			tertiaryCategories.add(tertiaryCat);
		}
	}

	/**
	 * @return the pointOfContactList
	 */
	public List<PointOfContact> getPointOfContactList() {
		return pointOfContactList;
	}

	/**
	 * @param pointOfContactList the pointOfContactList to set
	 */
	public void setPointOfContactList(List<PointOfContact> pointOfContactList) {
		this.pointOfContactList = pointOfContactList;
	}
	
	public void addPointOfContact(PointOfContact aContact){
		if(pointOfContactList.size() < MAX_NUM_POINT_CONTACTS ){
			pointOfContactList.add(aContact);
		}
	}

	/**
	 * @return the specializations
	 */
	public List<CompanySpecialization> getSpecializations() {
		return specializations;
	}

	/**
	 * @param specializations the specializations to set
	 */
	public void setSpecializations(List<CompanySpecialization> specializations) {
		this.specializations = specializations;
	}
	
	public static CompanySpecialization createSpecialization (String type, String description){
		return new CompanySpecialization(type, description);
	}

	public void addSpecialization(CompanySpecialization specialization){
		if(specializations.size() < MAX_NUM_SPECIALIZATIONS){
			specializations.add(specialization);
		}
	}
	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * Returns a string representation of company.
	 */
	public String toString(){
		return "Company to string default.";
	}
	
}
	
		