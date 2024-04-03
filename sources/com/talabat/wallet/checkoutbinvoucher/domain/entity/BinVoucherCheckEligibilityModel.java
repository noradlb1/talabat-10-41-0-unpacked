package com.talabat.wallet.checkoutbinvoucher.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/checkoutbinvoucher/domain/entity/BinVoucherCheckEligibilityModel;", "", "isGemActive", "", "isBinCampAvailable", "isDarkStore", "binNumber", "", "(ZZZLjava/lang/String;)V", "getBinNumber", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BinVoucherCheckEligibilityModel {
    @Nullable
    private final String binNumber;
    private final boolean isBinCampAvailable;
    private final boolean isDarkStore;
    private final boolean isGemActive;

    public BinVoucherCheckEligibilityModel(boolean z11, boolean z12, boolean z13, @Nullable String str) {
        this.isGemActive = z11;
        this.isBinCampAvailable = z12;
        this.isDarkStore = z13;
        this.binNumber = str;
    }

    public static /* synthetic */ BinVoucherCheckEligibilityModel copy$default(BinVoucherCheckEligibilityModel binVoucherCheckEligibilityModel, boolean z11, boolean z12, boolean z13, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = binVoucherCheckEligibilityModel.isGemActive;
        }
        if ((i11 & 2) != 0) {
            z12 = binVoucherCheckEligibilityModel.isBinCampAvailable;
        }
        if ((i11 & 4) != 0) {
            z13 = binVoucherCheckEligibilityModel.isDarkStore;
        }
        if ((i11 & 8) != 0) {
            str = binVoucherCheckEligibilityModel.binNumber;
        }
        return binVoucherCheckEligibilityModel.copy(z11, z12, z13, str);
    }

    public final boolean component1() {
        return this.isGemActive;
    }

    public final boolean component2() {
        return this.isBinCampAvailable;
    }

    public final boolean component3() {
        return this.isDarkStore;
    }

    @Nullable
    public final String component4() {
        return this.binNumber;
    }

    @NotNull
    public final BinVoucherCheckEligibilityModel copy(boolean z11, boolean z12, boolean z13, @Nullable String str) {
        return new BinVoucherCheckEligibilityModel(z11, z12, z13, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinVoucherCheckEligibilityModel)) {
            return false;
        }
        BinVoucherCheckEligibilityModel binVoucherCheckEligibilityModel = (BinVoucherCheckEligibilityModel) obj;
        return this.isGemActive == binVoucherCheckEligibilityModel.isGemActive && this.isBinCampAvailable == binVoucherCheckEligibilityModel.isBinCampAvailable && this.isDarkStore == binVoucherCheckEligibilityModel.isDarkStore && Intrinsics.areEqual((Object) this.binNumber, (Object) binVoucherCheckEligibilityModel.binNumber);
    }

    @Nullable
    public final String getBinNumber() {
        return this.binNumber;
    }

    public int hashCode() {
        boolean z11 = this.isGemActive;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.isBinCampAvailable;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isDarkStore;
        if (!z14) {
            z12 = z14;
        }
        int i13 = (i12 + (z12 ? 1 : 0)) * 31;
        String str = this.binNumber;
        return i13 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isBinCampAvailable() {
        return this.isBinCampAvailable;
    }

    public final boolean isDarkStore() {
        return this.isDarkStore;
    }

    public final boolean isGemActive() {
        return this.isGemActive;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isGemActive;
        boolean z12 = this.isBinCampAvailable;
        boolean z13 = this.isDarkStore;
        String str = this.binNumber;
        return "BinVoucherCheckEligibilityModel(isGemActive=" + z11 + ", isBinCampAvailable=" + z12 + ", isDarkStore=" + z13 + ", binNumber=" + str + ")";
    }
}
