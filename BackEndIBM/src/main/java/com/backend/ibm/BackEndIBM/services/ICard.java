package com.backend.ibm.BackEndIBM.services;

import java.util.ArrayList;

import com.backend.ibm.BackEndIBM.models.Card;

public interface ICard {
	
	public ArrayList<Card> get();
	public Card getID(Long id);
	public Card create(Card card);
	public Card update(Card card);
	public Boolean delete(Long id);

}
