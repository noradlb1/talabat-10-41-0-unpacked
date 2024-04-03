package com.talabat.darkstores.feature.categories;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.FragmentKt;
import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.tabs.TabLayout;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.base.BaseFragment;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6;
import com.talabat.darkstores.common.extensions.ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7;
import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.feature.categories.CategoriesFragmentDirections;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import com.talabat.darkstores.model.Category;
import com.talabat.wrapper.EventWrapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xi.a;
import xi.b;
import xi.c;
import xi.d;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104J \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016XD¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragment;", "Lcom/talabat/darkstores/common/base/BaseFragment;", "", "Lcom/talabat/darkstores/model/Category;", "categories", "Landroid/os/Bundle;", "savedInstanceState", "", "onDataReceived", "", "initViewPager", "()Ljava/lang/Boolean;", "onCategoriesViewAllClicked", "isRtl", "observeNavigationActions", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "i0", "onRetryClicked", "", "contentViewId", "I", "getContentViewId", "()I", "", "screenName", "Ljava/lang/String;", "getScreenName", "()Ljava/lang/String;", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "getEventOriginType", "()Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "Lcom/talabat/darkstores/feature/categories/CategoriesFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/talabat/darkstores/feature/categories/CategoriesFragmentViewModel;", "viewModel", "Lcom/talabat/darkstores/feature/categories/CategoriesFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "getArgs", "()Lcom/talabat/darkstores/feature/categories/CategoriesFragmentArgs;", "args", "Lcom/talabat/darkstores/feature/categories/ViewPagerAdapter;", "viewPagerAdapter", "Lcom/talabat/darkstores/feature/categories/ViewPagerAdapter;", "<init>", "()V", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class CategoriesFragment extends BaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_NAME = "DS Category Screen";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final NavArgsLazy args$delegate;
    private final int contentViewId = R.layout.darkstores_fragment_categories;
    @NotNull
    private final EventOriginType eventOriginType = EventOriginType.Category;
    @NotNull
    private final String screenName = SCREEN_NAME;
    @NotNull
    private final Lazy viewModel$delegate;
    @Nullable
    private ViewPagerAdapter viewPagerAdapter;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/categories/CategoriesFragment$Companion;", "", "()V", "SCREEN_NAME", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CategoriesFragment() {
        CategoriesFragment$special$$inlined$viewModel$1 categoriesFragment$special$$inlined$viewModel$1 = new CategoriesFragment$special$$inlined$viewModel$1();
        Lazy lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$5(new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$4(this)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CategoriesFragmentViewModel.class), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$6(lazy), new ViewModelFactoryExtensionsKt$viewModel$$inlined$viewModels$default$7((Function0) null, lazy), categoriesFragment$special$$inlined$viewModel$1);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(CategoriesFragmentArgs.class), new CategoriesFragment$special$$inlined$navArgs$1(this));
    }

    private final CategoriesFragmentArgs getArgs() {
        return (CategoriesFragmentArgs) this.args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CategoriesFragmentViewModel getViewModel() {
        return (CategoriesFragmentViewModel) this.viewModel$delegate.getValue();
    }

    private final Boolean initViewPager() {
        View view = getView();
        if (view != null) {
            return Boolean.valueOf(view.post(new c(this)));
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: initViewPager$lambda-3  reason: not valid java name */
    public static final void m9854initViewPager$lambda3(CategoriesFragment categoriesFragment) {
        Intrinsics.checkNotNullParameter(categoriesFragment, "this$0");
        if (categoriesFragment.isAdded()) {
            if (categoriesFragment.viewPagerAdapter != null) {
                ((RtlViewPager) categoriesFragment._$_findCachedViewById(R.id.subcategoriesViewPager)).setAdapter(categoriesFragment.viewPagerAdapter);
            }
            ((TabLayout) categoriesFragment._$_findCachedViewById(R.id.tabLayout)).setupWithViewPager((RtlViewPager) categoriesFragment._$_findCachedViewById(R.id.subcategoriesViewPager));
        }
    }

    private final boolean isRtl() {
        return requireView().getLayoutDirection() == 1;
    }

    private final void observeNavigationActions() {
        getViewModel().getNavigationActions().observe(getViewLifecycleOwner(), new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeNavigationActions$lambda-5  reason: not valid java name */
    public static final void m9855observeNavigationActions$lambda5(CategoriesFragment categoriesFragment, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(categoriesFragment, "this$0");
        NavDirections navDirections = (NavDirections) eventWrapper.getContentIfNotHandled();
        if (navDirections != null) {
            FragmentKt.findNavController(categoriesFragment).navigate(navDirections);
        }
    }

    private final void onCategoriesViewAllClicked(List<Category> list) {
        NavController findNavController = FragmentKt.findNavController(this);
        CategoriesFragmentDirections.Companion companion = CategoriesFragmentDirections.Companion;
        Object[] array = list.toArray(new Category[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        findNavController.navigate(companion.actionCategoriesFragmentToCategoriesOverviewBottomSheet((Category[]) array));
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(List<Category> list, Bundle bundle) {
        Category topLevelCategory = getViewModel().getTopLevelCategory(list, getArgs().getCategory().getId());
        String str = null;
        CategoriesFragmentViewModel.trackCategorySelected$default(getViewModel(), topLevelCategory, 0, 2, (Object) null);
        int indexOf = list.indexOf(topLevelCategory);
        if (bundle == null) {
            if (!Intrinsics.areEqual((Object) getArgs().getCategory().getId(), (Object) topLevelCategory.getId())) {
                str = getArgs().getCategory().getId();
            }
            EventOrigin fromTrackingName = EventOrigin.Companion.fromTrackingName(getArgs().getEventOrigin());
            boolean isRtl = isRtl();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            this.viewPagerAdapter = new ViewPagerAdapter(list, str, fromTrackingName, isRtl, childFragmentManager);
            int i11 = R.id.subcategoriesViewPager;
            ((RtlViewPager) _$_findCachedViewById(i11)).setAdapter(this.viewPagerAdapter);
            ((RtlViewPager) _$_findCachedViewById(i11)).setCurrentItem(indexOf, false);
        } else {
            EventOrigin fromTrackingName2 = EventOrigin.Companion.fromTrackingName(getArgs().getEventOrigin());
            boolean isRtl2 = isRtl();
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            this.viewPagerAdapter = new ViewPagerAdapter(list, (String) null, fromTrackingName2, isRtl2, childFragmentManager2);
            ((RtlViewPager) _$_findCachedViewById(R.id.subcategoriesViewPager)).setAdapter(this.viewPagerAdapter);
        }
        ((AppCompatImageView) _$_findCachedViewById(R.id.allCategories)).setOnClickListener(new d(this, list));
        ((RtlViewPager) _$_findCachedViewById(R.id.subcategoriesViewPager)).addOnPageChangeListener(new CategoriesFragment$onDataReceived$2(this, list));
    }

    /* access modifiers changed from: private */
    /* renamed from: onDataReceived$lambda-2  reason: not valid java name */
    public static final void m9856onDataReceived$lambda2(CategoriesFragment categoriesFragment, List list, View view) {
        Intrinsics.checkNotNullParameter(categoriesFragment, "this$0");
        Intrinsics.checkNotNullParameter(list, "$categories");
        categoriesFragment.onCategoriesViewAllClicked(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupToolbar$lambda-1  reason: not valid java name */
    public static final void m9857setupToolbar$lambda1(CategoriesFragment categoriesFragment, View view) {
        Intrinsics.checkNotNullParameter(categoriesFragment, "this$0");
        categoriesFragment.getViewModel().onSearchBarClicked();
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
        int i11 = R.id.toolbar;
        ((Toolbar) _$_findCachedViewById(i11)).setNavigationIcon(ResourcesCompat.getDrawable(getResources(), com.designsystem.marshmallow.R.drawable.ds_arrow_back, (Resources.Theme) null));
        ((Toolbar) _$_findCachedViewById(i11)).findViewById(R.id.btnSearch).setOnClickListener(new a(this));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        f(getViewModel().getCategoriesLiveData(), this, new CategoriesFragment$onCreate$1(this, bundle));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onRetryClicked() {
        getViewModel().onRetry();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initViewPager();
        observeNavigationActions();
    }
}
