package com.talabat.configuration;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.remote.model.RootAppInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/remote/model/RootAppInfoEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RealConfigurationRemoteRepository$jsonAdapter$2 extends Lambda implements Function0<JsonAdapter<RootAppInfoEntity>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Moshi f55765g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealConfigurationRemoteRepository$jsonAdapter$2(Moshi moshi) {
        super(0);
        this.f55765g = moshi;
    }

    public final JsonAdapter<RootAppInfoEntity> invoke() {
        return this.f55765g.adapter(RootAppInfoEntity.class);
    }
}
