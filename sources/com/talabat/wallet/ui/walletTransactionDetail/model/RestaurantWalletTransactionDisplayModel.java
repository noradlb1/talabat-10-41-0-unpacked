package com.talabat.wallet.ui.walletTransactionDetail.model;

import com.talabat.mapper.ModelMapping;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/model/RestaurantWalletTransactionDisplayModel;", "", "name", "", "areaName", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAreaName", "()Ljava/lang/String;", "setAreaName", "(Ljava/lang/String;)V", "getImageUrl", "setImageUrl", "getName", "setName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RestaurantWalletTransactionDisplayModel {
    @NotNull
    @ModelMapping({"areaName"})
    private String areaName;
    @NotNull
    @ModelMapping({"imageUrl"})
    private String imageUrl;
    @NotNull
    @ModelMapping({"name"})

    /* renamed from: name  reason: collision with root package name */
    private String f12824name;

    public RestaurantWalletTransactionDisplayModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public RestaurantWalletTransactionDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "areaName");
        Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
        this.f12824name = str;
        this.areaName = str2;
        this.imageUrl = str3;
    }

    public static /* synthetic */ RestaurantWalletTransactionDisplayModel copy$default(RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = restaurantWalletTransactionDisplayModel.f12824name;
        }
        if ((i11 & 2) != 0) {
            str2 = restaurantWalletTransactionDisplayModel.areaName;
        }
        if ((i11 & 4) != 0) {
            str3 = restaurantWalletTransactionDisplayModel.imageUrl;
        }
        return restaurantWalletTransactionDisplayModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.f12824name;
    }

    @NotNull
    public final String component2() {
        return this.areaName;
    }

    @NotNull
    public final String component3() {
        return this.imageUrl;
    }

    @NotNull
    public final RestaurantWalletTransactionDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "areaName");
        Intrinsics.checkNotNullParameter(str3, ObservableAttributesNames.IMAGE_URL_V2);
        return new RestaurantWalletTransactionDisplayModel(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestaurantWalletTransactionDisplayModel)) {
            return false;
        }
        RestaurantWalletTransactionDisplayModel restaurantWalletTransactionDisplayModel = (RestaurantWalletTransactionDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.f12824name, (Object) restaurantWalletTransactionDisplayModel.f12824name) && Intrinsics.areEqual((Object) this.areaName, (Object) restaurantWalletTransactionDisplayModel.areaName) && Intrinsics.areEqual((Object) this.imageUrl, (Object) restaurantWalletTransactionDisplayModel.imageUrl);
    }

    @NotNull
    public final String getAreaName() {
        return this.areaName;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f12824name;
    }

    public int hashCode() {
        return (((this.f12824name.hashCode() * 31) + this.areaName.hashCode()) * 31) + this.imageUrl.hashCode();
    }

    public final void setAreaName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.areaName = str;
    }

    public final void setImageUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUrl = str;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f12824name = str;
    }

    @NotNull
    public String toString() {
        String str = this.f12824name;
        String str2 = this.areaName;
        String str3 = this.imageUrl;
        return "RestaurantWalletTransactionDisplayModel(name=" + str + ", areaName=" + str2 + ", imageUrl=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RestaurantWalletTransactionDisplayModel(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2, (i11 & 4) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str3);
    }
}
