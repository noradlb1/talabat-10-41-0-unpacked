package com.uxcam.internals;

import com.adyen.checkout.core.model.WeChatPayDetails;
import org.json.JSONException;
import org.json.JSONObject;

public class ik {
    public static boolean a(JSONObject jSONObject, boolean z11) {
        int i11;
        if (jSONObject == null) {
            return false;
        }
        try {
            i11 = jSONObject.getInt(WeChatPayDetails.KEY_RESULT_CODE);
        } catch (JSONException unused) {
            i11 = 1;
        }
        if (!(i11 == 2 || i11 == 3 || i11 == 13 || i11 == 15)) {
            switch (i11) {
                case 6:
                    return !z11;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
