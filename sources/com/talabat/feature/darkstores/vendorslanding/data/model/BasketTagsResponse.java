package com.talabat.feature.darkstores.vendorslanding.data.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/model/BasketTagsResponse;", "", "bottomSheetTitle", "", "bottomSheetButtonTitle", "bottomSheetMovMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBottomSheetButtonTitle", "()Ljava/lang/String;", "getBottomSheetMovMessage", "getBottomSheetTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketTagsResponse {
    @Nullable
    private final String bottomSheetButtonTitle;
    @Nullable
    private final String bottomSheetMovMessage;
    @Nullable
    private final String bottomSheetTitle;

    public BasketTagsResponse() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public BasketTagsResponse(@Nullable @Json(name = "bottom_sheet_title") String str, @Nullable @Json(name = "bottom_sheet_button_title") String str2, @Nullable @Json(name = "bottom_sheet_mov_message") String str3) {
        this.bottomSheetTitle = str;
        this.bottomSheetButtonTitle = str2;
        this.bottomSheetMovMessage = str3;
    }

    public static /* synthetic */ BasketTagsResponse copy$default(BasketTagsResponse basketTagsResponse, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = basketTagsResponse.bottomSheetTitle;
        }
        if ((i11 & 2) != 0) {
            str2 = basketTagsResponse.bottomSheetButtonTitle;
        }
        if ((i11 & 4) != 0) {
            str3 = basketTagsResponse.bottomSheetMovMessage;
        }
        return basketTagsResponse.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.bottomSheetTitle;
    }

    @Nullable
    public final String component2() {
        return this.bottomSheetButtonTitle;
    }

    @Nullable
    public final String component3() {
        return this.bottomSheetMovMessage;
    }

    @NotNull
    public final BasketTagsResponse copy(@Nullable @Json(name = "bottom_sheet_title") String str, @Nullable @Json(name = "bottom_sheet_button_title") String str2, @Nullable @Json(name = "bottom_sheet_mov_message") String str3) {
        return new BasketTagsResponse(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasketTagsResponse)) {
            return false;
        }
        BasketTagsResponse basketTagsResponse = (BasketTagsResponse) obj;
        return Intrinsics.areEqual((Object) this.bottomSheetTitle, (Object) basketTagsResponse.bottomSheetTitle) && Intrinsics.areEqual((Object) this.bottomSheetButtonTitle, (Object) basketTagsResponse.bottomSheetButtonTitle) && Intrinsics.areEqual((Object) this.bottomSheetMovMessage, (Object) basketTagsResponse.bottomSheetMovMessage);
    }

    @Nullable
    public final String getBottomSheetButtonTitle() {
        return this.bottomSheetButtonTitle;
    }

    @Nullable
    public final String getBottomSheetMovMessage() {
        return this.bottomSheetMovMessage;
    }

    @Nullable
    public final String getBottomSheetTitle() {
        return this.bottomSheetTitle;
    }

    public int hashCode() {
        String str = this.bottomSheetTitle;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.bottomSheetButtonTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bottomSheetMovMessage;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.bottomSheetTitle;
        String str2 = this.bottomSheetButtonTitle;
        String str3 = this.bottomSheetMovMessage;
        return "BasketTagsResponse(bottomSheetTitle=" + str + ", bottomSheetButtonTitle=" + str2 + ", bottomSheetMovMessage=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasketTagsResponse(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }
}
