package com.backend.ibm.BackEndIBM.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.ibm.BackEndIBM.models.Card;

public interface ICardDAO extends CrudRepository<Card, Long> {

}
