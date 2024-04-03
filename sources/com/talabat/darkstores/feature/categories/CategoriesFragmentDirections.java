package com.talabat.darkstores.feature.categories;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.talabat.darkstores.NavGraphDirections;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.model.Category;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.utils.Constants;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragmentDirections;", "", "()V", "ActionCategoriesFragmentToCategoriesOverviewBottomSheet", "ActionCategoriesFragmentToFlutterSearchFragment", "ActionCategoriesFragmentToSearchResultsFragment", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesFragmentDirections {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragmentDirections$ActionCategoriesFragmentToCategoriesOverviewBottomSheet;", "Landroidx/navigation/NavDirections;", "categories", "", "Lcom/talabat/darkstores/model/Category;", "([Lcom/talabat/darkstores/model/Category;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getCategories", "()[Lcom/talabat/darkstores/model/Category;", "[Lcom/talabat/darkstores/model/Category;", "component1", "copy", "([Lcom/talabat/darkstores/model/Category;)Lcom/talabat/darkstores/feature/categories/CategoriesFragmentDirections$ActionCategoriesFragmentToCategoriesOverviewBottomSheet;", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionCategoriesFragmentToCategoriesOverviewBottomSheet implements NavDirections {
        private final int actionId = R.id.action_categoriesFragment_to_categoriesOverviewBottomSheet;
        @NotNull
        private final Category[] categories;

        public ActionCategoriesFragmentToCategoriesOverviewBottomSheet(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            this.categories = categoryArr;
        }

        public static /* synthetic */ ActionCategoriesFragmentToCategoriesOverviewBottomSheet copy$default(ActionCategoriesFragmentToCategoriesOverviewBottomSheet actionCategoriesFragmentToCategoriesOverviewBottomSheet, Category[] categoryArr, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                categoryArr = actionCategoriesFragmentToCategoriesOverviewBottomSheet.categories;
            }
            return actionCategoriesFragmentToCategoriesOverviewBottomSheet.copy(categoryArr);
        }

        @NotNull
        public final Category[] component1() {
            return this.categories;
        }

        @NotNull
        public final ActionCategoriesFragmentToCategoriesOverviewBottomSheet copy(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            return new ActionCategoriesFragmentToCategoriesOverviewBottomSheet(categoryArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActionCategoriesFragmentToCategoriesOverviewBottomSheet) && Intrinsics.areEqual((Object) this.categories, (Object) ((ActionCategoriesFragmentToCategoriesOverviewBottomSheet) obj).categories);
        }

        public int getActionId() {
            return this.actionId;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("categories", (Parcelable[]) this.categories);
            return bundle;
        }

        @NotNull
        public final Category[] getCategories() {
            return this.categories;
        }

        public int hashCode() {
            return Arrays.hashCode(this.categories);
        }

        @NotNull
        public String toString() {
            String arrays = Arrays.toString(this.categories);
            return "ActionCategoriesFragmentToCategoriesOverviewBottomSheet(categories=" + arrays + ")";
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragmentDirections$ActionCategoriesFragmentToFlutterSearchFragment;", "Landroidx/navigation/NavDirections;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getConfigurationParams", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "getRoute", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionCategoriesFragmentToFlutterSearchFragment implements NavDirections {
        private final int actionId = R.id.action_categoriesFragment_to_flutterSearchFragment;
        @NotNull
        private final FlutterConfigurationParams configurationParams;
        @NotNull
        private final FlutterRoute route;

        public ActionCategoriesFragmentToFlutterSearchFragment(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            this.configurationParams = flutterConfigurationParams;
            this.route = flutterRoute;
        }

        public static /* synthetic */ ActionCategoriesFragmentToFlutterSearchFragment copy$default(ActionCategoriesFragmentToFlutterSearchFragment actionCategoriesFragmentToFlutterSearchFragment, FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                flutterConfigurationParams = actionCategoriesFragmentToFlutterSearchFragment.configurationParams;
            }
            if ((i11 & 2) != 0) {
                flutterRoute = actionCategoriesFragmentToFlutterSearchFragment.route;
            }
            return actionCategoriesFragmentToFlutterSearchFragment.copy(flutterConfigurationParams, flutterRoute);
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
        public final ActionCategoriesFragmentToFlutterSearchFragment copy(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            return new ActionCategoriesFragmentToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionCategoriesFragmentToFlutterSearchFragment)) {
                return false;
            }
            ActionCategoriesFragmentToFlutterSearchFragment actionCategoriesFragmentToFlutterSearchFragment = (ActionCategoriesFragmentToFlutterSearchFragment) obj;
            return Intrinsics.areEqual((Object) this.configurationParams, (Object) actionCategoriesFragmentToFlutterSearchFragment.configurationParams) && Intrinsics.areEqual((Object) this.route, (Object) actionCategoriesFragmentToFlutterSearchFragment.route);
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
            return "ActionCategoriesFragmentToFlutterSearchFragment(configurationParams=" + flutterConfigurationParams + ", route=" + flutterRoute + ")";
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u0004J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013JV\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u00132\b\b\u0002\u0010\u001e\u001a\u00020\u0013¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragmentDirections$Companion;", "", "()V", "actionCategoriesFragmentToCategoriesOverviewBottomSheet", "Landroidx/navigation/NavDirections;", "categories", "", "Lcom/talabat/darkstores/model/Category;", "([Lcom/talabat/darkstores/model/Category;)Landroidx/navigation/NavDirections;", "actionCategoriesFragmentToFlutterSearchFragment", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "actionCategoriesFragmentToSearchFragment", "actionCategoriesFragmentToSearchResultsFragment", "resultsType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "eventOrigin", "", "actionToProductFragment", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavDirections actionCategoriesFragmentToSearchResultsFragment$default(Companion companion, SearchResultsType searchResultsType, String str, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str = null;
            }
            return companion.actionCategoriesFragmentToSearchResultsFragment(searchResultsType, str);
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
        public final NavDirections actionCategoriesFragmentToCategoriesOverviewBottomSheet(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            return new ActionCategoriesFragmentToCategoriesOverviewBottomSheet(categoryArr);
        }

        @NotNull
        public final NavDirections actionCategoriesFragmentToFlutterSearchFragment(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            return new ActionCategoriesFragmentToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
        }

        @NotNull
        public final NavDirections actionCategoriesFragmentToSearchFragment() {
            return new ActionOnlyNavDirections(R.id.action_categoriesFragment_to_searchFragment);
        }

        @NotNull
        public final NavDirections actionCategoriesFragmentToSearchResultsFragment(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            return new ActionCategoriesFragmentToSearchResultsFragment(searchResultsType, str);
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

    private CategoriesFragmentDirections() {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragmentDirections$ActionCategoriesFragmentToSearchResultsFragment;", "Landroidx/navigation/NavDirections;", "resultsType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "eventOrigin", "", "(Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;Ljava/lang/String;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getEventOrigin", "()Ljava/lang/String;", "getResultsType", "()Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionCategoriesFragmentToSearchResultsFragment implements NavDirections {
        private final int actionId;
        @Nullable
        private final String eventOrigin;
        @NotNull
        private final SearchResultsType resultsType;

        public ActionCategoriesFragmentToSearchResultsFragment(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            this.resultsType = searchResultsType;
            this.eventOrigin = str;
            this.actionId = R.id.action_categoriesFragment_to_searchResultsFragment;
        }

        public static /* synthetic */ ActionCategoriesFragmentToSearchResultsFragment copy$default(ActionCategoriesFragmentToSearchResultsFragment actionCategoriesFragmentToSearchResultsFragment, SearchResultsType searchResultsType, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                searchResultsType = actionCategoriesFragmentToSearchResultsFragment.resultsType;
            }
            if ((i11 & 2) != 0) {
                str = actionCategoriesFragmentToSearchResultsFragment.eventOrigin;
            }
            return actionCategoriesFragmentToSearchResultsFragment.copy(searchResultsType, str);
        }

        @NotNull
        public final SearchResultsType component1() {
            return this.resultsType;
        }

        @Nullable
        public final String component2() {
            return this.eventOrigin;
        }

        @NotNull
        public final ActionCategoriesFragmentToSearchResultsFragment copy(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            return new ActionCategoriesFragmentToSearchResultsFragment(searchResultsType, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionCategoriesFragmentToSearchResultsFragment)) {
                return false;
            }
            ActionCategoriesFragmentToSearchResultsFragment actionCategoriesFragmentToSearchResultsFragment = (ActionCategoriesFragmentToSearchResultsFragment) obj;
            return Intrinsics.areEqual((Object) this.resultsType, (Object) actionCategoriesFragmentToSearchResultsFragment.resultsType) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) actionCategoriesFragmentToSearchResultsFragment.eventOrigin);
        }

        public int getActionId() {
            return this.actionId;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            Class<SearchResultsType> cls = SearchResultsType.class;
            if (Parcelable.class.isAssignableFrom(cls)) {
                bundle.putParcelable("resultsType", this.resultsType);
            } else if (Serializable.class.isAssignableFrom(cls)) {
                bundle.putSerializable("resultsType", (Serializable) this.resultsType);
            } else {
                String name2 = cls.getName();
                throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            bundle.putString("eventOrigin", this.eventOrigin);
            return bundle;
        }

        @Nullable
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        @NotNull
        public final SearchResultsType getResultsType() {
            return this.resultsType;
        }

        public int hashCode() {
            int hashCode = this.resultsType.hashCode() * 31;
            String str = this.eventOrigin;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            SearchResultsType searchResultsType = this.resultsType;
            String str = this.eventOrigin;
            return "ActionCategoriesFragmentToSearchResultsFragment(resultsType=" + searchResultsType + ", eventOrigin=" + str + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionCategoriesFragmentToSearchResultsFragment(SearchResultsType searchResultsType, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(searchResultsType, (i11 & 2) != 0 ? null : str);
        }
    }
}
