package com.andikasoft.rwandacattle.rwandacattle.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenPreferences {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String KEY_TOKEN = "MyToken";

    private Context context;

    private static final String TOKEN_SHARED_PREFS = "TokenPreferences";

    public TokenPreferences(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(TOKEN_SHARED_PREFS,0);
        editor = sharedPreferences.edit();
    }

    public void saveToken(String token){
        editor.putString(KEY_TOKEN, token);
        editor.commit();
    }

    public String getToken(){
        return sharedPreferences.getString(KEY_TOKEN,null);
    }

    public void clearTokenPrefs(){
        editor.clear();
        editor.commit();
    }
}
