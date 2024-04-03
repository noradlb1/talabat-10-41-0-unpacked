package com.instabug.library.networkv2.service.userattributes;

import androidx.annotation.Nullable;
import com.instabug.library.model.UserAttributes;
import com.instabug.library.model.l;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

abstract class a {
    public static Request a(String str, @Nullable String str2) {
        Request.Builder addParameter = new Request.Builder().endpoint(Endpoints.USER_ATTRIBUTES).type(1).method("GET").addParameter(new RequestParameter("email", str));
        if (str2 != null) {
            addParameter.addHeader(new RequestParameter("If-Match", str2));
        }
        return addParameter.build();
    }

    public static String b(RequestResponse requestResponse) {
        if (requestResponse == null || requestResponse.getResponseBody() == null) {
            return "{}";
        }
        return (String) requestResponse.getResponseBody();
    }

    public static List c(Map map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new l.a((String) entry.getKey(), (String) entry.getValue()).a());
        }
        return arrayList;
    }

    public static UserAttributes a(String str) throws JSONException {
        UserAttributes userAttributes = new UserAttributes();
        userAttributes.fromJson(str);
        return userAttributes;
    }
}
