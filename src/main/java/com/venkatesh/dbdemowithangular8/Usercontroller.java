package com.venkatesh.dbdemowithangular8;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.venkatesh.dbdemowithangular8.bean.Userbean;
import com.venkatesh.dbdemowithangular8.serinf.Serviceinterface;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class Usercontroller {

    @Autowired
    private Serviceinterface serviceinterface;

    // ObjectMapper mapper = new ObjectMapper();

    @PostMapping(value = "/create")
    public Boolean createuser(@RequestBody JSONObject jsondata) {
        try{
          //  Userbean bean = mapper.readValue(jsondata.toString(), Userbean.class);
            return serviceinterface.creauser(jsondata);
        }
        catch(Exception e)
        {
            return  false;
        }

    }

    @GetMapping(value = "/fetch")
    public JSONArray getdata()
    {
        try{
            return serviceinterface.getdata();
        }
        catch(Exception e)
        {
            return  new JSONArray();
        }
    }

}
