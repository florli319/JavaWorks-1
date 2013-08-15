package co.com.carp.petcity.entity;

import java.util.Date;

/**
 * This class is attempt to manage vaccines applied to pets. 
 * 
 * @author Carlos Rodriguez
 *
 */
public class PetVaccine implements Comparable<PetVaccine> {
	
	/**
	 * Identification from database
	 */
	private int identification;
	
	/**
	 * Vaccine name
	 */
	private String name;
	
	/**
	 * Date when vaccine was applied
	 */
	private Date appliedDate;
	
	
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

	/**
	 * @return the appliedDate
	 */
	public Date getAppliedDate() {
		return appliedDate;
	}

	/**
	 * @param appliedDate the appliedDate to set
	 */
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof PetVaccine)) {
			return false;
		}
		if  (!this.name.equals(((PetVaccine)arg).name)
				&& !this.appliedDate.equals(((PetVaccine)arg).appliedDate)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * this.name.hashCode() + this.appliedDate.hashCode();
		return hashCode;
	}

	@Override
	public String toString() {
		return "PetVaccine={name:" + this.name + ";appliedDate:" + this.appliedDate.toString() + "}";
	}

	@Override
	public int compareTo(PetVaccine anotherPetVaccine) {
		return this.appliedDate.compareTo(anotherPetVaccine.appliedDate);
	}
}