package com.backend.ibm.BackEndIBM.dao;

import org.springframework.data.repository.*;

import com.backend.ibm.BackEndIBM.models.History;

public interface IHistoryDAO extends CrudRepository<History, Long> {

}
