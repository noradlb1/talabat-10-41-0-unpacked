package com.talabat.sdsquad.ui.collections;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.core.TalabatViewModelFactory;
import com.talabat.sdsquad.data.vendorslist.response.SortTypes;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import com.talabat.sdsquad.ui.cuisines.CuisinesActivity;
import com.talabat.sdsquad.ui.filters.FiltersActivity;
import com.talabat.sdsquad.ui.restaurantssearch.VendorSearchActivity;
import com.talabat.sdsquad.ui.vendorslist.adapters.VendorsListAdapter;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import eu.a;
import eu.b;
import eu.c;
import eu.d;
import eu.e;
import eu.f;
import eu.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\"\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/talabat/sdsquad/ui/collections/CollectionsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "()V", "areaId", "", "cityId", "collection", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "countryId", "latitude", "", "longitude", "mVendorsListAdapter", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/VendorsListAdapter;", "getMVendorsListAdapter", "()Lcom/talabat/sdsquad/ui/vendorslist/adapters/VendorsListAdapter;", "mVendorsListAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/talabat/sdsquad/ui/collections/CollectionsViewModel;", "loadVendorList", "", "update", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "vendorClicked", "vendor", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsFragment extends Fragment implements VendorViewHolder.VendorClickListener, TraceFieldInterface {
    @NotNull
    private static final String ARG_AREA_ID = "areaId";
    @NotNull
    private static final String ARG_CITY_ID = "cityId";
    @NotNull
    private static final String ARG_COLLECTION = "collection";
    @NotNull
    private static final String ARG_COUNTRY_ID = "countryId";
    @NotNull
    private static final String ARG_LATITUDE = "latitude";
    @NotNull
    private static final String ARG_LONGITUDE = "longitude";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REQUEST_CODE_CUISINE = 200;
    private static final int REQUEST_CODE_FILTERS = 100;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private int areaId;
    private int cityId;
    @Nullable
    private CollectionDisplayModel collection;
    private int countryId;
    @NotNull
    private String latitude = "";
    @NotNull
    private String longitude = "";
    @NotNull
    private final Lazy mVendorsListAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, CollectionsFragment$mVendorsListAdapter$2.INSTANCE);
    private CollectionsViewModel viewModel;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/sdsquad/ui/collections/CollectionsFragment$Companion;", "", "()V", "ARG_AREA_ID", "", "ARG_CITY_ID", "ARG_COLLECTION", "ARG_COUNTRY_ID", "ARG_LATITUDE", "ARG_LONGITUDE", "REQUEST_CODE_CUISINE", "", "REQUEST_CODE_FILTERS", "newInstance", "Lcom/talabat/sdsquad/ui/collections/CollectionsFragment;", "latitude", "longitude", "areaId", "cityId", "countryId", "collection", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CollectionsFragment newInstance(@Nullable String str, @Nullable String str2, int i11, int i12, int i13, @Nullable CollectionDisplayModel collectionDisplayModel) {
            CollectionsFragment collectionsFragment = new CollectionsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("latitude", str);
            bundle.putString("longitude", str2);
            bundle.putInt("areaId", i11);
            bundle.putInt("cityId", i12);
            bundle.putInt("countryId", i13);
            bundle.putParcelable("collection", collectionDisplayModel);
            collectionsFragment.setArguments(bundle);
            return collectionsFragment;
        }
    }

    private final VendorsListAdapter getMVendorsListAdapter() {
        return (VendorsListAdapter) this.mVendorsListAdapter$delegate.getValue();
    }

    private final void loadVendorList(boolean z11) {
        int i11;
        CollectionsViewModel collectionsViewModel = this.viewModel;
        if (collectionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            collectionsViewModel = null;
        }
        CollectionsViewModel collectionsViewModel2 = collectionsViewModel;
        CollectionDisplayModel collectionDisplayModel = this.collection;
        if (collectionDisplayModel != null) {
            i11 = collectionDisplayModel.getId();
        } else {
            i11 = 0;
        }
        collectionsViewModel2.getVendors(z11, i11, this.latitude, this.longitude, this.areaId, this.cityId, this.countryId);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-0  reason: not valid java name */
    public static final void m10795onActivityCreated$lambda0(CollectionsFragment collectionsFragment, View view) {
        Intrinsics.checkNotNullParameter(collectionsFragment, "this$0");
        FragmentActivity activity = collectionsFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m10796onActivityCreated$lambda1(CollectionsFragment collectionsFragment, List list) {
        Intrinsics.checkNotNullParameter(collectionsFragment, "this$0");
        if (list.isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) collectionsFragment._$_findCachedViewById(R.id.collectionRecycler);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "collectionRecycler");
            ViewExtentionsKt.show$default(recyclerView, false, 0, 2, (Object) null);
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) collectionsFragment._$_findCachedViewById(R.id.collectionRecycler);
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "collectionRecycler");
        ViewExtentionsKt.show$default(recyclerView2, true, 0, 2, (Object) null);
        VendorsListAdapter mVendorsListAdapter = collectionsFragment.getMVendorsListAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        mVendorsListAdapter.setVendorList(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-2  reason: not valid java name */
    public static final void m10797onActivityCreated$lambda2(CollectionsFragment collectionsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(collectionsFragment, "this$0");
        ImageView imageView = (ImageView) collectionsFragment._$_findCachedViewById(R.id.filterBubbleContainer);
        Intrinsics.checkNotNullExpressionValue(imageView, "filterBubbleContainer");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        ViewExtentionsKt.show$default(imageView, bool.booleanValue(), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-3  reason: not valid java name */
    public static final void m10798onActivityCreated$lambda3(CollectionsFragment collectionsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(collectionsFragment, "this$0");
        ImageView imageView = (ImageView) collectionsFragment._$_findCachedViewById(R.id.cuisineBubbleContainer);
        Intrinsics.checkNotNullExpressionValue(imageView, "cuisineBubbleContainer");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        ViewExtentionsKt.show$default(imageView, bool.booleanValue(), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-4  reason: not valid java name */
    public static final void m10799onActivityCreated$lambda4(CollectionsFragment collectionsFragment, View view) {
        Intrinsics.checkNotNullParameter(collectionsFragment, "this$0");
        FiltersActivity.Companion companion = FiltersActivity.Companion;
        CollectionsViewModel collectionsViewModel = collectionsFragment.viewModel;
        CollectionsViewModel collectionsViewModel2 = null;
        if (collectionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            collectionsViewModel = null;
        }
        Integer valueOf = Integer.valueOf(collectionsViewModel.getAppliedSort());
        CollectionsViewModel collectionsViewModel3 = collectionsFragment.viewModel;
        if (collectionsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            collectionsViewModel2 = collectionsViewModel3;
        }
        companion.startForResult(collectionsFragment, 100, valueOf, collectionsViewModel2.getAppliedFilters());
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-5  reason: not valid java name */
    public static final void m10800onActivityCreated$lambda5(CollectionsFragment collectionsFragment, View view) {
        Intrinsics.checkNotNullParameter(collectionsFragment, "this$0");
        CuisinesActivity.Companion companion = CuisinesActivity.Companion;
        CollectionsViewModel collectionsViewModel = collectionsFragment.viewModel;
        if (collectionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            collectionsViewModel = null;
        }
        companion.startForResult(collectionsFragment, 200, collectionsViewModel.getAppliedCuisine());
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-7  reason: not valid java name */
    public static final void m10801onActivityCreated$lambda7(CollectionsFragment collectionsFragment, View view) {
        int i11;
        Intrinsics.checkNotNullParameter(collectionsFragment, "this$0");
        Context context = collectionsFragment.getContext();
        if (context != null) {
            VendorSearchActivity.Companion companion = VendorSearchActivity.Companion;
            String str = collectionsFragment.latitude;
            String str2 = collectionsFragment.longitude;
            int i12 = collectionsFragment.areaId;
            int i13 = collectionsFragment.cityId;
            int i14 = collectionsFragment.countryId;
            CollectionDisplayModel collectionDisplayModel = collectionsFragment.collection;
            if (collectionDisplayModel != null) {
                i11 = collectionDisplayModel.getId();
            } else {
                i11 = 0;
            }
            companion.start(context, str, str2, i12, i13, i14, i11);
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
        int i11;
        int i12;
        int i13;
        CollectionDisplayModel collectionDisplayModel;
        boolean z11;
        boolean z12;
        Window window;
        String str3;
        String name2;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        CollectionsViewModel collectionsViewModel = null;
        if (arguments != null) {
            str = arguments.getString("latitude");
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = str4;
        }
        this.latitude = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("longitude");
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = str4;
        }
        this.longitude = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            i11 = arguments3.getInt("areaId");
        } else {
            i11 = 0;
        }
        this.areaId = i11;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            i12 = arguments4.getInt("cityId");
        } else {
            i12 = 0;
        }
        this.cityId = i12;
        Bundle arguments5 = getArguments();
        if (arguments5 != null) {
            i13 = arguments5.getInt("countryId");
        } else {
            i13 = 0;
        }
        this.countryId = i13;
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            collectionDisplayModel = (CollectionDisplayModel) arguments6.getParcelable("collection");
        } else {
            collectionDisplayModel = null;
        }
        this.collection = collectionDisplayModel;
        Button button = (Button) _$_findCachedViewById(R.id.button_termsAndCondition);
        Intrinsics.checkNotNullExpressionValue(button, "button_termsAndCondition");
        CollectionDisplayModel collectionDisplayModel2 = this.collection;
        if (collectionDisplayModel2 != null) {
            z11 = collectionDisplayModel2.getHasTerms();
        } else {
            z11 = false;
        }
        ViewExtentionsKt.show$default(button, z11, 0, 2, (Object) null);
        int i14 = R.id.mainToolbar;
        ((Toolbar) _$_findCachedViewById(i14)).setNavigationIcon(com.talabat.talabatcommon.R.drawable.ic_m_back_black);
        ((Toolbar) _$_findCachedViewById(i14)).setNavigationOnClickListener(new a(this));
        int i15 = R.id.cuisineBtn;
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(i15);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "cuisineBtn");
        CollectionDisplayModel collectionDisplayModel3 = this.collection;
        boolean z13 = true;
        if (collectionDisplayModel3 == null || !collectionDisplayModel3.isCuisine()) {
            z12 = false;
        } else {
            z12 = true;
        }
        ViewExtentionsKt.show$default(linearLayout, !z12, 0, 2, (Object) null);
        int i16 = R.id.collapsingToolbar;
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) _$_findCachedViewById(i16);
        CollectionDisplayModel collectionDisplayModel4 = this.collection;
        if (!(collectionDisplayModel4 == null || (name2 = collectionDisplayModel4.getName()) == null)) {
            str4 = name2;
        }
        collapsingToolbarLayout.setTitle(str4);
        Resources resources = getResources();
        int i17 = com.designsystem.marshmallow.R.color.ds_secondary_10;
        ((CollapsingToolbarLayout) _$_findCachedViewById(i16)).setContentScrimColor(resources.getColor(i17));
        FragmentActivity activity = getActivity();
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
        }
        if (window != null) {
            window.setStatusBarColor(getResources().getColor(i17));
        }
        ((AppBarLayout) _$_findCachedViewById(R.id.appbarLayout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new CollectionsFragment$onActivityCreated$2(this));
        TextView textView = (TextView) _$_findCachedViewById(R.id.descriptionTextView);
        CollectionDisplayModel collectionDisplayModel5 = this.collection;
        if (collectionDisplayModel5 != null) {
            str3 = collectionDisplayModel5.getDescription();
        } else {
            str3 = null;
        }
        textView.setText(str3);
        this.viewModel = (CollectionsViewModel) ViewModelProviders.of((Fragment) this, (ViewModelProvider.Factory) new TalabatViewModelFactory()).get(CollectionsViewModel.class);
        int i18 = R.id.collectionRecycler;
        ((RecyclerView) _$_findCachedViewById(i18)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        VendorsListAdapter mVendorsListAdapter = getMVendorsListAdapter();
        CollectionDisplayModel collectionDisplayModel6 = this.collection;
        if (collectionDisplayModel6 != null) {
            z13 = collectionDisplayModel6.getShowCardView();
        }
        mVendorsListAdapter.setViewUiType(z13);
        ((RecyclerView) _$_findCachedViewById(i18)).setAdapter(getMVendorsListAdapter());
        getMVendorsListAdapter().setVednorClickListener(this);
        loadVendorList(false);
        CollectionsViewModel collectionsViewModel2 = this.viewModel;
        if (collectionsViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            collectionsViewModel2 = null;
        }
        collectionsViewModel2.getVendorsList().observe(this, new b(this));
        CollectionsViewModel collectionsViewModel3 = this.viewModel;
        if (collectionsViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            collectionsViewModel3 = null;
        }
        collectionsViewModel3.getShowFilterBubble().observe(this, new c(this));
        CollectionsViewModel collectionsViewModel4 = this.viewModel;
        if (collectionsViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            collectionsViewModel = collectionsViewModel4;
        }
        collectionsViewModel.getShowCuisineBubble().observe(this, new d(this));
        ((LinearLayout) _$_findCachedViewById(R.id.filterBtn)).setOnClickListener(new e(this));
        ((LinearLayout) _$_findCachedViewById(i15)).setOnClickListener(new f(this));
        ((LinearLayout) _$_findCachedViewById(R.id.searchBtn)).setOnClickListener(new g(this));
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        int i13;
        Bundle extras;
        ArrayList<Integer> arrayList;
        int i14;
        Bundle extras2;
        Bundle extras3;
        super.onActivityResult(i11, i12, intent);
        CollectionsViewModel collectionsViewModel = null;
        if (i11 == 100 && i12 == -1) {
            if (intent == null || (extras3 = intent.getExtras()) == null) {
                arrayList = null;
            } else {
                arrayList = extras3.getIntegerArrayList("selectedFilters");
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (intent == null || (extras2 = intent.getExtras()) == null) {
                i14 = SortTypes.RECOMMENDATION.ordinal();
            } else {
                i14 = extras2.getInt("selectedSorts");
            }
            CollectionsViewModel collectionsViewModel2 = this.viewModel;
            if (collectionsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                collectionsViewModel2 = null;
            }
            collectionsViewModel2.setAppliedFilter(arrayList);
            CollectionsViewModel collectionsViewModel3 = this.viewModel;
            if (collectionsViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                collectionsViewModel = collectionsViewModel3;
            }
            collectionsViewModel.setAppliedSort(i14);
            loadVendorList(false);
        } else if (i11 == 200 && i12 == -1) {
            if (intent == null || (extras = intent.getExtras()) == null) {
                i13 = 0;
            } else {
                i13 = extras.getInt("selectedCuisineId");
            }
            CollectionsViewModel collectionsViewModel4 = this.viewModel;
            if (collectionsViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                collectionsViewModel = collectionsViewModel4;
            }
            collectionsViewModel.setAppliedCuisine(i13);
            loadVendorList(false);
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "CollectionsFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CollectionsFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_collections, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…ctions, container, false)");
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
        CollectionsViewModel collectionsViewModel = this.viewModel;
        if (collectionsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            collectionsViewModel = null;
        }
        companion.setGlobalRestaurantModel(collectionsViewModel.getVendorById(vendorDisplayModel.getId()));
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, vendorDisplayModel.getBranchId(), vendorDisplayModel.getVerticalType(), vendorDisplayModel.isGrlEnabled(), vendorDisplayModel.isDarkStore(), false, false, (String) null, (Bundle) null, 224, (Object) null));
        }
    }
}
