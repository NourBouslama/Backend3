package com.backend.caisse.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import
org.springframework.security.authentication.UsernamePasswordAuthenticationToken
;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.backend.caisse.entities.Utilisateur;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

private AuthenticationManager authenticationManager;

public JWTAuthenticationFilter(AuthenticationManager authenticationManager) 
{
super();
this.authenticationManager = authenticationManager;
}
//fonction auto appelé par spring security lors d'une authentification
//va extraire l'objet user a partie d'une requete
@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
                throws AuthenticationException {
Utilisateur user =null;
try {
//deserealiser le format json en un object de type utilisateur
user = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
} catch (JsonParseException e) {
e.printStackTrace();
} catch (JsonMappingException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
}
return authenticationManager.
authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getMotDePasse()));
}
@Override
protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
Authentication authResult) throws IOException, ServletException 
{
org.springframework.security.core.userdetails.User springUser = (org.springframework.security.core.userdetails.User) 
    authResult.getPrincipal();
    //construire les role dans une liste
List<String> role = new ArrayList<>();
//getAuthorities() retourne liste des role
springUser.getAuthorities().forEach(au-> {
    role.add(au.getAuthority());
});
//construire le token jwt
String jwt = JWT.create().
withSubject(springUser.getUsername()).
withArrayClaim("role", role.toArray(new String[role.size()])).
withExpiresAt(new Date(System.currentTimeMillis()+SecParams.EXP_TIME)).
sign(Algorithm.HMAC256(SecParams.SECRET));
//ajouter ce header a la classe security config
//Authorization l'entete creer lors de generation du token
response.addHeader("Authorization", jwt); 
}
    
}
