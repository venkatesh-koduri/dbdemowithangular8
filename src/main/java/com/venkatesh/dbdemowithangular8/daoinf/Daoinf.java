package com.venkatesh.dbdemowithangular8.daoinf;

import com.venkatesh.dbdemowithangular8.model.Usermodel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public interface Daoinf {
    Boolean save(Usermodel model);

    JSONArray fetch();
}
