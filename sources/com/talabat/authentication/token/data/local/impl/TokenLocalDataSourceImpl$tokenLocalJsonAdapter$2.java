package com.talabat.authentication.token.data.local.impl;

import com.squareup.moshi.JsonAdapter;
import com.talabat.authentication.token.data.local.model.TokenLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/authentication/token/data/local/model/TokenLocal;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TokenLocalDataSourceImpl$tokenLocalJsonAdapter$2 extends Lambda implements Function0<JsonAdapter<TokenLocal>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TokenLocalDataSourceImpl f55519g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TokenLocalDataSourceImpl$tokenLocalJsonAdapter$2(TokenLocalDataSourceImpl tokenLocalDataSourceImpl) {
        super(0);
        this.f55519g = tokenLocalDataSourceImpl;
    }

    public final JsonAdapter<TokenLocal> invoke() {
        return this.f55519g.moshi.adapter(TokenLocal.class);
    }
}
