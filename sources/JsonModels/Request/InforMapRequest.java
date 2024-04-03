package JsonModels.Request;

import JsonModels.parser.UniversalGson;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class InforMapRequest {
    public String addressElementsStr;
    public int areaid;
    public int countryId = GlobalDataModel.SelectedCountryId;
    public String latitude;
    public String longitude;
    public int restaurantId = -1;

    public InforMapRequest(String str, int i11, boolean z11) {
        String str2;
        Gson gson = UniversalGson.INSTANCE.gson;
        if (z11) {
            this.addressElementsStr = str;
        } else {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray("AddressElements");
                if (!(jSONArray instanceof JSONArray)) {
                    str2 = jSONArray.toString();
                } else {
                    str2 = JSONArrayInstrumentation.toString(jSONArray);
                }
                this.addressElementsStr = str2;
            } catch (JSONException unused) {
            }
        }
        this.areaid = i11;
    }

    public String getJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("areaid", this.areaid);
            jSONObject.put("countryId", GlobalDataModel.SelectedCountryId);
            int i11 = this.restaurantId;
            if (i11 > 0) {
                jSONObject.put("restId", i11);
            } else {
                jSONObject.put("restId", GlobalDataModel.SELECTED.restaurant.f13872id);
            }
            if (!TalabatUtils.isNullOrEmpty(this.addressElementsStr)) {
                jSONObject.put("addressElementStr", (Object) this.addressElementsStr);
            }
        } catch (JSONException unused) {
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public void setRestaurantId(int i11) {
        this.restaurantId = i11;
    }
}
