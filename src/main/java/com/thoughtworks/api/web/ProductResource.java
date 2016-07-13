package com.thoughtworks.api.web;

import com.thoughtworks.api.infrastructure.core.Product;
import com.thoughtworks.api.infrastructure.core.ProductRepository;
import com.thoughtworks.api.web.jersey.Routes;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Map;

/**
 * Created by syzhang on 7/13/16.
 */

@Path("products")
public class ProductResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Map<String, Object> info,
                                  @Context ProductRepository productRepository,
                                  @Context Routes routes){

        Product product = productRepository.creatProduct(info);
        return Response.created(routes.prodcut(product)).build();
    }
}
