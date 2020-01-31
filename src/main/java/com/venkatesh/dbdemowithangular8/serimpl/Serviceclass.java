package com.venkatesh.dbdemowithangular8.serimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.venkatesh.dbdemowithangular8.bean.Userbean;
import com.venkatesh.dbdemowithangular8.daoinf.Daoinf;
import com.venkatesh.dbdemowithangular8.model.Usermodel;
import com.venkatesh.dbdemowithangular8.serinf.Serviceinterface;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Serviceclass implements Serviceinterface {

    @Autowired
    private Daoinf daoinf;

    @Override
    public Boolean creauser(JSONObject jsondata) {
        try {
            Userbean bean = new ObjectMapper().readValue(jsondata.toString(), Userbean.class);
            Usermodel model = preparemodel(bean);
            return daoinf.save(model);
        }catch(Exception e)
        {
           System.out.println(e);
           return false;
        }
    }

    @Override
    public JSONArray getdata() {
        try{
            return daoinf.fetch();
        }catch (Exception e)
        {
            return  new JSONArray();
        }
    }

    private Usermodel preparemodel(Userbean bean) {
        Usermodel model = new Usermodel();

        if(bean.getIsmodify() == 1)
            model.setId(bean.getId());

        model.setRole(bean.getRole());
        model.setUsername(bean.getUsername());
        return model;
    }


}
