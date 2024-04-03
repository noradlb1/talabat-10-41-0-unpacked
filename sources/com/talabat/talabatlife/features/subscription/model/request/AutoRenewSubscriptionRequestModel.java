package com.talabat.talabatlife.features.subscription.model.request;

import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatlife.features.UrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/model/request/AutoRenewSubscriptionRequestModel;", "", "isSubscriptionAutoRenewable", "", "membershipId", "", "(ZLjava/lang/String;)V", "()Z", "setSubscriptionAutoRenewable", "(Z)V", "getMembershipId", "()Ljava/lang/String;", "setMembershipId", "(Ljava/lang/String;)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoRenewSubscriptionRequestModel {
    private boolean isSubscriptionAutoRenewable;
    @NotNull
    private String membershipId;

    public AutoRenewSubscriptionRequestModel() {
        this(false, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public AutoRenewSubscriptionRequestModel(boolean z11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        this.isSubscriptionAutoRenewable = z11;
        this.membershipId = str;
    }

    @NotNull
    public final String getMembershipId() {
        return this.membershipId;
    }

    public final boolean isSubscriptionAutoRenewable() {
        return this.isSubscriptionAutoRenewable;
    }

    public final void setMembershipId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.membershipId = str;
    }

    public final void setSubscriptionAutoRenewable(boolean z11) {
        this.isSubscriptionAutoRenewable = z11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoRenewSubscriptionRequestModel(boolean z11, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str);
    }
}
