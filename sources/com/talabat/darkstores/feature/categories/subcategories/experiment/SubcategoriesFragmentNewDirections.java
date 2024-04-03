package com.talabat.darkstores.feature.categories.subcategories.experiment;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.talabat.darkstores.NavGraphDirections;
import com.talabat.darkstores.R;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewDirections;", "", "()V", "ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet", "ActionSubcategoriesFragmentNewToCategorySortBottomSheet", "ActionSubcategoriesFragmentNewToFlutterSearchFragment", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentNewDirections {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewDirections$ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet;", "Landroidx/navigation/NavDirections;", "categories", "", "Lcom/talabat/darkstores/model/Category;", "([Lcom/talabat/darkstores/model/Category;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getCategories", "()[Lcom/talabat/darkstores/model/Category;", "[Lcom/talabat/darkstores/model/Category;", "component1", "copy", "([Lcom/talabat/darkstores/model/Category;)Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewDirections$ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet;", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet implements NavDirections {
        private final int actionId = R.id.action_subcategoriesFragmentNew_to_categoriesOverviewBottomSheet;
        @NotNull
        private final Category[] categories;

        public ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            this.categories = categoryArr;
        }

        public static /* synthetic */ ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet copy$default(ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet actionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet, Category[] categoryArr, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                categoryArr = actionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet.categories;
            }
            return actionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet.copy(categoryArr);
        }

        @NotNull
        public final Category[] component1() {
            return this.categories;
        }

        @NotNull
        public final ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet copy(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            return new ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet(categoryArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet) && Intrinsics.areEqual((Object) this.categories, (Object) ((ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet) obj).categories);
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
            return "ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet(categories=" + arrays + ")";
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewDirections$ActionSubcategoriesFragmentNewToCategorySortBottomSheet;", "Landroidx/navigation/NavDirections;", "sortOptions", "", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "([Lcom/talabat/darkstores/data/discovery/model/SortOption;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getSortOptions", "()[Lcom/talabat/darkstores/data/discovery/model/SortOption;", "[Lcom/talabat/darkstores/data/discovery/model/SortOption;", "component1", "copy", "([Lcom/talabat/darkstores/data/discovery/model/SortOption;)Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewDirections$ActionSubcategoriesFragmentNewToCategorySortBottomSheet;", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionSubcategoriesFragmentNewToCategorySortBottomSheet implements NavDirections {
        private final int actionId = R.id.action_subcategoriesFragmentNew_to_categorySortBottomSheet;
        @NotNull
        private final SortOption[] sortOptions;

        public ActionSubcategoriesFragmentNewToCategorySortBottomSheet(@NotNull SortOption[] sortOptionArr) {
            Intrinsics.checkNotNullParameter(sortOptionArr, "sortOptions");
            this.sortOptions = sortOptionArr;
        }

        public static /* synthetic */ ActionSubcategoriesFragmentNewToCategorySortBottomSheet copy$default(ActionSubcategoriesFragmentNewToCategorySortBottomSheet actionSubcategoriesFragmentNewToCategorySortBottomSheet, SortOption[] sortOptionArr, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                sortOptionArr = actionSubcategoriesFragmentNewToCategorySortBottomSheet.sortOptions;
            }
            return actionSubcategoriesFragmentNewToCategorySortBottomSheet.copy(sortOptionArr);
        }

        @NotNull
        public final SortOption[] component1() {
            return this.sortOptions;
        }

        @NotNull
        public final ActionSubcategoriesFragmentNewToCategorySortBottomSheet copy(@NotNull SortOption[] sortOptionArr) {
            Intrinsics.checkNotNullParameter(sortOptionArr, "sortOptions");
            return new ActionSubcategoriesFragmentNewToCategorySortBottomSheet(sortOptionArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActionSubcategoriesFragmentNewToCategorySortBottomSheet) && Intrinsics.areEqual((Object) this.sortOptions, (Object) ((ActionSubcategoriesFragmentNewToCategorySortBottomSheet) obj).sortOptions);
        }

        public int getActionId() {
            return this.actionId;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("sortOptions", (Parcelable[]) this.sortOptions);
            return bundle;
        }

        @NotNull
        public final SortOption[] getSortOptions() {
            return this.sortOptions;
        }

        public int hashCode() {
            return Arrays.hashCode(this.sortOptions);
        }

        @NotNull
        public String toString() {
            String arrays = Arrays.toString(this.sortOptions);
            return "ActionSubcategoriesFragmentNewToCategorySortBottomSheet(sortOptions=" + arrays + ")";
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewDirections$ActionSubcategoriesFragmentNewToFlutterSearchFragment;", "Landroidx/navigation/NavDirections;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getConfigurationParams", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "getRoute", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionSubcategoriesFragmentNewToFlutterSearchFragment implements NavDirections {
        private final int actionId = R.id.action_subcategoriesFragmentNew_to_flutterSearchFragment;
        @NotNull
        private final FlutterConfigurationParams configurationParams;
        @NotNull
        private final FlutterRoute route;

        public ActionSubcategoriesFragmentNewToFlutterSearchFragment(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            this.configurationParams = flutterConfigurationParams;
            this.route = flutterRoute;
        }

        public static /* synthetic */ ActionSubcategoriesFragmentNewToFlutterSearchFragment copy$default(ActionSubcategoriesFragmentNewToFlutterSearchFragment actionSubcategoriesFragmentNewToFlutterSearchFragment, FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                flutterConfigurationParams = actionSubcategoriesFragmentNewToFlutterSearchFragment.configurationParams;
            }
            if ((i11 & 2) != 0) {
                flutterRoute = actionSubcategoriesFragmentNewToFlutterSearchFragment.route;
            }
            return actionSubcategoriesFragmentNewToFlutterSearchFragment.copy(flutterConfigurationParams, flutterRoute);
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
        public final ActionSubcategoriesFragmentNewToFlutterSearchFragment copy(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            return new ActionSubcategoriesFragmentNewToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionSubcategoriesFragmentNewToFlutterSearchFragment)) {
                return false;
            }
            ActionSubcategoriesFragmentNewToFlutterSearchFragment actionSubcategoriesFragmentNewToFlutterSearchFragment = (ActionSubcategoriesFragmentNewToFlutterSearchFragment) obj;
            return Intrinsics.areEqual((Object) this.configurationParams, (Object) actionSubcategoriesFragmentNewToFlutterSearchFragment.configurationParams) && Intrinsics.areEqual((Object) this.route, (Object) actionSubcategoriesFragmentNewToFlutterSearchFragment.route);
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
            return "ActionSubcategoriesFragmentNewToFlutterSearchFragment(configurationParams=" + flutterConfigurationParams + ", route=" + flutterRoute + ")";
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0019\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0004JV\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a¨\u0006!"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewDirections$Companion;", "", "()V", "actionSubcategoriesFragmentNewToCartFragment", "Landroidx/navigation/NavDirections;", "actionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet", "categories", "", "Lcom/talabat/darkstores/model/Category;", "([Lcom/talabat/darkstores/model/Category;)Landroidx/navigation/NavDirections;", "actionSubcategoriesFragmentNewToCategorySortBottomSheet", "sortOptions", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "([Lcom/talabat/darkstores/data/discovery/model/SortOption;)Landroidx/navigation/NavDirections;", "actionSubcategoriesFragmentNewToFlutterSearchFragment", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "actionSubcategoriesFragmentNewToSearchFragment", "actionToProductFragment", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "", "eventOrigin", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
        public final NavDirections actionSubcategoriesFragmentNewToCartFragment() {
            return new ActionOnlyNavDirections(R.id.action_subcategoriesFragmentNew_to_cartFragment);
        }

        @NotNull
        public final NavDirections actionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            return new ActionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet(categoryArr);
        }

        @NotNull
        public final NavDirections actionSubcategoriesFragmentNewToCategorySortBottomSheet(@NotNull SortOption[] sortOptionArr) {
            Intrinsics.checkNotNullParameter(sortOptionArr, "sortOptions");
            return new ActionSubcategoriesFragmentNewToCategorySortBottomSheet(sortOptionArr);
        }

        @NotNull
        public final NavDirections actionSubcategoriesFragmentNewToFlutterSearchFragment(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            return new ActionSubcategoriesFragmentNewToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
        }

        @NotNull
        public final NavDirections actionSubcategoriesFragmentNewToSearchFragment() {
            return new ActionOnlyNavDirections(R.id.action_subcategoriesFragmentNew_to_searchFragment);
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

    private SubcategoriesFragmentNewDirections() {
    }
}
