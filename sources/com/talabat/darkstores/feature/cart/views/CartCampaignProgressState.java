package com.talabat.darkstores.feature.cart.views;

import android.content.res.Resources;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import com.talabat.localization.R;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000e2\u00020\u0001:\u0007\f\r\u000e\u000f\u0010\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000b\u0001\u0006\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState;", "", "()V", "getDiscountValue", "", "trigger", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "label", "resources", "Landroid/content/res/Resources;", "progressValue", "", "Basket", "BasketFulfilled", "Companion", "DeliveryFee", "DeliveryFeeFulfilled", "Hidden", "Mov", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$Hidden;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$Mov;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$DeliveryFee;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$Basket;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$DeliveryFeeFulfilled;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$BasketFulfilled;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CartCampaignProgressState {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int PROGRESS_MAX_VALUE = 100;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$Basket;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState;", "added", "", "threshold", "campaign", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "(FFLcom/talabat/feature/darkstorescart/data/model/Campaign;)V", "getAdded", "()F", "getCampaign", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "getThreshold", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Basket extends CartCampaignProgressState {
        private final float added;
        @NotNull
        private final Campaign campaign;
        private final float threshold;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Basket(float f11, float f12, @NotNull Campaign campaign2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(campaign2, "campaign");
            this.added = f11;
            this.threshold = f12;
            this.campaign = campaign2;
        }

        public static /* synthetic */ Basket copy$default(Basket basket, float f11, float f12, Campaign campaign2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = basket.added;
            }
            if ((i11 & 2) != 0) {
                f12 = basket.threshold;
            }
            if ((i11 & 4) != 0) {
                campaign2 = basket.campaign;
            }
            return basket.copy(f11, f12, campaign2);
        }

        public final float component1() {
            return this.added;
        }

        public final float component2() {
            return this.threshold;
        }

        @NotNull
        public final Campaign component3() {
            return this.campaign;
        }

        @NotNull
        public final Basket copy(float f11, float f12, @NotNull Campaign campaign2) {
            Intrinsics.checkNotNullParameter(campaign2, "campaign");
            return new Basket(f11, f12, campaign2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Basket)) {
                return false;
            }
            Basket basket = (Basket) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.added), (Object) Float.valueOf(basket.added)) && Intrinsics.areEqual((Object) Float.valueOf(this.threshold), (Object) Float.valueOf(basket.threshold)) && Intrinsics.areEqual((Object) this.campaign, (Object) basket.campaign);
        }

        public final float getAdded() {
            return this.added;
        }

        @NotNull
        public final Campaign getCampaign() {
            return this.campaign;
        }

        public final float getThreshold() {
            return this.threshold;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.added) * 31) + Float.floatToIntBits(this.threshold)) * 31) + this.campaign.hashCode();
        }

        @NotNull
        public String toString() {
            float f11 = this.added;
            float f12 = this.threshold;
            Campaign campaign2 = this.campaign;
            return "Basket(added=" + f11 + ", threshold=" + f12 + ", campaign=" + campaign2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$BasketFulfilled;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState;", "campaign", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "(Lcom/talabat/feature/darkstorescart/data/model/Campaign;)V", "getCampaign", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BasketFulfilled extends CartCampaignProgressState {
        @NotNull
        private final Campaign campaign;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BasketFulfilled(@NotNull Campaign campaign2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(campaign2, "campaign");
            this.campaign = campaign2;
        }

        public static /* synthetic */ BasketFulfilled copy$default(BasketFulfilled basketFulfilled, Campaign campaign2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                campaign2 = basketFulfilled.campaign;
            }
            return basketFulfilled.copy(campaign2);
        }

        @NotNull
        public final Campaign component1() {
            return this.campaign;
        }

        @NotNull
        public final BasketFulfilled copy(@NotNull Campaign campaign2) {
            Intrinsics.checkNotNullParameter(campaign2, "campaign");
            return new BasketFulfilled(campaign2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BasketFulfilled) && Intrinsics.areEqual((Object) this.campaign, (Object) ((BasketFulfilled) obj).campaign);
        }

        @NotNull
        public final Campaign getCampaign() {
            return this.campaign;
        }

        public int hashCode() {
            return this.campaign.hashCode();
        }

        @NotNull
        public String toString() {
            Campaign campaign2 = this.campaign;
            return "BasketFulfilled(campaign=" + campaign2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$Companion;", "", "()V", "PROGRESS_MAX_VALUE", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$DeliveryFee;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState;", "added", "", "threshold", "campaign", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "(FFLcom/talabat/feature/darkstorescart/data/model/Campaign;)V", "getAdded", "()F", "getCampaign", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "getThreshold", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DeliveryFee extends CartCampaignProgressState {
        private final float added;
        @NotNull
        private final Campaign campaign;
        private final float threshold;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeliveryFee(float f11, float f12, @NotNull Campaign campaign2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(campaign2, "campaign");
            this.added = f11;
            this.threshold = f12;
            this.campaign = campaign2;
        }

        public static /* synthetic */ DeliveryFee copy$default(DeliveryFee deliveryFee, float f11, float f12, Campaign campaign2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = deliveryFee.added;
            }
            if ((i11 & 2) != 0) {
                f12 = deliveryFee.threshold;
            }
            if ((i11 & 4) != 0) {
                campaign2 = deliveryFee.campaign;
            }
            return deliveryFee.copy(f11, f12, campaign2);
        }

        public final float component1() {
            return this.added;
        }

        public final float component2() {
            return this.threshold;
        }

        @NotNull
        public final Campaign component3() {
            return this.campaign;
        }

        @NotNull
        public final DeliveryFee copy(float f11, float f12, @NotNull Campaign campaign2) {
            Intrinsics.checkNotNullParameter(campaign2, "campaign");
            return new DeliveryFee(f11, f12, campaign2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeliveryFee)) {
                return false;
            }
            DeliveryFee deliveryFee = (DeliveryFee) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.added), (Object) Float.valueOf(deliveryFee.added)) && Intrinsics.areEqual((Object) Float.valueOf(this.threshold), (Object) Float.valueOf(deliveryFee.threshold)) && Intrinsics.areEqual((Object) this.campaign, (Object) deliveryFee.campaign);
        }

        public final float getAdded() {
            return this.added;
        }

        @NotNull
        public final Campaign getCampaign() {
            return this.campaign;
        }

        public final float getThreshold() {
            return this.threshold;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.added) * 31) + Float.floatToIntBits(this.threshold)) * 31) + this.campaign.hashCode();
        }

        @NotNull
        public String toString() {
            float f11 = this.added;
            float f12 = this.threshold;
            Campaign campaign2 = this.campaign;
            return "DeliveryFee(added=" + f11 + ", threshold=" + f12 + ", campaign=" + campaign2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$DeliveryFeeFulfilled;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState;", "campaign", "Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "(Lcom/talabat/feature/darkstorescart/data/model/Campaign;)V", "getCampaign", "()Lcom/talabat/feature/darkstorescart/data/model/Campaign;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DeliveryFeeFulfilled extends CartCampaignProgressState {
        @NotNull
        private final Campaign campaign;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeliveryFeeFulfilled(@NotNull Campaign campaign2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(campaign2, "campaign");
            this.campaign = campaign2;
        }

        public static /* synthetic */ DeliveryFeeFulfilled copy$default(DeliveryFeeFulfilled deliveryFeeFulfilled, Campaign campaign2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                campaign2 = deliveryFeeFulfilled.campaign;
            }
            return deliveryFeeFulfilled.copy(campaign2);
        }

        @NotNull
        public final Campaign component1() {
            return this.campaign;
        }

        @NotNull
        public final DeliveryFeeFulfilled copy(@NotNull Campaign campaign2) {
            Intrinsics.checkNotNullParameter(campaign2, "campaign");
            return new DeliveryFeeFulfilled(campaign2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeliveryFeeFulfilled) && Intrinsics.areEqual((Object) this.campaign, (Object) ((DeliveryFeeFulfilled) obj).campaign);
        }

        @NotNull
        public final Campaign getCampaign() {
            return this.campaign;
        }

        public int hashCode() {
            return this.campaign.hashCode();
        }

        @NotNull
        public String toString() {
            Campaign campaign2 = this.campaign;
            return "DeliveryFeeFulfilled(campaign=" + campaign2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$Hidden;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends CartCampaignProgressState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState$Mov;", "Lcom/talabat/darkstores/feature/cart/views/CartCampaignProgressState;", "added", "", "threshold", "(FF)V", "getAdded", "()F", "getThreshold", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Mov extends CartCampaignProgressState {
        private final float added;
        private final float threshold;

        public Mov(float f11, float f12) {
            super((DefaultConstructorMarker) null);
            this.added = f11;
            this.threshold = f12;
        }

        public static /* synthetic */ Mov copy$default(Mov mov, float f11, float f12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                f11 = mov.added;
            }
            if ((i11 & 2) != 0) {
                f12 = mov.threshold;
            }
            return mov.copy(f11, f12);
        }

        public final float component1() {
            return this.added;
        }

        public final float component2() {
            return this.threshold;
        }

        @NotNull
        public final Mov copy(float f11, float f12) {
            return new Mov(f11, f12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Mov)) {
                return false;
            }
            Mov mov = (Mov) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.added), (Object) Float.valueOf(mov.added)) && Intrinsics.areEqual((Object) Float.valueOf(this.threshold), (Object) Float.valueOf(mov.threshold));
        }

        public final float getAdded() {
            return this.added;
        }

        public final float getThreshold() {
            return this.threshold;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.added) * 31) + Float.floatToIntBits(this.threshold);
        }

        @NotNull
        public String toString() {
            float f11 = this.added;
            float f12 = this.threshold;
            return "Mov(added=" + f11 + ", threshold=" + f12 + ")";
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Campaign.Type.values().length];
            iArr[Campaign.Type.PERCENTAGE.ordinal()] = 1;
            iArr[Campaign.Type.ABSOLUTE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CartCampaignProgressState() {
    }

    public /* synthetic */ CartCampaignProgressState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String getDiscountValue(Campaign campaign) {
        if (campaign.getDiscountValue() <= 0.0f) {
            return "";
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[campaign.getDiscountType().ordinal()];
        if (i11 == 1) {
            String format = NumberFormat.getPercentInstance().format(Float.valueOf(campaign.getDiscountValue() / ((float) 100)));
            Intrinsics.checkNotNullExpressionValue(format, "getPercentInstance()\n   …tValue / PERCENTAGE_BASE)");
            return format;
        } else if (i11 == 2) {
            return FloatExtensionsKt.formatCurrency(campaign.getDiscountValue());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public final String label(@NotNull Resources resources) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (Intrinsics.areEqual((Object) this, (Object) Hidden.INSTANCE)) {
            return null;
        }
        if (this instanceof DeliveryFeeFulfilled) {
            DeliveryFeeFulfilled deliveryFeeFulfilled = (DeliveryFeeFulfilled) this;
            if (deliveryFeeFulfilled.getCampaign().getDiscountType() == Campaign.Type.PERCENTAGE) {
                if (deliveryFeeFulfilled.getCampaign().getDiscountValue() == 100.0f) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    return resources.getString(R.string.ds_cart_progress_free_fulfilled);
                }
            }
            return resources.getString(R.string.ds_cart_progress_delivery_fee_discount_fulfilled, new Object[]{getDiscountValue(deliveryFeeFulfilled.getCampaign())});
        } else if (this instanceof Mov) {
            Mov mov = (Mov) this;
            return resources.getString(R.string.ds_cart_progress_mov_add, new Object[]{FloatExtensionsKt.formatCurrency(mov.getThreshold() - mov.getAdded())});
        } else if (this instanceof DeliveryFee) {
            DeliveryFee deliveryFee = (DeliveryFee) this;
            if (deliveryFee.getCampaign().getDiscountType() == Campaign.Type.PERCENTAGE) {
                if (deliveryFee.getCampaign().getDiscountValue() == 100.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    return resources.getString(R.string.ds_cart_progress_delivery_fee_free, new Object[]{FloatExtensionsKt.formatCurrency(deliveryFee.getThreshold() - deliveryFee.getAdded())});
                }
            }
            return resources.getString(R.string.ds_cart_progress_delivery_fee_discount, new Object[]{FloatExtensionsKt.formatCurrency(deliveryFee.getThreshold() - deliveryFee.getAdded()), getDiscountValue(deliveryFee.getCampaign())});
        } else if (this instanceof Basket) {
            Basket basket = (Basket) this;
            return resources.getString(R.string.ds_cart_progress_basket_discount, new Object[]{FloatExtensionsKt.formatCurrency(basket.getThreshold() - basket.getAdded()), getDiscountValue(basket.getCampaign())});
        } else if (this instanceof BasketFulfilled) {
            return resources.getString(R.string.ds_cart_progress_basket_discount_fulfilled, new Object[]{getDiscountValue(((BasketFulfilled) this).getCampaign())});
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final int progressValue() {
        Object obj;
        Object obj2;
        Object obj3;
        int i11 = 0;
        if (Intrinsics.areEqual((Object) this, (Object) Hidden.INSTANCE)) {
            return 0;
        }
        if (this instanceof Mov) {
            try {
                Result.Companion companion = Result.Companion;
                obj3 = Result.m6329constructorimpl(Integer.valueOf((int) ((((float) 100) * ((Mov) this).getAdded()) / ((Mov) this).getThreshold())));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj3 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m6335isFailureimpl(obj3)) {
                i11 = obj3;
            }
            return ((Number) i11).intValue();
        } else if (this instanceof DeliveryFee) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj2 = Result.m6329constructorimpl(Integer.valueOf((int) ((((float) 100) * ((DeliveryFee) this).getAdded()) / ((DeliveryFee) this).getThreshold())));
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
            if (!Result.m6335isFailureimpl(obj2)) {
                i11 = obj2;
            }
            return ((Number) i11).intValue();
        } else if (!(this instanceof Basket)) {
            return 100;
        } else {
            try {
                Result.Companion companion5 = Result.Companion;
                obj = Result.m6329constructorimpl(Integer.valueOf((int) ((((float) 100) * ((Basket) this).getAdded()) / ((Basket) this).getThreshold())));
            } catch (Throwable th4) {
                Result.Companion companion6 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th4));
            }
            if (!Result.m6335isFailureimpl(obj)) {
                i11 = obj;
            }
            return ((Number) i11).intValue();
        }
    }
}
