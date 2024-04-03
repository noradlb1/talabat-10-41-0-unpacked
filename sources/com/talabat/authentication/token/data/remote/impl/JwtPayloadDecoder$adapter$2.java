package com.talabat.authentication.token.data.remote.impl;

import com.squareup.moshi.JsonAdapter;
import com.talabat.authentication.token.data.model.JwtPayload;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/authentication/token/data/model/JwtPayload;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class JwtPayloadDecoder$adapter$2 extends Lambda implements Function0<JsonAdapter<JwtPayload>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ JwtPayloadDecoder f55520g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JwtPayloadDecoder$adapter$2(JwtPayloadDecoder jwtPayloadDecoder) {
        super(0);
        this.f55520g = jwtPayloadDecoder;
    }

    public final JsonAdapter<JwtPayload> invoke() {
        return this.f55520g.moshi.adapter(JwtPayload.class);
    }
}
