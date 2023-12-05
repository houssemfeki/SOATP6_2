package web;

import com.example.tp6.entities.Compte;
import com.example.tp6.repositories.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
@Autowired
    private CompteRepository compteRepository;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON})

    public List<Compte> compteList(){
     return compteRepository.findAll();
    }
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})

    public Compte getOne(@PathParam(value = "id") Long id){
        return compteRepository.findById(id).get();
    }


    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})

    public  Compte save(Compte compte){
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})

    public  Compte update(Compte compte , @PathParam("id") Long id){
        compte.setId(id);
        return  compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})

    public  void delete(Compte compte , @PathParam("id") Long id){
     compteRepository.deleteById(id);
    }

}


