package com.talabat.splash.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/splash/domain/model/AppInfoRequestModel;", "", "countryId", "", "flowType", "Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "ignoreCustomerInfoReturnedFromAppInfo", "", "(ILcom/talabat/splash/domain/model/SplashRedirectionWrapper;Z)V", "getCountryId", "()I", "getFlowType", "()Lcom/talabat/splash/domain/model/SplashRedirectionWrapper;", "getIgnoreCustomerInfoReturnedFromAppInfo", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoRequestModel {
    private final int countryId;
    @Nullable
    private final SplashRedirectionWrapper flowType;
    private final boolean ignoreCustomerInfoReturnedFromAppInfo;

    public AppInfoRequestModel(int i11, @Nullable SplashRedirectionWrapper splashRedirectionWrapper, boolean z11) {
        this.countryId = i11;
        this.flowType = splashRedirectionWrapper;
        this.ignoreCustomerInfoReturnedFromAppInfo = z11;
    }

    public static /* synthetic */ AppInfoRequestModel copy$default(AppInfoRequestModel appInfoRequestModel, int i11, SplashRedirectionWrapper splashRedirectionWrapper, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = appInfoRequestModel.countryId;
        }
        if ((i12 & 2) != 0) {
            splashRedirectionWrapper = appInfoRequestModel.flowType;
        }
        if ((i12 & 4) != 0) {
            z11 = appInfoRequestModel.ignoreCustomerInfoReturnedFromAppInfo;
        }
        return appInfoRequestModel.copy(i11, splashRedirectionWrapper, z11);
    }

    public final int component1() {
        return this.countryId;
    }

    @Nullable
    public final SplashRedirectionWrapper component2() {
        return this.flowType;
    }

    public final boolean component3() {
        return this.ignoreCustomerInfoReturnedFromAppInfo;
    }

    @NotNull
    public final AppInfoRequestModel copy(int i11, @Nullable SplashRedirectionWrapper splashRedirectionWrapper, boolean z11) {
        return new AppInfoRequestModel(i11, splashRedirectionWrapper, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppInfoRequestModel)) {
            return false;
        }
        AppInfoRequestModel appInfoRequestModel = (AppInfoRequestModel) obj;
        return this.countryId == appInfoRequestModel.countryId && Intrinsics.areEqual((Object) this.flowType, (Object) appInfoRequestModel.flowType) && this.ignoreCustomerInfoReturnedFromAppInfo == appInfoRequestModel.ignoreCustomerInfoReturnedFromAppInfo;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final SplashRedirectionWrapper getFlowType() {
        return this.flowType;
    }

    public final boolean getIgnoreCustomerInfoReturnedFromAppInfo() {
        return this.ignoreCustomerInfoReturnedFromAppInfo;
    }

    public int hashCode() {
        int i11 = this.countryId * 31;
        SplashRedirectionWrapper splashRedirectionWrapper = this.flowType;
        int hashCode = (i11 + (splashRedirectionWrapper == null ? 0 : splashRedirectionWrapper.hashCode())) * 31;
        boolean z11 = this.ignoreCustomerInfoReturnedFromAppInfo;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        int i11 = this.countryId;
        SplashRedirectionWrapper splashRedirectionWrapper = this.flowType;
        boolean z11 = this.ignoreCustomerInfoReturnedFromAppInfo;
        return "AppInfoRequestModel(countryId=" + i11 + ", flowType=" + splashRedirectionWrapper + ", ignoreCustomerInfoReturnedFromAppInfo=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppInfoRequestModel(int i11, SplashRedirectionWrapper splashRedirectionWrapper, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, splashRedirectionWrapper, (i12 & 4) != 0 ? false : z11);
    }
}
