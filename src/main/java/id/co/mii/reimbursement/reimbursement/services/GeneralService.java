/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.mii.reimbursement.reimbursement.services;

import id.co.mii.reimbursement.reimbursement.daos.IDao;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author amry4
 */
@Service
@Transactional
public class GeneralService implements IService {
    @Autowired
    protected IDao iDao;

    @Override
    public List manageData(Object entity, String field, String keyword, Serializable id, boolean isGet, boolean isData) {
        return iDao.manageData(entity, field, keyword, id, isGet, isData);
    }
}
