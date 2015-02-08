package com.alibaba.dubbo.user.rest.provider;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.dubbo.user.api.User;

/**
 *
 * @author Shunli
 */
@Path("user")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8 })
public class UserRestServiceImpl implements UserRestService {

    @GET
    // @Path("{id}") @PathParam("id")
    @Path("/get")
    @Override
    public RESTResult getUser(@QueryParam("id") String id) {
        if (RpcContext.getContext().getRequest(HttpServletRequest.class) != null) {
            System.out.println("Client address is " + RpcContext.getContext().getRequest(HttpServletRequest.class).getRemoteAddr());
        }

        User user = new User(id, "name" + id);
        return new RESTResult(0, user);
    }

}
