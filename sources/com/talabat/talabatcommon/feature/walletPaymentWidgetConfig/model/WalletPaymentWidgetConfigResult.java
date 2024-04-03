package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJD\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0007\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\b\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResult;", "", "electronicPaymentMethods", "", "", "isCashEnabled", "", "isElectronicPaymentEnabled", "isWalletEnabled", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getElectronicPaymentMethods", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "setCashEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "setElectronicPaymentEnabled", "setWalletEnabled", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResult;", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentWidgetConfigResult {
    @SerializedName("electronicPaymentMethods")
    @Nullable
    private final List<Integer> electronicPaymentMethods;
    @SerializedName("isCashEnabled")
    @Nullable
    private Boolean isCashEnabled;
    @SerializedName("isElectronicPaymentEnabled")
    @Nullable
    private Boolean isElectronicPaymentEnabled;
    @SerializedName("isWalletEnabled")
    @Nullable
    private Boolean isWalletEnabled;

    public WalletPaymentWidgetConfigResult() {
        this((List) null, (Boolean) null, (Boolean) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
    }

    public WalletPaymentWidgetConfigResult(@Nullable List<Integer> list, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        this.electronicPaymentMethods = list;
        this.isCashEnabled = bool;
        this.isElectronicPaymentEnabled = bool2;
        this.isWalletEnabled = bool3;
    }

    public static /* synthetic */ WalletPaymentWidgetConfigResult copy$default(WalletPaymentWidgetConfigResult walletPaymentWidgetConfigResult, List<Integer> list, Boolean bool, Boolean bool2, Boolean bool3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = walletPaymentWidgetConfigResult.electronicPaymentMethods;
        }
        if ((i11 & 2) != 0) {
            bool = walletPaymentWidgetConfigResult.isCashEnabled;
        }
        if ((i11 & 4) != 0) {
            bool2 = walletPaymentWidgetConfigResult.isElectronicPaymentEnabled;
        }
        if ((i11 & 8) != 0) {
            bool3 = walletPaymentWidgetConfigResult.isWalletEnabled;
        }
        return walletPaymentWidgetConfigResult.copy(list, bool, bool2, bool3);
    }

    @Nullable
    public final List<Integer> component1() {
        return this.electronicPaymentMethods;
    }

    @Nullable
    public final Boolean component2() {
        return this.isCashEnabled;
    }

    @Nullable
    public final Boolean component3() {
        return this.isElectronicPaymentEnabled;
    }

    @Nullable
    public final Boolean component4() {
        return this.isWalletEnabled;
    }

    @NotNull
    public final WalletPaymentWidgetConfigResult copy(@Nullable List<Integer> list, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        return new WalletPaymentWidgetConfigResult(list, bool, bool2, bool3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletPaymentWidgetConfigResult)) {
            return false;
        }
        WalletPaymentWidgetConfigResult walletPaymentWidgetConfigResult = (WalletPaymentWidgetConfigResult) obj;
        return Intrinsics.areEqual((Object) this.electronicPaymentMethods, (Object) walletPaymentWidgetConfigResult.electronicPaymentMethods) && Intrinsics.areEqual((Object) this.isCashEnabled, (Object) walletPaymentWidgetConfigResult.isCashEnabled) && Intrinsics.areEqual((Object) this.isElectronicPaymentEnabled, (Object) walletPaymentWidgetConfigResult.isElectronicPaymentEnabled) && Intrinsics.areEqual((Object) this.isWalletEnabled, (Object) walletPaymentWidgetConfigResult.isWalletEnabled);
    }

    @Nullable
    public final List<Integer> getElectronicPaymentMethods() {
        return this.electronicPaymentMethods;
    }

    public int hashCode() {
        List<Integer> list = this.electronicPaymentMethods;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Boolean bool = this.isCashEnabled;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isElectronicPaymentEnabled;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isWalletEnabled;
        if (bool3 != null) {
            i11 = bool3.hashCode();
        }
        return hashCode3 + i11;
    }

    @Nullable
    public final Boolean isCashEnabled() {
        return this.isCashEnabled;
    }

    @Nullable
    public final Boolean isElectronicPaymentEnabled() {
        return this.isElectronicPaymentEnabled;
    }

    @Nullable
    public final Boolean isWalletEnabled() {
        return this.isWalletEnabled;
    }

    public final void setCashEnabled(@Nullable Boolean bool) {
        this.isCashEnabled = bool;
    }

    public final void setElectronicPaymentEnabled(@Nullable Boolean bool) {
        this.isElectronicPaymentEnabled = bool;
    }

    public final void setWalletEnabled(@Nullable Boolean bool) {
        this.isWalletEnabled = bool;
    }

    @NotNull
    public String toString() {
        List<Integer> list = this.electronicPaymentMethods;
        Boolean bool = this.isCashEnabled;
        Boolean bool2 = this.isElectronicPaymentEnabled;
        Boolean bool3 = this.isWalletEnabled;
        return "WalletPaymentWidgetConfigResult(electronicPaymentMethods=" + list + ", isCashEnabled=" + bool + ", isElectronicPaymentEnabled=" + bool2 + ", isWalletEnabled=" + bool3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletPaymentWidgetConfigResult(List list, Boolean bool, Boolean bool2, Boolean bool3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : bool2, (i11 & 8) != 0 ? null : bool3);
    }
}
