package com.talabat.darkstores.feature.product.views;

import android.content.res.Resources;
import com.talabat.darkstores.feature.product.models.ProductCampaign;
import com.talabat.localization.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000b2\u00020\u0001:\u0005\t\n\u000b\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\b\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressState;", "", "()V", "label", "", "resources", "Landroid/content/res/Resources;", "progressValue", "", "Added", "CanAddProduct", "Companion", "Fulfilled", "Hidden", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$Hidden;", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$Added;", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$CanAddProduct;", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$Fulfilled;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CampaignProgressState {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int PROGRESS_MAX_VALUE = 100;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$Added;", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState;", "added", "", "campaign", "Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "(ILcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;)V", "getAdded", "()I", "getCampaign", "()Lcom/talabat/darkstores/feature/product/models/ProductCampaign$Free;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Added extends CampaignProgressState {
        private final int added;
        @NotNull
        private final ProductCampaign.Free campaign;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Added(int i11, @NotNull ProductCampaign.Free free) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(free, "campaign");
            this.added = i11;
            this.campaign = free;
        }

        public static /* synthetic */ Added copy$default(Added added2, int i11, ProductCampaign.Free free, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = added2.added;
            }
            if ((i12 & 2) != 0) {
                free = added2.campaign;
            }
            return added2.copy(i11, free);
        }

        public final int component1() {
            return this.added;
        }

        @NotNull
        public final ProductCampaign.Free component2() {
            return this.campaign;
        }

        @NotNull
        public final Added copy(int i11, @NotNull ProductCampaign.Free free) {
            Intrinsics.checkNotNullParameter(free, "campaign");
            return new Added(i11, free);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Added)) {
                return false;
            }
            Added added2 = (Added) obj;
            return this.added == added2.added && Intrinsics.areEqual((Object) this.campaign, (Object) added2.campaign);
        }

        public final int getAdded() {
            return this.added;
        }

        @NotNull
        public final ProductCampaign.Free getCampaign() {
            return this.campaign;
        }

        public int hashCode() {
            return (this.added * 31) + this.campaign.hashCode();
        }

        @NotNull
        public String toString() {
            int i11 = this.added;
            ProductCampaign.Free free = this.campaign;
            return "Added(added=" + i11 + ", campaign=" + free + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$CanAddProduct;", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState;", "benefitCount", "", "discount", "", "(IZ)V", "getBenefitCount", "()I", "getDiscount", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CanAddProduct extends CampaignProgressState {
        private final int benefitCount;
        private final boolean discount;

        public CanAddProduct(int i11, boolean z11) {
            super((DefaultConstructorMarker) null);
            this.benefitCount = i11;
            this.discount = z11;
        }

        public static /* synthetic */ CanAddProduct copy$default(CanAddProduct canAddProduct, int i11, boolean z11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i11 = canAddProduct.benefitCount;
            }
            if ((i12 & 2) != 0) {
                z11 = canAddProduct.discount;
            }
            return canAddProduct.copy(i11, z11);
        }

        public final int component1() {
            return this.benefitCount;
        }

        public final boolean component2() {
            return this.discount;
        }

        @NotNull
        public final CanAddProduct copy(int i11, boolean z11) {
            return new CanAddProduct(i11, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CanAddProduct)) {
                return false;
            }
            CanAddProduct canAddProduct = (CanAddProduct) obj;
            return this.benefitCount == canAddProduct.benefitCount && this.discount == canAddProduct.discount;
        }

        public final int getBenefitCount() {
            return this.benefitCount;
        }

        public final boolean getDiscount() {
            return this.discount;
        }

        public int hashCode() {
            int i11 = this.benefitCount * 31;
            boolean z11 = this.discount;
            if (z11) {
                z11 = true;
            }
            return i11 + (z11 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            int i11 = this.benefitCount;
            boolean z11 = this.discount;
            return "CanAddProduct(benefitCount=" + i11 + ", discount=" + z11 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CanAddProduct(int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, (i12 & 2) != 0 ? false : z11);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$Companion;", "", "()V", "PROGRESS_MAX_VALUE", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$Fulfilled;", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Fulfilled extends CampaignProgressState {
        @NotNull
        public static final Fulfilled INSTANCE = new Fulfilled();

        private Fulfilled() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/CampaignProgressState$Hidden;", "Lcom/talabat/darkstores/feature/product/views/CampaignProgressState;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends CampaignProgressState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    private CampaignProgressState() {
    }

    public /* synthetic */ CampaignProgressState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public final String label(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (Intrinsics.areEqual((Object) this, (Object) Hidden.INSTANCE)) {
            return null;
        }
        if (this instanceof Fulfilled) {
            return resources.getString(R.string.free_item_campaign_success);
        }
        if (this instanceof CanAddProduct) {
            CanAddProduct canAddProduct = (CanAddProduct) this;
            if (canAddProduct.getDiscount()) {
                return resources.getQuantityString(R.plurals.discount_campaign_can_add, canAddProduct.getBenefitCount());
            }
            return resources.getQuantityString(R.plurals.free_item_campaign_can_add, canAddProduct.getBenefitCount());
        } else if (this instanceof Added) {
            Added added = (Added) this;
            return added.getCampaign().inProgressLabel(resources, added.getAdded());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final int progressValue() {
        Integer num;
        if (Intrinsics.areEqual((Object) this, (Object) Hidden.INSTANCE)) {
            return 0;
        }
        if (!(this instanceof Added)) {
            return 100;
        }
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m6329constructorimpl(Integer.valueOf((((Added) this).getAdded() * 100) / ((Added) this).getCampaign().requiredItems()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(num)) {
            num = 0;
        }
        return ((Number) num).intValue();
    }
}
