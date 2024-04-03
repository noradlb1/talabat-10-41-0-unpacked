package JsonModels;

import com.talabat.domain.address.Address;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class GrlCartAddressSerialiser {
    private String cartSelectedGrlJson;
    private Address inforMapAddress;

    public class JsonModelAddAddressResult {
        public String item;
        public int itemId;

        public JsonModelAddAddressResult() {
        }
    }

    public GrlCartAddressSerialiser(Address address, String str) {
        this.inforMapAddress = address;
        this.cartSelectedGrlJson = str;
    }

    public Address getInforMapAddress() {
        return this.inforMapAddress;
    }

    public String getcartSelectedGrlID() {
        return infoMaptoGrlIDConverter(this.cartSelectedGrlJson);
    }

    public String infoMaptoGrlIDConverter(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("AddressElements");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JsonModelAddAddressResult jsonModelAddAddressResult = new JsonModelAddAddressResult();
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                jsonModelAddAddressResult.itemId = jSONObject.getInt("AddressElementTypeCode");
                jsonModelAddAddressResult.item = jSONObject.getString("Value");
                arrayList.add(i11, jsonModelAddAddressResult);
            }
            if (arrayList.size() > 4) {
                return ((JsonModelAddAddressResult) arrayList.get(4)).item;
            }
            return "";
        } catch (Exception unused) {
            return str;
        }
    }
}
