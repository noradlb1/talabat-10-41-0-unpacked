package com.talabat.darkstores.feature.product.models;

import android.content.res.Resources;
import com.talabat.localization.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel;", "", "()V", "asString", "", "resources", "Landroid/content/res/Resources;", "MixAndMatch", "PopularProducts", "Swimlanes", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$PopularProducts;", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$Swimlanes;", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$MixAndMatch;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SwimlaneLabel {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$MixAndMatch;", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel;", "()V", "benefitsCount", "", "getBenefitsCount", "()I", "Discounted", "Free", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$MixAndMatch$Free;", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$MixAndMatch$Discounted;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class MixAndMatch extends SwimlaneLabel {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$MixAndMatch$Discounted;", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$MixAndMatch;", "benefitsCount", "", "(I)V", "getBenefitsCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Discounted extends MixAndMatch {
            private final int benefitsCount;

            public Discounted(int i11) {
                super((DefaultConstructorMarker) null);
                this.benefitsCount = i11;
            }

            public static /* synthetic */ Discounted copy$default(Discounted discounted, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    i11 = discounted.getBenefitsCount();
                }
                return discounted.copy(i11);
            }

            public final int component1() {
                return getBenefitsCount();
            }

            @NotNull
            public final Discounted copy(int i11) {
                return new Discounted(i11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Discounted) && getBenefitsCount() == ((Discounted) obj).getBenefitsCount();
            }

            public int getBenefitsCount() {
                return this.benefitsCount;
            }

            public int hashCode() {
                return getBenefitsCount();
            }

            @NotNull
            public String toString() {
                int benefitsCount2 = getBenefitsCount();
                return "Discounted(benefitsCount=" + benefitsCount2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$MixAndMatch$Free;", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$MixAndMatch;", "benefitsCount", "", "(I)V", "getBenefitsCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Free extends MixAndMatch {
            private final int benefitsCount;

            public Free(int i11) {
                super((DefaultConstructorMarker) null);
                this.benefitsCount = i11;
            }

            public static /* synthetic */ Free copy$default(Free free, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    i11 = free.getBenefitsCount();
                }
                return free.copy(i11);
            }

            public final int component1() {
                return getBenefitsCount();
            }

            @NotNull
            public final Free copy(int i11) {
                return new Free(i11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Free) && getBenefitsCount() == ((Free) obj).getBenefitsCount();
            }

            public int getBenefitsCount() {
                return this.benefitsCount;
            }

            public int hashCode() {
                return getBenefitsCount();
            }

            @NotNull
            public String toString() {
                int benefitsCount2 = getBenefitsCount();
                return "Free(benefitsCount=" + benefitsCount2 + ")";
            }
        }

        private MixAndMatch() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ MixAndMatch(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getBenefitsCount();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$PopularProducts;", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PopularProducts extends SwimlaneLabel {
        @NotNull
        public static final PopularProducts INSTANCE = new PopularProducts();

        private PopularProducts() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel$Swimlanes;", "Lcom/talabat/darkstores/feature/product/models/SwimlaneLabel;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Swimlanes extends SwimlaneLabel {
        @NotNull
        public static final Swimlanes INSTANCE = new Swimlanes();

        private Swimlanes() {
            super((DefaultConstructorMarker) null);
        }
    }

    private SwimlaneLabel() {
    }

    public /* synthetic */ SwimlaneLabel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final String asString(@NotNull Resources resources) {
        String str;
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (Intrinsics.areEqual((Object) this, (Object) PopularProducts.INSTANCE)) {
            str = resources.getString(R.string.suggested);
        } else if (Intrinsics.areEqual((Object) this, (Object) Swimlanes.INSTANCE)) {
            throw new IllegalStateException();
        } else if (this instanceof MixAndMatch.Free) {
            MixAndMatch.Free free = (MixAndMatch.Free) this;
            str = resources.getQuantityString(R.plurals.choose_free_item, free.getBenefitsCount(), new Object[]{Integer.valueOf(free.getBenefitsCount())});
        } else if (this instanceof MixAndMatch.Discounted) {
            MixAndMatch.Discounted discounted = (MixAndMatch.Discounted) this;
            str = resources.getQuantityString(R.plurals.choose_discounted_item, discounted.getBenefitsCount(), new Object[]{Integer.valueOf(discounted.getBenefitsCount())});
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullExpressionValue(str, "when (this) {\n        Po…fitsCount\n        )\n    }");
        return str;
    }
}
