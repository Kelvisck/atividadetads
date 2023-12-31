package com.kelvisck.primeiroexemplo.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Map;
import java.util.Collection;

public class JWTconverter implements Converter<Jwt, AbstractAuthenticationToken>{

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

        System.out.println("Token Claims: " + jwt.getClaims());
        
        Map<String, Collection<String>> realmAcess = jwt.getClaim("realm_acess");
        Collection<String> roles = realmAcess.get("roles");
        var grants = roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role)).toList();
        
        System.out.println("Granted Authorities: " + grants);
        return new JwtAuthenticationToken(jwt, grants);


    }
    

    
}
