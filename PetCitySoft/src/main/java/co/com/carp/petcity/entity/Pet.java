package co.com.carp.petcity.entity;

import java.awt.Image;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * This class is attempt to manage pets. 
 * 
 * @author Carlos Rodriguez
 * */
public class Pet {
	
	/**
	 * Pet's identification
	 */
	private int identification;
	
	/**
	 * Pet's name
	 * */
	private String name;
	
	/**
	 * Pet's type
	 */
	private PetType type;
	
	/**
	 * Pet's color
	 */
	private String color;	
	
	/**
	 * Pet's sex
	 */
	private String sex;
	
	/**
	 * Pet's born date
	 */
	private Date bornDate;
	
	/**
	 * Pet's born place
	 */
	private String bornPlace;
	
	/**
	 * Pet's drenching set
	 */
	private HashSet<PetDrenching> drenching;
	
	/**
	 * Pet's reproduction
	 */
	private String reproduction;
	
	/**
	 * Pet's photo
	 */
	private Image photo;
	
	/**
	 * Vaccines applied to pet
	 */
	private TreeSet<PetVaccine> vaccineSet;
	
	/**
	 * It contains all pet's clinic history, it includes all medical consultations.
	 */
	private ClinicHistory clinicHistory;
	
	/**
	 * Notification message set
	 */
	private TreeSet<Notification> notificationSet;

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
	 * @return the type
	 */
	public PetType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PetType type) {
		this.type = type;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the bornDate
	 */
	public Date getBornDate() {
		return bornDate;
	}

	/**
	 * @param bornDate the bornDate to set
	 */
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	/**
	 * @return the bornPlace
	 */
	public String getBornPlace() {
		return bornPlace;
	}

	/**
	 * @param bornPlace the bornPlace to set
	 */
	public void setBornPlace(String bornPlace) {
		this.bornPlace = bornPlace;
	}

	/**
	 * @return the drenching
	 */
	public HashSet<PetDrenching> getDrenching() {
		return drenching;
	}

	/**
	 * @param drenching the drenching to set
	 */
	public void setDrenching(HashSet<PetDrenching> drenching) {
		this.drenching = drenching;
	}

	/**
	 * @return the reproduction
	 */
	public String getReproduction() {
		return reproduction;
	}

	/**
	 * @param reproduction the reproduction to set
	 */
	public void setReproduction(String reproduction) {
		this.reproduction = reproduction;
	}

	/**
	 * @return the photo
	 */
	public Image getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(Image photo) {
		this.photo = photo;
	}

	/**
	 * @return the vaccineSet
	 */
	public TreeSet<PetVaccine> getVaccineSet() {
		return vaccineSet;
	}

	/**
	 * @param vaccineSet the vaccineSet to set
	 */
	public void setVaccineSet(TreeSet<PetVaccine> vaccineSet) {
		this.vaccineSet = vaccineSet;
	}

	/**
	 * @return the clinicHistory
	 */
	public ClinicHistory getClinicHistory() {
		return clinicHistory;
	}

	/**
	 * @param clinicHistory the clinicHistory to set
	 */
	public void setClinicHistory(ClinicHistory clinicHistory) {
		this.clinicHistory = clinicHistory;
	}
	
	/**
	 * @return the notificationSet
	 */
	public TreeSet<Notification> getNotificationSet() {
		return notificationSet;
	}

	/**
	 * @param notificationSet the notificationSet to set
	 */
	public void setNotificationSet(TreeSet<Notification> notificationSet) {
		this.notificationSet = notificationSet;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof Pet)) {
			return false;
		}
		if (!this.name.equals(((Pet)arg).name) ||
				!this.type.equals(((Pet)arg).type) ||
				!this.bornDate.equals(((Pet)arg).bornDate) ||
				!this.bornPlace.equals(((Pet)arg).bornPlace)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * name.hashCode() + type.hashCode()
				+ bornDate.hashCode() + bornPlace.hashCode();
		hashCode += ((notificationSet == null) ? 0 : notificationSet.hashCode());
		return hashCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pet [identification=" + identification + ", name=" + name
				+ ", type=" + type + ", color=" + color + ", sex=" + sex
				+ ", bornDate=" + bornDate + ", bornPlace=" + bornPlace
				+ ", drenching=" + drenching + ", reproduction=" + reproduction
				+ ", photo=" + photo + ", vaccineSet=" + vaccineSet
				+ ", notificationSet=" + this.notificationSet.toString()
				+ ", clinicHistory=" + clinicHistory + "]";
	}
}