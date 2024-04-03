package JsonModels;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class AddAddressResult {
    public String msg;
    public int statusCode;

    public static class Deserializer implements JsonDeserializer<AddAddressResult> {
        public AddAddressResult deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            JsonElement jsonElement2 = asJsonObject.get("statusCode");
            JsonElement jsonElement3 = asJsonObject.get("msg");
            int i11 = 0;
            if (jsonElement2 != null && !jsonElement2.isJsonNull()) {
                i11 = jsonElement2.getAsInt();
            }
            String str = null;
            if (jsonElement3 != null && !jsonElement3.isJsonNull()) {
                str = jsonElement3.getAsString();
            }
            return new AddAddressResult(i11, str);
        }
    }

    public AddAddressResult() {
        this.statusCode = 0;
        this.msg = null;
    }

    public AddAddressResult(int i11, String str) {
        this.statusCode = i11;
        this.msg = str;
    }
}
