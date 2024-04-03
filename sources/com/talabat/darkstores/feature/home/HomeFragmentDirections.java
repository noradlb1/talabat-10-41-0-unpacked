package com.talabat.darkstores.feature.home;

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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentDirections;", "", "()V", "ActionHomeFragmentToCategoriesFragment", "ActionHomeFragmentToCategoriesOverviewBottomSheet", "ActionHomeFragmentToFlutterSearchFragment", "ActionHomeFragmentToSearchResultsFragment", "ActionHomeFragmentToSubcategoriesFragmentNew", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeFragmentDirections {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentDirections$ActionHomeFragmentToCategoriesFragment;", "Landroidx/navigation/NavDirections;", "category", "Lcom/talabat/darkstores/model/Category;", "eventOrigin", "", "(Lcom/talabat/darkstores/model/Category;Ljava/lang/String;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getCategory", "()Lcom/talabat/darkstores/model/Category;", "getEventOrigin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionHomeFragmentToCategoriesFragment implements NavDirections {
        private final int actionId = R.id.action_homeFragment_to_categoriesFragment;
        @NotNull
        private final Category category;
        @NotNull
        private final String eventOrigin;

        public ActionHomeFragmentToCategoriesFragment(@NotNull Category category2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(category2, "category");
            Intrinsics.checkNotNullParameter(str, "eventOrigin");
            this.category = category2;
            this.eventOrigin = str;
        }

        public static /* synthetic */ ActionHomeFragmentToCategoriesFragment copy$default(ActionHomeFragmentToCategoriesFragment actionHomeFragmentToCategoriesFragment, Category category2, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                category2 = actionHomeFragmentToCategoriesFragment.category;
            }
            if ((i11 & 2) != 0) {
                str = actionHomeFragmentToCategoriesFragment.eventOrigin;
            }
            return actionHomeFragmentToCategoriesFragment.copy(category2, str);
        }

        @NotNull
        public final Category component1() {
            return this.category;
        }

        @NotNull
        public final String component2() {
            return this.eventOrigin;
        }

        @NotNull
        public final ActionHomeFragmentToCategoriesFragment copy(@NotNull Category category2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(category2, "category");
            Intrinsics.checkNotNullParameter(str, "eventOrigin");
            return new ActionHomeFragmentToCategoriesFragment(category2, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionHomeFragmentToCategoriesFragment)) {
                return false;
            }
            ActionHomeFragmentToCategoriesFragment actionHomeFragmentToCategoriesFragment = (ActionHomeFragmentToCategoriesFragment) obj;
            return Intrinsics.areEqual((Object) this.category, (Object) actionHomeFragmentToCategoriesFragment.category) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) actionHomeFragmentToCategoriesFragment.eventOrigin);
        }

        public int getActionId() {
            return this.actionId;
        }

        @NotNull
        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            Class<Category> cls = Category.class;
            if (Parcelable.class.isAssignableFrom(cls)) {
                bundle.putParcelable("category", this.category);
            } else if (Serializable.class.isAssignableFrom(cls)) {
                bundle.putSerializable("category", (Serializable) this.category);
            } else {
                String name2 = cls.getName();
                throw new UnsupportedOperationException(name2 + " must implement Parcelable or Serializable or must be an Enum.");
            }
            bundle.putString("eventOrigin", this.eventOrigin);
            return bundle;
        }

        @NotNull
        public final Category getCategory() {
            return this.category;
        }

        @NotNull
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        public int hashCode() {
            return (this.category.hashCode() * 31) + this.eventOrigin.hashCode();
        }

        @NotNull
        public String toString() {
            Category category2 = this.category;
            String str = this.eventOrigin;
            return "ActionHomeFragmentToCategoriesFragment(category=" + category2 + ", eventOrigin=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentDirections$ActionHomeFragmentToCategoriesOverviewBottomSheet;", "Landroidx/navigation/NavDirections;", "categories", "", "Lcom/talabat/darkstores/model/Category;", "([Lcom/talabat/darkstores/model/Category;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getCategories", "()[Lcom/talabat/darkstores/model/Category;", "[Lcom/talabat/darkstores/model/Category;", "component1", "copy", "([Lcom/talabat/darkstores/model/Category;)Lcom/talabat/darkstores/feature/home/HomeFragmentDirections$ActionHomeFragmentToCategoriesOverviewBottomSheet;", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionHomeFragmentToCategoriesOverviewBottomSheet implements NavDirections {
        private final int actionId = R.id.action_homeFragment_to_categoriesOverviewBottomSheet;
        @NotNull
        private final Category[] categories;

        public ActionHomeFragmentToCategoriesOverviewBottomSheet(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            this.categories = categoryArr;
        }

        public static /* synthetic */ ActionHomeFragmentToCategoriesOverviewBottomSheet copy$default(ActionHomeFragmentToCategoriesOverviewBottomSheet actionHomeFragmentToCategoriesOverviewBottomSheet, Category[] categoryArr, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                categoryArr = actionHomeFragmentToCategoriesOverviewBottomSheet.categories;
            }
            return actionHomeFragmentToCategoriesOverviewBottomSheet.copy(categoryArr);
        }

        @NotNull
        public final Category[] component1() {
            return this.categories;
        }

        @NotNull
        public final ActionHomeFragmentToCategoriesOverviewBottomSheet copy(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            return new ActionHomeFragmentToCategoriesOverviewBottomSheet(categoryArr);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActionHomeFragmentToCategoriesOverviewBottomSheet) && Intrinsics.areEqual((Object) this.categories, (Object) ((ActionHomeFragmentToCategoriesOverviewBottomSheet) obj).categories);
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
            return "ActionHomeFragmentToCategoriesOverviewBottomSheet(categories=" + arrays + ")";
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentDirections$ActionHomeFragmentToFlutterSearchFragment;", "Landroidx/navigation/NavDirections;", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getConfigurationParams", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "getRoute", "()Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionHomeFragmentToFlutterSearchFragment implements NavDirections {
        private final int actionId = R.id.action_homeFragment_to_flutterSearchFragment;
        @NotNull
        private final FlutterConfigurationParams configurationParams;
        @NotNull
        private final FlutterRoute route;

        public ActionHomeFragmentToFlutterSearchFragment(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            this.configurationParams = flutterConfigurationParams;
            this.route = flutterRoute;
        }

        public static /* synthetic */ ActionHomeFragmentToFlutterSearchFragment copy$default(ActionHomeFragmentToFlutterSearchFragment actionHomeFragmentToFlutterSearchFragment, FlutterConfigurationParams flutterConfigurationParams, FlutterRoute flutterRoute, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                flutterConfigurationParams = actionHomeFragmentToFlutterSearchFragment.configurationParams;
            }
            if ((i11 & 2) != 0) {
                flutterRoute = actionHomeFragmentToFlutterSearchFragment.route;
            }
            return actionHomeFragmentToFlutterSearchFragment.copy(flutterConfigurationParams, flutterRoute);
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
        public final ActionHomeFragmentToFlutterSearchFragment copy(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            return new ActionHomeFragmentToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionHomeFragmentToFlutterSearchFragment)) {
                return false;
            }
            ActionHomeFragmentToFlutterSearchFragment actionHomeFragmentToFlutterSearchFragment = (ActionHomeFragmentToFlutterSearchFragment) obj;
            return Intrinsics.areEqual((Object) this.configurationParams, (Object) actionHomeFragmentToFlutterSearchFragment.configurationParams) && Intrinsics.areEqual((Object) this.route, (Object) actionHomeFragmentToFlutterSearchFragment.route);
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
            return "ActionHomeFragmentToFlutterSearchFragment(configurationParams=" + flutterConfigurationParams + ", route=" + flutterRoute + ")";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentDirections$ActionHomeFragmentToSubcategoriesFragmentNew;", "Landroidx/navigation/NavDirections;", "categoryId", "", "categoryName", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getCategoryId", "()Ljava/lang/String;", "getCategoryName", "getEventOrigin", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionHomeFragmentToSubcategoriesFragmentNew implements NavDirections {
        private final int actionId = R.id.action_homeFragment_to_subcategoriesFragmentNew;
        @NotNull
        private final String categoryId;
        @NotNull
        private final String categoryName;
        @NotNull
        private final String eventOrigin;

        public ActionHomeFragmentToSubcategoriesFragmentNew(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, "eventOrigin");
            this.categoryId = str;
            this.categoryName = str2;
            this.eventOrigin = str3;
        }

        public static /* synthetic */ ActionHomeFragmentToSubcategoriesFragmentNew copy$default(ActionHomeFragmentToSubcategoriesFragmentNew actionHomeFragmentToSubcategoriesFragmentNew, String str, String str2, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = actionHomeFragmentToSubcategoriesFragmentNew.categoryId;
            }
            if ((i11 & 2) != 0) {
                str2 = actionHomeFragmentToSubcategoriesFragmentNew.categoryName;
            }
            if ((i11 & 4) != 0) {
                str3 = actionHomeFragmentToSubcategoriesFragmentNew.eventOrigin;
            }
            return actionHomeFragmentToSubcategoriesFragmentNew.copy(str, str2, str3);
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
        public final ActionHomeFragmentToSubcategoriesFragmentNew copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, "eventOrigin");
            return new ActionHomeFragmentToSubcategoriesFragmentNew(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionHomeFragmentToSubcategoriesFragmentNew)) {
                return false;
            }
            ActionHomeFragmentToSubcategoriesFragmentNew actionHomeFragmentToSubcategoriesFragmentNew = (ActionHomeFragmentToSubcategoriesFragmentNew) obj;
            return Intrinsics.areEqual((Object) this.categoryId, (Object) actionHomeFragmentToSubcategoriesFragmentNew.categoryId) && Intrinsics.areEqual((Object) this.categoryName, (Object) actionHomeFragmentToSubcategoriesFragmentNew.categoryName) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) actionHomeFragmentToSubcategoriesFragmentNew.eventOrigin);
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
            return "ActionHomeFragmentToSubcategoriesFragmentNew(categoryId=" + str + ", categoryName=" + str2 + ", eventOrigin=" + str3 + ")";
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0019\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJV\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020\b¨\u0006$"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentDirections$Companion;", "", "()V", "actionHomeFragmentToCategoriesFragment", "Landroidx/navigation/NavDirections;", "category", "Lcom/talabat/darkstores/model/Category;", "eventOrigin", "", "actionHomeFragmentToCategoriesOverviewBottomSheet", "categories", "", "([Lcom/talabat/darkstores/model/Category;)Landroidx/navigation/NavDirections;", "actionHomeFragmentToFlutterSearchFragment", "configurationParams", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "route", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "actionHomeFragmentToSearchFragment", "actionHomeFragmentToSearchResultsFragment", "resultsType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "actionHomeFragmentToSubcategoriesFragmentNew", "categoryId", "categoryName", "actionToProductFragment", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavDirections actionHomeFragmentToSearchResultsFragment$default(Companion companion, SearchResultsType searchResultsType, String str, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str = null;
            }
            return companion.actionHomeFragmentToSearchResultsFragment(searchResultsType, str);
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
        public final NavDirections actionHomeFragmentToCategoriesFragment(@NotNull Category category, @NotNull String str) {
            Intrinsics.checkNotNullParameter(category, "category");
            Intrinsics.checkNotNullParameter(str, "eventOrigin");
            return new ActionHomeFragmentToCategoriesFragment(category, str);
        }

        @NotNull
        public final NavDirections actionHomeFragmentToCategoriesOverviewBottomSheet(@NotNull Category[] categoryArr) {
            Intrinsics.checkNotNullParameter(categoryArr, "categories");
            return new ActionHomeFragmentToCategoriesOverviewBottomSheet(categoryArr);
        }

        @NotNull
        public final NavDirections actionHomeFragmentToFlutterSearchFragment(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
            Intrinsics.checkNotNullParameter(flutterConfigurationParams, Constants.ARG_CONFIGURATION_PARAMS);
            Intrinsics.checkNotNullParameter(flutterRoute, Constants.ARG_ROUTE);
            return new ActionHomeFragmentToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
        }

        @NotNull
        public final NavDirections actionHomeFragmentToSearchFragment() {
            return new ActionOnlyNavDirections(R.id.action_homeFragment_to_searchFragment);
        }

        @NotNull
        public final NavDirections actionHomeFragmentToSearchResultsFragment(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            return new ActionHomeFragmentToSearchResultsFragment(searchResultsType, str);
        }

        @NotNull
        public final NavDirections actionHomeFragmentToSubcategoriesFragmentNew(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "categoryId");
            Intrinsics.checkNotNullParameter(str2, "categoryName");
            Intrinsics.checkNotNullParameter(str3, "eventOrigin");
            return new ActionHomeFragmentToSubcategoriesFragmentNew(str, str2, str3);
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

    private HomeFragmentDirections() {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeFragmentDirections$ActionHomeFragmentToSearchResultsFragment;", "Landroidx/navigation/NavDirections;", "resultsType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "eventOrigin", "", "(Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;Ljava/lang/String;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getEventOrigin", "()Ljava/lang/String;", "getResultsType", "()Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionHomeFragmentToSearchResultsFragment implements NavDirections {
        private final int actionId;
        @Nullable
        private final String eventOrigin;
        @NotNull
        private final SearchResultsType resultsType;

        public ActionHomeFragmentToSearchResultsFragment(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            this.resultsType = searchResultsType;
            this.eventOrigin = str;
            this.actionId = R.id.action_homeFragment_to_searchResultsFragment;
        }

        public static /* synthetic */ ActionHomeFragmentToSearchResultsFragment copy$default(ActionHomeFragmentToSearchResultsFragment actionHomeFragmentToSearchResultsFragment, SearchResultsType searchResultsType, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                searchResultsType = actionHomeFragmentToSearchResultsFragment.resultsType;
            }
            if ((i11 & 2) != 0) {
                str = actionHomeFragmentToSearchResultsFragment.eventOrigin;
            }
            return actionHomeFragmentToSearchResultsFragment.copy(searchResultsType, str);
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
        public final ActionHomeFragmentToSearchResultsFragment copy(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            return new ActionHomeFragmentToSearchResultsFragment(searchResultsType, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionHomeFragmentToSearchResultsFragment)) {
                return false;
            }
            ActionHomeFragmentToSearchResultsFragment actionHomeFragmentToSearchResultsFragment = (ActionHomeFragmentToSearchResultsFragment) obj;
            return Intrinsics.areEqual((Object) this.resultsType, (Object) actionHomeFragmentToSearchResultsFragment.resultsType) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) actionHomeFragmentToSearchResultsFragment.eventOrigin);
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
            return "ActionHomeFragmentToSearchResultsFragment(resultsType=" + searchResultsType + ", eventOrigin=" + str + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionHomeFragmentToSearchResultsFragment(SearchResultsType searchResultsType, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(searchResultsType, (i11 & 2) != 0 ? null : str);
        }
    }
}
