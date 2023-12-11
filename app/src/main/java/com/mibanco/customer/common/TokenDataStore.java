package com.mibanco.customer.common;

import android.content.Context;
import android.content.SharedPreferences;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenDataStore {

    private static final String PREF_NAME = "token_pref";
    private static final String KEY_AUTH_TOKEN = "auth_token";

    private final SharedPreferences preferences;

    public TokenDataStore(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_AUTH_TOKEN, token);
        editor.apply();
    }

    public String getAuthToken() {
        return preferences.getString(KEY_AUTH_TOKEN, null);
    }

    public void clearToken() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(KEY_AUTH_TOKEN);
        editor.apply();
    }


    public static String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("YourSecretKey")
                    .parseClaimsJws(token)
                    .getBody();


            return claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            return "Usuario";
        }
    }


}
