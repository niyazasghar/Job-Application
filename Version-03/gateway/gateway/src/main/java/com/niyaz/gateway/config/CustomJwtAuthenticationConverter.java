package com.niyaz.gateway.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final Converter<Jwt, Collection<GrantedAuthority>> grantedAuthoritiesConverter = new KeycloakRoleConverter();

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = grantedAuthoritiesConverter.convert(jwt);

        // Extract additional user details from JWT claims
        String username = jwt.getClaimAsString("preferred_username");
        String id = jwt.getClaimAsString("sub");
        String firstName = jwt.getClaimAsString("given_name");
        String lastName = jwt.getClaimAsString("family_name");

        // Create a custom principal with the additional information
        CustomUserDetails principal = new CustomUserDetails(id, username, firstName, lastName, authorities);

        return new JwtAuthenticationToken(jwt, authorities, principal.getUsername());
    }
}

