package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardDefaultContentResponseModel;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCardDefaultContentResponseModel {
    @Nullable
    private final String url;

    public TProOnBoardingCardDefaultContentResponseModel() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingCardDefaultContentResponseModel(@Nullable @Json(name = "url") String str) {
        this.url = str;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProOnBoardingCardDefaultContentResponseModel(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }
}
