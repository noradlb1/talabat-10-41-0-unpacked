package com.talabat.darkstores.feature.searchResults;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.entity.QCommerceScreenTracingNames;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.darkstores.data.tracking.ProductTrackingData;
import com.talabat.darkstores.data.tracking.ProductTrackingDataKt;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
import com.talabat.darkstores.feature.searchResults.NavigationCommand;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactory;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.wrapper.EventWrapper;
import dagger.assisted.AssistedFactory;
import io.reactivex.Single;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0004^_`aBY\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0006\u00108\u001a\u00020)J\u001e\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u0002040:2\b\u0010<\u001a\u0004\u0018\u00010!H\u0002J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020;J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020BH\u0002J'\u0010F\u001a\u00020B2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020;2\b\u0010J\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010KJ\u0016\u0010L\u001a\u00020B2\u0006\u0010G\u001a\u00020H2\u0006\u0010M\u001a\u00020;J'\u0010N\u001a\u00020B2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020;2\b\u0010J\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010KJ\u0006\u0010O\u001a\u00020BJ\b\u0010P\u001a\u00020BH\u0002J\u000e\u0010Q\u001a\u00020B2\u0006\u0010R\u001a\u00020)J\u0010\u0010S\u001a\u00020B2\b\u0010<\u001a\u0004\u0018\u00010!J\u0016\u0010T\u001a\u00020B2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020BJ\u0006\u0010Z\u001a\u00020BJ\u0014\u0010[\u001a\u00020B2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002040\u0019J\u0018\u0010]\u001a\b\u0012\u0004\u0012\u00020403*\b\u0012\u0004\u0012\u00020403H\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0+¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,01X\u0004¢\u0006\u0002\n\u0000R\u001d\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000204030#¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "pagingSourceFactory", "Lcom/talabat/darkstores/feature/searchResults/paging/PagingSourceFactory;", "searchTracker", "Lcom/talabat/darkstores/data/tracking/SearchTracker;", "impressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "screenTracker", "Lcom/talabat/core/observabilityNew/domain/IScreenTracker;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "arguments", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$Arguments;", "buildSearchNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/darkstores/feature/searchResults/paging/PagingSourceFactory;Lcom/talabat/darkstores/data/tracking/SearchTracker;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lcom/talabat/core/observabilityNew/domain/IScreenTracker;Lio/reactivex/disposables/CompositeDisposable;Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$Arguments;Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "cachedCategories", "", "Lcom/talabat/darkstores/data/SearchCategory;", "getCachedCategories$com_talabat_NewArchi_darkstores_darkstores", "()Ljava/util/List;", "setCachedCategories$com_talabat_NewArchi_darkstores_darkstores", "(Ljava/util/List;)V", "categorySelection", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "currentCategoryId", "Lkotlinx/coroutines/flow/Flow;", "getCurrentCategoryId", "()Lkotlinx/coroutines/flow/Flow;", "eventOrigin", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "firstTime", "", "navigationCommands", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/wrapper/EventWrapper;", "Lcom/talabat/darkstores/feature/searchResults/NavigationCommand;", "getNavigationCommands", "()Landroidx/lifecycle/LiveData;", "navigationCommandsMutable", "Landroidx/lifecycle/MutableLiveData;", "pagingData", "Landroidx/paging/PagingData;", "Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "getPagingData", "resultType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "canShowCategoriesFilter", "createPagerForCategory", "Landroidx/paging/Pager;", "", "categoryId", "getLabel", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel;", "resultsType", "itemCount", "navigate", "", "action", "Landroidx/navigation/NavDirections;", "navigateBack", "onProductAdded", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "quantity", "listPosition", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;)V", "onProductOpened", "position", "onProductRemoved", "onReadyForInteractionDhDefinition", "onReadyForInteractionTlbDefinition", "onSearchBarClicked", "isFromSearch", "selectCategory", "startImpressionTracking", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "startTraceDefinition", "stopImpressionTracking", "updateImpressionData", "subcategoryItems", "replaceCategories", "Arguments", "Companion", "Factory", "ListLabel", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsFragmentViewModel extends BaseViewModel implements NewProductQuantityListener {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int DEFAULT_PAGE_SIZE = 20;
    @NotNull
    private final Arguments arguments;
    @NotNull
    private final BuildSearchNavigationActionUseCase buildSearchNavigationAction;
    @Nullable
    private List<SearchCategory> cachedCategories;
    @NotNull
    private final MutableStateFlow<String> categorySelection;
    @NotNull
    private final Flow<String> currentCategoryId;
    @NotNull
    private final DiscoveryRepo discoveryRepo;
    @NotNull
    private final ScreenTrackingProvider.EventOrigin eventOrigin;
    private boolean firstTime = true;
    @NotNull
    private final ProductImpressionTracker impressionTracker;
    @NotNull
    private final LiveData<EventWrapper<NavigationCommand>> navigationCommands;
    @NotNull
    private final MutableLiveData<EventWrapper<NavigationCommand>> navigationCommandsMutable;
    @NotNull
    private final Flow<PagingData<SearchPagingItem>> pagingData;
    /* access modifiers changed from: private */
    @NotNull
    public final PagingSourceFactory pagingSourceFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final SearchResultsType resultType;
    @NotNull
    private final IScreenTracker screenTracker;
    @NotNull
    private final SearchTracker searchTracker;
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$Arguments;", "", "resultType", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "eventOrigin", "", "(Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getResultType", "()Lcom/talabat/darkstores/feature/searchResults/SearchResultsType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Arguments {
        @Nullable
        private final String eventOrigin;
        @NotNull
        private final SearchResultsType resultType;

        public Arguments(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultType");
            this.resultType = searchResultsType;
            this.eventOrigin = str;
        }

        public static /* synthetic */ Arguments copy$default(Arguments arguments, SearchResultsType searchResultsType, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                searchResultsType = arguments.resultType;
            }
            if ((i11 & 2) != 0) {
                str = arguments.eventOrigin;
            }
            return arguments.copy(searchResultsType, str);
        }

        @NotNull
        public final SearchResultsType component1() {
            return this.resultType;
        }

        @Nullable
        public final String component2() {
            return this.eventOrigin;
        }

        @NotNull
        public final Arguments copy(@NotNull SearchResultsType searchResultsType, @Nullable String str) {
            Intrinsics.checkNotNullParameter(searchResultsType, "resultType");
            return new Arguments(searchResultsType, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Arguments)) {
                return false;
            }
            Arguments arguments = (Arguments) obj;
            return Intrinsics.areEqual((Object) this.resultType, (Object) arguments.resultType) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) arguments.eventOrigin);
        }

        @Nullable
        public final String getEventOrigin() {
            return this.eventOrigin;
        }

        @NotNull
        public final SearchResultsType getResultType() {
            return this.resultType;
        }

        public int hashCode() {
            int hashCode = this.resultType.hashCode() * 31;
            String str = this.eventOrigin;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            SearchResultsType searchResultsType = this.resultType;
            String str = this.eventOrigin;
            return "Arguments(resultType=" + searchResultsType + ", eventOrigin=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$Companion;", "", "()V", "DEFAULT_PAGE_SIZE", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$Factory;", "", "create", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel;", "arguments", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$Arguments;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SearchResultsFragmentViewModel create(@NotNull Arguments arguments);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel;", "", "()V", "EmptyLabel", "QueryLabel", "Text", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel$Text;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel$EmptyLabel;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel$QueryLabel;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class ListLabel {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel$EmptyLabel;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel;", "itemCount", "", "(I)V", "getItemCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class EmptyLabel extends ListLabel {
            private final int itemCount;

            public EmptyLabel(int i11) {
                super((DefaultConstructorMarker) null);
                this.itemCount = i11;
            }

            public static /* synthetic */ EmptyLabel copy$default(EmptyLabel emptyLabel, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    i11 = emptyLabel.itemCount;
                }
                return emptyLabel.copy(i11);
            }

            public final int component1() {
                return this.itemCount;
            }

            @NotNull
            public final EmptyLabel copy(int i11) {
                return new EmptyLabel(i11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof EmptyLabel) && this.itemCount == ((EmptyLabel) obj).itemCount;
            }

            public final int getItemCount() {
                return this.itemCount;
            }

            public int hashCode() {
                return this.itemCount;
            }

            @NotNull
            public String toString() {
                int i11 = this.itemCount;
                return "EmptyLabel(itemCount=" + i11 + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel$QueryLabel;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel;", "itemCount", "", "(I)V", "getItemCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class QueryLabel extends ListLabel {
            private final int itemCount;

            public QueryLabel(int i11) {
                super((DefaultConstructorMarker) null);
                this.itemCount = i11;
            }

            public static /* synthetic */ QueryLabel copy$default(QueryLabel queryLabel, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    i11 = queryLabel.itemCount;
                }
                return queryLabel.copy(i11);
            }

            public final int component1() {
                return this.itemCount;
            }

            @NotNull
            public final QueryLabel copy(int i11) {
                return new QueryLabel(i11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof QueryLabel) && this.itemCount == ((QueryLabel) obj).itemCount;
            }

            public final int getItemCount() {
                return this.itemCount;
            }

            public int hashCode() {
                return this.itemCount;
            }

            @NotNull
            public String toString() {
                int i11 = this.itemCount;
                return "QueryLabel(itemCount=" + i11 + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel$Text;", "Lcom/talabat/darkstores/feature/searchResults/SearchResultsFragmentViewModel$ListLabel;", "label", "", "(Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Text extends ListLabel {
            @NotNull
            private final String label;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Text(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "label");
                this.label = str;
            }

            public static /* synthetic */ Text copy$default(Text text, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = text.label;
                }
                return text.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.label;
            }

            @NotNull
            public final Text copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "label");
                return new Text(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Text) && Intrinsics.areEqual((Object) this.label, (Object) ((Text) obj).label);
            }

            @NotNull
            public final String getLabel() {
                return this.label;
            }

            public int hashCode() {
                return this.label.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.label;
                return "Text(label=" + str + ")";
            }
        }

        private ListLabel() {
        }

        public /* synthetic */ ListLabel(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x005f, code lost:
        r4 = com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider.EventOrigin.Companion.fromTrackingName(r4);
     */
    @dagger.assisted.AssistedInject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchResultsFragmentViewModel(@org.jetbrains.annotations.NotNull com.talabat.darkstores.data.discovery.DiscoveryRepo r2, @org.jetbrains.annotations.NotNull com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactory r3, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.SearchTracker r4, @org.jetbrains.annotations.NotNull com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker r5, @org.jetbrains.annotations.NotNull com.talabat.core.observabilityNew.domain.IScreenTracker r6, @org.jetbrains.annotations.NotNull io.reactivex.disposables.CompositeDisposable r7, @org.jetbrains.annotations.NotNull @dagger.assisted.Assisted com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel.Arguments r8, @org.jetbrains.annotations.NotNull com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase r9, @org.jetbrains.annotations.NotNull com.talabat.core.featureflag.domain.ITalabatFeatureFlag r10, @org.jetbrains.annotations.NotNull com.talabat.core.experiment.domain.ITalabatExperiment r11) {
        /*
            r1 = this;
            java.lang.String r0 = "discoveryRepo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "pagingSourceFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "searchTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "impressionTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "screenTracker"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "compositeDisposable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "arguments"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "buildSearchNavigationAction"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "talabatFeatureFlag"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "talabatExperiment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r1.<init>(r7)
            r1.discoveryRepo = r2
            r1.pagingSourceFactory = r3
            r1.searchTracker = r4
            r1.impressionTracker = r5
            r1.screenTracker = r6
            r1.arguments = r8
            r1.buildSearchNavigationAction = r9
            r1.talabatFeatureFlag = r10
            r1.talabatExperiment = r11
            r2 = 0
            kotlinx.coroutines.flow.MutableStateFlow r3 = kotlinx.coroutines.flow.StateFlowKt.MutableStateFlow(r2)
            r1.categorySelection = r3
            r4 = 1
            r1.firstTime = r4
            com.talabat.darkstores.feature.searchResults.SearchResultsType r4 = r8.getResultType()
            r1.resultType = r4
            java.lang.String r4 = r8.getEventOrigin()
            if (r4 == 0) goto L_0x0067
            com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider$EventOrigin$Companion r5 = com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider.EventOrigin.Companion
            com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider$EventOrigin r4 = r5.fromTrackingName(r4)
            if (r4 != 0) goto L_0x0069
        L_0x0067:
            com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider$EventOrigin r4 = com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider.EventOrigin.SEARCH_RESULTS
        L_0x0069:
            r1.eventOrigin = r4
            androidx.lifecycle.MutableLiveData r4 = new androidx.lifecycle.MutableLiveData
            r4.<init>()
            r1.navigationCommandsMutable = r4
            r1.navigationCommands = r4
            com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel$special$$inlined$flatMapLatest$1 r4 = new com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel$special$$inlined$flatMapLatest$1
            r4.<init>(r2, r1)
            kotlinx.coroutines.flow.Flow r2 = kotlinx.coroutines.flow.FlowKt.transformLatest(r3, r4)
            kotlinx.coroutines.CoroutineScope r4 = androidx.lifecycle.ViewModelKt.getViewModelScope(r1)
            kotlinx.coroutines.flow.Flow r2 = androidx.paging.CachedPagingDataKt.cachedIn(r2, r4)
            r1.pagingData = r2
            r1.currentCategoryId = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel.<init>(com.talabat.darkstores.data.discovery.DiscoveryRepo, com.talabat.darkstores.feature.searchResults.paging.PagingSourceFactory, com.talabat.darkstores.data.tracking.SearchTracker, com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker, com.talabat.core.observabilityNew.domain.IScreenTracker, io.reactivex.disposables.CompositeDisposable, com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel$Arguments, com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.core.experiment.domain.ITalabatExperiment):void");
    }

    /* access modifiers changed from: private */
    public final Pager<Integer, SearchPagingItem> createPagerForCategory(String str) {
        return new Pager(new PagingConfig(20, 0, false, 20, 0, 0, 50, (DefaultConstructorMarker) null), (Object) null, new SearchResultsFragmentViewModel$createPagerForCategory$1(this, str), 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public final void navigate(NavDirections navDirections) {
        this.navigationCommandsMutable.postValue(new EventWrapper(new NavigationCommand.OpenScreen(navDirections)));
    }

    private final void navigateBack() {
        this.navigationCommandsMutable.postValue(new EventWrapper(NavigationCommand.Back.INSTANCE));
    }

    private final void onReadyForInteractionTlbDefinition() {
        if (this.firstTime) {
            this.firstTime = false;
            this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.TLB_QCOMMERCE_PLP_START_TO_INTERACTIVE.getValue()));
        }
    }

    /* access modifiers changed from: private */
    public final PagingData<SearchPagingItem> replaceCategories(PagingData<SearchPagingItem> pagingData2) {
        return PagingDataTransforms.map(pagingData2, new SearchResultsFragmentViewModel$replaceCategories$1(this, (Continuation<? super SearchResultsFragmentViewModel$replaceCategories$1>) null));
    }

    public final boolean canShowCategoriesFilter() {
        return Intrinsics.areEqual((Object) this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_CATEGORIES_FITLER_PLP, "", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    @Nullable
    public final List<SearchCategory> getCachedCategories$com_talabat_NewArchi_darkstores_darkstores() {
        return this.cachedCategories;
    }

    @NotNull
    public final Flow<String> getCurrentCategoryId() {
        return this.currentCategoryId;
    }

    @NotNull
    public final ListLabel getLabel(@NotNull SearchResultsType searchResultsType, int i11) {
        ListLabel.Text text;
        boolean z11;
        Intrinsics.checkNotNullParameter(searchResultsType, "resultsType");
        if (searchResultsType instanceof SearchResultsType.Query) {
            if (StringsKt__StringsJVMKt.isBlank(((SearchResultsType.Query) searchResultsType).getQuery())) {
                return new ListLabel.EmptyLabel(i11);
            }
            return new ListLabel.QueryLabel(i11);
        } else if (searchResultsType instanceof SearchResultsType.Banner) {
            return new ListLabel.EmptyLabel(i11);
        } else {
            if (searchResultsType instanceof SearchResultsType.Tag) {
                SearchResultsType.Tag tag = (SearchResultsType.Tag) searchResultsType;
                String swimlaneTitle = tag.getSwimlaneTitle();
                if (swimlaneTitle == null || StringsKt__StringsJVMKt.isBlank(swimlaneTitle)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    return new ListLabel.EmptyLabel(i11);
                }
                text = new ListLabel.Text(tag.getSwimlaneTitle());
            } else if (searchResultsType instanceof SearchResultsType.Category) {
                text = new ListLabel.Text(((SearchResultsType.Category) searchResultsType).getCategoryName());
            } else if (searchResultsType instanceof SearchResultsType.LifestyleMissionControl) {
                text = new ListLabel.Text(((SearchResultsType.LifestyleMissionControl) searchResultsType).getName());
            } else if (searchResultsType instanceof SearchResultsType.LifestyleMissionControlV2) {
                text = new ListLabel.Text(((SearchResultsType.LifestyleMissionControlV2) searchResultsType).getName());
            } else if (searchResultsType instanceof SearchResultsType.PrimaryMissionControl) {
                text = new ListLabel.Text(((SearchResultsType.PrimaryMissionControl) searchResultsType).getName());
            } else if (searchResultsType instanceof SearchResultsType.SwimlaneProducts) {
                text = new ListLabel.Text(((SearchResultsType.SwimlaneProducts) searchResultsType).getName());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return text;
        }
    }

    @NotNull
    public final LiveData<EventWrapper<NavigationCommand>> getNavigationCommands() {
        return this.navigationCommands;
    }

    @NotNull
    public final Flow<PagingData<SearchPagingItem>> getPagingData() {
        return this.pagingData;
    }

    public void onProductAdded(@NotNull Product product, int i11, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(product, "product");
        ProductTrackingData trackingData = ProductTrackingDataKt.toTrackingData(product, i11);
        String lastSearchRequestId = this.discoveryRepo.getLastSearchRequestId();
        SearchResultsType searchResultsType = this.resultType;
        if (searchResultsType instanceof SearchResultsType.Query) {
            SearchTracker.productAdded$default(this.searchTracker, trackingData, num, ((SearchResultsType.Query) searchResultsType).getQuery(), lastSearchRequestId, this.eventOrigin, (String) null, 32, (Object) null);
        }
    }

    public final void onProductOpened(@NotNull Product product, int i11) {
        SearchResultsType.Query query;
        Intrinsics.checkNotNullParameter(product, "product");
        SearchResultsType searchResultsType = this.resultType;
        String str = null;
        if (searchResultsType instanceof SearchResultsType.Query) {
            query = (SearchResultsType.Query) searchResultsType;
        } else {
            query = null;
        }
        if (query != null) {
            str = query.getQuery();
        }
        this.searchTracker.searchItemClicked(Integer.valueOf(i11), str, this.discoveryRepo.getLastSearchRequestId(), (String) null, this.eventOrigin);
        this.searchTracker.trackProductOpened(ProductTrackingDataKt.toTrackingData(product), i11, str, this.eventOrigin);
    }

    public void onProductRemoved(@NotNull Product product, int i11, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(product, "product");
        ProductTrackingData trackingData = ProductTrackingDataKt.toTrackingData(product, i11);
        String lastSearchRequestId = this.discoveryRepo.getLastSearchRequestId();
        SearchResultsType searchResultsType = this.resultType;
        if (searchResultsType instanceof SearchResultsType.Query) {
            SearchTracker.productRemoved$default(this.searchTracker, trackingData, num, ((SearchResultsType.Query) searchResultsType).getQuery(), lastSearchRequestId, this.eventOrigin, (String) null, 32, (Object) null);
        }
    }

    public final void onReadyForInteractionDhDefinition() {
        this.screenTracker.stopTrace(ScreenTrackerParams.Companion.create(QCommerceScreenTracingNames.QCOMMERCE_PLP_START_TO_INTERACTIVE.getValue()));
    }

    public final void onSearchBarClicked(boolean z11) {
        if (z11) {
            navigateBack();
        } else {
            DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildSearchNavigationAction.invoke(new SearchResultsFragmentViewModel$onSearchBarClicked$1(SearchResultsFragmentDirections.Companion)), (Function1) null, (Function1) new SearchResultsFragmentViewModel$onSearchBarClicked$2(this), 1, (Object) null));
        }
    }

    public final void selectCategory(@Nullable String str) {
        String value;
        MutableStateFlow<String> mutableStateFlow = this.categorySelection;
        do {
            value = mutableStateFlow.getValue();
            String str2 = value;
        } while (!mutableStateFlow.compareAndSet(value, str));
    }

    public final void setCachedCategories$com_talabat_NewArchi_darkstores_darkstores(@Nullable List<SearchCategory> list) {
        this.cachedCategories = list;
    }

    public final void startImpressionTracking(@NotNull RecyclerView recyclerView, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.impressionTracker.register(recyclerView, lifecycleOwner);
    }

    public final void startTraceDefinition() {
        IScreenTracker iScreenTracker = this.screenTracker;
        ScreenTrackerParams.Companion companion = ScreenTrackerParams.Companion;
        iScreenTracker.startTrace(companion.create(QCommerceScreenTracingNames.QCOMMERCE_PLP_START_TO_INTERACTIVE.getValue()));
        this.screenTracker.startTrace(companion.create(QCommerceScreenTracingNames.TLB_QCOMMERCE_PLP_START_TO_INTERACTIVE.getValue()));
    }

    public final void stopImpressionTracking() {
        this.impressionTracker.unregister();
    }

    public final void updateImpressionData(@NotNull List<? extends SearchPagingItem> list) {
        SearchResultsType.Query query;
        Intrinsics.checkNotNullParameter(list, "subcategoryItems");
        String str = null;
        if (ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, QCommerceFeatureFlagsKeys.SEARCH_RESULT_IMPRESSIONS_TRACKING, false, 2, (Object) null) || ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, QCommerceFeatureFlagsKeys.SWIMLANE_IMPRESSIONS_TRACKING, false, 2, (Object) null) || (this.resultType instanceof SearchResultsType.Query)) {
            SearchResultsType searchResultsType = this.resultType;
            if (searchResultsType instanceof SearchResultsType.Query) {
                query = (SearchResultsType.Query) searchResultsType;
            } else {
                query = null;
            }
            ProductImpressionTracker productImpressionTracker = this.impressionTracker;
            if (query != null) {
                str = query.getQuery();
            }
            productImpressionTracker.updateSearchItems(list, str, this.discoveryRepo.getLastSearchRequestId(), this.eventOrigin.getTrackingName());
        }
        onReadyForInteractionTlbDefinition();
    }
}
