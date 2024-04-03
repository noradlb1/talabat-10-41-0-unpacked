package com.talabat.wallet.knetStatusManager.domain.entity;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000e"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatus;", "", "isServiceDown", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KNetStatus {
    @ModelMapping({"isServiceDown"})
    private final boolean isServiceDown;

    public KNetStatus() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public KNetStatus(boolean z11) {
        this.isServiceDown = z11;
    }

    public static /* synthetic */ KNetStatus copy$default(KNetStatus kNetStatus, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = kNetStatus.isServiceDown;
        }
        return kNetStatus.copy(z11);
    }

    public final boolean component1() {
        return this.isServiceDown;
    }

    @NotNull
    public final KNetStatus copy(boolean z11) {
        return new KNetStatus(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KNetStatus) && this.isServiceDown == ((KNetStatus) obj).isServiceDown;
    }

    public int hashCode() {
        boolean z11 = this.isServiceDown;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    public final boolean isServiceDown() {
        return this.isServiceDown;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isServiceDown;
        return "KNetStatus(isServiceDown=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KNetStatus(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11);
    }
}
