package com.talabat.talabatcommon.feature.subscriptionManagement;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/SubscriptionParam;", "", "countryIso", "", "isActive", "", "(Ljava/lang/String;Z)V", "getCountryIso", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionParam {
    @NotNull
    private final String countryIso;
    private final boolean isActive;

    public SubscriptionParam(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "countryIso");
        this.countryIso = str;
        this.isActive = z11;
    }

    public static /* synthetic */ SubscriptionParam copy$default(SubscriptionParam subscriptionParam, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionParam.countryIso;
        }
        if ((i11 & 2) != 0) {
            z11 = subscriptionParam.isActive;
        }
        return subscriptionParam.copy(str, z11);
    }

    @NotNull
    public final String component1() {
        return this.countryIso;
    }

    public final boolean component2() {
        return this.isActive;
    }

    @NotNull
    public final SubscriptionParam copy(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "countryIso");
        return new SubscriptionParam(str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionParam)) {
            return false;
        }
        SubscriptionParam subscriptionParam = (SubscriptionParam) obj;
        return Intrinsics.areEqual((Object) this.countryIso, (Object) subscriptionParam.countryIso) && this.isActive == subscriptionParam.isActive;
    }

    @NotNull
    public final String getCountryIso() {
        return this.countryIso;
    }

    public int hashCode() {
        int hashCode = this.countryIso.hashCode() * 31;
        boolean z11 = this.isActive;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    @NotNull
    public String toString() {
        String str = this.countryIso;
        boolean z11 = this.isActive;
        return "SubscriptionParam(countryIso=" + str + ", isActive=" + z11 + ")";
    }
}
