package com.talabat.darkstores.feature.categories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.domain.common.BuildSearchNavigationActionUseCase;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.model.Category;
import com.talabat.darkstores.model.SubCategory;
import com.talabat.wrapper.EventWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xi.e;
import xi.f;
import xi.g;
import xi.h;
import xi.i;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u001bJ\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020'R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragmentViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "tracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "buildSearchNavigationAction", "Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lio/reactivex/disposables/CompositeDisposable;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/darkstores/domain/common/BuildSearchNavigationActionUseCase;)V", "_categoriesLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/darkstores/common/Result;", "", "Lcom/talabat/darkstores/model/Category;", "categoriesLiveData", "Landroidx/lifecycle/LiveData;", "getCategoriesLiveData", "()Landroidx/lifecycle/LiveData;", "navigationActions", "Lcom/talabat/wrapper/EventWrapper;", "Landroidx/navigation/NavDirections;", "getNavigationActions", "navigationActionsMutable", "retrySubject", "Lio/reactivex/subjects/PublishSubject;", "", "getTopLevelCategory", "categoriesList", "selectedCategoryId", "", "navigate", "action", "onRetry", "onSearchBarClicked", "trackCategorySelected", "category", "position", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CategoriesFragmentViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<List<Category>>> _categoriesLiveData = new MutableLiveData<>();
    @NotNull
    private final BuildSearchNavigationActionUseCase buildSearchNavigationAction;
    @NotNull
    private final LiveData<EventWrapper<NavDirections>> navigationActions;
    @NotNull
    private final MutableLiveData<EventWrapper<NavDirections>> navigationActionsMutable;
    @NotNull
    private final PublishSubject<Unit> retrySubject;
    @NotNull
    private final DarkstoresEventTracker tracker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public CategoriesFragmentViewModel(@NotNull DiscoveryRepo discoveryRepo, @NotNull CompositeDisposable compositeDisposable, @NotNull DarkstoresEventTracker darkstoresEventTracker, @NotNull BuildSearchNavigationActionUseCase buildSearchNavigationActionUseCase) {
        super(compositeDisposable);
        Intrinsics.checkNotNullParameter(discoveryRepo, "discoveryRepo");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(darkstoresEventTracker, "tracker");
        Intrinsics.checkNotNullParameter(buildSearchNavigationActionUseCase, "buildSearchNavigationAction");
        this.tracker = darkstoresEventTracker;
        this.buildSearchNavigationAction = buildSearchNavigationActionUseCase;
        MutableLiveData<EventWrapper<NavDirections>> mutableLiveData = new MutableLiveData<>();
        this.navigationActionsMutable = mutableLiveData;
        this.navigationActions = mutableLiveData;
        PublishSubject<Unit> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        this.retrySubject = create;
        Observable<List<Category>> filter = discoveryRepo.getTopLevelCategories(FeedEndpointRequest.PageType.default_page).toObservable().doOnSubscribe(new f(this)).doOnError(new g(this)).retryWhen(new h(this)).filter(new i());
        Intrinsics.checkNotNullExpressionValue(filter, "discoveryRepo.getTopLeve…ilter { it.isNotEmpty() }");
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default((Observable) filter, (Function1) null, (Function0) null, (Function1) new Function1<List<? extends Category>, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ CategoriesFragmentViewModel f56309g;

            {
                this.f56309g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<Category>) (List) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<Category> list) {
                MutableLiveData access$get_categoriesLiveData$p = this.f56309g._categoriesLiveData;
                Intrinsics.checkNotNullExpressionValue(list, "it");
                access$get_categoriesLiveData$p.postValue(new Result.Success(list));
            }
        }, 3, (Object) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m9858_init_$lambda0(CategoriesFragmentViewModel categoriesFragmentViewModel, Disposable disposable) {
        Intrinsics.checkNotNullParameter(categoriesFragmentViewModel, "this$0");
        categoriesFragmentViewModel._categoriesLiveData.postValue(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m9859_init_$lambda1(CategoriesFragmentViewModel categoriesFragmentViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(categoriesFragmentViewModel, "this$0");
        MutableLiveData<Result<List<Category>>> mutableLiveData = categoriesFragmentViewModel._categoriesLiveData;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        mutableLiveData.postValue(new Result.Error(th2, false, (Object) null, 6, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final ObservableSource m9860_init_$lambda3(CategoriesFragmentViewModel categoriesFragmentViewModel, Observable observable) {
        Intrinsics.checkNotNullParameter(categoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(observable, "it");
        return observable.flatMap(new e(categoriesFragmentViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-4  reason: not valid java name */
    public static final boolean m9861_init_$lambda4(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return !list.isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-3$lambda-2  reason: not valid java name */
    public static final ObservableSource m9862lambda3$lambda2(CategoriesFragmentViewModel categoriesFragmentViewModel, Throwable th2) {
        Intrinsics.checkNotNullParameter(categoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(th2, "it");
        return categoriesFragmentViewModel.retrySubject;
    }

    /* access modifiers changed from: private */
    public final void navigate(NavDirections navDirections) {
        this.navigationActionsMutable.postValue(new EventWrapper(navDirections));
    }

    public static /* synthetic */ void trackCategorySelected$default(CategoriesFragmentViewModel categoriesFragmentViewModel, Category category, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        categoriesFragmentViewModel.trackCategorySelected(category, i11);
    }

    @NotNull
    public final LiveData<Result<List<Category>>> getCategoriesLiveData() {
        return this._categoriesLiveData;
    }

    @NotNull
    public final LiveData<EventWrapper<NavDirections>> getNavigationActions() {
        return this.navigationActions;
    }

    @NotNull
    public final Category getTopLevelCategory(@NotNull List<Category> list, @NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "categoriesList");
        Intrinsics.checkNotNullParameter(str, "selectedCategoryId");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Category) obj).getId(), (Object) str)) {
                break;
            }
        }
        Category category = (Category) obj;
        if (category != null) {
            return category;
        }
        Iterator<Category> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Category next = it2.next();
            Iterable<SubCategory> subcategories = next.getSubcategories();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcategories, 10));
            for (SubCategory id2 : subcategories) {
                arrayList.add(id2.getId());
            }
            if (arrayList.contains(str)) {
                category = next;
                break;
            }
        }
        if (category == null) {
            return list.get(0);
        }
        return category;
    }

    public final void onRetry() {
        this.retrySubject.onNext(Unit.INSTANCE);
    }

    public final void onSearchBarClicked() {
        DisposableKt.plusAssign(a(), SubscribersKt.subscribeBy$default((Single) this.buildSearchNavigationAction.invoke(new CategoriesFragmentViewModel$onSearchBarClicked$1(CategoriesFragmentDirections.Companion)), (Function1) null, (Function1) new CategoriesFragmentViewModel$onSearchBarClicked$2(this), 1, (Object) null));
    }

    public final void trackCategorySelected(@NotNull Category category, int i11) {
        Intrinsics.checkNotNullParameter(category, "category");
        Iterable<SubCategory> subcategories = category.getSubcategories();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(subcategories, 10));
        for (SubCategory name2 : subcategories) {
            arrayList.add(name2.getName());
        }
        this.tracker.onCategoryClicked(category.getName(), category.getId(), arrayList, i11);
    }
}
