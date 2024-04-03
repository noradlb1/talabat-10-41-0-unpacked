package com.talabat.darkstores.feature.search;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.NavDirections;
import com.talabat.darkstores.NavGraphDirections;
import com.talabat.darkstores.R;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchFragmentDirections;", "", "()V", "ActionSearchFragmentToSearchResultsFragment", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchFragmentDirections {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJV\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchFragmentDirections$Companion;", "", "()V", "actionSearchFragmentToSearchResultsFragment", "Landroidx/navigation/NavDirections;", "resultsType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "eventOrigin", "", "actionToProductFragment", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "shouldTrackProductOpenedEvent", "", "deeplinkUri", "productClickTrackingAttribute", "Lcom/talabat/darkstores/feature/home/swimlane/ProductClickTrackingAttribute;", "swimlaneRequestId", "searchRequestId", "searchTerm", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavDirections actionSearchFragmentToSearchResultsFragment$default(Companion companion, SearchResultsType searchResultsType, String str, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str = null;
            }
            return companion.actionSearchFragmentToSearchResultsFragment(searchResultsType, str);
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
        public final NavDirections actionSearchFragmentToSearchResultsFragment(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            return new ActionSearchFragmentToSearchResultsFragment(searchResultsType, str);
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

    private SearchFragmentDirections() {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchFragmentDirections$ActionSearchFragmentToSearchResultsFragment;", "Landroidx/navigation/NavDirections;", "resultsType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "eventOrigin", "", "(Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;Ljava/lang/String;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getEventOrigin", "()Ljava/lang/String;", "getResultsType", "()Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActionSearchFragmentToSearchResultsFragment implements NavDirections {
        private final int actionId;
        @Nullable
        private final String eventOrigin;
        @NotNull
        private final SearchResultsType resultsType;

        public ActionSearchFragmentToSearchResultsFragment(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            this.resultsType = searchResultsType;
            this.eventOrigin = str;
            this.actionId = R.id.action_searchFragment_to_searchResultsFragment;
        }

        public static /* synthetic */ ActionSearchFragmentToSearchResultsFragment copy$default(ActionSearchFragmentToSearchResultsFragment actionSearchFragmentToSearchResultsFragment, SearchResultsType searchResultsType, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                searchResultsType = actionSearchFragmentToSearchResultsFragment.resultsType;
            }
            if ((i11 & 2) != 0) {
                str = actionSearchFragmentToSearchResultsFragment.eventOrigin;
            }
            return actionSearchFragmentToSearchResultsFragment.copy(searchResultsType, str);
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
        public final ActionSearchFragmentToSearchResultsFragment copy(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
            return new ActionSearchFragmentToSearchResultsFragment(searchResultsType, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ActionSearchFragmentToSearchResultsFragment)) {
                return false;
            }
            ActionSearchFragmentToSearchResultsFragment actionSearchFragmentToSearchResultsFragment = (ActionSearchFragmentToSearchResultsFragment) obj;
            return Intrinsics.areEqual((Object) this.resultsType, (Object) actionSearchFragmentToSearchResultsFragment.resultsType) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) actionSearchFragmentToSearchResultsFragment.eventOrigin);
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
            return "ActionSearchFragmentToSearchResultsFragment(resultsType=" + searchResultsType + ", eventOrigin=" + str + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionSearchFragmentToSearchResultsFragment(SearchResultsType searchResultsType, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(searchResultsType, (i11 & 2) != 0 ? null : str);
        }
    }
}
