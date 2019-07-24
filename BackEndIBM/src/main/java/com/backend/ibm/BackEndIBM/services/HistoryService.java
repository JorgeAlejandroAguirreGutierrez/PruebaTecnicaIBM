package com.backend.ibm.BackEndIBM.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.ibm.BackEndIBM.dao.IHistoryDAO;
import com.backend.ibm.BackEndIBM.models.History;

@Service
public class HistoryService implements IHistory {
	
	@Autowired
	private IHistoryDAO historyDAO;
	
	@Override
	public ArrayList<History> get() {
		return (ArrayList<History>) historyDAO.findAll();
	}
	
	@Override
	public History getID(long id) {
		return historyDAO.findById(id).get();
	}

	@Override
	public History create(History customer) {
		History chistory=historyDAO.save(customer);
		return chistory;
	}

	@Override
	public History update(History history) {
		History uhistory=historyDAO.findById(history.getId()).get();
		uhistory.setDate(history.getDate());
		uhistory.setDescription(history.getDescription());
		uhistory.setAmount(history.getAmount());
		uhistory=historyDAO.save(uhistory);
		return uhistory;
	}

	@Override
	public Boolean delete(Long id) {
		try { 
			historyDAO.deleteById(id);
		return true;
		} catch(Exception e) {
			return false;
		}
	}

}
