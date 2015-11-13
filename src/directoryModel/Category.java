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
public class Category {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent 
	private String type;
	
	@Persistent 
	private String description;
		
	public Category(){
		this("type", "description");
	}
	public Category(String type, String catDescription) {
		this.type = type;
		this.description = catDescription;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}
	
	public String toString(){
		return "Category Default String";
	}

}
