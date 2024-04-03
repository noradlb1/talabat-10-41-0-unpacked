package com.talabat.darkstores;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/NavGraphDirections;", "", "()V", "ActionToProductFragment", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavGraphDirections {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/NavGraphDirections$Companion;", "", "()V", "actionToProductFragment", "Landroidx/navigation/NavDirections;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "", "eventOrigin", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavDirections actionToProductFragment$default(Companion companion, Product product, boolean z11, String str, String str2, ProductClickTrackingAttribute productClickTrackingAttribute, String str3, String str4, String str5, int i11, Object obj) {
            boolean z12;
            String str6;
            String str7;
            ProductClickTrackingAttribute productClickTrackingAttribute2;
            String str8;
            String str9;
            int i12 = i11;
            if ((i12 & 2) != 0) {
                z12 = true;
            } else {
                z12 = z11;
            }
            String str10 = "";
            if ((i12 & 4) != 0) {
                str6 = str10;
            } else {
                str6 = str;
            }
            if ((i12 & 8) != 0) {
                str7 = str10;
            } else {
                str7 = str2;
            }
            if ((i12 & 16) != 0) {
                productClickTrackingAttribute2 = null;
            } else {
                productClickTrackingAttribute2 = productClickTrackingAttribute;
            }
            if ((i12 & 32) != 0) {
                str8 = str10;
            } else {
                str8 = str3;
            }
            if ((i12 & 64) != 0) {
                str9 = str10;
            } else {
                str9 = str4;
            }
            if ((i12 & 128) == 0) {
                str10 = str5;
            }
            return companion.actionToProductFragment(product, z12, str6, str7, productClickTrackingAttribute2, str8, str9, str10);
        }

        @NotNull
        public final NavDirections actionToProductFragment(@NotNull Product product, boolean z11, @NotNull String str, @NotNull String str2, @Nullable ProductClickTrackingAttribute productClickTrackingAttribute, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(str, "deeplinkUri");
            Intrinsics.checkNotNullParameter(str2, "eventOrigin");
            String str6 = str3;
            Intrinsics.checkNotNullParameter(str6, "swimlaneRequestId");
            String str7 = str4;
            Intrinsics.checkNotNullParameter(str7, "searchRequestId");
            String str8 = str5;
            Intrinsics.checkNotNullParameter(str8, "searchTerm");
            return new ActionToProductFragment(product, z11, str, str2, productClickTrackingAttribute, str6, str7, str8);
        }
    }

    private NavGraphDirections() {
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J[\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0010HÖ\u0001J\t\u00100\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018¨\u00061"}, d2 = {"Lcom/talabat/darkstores/NavGraphDirections$ActionToProductFragment;", "Landroidx/navigation/NavDirections;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "", "eventOrigin", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ZLjava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getDeeplinkUri", "()Ljava/lang/String;", "getEventOrigin", "getProduct", "()Lcom/talabat/feature/darkstorescart/data/model/Product;", "getProductClickTrackingAttribute", "()Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "getSearchRequestId", "getSearchTerm", "getShouldTrackProductOpenedEvent", "()Z", "getSwimlaneRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionToProductFragment implements NavDirections {
        private final int actionId;
        @NotNull
        private final String deeplinkUri;
        @NotNull
        private final String eventOrigin;
        @NotNull
        private final Product product;
        @Nullable
        private final ProductClickTrackingAttribute productClickTrackingAttribute;
        @NotNull
        private final String searchRequestId;
        @NotNull
        private final String searchTerm;
        private final boolean shouldTrackProductOpenedEvent;
        @NotNull
        private final String swimlaneRequestId;

        public ActionToProductFragment(@NotNull Product product2, boolean z11, @NotNull String str, @NotNull String str2, @Nullable ProductClickTrackingAttribute productClickTrackingAttribute2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(product2, "product");
            Intrinsics.checkNotNullParameter(str, "deeplinkUri");
            Intrinsics.checkNotNullParameter(str2, "eventOrigin");
            Intrinsics.checkNotNullParameter(str3, "swimlaneRequestId");
            Intrinsics.checkNotNullParameter(str4, "searchRequestId");
            Intrinsics.checkNotNullParameter(str5, "searchTerm");
            this.product = product2;
            this.shouldTrackProductOpenedEvent = z11;
            this.deeplinkUri = str;
            this.eventOrigin = str2;
            this.productClickTrackingAttribute = productClickTrackingAttribute2;
            this.swimlaneRequestId = str3;
            this.searchRequestId = str4;
            this.searchTerm = str5;
            this.actionId = R.id.action_to_productFragment;
        }

        public static /* synthetic */ ActionToProductFragment copy$default(ActionToProductFragment actionToProductFragment, Product product2, boolean z11, String str, String str2, ProductClickTrackingAttribute productClickTrackingAttribute2, String str3, String str4, String str5, int i11, Object obj) {
            ActionToProductFragment actionToProductFragment2 = actionToProductFragment;
            int i12 = i11;
            return actionToProductFragment.copy((i12 & 1) != 0 ? actionToProductFragment2.product : product2, (i12 & 2) != 0 ? actionToProductFragment2.shouldTrackProductOpenedEvent : z11, (i12 & 4) != 0 ? actionToProductFragment2.deeplinkUri : str, (i12 & 8) != 0 ? actionToProductFragment2.eventOrigin : str2, (i12 & 16) != 0 ? actionToProductFragment2.productClickTrackingAttribute : productClickTrackingAttribute2, (i12 & 32) != 0 ? actionToProductFragment2.swimlaneRequestId : str3, (i12 & 64) != 0 ? actionToProductFragment2.searchRequestId : str4, (i12 & 128) != 0 ? actionToProductFragment2.searchTerm : str5);
        }

        @NotNull
        public final Product component1() {
            return this.product;
        }

        public final boolean component2() {
            return this.shouldTrackProductOpenedEvent;
        }

        @NotNull
        public final String component3() {
            return this.deeplinkUri;
        }

        @NotNull
        public final String component4() {
            return this.eventOrigin;
        }

        @Nullable
        public final ProductClickTrackingAttribute component5() {
            return this.productClickTrackingAttribute;
        }

        @NotNull
        public final String component6() {
            return this.swimlaneRequestId;
        }

        @NotNull
        public final String component7() {
            return this.searchRequestId;
        }

        @NotNull
        public final String component8() {
            return this.searchTerm;
        }

        @NotNull
        public final ActionToProductFragment copy(@NotNull Product product2, boolean z11, @NotNull String str, @NotNull String str2, @Nullable ProductClickTrackingAttribute productClickTrackingAttribute2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(product2, "product");
            Intrinsics.checkNotNullParameter(str, "deeplinkUri");
            Intrinsics.checkNotNullParameter(str2, "eventOrigin");
            String str6 = str3;
            Intrinsics.checkNotNullParameter(str6, "swimlaneRequestId");
            String str7 = str4;
            Intrinsics.checkNotNullParameter(str7, "searchRequestId");
            String str8 = str5;
            Intrinsics.checkNotNullParameter(str8, "searchTerm");
            return new ActionToProductFragment(product2, z11, str, str2, productClickTrackingAttribute2, str6, str7, str8);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionToProductFragment)) {
                return false;
            }
            ActionToProductFragment actionToProductFragment = (ActionToProductFragment) obj;
            return Intrinsics.areEqual((Object) this.product, (Object) actionToProductFragment.product) && this.shouldTrackProductOpenedEvent == actionToProductFragment.shouldTrackProductOpenedEvent && Intrinsics.areEqual((Object) this.deeplinkUri, (Object) actionToProductFragment.deeplinkUri) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) actionToProductFragment.eventOrigin) && Intrinsics.areEqual((Object) this.productClickTrackingAttribute, (Object) actionToProductFragment.productClickTrackingAttribute) && Intrinsics.areEqual((Object) this.swimlaneRequestId, (Object) actionToProductFragment.swimlaneRequestId) && Intrinsics.areEqual((Object) this.searchRequestId, (Object) actionToProductFragment.searchRequestId) && Intrinsics.areEqual((Object) this.searchTerm, (Object) actionToProductFragment.searchTerm);
        }

        public int getActionId() {
            return this.actionId;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            Class<Parcelable> cls = Parcelable.class;
            Class<Product> cls2 = Product.class;
            Class<Serializable> cls3 = Serializable.class;
            if (cls.isAssignableFrom(cls2)) {
                bundle.putParcelable("product", this.product);
            } else if (cls3.isAssignableFrom(cls2)) {
                bundle.putSerializable("product", (Serializable) this.product);
            } else {
                String name2 = cls2.getName();
                throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            bundle.putBoolean("shouldTrackProductOpenedEvent", this.shouldTrackProductOpenedEvent);
            bundle.putString("deeplinkUri", this.deeplinkUri);
            bundle.putString("eventOrigin", this.eventOrigin);
            Class<ProductClickTrackingAttribute> cls4 = ProductClickTrackingAttribute.class;
            if (cls.isAssignableFrom(cls4)) {
                bundle.putParcelable("productClickTrackingAttribute", this.productClickTrackingAttribute);
            } else if (cls3.isAssignableFrom(cls4)) {
                bundle.putSerializable("productClickTrackingAttribute", (Serializable) this.productClickTrackingAttribute);
            }
            bundle.putString("swimlaneRequestId", this.swimlaneRequestId);
            bundle.putString("searchRequestId", this.searchRequestId);
            bundle.putString("searchTerm", this.searchTerm);
            return bundle;
        }

        @NotNull
        public final String getDeeplinkUri() {
            return this.deeplinkUri;
        }

        @NotNull
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        @NotNull
        public final Product getProduct() {
            return this.product;
        }

        @Nullable
        public final ProductClickTrackingAttribute getProductClickTrackingAttribute() {
            return this.productClickTrackingAttribute;
        }

        @NotNull
        public final String getSearchRequestId() {
            return this.searchRequestId;
        }

        @NotNull
        public final String getSearchTerm() {
            return this.searchTerm;
        }

        public final boolean getShouldTrackProductOpenedEvent() {
            return this.shouldTrackProductOpenedEvent;
        }

        @NotNull
        public final String getSwimlaneRequestId() {
            return this.swimlaneRequestId;
        }

        public int hashCode() {
            int hashCode = this.product.hashCode() * 31;
            boolean z11 = this.shouldTrackProductOpenedEvent;
            if (z11) {
                z11 = true;
            }
            int hashCode2 = (((((hashCode + (z11 ? 1 : 0)) * 31) + this.deeplinkUri.hashCode()) * 31) + this.eventOrigin.hashCode()) * 31;
            ProductClickTrackingAttribute productClickTrackingAttribute2 = this.productClickTrackingAttribute;
            return ((((((hashCode2 + (productClickTrackingAttribute2 == null ? 0 : productClickTrackingAttribute2.hashCode())) * 31) + this.swimlaneRequestId.hashCode()) * 31) + this.searchRequestId.hashCode()) * 31) + this.searchTerm.hashCode();
        }

        @NotNull
        public String toString() {
            Product product2 = this.product;
            boolean z11 = this.shouldTrackProductOpenedEvent;
            String str = this.deeplinkUri;
            String str2 = this.eventOrigin;
            ProductClickTrackingAttribute productClickTrackingAttribute2 = this.productClickTrackingAttribute;
            String str3 = this.swimlaneRequestId;
            String str4 = this.searchRequestId;
            String str5 = this.searchTerm;
            return "ActionToProductFragment(product=" + product2 + ", shouldTrackProductOpenedEvent=" + z11 + ", deeplinkUri=" + str + ", eventOrigin=" + str2 + ", productClickTrackingAttribute=" + productClickTrackingAttribute2 + ", swimlaneRequestId=" + str3 + ", searchRequestId=" + str4 + ", searchTerm=" + str5 + ")";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ ActionToProductFragment(com.talabat.feature.darkstorescart.data.model.Product r9, boolean r10, java.lang.String r11, java.lang.String r12, com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
            /*
                r8 = this;
                r0 = r17
                r1 = r0 & 2
                if (r1 == 0) goto L_0x0008
                r1 = 1
                goto L_0x0009
            L_0x0008:
                r1 = r10
            L_0x0009:
                r2 = r0 & 4
                java.lang.String r3 = ""
                if (r2 == 0) goto L_0x0011
                r2 = r3
                goto L_0x0012
            L_0x0011:
                r2 = r11
            L_0x0012:
                r4 = r0 & 8
                if (r4 == 0) goto L_0x0018
                r4 = r3
                goto L_0x0019
            L_0x0018:
                r4 = r12
            L_0x0019:
                r5 = r0 & 16
                if (r5 == 0) goto L_0x001f
                r5 = 0
                goto L_0x0020
            L_0x001f:
                r5 = r13
            L_0x0020:
                r6 = r0 & 32
                if (r6 == 0) goto L_0x0026
                r6 = r3
                goto L_0x0027
            L_0x0026:
                r6 = r14
            L_0x0027:
                r7 = r0 & 64
                if (r7 == 0) goto L_0x002d
                r7 = r3
                goto L_0x002e
            L_0x002d:
                r7 = r15
            L_0x002e:
                r0 = r0 & 128(0x80, float:1.794E-43)
                if (r0 == 0) goto L_0x0033
                goto L_0x0035
            L_0x0033:
                r3 = r16
            L_0x0035:
                r10 = r8
                r11 = r9
                r12 = r1
                r13 = r2
                r14 = r4
                r15 = r5
                r16 = r6
                r17 = r7
                r18 = r3
                r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.NavGraphDirections.ActionToProductFragment.<init>(com.talabat.feature.darkstorescart.data.model.Product, boolean, java.lang.String, java.lang.String, com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
