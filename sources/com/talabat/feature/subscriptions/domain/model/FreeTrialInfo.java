package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/FreeTrialInfo;", "", "freeTrialDays", "", "freeTrialTitle", "", "freeTrialEligible", "", "(ILjava/lang/String;Z)V", "getFreeTrialDays", "()I", "getFreeTrialEligible", "()Z", "getFreeTrialTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FreeTrialInfo {
    private final int freeTrialDays;
    private final boolean freeTrialEligible;
    @NotNull
    private final String freeTrialTitle;

    public FreeTrialInfo(int i11, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "freeTrialTitle");
        this.freeTrialDays = i11;
        this.freeTrialTitle = str;
        this.freeTrialEligible = z11;
    }

    public static /* synthetic */ FreeTrialInfo copy$default(FreeTrialInfo freeTrialInfo, int i11, String str, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = freeTrialInfo.freeTrialDays;
        }
        if ((i12 & 2) != 0) {
            str = freeTrialInfo.freeTrialTitle;
        }
        if ((i12 & 4) != 0) {
            z11 = freeTrialInfo.freeTrialEligible;
        }
        return freeTrialInfo.copy(i11, str, z11);
    }

    public final int component1() {
        return this.freeTrialDays;
    }

    @NotNull
    public final String component2() {
        return this.freeTrialTitle;
    }

    public final boolean component3() {
        return this.freeTrialEligible;
    }

    @NotNull
    public final FreeTrialInfo copy(int i11, @NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "freeTrialTitle");
        return new FreeTrialInfo(i11, str, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FreeTrialInfo)) {
            return false;
        }
        FreeTrialInfo freeTrialInfo = (FreeTrialInfo) obj;
        return this.freeTrialDays == freeTrialInfo.freeTrialDays && Intrinsics.areEqual((Object) this.freeTrialTitle, (Object) freeTrialInfo.freeTrialTitle) && this.freeTrialEligible == freeTrialInfo.freeTrialEligible;
    }

    public final int getFreeTrialDays() {
        return this.freeTrialDays;
    }

    public final boolean getFreeTrialEligible() {
        return this.freeTrialEligible;
    }

    @NotNull
    public final String getFreeTrialTitle() {
        return this.freeTrialTitle;
    }

    public int hashCode() {
        int hashCode = ((this.freeTrialDays * 31) + this.freeTrialTitle.hashCode()) * 31;
        boolean z11 = this.freeTrialEligible;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        int i11 = this.freeTrialDays;
        String str = this.freeTrialTitle;
        boolean z11 = this.freeTrialEligible;
        return "FreeTrialInfo(freeTrialDays=" + i11 + ", freeTrialTitle=" + str + ", freeTrialEligible=" + z11 + ")";
    }
}
