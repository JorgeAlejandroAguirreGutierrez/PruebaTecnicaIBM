package com.backend.ibm.BackEndIBM.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.ibm.BackEndIBM.dao.ICardDAO;
import com.backend.ibm.BackEndIBM.models.Card;

public class CardService implements ICard {

	@Autowired
	private ICardDAO cardDAO;
	
	@Override
	public ArrayList<Card> get() {
		return (ArrayList<Card>) cardDAO.findAll();
	}
	
	@Override
	public Card getID(Long id) {
		return cardDAO.findById(id).get();
	}

	@Override
	public Card create(Card card) {
		Card ccard=cardDAO.save(card);
		return ccard;
	}

	@Override
	public Card update(Card card) {
		Card ucard=cardDAO.findById(card.getId()).get();
		ucard.setNumber(card.getNumber());
		ucard.setCcv(card.getCcv());
		ucard.setType(card.getType());
		ucard=cardDAO.save(ucard);
		return ucard;
	}

	@Override
	public Boolean delete(Long id) {
		try { 
		cardDAO.deleteById(id);
		return true;
		} catch(Exception e) {
			return false;
		}
	}
}
