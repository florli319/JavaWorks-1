package co.com.carp.petcity.entity;

import java.util.Date;

/**
 * This class is attempt to manage pet's drenching. 
 * 
 * @author Carlos Rodriguez
 *
 */
public class Drenching {
	
	/**
	 * Identification from database
	 */
	private int identification;
	
	/**
	 * Drenching date
	 */
	private Date drenchingDate;
	
	/**
	 * Product used
	 */
	private String productName;
	
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
	 * @return the drenchingDate
	 */
	public Date getDrenchingDate() {
		return drenchingDate;
	}

	/**
	 * @param drenchingDate the drenchingDate to set
	 */
	public void setDrenchingDate(Date drenchingDate) {
		this.drenchingDate = drenchingDate;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof Drenching)) {
			return false;
		}
		if  (!this.productName.equals(((Drenching)arg).productName)
				&& !this.drenchingDate.equals(((Drenching)arg).drenchingDate)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * productName.hashCode() + drenchingDate.hashCode();
		return hashCode;
	}

	@Override
	public String toString() {
		return "Drenching={date:" + this.drenchingDate.toString() + ";productName:" + this.productName + "}";
	}
}