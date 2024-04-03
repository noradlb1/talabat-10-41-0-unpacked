package com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.core.TalabatViewModelFactory;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.adapters.DishesSuggestionsAdapter;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.adapters.VendorsSuggestionsAdapter;
import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.adapters.viewholders.VendorSuggestionViewHolder;
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
import lu.a;
import lu.b;
import lu.c;
import lu.d;
import lu.e;
import lu.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/SuggestionsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/viewholders/VendorSuggestionViewHolder$VendorClickListener;", "()V", "mDishSuggestionsAdapter", "Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/DishesSuggestionsAdapter;", "getMDishSuggestionsAdapter", "()Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/DishesSuggestionsAdapter;", "mDishSuggestionsAdapter$delegate", "Lkotlin/Lazy;", "mSuggestionsAdapter", "Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/VendorsSuggestionsAdapter;", "getMSuggestionsAdapter", "()Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/adapters/VendorsSuggestionsAdapter;", "mSuggestionsAdapter$delegate", "viewModel", "Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/SuggestionsViewModel;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupDishesRecyclerView", "setupVendorRecyclerView", "vendorClicked", "vendor", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SuggestionsFragment extends Fragment implements VendorSuggestionViewHolder.VendorClickListener, TraceFieldInterface {
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
    @NotNull
    private final Lazy mDishSuggestionsAdapter$delegate;
    @NotNull
    private final Lazy mSuggestionsAdapter$delegate;
    private SuggestionsViewModel viewModel;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/SuggestionsFragment$Companion;", "", "()V", "ARG_AREA_ID", "", "ARG_CITY_ID", "ARG_COLLECTION_ID", "ARG_COUNTRY_ID", "ARG_LATITUDE", "ARG_LONGITUDE", "ARG_SEARCH_TERM", "newInstance", "Lcom/talabat/sdsquad/ui/restaurantssearch/suggestionsearch/SuggestionsFragment;", "searchTerm", "latitude", "longitude", "areaId", "", "cityId", "countryId", "collectionId", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SuggestionsFragment newInstance(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, int i12, int i13, int i14) {
            Intrinsics.checkNotNullParameter(str, "searchTerm");
            Intrinsics.checkNotNullParameter(str2, "latitude");
            Intrinsics.checkNotNullParameter(str3, "longitude");
            SuggestionsFragment suggestionsFragment = new SuggestionsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("search", str);
            bundle.putString("latitude", str2);
            bundle.putString("longitude", str3);
            bundle.putInt("countryId", i13);
            bundle.putInt("areaId", i11);
            bundle.putInt("cityId", i12);
            bundle.putInt("collectionId", i14);
            suggestionsFragment.setArguments(bundle);
            return suggestionsFragment;
        }
    }

    public SuggestionsFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.mSuggestionsAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SuggestionsFragment$mSuggestionsAdapter$2.INSTANCE);
        this.mDishSuggestionsAdapter$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SuggestionsFragment$mDishSuggestionsAdapter$2.INSTANCE);
    }

    private final DishesSuggestionsAdapter getMDishSuggestionsAdapter() {
        return (DishesSuggestionsAdapter) this.mDishSuggestionsAdapter$delegate.getValue();
    }

    private final VendorsSuggestionsAdapter getMSuggestionsAdapter() {
        return (VendorsSuggestionsAdapter) this.mSuggestionsAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m10842onActivityCreated$lambda1(SuggestionsFragment suggestionsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(suggestionsFragment, "this$0");
        Button button = (Button) suggestionsFragment._$_findCachedViewById(R.id.seeMoreVendors);
        Intrinsics.checkNotNullExpressionValue(button, "seeMoreVendors");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        ViewExtentionsKt.show$default(button, bool.booleanValue(), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-2  reason: not valid java name */
    public static final void m10843onActivityCreated$lambda2(SuggestionsFragment suggestionsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(suggestionsFragment, "this$0");
        Button button = (Button) suggestionsFragment._$_findCachedViewById(R.id.seeMoreItemsBtn);
        Intrinsics.checkNotNullExpressionValue(button, "seeMoreItemsBtn");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        ViewExtentionsKt.show$default(button, bool.booleanValue(), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-3  reason: not valid java name */
    public static final void m10844onActivityCreated$lambda3(SuggestionsFragment suggestionsFragment, List list) {
        Intrinsics.checkNotNullParameter(suggestionsFragment, "this$0");
        VendorsSuggestionsAdapter mSuggestionsAdapter = suggestionsFragment.getMSuggestionsAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        mSuggestionsAdapter.setSuggestionsList(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-4  reason: not valid java name */
    public static final void m10845onActivityCreated$lambda4(SuggestionsFragment suggestionsFragment, List list) {
        Intrinsics.checkNotNullParameter(suggestionsFragment, "this$0");
        DishesSuggestionsAdapter mDishSuggestionsAdapter = suggestionsFragment.getMDishSuggestionsAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        mDishSuggestionsAdapter.setSuggestionsList(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-5  reason: not valid java name */
    public static final void m10846onActivityCreated$lambda5(SuggestionsFragment suggestionsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(suggestionsFragment, "this$0");
        LinearLayout linearLayout = (LinearLayout) suggestionsFragment._$_findCachedViewById(R.id.restaurantsSuggestionContainer);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "restaurantsSuggestionContainer");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        ViewExtentionsKt.show$default(linearLayout, bool.booleanValue(), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-6  reason: not valid java name */
    public static final void m10847onActivityCreated$lambda6(SuggestionsFragment suggestionsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(suggestionsFragment, "this$0");
        LinearLayout linearLayout = (LinearLayout) suggestionsFragment._$_findCachedViewById(R.id.itemsSuggestionContainer);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "itemsSuggestionContainer");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        ViewExtentionsKt.show$default(linearLayout, bool.booleanValue(), 0, 2, (Object) null);
    }

    private final void setupDishesRecyclerView() {
        int i11 = R.id.itemSuggestionList;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(getMDishSuggestionsAdapter());
    }

    private final void setupVendorRecyclerView() {
        int i11 = R.id.vendorsSuggestionsList;
        ((RecyclerView) _$_findCachedViewById(i11)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        getMSuggestionsAdapter().setVendorClickListener(this);
        ((RecyclerView) _$_findCachedViewById(i11)).setAdapter(getMSuggestionsAdapter());
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
        int i13;
        int i14;
        String string;
        String string2;
        super.onActivityCreated(bundle);
        this.viewModel = (SuggestionsViewModel) ViewModelProviders.of((Fragment) this, (ViewModelProvider.Factory) new TalabatViewModelFactory()).get(SuggestionsViewModel.class);
        Bundle arguments = getArguments();
        SuggestionsViewModel suggestionsViewModel = null;
        if (arguments != null) {
            str = arguments.getString("search");
        } else {
            str = null;
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
            i12 = arguments5.getInt("cityId");
        } else {
            i12 = 0;
        }
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            i13 = arguments6.getInt("areaId");
        } else {
            i13 = 0;
        }
        Bundle arguments7 = getArguments();
        if (arguments7 != null) {
            i14 = arguments7.getInt("collectionId");
        } else {
            i14 = 0;
        }
        setupVendorRecyclerView();
        setupDishesRecyclerView();
        if (str != null) {
            SuggestionsViewModel suggestionsViewModel2 = this.viewModel;
            if (suggestionsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                suggestionsViewModel2 = null;
            }
            suggestionsViewModel2.search(str2, str3, str, i13, i12, i11, "en", i14);
        }
        SuggestionsViewModel suggestionsViewModel3 = this.viewModel;
        if (suggestionsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suggestionsViewModel3 = null;
        }
        suggestionsViewModel3.getShowVendorsSeeMore().observe(this, new a(this));
        SuggestionsViewModel suggestionsViewModel4 = this.viewModel;
        if (suggestionsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suggestionsViewModel4 = null;
        }
        suggestionsViewModel4.getShowDishesSeeMore().observe(this, new b(this));
        SuggestionsViewModel suggestionsViewModel5 = this.viewModel;
        if (suggestionsViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suggestionsViewModel5 = null;
        }
        suggestionsViewModel5.getVendorsSuggestionsList().observe(this, new c(this));
        SuggestionsViewModel suggestionsViewModel6 = this.viewModel;
        if (suggestionsViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suggestionsViewModel6 = null;
        }
        suggestionsViewModel6.getDishesSuggestionsList().observe(this, new d(this));
        SuggestionsViewModel suggestionsViewModel7 = this.viewModel;
        if (suggestionsViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suggestionsViewModel7 = null;
        }
        suggestionsViewModel7.getShowVendorsSuggestions().observe(this, new e(this));
        SuggestionsViewModel suggestionsViewModel8 = this.viewModel;
        if (suggestionsViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            suggestionsViewModel = suggestionsViewModel8;
        }
        suggestionsViewModel.getShowDishesSuggestions().observe(this, new f(this));
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "SuggestionsFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SuggestionsFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_suggestions, viewGroup, false);
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
        SuggestionsViewModel suggestionsViewModel = this.viewModel;
        if (suggestionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            suggestionsViewModel = null;
        }
        companion.setGlobalRestaurantModel(suggestionsViewModel.getVendorById(vendorDisplayModel.getId()));
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, vendorDisplayModel.getBranchId(), vendorDisplayModel.getVerticalType(), vendorDisplayModel.isGrlEnabled(), vendorDisplayModel.isDarkStore(), false, false, (String) null, (Bundle) null, 224, (Object) null));
        }
    }
}
