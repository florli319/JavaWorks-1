package co.com.carp.petcity.entity;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * This class is attempt to be an implementation of person, this class represent 
 * pet's owner. 
 * 
 * @author Carlos Rodriguez
 * */
public class Owner extends Person implements Comparable<Owner> {
	
	/**
	 * Owner home address
	 */
	private String address;
	
	/**
	 * Owner cell-phone
	 */
	private int cellphone;
	
	/**
	 * Owner phone
	 */
	private int phone;
	
	/**
	 * Pet set from owner
	 */
	private HashSet<Pet> petSet;
	
	/**
	 * Notification message set
	 */
	private TreeSet<Notification> notificationSet;
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the cellphone
	 */
	public int getCellphone() {
		return cellphone;
	}

	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the petSet
	 */
	public HashSet<Pet> getPetSet() {
		return petSet;
	}

	/**
	 * @param petSet the petSet to set
	 */
	public void setPetSet(HashSet<Pet> petSet) {
		this.petSet = petSet;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + cellphone;
		result = prime * result
				+ ((notificationSet == null) ? 0 : notificationSet.hashCode());
		result = prime * result + phone;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cellphone != other.cellphone)
			return false;
		if (notificationSet == null) {
			if (other.notificationSet != null)
				return false;
		} else if (!notificationSet.equals(other.notificationSet))
			return false;
		if (phone != other.phone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ";Owner={" + this.address + ";" +
				"cellphone:" + this.cellphone + ";" +
				"phone:" + this.phone + ";" +
				"petSet:" + this.petSet + ";" + 
				"notificationSet:" + this.notificationSet.toString() + 
				";}";
	}

	@Override
	public int compareTo(Owner otherOwner) {
		return this.getName().compareToIgnoreCase(otherOwner.getName());
	}

}
