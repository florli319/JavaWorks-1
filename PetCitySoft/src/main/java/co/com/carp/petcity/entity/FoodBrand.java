package co.com.carp.petcity.entity;

/**
 * This class is attempt to manage food brands. 
 * 
 * @author Carlos Rodriguez
 *
 */
public class FoodBrand {
	
	/** 
	 * Food brand identification
	 * */
	private int identification;
	
	/** 
	 * Food brand name
	 * */
	private String name;

	/**
	 * @return the identification
	 */
	public int getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(int identification) {
		this.identification = identification;
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
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof FoodBrand)) {
			return false;
		}
		if  (!this.name.equals(((FoodBrand)arg).name)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * name.hashCode();
		return hashCode;
	}

	@Override
	public String toString() {
		return "FoodBrand={identification:" + this.identification + ";name:" + this.name + "}";
	}
	
}