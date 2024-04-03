package com.talabat.darkstores.feature.cart.model;

import com.talabat.feature.darkstorescart.data.model.Campaign;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/CartProgressCampaign;", "", "campaign", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "progressCampaignType", "Lcom/talabat/darkstores/feature/cart/model/ProgressCampaignType;", "(Lcom/talabat/feature/darkstorescart/data/model/Campaign;Lcom/talabat/darkstores/feature/cart/model/ProgressCampaignType;)V", "getCampaign", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "getProgressCampaignType", "()Lcom/talabat/darkstores/feature/cart/model/ProgressCampaignType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartProgressCampaign {
    @NotNull
    private final Campaign campaign;
    @NotNull
    private final ProgressCampaignType progressCampaignType;

    public CartProgressCampaign(@NotNull Campaign campaign2, @NotNull ProgressCampaignType progressCampaignType2) {
        Intrinsics.checkNotNullParameter(campaign2, "campaign");
        Intrinsics.checkNotNullParameter(progressCampaignType2, "progressCampaignType");
        this.campaign = campaign2;
        this.progressCampaignType = progressCampaignType2;
    }

    public static /* synthetic */ CartProgressCampaign copy$default(CartProgressCampaign cartProgressCampaign, Campaign campaign2, ProgressCampaignType progressCampaignType2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            campaign2 = cartProgressCampaign.campaign;
        }
        if ((i11 & 2) != 0) {
            progressCampaignType2 = cartProgressCampaign.progressCampaignType;
        }
        return cartProgressCampaign.copy(campaign2, progressCampaignType2);
    }

    @NotNull
    public final Campaign component1() {
        return this.campaign;
    }

    @NotNull
    public final ProgressCampaignType component2() {
        return this.progressCampaignType;
    }

    @NotNull
    public final CartProgressCampaign copy(@NotNull Campaign campaign2, @NotNull ProgressCampaignType progressCampaignType2) {
        Intrinsics.checkNotNullParameter(campaign2, "campaign");
        Intrinsics.checkNotNullParameter(progressCampaignType2, "progressCampaignType");
        return new CartProgressCampaign(campaign2, progressCampaignType2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CartProgressCampaign)) {
            return false;
        }
        CartProgressCampaign cartProgressCampaign = (CartProgressCampaign) obj;
        return Intrinsics.areEqual((Object) this.campaign, (Object) cartProgressCampaign.campaign) && this.progressCampaignType == cartProgressCampaign.progressCampaignType;
    }

    @NotNull
    public final Campaign getCampaign() {
        return this.campaign;
    }

    @NotNull
    public final ProgressCampaignType getProgressCampaignType() {
        return this.progressCampaignType;
    }

    public int hashCode() {
        return (this.campaign.hashCode() * 31) + this.progressCampaignType.hashCode();
    }

    @NotNull
    public String toString() {
        Campaign campaign2 = this.campaign;
        ProgressCampaignType progressCampaignType2 = this.progressCampaignType;
        return "CartProgressCampaign(campaign=" + campaign2 + ", progressCampaignType=" + progressCampaignType2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartProgressCampaign(Campaign campaign2, ProgressCampaignType progressCampaignType2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(campaign2, (i11 & 2) != 0 ? ProgressCampaignType.DeliveryFee : progressCampaignType2);
    }
}
