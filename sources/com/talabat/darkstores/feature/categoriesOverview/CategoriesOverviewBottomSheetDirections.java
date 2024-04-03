package com.talabat.darkstores.feature.categoriesOverview;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.talabat.darkstores.NavGraphDirections;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetDirections;", "", "()V", "ActionCategoriesOverviewBottomSheetToFlutterSearchFragment", "ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesOverviewBottomSheetDirections {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetDirections$ActionCategoriesOverviewBottomSheetToFlutterSearchFragment;", "Landroidx/navigation/NavDirections;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getConfigurationParams", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "getRoute", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionCategoriesOverviewBottomSheetToFlutterSearchFragment implements NavDirections {
        private final int actionId = R.id.action_categoriesOverviewBottomSheet_to_flutterSearchFragment;
        @NotNull
        private final FlutterConfigurationParams configurationParams;
        @NotNull
        private final FlutterRoute route;

        public ActionCategoriesOverviewBottomSheetToFlutterSearchFragment(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            this.configurationParams = flutterConfigurationParams;
            this.route = flutterRoute;
        }

        public static /* synthetic */ ActionCategoriesOverviewBottomSheetToFlutterSearchFragment copy$default(ActionCategoriesOverviewBottomSheetToFlutterSearchFragment actionCategoriesOverviewBottomSheetToFlutterSearchFragment, FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                flutterConfigurationParams = actionCategoriesOverviewBottomSheetToFlutterSearchFragment.configurationParams;
            }
            if ((i11 & 2) != 0) {
                flutterRoute = actionCategoriesOverviewBottomSheetToFlutterSearchFragment.route;
            }
            return actionCategoriesOverviewBottomSheetToFlutterSearchFragment.copy(flutterConfigurationParams, flutterRoute);
        }

        @NotNull
        public final FlutterConfigurationParams component1() {
            return this.configurationParams;
        }

        @NotNull
        public final FlutterRoute component2() {
            return this.route;
        }

        @NotNull
        public final ActionCategoriesOverviewBottomSheetToFlutterSearchFragment copy(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            return new ActionCategoriesOverviewBottomSheetToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionCategoriesOverviewBottomSheetToFlutterSearchFragment)) {
                return false;
            }
            ActionCategoriesOverviewBottomSheetToFlutterSearchFragment actionCategoriesOverviewBottomSheetToFlutterSearchFragment = (ActionCategoriesOverviewBottomSheetToFlutterSearchFragment) obj;
            return Intrinsics.areEqual((Object) this.configurationParams, (Object) actionCategoriesOverviewBottomSheetToFlutterSearchFragment.configurationParams) && Intrinsics.areEqual((Object) this.route, (Object) actionCategoriesOverviewBottomSheetToFlutterSearchFragment.route);
        }

        public int getActionId() {
            return this.actionId;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            Class<Parcelable> cls = Parcelable.class;
            Class<FlutterConfigurationParams> cls2 = FlutterConfigurationParams.class;
            Class<Serializable> cls3 = Serializable.class;
            if (cls.isAssignableFrom(cls2)) {
                bundle.putParcelable(Constants.ARG_CONFIGURATION_PARAMS, this.configurationParams);
            } else if (cls3.isAssignableFrom(cls2)) {
                bundle.putSerializable(Constants.ARG_CONFIGURATION_PARAMS, (Serializable) this.configurationParams);
            } else {
                String name2 = cls2.getName();
                throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            Class<FlutterRoute> cls4 = FlutterRoute.class;
            if (cls.isAssignableFrom(cls4)) {
                bundle.putParcelable(Constants.ARG_ROUTE, this.route);
            } else if (cls3.isAssignableFrom(cls4)) {
                bundle.putSerializable(Constants.ARG_ROUTE, (Serializable) this.route);
            } else {
                String name3 = cls4.getName();
                throw new UnsupportedOperationException(name3 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            return bundle;
        }

        @NotNull
        public final FlutterConfigurationParams getConfigurationParams() {
            return this.configurationParams;
        }

        @NotNull
        public final FlutterRoute getRoute() {
            return this.route;
        }

        public int hashCode() {
            return (this.configurationParams.hashCode() * 31) + this.route.hashCode();
        }

        @NotNull
        public String toString() {
            FlutterConfigurationParams flutterConfigurationParams = this.configurationParams;
            FlutterRoute flutterRoute = this.route;
            return "ActionCategoriesOverviewBottomSheetToFlutterSearchFragment(configurationParams=" + flutterConfigurationParams + ", route=" + flutterRoute + ")";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetDirections$ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew;", "Landroidx/navigation/NavDirections;", "categoryId", "", "categoryName", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getCategoryId", "()Ljava/lang/String;", "getCategoryName", "getEventOrigin", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew implements NavDirections {
        private final int actionId = R.id.action_categoriesOverviewBottomSheet_to_subcategoriesFragmentNew;
        @NotNull
        private final String categoryId;
        @NotNull
        private final String categoryName;
        @NotNull
        private final String eventOrigin;

        public ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, "eventOrigin");
            this.categoryId = str;
            this.categoryName = str2;
            this.eventOrigin = str3;
        }

        public static /* synthetic */ ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew copy$default(ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew.categoryId;
            }
            if ((i11 & 2) != 0) {
                str2 = actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew.categoryName;
            }
            if ((i11 & 4) != 0) {
                str3 = actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew.eventOrigin;
            }
            return actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.categoryId;
        }

        @NotNull
        public final String component2() {
            return this.categoryName;
        }

        @NotNull
        public final String component3() {
            return this.eventOrigin;
        }

        @NotNull
        public final ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, "eventOrigin");
            return new ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew)) {
                return false;
            }
            ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew = (ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew) obj;
            return Intrinsics.areEqual((Object) this.categoryId, (Object) actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew.categoryId) && Intrinsics.areEqual((Object) this.categoryName, (Object) actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew.categoryName) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew.eventOrigin);
        }

        public int getActionId() {
            return this.actionId;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putString("categoryId", this.categoryId);
            bundle.putString("categoryName", this.categoryName);
            bundle.putString("eventOrigin", this.eventOrigin);
            return bundle;
        }

        @NotNull
        public final String getCategoryId() {
            return this.categoryId;
        }

        @NotNull
        public final String getCategoryName() {
            return this.categoryName;
        }

        @NotNull
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        public int hashCode() {
            return (((this.categoryId.hashCode() * 31) + this.categoryName.hashCode()) * 31) + this.eventOrigin.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.categoryId;
            String str2 = this.categoryName;
            String str3 = this.eventOrigin;
            return "ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew(categoryId=" + str + ", categoryName=" + str2 + ", eventOrigin=" + str3 + ")";
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJV\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewBottomSheetDirections$Companion;", "", "()V", "actionCategoriesOverviewBottomSheetToFlutterSearchFragment", "Landroidx/navigation/NavDirections;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew", "categoryId", "", "categoryName", "eventOrigin", "actionToProductFragment", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        public final NavDirections actionCategoriesOverviewBottomSheetToFlutterSearchFragment(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            return new ActionCategoriesOverviewBottomSheetToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
        }

        @NotNull
        public final NavDirections actionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, "eventOrigin");
            return new ActionCategoriesOverviewBottomSheetToSubcategoriesFragmentNew(str, str2, str3);
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

    private CategoriesOverviewBottomSheetDirections() {
    }
}
