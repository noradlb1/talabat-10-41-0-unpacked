package com.talabat.splash.data.repositories;

import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/talabat/splash/data/repositories/Params;", "", "countryId", "", "cachedCustomerInfo", "Ldatamodels/CustomerInfo;", "isLoggedIn", "", "(ILdatamodels/CustomerInfo;Z)V", "getCachedCustomerInfo", "()Ldatamodels/CustomerInfo;", "getCountryId", "()I", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Params {
    @Nullable
    private final CustomerInfo cachedCustomerInfo;
    private final int countryId;
    private final boolean isLoggedIn;

    public Params(int i11, @Nullable CustomerInfo customerInfo, boolean z11) {
        this.countryId = i11;
        this.cachedCustomerInfo = customerInfo;
        this.isLoggedIn = z11;
    }

    public static /* synthetic */ Params copy$default(Params params, int i11, CustomerInfo customerInfo, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = params.countryId;
        }
        if ((i12 & 2) != 0) {
            customerInfo = params.cachedCustomerInfo;
        }
        if ((i12 & 4) != 0) {
            z11 = params.isLoggedIn;
        }
        return params.copy(i11, customerInfo, z11);
    }

    public final int component1() {
        return this.countryId;
    }

    @Nullable
    public final CustomerInfo component2() {
        return this.cachedCustomerInfo;
    }

    public final boolean component3() {
        return this.isLoggedIn;
    }

    @NotNull
    public final Params copy(int i11, @Nullable CustomerInfo customerInfo, boolean z11) {
        return new Params(i11, customerInfo, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Params)) {
            return false;
        }
        Params params = (Params) obj;
        return this.countryId == params.countryId && Intrinsics.areEqual((Object) this.cachedCustomerInfo, (Object) params.cachedCustomerInfo) && this.isLoggedIn == params.isLoggedIn;
    }

    @Nullable
    public final CustomerInfo getCachedCustomerInfo() {
        return this.cachedCustomerInfo;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    public int hashCode() {
        int i11 = this.countryId * 31;
        CustomerInfo customerInfo = this.cachedCustomerInfo;
        int hashCode = (i11 + (customerInfo == null ? 0 : customerInfo.hashCode())) * 31;
        boolean z11 = this.isLoggedIn;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        CustomerInfo customerInfo = this.cachedCustomerInfo;
        boolean z11 = this.isLoggedIn;
        return "Params(countryId=" + i11 + ", cachedCustomerInfo=" + customerInfo + ", isLoggedIn=" + z11 + ")";
    }
}
