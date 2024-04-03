package com.talabat.darkstores.feature.categories.subcategories.experiment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.common.extensions.SearchViewExtensionsKt;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7;
import com.talabat.darkstores.common.view.LoadingFailedView;
import com.talabat.darkstores.feature.cart.CartFragmentData;
import com.talabat.darkstores.feature.cart.CartFragmentViewModelKt;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesData;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNewDirections;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfView;
import com.talabat.darkstores.feature.categories.subcategories.sort.SortOptionBottomSheetKt;
import com.talabat.darkstores.feature.home.swimlane.ProductClickTrackingAttribute;
import com.talabat.darkstores.feature.product.views.NavigationBarTrailingIcons;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.model.Category;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstorestooltip.domain.model.TooltipKey;
import com.talabat.feature.darkstorestooltip.presentation.ShowStrategy;
import com.talabat.feature.darkstorestooltip.presentation.TooltipData;
import com.talabat.feature.darkstorestooltip.presentation.TooltipView;
import com.talabat.wrapper.EventWrapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;
import zi.b;
import zi.c;
import zi.d;
import zi.e;
import zi.f;
import zi.g;
import zi.h;
import zi.i;
import zi.j;
import zi.k;
import zi.l;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b>\u0010?J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u001a\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0014J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010$\u001a\u00020#8\u0016XD¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010)\u001a\u00020(8\u0016X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<¨\u0006A"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNew;", "Lcom/talabat/darkstores/common/base/BaseFragment;", "", "initController", "()Ljava/lang/Boolean;", "", "observeNavigationActions", "observeBasketLifetimeTooltip", "showBasketLifetimeTooltip", "", "Lcom/talabat/darkstores/model/Category;", "categories", "onCategoriesViewAllClicked", "clearShelfViewSelection", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "product", "onProductClicked", "Landroidx/navigation/NavDirections;", "direction", "navigateOnlyIfCurrentScreenIsSubCategoriesScreen", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onResume", "Landroid/view/View;", "view", "onViewCreated", "onDestroyView", "i0", "onRetryClicked", "", "contentViewId", "I", "getContentViewId", "()I", "", "screenName", "Ljava/lang/String;", "getScreenName", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "getArgs", "()Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNewArgs;", "args", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentViewModelNew;", "viewModel", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesListController;", "subcategoriesListController$delegate", "getSubcategoriesListController", "()Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesListController;", "subcategoriesListController", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class SubcategoriesFragmentNew extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "DS Subcategory Screen";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final NavArgsLazy args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(SubcategoriesFragmentNewArgs.class), new SubcategoriesFragmentNew$special$$inlined$navArgs$1(this));
    private final int contentViewId = R.layout.darkstores_fragment_subcategories_new;
    @NotNull
    private final EventOriginType eventOriginType = EventOriginType.Category;
    @NotNull
    private final String screenName = SCREEN_NAME;
    @NotNull
    private final Lazy subcategoriesListController$delegate;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/SubcategoriesFragmentNew$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SubcategoriesFragmentNew() {
        SubcategoriesFragmentNew$special$$inlined$viewModel$1 subcategoriesFragmentNew$special$$inlined$viewModel$1 = new SubcategoriesFragmentNew$special$$inlined$viewModel$1(this);
        ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4 = new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(this);
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        Lazy lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(viewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubcategoriesFragmentViewModelNew.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), subcategoriesFragmentNew$special$$inlined$viewModel$1);
        this.subcategoriesListController$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new SubcategoriesFragmentNew$subcategoriesListController$2(this));
    }

    /* access modifiers changed from: private */
    public final void clearShelfViewSelection() {
        getViewModel().clearTag();
    }

    /* access modifiers changed from: private */
    public final SubcategoriesFragmentNewArgs getArgs() {
        return (SubcategoriesFragmentNewArgs) this.args$delegate.getValue();
    }

    private final SubcategoriesListController getSubcategoriesListController() {
        return (SubcategoriesListController) this.subcategoriesListController$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final SubcategoriesFragmentViewModelNew getViewModel() {
        return (SubcategoriesFragmentViewModelNew) this.viewModel$delegate.getValue();
    }

    private final Boolean initController() {
        View view = getView();
        if (view != null) {
            return Boolean.valueOf(view.post(new l(this)));
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: initController$lambda-15  reason: not valid java name */
    public static final void m9884initController$lambda15(SubcategoriesFragmentNew subcategoriesFragmentNew) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        if (subcategoriesFragmentNew.isAdded()) {
            SubcategoriesListController subcategoriesListController = subcategoriesFragmentNew.getSubcategoriesListController();
            RecyclerView recyclerView = (RecyclerView) subcategoriesFragmentNew._$_findCachedViewById(R.id.headlinesChipsRv);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "headlinesChipsRv");
            RecyclerView recyclerView2 = (RecyclerView) subcategoriesFragmentNew._$_findCachedViewById(R.id.productsItemsRv);
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "productsItemsRv");
            ShelfView shelfView = (ShelfView) subcategoriesFragmentNew._$_findCachedViewById(R.id.shelfView);
            Intrinsics.checkNotNullExpressionValue(shelfView, "shelfView");
            RecyclerView recyclerView3 = (RecyclerView) subcategoriesFragmentNew._$_findCachedViewById(R.id.shelfViewProductsItems);
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "shelfViewProductsItems");
            LifecycleOwner viewLifecycleOwner = subcategoriesFragmentNew.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            subcategoriesListController.init(recyclerView, recyclerView2, shelfView, recyclerView3, viewLifecycleOwner);
        }
    }

    private final void navigateOnlyIfCurrentScreenIsSubCategoriesScreen(NavDirections navDirections) {
        NavDestination currentDestination = FragmentKt.findNavController(this).getCurrentDestination();
        boolean z11 = false;
        if (currentDestination != null && currentDestination.getId() == R.id.subcategoriesFragmentNew) {
            z11 = true;
        }
        if (z11) {
            FragmentKt.findNavController(this).navigate(navDirections);
        }
    }

    private final void observeBasketLifetimeTooltip() {
        getViewModel().getBasketLifetimeTooltipLiveData().observe(getViewLifecycleOwner(), new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeBasketLifetimeTooltip$lambda-18  reason: not valid java name */
    public static final void m9885observeBasketLifetimeTooltip$lambda18(SubcategoriesFragmentNew subcategoriesFragmentNew, Unit unit) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        subcategoriesFragmentNew.showBasketLifetimeTooltip();
    }

    private final void observeNavigationActions() {
        getViewModel().getNavigationActions().observe(getViewLifecycleOwner(), new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNavigationActions$lambda-17  reason: not valid java name */
    public static final void m9886observeNavigationActions$lambda17(SubcategoriesFragmentNew subcategoriesFragmentNew, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        NavDirections navDirections = (NavDirections) eventWrapper.getContentIfNotHandled();
        if (navDirections != null) {
            subcategoriesFragmentNew.navigateOnlyIfCurrentScreenIsSubCategoriesScreen(navDirections);
        }
    }

    private final void onCategoriesViewAllClicked(List<Category> list) {
        SubcategoriesFragmentNewDirections.Companion companion = SubcategoriesFragmentNewDirections.Companion;
        Object[] array = list.toArray(new Category[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        navigateOnlyIfCurrentScreenIsSubCategoriesScreen(companion.actionSubcategoriesFragmentNewToCategoriesOverviewBottomSheet((Category[]) array));
    }

    /* access modifiers changed from: private */
    public final void onProductClicked(Product product) {
        navigateOnlyIfCurrentScreenIsSubCategoriesScreen(SubcategoriesFragmentNewDirections.Companion.actionToProductFragment$default(SubcategoriesFragmentNewDirections.Companion, product, false, (String) null, (String) null, (ProductClickTrackingAttribute) null, (String) null, (String) null, (String) null, 254, (Object) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-12  reason: not valid java name */
    public static final void m9887onViewCreated$lambda12(SubcategoriesFragmentNew subcategoriesFragmentNew, Result result) {
        int i11;
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        int i12 = R.id.allCategories;
        ImageView imageView = (ImageView) subcategoriesFragmentNew._$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(imageView, "allCategories");
        if (!result.isSuccess()) {
            i11 = 4;
        } else {
            i11 = 0;
        }
        imageView.setVisibility(i11);
        if (result instanceof Result.Success) {
            ((ImageView) subcategoriesFragmentNew._$_findCachedViewById(i12)).setOnClickListener(new c(subcategoriesFragmentNew, (List) ((Result.Success) result).getData()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-12$lambda-11$lambda-10  reason: not valid java name */
    public static final void m9888onViewCreated$lambda12$lambda11$lambda10(SubcategoriesFragmentNew subcategoriesFragmentNew, List list, View view) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        Intrinsics.checkNotNullParameter(list, "$data");
        subcategoriesFragmentNew.onCategoriesViewAllClicked(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14  reason: not valid java name */
    public static final void m9889onViewCreated$lambda14(SubcategoriesFragmentNew subcategoriesFragmentNew, Result result) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        if (result instanceof Result.Success) {
            ((NavigationBarTrailingIcons) subcategoriesFragmentNew._$_findCachedViewById(R.id.trailingIcons)).setQuantity(CartFragmentViewModelKt.cartCount(((CartFragmentData) ((Result.Success) result).getData()).getCartProductsWithSummary()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m9890onViewCreated$lambda2(SubcategoriesFragmentNew subcategoriesFragmentNew, View view) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        subcategoriesFragmentNew.getViewModel().onSearchBarClicked();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m9891onViewCreated$lambda4(SubcategoriesFragmentNew subcategoriesFragmentNew, Result result) {
        int i11;
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        ProgressBar progressBar = (ProgressBar) subcategoriesFragmentNew._$_findCachedViewById(R.id.progressBar);
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        int i12 = 0;
        if (result.isLoading()) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        Group group = (Group) subcategoriesFragmentNew._$_findCachedViewById(R.id.contentContainer);
        Intrinsics.checkNotNullExpressionValue(group, "contentContainer");
        if (!result.isSuccess()) {
            i12 = 8;
        }
        group.setVisibility(i12);
        if (result instanceof Result.Error) {
            ((LoadingFailedView) subcategoriesFragmentNew._$_findCachedViewById(R.id.errorView)).show(((Result.Error) result).getError());
        } else {
            ((LoadingFailedView) subcategoriesFragmentNew._$_findCachedViewById(R.id.errorView)).hide();
        }
        if (result instanceof Result.Success) {
            SubcategoriesData subcategoriesData = (SubcategoriesData) ((Result.Success) result).getData();
            subcategoriesFragmentNew.getSubcategoriesListController().submit(subcategoriesData.getHeadlines(), subcategoriesData.getSubcategoryItems());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final void m9892onViewCreated$lambda6(SubcategoriesFragmentNew subcategoriesFragmentNew, Result result) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        if (result instanceof Result.Success) {
            SubcategoriesData subcategoriesData = (SubcategoriesData) ((Result.Success) result).getData();
            if (subcategoriesData.getSubcategoryItems().isEmpty()) {
                RecyclerView recyclerView = (RecyclerView) subcategoriesFragmentNew._$_findCachedViewById(R.id.shelfViewProductsItems);
                Intrinsics.checkNotNullExpressionValue(recyclerView, "shelfViewProductsItems");
                recyclerView.setVisibility(8);
                RecyclerView recyclerView2 = (RecyclerView) subcategoriesFragmentNew._$_findCachedViewById(R.id.productsItemsRv);
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "productsItemsRv");
                recyclerView2.setVisibility(0);
                return;
            }
            RecyclerView recyclerView3 = (RecyclerView) subcategoriesFragmentNew._$_findCachedViewById(R.id.shelfViewProductsItems);
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "shelfViewProductsItems");
            recyclerView3.setVisibility(0);
            RecyclerView recyclerView4 = (RecyclerView) subcategoriesFragmentNew._$_findCachedViewById(R.id.productsItemsRv);
            Intrinsics.checkNotNullExpressionValue(recyclerView4, "productsItemsRv");
            recyclerView4.setVisibility(8);
            subcategoriesFragmentNew.getSubcategoriesListController().submitShelfViewData(subcategoriesData.getSubcategoryItems());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-7  reason: not valid java name */
    public static final void m9893onViewCreated$lambda7(SubcategoriesFragmentNew subcategoriesFragmentNew, Map map) {
        Intrinsics.checkNotNullParameter(subcategoriesFragmentNew, "this$0");
        SubcategoriesListController subcategoriesListController = subcategoriesFragmentNew.getSubcategoriesListController();
        Intrinsics.checkNotNullExpressionValue(map, "it");
        subcategoriesListController.submitCartContent(map);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0028, code lost:
        if ((!((java.util.Collection) ((com.talabat.darkstores.common.Result.Success) r6).getData()).isEmpty()) != false) goto L_0x002c;
     */
    /* renamed from: onViewCreated$lambda-9  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m9894onViewCreated$lambda9(com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew r5, com.talabat.darkstores.common.Result r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = com.talabat.darkstores.R.id.shelfView
            android.view.View r0 = r5._$_findCachedViewById(r0)
            com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfView r0 = (com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfView) r0
            java.lang.String r1 = "shelfView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r1 = r6 instanceof com.talabat.darkstores.common.Result.Success
            r2 = 0
            if (r1 == 0) goto L_0x002b
            r3 = r6
            com.talabat.darkstores.common.Result$Success r3 = (com.talabat.darkstores.common.Result.Success) r3
            java.lang.Object r3 = r3.getData()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r4 = r2
        L_0x002c:
            if (r4 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r2 = 8
        L_0x0031:
            r0.setVisibility(r2)
            if (r1 == 0) goto L_0x0045
            com.talabat.darkstores.common.Result$Success r6 = (com.talabat.darkstores.common.Result.Success) r6
            java.lang.Object r6 = r6.getData()
            java.util.List r6 = (java.util.List) r6
            com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesListController r5 = r5.getSubcategoriesListController()
            r5.submitShelfItems(r6)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew.m9894onViewCreated$lambda9(com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNew, com.talabat.darkstores.common.Result):void");
    }

    private final void showBasketLifetimeTooltip() {
        TooltipKey tooltipKey = TooltipKey.BASKET_LIFETIME;
        View bagIcon = ((NavigationBarTrailingIcons) _$_findCachedViewById(R.id.trailingIcons)).getBagIcon();
        String string = getString(com.talabat.localization.R.string.basket_lifetime_tooltip);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….basket_lifetime_tooltip)");
        ((TooltipView) _$_findCachedViewById(R.id.basketLifetimeTooltipView)).initialize(new TooltipData(tooltipKey, bagIcon, string, false, 0, ShowStrategy.Once, 24, (DefaultConstructorMarker) null));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public int getContentViewId() {
        return this.contentViewId;
    }

    @NotNull
    public EventOriginType getEventOriginType() {
        return this.eventOriginType;
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void i0() {
        super.i0();
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.toolbar);
        ((TextView) _$_findCachedViewById(R.id.toolbar_title)).setText(getArgs().getCategoryName());
        toolbar.setNavigationIcon(ResourcesCompat.getDrawable(toolbar.getResources(), R.drawable.ic_m_back_white_bg, (Resources.Theme) null));
        SearchView searchView = (SearchView) _$_findCachedViewById(R.id.searchView);
        Intrinsics.checkNotNullExpressionValue(searchView, "searchView");
        SearchViewExtensionsKt.styleMarshmallowSearchBar(searchView);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getViewModel().startTraceDefinition();
    }

    public void onDestroyView() {
        getSubcategoriesListController().dispose();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
        getViewModel().onReadyForInteractionDhDefinition();
    }

    public void onRetryClicked() {
        Timber.d("Retrying subcategories", new Object[0]);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((LoadingFailedView) _$_findCachedViewById(R.id.errorView)).setOnReloadClicked(new SubcategoriesFragmentNew$onViewCreated$1(this));
        ((NavigationBarTrailingIcons) _$_findCachedViewById(R.id.trailingIcons)).setOnCartClickListener(new SubcategoriesFragmentNew$onViewCreated$2$1(getViewModel()));
        _$_findCachedViewById(R.id.btnSearch).setOnClickListener(new e(this));
        initController();
        getViewModel().subcategoriesData().observe(getViewLifecycleOwner(), new f(this));
        getViewModel().shelfViewData().observe(getViewLifecycleOwner(), new g(this));
        getCartFragmentViewModel().getCartMapLiveData().observe(getViewLifecycleOwner(), new h(this));
        getViewModel().getShelfItemsLiveData().observe(getViewLifecycleOwner(), new i(this));
        getViewModel().getCategoriesLiveData().observe(getViewLifecycleOwner(), new j(this));
        getCartFragmentViewModel().getCartFragmentLiveData().observe(getViewLifecycleOwner(), new k(this));
        observeNavigationActions();
        observeBasketLifetimeTooltip();
        androidx.fragment.app.FragmentKt.setFragmentResultListener(this, SortOptionBottomSheetKt.REQUEST_APPLIED_SORT_OPTION, new SubcategoriesFragmentNew$onViewCreated$10(this));
    }
}
