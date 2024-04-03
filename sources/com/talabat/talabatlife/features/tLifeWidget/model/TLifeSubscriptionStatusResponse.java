package com.talabat.talabatlife.features.tLifeWidget.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/talabatlife/features/tLifeWidget/model/TLifeSubscriptionStatusResponse;", "", "()V", "isSubscribed", "", "()Ljava/lang/Boolean;", "setSubscribed", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeSubscriptionStatusResponse {
    @SerializedName("isSubscribed")
    @Nullable
    private Boolean isSubscribed;

    @Nullable
    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setSubscribed(@Nullable Boolean bool) {
        this.isSubscribed = bool;
    }
}
