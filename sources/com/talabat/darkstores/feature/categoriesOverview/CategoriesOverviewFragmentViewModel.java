package com.talabat.darkstores.feature.categoriesOverview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import cj.e;
import cj.f;
import cj.g;
import cj.h;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.ResultKt;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.data.search.model.SearchCategoryResponse;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.data.tracking.SearchTracker;
import com.talabat.darkstores.domain.common.BuildCategoryProductsNavigationActionUseCase;
import com.talabat.darkstores.feature.categoriesOverview.CategoriesOverviewBottomSheetDirections;
import com.talabat.darkstores.feature.searchCategory.SearchCategoryUseCase;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.SubCategory;
import com.talabat.talabatcore.exception.ServerError;
import com.talabat.wrapper.EventWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\\\u0010(\u001aV\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e $*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\u001d0\u001d $**\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e $*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\u001d0\u001d\u0018\u00010#0#H\u0002J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020'H\u0002J\"\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d0#2\u0006\u0010*\u001a\u00020'H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014H\u0002J&\u0010/\u001a\u00020-2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0016J\u0006\u00106\u001a\u00020-J\u000e\u00107\u001a\u00020-2\u0006\u0010*\u001a\u00020'J\u0018\u00108\u001a\u00020-2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u000202H\u0002J\b\u00109\u001a\u00020-H\u0002J\"\u0010:\u001a\u00020-2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u00020\u0016H\u0002R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d0\u0019¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR \u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d0\u0012X\u0004¢\u0006\u0002\n\u0000Rb\u0010\"\u001aV\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e $*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\u001d0\u001d $**\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e $*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\u001d0\u001d\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010'0'0&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/talabat/darkstores/feature/categoriesOverview/CategoriesOverviewFragmentViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "usecase", "Lcom/talabat/darkstores/feature/searchCategory/SearchCategoryUseCase;", "tracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "searchTracker", "Lcom/talabat/darkstores/data/tracking/SearchTracker;", "buildCategoryProductsNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCase;", "(Lio/reactivex/disposables/CompositeDisposable;Lcom/talabat/darkstores/feature/searchCategory/SearchCategoryUseCase;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/darkstores/data/tracking/SearchTracker;Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCase;)V", "_navigationActions", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wrapper/EventWrapper;", "Landroidx/navigation/NavDirections;", "isSearchCategoryEnabled", "", "()Z", "navigationActions", "Landroidx/lifecycle/LiveData;", "getNavigationActions", "()Landroidx/lifecycle/LiveData;", "searchCategoryLiveData", "Lcom/talabat/darkstores/common/Result;", "", "Lcom/talabat/darkstores/model/Category;", "getSearchCategoryLiveData", "searchCategoryMutableLiveData", "searchCategoryObservable", "Lio/reactivex/Observable;", "kotlin.jvm.PlatformType", "searchQuerySubject", "Lio/reactivex/subjects/BehaviorSubject;", "", "createSearchCategoryObservable", "isValidSearchQuery", "query", "loadCategories", "navigate", "", "action", "onCategoryClicked", "category", "position", "", "eventOrigin", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "isSearchCategory", "onCategorySearchBarClicked", "onSearchCategory", "onSearchCategoryClicked", "subscribeToSearchCategory", "trackCategoryClicked", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesOverviewFragmentViewModel extends BaseViewModel {
    @NotNull
    private final MutableLiveData<EventWrapper<NavDirections>> _navigationActions;
    @NotNull
    private final BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationAction;
    private final boolean isSearchCategoryEnabled;
    @NotNull
    private final LiveData<EventWrapper<NavDirections>> navigationActions;
    @NotNull
    private final LiveData<Result<List<Category>>> searchCategoryLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<List<Category>>> searchCategoryMutableLiveData;
    private final Observable<Result<List<Category>>> searchCategoryObservable = createSearchCategoryObservable();
    @NotNull
    private final BehaviorSubject<String> searchQuerySubject;
    @NotNull
    private final SearchTracker searchTracker;
    @NotNull
    private final DarkstoresEventTracker tracker;
    @NotNull
    private final SearchCategoryUseCase usecase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CategoriesOverviewFragmentViewModel(@NotNull CompositeDisposable compositeDisposable, @NotNull SearchCategoryUseCase searchCategoryUseCase, @NotNull DarkstoresEventTracker darkstoresEventTracker, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull SearchTracker searchTracker2, @NotNull BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationActionUseCase) {
        super(compositeDisposable);
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(searchCategoryUseCase, "usecase");
        Intrinsics.checkNotNullParameter(darkstoresEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(searchTracker2, "searchTracker");
        Intrinsics.checkNotNullParameter(buildCategoryProductsNavigationActionUseCase, "buildCategoryProductsNavigationAction");
        this.usecase = searchCategoryUseCase;
        this.tracker = darkstoresEventTracker;
        this.searchTracker = searchTracker2;
        this.buildCategoryProductsNavigationAction = buildCategoryProductsNavigationActionUseCase;
        BehaviorSubject<String> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<String>()");
        this.searchQuerySubject = create;
        MutableLiveData<Result<List<Category>>> mutableLiveData = new MutableLiveData<>();
        this.searchCategoryMutableLiveData = mutableLiveData;
        MutableLiveData<EventWrapper<NavDirections>> mutableLiveData2 = new MutableLiveData<>();
        this._navigationActions = mutableLiveData2;
        this.navigationActions = mutableLiveData2;
        this.searchCategoryLiveData = mutableLiveData;
        subscribeToSearchCategory();
    }

    private final Observable<Result<List<Category>>> createSearchCategoryObservable() {
        return this.searchQuerySubject.distinctUntilChanged().filter(new f(this)).switchMap(new g(this)).share();
    }

    /* access modifiers changed from: private */
    /* renamed from: createSearchCategoryObservable$lambda-0  reason: not valid java name */
    public static final boolean m9939createSearchCategoryObservable$lambda0(CategoriesOverviewFragmentViewModel categoriesOverviewFragmentViewModel, String str) {
        Intrinsics.checkNotNullParameter(categoriesOverviewFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "it");
        return categoriesOverviewFragmentViewModel.isSearchCategoryEnabled;
    }

    /* access modifiers changed from: private */
    /* renamed from: createSearchCategoryObservable$lambda-1  reason: not valid java name */
    public static final ObservableSource m9940createSearchCategoryObservable$lambda1(CategoriesOverviewFragmentViewModel categoriesOverviewFragmentViewModel, String str) {
        Intrinsics.checkNotNullParameter(categoriesOverviewFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "query");
        if (categoriesOverviewFragmentViewModel.isValidSearchQuery(str)) {
            return categoriesOverviewFragmentViewModel.loadCategories(str);
        }
        Observable just = Observable.just(new Result.Success(CollectionsKt__CollectionsKt.emptyList()));
        Intrinsics.checkNotNullExpressionValue(just, "{\n                Observ…ptyList()))\n            }");
        return just;
    }

    private final boolean isValidSearchQuery(String str) {
        return (StringsKt__StringsJVMKt.isBlank(str) ^ true) && str.length() >= 2;
    }

    private final Observable<Result<List<Category>>> loadCategories(String str) {
        Observable<R> switchMap = Observable.timer(500, TimeUnit.MILLISECONDS).switchMap(new h(this, str));
        Intrinsics.checkNotNullExpressionValue(switchMap, "timer(SEARCH_QUERY_DEBOU….toResult()\n            }");
        return switchMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: loadCategories$lambda-6  reason: not valid java name */
    public static final ObservableSource m9941loadCategories$lambda6(CategoriesOverviewFragmentViewModel categoriesOverviewFragmentViewModel, String str, Long l11) {
        Intrinsics.checkNotNullParameter(categoriesOverviewFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(l11, "it");
        Observable<R> observable = categoriesOverviewFragmentViewModel.usecase.searchCategory(str).map(new e(categoriesOverviewFragmentViewModel)).toObservable();
        Intrinsics.checkNotNullExpressionValue(observable, "usecase.searchCategory(q…          .toObservable()");
        return ResultKt.toResult(observable);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadCategories$lambda-6$lambda-5  reason: not valid java name */
    public static final List m9942loadCategories$lambda6$lambda5(CategoriesOverviewFragmentViewModel categoriesOverviewFragmentViewModel, SearchCategoryResponse searchCategoryResponse) {
        List<Category> list;
        Intrinsics.checkNotNullParameter(categoriesOverviewFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(searchCategoryResponse, "response");
        String value = categoriesOverviewFragmentViewModel.searchQuerySubject.getValue();
        if (value != null) {
            if (categoriesOverviewFragmentViewModel.isValidSearchQuery(value)) {
                list = searchCategoryResponse.getCategories();
                if (!(!list.isEmpty())) {
                    list = null;
                }
                if (list == null) {
                    throw new ServerError((Integer) null, "No category found", (String) null, 5, (DefaultConstructorMarker) null);
                }
            } else {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            if (list != null) {
                return list;
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* access modifiers changed from: private */
    public final void navigate(NavDirections navDirections) {
        this._navigationActions.postValue(new EventWrapper(navDirections));
    }

    private final void onSearchCategoryClicked(Category category, int i11) {
        this.searchTracker.onSearchCategoryClicked(category.getId(), i11, category.getName());
    }

    private final void subscribeToSearchCategory() {
        CompositeDisposable a11 = a();
        Observable<Result<List<Category>>> observable = this.searchCategoryObservable;
        Intrinsics.checkNotNullExpressionValue(observable, "searchCategoryObservable");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) observable, (Function1) null, (Function0) null, (Function1) new CategoriesOverviewFragmentViewModel$subscribeToSearchCategory$1(this), 3, (Object) null));
    }

    private final void trackCategoryClicked(Category category, int i11, boolean z11) {
        if (z11) {
            onSearchCategoryClicked(category, i11);
            return;
        }
        Iterable<SubCategory> subcategories = category.getSubcategories();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcategories, 10));
        for (SubCategory name2 : subcategories) {
            arrayList.add(name2.getName());
        }
        this.tracker.onCategoryClicked(category.getName(), category.getId(), arrayList, i11);
    }

    @NotNull
    public final LiveData<EventWrapper<NavDirections>> getNavigationActions() {
        return this.navigationActions;
    }

    @NotNull
    public final LiveData<Result<List<Category>>> getSearchCategoryLiveData() {
        return this.searchCategoryLiveData;
    }

    public final boolean isSearchCategoryEnabled() {
        return this.isSearchCategoryEnabled;
    }

    public final void onCategoryClicked(@NotNull Category category, int i11, @NotNull EventOrigin eventOrigin, boolean z11) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        trackCategoryClicked(category, i11, z11);
        CompositeDisposable a11 = a();
        BuildCategoryProductsNavigationActionUseCase buildCategoryProductsNavigationActionUseCase = this.buildCategoryProductsNavigationAction;
        String id2 = category.getId();
        String name2 = category.getName();
        String trackingName = eventOrigin.getTrackingName();
        CategoriesOverviewBottomSheetDirections.Companion companion = CategoriesOverviewBottomSheetDirections.Companion;
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Single) buildCategoryProductsNavigationActionUseCase.invoke(id2, name2, trackingName, new CategoriesOverviewFragmentViewModel$onCategoryClicked$1(companion), new CategoriesOverviewFragmentViewModel$onCategoryClicked$2(companion)), (Function1) null, (Function1) new CategoriesOverviewFragmentViewModel$onCategoryClicked$3(this), 1, (Object) null));
    }

    public final void onCategorySearchBarClicked() {
        this.searchTracker.onCategorySearchBarClicked();
    }

    public final void onSearchCategory(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        Timber.d("on search: " + str, new Object[0]);
        this.searchQuerySubject.onNext(str);
    }
}
