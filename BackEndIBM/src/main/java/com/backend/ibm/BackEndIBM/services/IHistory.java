package com.backend.ibm.BackEndIBM.services;
import java.util.ArrayList;

import com.backend.ibm.BackEndIBM.models.History;

public interface IHistory {
	
	public ArrayList<History> get();
	public ArrayList<History> getID(long ID);
}
