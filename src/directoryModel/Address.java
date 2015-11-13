/**
 * 
 */
package directoryModel;

import javax.jdo.annotations.*;

import com.google.appengine.api.datastore.Key;

/**
 * @author Luis
 *
 */
@PersistenceCapable
public class Address {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent private String streetName;
	
	@Persistent private String city;
	
	@Persistent private String state;
	
	@Persistent private String stateCode;
	
	@Persistent private String zipcode;
	
	public Address(){
		this("114 Street Name", "city", "state", "20164");
		this.stateCode = "VA";
	}
	
	public Address(String streetName, String city, String state, String zipcode){
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.stateCode = "VA";
		this.zipcode = zipcode;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return this.streetName;
	}

	/**
	 * @param streetName the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @return the numberOfAddresses
	 */
	
	public String toString(){
		return "This is the Address toStirng. implement pending.";
	}
}
