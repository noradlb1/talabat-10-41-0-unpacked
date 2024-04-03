package JsonModels.Response;

import JsonModels.AddAddressResponse;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class AddAddressRM {
    public AddAddressResponse result;

    public static class Deserializer implements JsonDeserializer<AddAddressRM> {
        public AddAddressRM deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("result");
            return new AddAddressRM(jsonElement2 != null ? new AddAddressResponse.Deserializer().deserialize(jsonElement2, (Type) AddAddressResponse.class, jsonDeserializationContext) : null);
        }
    }

    public AddAddressRM() {
        this.result = null;
    }

    public AddAddressRM(AddAddressResponse addAddressResponse) {
        this.result = addAddressResponse;
    }
}
