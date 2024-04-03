package com.talabat.talabatcommon.feature.subscriptionManagement;

import com.talabat.talabatcommon.feature.subscriptionManagement.model.SubscriptionAutoRenewRequestModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/SubscriptionAutoRenewParam;", "", "subscriptionAutoRenewRequestModel", "Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;", "subscriptionMemberId", "", "(Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;Ljava/lang/String;)V", "getSubscriptionAutoRenewRequestModel", "()Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SubscriptionAutoRenewRequestModel;", "getSubscriptionMemberId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionAutoRenewParam {
    @NotNull
    private final SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel;
    @NotNull
    private final String subscriptionMemberId;

    public SubscriptionAutoRenewParam(@NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(subscriptionAutoRenewRequestModel2, "subscriptionAutoRenewRequestModel");
        Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
        this.subscriptionAutoRenewRequestModel = subscriptionAutoRenewRequestModel2;
        this.subscriptionMemberId = str;
    }

    public static /* synthetic */ SubscriptionAutoRenewParam copy$default(SubscriptionAutoRenewParam subscriptionAutoRenewParam, SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            subscriptionAutoRenewRequestModel2 = subscriptionAutoRenewParam.subscriptionAutoRenewRequestModel;
        }
        if ((i11 & 2) != 0) {
            str = subscriptionAutoRenewParam.subscriptionMemberId;
        }
        return subscriptionAutoRenewParam.copy(subscriptionAutoRenewRequestModel2, str);
    }

    @NotNull
    public final SubscriptionAutoRenewRequestModel component1() {
        return this.subscriptionAutoRenewRequestModel;
    }

    @NotNull
    public final String component2() {
        return this.subscriptionMemberId;
    }

    @NotNull
    public final SubscriptionAutoRenewParam copy(@NotNull SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(subscriptionAutoRenewRequestModel2, "subscriptionAutoRenewRequestModel");
        Intrinsics.checkNotNullParameter(str, "subscriptionMemberId");
        return new SubscriptionAutoRenewParam(subscriptionAutoRenewRequestModel2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionAutoRenewParam)) {
            return false;
        }
        SubscriptionAutoRenewParam subscriptionAutoRenewParam = (SubscriptionAutoRenewParam) obj;
        return Intrinsics.areEqual((Object) this.subscriptionAutoRenewRequestModel, (Object) subscriptionAutoRenewParam.subscriptionAutoRenewRequestModel) && Intrinsics.areEqual((Object) this.subscriptionMemberId, (Object) subscriptionAutoRenewParam.subscriptionMemberId);
    }

    @NotNull
    public final SubscriptionAutoRenewRequestModel getSubscriptionAutoRenewRequestModel() {
        return this.subscriptionAutoRenewRequestModel;
    }

    @NotNull
    public final String getSubscriptionMemberId() {
        return this.subscriptionMemberId;
    }

    public int hashCode() {
        return (this.subscriptionAutoRenewRequestModel.hashCode() * 31) + this.subscriptionMemberId.hashCode();
    }

    @NotNull
    public String toString() {
        SubscriptionAutoRenewRequestModel subscriptionAutoRenewRequestModel2 = this.subscriptionAutoRenewRequestModel;
        String str = this.subscriptionMemberId;
        return "SubscriptionAutoRenewParam(subscriptionAutoRenewRequestModel=" + subscriptionAutoRenewRequestModel2 + ", subscriptionMemberId=" + str + ")";
    }
}
