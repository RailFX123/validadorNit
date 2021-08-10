/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author victorm.gonzalez
 */
@Path("validaNit") // test
public class validaNit {

    @Context
    private UriInfo context;

    private validador valNit;

    public validaNit() {
        this.valNit = new validador();
    }

    /**
     *
     * @param content
     * @return
     * @throws JSONException
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public String postJson(String content) {

        JSONObject group = new JSONObject(content);
        JSONObject req = group.getJSONObject("validarNitK");
        String vNit = req.getString("nitx");
        String res = valNit.nit(vNit);
        return new JSONObject().put("res",res).toString();
    }

}
