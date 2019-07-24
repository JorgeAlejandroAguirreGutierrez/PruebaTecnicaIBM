package com.backend.ibm.BackEndIBM.services;
import java.util.ArrayList;

import com.backend.ibm.BackEndIBM.models.History;

public interface IHistory {
	
	public ArrayList<History> get();
	public History getID(long ID);
	public History create(History history);
	public History update(History history);
	public Boolean delete(Long id);
}
