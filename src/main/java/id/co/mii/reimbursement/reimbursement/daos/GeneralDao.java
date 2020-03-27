/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.reimbursement.reimbursement.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amry4
 * @param <T>
 */
@Repository

public class GeneralDao<T> implements IDao<T> {

    @Autowired
    protected SessionFactory sf;

    @Override
    public List<T> manageData(T entity, String field, String keyword, Serializable id, boolean isGet, boolean isData) {
        Session ss = sf.openSession();
        List<T> model = new ArrayList<>();
        Transaction trc = null;
        try {
            trc = ss.beginTransaction();
            if (isGet) {
                T data = (T) ss.get(entity.getClass(), id);
                if (isData) {
                    ss.delete(data);
                } else {
                    ss.saveOrUpdate(entity);
                }
                trc.commit();
                return model;
            } else {
                String hql = (isData) ? "FROM " + entity.getClass().getSimpleName() + " where Upper(" + field + ") like :keyword"
                        : "FROM " + entity.getClass().getSimpleName() + " where " + field + " = :keyword";
                Query q = ss.createQuery(hql);
                q = (isData) ? q.setString("keyword", "%" + keyword.toUpperCase() + "%") : q.setString("keyword", keyword);
                model = q.list();
                if (model.isEmpty()) {
                    return null;
                }
                trc.commit();

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return model;
    }

}
