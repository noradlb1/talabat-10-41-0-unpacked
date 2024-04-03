package com.talabat.sdsquad.ui.vendorslist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.material.appbar.MaterialToolbar;
import com.integration.IntegrationGlobalDataModel;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.core.TalabatViewModelFactory;
import com.talabat.sdsquad.data.vendorslist.response.SortTypes;
import com.talabat.sdsquad.extentions.ViewExtentionsKt;
import com.talabat.sdsquad.ui.collections.CollectionsActivity;
import com.talabat.sdsquad.ui.cuisines.CuisinesActivity;
import com.talabat.sdsquad.ui.customviews.LoadingView;
import com.talabat.sdsquad.ui.filters.FiltersActivity;
import com.talabat.sdsquad.ui.restaurantssearch.VendorSearchActivity;
import com.talabat.sdsquad.ui.vendorslist.adapters.VendorsListAdapter;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.CollectionCellViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.ToggleHeaderViewHolder;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.VendorViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorDisplayModel;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.Ad;
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
import nu.a;
import nu.b;
import nu.c;
import nu.d;
import nu.e;
import nu.f;
import nu.g;
import nu.h;
import nu.i;
import nu.j;
import nu.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00011B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/VendorsListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/ToggleHeaderViewHolder$OnHeaderToggleClickListener;", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/CollectionCellViewHolder$OnCollectionClicked;", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/viewholders/VendorViewHolder$VendorClickListener;", "()V", "areaId", "", "areaName", "", "cityId", "countryId", "latitude", "longitude", "mVendorsListAdapter", "Lcom/talabat/sdsquad/ui/vendorslist/adapters/VendorsListAdapter;", "getMVendorsListAdapter", "()Lcom/talabat/sdsquad/ui/vendorslist/adapters/VendorsListAdapter;", "mVendorsListAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/talabat/sdsquad/ui/vendorslist/VendorsListViewModel;", "cardViewClicked", "", "collectionClicked", "clickedCollection", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "listViewClicked", "loadVendorList", "update", "", "observeInLineAds", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "vendorClicked", "vendor", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment extends Fragment implements ToggleHeaderViewHolder.OnHeaderToggleClickListener, CollectionCellViewHolder.OnCollectionClicked, VendorViewHolder.VendorClickListener, TraceFieldInterface {
    @NotNull
    private static final String ARG_AREA_ID = "areaId";
    @NotNull
    private static final String ARG_AREA_NAME = "areaName";
    @NotNull
    private static final String ARG_CITY_ID = "cityId";
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
    @NotNull
    private String areaName = "";
    private int cityId;
    private int countryId;
    @NotNull
    private String latitude = "";
    @NotNull
    private String longitude = "";
    @NotNull
    private final Lazy mVendorsListAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, VendorsListFragment$mVendorsListAdapter$2.INSTANCE);
    private VendorsListViewModel viewModel;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/VendorsListFragment$Companion;", "", "()V", "ARG_AREA_ID", "", "ARG_AREA_NAME", "ARG_CITY_ID", "ARG_COUNTRY_ID", "ARG_LATITUDE", "ARG_LONGITUDE", "REQUEST_CODE_CUISINE", "", "REQUEST_CODE_FILTERS", "newInstance", "Lcom/talabat/sdsquad/ui/vendorslist/VendorsListFragment;", "latitude", "longitude", "areaId", "cityId", "countryId", "areaName", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VendorsListFragment newInstance(@Nullable String str, @Nullable String str2, int i11, int i12, int i13, @Nullable String str3) {
            VendorsListFragment vendorsListFragment = new VendorsListFragment();
            Bundle bundle = new Bundle();
            if (str == null) {
                str = "";
            }
            bundle.putString("latitude", str);
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString("longitude", str2);
            bundle.putInt("areaId", i11);
            bundle.putInt("cityId", i12);
            bundle.putInt("countryId", i13);
            if (str3 == null) {
                str3 = "";
            }
            bundle.putString("areaName", str3);
            vendorsListFragment.setArguments(bundle);
            return vendorsListFragment;
        }
    }

    private final VendorsListAdapter getMVendorsListAdapter() {
        return (VendorsListAdapter) this.mVendorsListAdapter$delegate.getValue();
    }

    private final void loadVendorList(boolean z11) {
        VendorsListViewModel vendorsListViewModel = this.viewModel;
        if (vendorsListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel = null;
        }
        vendorsListViewModel.getVendors(z11, this.latitude, this.longitude, this.areaId, this.cityId, this.countryId);
    }

    private final void observeInLineAds() {
        VendorsListViewModel vendorsListViewModel = this.viewModel;
        if (vendorsListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel = null;
        }
        vendorsListViewModel.getInLineAdsResponse().observe(this, new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeInLineAds$lambda-11  reason: not valid java name */
    public static final void m10860observeInLineAds$lambda11(VendorsListFragment vendorsListFragment, List list) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "adList");
        for (Ad ad2 : CollectionsKt___CollectionsKt.toMutableList(list)) {
            FragmentActivity activity = vendorsListFragment.getActivity();
            String adUnit = ad2.getAdUnit();
            new AdLoader.Builder(activity, "/160416261/" + adUnit).forCustomTemplateAd("11765624", new k(vendorsListFragment, ad2), new b()).withAdListener(new VendorsListFragment$observeInLineAds$1$adLoader$3()).withNativeAdOptions(new NativeAdOptions.Builder().build()).build().loadAd(new AdManagerAdRequest.Builder().addCustomTargeting("area", "9").build());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeInLineAds$lambda-11$lambda-10  reason: not valid java name */
    public static final void m10861observeInLineAds$lambda11$lambda10(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
    }

    /* access modifiers changed from: private */
    /* renamed from: observeInLineAds$lambda-11$lambda-9  reason: not valid java name */
    public static final void m10862observeInLineAds$lambda11$lambda9(VendorsListFragment vendorsListFragment, Ad ad2, NativeCustomTemplateAd nativeCustomTemplateAd) {
        int i11;
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        Intrinsics.checkNotNullParameter(ad2, "$ad");
        String obj = nativeCustomTemplateAd.getText("link").toString();
        String obj2 = nativeCustomTemplateAd.getText("imageurl").toString();
        VendorsListViewModel vendorsListViewModel = vendorsListFragment.viewModel;
        if (vendorsListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel = null;
        }
        Integer position = ad2.getPosition();
        if (position != null) {
            i11 = position.intValue();
        } else {
            i11 = 0;
        }
        vendorsListViewModel.insertInlineAd(obj, obj2, i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-0  reason: not valid java name */
    public static final void m10863onActivityCreated$lambda0(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        FragmentActivity activity = vendorsListFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1  reason: not valid java name */
    public static final void m10864onActivityCreated$lambda1(VendorsListFragment vendorsListFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        int i11 = R.id.loadingView;
        ((LoadingView) vendorsListFragment._$_findCachedViewById(i11)).start();
        LoadingView loadingView = (LoadingView) vendorsListFragment._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        ViewExtentionsKt.show$default(loadingView, true, 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-2  reason: not valid java name */
    public static final void m10865onActivityCreated$lambda2(VendorsListFragment vendorsListFragment, List list) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        int i11 = R.id.loadingView;
        ((LoadingView) vendorsListFragment._$_findCachedViewById(i11)).stop();
        LoadingView loadingView = (LoadingView) vendorsListFragment._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(loadingView, "loadingView");
        ViewExtentionsKt.show$default(loadingView, false, 0, 2, (Object) null);
        if (list.isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) vendorsListFragment._$_findCachedViewById(R.id.vendorsRecycler);
            Intrinsics.checkNotNullExpressionValue(recyclerView, "vendorsRecycler");
            ViewExtentionsKt.show$default(recyclerView, false, 0, 2, (Object) null);
            LinearLayout linearLayout = (LinearLayout) vendorsListFragment._$_findCachedViewById(R.id.noVendorsFoundContainer);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "noVendorsFoundContainer");
            ViewExtentionsKt.show$default(linearLayout, true, 0, 2, (Object) null);
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) vendorsListFragment._$_findCachedViewById(R.id.vendorsRecycler);
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "vendorsRecycler");
        ViewExtentionsKt.show$default(recyclerView2, true, 0, 2, (Object) null);
        LinearLayout linearLayout2 = (LinearLayout) vendorsListFragment._$_findCachedViewById(R.id.noVendorsFoundContainer);
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "noVendorsFoundContainer");
        ViewExtentionsKt.show$default(linearLayout2, false, 0, 2, (Object) null);
        VendorsListAdapter mVendorsListAdapter = vendorsListFragment.getMVendorsListAdapter();
        Intrinsics.checkNotNullExpressionValue(list, "it");
        mVendorsListAdapter.setVendorList(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-3  reason: not valid java name */
    public static final void m10866onActivityCreated$lambda3(VendorsListFragment vendorsListFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        FrameLayout frameLayout = (FrameLayout) vendorsListFragment._$_findCachedViewById(R.id.filterBubbleContainer);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "filterBubbleContainer");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        ViewExtentionsKt.show$default(frameLayout, bool.booleanValue(), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-4  reason: not valid java name */
    public static final void m10867onActivityCreated$lambda4(VendorsListFragment vendorsListFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        FrameLayout frameLayout = (FrameLayout) vendorsListFragment._$_findCachedViewById(R.id.cuisineBubbleContainer);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "cuisineBubbleContainer");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        ViewExtentionsKt.show$default(frameLayout, bool.booleanValue(), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-5  reason: not valid java name */
    public static final void m10868onActivityCreated$lambda5(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        FiltersActivity.Companion companion = FiltersActivity.Companion;
        VendorsListViewModel vendorsListViewModel = vendorsListFragment.viewModel;
        VendorsListViewModel vendorsListViewModel2 = null;
        if (vendorsListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel = null;
        }
        Integer valueOf = Integer.valueOf(vendorsListViewModel.getAppliedSort());
        VendorsListViewModel vendorsListViewModel3 = vendorsListFragment.viewModel;
        if (vendorsListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            vendorsListViewModel2 = vendorsListViewModel3;
        }
        companion.startForResult(vendorsListFragment, 100, valueOf, vendorsListViewModel2.getAppliedFilters());
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-6  reason: not valid java name */
    public static final void m10869onActivityCreated$lambda6(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        CuisinesActivity.Companion companion = CuisinesActivity.Companion;
        VendorsListViewModel vendorsListViewModel = vendorsListFragment.viewModel;
        if (vendorsListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel = null;
        }
        companion.startForResult(vendorsListFragment, 200, vendorsListViewModel.getAppliedCuisine());
    }

    /* access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-8  reason: not valid java name */
    public static final void m10870onActivityCreated$lambda8(VendorsListFragment vendorsListFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorsListFragment, "this$0");
        Context context = vendorsListFragment.getContext();
        if (context != null) {
            VendorSearchActivity.Companion.start$default(VendorSearchActivity.Companion, context, vendorsListFragment.latitude, vendorsListFragment.longitude, vendorsListFragment.areaId, vendorsListFragment.cityId, vendorsListFragment.countryId, 0, 64, (Object) null);
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

    public void cardViewClicked() {
        getMVendorsListAdapter().setViewUiType(false);
    }

    public void collectionClicked(@NotNull CollectionDisplayModel collectionDisplayModel) {
        Intrinsics.checkNotNullParameter(collectionDisplayModel, "clickedCollection");
        Context context = getContext();
        if (context != null) {
            CollectionsActivity.Companion.start(context, this.latitude, this.longitude, this.areaId, this.cityId, this.countryId, collectionDisplayModel);
        }
    }

    public void listViewClicked() {
        getMVendorsListAdapter().setViewUiType(true);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        String str;
        String str2;
        int i11;
        int i12;
        int i13;
        String str3;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        VendorsListViewModel vendorsListViewModel = null;
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
            str3 = arguments6.getString("areaName");
        } else {
            str3 = null;
        }
        if (str3 != null) {
            str4 = str3;
        }
        this.areaName = str4;
        ((TextView) _$_findCachedViewById(R.id.vendorAreaName)).setText(this.areaName);
        ((MaterialToolbar) _$_findCachedViewById(R.id.toolbar)).setNavigationOnClickListener(new c(this));
        this.viewModel = (VendorsListViewModel) ViewModelProviders.of((Fragment) this, (ViewModelProvider.Factory) new TalabatViewModelFactory()).get(VendorsListViewModel.class);
        int i14 = R.id.vendorsRecycler;
        ((RecyclerView) _$_findCachedViewById(i14)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        getMVendorsListAdapter().setToggleListener(this);
        getMVendorsListAdapter().setCollectionListener(this);
        getMVendorsListAdapter().setVednorClickListener(this);
        ((RecyclerView) _$_findCachedViewById(i14)).setAdapter(getMVendorsListAdapter());
        loadVendorList(true);
        VendorsListViewModel vendorsListViewModel2 = this.viewModel;
        if (vendorsListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel2 = null;
        }
        vendorsListViewModel2.getShowLoading().observe(this, new d(this));
        VendorsListViewModel vendorsListViewModel3 = this.viewModel;
        if (vendorsListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel3 = null;
        }
        vendorsListViewModel3.getVendorsList().observe(this, new e(this));
        VendorsListViewModel vendorsListViewModel4 = this.viewModel;
        if (vendorsListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel4 = null;
        }
        vendorsListViewModel4.getShowFilterBubble().observe(this, new f(this));
        VendorsListViewModel vendorsListViewModel5 = this.viewModel;
        if (vendorsListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            vendorsListViewModel = vendorsListViewModel5;
        }
        vendorsListViewModel.getShowCuisineBubble().observe(this, new g(this));
        ((LinearLayout) _$_findCachedViewById(R.id.filterBtn)).setOnClickListener(new h(this));
        ((LinearLayout) _$_findCachedViewById(R.id.cuisineBtn)).setOnClickListener(new i(this));
        ((LinearLayout) _$_findCachedViewById(R.id.searchBtn)).setOnClickListener(new j(this));
        observeInLineAds();
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        int i13;
        Bundle extras;
        ArrayList<Integer> arrayList;
        int i14;
        Bundle extras2;
        Bundle extras3;
        super.onActivityResult(i11, i12, intent);
        VendorsListViewModel vendorsListViewModel = null;
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
            VendorsListViewModel vendorsListViewModel2 = this.viewModel;
            if (vendorsListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                vendorsListViewModel2 = null;
            }
            vendorsListViewModel2.setAppliedFilter(arrayList);
            VendorsListViewModel vendorsListViewModel3 = this.viewModel;
            if (vendorsListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                vendorsListViewModel = vendorsListViewModel3;
            }
            vendorsListViewModel.setAppliedSort(i14);
            loadVendorList(false);
        } else if (i11 == 200 && i12 == -1) {
            if (intent == null || (extras = intent.getExtras()) == null) {
                i13 = 0;
            } else {
                i13 = extras.getInt("selectedCuisineId");
            }
            VendorsListViewModel vendorsListViewModel4 = this.viewModel;
            if (vendorsListViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                vendorsListViewModel = vendorsListViewModel4;
            }
            vendorsListViewModel.setAppliedCuisine(i13);
            loadVendorList(false);
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "VendorsListFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VendorsListFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_vendors_list, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…s_list, container, false)");
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
        VendorsListViewModel vendorsListViewModel = this.viewModel;
        if (vendorsListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            vendorsListViewModel = null;
        }
        companion.setGlobalRestaurantModel(vendorsListViewModel.getVendorById(vendorDisplayModel.getId()));
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, vendorDisplayModel.getBranchId(), vendorDisplayModel.getVerticalType(), vendorDisplayModel.isGrlEnabled(), vendorDisplayModel.isDarkStore(), false, false, (String) null, (Bundle) null, 224, (Object) null));
        }
    }
}
