package com.venkatesh.dbdemowithangular8.serinf;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public interface Serviceinterface {
    Boolean creauser(JSONObject jsondata);

    JSONArray getdata();
}
