package br.com.paggi.auth;

import br.com.paggi.model.PaggiCredentials;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class PaggiCredentialsValidator {
    private PaggiCredentials credentials;

    public PaggiCredentialsValidator(PaggiCredentials credentials){
        this.credentials = credentials;
    }

    public static PaggiCredentialsValidator withCredentials(PaggiCredentials credentials){
        return new PaggiCredentialsValidator(credentials);
    }

    public boolean isValid(){

        try {
            DecodedJWT jwt = JWT.decode(credentials.getToken());
            String decodedPartnerId = (String) jwt.getClaims().get("permissions").asArray(LinkedHashMap.class)[0].get("partner_id");

            //Expired Token
            if (jwt.getExpiresAt().before(new Date())){
                return false;
            }

            if (credentials.getPartnerId() == null || credentials.getPartnerId().isEmpty()){
                credentials.setPartnerId(decodedPartnerId);
            }

            return credentials.getPartnerId().equals(decodedPartnerId);
        } catch (Exception e){
            //Invalid token
            return false;
        }
    }
}
