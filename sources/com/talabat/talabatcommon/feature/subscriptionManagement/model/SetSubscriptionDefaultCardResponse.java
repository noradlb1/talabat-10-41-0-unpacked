package com.talabat.talabatcommon.feature.subscriptionManagement.model;

import com.google.gson.annotations.SerializedName;
import com.talabat.talabatcommon.model.wallet.WalletErrorMessageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/subscriptionManagement/model/SetSubscriptionDefaultCardResponse;", "", "errors", "", "Lcom/talabat/talabatcommon/model/wallet/WalletErrorMessageModel;", "(Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetSubscriptionDefaultCardResponse {
    @SerializedName("errors")
    @Nullable
    private final List<WalletErrorMessageModel> errors;

    public SetSubscriptionDefaultCardResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public SetSubscriptionDefaultCardResponse(@Nullable List<WalletErrorMessageModel> list) {
        this.errors = list;
    }

    public static /* synthetic */ SetSubscriptionDefaultCardResponse copy$default(SetSubscriptionDefaultCardResponse setSubscriptionDefaultCardResponse, List<WalletErrorMessageModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = setSubscriptionDefaultCardResponse.errors;
        }
        return setSubscriptionDefaultCardResponse.copy(list);
    }

    @Nullable
    public final List<WalletErrorMessageModel> component1() {
        return this.errors;
    }

    @NotNull
    public final SetSubscriptionDefaultCardResponse copy(@Nullable List<WalletErrorMessageModel> list) {
        return new SetSubscriptionDefaultCardResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SetSubscriptionDefaultCardResponse) && Intrinsics.areEqual((Object) this.errors, (Object) ((SetSubscriptionDefaultCardResponse) obj).errors);
    }

    @Nullable
    public final List<WalletErrorMessageModel> getErrors() {
        return this.errors;
    }

    public int hashCode() {
        List<WalletErrorMessageModel> list = this.errors;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<WalletErrorMessageModel> list = this.errors;
        return "SetSubscriptionDefaultCardResponse(errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SetSubscriptionDefaultCardResponse(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }
}
