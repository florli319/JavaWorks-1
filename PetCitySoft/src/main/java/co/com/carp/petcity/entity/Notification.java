package co.com.carp.petcity.entity;

import java.util.Date;

/**
 * This class is attempt to manage all notification message that 
 * pet city soft can do to keep alert about some events.
 * 
 * @author Carlos Rodriguez
 *
 */
public class Notification implements Comparable<Notification> {
	
	/**
	 * Database identification
	 */
	private int identification;
	
	/**
	 * Notification message
	 */
	private String message;
	
	/**
	 * Notification level
	 */
	private int level;
	
	/**
	 * Date when notification was created.
	 */
	private Date creationDate;
	
	/**
	 * Date when notification must be displayed.
	 */
	private Date notificationDate;
	
	/**
	 * Notify if an email must be send to owner
	 */
	private boolean sendEmail;
	
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the notificationDate
	 */
	public Date getNotificationDate() {
		return notificationDate;
	}

	/**
	 * @param notificationDate the notificationDate to set
	 */
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	/**
	 * @return the sendEmail
	 */
	public boolean isSendEmail() {
		return sendEmail;
	}

	/**
	 * @param sendEmail the sendEmail to set
	 */
	public void setSendEmail(boolean sendEmail) {
		this.sendEmail = sendEmail;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof Notification)) {
			return false;
		}
		if  (!this.message.equals(((Notification)arg).message) ||
				!this.creationDate.equals(((Notification)arg).creationDate) ||
				!this.notificationDate.equals(((Notification)arg).notificationDate)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * this.message.hashCode() + this.creationDate.hashCode() +
				this.notificationDate.hashCode();
		return hashCode;
	}

	@Override
	public String toString() {
		return "Notification={identification:" + this.identification + ";message:" + this.message 
				+ ";level:" + this.level 
				+ ";creationDate:" + this.creationDate.toString()
				+ ";notificationDate:" + this.notificationDate.toString()
				+ ";sendEmail:" + this.sendEmail
				+ "}";
	}

	@Override
	public int compareTo(Notification anotherNotification) {
		return this.notificationDate.compareTo(anotherNotification.notificationDate);
	}
}
