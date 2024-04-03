package com.talabat.darkstores.feature.home;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/feature/home/RewardsMissionItemData;", "", "chainId", "", "(I)V", "getChainId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RewardsMissionItemData {
    private final int chainId;

    public RewardsMissionItemData(int i11) {
        this.chainId = i11;
    }

    public static /* synthetic */ RewardsMissionItemData copy$default(RewardsMissionItemData rewardsMissionItemData, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = rewardsMissionItemData.chainId;
        }
        return rewardsMissionItemData.copy(i11);
    }

    public final int component1() {
        return this.chainId;
    }

    @NotNull
    public final RewardsMissionItemData copy(int i11) {
        return new RewardsMissionItemData(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RewardsMissionItemData) && this.chainId == ((RewardsMissionItemData) obj).chainId;
    }

    public final int getChainId() {
        return this.chainId;
    }

    public int hashCode() {
        return this.chainId;
    }

    @NotNull
    public String toString() {
        int i11 = this.chainId;
        return "RewardsMissionItemData(chainId=" + i11 + ")";
    }
}
