package fwfd.com.fwfsdk.util;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.reflect.Type;
import java.util.List;

@Instrumented
public class FWFStringListConverter {
    @TypeConverter
    public static String fromArrayList(List<String> list) {
        Gson instance = FWFGson.getInstance();
        return !(instance instanceof Gson) ? instance.toJson((Object) list) : GsonInstrumentation.toJson(instance, (Object) list);
    }

    @TypeConverter
    public static List<String> fromString(String str) {
        Object obj;
        Type type = new TypeToken<List<String>>() {
        }.getType();
        Gson instance = FWFGson.getInstance();
        if (!(instance instanceof Gson)) {
            obj = instance.fromJson(str, type);
        } else {
            obj = GsonInstrumentation.fromJson(instance, str, type);
        }
        return (List) obj;
    }
}
