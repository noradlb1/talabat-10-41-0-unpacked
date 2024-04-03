package com.talabat.darkstores.feature.categories.subcategories.sort;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.NavGraphDirections;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.feature.darkstorescart.data.model.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetDirections;", "", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortOptionBottomSheetDirections {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetDirections$Companion;", "", "()V", "actionToProductFragment", "Landroidx/navigation/NavDirections;", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "", "eventOrigin", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
            return NavGraphDirections.Companion.actionToProductFragment(product, z11, str, str2, productClickTrackingAttribute, str6, str7, str8);
        }
    }

    private SortOptionBottomSheetDirections() {
    }
}
