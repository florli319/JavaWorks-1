package co.com.carp.petcity.controller;

import java.util.Set;
import java.util.TreeSet;

import co.com.carp.petcity.entity.Owner;
import co.com.carp.petcity.view.JPOwnerInfo;

public class PetAndOwnerInfoTabController {
	
	/**
	 * Copy from actual set that is being displayed
	 */
	private Set<Owner> ownerSet;
	
	/**
	 * Copy from owner information's panel
	 */
	private JPOwnerInfo jpOwnerInfo;
	
	/**
	 * It does a query to database using the parameter send.
	 * 
	 * @param toLookFor String value used to do query.
	 * @return Owner set with all information obtained from database.
	 */
	public Set<Owner> queryOwnerInfo(String toLookFor) {
		this.ownerSet = new TreeSet<>();
		//Fake data
		Owner owner = new Owner();
		owner.setIdentification(1);
		owner.setDocumentId(19604742);
		owner.setName("Carlos Rodriguez");
		this.ownerSet.add(owner);
		
		owner = new Owner();
		owner.setIdentification(2);
		owner.setDocumentId(1045676080);
		owner.setName("Lina Florez");
		this.ownerSet.add(owner);
		
		return this.ownerSet;
	}
	
	/**
	 * It keeps a copy from central panel, this copy can be used to change the owner
	 * that is being displayed.
	 * 
	 * @param jpOwnerInfo
	 */
	public void keepCopyFromOwnerInfoPanel(JPOwnerInfo jpOwnerInfo) {
		this.jpOwnerInfo = jpOwnerInfo;
	}

	public void changeOwnerInOwnerInfoPanel(Owner owner) {
		this.jpOwnerInfo.replaceOwnerInformation(owner);
	}
}
