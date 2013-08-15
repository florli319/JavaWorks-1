package co.com.carp.petcity.entity;

import java.util.Date;
import java.util.TreeSet;

/**
 * This class is attempt to control pet's clinic history
 * 
 * @author Carlos Rodriguez
 *
 */
public class PetClinicHistory {
	
	/**
	 * Database identification
	 */
	private int identification;
	
	/**
	 * Date from first medical consultation.
	 */
	private Date openDate;
	
	/**
	 * User creator for clinic history
	 */
	private int userIdentification;
	
	/**
	 * Pet's medical consultation set
	 */
	private TreeSet<PetMedicalConsultation> consultationSet;
	
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
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/**
	 * @return the userIdentification
	 */
	public int getUserIdentification() {
		return userIdentification;
	}

	/**
	 * @param userIdentification the userIdentification to set
	 */
	public void setUserIdentification(int userIdentification) {
		this.userIdentification = userIdentification;
	}

	/**
	 * @return the consultationSet
	 */
	public TreeSet<PetMedicalConsultation> getConsultationSet() {
		return consultationSet;
	}

	/**
	 * @param consultationSet the consultationSet to set
	 */
	public void setConsultationSet(TreeSet<PetMedicalConsultation> consultationSet) {
		this.consultationSet = consultationSet;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof PetClinicHistory)) {
			return false;
		}
		if  (!this.openDate.equals(((PetClinicHistory)arg).openDate)
				|| this.identification != ((PetClinicHistory)arg).identification
				|| this.userIdentification != ((PetClinicHistory)arg).userIdentification) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "PetMedicalHistory={identification:" + this.identification + 
				";openDate:" + this.openDate.toString() + 
				";userIdentification:" + this.userIdentification +
				";consultationSet:" + this.consultationSet.toString() +
				"}";
	}

}