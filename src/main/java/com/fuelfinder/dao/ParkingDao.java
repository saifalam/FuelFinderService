package com.fuelfinder.dao;

import com.fuelfinder.model.response.SearchResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by saif on 03.12.17.
 */
@Repository
@Transactional
public interface ParkingDao extends JpaRepository<SearchResponse, Serializable> {
}
