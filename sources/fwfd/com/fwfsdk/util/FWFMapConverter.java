package fwfd.com.fwfsdk.util;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.reflect.Type;
import java.util.Map;

@Instrumented
public class FWFMapConverter {
    @TypeConverter
    public static String fromMap(Map<String, Boolean> map) {
        Gson instance = FWFGson.getInstance();
        return !(instance instanceof Gson) ? instance.toJson((Object) map) : GsonInstrumentation.toJson(instance, (Object) map);
    }

    @TypeConverter
    public static Map<String, Boolean> fromString(String str) {
        Object obj;
        Type type = new TypeToken<Map<String, Boolean>>() {
        }.getType();
        Gson instance = FWFGson.getInstance();
        if (!(instance instanceof Gson)) {
            obj = instance.fromJson(str, type);
        } else {
            obj = GsonInstrumentation.fromJson(instance, str, type);
        }
        return (Map) obj;
    }
}
