package com.talabat.darkstores.feature.categories.subcategories;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.integration.nfv.observability.NfvObservabilityHandler;
import com.models.ProductTrackingModel;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.ResultKt$toResult$4;
import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.common.base.BaseViewModel;
import com.talabat.darkstores.common.extensions.FloatExtensionsKt;
import com.talabat.darkstores.common.extensions.SingleExtensionsKt;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.data.discovery.model.FeedEndpointRequest;
import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.data.tracking.NewProductQuantityListener;
import com.talabat.darkstores.data.tracking.impression.ProductImpressionTracker;
import com.talabat.darkstores.data.tracking.product.ProductTracker;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import com.talabat.darkstores.feature.tracking.DarkstoresEventTracker;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.darkstores.feature.tracking.data.CategoryLoadedEvent;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.Observables;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yi.i;
import yi.j;
import yi.k;
import yi.l;
import yi.m;
import yi.n;
import yi.o;
import yi.p;
import yi.q;
import yi.r;
import yi.s;
import yi.t;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0002STBa\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0006\u00103\u001a\u00020!J\b\u00104\u001a\u000205H\u0002J.\u00106\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0-\u0012\n\u0012\b\u0012\u0004\u0012\u0002080-072\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0-H\u0002J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0;J'\u0010<\u001a\u00020!2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0002\u0010AJ'\u0010B\u001a\u00020!2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0002\u0010AJ\u0006\u0010C\u001a\u00020!J\u001e\u0010D\u001a\u00020!2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010F\u001a\u00020GH\u0002J\u000e\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020'J\u0016\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020!J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201000;J\u0014\u0010P\u001a\u00020!2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020.0-J\u0012\u0010Q\u001a\b\u0012\u0004\u0012\u00020.0-*\u00020RH\u0002R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020*0 X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010'0'0 X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0 X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000201000&X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001aR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragmentViewModel;", "Lcom/talabat/darkstores/common/base/BaseViewModel;", "Lcom/talabat/darkstores/data/tracking/NewProductQuantityListener;", "discoveryRepo", "Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "cartRepository", "Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "topLevelCategoryId", "", "categoryName", "eventOrigin", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "tracker", "Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;", "productTracker", "Lcom/talabat/darkstores/data/tracking/product/ProductTracker;", "impressionTracker", "Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Lcom/talabat/darkstores/data/discovery/DiscoveryRepo;Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/darkstores/data/tracking/EventOrigin;Lcom/talabat/darkstores/feature/tracking/DarkstoresEventTracker;Lcom/talabat/darkstores/data/tracking/product/ProductTracker;Lcom/talabat/darkstores/data/tracking/impression/ProductImpressionTracker;Lio/reactivex/Scheduler;)V", "getCartRepository", "()Lcom/talabat/feature/darkstorescart/data/repository/DarkstoresCartRepository;", "getCategoryName", "()Ljava/lang/String;", "getDarkstoresRepo", "()Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "setDarkstoresRepo", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;)V", "enableAnalyticsSubject", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "getEventOrigin", "()Lcom/talabat/darkstores/data/tracking/EventOrigin;", "headlineSelection", "Landroidx/lifecycle/MutableLiveData;", "", "productsSentCount", "retrySubject", "", "scrollPositionSubject", "subCategoriesObservability", "", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "subcategoryFragmentData", "Lcom/talabat/darkstores/common/Result;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesData;", "getTopLevelCategoryId", "enableAnalytics", "getEventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getSubcategoriesAndProducts", "Lkotlin/Pair;", "Lcom/models/ProductTrackingModel;", "swimlanes", "Lcom/talabat/darkstores/model/Swimlane;", "Landroidx/lifecycle/LiveData;", "onProductAdded", "product", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "quantity", "listPosition", "(Lcom/talabat/feature/darkstorescart/data/model/Product;ILjava/lang/Integer;)V", "onProductRemoved", "onRetry", "sendSubcategoriesObservabilityEvents", "subcategoryItems", "vendor", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "setScrollPosition", "position", "startImpressionTracking", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "stopImpressionTracking", "updateImpressionData", "toSubcategoryItems", "Lcom/talabat/darkstores/data/discovery/model/SubcategorySwimalnesResponse;", "Companion", "Factory", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesFragmentViewModel extends BaseViewModel implements NewProductQuantityListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TRACKING_EVENTS_TO_SEND = 5;
    @NotNull
    private final DarkstoresCartRepository cartRepository;
    @NotNull
    private final String categoryName;
    @NotNull
    private DarkstoresRepo darkstoresRepo;
    @NotNull
    private final PublishSubject<Unit> enableAnalyticsSubject;
    @Nullable
    private final EventOrigin eventOrigin;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Integer> headlineSelection = new MutableLiveData<>();
    @NotNull
    private final ProductImpressionTracker impressionTracker;
    @NotNull
    private final ProductTracker productTracker;
    /* access modifiers changed from: private */
    public int productsSentCount;
    @NotNull
    private final PublishSubject<Object> retrySubject;
    @NotNull
    private final PublishSubject<Integer> scrollPositionSubject;
    @NotNull
    private final PublishSubject<List<SubcategoryItem>> subCategoriesObservability;
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<Result<SubcategoriesData>> subcategoryFragmentData = new MutableLiveData<>();
    @NotNull
    private final String topLevelCategoryId;
    /* access modifiers changed from: private */
    @NotNull
    public final DarkstoresEventTracker tracker;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragmentViewModel$Companion;", "", "()V", "TRACKING_EVENTS_TO_SEND", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragmentViewModel$Factory;", "", "create", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoriesFragmentViewModel;", "topLevelCategoryId", "", "categoryName", "eventOrigin", "Lcom/talabat/darkstores/data/tracking/EventOrigin;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SubcategoriesFragmentViewModel create(@NotNull @Assisted("categoryId") String str, @NotNull @Assisted("categoryName") String str2, @Nullable EventOrigin eventOrigin);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @AssistedInject
    public SubcategoriesFragmentViewModel(@NotNull DiscoveryRepo discoveryRepo, @NotNull DarkstoresRepo darkstoresRepo2, @NotNull DarkstoresCartRepository darkstoresCartRepository, @NotNull @Assisted("categoryId") String str, @NotNull @Assisted("categoryName") String str2, @Nullable @Assisted EventOrigin eventOrigin2, @NotNull DarkstoresEventTracker darkstoresEventTracker, @NotNull ProductTracker productTracker2, @NotNull ProductImpressionTracker productImpressionTracker, @IoScheduler @NotNull Scheduler scheduler) {
        super(new CompositeDisposable());
        DarkstoresRepo darkstoresRepo3 = darkstoresRepo2;
        DarkstoresCartRepository darkstoresCartRepository2 = darkstoresCartRepository;
        String str3 = str;
        String str4 = str2;
        DarkstoresEventTracker darkstoresEventTracker2 = darkstoresEventTracker;
        ProductTracker productTracker3 = productTracker2;
        ProductImpressionTracker productImpressionTracker2 = productImpressionTracker;
        Scheduler scheduler2 = scheduler;
        Intrinsics.checkNotNullParameter(discoveryRepo, "discoveryRepo");
        Intrinsics.checkNotNullParameter(darkstoresRepo3, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(darkstoresCartRepository2, "cartRepository");
        Intrinsics.checkNotNullParameter(str3, "topLevelCategoryId");
        Intrinsics.checkNotNullParameter(str4, "categoryName");
        Intrinsics.checkNotNullParameter(darkstoresEventTracker2, "tracker");
        Intrinsics.checkNotNullParameter(productTracker3, "productTracker");
        Intrinsics.checkNotNullParameter(productImpressionTracker2, "impressionTracker");
        Intrinsics.checkNotNullParameter(scheduler2, "ioScheduler");
        this.darkstoresRepo = darkstoresRepo3;
        this.cartRepository = darkstoresCartRepository2;
        this.topLevelCategoryId = str3;
        this.categoryName = str4;
        this.eventOrigin = eventOrigin2;
        this.tracker = darkstoresEventTracker2;
        this.productTracker = productTracker3;
        this.impressionTracker = productImpressionTracker2;
        PublishSubject<Unit> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Unit>()");
        this.enableAnalyticsSubject = create;
        PublishSubject<Integer> create2 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Int>()");
        this.scrollPositionSubject = create2;
        PublishSubject<Object> create3 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create()");
        this.retrySubject = create3;
        PublishSubject<List<SubcategoryItem>> create4 = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create4, "create()");
        this.subCategoriesObservability = create4;
        Single cacheButRetryOnError = SingleExtensionsKt.cacheButRetryOnError(DiscoveryRepo.getSubcategorySwimlanes$default(discoveryRepo, str, FeedEndpointRequest.PageType.default_page, 1, (String) null, 8, (Object) null));
        ConnectableObservable<R> replay = create3.startWith(Unit.INSTANCE).switchMapSingle(new i(cacheButRetryOnError, this)).replay(1);
        CompositeDisposable a11 = a();
        Intrinsics.checkNotNullExpressionValue(replay, "subcategoryItems");
        Observable<R> startWith = replay.map(new SubcategoriesFragmentViewModel$special$$inlined$toResult$1()).onErrorReturn(ResultKt$toResult$4.INSTANCE).startWith(new Result.Loading((Object) null, 1, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(startWith, "crossinline mapper: (Inp…artWith(Result.Loading())");
        DisposableKt.plusAssign(a11, SubscribersKt.subscribeBy$default((Observable) startWith, (Function1) null, (Function0) null, (Function1) new Function1<Result<SubcategoriesData>, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SubcategoriesFragmentViewModel f56325g;

            {
                this.f56325g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Result<SubcategoriesData>) (Result) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Result<SubcategoriesData> result) {
                Intrinsics.checkNotNullParameter(result, "it");
                this.f56325g.subcategoryFragmentData.postValue(result);
            }
        }, 3, (Object) null));
        CompositeDisposable a12 = a();
        Observables observables = Observables.INSTANCE;
        Observable<Integer> distinct = create2.startWith(0).distinct();
        Intrinsics.checkNotNullExpressionValue(distinct, "scrollPositionSubject.startWith(0).distinct()");
        Observable<R> combineLatest = Observable.combineLatest(distinct, create, new SubcategoriesFragmentViewModel$special$$inlined$combineLatest$1());
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        Observable<R> switchMapMaybe = combineLatest.distinctUntilChanged().filter(new l(this)).switchMapMaybe(new m(cacheButRetryOnError, this));
        Intrinsics.checkNotNullExpressionValue(switchMapMaybe, "Observables.combineLates…wimlanes) }\n            }");
        DisposableKt.plusAssign(a12, SubscribersKt.subscribeBy$default((Observable) switchMapMaybe, (Function1) null, (Function0) null, (Function1) new Function1<Pair<? extends List<? extends String>, ? extends List<? extends ProductTrackingModel>>, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SubcategoriesFragmentViewModel f56326g;

            {
                this.f56326g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Pair<? extends List<String>, ? extends List<ProductTrackingModel>>) (Pair) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Pair<? extends List<String>, ? extends List<ProductTrackingModel>> pair) {
                List list = (List) pair.component1();
                List list2 = (List) pair.component2();
                DarkstoresEventTracker access$getTracker$p = this.f56326g.tracker;
                String categoryName = this.f56326g.getCategoryName();
                String topLevelCategoryId = this.f56326g.getTopLevelCategoryId();
                boolean z11 = this.f56326g.productsSentCount > 5;
                EventOrigin eventOrigin = this.f56326g.getEventOrigin();
                access$getTracker$p.onCategoryLoaded(new CategoryLoadedEvent(categoryName, topLevelCategoryId, list, list2, z11, eventOrigin != null ? eventOrigin.getTrackingName() : null));
            }
        }, 3, (Object) null));
        CompositeDisposable a13 = a();
        Disposable subscribe = create4.subscribeOn(scheduler2).switchMap(new n(this)).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "subCategoriesObservabili…\n            .subscribe()");
        DisposableKt.plusAssign(a13, subscribe);
        CompositeDisposable a14 = a();
        Observables observables2 = Observables.INSTANCE;
        Observable<Integer> distinctUntilChanged = create2.startWith(0).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "scrollPositionSubject.st…0).distinctUntilChanged()");
        Observable<R> distinctUntilChanged2 = observables2.combineLatest(distinctUntilChanged, replay).subscribeOn(Schedulers.computation()).flatMapMaybe(new o()).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged2, "Observables.combineLates…  .distinctUntilChanged()");
        DisposableKt.plusAssign(a14, SubscribersKt.subscribeBy$default((Observable) distinctUntilChanged2, (Function1) null, (Function0) null, (Function1) new Function1<Integer, Unit>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SubcategoriesFragmentViewModel f56327g;

            {
                this.f56327g = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                this.f56327g.headlineSelection.postValue(num);
            }
        }, 3, (Object) null));
        replay.connect();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-10  reason: not valid java name */
    public static final ObservableSource m9871_init_$lambda10(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, List list) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return subcategoriesFragmentViewModel.darkstoresRepo.getVendor().toObservable().map(new t(subcategoriesFragmentViewModel, list));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-13  reason: not valid java name */
    public static final MaybeSource m9872_init_$lambda13(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
        return Maybe.fromCallable(new j((List) pair.component2(), (Integer) pair.component1())).map(new k());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final SingleSource m9873_init_$lambda2(Single single, SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, Object obj) {
        Intrinsics.checkNotNullParameter(single, "$subcategorySwimlanesResponse");
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(obj, "it");
        return single.map(new r(subcategoriesFragmentViewModel)).doOnSuccess(new s(subcategoriesFragmentViewModel));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-5  reason: not valid java name */
    public static final boolean m9874_init_$lambda5(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, Integer num) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(num, "it");
        if (num.intValue() > subcategoriesFragmentViewModel.productsSentCount || num.intValue() == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-8  reason: not valid java name */
    public static final MaybeSource m9875_init_$lambda8(Single single, SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, Integer num) {
        Intrinsics.checkNotNullParameter(single, "$subcategorySwimlanesResponse");
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(num, "it");
        return single.onErrorReturnItem(new SubcategorySwimalnesResponse(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList())).filter(new p()).map(new q(subcategoriesFragmentViewModel));
    }

    private final EventOriginType getEventOriginType() {
        EventOriginType fromTrackingName;
        EventOrigin eventOrigin2 = this.eventOrigin;
        if (eventOrigin2 == null || (fromTrackingName = EventOriginType.Companion.fromTrackingName(eventOrigin2.getTrackingName())) == null) {
            return EventOriginType.None;
        }
        return fromTrackingName;
    }

    private final Pair<List<String>, List<ProductTrackingModel>> getSubcategoriesAndProducts(List<Swimlane> list) {
        Iterable<Swimlane> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Swimlane headline : iterable) {
            arrayList.add(headline.getHeadline());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Swimlane products : iterable) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, products.getProducts());
        }
        Iterable<IndexedValue> take = CollectionsKt___CollectionsKt.take(CollectionsKt___CollectionsKt.drop(CollectionsKt___CollectionsKt.withIndex(arrayList2), this.productsSentCount), 5);
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(take, 10));
        for (IndexedValue indexedValue : take) {
            int component1 = indexedValue.component1();
            Product product = (Product) indexedValue.component2();
            Pair<String, String> priceAndCurrency = FloatExtensionsKt.getPriceAndCurrency(product.getPrice());
            arrayList3.add(new ProductTrackingModel(product.getSku(), product.getName(), priceAndCurrency.component1(), priceAndCurrency.component2(), component1 + 1));
        }
        this.productsSentCount += arrayList3.size();
        return TuplesKt.to(arrayList, arrayList3);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-10$lambda-9  reason: not valid java name */
    public static final Unit m9876lambda10$lambda9(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, List list, Vendor vendor) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "$items");
        Intrinsics.checkNotNullParameter(vendor, "it");
        subcategoriesFragmentViewModel.sendSubcategoriesObservabilityEvents(list, vendor);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-13$lambda-11  reason: not valid java name */
    public static final SubcategoryItem m9877lambda13$lambda11(List list, Integer num) {
        Intrinsics.checkNotNullExpressionValue(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullExpressionValue(num, "position");
        return (SubcategoryItem) CollectionsKt___CollectionsKt.getOrNull(list, num.intValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-13$lambda-12  reason: not valid java name */
    public static final Integer m9878lambda13$lambda12(SubcategoryItem subcategoryItem) {
        Intrinsics.checkNotNullParameter(subcategoryItem, "currentItem");
        return Integer.valueOf(subcategoryItem.getHeadlineIndex());
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-2$lambda-0  reason: not valid java name */
    public static final List m9879lambda2$lambda0(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return subcategoriesFragmentViewModel.toSubcategoryItems(subcategorySwimalnesResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-2$lambda-1  reason: not valid java name */
    public static final void m9880lambda2$lambda1(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, List list) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModel, "this$0");
        subcategoriesFragmentViewModel.subCategoriesObservability.onNext(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-8$lambda-6  reason: not valid java name */
    public static final boolean m9881lambda8$lambda6(SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return !subcategorySwimalnesResponse.getSwimlanes().isEmpty();
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-8$lambda-7  reason: not valid java name */
    public static final Pair m9882lambda8$lambda7(SubcategoriesFragmentViewModel subcategoriesFragmentViewModel, SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModel, "this$0");
        Intrinsics.checkNotNullParameter(subcategorySwimalnesResponse, "it");
        return subcategoriesFragmentViewModel.getSubcategoriesAndProducts(subcategorySwimalnesResponse.getSwimlanes());
    }

    private final void sendSubcategoriesObservabilityEvents(List<? extends SubcategoryItem> list, Vendor vendor) {
        if (list.isEmpty()) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresEmptyProductsList(vendor.getVendorId(), this.categoryName, this.topLevelCategoryId);
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof SubcategoryHeadline) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresEmptySubCategories(vendor.getVendorId(), this.categoryName, this.topLevelCategoryId);
        }
    }

    private final List<SubcategoryItem> toSubcategoryItems(SubcategorySwimalnesResponse subcategorySwimalnesResponse) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        for (Object next : subcategorySwimalnesResponse.getSwimlanes()) {
            int i13 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Swimlane swimlane = (Swimlane) next;
            SubcategoryHeadline subcategoryHeadline = new SubcategoryHeadline(swimlane.getHeadline(), i11, i12, (Integer) null, (List) null, 24, (DefaultConstructorMarker) null);
            Iterable<Product> products = swimlane.getProducts();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(products, 10));
            for (Product subcategoryProduct : products) {
                arrayList2.add(new SubcategoryProduct(subcategoryProduct, i11));
            }
            List plus = CollectionsKt___CollectionsKt.plus(CollectionsKt__CollectionsJVMKt.listOf(subcategoryHeadline), arrayList2);
            i12 += plus.size();
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, plus);
            i11 = i13;
        }
        return arrayList;
    }

    public final void enableAnalytics() {
        this.enableAnalyticsSubject.onNext(Unit.INSTANCE);
    }

    @NotNull
    public final DarkstoresCartRepository getCartRepository() {
        return this.cartRepository;
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final DarkstoresRepo getDarkstoresRepo() {
        return this.darkstoresRepo;
    }

    @Nullable
    public final EventOrigin getEventOrigin() {
        return this.eventOrigin;
    }

    @NotNull
    public final String getTopLevelCategoryId() {
        return this.topLevelCategoryId;
    }

    @NotNull
    public final LiveData<Integer> headlineSelection() {
        return this.headlineSelection;
    }

    public void onProductAdded(@NotNull Product product, int i11, @Nullable Integer num) {
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product2, "product");
        ProductTracker.addToCartClicked$default(this.productTracker, product2, i11, num, this.tracker.getScreenName(), getEventOriginType(), (String) null, (SwimlaneTrackingData) null, (TrackingCategoryId) null, (String) null, (String) null, this.cartRepository.getCartId(), (String) null, 3040, (Object) null);
    }

    public void onProductRemoved(@NotNull Product product, int i11, @Nullable Integer num) {
        Product product2 = product;
        Intrinsics.checkNotNullParameter(product2, "product");
        ProductTracker.removeFromCartClicked$default(this.productTracker, product2, i11, num, this.tracker.getScreenName(), getEventOriginType(), (String) null, (SwimlaneTrackingData) null, (TrackingCategoryId) null, (String) null, (String) null, (String) null, 2016, (Object) null);
    }

    public final void onRetry() {
        this.retrySubject.onNext(Unit.INSTANCE);
    }

    public final void setDarkstoresRepo(@NotNull DarkstoresRepo darkstoresRepo2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "<set-?>");
        this.darkstoresRepo = darkstoresRepo2;
    }

    public final void setScrollPosition(int i11) {
        this.scrollPositionSubject.onNext(Integer.valueOf(i11));
    }

    public final void startImpressionTracking(@NotNull RecyclerView recyclerView, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.impressionTracker.register(recyclerView, lifecycleOwner);
    }

    public final void stopImpressionTracking() {
        this.impressionTracker.unregister();
    }

    @NotNull
    public final LiveData<Result<SubcategoriesData>> subcategoryFragmentData() {
        return this.subcategoryFragmentData;
    }

    public final void updateImpressionData(@NotNull List<? extends SubcategoryItem> list) {
        String str;
        Intrinsics.checkNotNullParameter(list, "subcategoryItems");
        ProductImpressionTracker productImpressionTracker = this.impressionTracker;
        String screenName = this.tracker.getScreenName();
        if (screenName == null) {
            screenName = "NA";
        }
        EventOrigin eventOrigin2 = this.eventOrigin;
        if (eventOrigin2 != null) {
            str = eventOrigin2.getTrackingName();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        productImpressionTracker.updateSubcategoryItems(list, screenName, str);
    }
}
