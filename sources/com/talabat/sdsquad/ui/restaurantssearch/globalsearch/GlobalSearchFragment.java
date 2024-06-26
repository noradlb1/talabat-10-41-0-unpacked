package com.talabat.sdsquad.ui.restaurantssearch.globalsearch;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.core.TalabatViewModelFactory;
import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.adapters.GlobalSearchAdapter;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ku.a;
import ku.b;
import ku.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/GlobalSearchFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "()V", "mListScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mSearchAdapter", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/adapters/GlobalSearchAdapter;", "getMSearchAdapter", "()Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/adapters/GlobalSearchAdapter;", "mSearchAdapter$delegate", "Lkotlin/Lazy;", "mTabSelectedListener", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "viewModel", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/GlobalSearchViewModel;", "addDishTab", "", "addRestaurantTab", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "vendorClicked", "vendor", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalSearchFragment extends Fragment implements VendorViewHolder.VendorClickListener, TraceFieldInterface {
    @NotNull
    private static final String ARG_AREA_ID = "areaId";
    @NotNull
    private static final String ARG_CITY_ID = "cityId";
    @NotNull
    private static final String ARG_COLLECTION_ID = "collectionId";
    @NotNull
    private static final String ARG_COUNTRY_ID = "countryId";
    @NotNull
    private static final String ARG_LATITUDE = "latitude";
    @NotNull
    private static final String ARG_LONGITUDE = "longitude";
    @NotNull
    private static final String ARG_SEARCH_TERM = "search";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    @NotNull
    public final RecyclerView.OnScrollListener mListScrollListener = new GlobalSearchFragment$mListScrollListener$1(this);
    @NotNull
    private final Lazy mSearchAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, GlobalSearchFragment$mSearchAdapter$2.INSTANCE);
    /* access modifiers changed from: private */
    @NotNull
    public final TabLayout.OnTabSelectedListener mTabSelectedListener = new GlobalSearchFragment$mTabSelectedListener$1(this);
    /* access modifiers changed from: private */
    public GlobalSearchViewModel viewModel;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/GlobalSearchFragment$Companion;", "", "()V", "ARG_AREA_ID", "", "ARG_CITY_ID", "ARG_COLLECTION_ID", "ARG_COUNTRY_ID", "ARG_LATITUDE", "ARG_LONGITUDE", "ARG_SEARCH_TERM", "newInstance", "Lcom/talabat/sdsquad/ui/restaurantssearch/globalsearch/GlobalSearchFragment;", "searchTerm", "latitude", "longitude", "areaId", "", "cityId", "countryId", "collectionId", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GlobalSearchFragment newInstance(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, int i12, int i13, int i14) {
            Intrinsics.checkNotNullParameter(str, "searchTerm");
            Intrinsics.checkNotNullParameter(str2, "latitude");
            Intrinsics.checkNotNullParameter(str3, "longitude");
            GlobalSearchFragment globalSearchFragment = new GlobalSearchFragment();
            Bundle bundle = new Bundle();
            bundle.putString("search", str);
            bundle.putString("latitude", str2);
            bundle.putString("longitude", str3);
            bundle.putInt("countryId", i13);
            bundle.putInt("areaId", i11);
            bundle.putInt("cityId", i12);
            bundle.putInt("collectionId", i14);
            globalSearchFragment.setArguments(bundle);
            return globalSearchFragment;
        }
    }

    private final void addDishTab() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.tab_vendor_search, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.….tab_vendor_search, null)");
        ((TextView) inflate.findViewById(R.id.tabName)).setText("Dishes");
        int i11 = R.id.tabLayout;
        TabLayout.Tab newTab = ((TabLayout) _$_findCachedViewById(i11)).newTab();
        Intrinsics.checkNotNullExpressionValue(newTab, "tabLayout.newTab()");
        newTab.setCustomView(inflate);
        newTab.setTag("dish");
        ((TabLayout) _$_findCachedViewById(i11)).addTab(newTab);
    }

    private final void addRestaurantTab() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.tab_vendor_search, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.….tab_vendor_search, null)");
        ((TextView) inflate.findViewById(R.id.tabName)).setText("Restaurants");
        int i11 = R.id.tabLayout;
        TabLayout.Tab newTab = ((TabLayout) _$_findCachedViewById(i11)).newTab();
        Intrinsics.checkNotNullExpressionValue(newTab, "tabLayout.newTab()");
        newTab.setCustomView(inflate);
        newTab.setTag("restaurant");
        ((TabLayout) _$_findCachedViewById(i11)).addTab(newTab);
    }

    private final GlobalSearchAdapter getMSearchAdapter() {
        return (GlobalSearchAdapter) this.mSearchAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-0  reason: not valid java name */
    public static final void m10831onActivityCreated$lambda0(GlobalSearchFragment globalSearchFragment, List list) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "this$0");
        GlobalSearchAdapter mSearchAdapter = globalSearchFragment.getMSearchAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        mSearchAdapter.setResultList(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m10832onActivityCreated$lambda1(GlobalSearchFragment globalSearchFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            globalSearchFragment.addRestaurantTab();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-2  reason: not valid java name */
    public static final void m10833onActivityCreated$lambda2(GlobalSearchFragment globalSearchFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            globalSearchFragment.addDishTab();
        }
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

    public void onActivityCreated(@Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        int i11;
        int i12;
        GlobalSearchViewModel globalSearchViewModel;
        String string;
        String string2;
        String string3;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (string3 = arguments.getString("search")) == null) {
            str = "";
        } else {
            str = string3;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString("latitude")) == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (string = arguments3.getString("longitude")) == null) {
            str3 = "";
        } else {
            str3 = string;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            i11 = arguments4.getInt("countryId");
        } else {
            i11 = 0;
        }
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            arguments5.getInt("cityId");
        }
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            arguments6.getInt("areaId");
        }
        Bundle arguments7 = getArguments();
        if (arguments7 != null) {
            i12 = arguments7.getInt("collectionId");
        } else {
            i12 = 0;
        }
        this.viewModel = (GlobalSearchViewModel) ViewModelProviders.of((Fragment) this, (ViewModelProvider.Factory) new TalabatViewModelFactory()).get(GlobalSearchViewModel.class);
        int i13 = R.id.globalSearchRecyclerView;
        ((RecyclerView) _$_findCachedViewById(i13)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((RecyclerView) _$_findCachedViewById(i13)).addOnScrollListener(this.mListScrollListener);
        ((TabLayout) _$_findCachedViewById(R.id.tabLayout)).addOnTabSelectedListener(this.mTabSelectedListener);
        getMSearchAdapter().setVendorClickListener(this);
        ((RecyclerView) _$_findCachedViewById(i13)).setAdapter(getMSearchAdapter());
        GlobalSearchViewModel globalSearchViewModel2 = this.viewModel;
        GlobalSearchViewModel globalSearchViewModel3 = null;
        if (globalSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            globalSearchViewModel = null;
        } else {
            globalSearchViewModel = globalSearchViewModel2;
        }
        globalSearchViewModel.search(str2, str3, i11, str, "en", i12);
        GlobalSearchViewModel globalSearchViewModel4 = this.viewModel;
        if (globalSearchViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            globalSearchViewModel4 = null;
        }
        globalSearchViewModel4.getResultList().observe(this, new a(this));
        GlobalSearchViewModel globalSearchViewModel5 = this.viewModel;
        if (globalSearchViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            globalSearchViewModel5 = null;
        }
        globalSearchViewModel5.getVendorTab().observe(this, new b(this));
        GlobalSearchViewModel globalSearchViewModel6 = this.viewModel;
        if (globalSearchViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            globalSearchViewModel3 = globalSearchViewModel6;
        }
        globalSearchViewModel3.getDishTab().observe(this, new c(this));
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "GlobalSearchFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GlobalSearchFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_global_search, viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void vendorClicked(@NotNull VendorDisplayModel vendorDisplayModel) {
        Intrinsics.checkNotNullParameter(vendorDisplayModel, "vendor");
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        GlobalSearchViewModel globalSearchViewModel = this.viewModel;
        if (globalSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            globalSearchViewModel = null;
        }
        companion.setGlobalRestaurantModel(globalSearchViewModel.getVendorById(vendorDisplayModel.getId()));
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, vendorDisplayModel.getBranchId(), vendorDisplayModel.getVerticalType(), vendorDisplayModel.isGrlEnabled(), vendorDisplayModel.isDarkStore(), false, false, (String) null, (Bundle) null, 224, (Object) null));
        }
    }
}
