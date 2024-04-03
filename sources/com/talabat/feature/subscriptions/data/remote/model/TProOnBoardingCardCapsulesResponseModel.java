package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B5\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardCapsulesResponseModel;", "", "title", "", "titleColor", "backgroundColor", "image", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getImage", "getTitle", "getTitleColor", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCardCapsulesResponseModel {
    @Nullable
    private final String backgroundColor;
    @Nullable
    private final String image;
    @Nullable
    private final String title;
    @Nullable
    private final String titleColor;

    public TProOnBoardingCardCapsulesResponseModel() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingCardCapsulesResponseModel(@Nullable @Json(name = "title") String str, @Nullable @Json(name = "titleColor") String str2, @Nullable @Json(name = "backgroundColor") String str3, @Nullable @Json(name = "image") String str4) {
        this.title = str;
        this.titleColor = str2;
        this.backgroundColor = str3;
        this.image = str4;
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTitleColor() {
        return this.titleColor;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProOnBoardingCardCapsulesResponseModel(String str, String str2, String str3, String str4, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }
}
