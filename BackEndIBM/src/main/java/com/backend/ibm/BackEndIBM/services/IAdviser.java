package com.backend.ibm.BackEndIBM.services;

import java.util.ArrayList;

import com.backend.ibm.BackEndIBM.models.Adviser;

public interface IAdviser {
	public ArrayList<Adviser> get();
	public Adviser getID(Long id);
	public Adviser create(Adviser adviser);
	public Adviser update(Adviser adviser);
	public Boolean delete(Long id);
}
