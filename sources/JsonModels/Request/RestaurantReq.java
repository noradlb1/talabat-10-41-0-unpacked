package JsonModels.Request;

import JsonModels.parser.UniversalGson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.lang.reflect.Type;
import java.util.Map;
import org.json.JSONObject;

@Instrumented
public class RestaurantReq {
    public int areaId;
    public int cityId;
    public int countryId;
    public boolean isMultipleSL;
    public String latitude;
    public String longitude;
    public int restaurantId;

    public RestaurantReq(int i11, int i12, int i13) {
        this.areaId = i11;
        this.cityId = i12;
        this.countryId = i13;
    }

    public JSONObject getJsonBody() {
        String str;
        Gson gson = UniversalGson.INSTANCE.gson;
        try {
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) this);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) this);
            }
            return new JSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public Map<String, String> getRequestBody() {
        String str;
        Object obj;
        Gson gson = UniversalGson.INSTANCE.gson;
        boolean z11 = gson instanceof Gson;
        if (!z11) {
            str = gson.toJson((Object) this);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) this);
        }
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        if (!z11) {
            obj = gson.fromJson(str, type);
        } else {
            obj = GsonInstrumentation.fromJson(gson, str, type);
        }
        return (Map) obj;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }
}
