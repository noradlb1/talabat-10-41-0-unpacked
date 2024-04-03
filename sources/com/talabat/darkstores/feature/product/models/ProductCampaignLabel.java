package com.talabat.darkstores.feature.product.models;

import android.content.res.Resources;
import com.talabat.localization.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00072\u00020\u0001:\u0004\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "", "()V", "asString", "", "resources", "Landroid/content/res/Resources;", "Companion", "Discount", "FreeItem", "None", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$None;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$FreeItem;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$Discount;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ProductCampaignLabel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$Companion;", "", "()V", "discount", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "", "mixAndMatch", "campaignName", "none", "sameItemBundle", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProductCampaignLabel discount(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "discount");
            return new Discount(str);
        }

        @NotNull
        public final ProductCampaignLabel mixAndMatch(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "campaignName");
            return new FreeItem.MixAndMatch(str);
        }

        @NotNull
        public final ProductCampaignLabel none() {
            return None.INSTANCE;
        }

        @NotNull
        public final ProductCampaignLabel sameItemBundle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "campaignName");
            return new FreeItem.SameItemBundle(str);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$Discount;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "discount", "", "(Ljava/lang/String;)V", "getDiscount", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Discount extends ProductCampaignLabel {
        @NotNull
        private final String discount;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Discount(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "discount");
            this.discount = str;
        }

        public static /* synthetic */ Discount copy$default(Discount discount2, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = discount2.discount;
            }
            return discount2.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.discount;
        }

        @NotNull
        public final Discount copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "discount");
            return new Discount(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Discount) && Intrinsics.areEqual((Object) this.discount, (Object) ((Discount) obj).discount);
        }

        @NotNull
        public final String getDiscount() {
            return this.discount;
        }

        public int hashCode() {
            return this.discount.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.discount;
            return "Discount(discount=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$FreeItem;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "()V", "campaignName", "", "getCampaignName", "()Ljava/lang/String;", "MixAndMatch", "SameItemBundle", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$FreeItem$MixAndMatch;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$FreeItem$SameItemBundle;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class FreeItem extends ProductCampaignLabel {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$FreeItem$MixAndMatch;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$FreeItem;", "campaignName", "", "(Ljava/lang/String;)V", "getCampaignName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class MixAndMatch extends FreeItem {
            @NotNull
            private final String campaignName;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MixAndMatch(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "campaignName");
                this.campaignName = str;
            }

            public static /* synthetic */ MixAndMatch copy$default(MixAndMatch mixAndMatch, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = mixAndMatch.getCampaignName();
                }
                return mixAndMatch.copy(str);
            }

            @NotNull
            public final String component1() {
                return getCampaignName();
            }

            @NotNull
            public final MixAndMatch copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "campaignName");
                return new MixAndMatch(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MixAndMatch) && Intrinsics.areEqual((Object) getCampaignName(), (Object) ((MixAndMatch) obj).getCampaignName());
            }

            @NotNull
            public String getCampaignName() {
                return this.campaignName;
            }

            public int hashCode() {
                return getCampaignName().hashCode();
            }

            @NotNull
            public String toString() {
                String campaignName2 = getCampaignName();
                return "MixAndMatch(campaignName=" + campaignName2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$FreeItem$SameItemBundle;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$FreeItem;", "campaignName", "", "(Ljava/lang/String;)V", "getCampaignName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class SameItemBundle extends FreeItem {
            @NotNull
            private final String campaignName;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SameItemBundle(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "campaignName");
                this.campaignName = str;
            }

            public static /* synthetic */ SameItemBundle copy$default(SameItemBundle sameItemBundle, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = sameItemBundle.getCampaignName();
                }
                return sameItemBundle.copy(str);
            }

            @NotNull
            public final String component1() {
                return getCampaignName();
            }

            @NotNull
            public final SameItemBundle copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "campaignName");
                return new SameItemBundle(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SameItemBundle) && Intrinsics.areEqual((Object) getCampaignName(), (Object) ((SameItemBundle) obj).getCampaignName());
            }

            @NotNull
            public String getCampaignName() {
                return this.campaignName;
            }

            public int hashCode() {
                return getCampaignName().hashCode();
            }

            @NotNull
            public String toString() {
                String campaignName2 = getCampaignName();
                return "SameItemBundle(campaignName=" + campaignName2 + ")";
            }
        }

        private FreeItem() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ FreeItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public abstract String getCampaignName();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel$None;", "Lcom/talabat/darkstores/feature/product/models/ProductCampaignLabel;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class None extends ProductCampaignLabel {
        @NotNull
        public static final None INSTANCE = new None();

        private None() {
            super((DefaultConstructorMarker) null);
        }
    }

    private ProductCampaignLabel() {
    }

    public /* synthetic */ ProductCampaignLabel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public final String asString(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (Intrinsics.areEqual((Object) this, (Object) None.INSTANCE)) {
            return null;
        }
        if (this instanceof FreeItem) {
            return ((FreeItem) this).getCampaignName();
        }
        if (this instanceof Discount) {
            return resources.getString(R.string.product_details_saved, new Object[]{((Discount) this).getDiscount()});
        }
        throw new NoWhenBranchMatchedException();
    }
}
