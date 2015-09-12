package com.tatharo.onelegacy.hibernate.domain.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tatharo.onelegacy.hibernate.domain.model.Product;
@Repository
public class HibernateTransactions {
    @Autowired
    private SessionFactory sf;
    @Transactional
    public void saveProduct(Product object){
        sf.getCurrentSession().saveOrUpdate(object);
        System.out.println("opgeslagen product is:");
    }
}
