package co.com.carp.petcity.entity;

import java.io.File;

/**
 * This class is attempt to 
 * 
 * @author Carlos Rodriguez
 *
 */
public class PetExam {
	
	/**
	 * Identification from database.
	 */
	private int identification;
	
	/**
	 * Exam name
	 */
	private String name;
	
	/**
	 * Exam description
	 */
	private String description;
	
	/**
	 * File associated with exam
	 */
	private File examFile;
	
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
	 * @return the examFile
	 */
	public File getExamFile() {
		return examFile;
	}

	/**
	 * @param examFile the examFile to set
	 */
	public void setExamFile(File examFile) {
		this.examFile = examFile;
	}

	@Override
	public boolean equals(Object arg) {
		if (arg == null || !(arg instanceof PetExam)) {
			return false;
		}
		if  (!this.name.equals(((PetExam)arg).name)
				|| this.identification != ((PetExam)arg).identification) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hashCode = 85;
		hashCode = hashCode * this.name.hashCode() + this.identification;
		return hashCode;
	}

	@Override
	public String toString() {
		return "PetExam={identification:" + this.identification + 
				";name:" + this.name + 
				";description:" + this.description +
				";file:" + this.examFile +
				"}";
	}

}
