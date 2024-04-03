package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/HeroWidgetResponseModel;", "", "widgetType", "", "trackingId", "(Ljava/lang/String;Ljava/lang/String;)V", "getTrackingId", "()Ljava/lang/String;", "getWidgetType", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class HeroWidgetResponseModel {
    @Nullable
    private final String trackingId;
    @NotNull
    private final String widgetType;

    public HeroWidgetResponseModel(@NotNull @Json(name = "widgetType") String str, @Nullable @Json(name = "trackingId") String str2) {
        Intrinsics.checkNotNullParameter(str, "widgetType");
        this.widgetType = str;
        this.trackingId = str2;
    }

    @Nullable
    public String getTrackingId() {
        return this.trackingId;
    }

    @NotNull
    public final String getWidgetType() {
        return this.widgetType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeroWidgetResponseModel(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2);
    }
}
