package fwfd.com.fwfsdk.util;

import com.google.gson.Gson;

public abstract class FWFGson {
    private static volatile Gson INSTANCE;

    public static Gson getInstance() {
        if (INSTANCE == null) {
            synchronized (FWFGson.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Gson();
                }
            }
        }
        return INSTANCE;
    }
}
