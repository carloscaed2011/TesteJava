/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.PokemonDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Pokemon;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author CARLOS
 */
@Path("WebService")
public class PokemonWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PokemonWS
     */
    public PokemonWS() {
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String salvarPokemon(String pokemon) {

        try {
            carrega(); //executar só a primeira vez
            Gson gson = new Gson();
            Pokemon p = gson.fromJson(pokemon, Pokemon.class);
            //System.out.println(p.getName());
            PokemonDAO pdao = new PokemonDAO();
            pdao.salvar(p);
            return "ok";
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Retrieves representation of an instance of ws.PokemonWS
     *
     * @return an instance of java.lang.String
     */
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("pokemons")
    public String getJsonP() {
        //TODO return proper representation object

        ArrayList<Pokemon> pokemons = new ArrayList<>();

        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("fogo");
        tipos.add("agua");
        Pokemon p = new Pokemon();
        p.setNum("001");
        p.setName("pik");
        p.setTipos(tipos);
        p.setPre_evolution("p");
        p.setNext_evolution("pMais");

        ArrayList<String> tipos2 = new ArrayList<>();
        tipos.add("fogo");
        tipos.add("agua");
        Pokemon p2 = new Pokemon();
        p2.setNum("002");
        p2.setName("pik");
        p2.setTipos(tipos);
        p2.setPre_evolution("p");
        p2.setNext_evolution("pMais");

        pokemons.add(p);
        pokemons.add(p2);

        Gson g = new Gson();
        return g.toJson(pokemons);

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("pokemon/{numero}")
    public String getJson(@PathParam("numero") String numero) {
        System.out.println(numero);
        //TODO return proper representation object
        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("fogo");
        tipos.add("agua");
        Pokemon p = new Pokemon();
        p.setNum("001");
        p.setName("pik");
        p.setTipos(tipos);
        p.setPre_evolution("p");
        p.setNext_evolution("pMais");
        Gson g = new Gson();

        return g.toJson(p);

    }

    /**
     * PUT method for updating or creating an instance of PokemonWS
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{numeroPut}")
    public void putJson(String content) {
    }

    @DELETE
    @Path("/{numeroDelete}")
    public void delete(@PathParam("numero") String numero) {
        //ejb.remover(Long.valueOf(id));
    }

    public void carrega() throws Exception {
        PokemonDAO pokemonDAO = new PokemonDAO();
        Pokemon pokemon = new Pokemon();
        String jsonString = "";
        try {
            String caminhoDoArquivo = "C:/Users/CARLOS/Documents/NetBeansProjects/TesteWS/pokedex.json";
            FileReader reader = new FileReader(caminhoDoArquivo);
            BufferedReader br = new BufferedReader(reader);
            String temp;
            while ((temp = br.readLine()) != null) {
                jsonString = jsonString + temp;
                //System.out.println(temp);
            }
            JSONObject json = new JSONObject(jsonString);
            //System.out.println(json);
            JSONArray array = json.getJSONArray("pokemon");

            for (Object o1 : array) {
                JSONObject j1 = (JSONObject) o1;
                pokemon.setNum(j1.getString("num"));
                pokemon.setName(j1.getString("name"));
                ArrayList<String> typs = new ArrayList<>();
                for (Object o2 : j1.getJSONArray("type")) {
                    //System.out.println("tipo: " + o2);
                    typs.add("" + o2);
                }
                pokemon.setTipos(typs);
                try {
                    String aux = "";
                    for (Object o3 : j1.getJSONArray("prev_evolution")) {
                        JSONObject j3 = (JSONObject) o3;
                        //System.out.println("prev: " + j3.getString("name"));
                        aux = aux + j3.getString("name") + " ";
                    }
                    pokemon.setPre_evolution(aux);
                } catch (Exception e) {
                    pokemon.setPre_evolution("");
                    //System.out.println("não existe prev!");
                }

                try {
                    String aux = "";
                    for (Object o4 : j1.getJSONArray("next_evolution")) {
                        JSONObject j4 = (JSONObject) o4;
                        //System.out.println("next: " + j4.getString("name"));
                        aux = aux + j4.getString("name") + " ";
                    }
                    pokemon.setNext_evolution(aux);
                } catch (Exception e) {
                    pokemon.setNext_evolution("");
                    //System.out.println("não existe next!");
                }

                pokemonDAO.salvar(pokemon);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

/*public void carrega(){         
     JSONObject json =new JSONObject(pokemon);  // método para leitura do arquivo json
        JSONArray todos = json.getJSONArray("pokemon");
        for (Object titulo : todos) {
                  JSONObject ob =(JSONObject) titulo;
                  String n =ob.getString("name");
                  System.out.println(n+" "+t);
                  
              }
}*/
