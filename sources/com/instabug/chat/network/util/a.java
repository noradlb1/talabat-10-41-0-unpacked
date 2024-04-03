package com.instabug.chat.network.util;

import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugDateFormatter;
import org.json.JSONArray;

public abstract class a {
    public static Request a(long j11, int i11, JSONArray jSONArray) {
        Request.Builder method = new Request.Builder().endpoint(Endpoints.SYNC_CHATS).method("POST");
        if (j11 != 0) {
            method.addParameter(new RequestParameter("last_message_messaged_at", InstabugDateFormatter.formatUTCDate(j11)));
        }
        method.addParameter(new RequestParameter("messages_count", Integer.valueOf(i11)));
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            method.addParameter(new RequestParameter("read_messages", jSONArray));
        }
        return method.build();
    }
}
