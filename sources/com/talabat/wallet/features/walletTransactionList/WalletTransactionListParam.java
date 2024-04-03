package com.talabat.wallet.features.walletTransactionList;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/WalletTransactionListParam;", "", "countryId", "", "take", "skip", "(III)V", "getCountryId", "()I", "getSkip", "getTake", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionListParam {
    private final int countryId;
    private final int skip;
    private final int take;

    public WalletTransactionListParam(int i11, int i12, int i13) {
        this.countryId = i11;
        this.take = i12;
        this.skip = i13;
    }

    public static /* synthetic */ WalletTransactionListParam copy$default(WalletTransactionListParam walletTransactionListParam, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = walletTransactionListParam.countryId;
        }
        if ((i14 & 2) != 0) {
            i12 = walletTransactionListParam.take;
        }
        if ((i14 & 4) != 0) {
            i13 = walletTransactionListParam.skip;
        }
        return walletTransactionListParam.copy(i11, i12, i13);
    }

    public final int component1() {
        return this.countryId;
    }

    public final int component2() {
        return this.take;
    }

    public final int component3() {
        return this.skip;
    }

    @NotNull
    public final WalletTransactionListParam copy(int i11, int i12, int i13) {
        return new WalletTransactionListParam(i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionListParam)) {
            return false;
        }
        WalletTransactionListParam walletTransactionListParam = (WalletTransactionListParam) obj;
        return this.countryId == walletTransactionListParam.countryId && this.take == walletTransactionListParam.take && this.skip == walletTransactionListParam.skip;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    public final int getSkip() {
        return this.skip;
    }

    public final int getTake() {
        return this.take;
    }

    public int hashCode() {
        return (((this.countryId * 31) + this.take) * 31) + this.skip;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        int i12 = this.take;
        int i13 = this.skip;
        return "WalletTransactionListParam(countryId=" + i11 + ", take=" + i12 + ", skip=" + i13 + ")";
    }
}
