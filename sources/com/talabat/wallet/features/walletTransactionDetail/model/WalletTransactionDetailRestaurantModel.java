package com.talabat.wallet.features.walletTransactionDetail.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRestaurantModel;", "", "name", "", "areaName", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAreaName", "()Ljava/lang/String;", "getImageUrl", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailRestaurantModel {
    @SerializedName("areaName")
    @Nullable
    private final String areaName;
    @SerializedName("imageUrl")
    @Nullable
    private final String imageUrl;
    @SerializedName("name")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f12600name;

    public WalletTransactionDetailRestaurantModel(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f12600name = str;
        this.areaName = str2;
        this.imageUrl = str3;
    }

    public static /* synthetic */ WalletTransactionDetailRestaurantModel copy$default(WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = walletTransactionDetailRestaurantModel.f12600name;
        }
        if ((i11 & 2) != 0) {
            str2 = walletTransactionDetailRestaurantModel.areaName;
        }
        if ((i11 & 4) != 0) {
            str3 = walletTransactionDetailRestaurantModel.imageUrl;
        }
        return walletTransactionDetailRestaurantModel.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.f12600name;
    }

    @Nullable
    public final String component2() {
        return this.areaName;
    }

    @Nullable
    public final String component3() {
        return this.imageUrl;
    }

    @NotNull
    public final WalletTransactionDetailRestaurantModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new WalletTransactionDetailRestaurantModel(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionDetailRestaurantModel)) {
            return false;
        }
        WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel = (WalletTransactionDetailRestaurantModel) obj;
        return Intrinsics.areEqual((Object) this.f12600name, (Object) walletTransactionDetailRestaurantModel.f12600name) && Intrinsics.areEqual((Object) this.areaName, (Object) walletTransactionDetailRestaurantModel.areaName) && Intrinsics.areEqual((Object) this.imageUrl, (Object) walletTransactionDetailRestaurantModel.imageUrl);
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getName() {
        return this.f12600name;
    }

    public int hashCode() {
        String str = this.f12600name;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.areaName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageUrl;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f12600name;
        String str2 = this.areaName;
        String str3 = this.imageUrl;
        return "WalletTransactionDetailRestaurantModel(name=" + str + ", areaName=" + str2 + ", imageUrl=" + str3 + ")";
    }
}
