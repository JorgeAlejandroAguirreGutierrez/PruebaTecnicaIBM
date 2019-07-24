package com.backend.ibm.BackEndIBM.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.ibm.BackEndIBM.dao.IAdviserDAO;
import com.backend.ibm.BackEndIBM.models.Adviser;

public class AdviserService implements IAdviser {
	@Autowired
	private IAdviserDAO adviserDAO;
	
	@Override
	public ArrayList<Adviser> get() {
		return (ArrayList<Adviser>) adviserDAO.findAll();
	}
	
	@Override
	public Adviser getID(Long id) {
		return adviserDAO.findById(id).get();
	}

	@Override
	public Adviser create(Adviser card) {
		Adviser cadviser=adviserDAO.save(card);
		return cadviser;
	}

	@Override
	public Adviser update(Adviser adviser) {
		Adviser uadviser=adviserDAO.findById(adviser.getId()).get();
		uadviser.setName(adviser.getName());
		uadviser.setSpeciality(adviser.getSpeciality());
		uadviser=adviserDAO.save(uadviser);
		return uadviser;
	}

	@Override
	public Boolean delete(Long id) {
		try { 
			adviserDAO.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
