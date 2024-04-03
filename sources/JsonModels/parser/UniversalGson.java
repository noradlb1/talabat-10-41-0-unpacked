package JsonModels.parser;

import JsonModels.AddAddressResponse;
import JsonModels.AddAddressResult;
import JsonModels.Response.AddAddressRM;
import com.google.gson.Gson;

public enum UniversalGson {
    INSTANCE;
    
    AddAddressRM.Deserializer addAddressRMDeserializer;
    AddAddressResponse.Deserializer addAddressResponseDeserializer;
    AddAddressResult.Deserializer addAddressResultDeserializer;
    AddAddressResponse.AddressDeserializer addressDeserializer;
    AddAddressResponse.AddressSerializer addressSerializer;
    public Gson gson;

    public static Gson getGson() {
        return INSTANCE.gson;
    }
}
