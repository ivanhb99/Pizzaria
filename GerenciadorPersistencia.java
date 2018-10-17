package br.edu.catolica_to.my_pizza;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by ivanh on 06/09/2018.
 */

public class GerenciadorPersistencia {

    public static final int TYPE_BOOLEAN = 0;
    public static final int TYPE_STRING = 1;

    public static void save(Activity activity, boolean value)
    {
        SharedPreferences shared = activity.getSharedPreferences("config", Activity.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putBoolean("notification" , value);

        editor.commit();
    }

    public static void save(Activity activity, String value)
    {
        SharedPreferences shared = activity.getSharedPreferences("config", Activity.MODE_PRIVATE);

        SharedPreferences.Editor editor = shared.edit();

        editor.putString("notification" , value);

        editor.commit();
    }


    public static Object getValue(Activity activity, int type){

        SharedPreferences shared = activity.getSharedPreferences("config", activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();

        if(shared.contains("notification")){
            switch (type){
                case 0:
                    return shared.getBoolean("notification", false);
                case 1:
                    return shared.getString("notification", "");
            }
        }
        return false;
    }

}
