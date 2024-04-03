package com.talabat.feature.referafriend.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/referafriend/domain/models/RafRemoteConfig;", "", "senderVoucherValue", "Lcom/talabat/feature/referafriend/domain/models/SenderVoucherValue;", "(Lcom/talabat/feature/referafriend/domain/models/SenderVoucherValue;)V", "getSenderVoucherValue", "()Lcom/talabat/feature/referafriend/domain/models/SenderVoucherValue;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_refer-a-friend_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RafRemoteConfig {
    @Nullable
    private final SenderVoucherValue senderVoucherValue;

    public RafRemoteConfig() {
        this((SenderVoucherValue) null, 1, (DefaultConstructorMarker) null);
    }

    public RafRemoteConfig(@Nullable SenderVoucherValue senderVoucherValue2) {
        this.senderVoucherValue = senderVoucherValue2;
    }

    public static /* synthetic */ RafRemoteConfig copy$default(RafRemoteConfig rafRemoteConfig, SenderVoucherValue senderVoucherValue2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            senderVoucherValue2 = rafRemoteConfig.senderVoucherValue;
        }
        return rafRemoteConfig.copy(senderVoucherValue2);
    }

    @Nullable
    public final SenderVoucherValue component1() {
        return this.senderVoucherValue;
    }

    @NotNull
    public final RafRemoteConfig copy(@Nullable SenderVoucherValue senderVoucherValue2) {
        return new RafRemoteConfig(senderVoucherValue2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RafRemoteConfig) && Intrinsics.areEqual((Object) this.senderVoucherValue, (Object) ((RafRemoteConfig) obj).senderVoucherValue);
    }

    @Nullable
    public final SenderVoucherValue getSenderVoucherValue() {
        return this.senderVoucherValue;
    }

    public int hashCode() {
        SenderVoucherValue senderVoucherValue2 = this.senderVoucherValue;
        if (senderVoucherValue2 == null) {
            return 0;
        }
        return senderVoucherValue2.hashCode();
    }

    @NotNull
    public String toString() {
        SenderVoucherValue senderVoucherValue2 = this.senderVoucherValue;
        return "RafRemoteConfig(senderVoucherValue=" + senderVoucherValue2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RafRemoteConfig(SenderVoucherValue senderVoucherValue2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : senderVoucherValue2);
    }
}
