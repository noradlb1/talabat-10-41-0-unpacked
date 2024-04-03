package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingTitleSpanningResponseModel;", "", "text", "", "color", "(Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingTitleSpanningResponseModel {
    @Nullable
    private final String color;
    @Nullable
    private final String text;

    public TProOnBoardingTitleSpanningResponseModel() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public TProOnBoardingTitleSpanningResponseModel(@Nullable @Json(name = "text") String str, @Nullable @Json(name = "color") String str2) {
        this.text = str;
        this.color = str2;
    }

    public static /* synthetic */ TProOnBoardingTitleSpanningResponseModel copy$default(TProOnBoardingTitleSpanningResponseModel tProOnBoardingTitleSpanningResponseModel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProOnBoardingTitleSpanningResponseModel.text;
        }
        if ((i11 & 2) != 0) {
            str2 = tProOnBoardingTitleSpanningResponseModel.color;
        }
        return tProOnBoardingTitleSpanningResponseModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.text;
    }

    @Nullable
    public final String component2() {
        return this.color;
    }

    @NotNull
    public final TProOnBoardingTitleSpanningResponseModel copy(@Nullable @Json(name = "text") String str, @Nullable @Json(name = "color") String str2) {
        return new TProOnBoardingTitleSpanningResponseModel(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingTitleSpanningResponseModel)) {
            return false;
        }
        TProOnBoardingTitleSpanningResponseModel tProOnBoardingTitleSpanningResponseModel = (TProOnBoardingTitleSpanningResponseModel) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) tProOnBoardingTitleSpanningResponseModel.text) && Intrinsics.areEqual((Object) this.color, (Object) tProOnBoardingTitleSpanningResponseModel.color);
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.color;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.text;
        String str2 = this.color;
        return "TProOnBoardingTitleSpanningResponseModel(text=" + str + ", color=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProOnBoardingTitleSpanningResponseModel(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
