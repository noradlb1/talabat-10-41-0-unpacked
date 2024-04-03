package com.instabug.featuresrequest.network;

import com.instabug.featuresrequest.models.f;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.State;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;

public abstract class a {
    public static Request.Builder a(Request.Builder builder, f fVar) {
        builder.addParameter(new RequestParameter("body", fVar.e()));
        builder.addParameter(new RequestParameter("created_at", Long.valueOf(fVar.a())));
        if (fVar.f() != null && !fVar.f().trim().isEmpty()) {
            builder.addParameter(new RequestParameter("name", fVar.f()));
        }
        builder.addParameter(new RequestParameter("email", fVar.k()));
        builder.addParameter(new RequestParameter(State.KEY_PUSH_TOKEN, InstabugCore.getPushNotificationToken()));
        return builder;
    }
}
