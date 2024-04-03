package com.talabat.busypopup;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.compose.DialogNavigator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.talabat.R;
import com.talabat.adapters.restaurantslist.OnRestaurantClick;
import com.talabat.adapters.restaurantslist.RestaurantsListAdapterRefactor;
import com.talabat.busypopup.di.DaggerBusyPopupBottomSheetComponent;
import com.talabat.busypopup.viewModel.BusyPopupVMBuilder;
import com.talabat.busypopup.viewModel.BusyPopupViewModel;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.BusyPopupListingItemDecoration;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsFilteredByCuisine;
import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.RequestVendorsUseCase;
import com.talabat.restaurants.v2.domain.vendors.ShouldUsePolygonApiUseCase;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcore.TalabatBaseMvvmBottomSheetDialogFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pf.a;
import pf.b;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 q2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001qB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010<\u001a\u00020=H\u0002J\u0012\u0010>\u001a\u00020=2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020=H\u0002J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020CH\u0016J\b\u0010D\u001a\u00020=H\u0002J\b\u0010E\u001a\u00020=H\u0002J\b\u0010F\u001a\u00020=H\u0016J\u0010\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020=2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J&\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010S\u001a\u00020=2\u0006\u0010T\u001a\u00020UH\u0016J\u001a\u0010V\u001a\u00020=2\b\u0010W\u001a\u0004\u0018\u00010\u001f2\u0006\u0010X\u001a\u00020\rH\u0016J\u001a\u0010Y\u001a\u00020=2\b\u0010Z\u001a\u0004\u0018\u00010\u001f2\u0006\u0010X\u001a\u00020\rH\u0016J\u0012\u0010Y\u001a\u00020=2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\u001a\u0010]\u001a\u00020=2\b\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010X\u001a\u00020\rH\u0016J\u001a\u0010`\u001a\u00020=2\u0006\u0010a\u001a\u00020N2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010b\u001a\u00020=2\u0006\u0010a\u001a\u00020NH\u0002J\u000e\u0010c\u001a\u00020=2\u0006\u0010a\u001a\u00020NJ\u0018\u0010d\u001a\u00020=2\u0006\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010\u001fJ\b\u0010h\u001a\u00020=H\u0002J\u0017\u0010i\u001a\u00020=2\b\u0010j\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010kJ\u0018\u0010l\u001a\u00020=2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nH\u0002J\b\u0010p\u001a\u00020\u0002H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001a\u0010-\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001a\u00100\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u0010#R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011¨\u0006r"}, d2 = {"Lcom/talabat/busypopup/BusyPopupBottomSheet;", "Lcom/talabat/talabatcore/TalabatBaseMvvmBottomSheetDialogFragment;", "Lcom/talabat/busypopup/viewModel/BusyPopupViewModel;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "Lcom/talabat/adapters/restaurantslist/OnRestaurantClick;", "()V", "canCallShopList", "", "getCanCallShopList", "()Z", "setCanCallShopList", "(Z)V", "cuisineIdToFilter", "", "getCuisineIdToFilter", "()I", "setCuisineIdToFilter", "(I)V", "interactionListener", "Lcom/talabat/busypopup/BusyPopupDialogFragmentCallbacks;", "getInteractionListener", "()Lcom/talabat/busypopup/BusyPopupDialogFragmentCallbacks;", "setInteractionListener", "(Lcom/talabat/busypopup/BusyPopupDialogFragmentCallbacks;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mainContent", "", "getMainContent", "()Ljava/lang/String;", "setMainContent", "(Ljava/lang/String;)V", "popupMainButtonText", "getPopupMainButtonText", "setPopupMainButtonText", "restaurantListAdapter", "Lcom/talabat/adapters/restaurantslist/RestaurantsListAdapterRefactor;", "getRestaurantListAdapter", "()Lcom/talabat/adapters/restaurantslist/RestaurantsListAdapterRefactor;", "restaurantListAdapter$delegate", "Lkotlin/Lazy;", "resultCount", "getResultCount", "setResultCount", "secondaryContent", "getSecondaryContent", "setSecondaryContent", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setTalabatFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "verticalType", "getVerticalType", "setVerticalType", "closeBottomSheetFromDialog", "", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getShopList", "getViewModelClass", "Ljava/lang/Class;", "hideLoading", "initRecyclerView", "observatory", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onInlineAdsAppeared", "adsLink", "position", "onInlineAdsClick", "adLink", "ad", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "onRestaurantClick", "restaurant", "Ldatamodels/Restaurant;", "onViewCreated", "view", "setBottomSheetHeight", "setup", "showDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "showLoading", "showNoResult", "noResult", "(Ljava/lang/Boolean;)V", "showVendors", "list", "", "Ldatamodels/RestaurantListItemModel;", "viewModelBuilder", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BusyPopupBottomSheet extends TalabatBaseMvvmBottomSheetDialogFragment<BusyPopupViewModel> implements AnimationHelper, OnRestaurantClick {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_CALL_SHOP_LIST = "canCallShopList";
    @NotNull
    public static final String EXTRA_CUISINE_ID_TO_FILTER = "cusisineIdToFilter";
    @NotNull
    public static final String EXTRA_MAIN_BUTTON_CONTENT = "popupMainButtonText";
    @NotNull
    public static final String EXTRA_MAIN_CONTENT = "mainContent";
    @NotNull
    public static final String EXTRA_RESULT_COUNT = "resultCount";
    @NotNull
    public static final String EXTRA_SECONDARY_CONTENT = "secondaryContent";
    @NotNull
    public static final String EXTRA_VERTICAL_TYPE = "verticalType";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean canCallShopList = true;
    private int cuisineIdToFilter;
    @Nullable
    private BusyPopupDialogFragmentCallbacks interactionListener;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private String mainContent = "";
    @NotNull
    private String popupMainButtonText = "";
    @NotNull
    private final Lazy restaurantListAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new BusyPopupBottomSheet$restaurantListAdapter$2(this));
    private int resultCount;
    @NotNull
    private String secondaryContent = "";
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;
    private int verticalType;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JK\u0010\u000b\u001a\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/busypopup/BusyPopupBottomSheet$Companion;", "", "()V", "EXTRA_CALL_SHOP_LIST", "", "EXTRA_CUISINE_ID_TO_FILTER", "EXTRA_MAIN_BUTTON_CONTENT", "EXTRA_MAIN_CONTENT", "EXTRA_RESULT_COUNT", "EXTRA_SECONDARY_CONTENT", "EXTRA_VERTICAL_TYPE", "newInstance", "Lcom/talabat/busypopup/BusyPopupBottomSheet;", "Lorg/jetbrains/annotations/NotNull;", "cuisineIdToFilter", "", "verticalType", "callShopList", "", "resultCount", "mainContent", "secondaryContent", "popupMainButtonText", "interactionListener", "Lcom/talabat/busypopup/BusyPopupDialogFragmentCallbacks;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BusyPopupBottomSheet newInstance(int i11, int i12, boolean z11, int i13, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull BusyPopupDialogFragmentCallbacks busyPopupDialogFragmentCallbacks) {
            Intrinsics.checkNotNullParameter(str, BusyPopupBottomSheet.EXTRA_MAIN_CONTENT);
            Intrinsics.checkNotNullParameter(str2, BusyPopupBottomSheet.EXTRA_SECONDARY_CONTENT);
            Intrinsics.checkNotNullParameter(str3, BusyPopupBottomSheet.EXTRA_MAIN_BUTTON_CONTENT);
            Intrinsics.checkNotNullParameter(busyPopupDialogFragmentCallbacks, "interactionListener");
            BusyPopupBottomSheet busyPopupBottomSheet = new BusyPopupBottomSheet();
            busyPopupBottomSheet.setInteractionListener(busyPopupDialogFragmentCallbacks);
            Bundle bundle = new Bundle();
            bundle.putInt(BusyPopupBottomSheet.EXTRA_CUISINE_ID_TO_FILTER, i11);
            bundle.putInt("verticalType", i12);
            bundle.putBoolean(BusyPopupBottomSheet.EXTRA_CALL_SHOP_LIST, z11);
            bundle.putInt(BusyPopupBottomSheet.EXTRA_RESULT_COUNT, i13);
            bundle.putString(BusyPopupBottomSheet.EXTRA_MAIN_CONTENT, str);
            bundle.putString(BusyPopupBottomSheet.EXTRA_SECONDARY_CONTENT, str2);
            bundle.putString(BusyPopupBottomSheet.EXTRA_MAIN_BUTTON_CONTENT, str3);
            busyPopupBottomSheet.setArguments(bundle);
            return busyPopupBottomSheet;
        }
    }

    private final void closeBottomSheetFromDialog() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            int i11 = R.id.busy_popup_bottom_sheet;
            RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(i11);
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "it.busy_popup_bottom_sheet");
            adjustViewHeight(relativeLayout, ((RelativeLayout) dialog.findViewById(i11)).getHeight(), 0, AnimationSpeed.NORMAL);
            dialog.dismiss();
        }
    }

    private final RestaurantsListAdapterRefactor getRestaurantListAdapter() {
        return (RestaurantsListAdapterRefactor) this.restaurantListAdapter$delegate.getValue();
    }

    private final void getShopList() {
        showLoading();
        ((BusyPopupViewModel) getViewModel()).getRestaurantListWithCuisine(this.cuisineIdToFilter, this.verticalType, this.resultCount);
    }

    private final void hideLoading() {
        ((RelativeLayout) _$_findCachedViewById(R.id.progress_bar_view)).setVisibility(8);
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.restaurant_list);
        recyclerView.setBackgroundColor(recyclerView.getResources().getColor(R.color.white));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new BusyPopupListingItemDecoration(recyclerView.getResources()));
        recyclerView.setAdapter(getRestaurantListAdapter());
        RestaurantsListAdapterRefactor restaurantListAdapter = getRestaurantListAdapter();
        restaurantListAdapter.setClickListener(this);
        restaurantListAdapter.setIsTgoStyle(true);
    }

    private final void setBottomSheetHeight(View view) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new a(view));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setBottomSheetHeight$lambda-5  reason: not valid java name */
    public static final void m9533setBottomSheetHeight$lambda5(View view, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(view, "$view");
        if (dialogInterface != null) {
            FrameLayout frameLayout = (FrameLayout) ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
            if (frameLayout != null) {
                BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(from, "from(bottomSheet)");
                from.setPeekHeight(((ViewGroup) view.findViewById(R.id.busy_popup_bottom_sheet)).getHeight());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-1  reason: not valid java name */
    public static final void m9534setup$lambda1(BusyPopupBottomSheet busyPopupBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(busyPopupBottomSheet, "this$0");
        BusyPopupDialogFragmentCallbacks busyPopupDialogFragmentCallbacks = busyPopupBottomSheet.interactionListener;
        if (busyPopupDialogFragmentCallbacks != null) {
            busyPopupDialogFragmentCallbacks.viewAllRestaurantsClicked();
        }
        busyPopupBottomSheet.closeBottomSheetFromDialog();
    }

    private final void showLoading() {
        ((RelativeLayout) _$_findCachedViewById(R.id.progress_bar_view)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void showNoResult(Boolean bool) {
        hideLoading();
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            ((LinearLayout) _$_findCachedViewById(R.id.no_restaurants_view)).setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.list_container)).setVisibility(8);
            return;
        }
        int i11 = R.id.list_container;
        if (((LinearLayout) _$_findCachedViewById(i11)) != null) {
            ((LinearLayout) _$_findCachedViewById(R.id.no_restaurants_view)).setVisibility(8);
            ((LinearLayout) _$_findCachedViewById(i11)).setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void showVendors(List<? extends RestaurantListItemModel> list) {
        hideLoading();
        if (list != null) {
            getRestaurantListAdapter().setRestaurantsListModels(list);
        }
        ((RecyclerView) _$_findCachedViewById(R.id.restaurant_list)).setVisibility(0);
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

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void failureHere(@Nullable Failure failure) {
    }

    public final boolean getCanCallShopList() {
        return this.canCallShopList;
    }

    public final int getCuisineIdToFilter() {
        return this.cuisineIdToFilter;
    }

    @Nullable
    public final BusyPopupDialogFragmentCallbacks getInteractionListener() {
        return this.interactionListener;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @NotNull
    public final String getMainContent() {
        return this.mainContent;
    }

    @NotNull
    public final String getPopupMainButtonText() {
        return this.popupMainButtonText;
    }

    public final int getResultCount() {
        return this.resultCount;
    }

    @NotNull
    public final String getSecondaryContent() {
        return this.secondaryContent;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatFeatureFlag");
        return null;
    }

    public final int getVerticalType() {
        return this.verticalType;
    }

    @NotNull
    public Class<BusyPopupViewModel> getViewModelClass() {
        return BusyPopupViewModel.class;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((BusyPopupViewModel) getViewModel()).getShowNoResult(), new BusyPopupBottomSheet$observatory$1(this));
        LifecycleKt.observe(this, ((BusyPopupViewModel) getViewModel()).getVendorList(), new BusyPopupBottomSheet$observatory$2(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        DaggerBusyPopupBottomSheetComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.VoucherBottomSheetDialogTheme);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.busy_popup_bottomsheet, viewGroup, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        BusyPopupDialogFragmentCallbacks busyPopupDialogFragmentCallbacks = this.interactionListener;
        if (busyPopupDialogFragmentCallbacks != null) {
            busyPopupDialogFragmentCallbacks.onBusyPopupClosed();
        }
        super.onDismiss(dialogInterface);
    }

    public void onInlineAdsAppeared(@Nullable String str, int i11) {
    }

    public void onInlineAdsClick(@Nullable String str, int i11) {
    }

    public void onInlineAdsClick(@Nullable AdsWrapper adsWrapper) {
    }

    public void onRestaurantClick(@Nullable Restaurant restaurant, int i11) {
        BusyPopupDialogFragmentCallbacks busyPopupDialogFragmentCallbacks = this.interactionListener;
        if (busyPopupDialogFragmentCallbacks != null) {
            busyPopupDialogFragmentCallbacks.onShopClicked(restaurant, i11);
        }
        closeBottomSheetFromDialog();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.cuisineIdToFilter = arguments.getInt(EXTRA_CUISINE_ID_TO_FILTER, 0);
            this.verticalType = arguments.getInt("verticalType", 0);
            this.canCallShopList = arguments.getBoolean(EXTRA_CALL_SHOP_LIST, false);
            this.resultCount = arguments.getInt(EXTRA_RESULT_COUNT, 5);
            String string = arguments.getString(EXTRA_MAIN_CONTENT, "");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(EXTRA_MAIN_CONTENT, \"\")");
            this.mainContent = string;
            String string2 = arguments.getString(EXTRA_SECONDARY_CONTENT, "");
            Intrinsics.checkNotNullExpressionValue(string2, "it.getString(EXTRA_SECONDARY_CONTENT, \"\")");
            this.secondaryContent = string2;
            String string3 = arguments.getString(EXTRA_MAIN_BUTTON_CONTENT, "");
            Intrinsics.checkNotNullExpressionValue(string3, "it.getString(EXTRA_MAIN_BUTTON_CONTENT, \"\")");
            this.popupMainButtonText = string3;
        }
        setup(view);
        getShopList();
    }

    public final void setCanCallShopList(boolean z11) {
        this.canCallShopList = z11;
    }

    public final void setCuisineIdToFilter(int i11) {
        this.cuisineIdToFilter = i11;
    }

    public final void setInteractionListener(@Nullable BusyPopupDialogFragmentCallbacks busyPopupDialogFragmentCallbacks) {
        this.interactionListener = busyPopupDialogFragmentCallbacks;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setMainContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainContent = str;
    }

    public final void setPopupMainButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.popupMainButtonText = str;
    }

    public final void setResultCount(int i11) {
        this.resultCount = i11;
    }

    public final void setSecondaryContent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondaryContent = str;
    }

    public final void setTalabatFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public final void setVerticalType(int i11) {
        this.verticalType = i11;
    }

    public final void setup(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        setBottomSheetHeight(view);
        initRecyclerView();
        ((TextView) _$_findCachedViewById(R.id.main_content)).setText(this.mainContent);
        ((TextView) _$_findCachedViewById(R.id.secondary_content)).setText(this.secondaryContent);
        int i11 = R.id.view_all_restaurants;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setText(this.popupMainButtonText);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setOnClickListener(new b(this));
    }

    public final void showDialog(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (!isVisible()) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag).commitNow();
            }
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitNow();
        }
    }

    @NotNull
    public BusyPopupViewModel viewModelBuilder() {
        return BusyPopupVMBuilder.INSTANCE.getBusyPopupViewModel(getTalabatFeatureFlag(), new GetVendorsFilteredByCuisine(getTalabatFeatureFlag(), new GetVendorsUseCase(getTalabatFeatureFlag(), new RequestVendorsUseCase((Function6) null, (Function5) null, new ShouldUsePolygonApiUseCase(getLocationConfigurationRepository(), (Function0) null, 2, (DefaultConstructorMarker) null), 3, (DefaultConstructorMarker) null))));
    }
}
