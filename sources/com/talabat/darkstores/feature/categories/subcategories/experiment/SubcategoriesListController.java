package com.talabat.darkstores.feature.categories.subcategories.experiment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.extensions.ContextExtensionsKt;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.categories.subcategories.HeadlinesChipsListAdapter;
import com.talabat.darkstores.feature.categories.subcategories.ProductsItemsListAdapter;
import com.talabat.darkstores.feature.categories.subcategories.ShelfItemsListAdapter;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryHeadline;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryItem;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfItem;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfView;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zi.q0;
import zi.r0;
import zi.s0;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0011\u0012\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\u0015J\u0006\u0010.\u001a\u00020\tJ\u001e\u0010/\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010\u000f0\u000f002\u0006\u00101\u001a\u00020\u000fH\u0002J.\u00102\u001a\u00020\t2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002042\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\u000fJ\u0010\u0010=\u001a\u00020\t2\u0006\u00105\u001a\u000204H\u0002J\u0010\u0010>\u001a\u00020\t2\u0006\u00106\u001a\u000207H\u0002J\u0010\u0010?\u001a\u00020\t2\u0006\u00108\u001a\u000204H\u0002J\u0010\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u000204H\u0002J\"\u0010B\u001a\u00020\t2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00132\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0013J\u001a\u0010G\u001a\u00020\t2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u000f0IJ\u0014\u0010K\u001a\u00020\t2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u0013J\u0014\u0010N\u001a\u00020\t2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u0013J\u0014\u0010O\u001a\u00020\t*\u0002042\u0006\u0010P\u001a\u00020\u000fH\u0002R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u0011X\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u001c\u0010#\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010\u000f0\u000f0$X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u001d\u001a\u0004\b,\u0010!R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesListController;", "", "cartFragmentViewModel", "Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;", "trackingCategoryId", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "onProductClicked", "Lkotlin/Function1;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "", "subcategoriesFragmentViewModelNew", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew;", "onHeadlineSelected", "Lkotlin/Function0;", "analyticsAction", "", "onQuantityChange", "Lkotlin/Function2;", "onSortOptionClicked", "", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "(Lcom/talabat/darkstores/feature/cart/CartFragmentViewModel;Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;Lkotlin/jvm/functions/Function1;Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "headlinesAdapter", "Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter;", "getHeadlinesAdapter", "()Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter;", "headlinesAdapter$delegate", "Lkotlin/Lazy;", "productsItemsListAdapter", "Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter;", "getProductsItemsListAdapter", "()Lcom/talabat/darkstores/feature/categories/subcategories/ProductsItemsListAdapter;", "productsItemsListAdapter$delegate", "scrollPositionProcessor", "Lio/reactivex/processors/PublishProcessor;", "kotlin.jvm.PlatformType", "shelfItemsListAdapter", "Lcom/talabat/darkstores/feature/categories/subcategories/ShelfItemsListAdapter;", "getShelfItemsListAdapter", "()Lcom/talabat/darkstores/feature/categories/subcategories/ShelfItemsListAdapter;", "shelfItemsListAdapter$delegate", "shelfViewProductsItemsListAdapter", "getShelfViewProductsItemsListAdapter", "shelfViewProductsItemsListAdapter$delegate", "dispose", "getHeadlineIndexToSelect", "Lio/reactivex/Maybe;", "scrollPosition", "init", "headlinesRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "productsRecyclerView", "shelfView", "Lcom/talabat/darkstores/feature/categories/subcategories/shelf/ShelfView;", "shelfViewProductsItems", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "scrollTo", "position", "setupProductsRecyclerView", "setupShelfView", "setupShelfViewProductsRecyclerView", "setupSubcategoriesRecyclerView", "subcategoriesRecyclerView", "submit", "headlines", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "subcategoryItems", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryItem;", "submitCartContent", "cart", "", "", "submitShelfItems", "items", "Lcom/talabat/darkstores/feature/categories/subcategories/shelf/ShelfItem;", "submitShelfViewData", "selectHeadline", "headlineIndex", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategoriesListController {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SPAN_COUNT = 2;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Integer, Unit> analyticsAction;
    @NotNull
    private final CompositeDisposable disposable = new CompositeDisposable();
    @NotNull
    private final Lazy headlinesAdapter$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Unit> onHeadlineSelected;
    /* access modifiers changed from: private */
    @NotNull
    public final Function2<Product, Integer, Unit> onQuantityChange;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<List<SortOption>, Unit> onSortOptionClicked;
    @NotNull
    private final Lazy productsItemsListAdapter$delegate;
    @NotNull
    private final PublishProcessor<Integer> scrollPositionProcessor;
    @NotNull
    private final Lazy shelfItemsListAdapter$delegate;
    @NotNull
    private final Lazy shelfViewProductsItemsListAdapter$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew;
    /* access modifiers changed from: private */
    @NotNull
    public final TrackingCategoryId trackingCategoryId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesListController$Companion;", "", "()V", "SPAN_COUNT", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SubcategoriesListController(@NotNull CartFragmentViewModel cartFragmentViewModel, @NotNull TrackingCategoryId trackingCategoryId2, @NotNull Function1<? super Product, Unit> function1, @NotNull SubcategoriesFragmentViewModelNew subcategoriesFragmentViewModelNew2, @NotNull Function0<Unit> function0, @NotNull Function1<? super Integer, Unit> function12, @NotNull Function2<? super Product, ? super Integer, Unit> function2, @NotNull Function1<? super List<SortOption>, Unit> function13) {
        Intrinsics.checkNotNullParameter(cartFragmentViewModel, "cartFragmentViewModel");
        Intrinsics.checkNotNullParameter(trackingCategoryId2, "trackingCategoryId");
        Intrinsics.checkNotNullParameter(function1, "onProductClicked");
        Intrinsics.checkNotNullParameter(subcategoriesFragmentViewModelNew2, "subcategoriesFragmentViewModelNew");
        Intrinsics.checkNotNullParameter(function0, "onHeadlineSelected");
        Intrinsics.checkNotNullParameter(function12, "analyticsAction");
        Intrinsics.checkNotNullParameter(function2, "onQuantityChange");
        Intrinsics.checkNotNullParameter(function13, "onSortOptionClicked");
        this.trackingCategoryId = trackingCategoryId2;
        this.subcategoriesFragmentViewModelNew = subcategoriesFragmentViewModelNew2;
        this.onHeadlineSelected = function0;
        this.analyticsAction = function12;
        this.onQuantityChange = function2;
        this.onSortOptionClicked = function13;
        PublishProcessor<Integer> create = PublishProcessor.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Int>()");
        this.scrollPositionProcessor = create;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.shelfItemsListAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SubcategoriesListController$shelfItemsListAdapter$2.INSTANCE);
        this.productsItemsListAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SubcategoriesListController$productsItemsListAdapter$2(cartFragmentViewModel, function1, this));
        this.shelfViewProductsItemsListAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SubcategoriesListController$shelfViewProductsItemsListAdapter$2(cartFragmentViewModel, function1, this));
        this.headlinesAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SubcategoriesListController$headlinesAdapter$2.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final Maybe<Integer> getHeadlineIndexToSelect(int i11) {
        Maybe<Integer> map = Maybe.fromCallable(new q0(this, i11)).map(new r0());
        Intrinsics.checkNotNullExpressionValue(map, "fromCallable<Subcategory….map { it.headlineIndex }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getHeadlineIndexToSelect$lambda-0  reason: not valid java name */
    public static final SubcategoryItem m9925getHeadlineIndexToSelect$lambda0(SubcategoriesListController subcategoriesListController, int i11) {
        Intrinsics.checkNotNullParameter(subcategoriesListController, "this$0");
        List currentList = subcategoriesListController.getProductsItemsListAdapter().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "productsItemsListAdapter.currentList");
        return (SubcategoryItem) CollectionsKt___CollectionsKt.getOrNull(currentList, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: getHeadlineIndexToSelect$lambda-1  reason: not valid java name */
    public static final Integer m9926getHeadlineIndexToSelect$lambda1(SubcategoryItem subcategoryItem) {
        Intrinsics.checkNotNullParameter(subcategoryItem, "it");
        return Integer.valueOf(subcategoryItem.getHeadlineIndex());
    }

    /* access modifiers changed from: private */
    public final HeadlinesChipsListAdapter getHeadlinesAdapter() {
        return (HeadlinesChipsListAdapter) this.headlinesAdapter$delegate.getValue();
    }

    private final ProductsItemsListAdapter getProductsItemsListAdapter() {
        return (ProductsItemsListAdapter) this.productsItemsListAdapter$delegate.getValue();
    }

    private final ShelfItemsListAdapter getShelfItemsListAdapter() {
        return (ShelfItemsListAdapter) this.shelfItemsListAdapter$delegate.getValue();
    }

    private final ProductsItemsListAdapter getShelfViewProductsItemsListAdapter() {
        return (ProductsItemsListAdapter) this.shelfViewProductsItemsListAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void selectHeadline(RecyclerView recyclerView, int i11) {
        LinearLayoutManager linearLayoutManager;
        getHeadlinesAdapter().setCurrentSelection(i11);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPosition(i11);
        }
    }

    private final void setupProductsRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setAdapter(getProductsItemsListAdapter());
        recyclerView.addOnScrollListener(new ProductItemsRvScrollListenerNew(this.scrollPositionProcessor));
    }

    private final void setupShelfView(ShelfView shelfView) {
        shelfView.setAdapter(getShelfItemsListAdapter());
    }

    private final void setupShelfViewProductsRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
        recyclerView.setAdapter(getShelfViewProductsItemsListAdapter());
    }

    private final void setupSubcategoriesRecyclerView(RecyclerView recyclerView) {
        Drawable drawableCompat;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), 0);
        Context context = recyclerView.getContext();
        if (!(context == null || (drawableCompat = ContextExtensionsKt.getDrawableCompat(context, R.drawable.divider_swimlanes_items)) == null)) {
            dividerItemDecoration.setDrawable(drawableCompat);
        }
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(getHeadlinesAdapter());
    }

    public final void dispose() {
        this.subcategoriesFragmentViewModelNew.stopImpressionTracking();
        this.disposable.clear();
    }

    public final void init(@NotNull RecyclerView recyclerView, @NotNull RecyclerView recyclerView2, @NotNull ShelfView shelfView, @NotNull RecyclerView recyclerView3, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(recyclerView, "headlinesRecyclerView");
        Intrinsics.checkNotNullParameter(recyclerView2, "productsRecyclerView");
        Intrinsics.checkNotNullParameter(shelfView, "shelfView");
        Intrinsics.checkNotNullParameter(recyclerView3, "shelfViewProductsItems");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "viewLifecycleOwner");
        setupSubcategoriesRecyclerView(recyclerView);
        setupProductsRecyclerView(recyclerView2);
        setupShelfView(shelfView);
        setupShelfViewProductsRecyclerView(recyclerView3);
        getHeadlinesAdapter().setClickListener(new SubcategoriesListController$init$1(this, recyclerView2));
        CompositeDisposable compositeDisposable = this.disposable;
        Flowable<R> observeOn = this.scrollPositionProcessor.onBackpressureLatest().subscribeOn(Schedulers.computation()).distinctUntilChanged().flatMapMaybe(new s0(this)).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "scrollPositionProcessor\n…dSchedulers.mainThread())");
        compositeDisposable.addAll(SubscribersKt.subscribeBy$default((Flowable) observeOn, (Function1) null, (Function0) null, (Function1) new SubcategoriesListController$init$3(this, recyclerView), 3, (Object) null));
        this.subcategoriesFragmentViewModelNew.startImpressionTracking(recyclerView2, lifecycleOwner);
    }

    public final void scrollTo(int i11) {
        this.scrollPositionProcessor.onNext(Integer.valueOf(i11));
    }

    public final void submit(@NotNull List<SubcategoryHeadline> list, @NotNull List<? extends SubcategoryItem> list2) {
        Intrinsics.checkNotNullParameter(list, "headlines");
        Intrinsics.checkNotNullParameter(list2, "subcategoryItems");
        getHeadlinesAdapter().submitList(list);
        getProductsItemsListAdapter().submitList(list2);
        this.subcategoriesFragmentViewModelNew.updateImpressionData(list2);
    }

    public final void submitCartContent(@NotNull Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "cart");
        getProductsItemsListAdapter().setCartCountMap(map);
    }

    public final void submitShelfItems(@NotNull List<ShelfItem> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        getShelfItemsListAdapter().submitList(list);
    }

    public final void submitShelfViewData(@NotNull List<? extends SubcategoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "subcategoryItems");
        getHeadlinesAdapter().setCurrentSelection(-1);
        getShelfViewProductsItemsListAdapter().submitList(list);
    }
}
