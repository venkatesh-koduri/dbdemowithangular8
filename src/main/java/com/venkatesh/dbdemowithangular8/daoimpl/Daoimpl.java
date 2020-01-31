package com.venkatesh.dbdemowithangular8.daoimpl;

import com.venkatesh.dbdemowithangular8.daoinf.Daoinf;
import com.venkatesh.dbdemowithangular8.model.Usermodel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
//@Transactional
public class Daoimpl implements Daoinf {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Boolean save(Usermodel model) {
        Transaction tx = null;
        try
        {
            Session session = entityManager.unwrap(Session.class);
            tx = session.beginTransaction();
            if(model != null)
            {
                session.saveOrUpdate(model);
            }
            tx.commit();
            return  true;
        }
        catch (Exception e){
            tx.rollback();
           return  false;
        }
    }

    @Override
    public JSONArray fetch() {
        JSONArray Array = new JSONArray();
         try {

            /* Session ses = entityManager.unwrap(Session.class);
             CriteriaBuilder cr = entityManager.getCriteriaBuilder();

             CriteriaQuery<Usermodel> qr = cr.createQuery(Usermodel.class);
             Root<Usermodel> r = qr.from(Usermodel.class);*/
             TypedQuery<Usermodel> query =
                     entityManager.createQuery("SELECT c FROM Usermodel c", Usermodel.class);


             List<Usermodel> um = query.getResultList();

             //List<Usermodel>  um = entityManager.createQuery("select * from usermodel", Usermodel.class).getResultList();

             if(um != null && um.size() > 0)
             {
                 for (Usermodel u : um)
                 {
                     JSONObject obj = new JSONObject();
                     obj.put("id",u.getId());
                     obj.put("role", u.getRole());
                     obj.put("username", u.getUsername());
                     Array.add(obj);
                 }
             }
             return Array;
         }catch (Exception e)
         {
             return Array;
         }

    }
}
