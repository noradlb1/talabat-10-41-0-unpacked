package com.talabat.darkstores.feature.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import com.integration.nfv.observability.NfvObservabilityHandler;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.ResultKt;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.darkstores.data.tracking.ProductTrackingData;
import com.talabat.darkstores.data.tracking.ProductTrackingDataKt;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.domain.model.RecentSearch;
import com.talabat.darkstores.domain.presearch.GetPreSearchSwimlaneUseCase;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.model.PreSearchItem;
import com.talabat.darkstores.feature.model.QuantityChangedInfo;
import com.talabat.darkstores.feature.model.mapper.PreSearchSwimlaneToListItemsMapper;
import com.talabat.darkstores.feature.model.mapper.RecentSearchesToListItemsMapper;
import com.talabat.darkstores.feature.search.SearchFragmentDirections;
import com.talabat.darkstores.feature.search.listener.PreSearchSwimlaneListener;
import com.talabat.darkstores.feature.search.listener.RecentSearchesListener;
import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.model.CategorySuggestion;
import com.talabat.darkstores.model.ProductSuggestion;
import com.talabat.darkstores.model.SearchSuggestion;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.wrapper.EventWrapper;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.ObservablesKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mj.l;
import mj.m;
import mj.n;
import mj.o;
import mj.p;
import mj.q;
import mj.r;
import mj.s;
import mj.t;
import mj.u;
import mj.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BI\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J$\u0010B\u001a\u00020?2\u0006\u0010C\u001a\u00020\u00172\u0012\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#08H\u0002J*\u0010E\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0#2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020*0#H\u0002J\\\u0010I\u001aV\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002090# ,*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#\u0018\u00010808 ,**\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002090# ,*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#\u0018\u00010808\u0018\u00010=0=H\u0002J\"\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#080=2\u0006\u0010K\u001a\u00020\u0017H\u0002J\u0010\u0010L\u001a\u0002002\u0006\u0010M\u001a\u00020\u001dH\u0002J\u0006\u0010N\u001a\u000200J\u0018\u0010O\u001a\u0002002\u0006\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020+H\u0016J'\u0010R\u001a\u0002002\u0006\u0010P\u001a\u00020*2\u0006\u0010S\u001a\u00020+2\b\u0010T\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0002\u0010UJ\u0018\u0010V\u001a\u0002002\u0006\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020+H\u0002J'\u0010W\u001a\u0002002\u0006\u0010P\u001a\u00020*2\u0006\u0010S\u001a\u00020+2\b\u0010T\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0002\u0010UJ\u0010\u0010X\u001a\u0002002\u0006\u0010K\u001a\u00020\u0017H\u0016J\u0006\u0010Y\u001a\u000200J\u000e\u0010Z\u001a\u0002002\u0006\u0010K\u001a\u00020\u0017J\u001a\u0010[\u001a\u0002002\u0006\u0010K\u001a\u00020\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]J\u0016\u0010^\u001a\u0002002\u0006\u0010_\u001a\u0002092\u0006\u0010Q\u001a\u00020+J\b\u0010`\u001a\u000200H\u0002J\b\u0010a\u001a\u000200H\u0002J\b\u0010b\u001a\u000200H\u0002J\b\u0010c\u001a\u000200H\u0002J\b\u0010d\u001a\u000200H\u0002J\b\u0010e\u001a\u000200H\u0002J\b\u0010f\u001a\u000200H\u0002J\b\u0010g\u001a\u000200H\u0002J\u0010\u0010h\u001a\u0002002\u0006\u0010K\u001a\u00020\u0017H\u0002J\u0018\u0010i\u001a\u0002002\u0006\u0010j\u001a\u00020.2\u0006\u0010K\u001a\u00020\u0017H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u001f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u001bX\u0004¢\u0006\u0002\n\u0000R4\u0010'\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+ ,*\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+\u0018\u00010)0)0(X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010.0.0(X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u000100000(X\u0004¢\u0006\u0002\n\u0000R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00170\u001bX\u0004¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00170\u001705X\u0004¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00170\u00170(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R#\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#080\u001f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010!R \u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#080\u001bX\u0004¢\u0006\u0002\n\u0000Rb\u0010<\u001aV\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002090# ,*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#\u0018\u00010808 ,**\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002090# ,*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002090#\u0018\u00010808\u0018\u00010=0=X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u001f¢\u0006\b\n\u0000\u001a\u0004\b@\u0010!R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020?0\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/talabat/darkstores/feature/search/SearchFragmentViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "Lcom/talabat/darkstores/feature/search/listener/RecentSearchesListener;", "Lcom/talabat/darkstores/feature/search/listener/PreSearchSwimlaneListener;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "searchTracker", "Lcom/talabat/darkstores/data/tracking/SearchTracker;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "ioScheduler", "Lio/reactivex/Scheduler;", "mapRecentSearchesToItems", "Lcom/talabat/darkstores/feature/model/mapper/RecentSearchesToListItemsMapper;", "mapPreSearchSwimlaneToItems", "Lcom/talabat/darkstores/feature/model/mapper/PreSearchSwimlaneToListItemsMapper;", "getPreSearchSwimlane", "Lcom/talabat/darkstores/domain/presearch/GetPreSearchSwimlaneUseCase;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/tracking/SearchTracker;Lio/reactivex/disposables/CompositeDisposable;Lio/reactivex/Scheduler;Lcom/talabat/darkstores/feature/model/mapper/RecentSearchesToListItemsMapper;Lcom/talabat/darkstores/feature/model/mapper/PreSearchSwimlaneToListItemsMapper;Lcom/talabat/darkstores/domain/presearch/GetPreSearchSwimlaneUseCase;)V", "lastSearchQuery", "", "getLastSearchQuery", "()Ljava/lang/String;", "mutableNavigationActions", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wrapper/EventWrapper;", "Landroidx/navigation/NavDirections;", "navigationActions", "Landroidx/lifecycle/LiveData;", "getNavigationActions", "()Landroidx/lifecycle/LiveData;", "preSearchItems", "", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "getPreSearchItems", "preSearchMutableLiveData", "productClickedSubject", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "", "kotlin.jvm.PlatformType", "productQuantitySubject", "Lcom/talabat/darkstores/feature/model/QuantityChangedInfo;", "retrySubject", "", "searchQueryLiveData", "getSearchQueryLiveData", "searchQueryMutableLiveData", "searchQuerySubject", "Lio/reactivex/subjects/BehaviorSubject;", "searchResultsObservability", "suggestionsLiveData", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/model/SearchSuggestion;", "getSuggestionsLiveData", "suggestionsMutableLiveData", "suggestionsObservable", "Lio/reactivex/Observable;", "viewAllButtonVisibilityLiveData", "", "getViewAllButtonVisibilityLiveData", "viewAllVisibilityMutableLiveData", "calculateViewAllVisibility", "searchQuery", "suggestionsResult", "combineItems", "recentSearches", "Lcom/talabat/darkstores/domain/model/RecentSearch;", "swimlane", "createSuggestionsObservable", "loadSuggestions", "query", "navigate", "action", "onBackClicked", "onPreSearchProductClicked", "product", "position", "onProductAdded", "quantity", "listPosition", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;)V", "onProductOpened", "onProductRemoved", "onRecentSearchClicked", "onRetry", "onSearch", "onSearchQuerySubmitted", "eventOrigin", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "onSearchSuggestionClicked", "suggestion", "subscribeToEmptySearchResults", "subscribeToPreSearchesItems", "subscribeToProductClicks", "subscribeToQualityChange", "subscribeToSearchClosed", "subscribeToSearchQuery", "subscribeToSuggestions", "subscribeToViewAllButtonVisibility", "trackEmptySearchResults", "trackQuantityChanged", "quantityInfo", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchFragmentViewModel extends BaseViewModel implements NewProductQuantityListener, RecentSearchesListener, PreSearchSwimlaneListener {
    @NotNull
    private final DarkstoresRepo darkstoresRepo;
    /* access modifiers changed from: private */
    @NotNull
    public final DiscoveryRepo discoveryRepo;
    @NotNull
    private final GetPreSearchSwimlaneUseCase getPreSearchSwimlane;
    @NotNull
    private final Scheduler ioScheduler;
    @NotNull
    private final PreSearchSwimlaneToListItemsMapper mapPreSearchSwimlaneToItems;
    @NotNull
    private final RecentSearchesToListItemsMapper mapRecentSearchesToItems;
    @NotNull
    private final MutableLiveData<EventWrapper<NavDirections>> mutableNavigationActions;
    @NotNull
    private final LiveData<EventWrapper<NavDirections>> navigationActions;
    @NotNull
    private final LiveData<List<PreSearchItem>> preSearchItems;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<List<PreSearchItem>> preSearchMutableLiveData;
    @NotNull
    private final PublishSubject<Pair<Product, Integer>> productClickedSubject;
    @NotNull
    private final PublishSubject<QuantityChangedInfo> productQuantitySubject;
    @NotNull
    private final PublishSubject<Unit> retrySubject;
    @NotNull
    private final LiveData<String> searchQueryLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<String> searchQueryMutableLiveData;
    @NotNull
    private final BehaviorSubject<String> searchQuerySubject;
    @NotNull
    private final PublishSubject<String> searchResultsObservability;
    /* access modifiers changed from: private */
    @NotNull
    public final SearchTracker searchTracker;
    @NotNull
    private final LiveData<Result<List<SearchSuggestion>>> suggestionsLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<List<SearchSuggestion>>> suggestionsMutableLiveData;
    private final Observable<Result<List<SearchSuggestion>>> suggestionsObservable = createSuggestionsObservable();
    @NotNull
    private final LiveData<Boolean> viewAllButtonVisibilityLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Boolean> viewAllVisibilityMutableLiveData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SearchFragmentViewModel(@NotNull DiscoveryRepo discoveryRepo2, @NotNull DarkstoresRepo darkstoresRepo2, @NotNull SearchTracker searchTracker2, @NotNull CompositeDisposable compositeDisposable, @IoScheduler @NotNull Scheduler scheduler, @NotNull RecentSearchesToListItemsMapper recentSearchesToListItemsMapper, @NotNull PreSearchSwimlaneToListItemsMapper preSearchSwimlaneToListItemsMapper, @NotNull GetPreSearchSwimlaneUseCase getPreSearchSwimlaneUseCase) {
        super(compositeDisposable);
        Intrinsics.checkNotNullParameter(discoveryRepo2, "discoveryRepo");
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(searchTracker2, "searchTracker");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        Intrinsics.checkNotNullParameter(recentSearchesToListItemsMapper, "mapRecentSearchesToItems");
        Intrinsics.checkNotNullParameter(preSearchSwimlaneToListItemsMapper, "mapPreSearchSwimlaneToItems");
        Intrinsics.checkNotNullParameter(getPreSearchSwimlaneUseCase, "getPreSearchSwimlane");
        this.discoveryRepo = discoveryRepo2;
        this.darkstoresRepo = darkstoresRepo2;
        this.searchTracker = searchTracker2;
        this.ioScheduler = scheduler;
        this.mapRecentSearchesToItems = recentSearchesToListItemsMapper;
        this.mapPreSearchSwimlaneToItems = preSearchSwimlaneToListItemsMapper;
        this.getPreSearchSwimlane = getPreSearchSwimlaneUseCase;
        MutableLiveData<List<PreSearchItem>> mutableLiveData = new MutableLiveData<>();
        this.preSearchMutableLiveData = mutableLiveData;
        MutableLiveData<Result<List<SearchSuggestion>>> mutableLiveData2 = new MutableLiveData<>();
        this.suggestionsMutableLiveData = mutableLiveData2;
        MutableLiveData<EventWrapper<NavDirections>> mutableLiveData3 = new MutableLiveData<>();
        this.mutableNavigationActions = mutableLiveData3;
        BehaviorSubject<String> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<String>()");
        this.searchQuerySubject = create;
        PublishSubject<Unit> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Unit>()");
        this.retrySubject = create2;
        PublishSubject<Pair<Product, Integer>> create3 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Pair<Product, Int>>()");
        this.productClickedSubject = create3;
        PublishSubject<QuantityChangedInfo> create4 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create<QuantityChangedInfo>()");
        this.productQuantitySubject = create4;
        PublishSubject<String> create5 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create5, "create<String>()");
        this.searchResultsObservability = create5;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this.viewAllVisibilityMutableLiveData = mutableLiveData4;
        MutableLiveData<String> mutableLiveData5 = new MutableLiveData<>();
        this.searchQueryMutableLiveData = mutableLiveData5;
        this.navigationActions = mutableLiveData3;
        this.suggestionsLiveData = mutableLiveData2;
        this.preSearchItems = mutableLiveData;
        this.viewAllButtonVisibilityLiveData = mutableLiveData4;
        this.searchQueryLiveData = mutableLiveData5;
        searchTracker2.searchLoaded();
        subscribeToSuggestions();
        subscribeToEmptySearchResults();
        subscribeToSearchClosed();
        subscribeToProductClicks();
        subscribeToPreSearchesItems();
        subscribeToQualityChange();
        subscribeToViewAllButtonVisibility();
        subscribeToSearchQuery();
    }

    /* access modifiers changed from: private */
    public final boolean calculateViewAllVisibility(String str, Result<List<SearchSuggestion>> result) {
        return !StringsKt__StringsJVMKt.isBlank(str);
    }

    /* access modifiers changed from: private */
    public final List<PreSearchItem> combineItems(List<RecentSearch> list, List<Product> list2) {
        return CollectionsKt___CollectionsKt.plus(this.mapRecentSearchesToItems.invoke(list), this.mapPreSearchSwimlaneToItems.invoke(list2));
    }

    private final Observable<Result<List<SearchSuggestion>>> createSuggestionsObservable() {
        return this.searchQuerySubject.distinctUntilChanged().switchMap(new n(this)).share();
    }

    /* access modifiers changed from: private */
    /* renamed from: createSuggestionsObservable$lambda-9  reason: not valid java name */
    public static final ObservableSource m10068createSuggestionsObservable$lambda9(SearchFragmentViewModel searchFragmentViewModel, String str) {
        Intrinsics.checkNotNullParameter(searchFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "query");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            return searchFragmentViewModel.loadSuggestions(str);
        }
        Observable just = Observable.just(new Result.Success(CollectionsKt__CollectionsKt.emptyList()));
        Intrinsics.checkNotNullExpressionValue(just, "{\n                Observ…ptyList()))\n            }");
        return just;
    }

    private final String getLastSearchQuery() {
        return this.searchQuerySubject.getValue();
    }

    private final Observable<Result<List<SearchSuggestion>>> loadSuggestions(String str) {
        Observable<R> switchMap = Observable.timer(500, TimeUnit.MILLISECONDS).switchMap(new l(this, str));
        Intrinsics.checkNotNullExpressionValue(switchMap, "timer(SEARCH_QUERY_DEBOU…rySubject }\n            }");
        return switchMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSuggestions$lambda-2  reason: not valid java name */
    public static final ObservableSource m10069loadSuggestions$lambda2(SearchFragmentViewModel searchFragmentViewModel, String str, Long l11) {
        Intrinsics.checkNotNullParameter(searchFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(l11, "it");
        Observable<List<SearchSuggestion>> observable = searchFragmentViewModel.discoveryRepo.search(str).doOnSuccess(new v(searchFragmentViewModel, str)).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "discoveryRepo.search(que…          .toObservable()");
        return ResultKt.toResult(observable).repeatWhen(new m(searchFragmentViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSuggestions$lambda-2$lambda-0  reason: not valid java name */
    public static final void m10070loadSuggestions$lambda2$lambda0(SearchFragmentViewModel searchFragmentViewModel, String str, List list) {
        Intrinsics.checkNotNullParameter(searchFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        if (list.isEmpty()) {
            searchFragmentViewModel.trackEmptySearchResults(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadSuggestions$lambda-2$lambda-1  reason: not valid java name */
    public static final ObservableSource m10071loadSuggestions$lambda2$lambda1(SearchFragmentViewModel searchFragmentViewModel, Observable observable) {
        Intrinsics.checkNotNullParameter(searchFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return searchFragmentViewModel.retrySubject;
    }

    private final void navigate(NavDirections navDirections) {
        this.mutableNavigationActions.postValue(new EventWrapper(navDirections));
    }

    private final void onProductOpened(Product product, int i11) {
        this.productClickedSubject.onNext(TuplesKt.to(product, Integer.valueOf(i11)));
    }

    public static /* synthetic */ void onSearchQuerySubmitted$default(SearchFragmentViewModel searchFragmentViewModel, String str, ScreenTrackingProvider.EventOrigin eventOrigin, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            eventOrigin = null;
        }
        searchFragmentViewModel.onSearchQuerySubmitted(str, eventOrigin);
    }

    private final void subscribeToEmptySearchResults() {
        CompositeDisposable a11 = a();
        Disposable subscribe = this.searchResultsObservability.subscribeOn(this.ioScheduler).switchMap(new s(this)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "searchResultsObservabili…\n            .subscribe()");
        DisposableKt.plusAssign(a11, subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToEmptySearchResults$lambda-4  reason: not valid java name */
    public static final ObservableSource m10072subscribeToEmptySearchResults$lambda4(SearchFragmentViewModel searchFragmentViewModel, String str) {
        Intrinsics.checkNotNullParameter(searchFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "query");
        return searchFragmentViewModel.darkstoresRepo.getVendor().toObservable().map(new t(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToEmptySearchResults$lambda-4$lambda-3  reason: not valid java name */
    public static final Unit m10073subscribeToEmptySearchResults$lambda4$lambda3(String str, Vendor vendor) {
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(vendor, "it");
        NfvObservabilityHandler.INSTANCE.onDarkstoresEmptySearchResults(vendor.getVendorId(), str);
        return Unit.INSTANCE;
    }

    private final void subscribeToPreSearchesItems() {
        CompositeDisposable a11 = a();
        Observable<R> combineLatest = Observable.combineLatest(Observable.just(CollectionsKt__CollectionsKt.emptyList()).startWith(CollectionsKt__CollectionsKt.emptyList()), this.getPreSearchSwimlane.invoke().toObservable().startWith(CollectionsKt__CollectionsKt.emptyList()), new o(this));
        Intrinsics.checkNotNullExpressionValue(combineLatest, "combineLatest(\n         … ::combineItems\n        )");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) combineLatest, (Function1) null, (Function0) null, (Function1) new SearchFragmentViewModel$subscribeToPreSearchesItems$2(this), 3, (Object) null));
    }

    private final void subscribeToProductClicks() {
        CompositeDisposable a11 = a();
        Observable<R> withLatestFrom = this.productClickedSubject.withLatestFrom(this.searchQuerySubject, new SearchFragmentViewModel$subscribeToProductClicks$$inlined$withLatestFrom$1());
        Intrinsics.checkExpressionValueIsNotNull(withLatestFrom, "withLatestFrom(other, Bi… combiner.invoke(t, u) })");
        Disposable subscribe = withLatestFrom.subscribe((Consumer<? super R>) new q(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "productClickedSubject\n  …          )\n            }");
        DisposableKt.plusAssign(a11, subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToProductClicks$lambda-7  reason: not valid java name */
    public static final void m10074subscribeToProductClicks$lambda7(SearchFragmentViewModel searchFragmentViewModel, Triple triple) {
        Intrinsics.checkNotNullParameter(searchFragmentViewModel, "this$0");
        int intValue = ((Number) triple.component2()).intValue();
        String str = (String) triple.component3();
        SearchTracker searchTracker2 = searchFragmentViewModel.searchTracker;
        Integer valueOf = Integer.valueOf(intValue);
        String lastSearchRequestId = searchFragmentViewModel.discoveryRepo.getLastSearchRequestId();
        ScreenTrackingProvider.EventOrigin eventOrigin = ScreenTrackingProvider.EventOrigin.SEARCH;
        searchTracker2.searchItemClicked(valueOf, str, lastSearchRequestId, (String) null, eventOrigin);
        searchFragmentViewModel.searchTracker.trackProductOpened(ProductTrackingDataKt.toTrackingData((Product) triple.component1()), intValue, str, eventOrigin);
    }

    private final void subscribeToQualityChange() {
        CompositeDisposable a11 = a();
        Disposable subscribe = ObservablesKt.withLatestFrom(this.productQuantitySubject, this.searchQuerySubject).subscribe(new p(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "productQuantitySubject\n …nfo, query)\n            }");
        DisposableKt.plusAssign(a11, subscribe);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToQualityChange$lambda-8  reason: not valid java name */
    public static final void m10075subscribeToQualityChange$lambda8(SearchFragmentViewModel searchFragmentViewModel, Pair pair) {
        Intrinsics.checkNotNullParameter(searchFragmentViewModel, "this$0");
        QuantityChangedInfo quantityChangedInfo = (QuantityChangedInfo) pair.component1();
        String str = (String) pair.component2();
        Intrinsics.checkNotNullExpressionValue(quantityChangedInfo, "quantityInfo");
        Intrinsics.checkNotNullExpressionValue(str, "query");
        searchFragmentViewModel.trackQuantityChanged(quantityChangedInfo, str);
    }

    private final void subscribeToSearchClosed() {
        CompositeDisposable a11 = a();
        Maybe<R> map = this.searchQuerySubject.lastElement().map(new u(this));
        Intrinsics.checkNotNullExpressionValue(map, "searchQuerySubject\n     …oductsCount\n            }");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Maybe) map, (Function1) null, (Function0) null, (Function1) new SearchFragmentViewModel$subscribeToSearchClosed$2(this), 3, (Object) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeToSearchClosed$lambda-5  reason: not valid java name */
    public static final Pair m10076subscribeToSearchClosed$lambda5(SearchFragmentViewModel searchFragmentViewModel, String str) {
        List list;
        int i11;
        Intrinsics.checkNotNullParameter(searchFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "query");
        Result value = searchFragmentViewModel.suggestionsMutableLiveData.getValue();
        if (value != null) {
            list = (List) value.getData();
        } else {
            list = null;
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                if (next instanceof ProductSuggestion) {
                    arrayList.add(next);
                }
            }
            i11 = arrayList.size();
        } else {
            i11 = 0;
        }
        return TuplesKt.to(str, Integer.valueOf(i11));
    }

    private final void subscribeToSearchQuery() {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Observable) this.searchQuerySubject, (Function1) null, (Function0) null, (Function1) new SearchFragmentViewModel$subscribeToSearchQuery$1(this), 3, (Object) null));
    }

    private final void subscribeToSuggestions() {
        CompositeDisposable a11 = a();
        Observable<Result<List<SearchSuggestion>>> observable = this.suggestionsObservable;
        Intrinsics.checkNotNullExpressionValue(observable, "suggestionsObservable");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) observable, (Function1) null, (Function0) null, (Function1) new SearchFragmentViewModel$subscribeToSuggestions$1(this), 3, (Object) null));
    }

    private final void subscribeToViewAllButtonVisibility() {
        CompositeDisposable a11 = a();
        Observable<R> distinctUntilChanged = Observable.combineLatest(this.searchQuerySubject.startWith(""), this.suggestionsObservable.startWith(new Result.Success(CollectionsKt__CollectionsKt.emptyList())), new r(this)).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "combineLatest(\n         …  .distinctUntilChanged()");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) distinctUntilChanged, (Function1) null, (Function0) null, (Function1) new SearchFragmentViewModel$subscribeToViewAllButtonVisibility$2(this), 3, (Object) null));
    }

    private final void trackEmptySearchResults(String str) {
        this.searchResultsObservability.onNext(str);
    }

    private final void trackQuantityChanged(QuantityChangedInfo quantityChangedInfo, String str) {
        ProductTrackingData trackingData = ProductTrackingDataKt.toTrackingData(quantityChangedInfo.getProduct(), quantityChangedInfo.getQuantity());
        ScreenTrackingProvider.EventOrigin eventOrigin = ScreenTrackingProvider.EventOrigin.SEARCH;
        if (quantityChangedInfo.getWasAdded()) {
            SearchTracker.productAdded$default(this.searchTracker, trackingData, quantityChangedInfo.getListPosition(), str, this.discoveryRepo.getLastSearchRequestId(), eventOrigin, (String) null, 32, (Object) null);
            return;
        }
        SearchTracker.productRemoved$default(this.searchTracker, trackingData, quantityChangedInfo.getListPosition(), str, this.discoveryRepo.getLastSearchRequestId(), eventOrigin, (String) null, 32, (Object) null);
    }

    @NotNull
    public final LiveData<EventWrapper<NavDirections>> getNavigationActions() {
        return this.navigationActions;
    }

    @NotNull
    public final LiveData<List<PreSearchItem>> getPreSearchItems() {
        return this.preSearchItems;
    }

    @NotNull
    public final LiveData<String> getSearchQueryLiveData() {
        return this.searchQueryLiveData;
    }

    @NotNull
    public final LiveData<Result<List<SearchSuggestion>>> getSuggestionsLiveData() {
        return this.suggestionsLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getViewAllButtonVisibilityLiveData() {
        return this.viewAllButtonVisibilityLiveData;
    }

    public final void onBackClicked() {
        this.searchQuerySubject.onComplete();
    }

    public void onPreSearchProductClicked(@NotNull Product product, int i11) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.searchTracker.trackProductOpened(ProductTrackingDataKt.toTrackingData(product), i11, (String) null, ScreenTrackingProvider.EventOrigin.PAST_ORDERS);
        navigate(SearchFragmentDirections.Companion.actionToProductFragment$default(SearchFragmentDirections.Companion, product, false, (String) null, (String) null, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 254, (Object) null));
    }

    public void onProductAdded(@NotNull Product product, int i11, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.productQuantitySubject.onNext(new QuantityChangedInfo(product, i11, num, true));
    }

    public void onProductRemoved(@NotNull Product product, int i11, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.productQuantitySubject.onNext(new QuantityChangedInfo(product, i11, num, false));
    }

    public void onRecentSearchClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Timber.d("Clicked on recent search item with query: " + str, new Object[0]);
        onSearchQuerySubmitted(str, ScreenTrackingProvider.EventOrigin.RECENT_SEARCH);
    }

    public final void onRetry() {
        this.retrySubject.onNext(Unit.INSTANCE);
    }

    public final void onSearch(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Timber.d("on search: " + str, new Object[0]);
        this.searchQuerySubject.onNext(str);
    }

    public final void onSearchQuerySubmitted(@NotNull String str, @Nullable ScreenTrackingProvider.EventOrigin eventOrigin) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "query");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            SearchResultsType.Query query = new SearchResultsType.Query(str);
            SearchFragmentDirections.Companion companion = SearchFragmentDirections.Companion;
            if (eventOrigin != null) {
                str2 = eventOrigin.getTrackingName();
            } else {
                str2 = null;
            }
            navigate(companion.actionSearchFragmentToSearchResultsFragment(query, str2));
        }
    }

    public final void onSearchSuggestionClicked(@NotNull SearchSuggestion searchSuggestion, int i11) {
        NavDirections navDirections;
        Intrinsics.checkNotNullParameter(searchSuggestion, "suggestion");
        if (searchSuggestion instanceof ProductSuggestion) {
            ProductSuggestion productSuggestion = (ProductSuggestion) searchSuggestion;
            onProductOpened(productSuggestion.getProduct(), i11);
            navDirections = SearchFragmentDirections.Companion.actionToProductFragment$default(SearchFragmentDirections.Companion, productSuggestion.getProduct(), false, (String) null, (String) null, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 252, (Object) null);
        } else if (searchSuggestion instanceof CategorySuggestion) {
            CategorySuggestion categorySuggestion = (CategorySuggestion) searchSuggestion;
            String id2 = categorySuggestion.getCategory().getId();
            String name2 = categorySuggestion.getCategory().getName();
            String lastSearchQuery = getLastSearchQuery();
            if (lastSearchQuery == null) {
                lastSearchQuery = "";
            }
            navDirections = SearchFragmentDirections.Companion.actionSearchFragmentToSearchResultsFragment$default(SearchFragmentDirections.Companion, new SearchResultsType.Category(id2, name2, lastSearchQuery), (String) null, 2, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        navigate(navDirections);
    }
}
