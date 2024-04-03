package com.talabat.darkstores.feature.cart.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel;", "", "()V", "Initial", "Populated", "Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel$Initial;", "Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel$Populated;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CartCampaignProgressModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel$Initial;", "Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Initial extends CartCampaignProgressModel {
        @NotNull
        public static final Initial INSTANCE = new Initial();

        private Initial() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel$Populated;", "Lcom/talabat/darkstores/feature/cart/model/CartCampaignProgressModel;", "campaigns", "", "Lcom/talabat/darkstores/feature/cart/model/CartProgressCampaign;", "(Ljava/util/List;)V", "getCampaigns", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Populated extends CartCampaignProgressModel {
        @NotNull
        private final List<CartProgressCampaign> campaigns;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Populated(@NotNull List<CartProgressCampaign> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "campaigns");
            this.campaigns = list;
        }

        public static /* synthetic */ Populated copy$default(Populated populated, List<CartProgressCampaign> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = populated.campaigns;
            }
            return populated.copy(list);
        }

        @NotNull
        public final List<CartProgressCampaign> component1() {
            return this.campaigns;
        }

        @NotNull
        public final Populated copy(@NotNull List<CartProgressCampaign> list) {
            Intrinsics.checkNotNullParameter(list, "campaigns");
            return new Populated(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Populated) && Intrinsics.areEqual((Object) this.campaigns, (Object) ((Populated) obj).campaigns);
        }

        @NotNull
        public final List<CartProgressCampaign> getCampaigns() {
            return this.campaigns;
        }

        public int hashCode() {
            return this.campaigns.hashCode();
        }

        @NotNull
        public String toString() {
            List<CartProgressCampaign> list = this.campaigns;
            return "Populated(campaigns=" + list + ")";
        }
    }

    private CartCampaignProgressModel() {
    }

    public /* synthetic */ CartCampaignProgressModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
