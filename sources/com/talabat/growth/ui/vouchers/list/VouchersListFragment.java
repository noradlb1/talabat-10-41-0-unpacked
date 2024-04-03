package com.talabat.growth.ui.vouchers.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_empty_state_v2.DSEmptyState;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.ds_tabs.DSTabBar;
import com.designsystem.ds_tabs.DSTabItemModel;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.referafriend.presentation.ui.PromoCodeBannerView;
import com.talabat.growth.R;
import com.talabat.growth.ui.vouchers.list.di.DaggerVouchersListFragmentComponent;
import com.talabat.growth.ui.vouchers.list.model.VoucherListDisplayModel;
import com.talabat.growth.ui.vouchers.list.viewModel.VouchersListViewModel;
import com.talabat.growth.ui.vouchers.list.viewModel.VouchersListViewModelBuilder;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersViewUserErrorMapperKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.ServerError;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import com.talabat.talabatnavigation.growthSquad.VouchersNavigationActions;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001$\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001LB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u0005H\u0002J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0002J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u001aH\u0002J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020*H\u0016J\b\u0010+\u001a\u00020\rH\u0016J\b\u0010,\u001a\u00020\u001aH\u0002J\u0010\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u001aH\u0016J\"\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u001aH\u0016J\u001a\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u001aH\u0002J\b\u0010@\u001a\u00020\u001aH\u0002J\u0012\u0010A\u001a\u00020\u001a2\b\u0010B\u001a\u0004\u0018\u00010/H\u0002J\u0017\u0010C\u001a\u00020\u001a2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010EJ\u0017\u0010F\u001a\u00020\u001a2\b\u0010G\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010EJ\u0012\u0010H\u001a\u00020\u001a2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\b\u0010K\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/VouchersListFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/growth/ui/vouchers/list/viewModel/VouchersListViewModel;", "()V", "calledFilterId", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "currentPage", "", "isLastPage", "", "isLoading", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "onVoucherItemClicked", "Lkotlin/Function1;", "Lcom/talabat/talabatcommon/views/vouchers/bottomSheetButton/model/VoucherItemDisplayModel;", "", "vouchersListAdapter", "Lcom/talabat/growth/ui/vouchers/list/VouchersListAdapter;", "callApiForFilter", "filterId", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getMoreItems", "getPaginationListener", "com/talabat/growth/ui/vouchers/list/VouchersListFragment$getPaginationListener$1", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)Lcom/talabat/growth/ui/vouchers/list/VouchersListFragment$getPaginationListener$1;", "getPointsListFromViewModel", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "loadUserVouchers", "navigateToVoucherDetails", "voucherId", "", "observatory", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onBackPressed", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setup", "setupVouchersTabs", "showToast", "message", "successRedeemPromoCode", "isSuccess", "(Ljava/lang/Boolean;)V", "successRedeemVoucherCode", "successToRedeemVoucher", "updateVoucherList", "voucherListDisplayModel", "Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModel;", "viewModelBuilder", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersListFragment extends BaseFragment {
    private static final int ACTIVE_VOUCHERS_TAB_ID = 1;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int EXPIRED_VOUCHERS_TAB_ID = 3;
    private static final int USED_VOUCHERS_TAB_ID = 2;
    @NotNull
    public static final String VOUCHER_LIST = "voucher_list";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private VouchersStatusFilter calledFilterId = VouchersStatusFilter.ALL;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    private int currentPage = 1;
    /* access modifiers changed from: private */
    public boolean isLastPage;
    /* access modifiers changed from: private */
    public boolean isLoading;
    @Inject
    public IObservabilityManager observabilityManager;
    @NotNull
    private final Function1<VoucherItemDisplayModel, Unit> onVoucherItemClicked = new VouchersListFragment$onVoucherItemClicked$1(this);
    private VouchersListAdapter vouchersListAdapter;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/VouchersListFragment$Companion;", "", "()V", "ACTIVE_VOUCHERS_TAB_ID", "", "EXPIRED_VOUCHERS_TAB_ID", "USED_VOUCHERS_TAB_ID", "VOUCHER_LIST", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void a(VouchersListFragment vouchersListFragment, VouchersStatusFilter vouchersStatusFilter, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            vouchersStatusFilter = VouchersStatusFilter.ALL;
        }
        vouchersListFragment.callApiForFilter(vouchersStatusFilter);
    }

    /* access modifiers changed from: private */
    public final void callApiForFilter(VouchersStatusFilter vouchersStatusFilter) {
        this.calledFilterId = vouchersStatusFilter;
        this.currentPage = 1;
        getPointsListFromViewModel();
    }

    /* access modifiers changed from: private */
    public final void getMoreItems() {
        this.currentPage++;
        getPointsListFromViewModel();
    }

    private final VouchersListFragment$getPaginationListener$1 getPaginationListener(LinearLayoutManager linearLayoutManager) {
        return new VouchersListFragment$getPaginationListener$1(linearLayoutManager, this);
    }

    private final void getPointsListFromViewModel() {
        showProgress();
        ((VouchersListViewModel) getViewModel()).getVoucherList(this.currentPage, 20, this.calledFilterId, getConfigurationLocalRepository().selectedCountry().getCountryId());
    }

    private final void loadUserVouchers() {
        String str;
        String str2;
        String str3;
        Boolean bool;
        Bundle arguments = getArguments();
        Unit unit = null;
        if (arguments != null) {
            str = arguments.getString("VOUCHER_DEEPLINK_CODE");
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("VOUCHER_DEEPLINK_MEDIA_SRC");
        } else {
            str2 = null;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str3 = arguments3.getString("VOUCHER_DEEPLINK_BRAND_ID");
        } else {
            str3 = null;
        }
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            bool = Boolean.valueOf(arguments4.getBoolean(VouchersNavigationActions.IS_OPEN_BOTTOM_SHEET));
        } else {
            bool = null;
        }
        LogManager.debug("code : " + str + " >>  src : " + str2 + "  brandId >> " + str3);
        if (str != null) {
            if (!(!StringsKt__StringsJVMKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                showProgress();
                ((VouchersListViewModel) getViewModel()).redeemVoucherCode(str, str3);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
                ((PromoCodeBannerView) _$_findCachedViewById(R.id.getACodeComponentView)).performClick();
            }
            callApiForFilter(VouchersStatusFilter.ACTIVE);
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToVoucherDetails(String str) {
        Navigator.Companion companion = Navigator.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Bundle bundle = new Bundle();
        bundle.putString(GrowthNavigatorActions.EXTRA_LOYALTY_VOUCHER_ID, str);
        Unit unit = Unit.INSTANCE;
        companion.navigate(requireContext, new NavigatorModel(GrowthNavigatorActions.OPEN_LOYALTY_VOUCHER_DETAILS_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
    }

    private final void setup() {
        String str;
        int i11 = R.id.vouchersListNavigationBar;
        ((DSNavigationBar) _$_findCachedViewById(i11)).setTitle(getString(com.talabat.localization.R.string.vouchers));
        ((DSNavigationBar) _$_findCachedViewById(i11)).setLeadingIconButton(new DSIconButtonModel(com.designsystem.marshmallow.R.drawable.ds_arrow_back, new VouchersListFragment$setup$1(this)));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.vouchersListRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        String str2 = null;
        VouchersListAdapter vouchersListAdapter2 = new VouchersListAdapter((List) null, this.onVoucherItemClicked, 1, (DefaultConstructorMarker) null);
        this.vouchersListAdapter = vouchersListAdapter2;
        recyclerView.setAdapter(vouchersListAdapter2);
        recyclerView.addOnScrollListener(getPaginationListener(linearLayoutManager));
        setupVouchersTabs();
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("VOUCHER_DEEPLINK_CODE");
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("VOUCHER_DEEPLINK_MEDIA_SRC");
        }
        LogManager.debug("code : " + str + " >>  src : " + str2);
    }

    private final void setupVouchersTabs() {
        int i11 = R.id.vouchersTabs;
        String string = getString(com.talabat.localization.R.string.vouchers_filter_active);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…g.vouchers_filter_active)");
        String string2 = getString(com.talabat.localization.R.string.vouchers_filter_used);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…ing.vouchers_filter_used)");
        String string3 = getString(com.talabat.localization.R.string.vouchers_filter_expired);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(com.talabat.lo….vouchers_filter_expired)");
        ((DSTabBar) _$_findCachedViewById(i11)).setTabs(CollectionsKt__CollectionsKt.listOf(new DSTabItemModel(1, string, (String) null, 4, (DefaultConstructorMarker) null), new DSTabItemModel(2, string2, (String) null, 4, (DefaultConstructorMarker) null), new DSTabItemModel(3, string3, (String) null, 4, (DefaultConstructorMarker) null)));
        ((DSTabBar) _$_findCachedViewById(i11)).setOnTabSelected(new VouchersListFragment$setupVouchersTabs$1(this));
        DSTabBar dSTabBar = (DSTabBar) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(dSTabBar, "vouchersTabs");
        DSTabBar.selectTab$default(dSTabBar, 0, false, 2, (Object) null);
    }

    private final void showToast(String str) {
        if (str != null) {
            Toast.makeText(requireContext(), str, 1).show();
        }
    }

    /* access modifiers changed from: private */
    public final void successRedeemPromoCode(Boolean bool) {
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            callApiForFilter(VouchersStatusFilter.ACTIVE);
        }
    }

    /* access modifiers changed from: private */
    public final void successRedeemVoucherCode(Boolean bool) {
        showToast(getString(com.talabat.localization.R.string.success_voucher_code_redemption_message));
        a(this, (VouchersStatusFilter) null, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateVoucherList(VoucherListDisplayModel voucherListDisplayModel) {
        if (voucherListDisplayModel != null) {
            boolean z11 = false;
            if (voucherListDisplayModel.getTotalCount() == 0) {
                ((DSEmptyState) _$_findCachedViewById(R.id.vouchersNoResultFoundLinearLayout)).setVisibility(0);
                ((RecyclerView) _$_findCachedViewById(R.id.vouchersListRecyclerView)).setVisibility(4);
            } else {
                ((DSEmptyState) _$_findCachedViewById(R.id.vouchersNoResultFoundLinearLayout)).setVisibility(8);
                ((RecyclerView) _$_findCachedViewById(R.id.vouchersListRecyclerView)).setVisibility(0);
                VouchersListAdapter vouchersListAdapter2 = null;
                if (this.isLoading) {
                    this.isLoading = false;
                    VouchersListAdapter vouchersListAdapter3 = this.vouchersListAdapter;
                    if (vouchersListAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vouchersListAdapter");
                    } else {
                        vouchersListAdapter2 = vouchersListAdapter3;
                    }
                    vouchersListAdapter2.addToPointHistoryItems(voucherListDisplayModel.getRecords());
                } else {
                    VouchersListAdapter vouchersListAdapter4 = this.vouchersListAdapter;
                    if (vouchersListAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vouchersListAdapter");
                    } else {
                        vouchersListAdapter2 = vouchersListAdapter4;
                    }
                    vouchersListAdapter2.updatePointHistory(voucherListDisplayModel.getRecords());
                }
                if (((double) this.currentPage) >= ((double) voucherListDisplayModel.getTotalCount()) / ((double) voucherListDisplayModel.getPageSize())) {
                    z11 = true;
                }
                this.isLastPage = z11;
            }
        }
        hideProgress();
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

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
        if (failure == null) {
            return;
        }
        if (failure instanceof VoucherFailures) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            showToast(ApplyVouchersViewUserErrorMapperKt.getUserErrorMessage((VoucherFailures) failure, requireContext));
            a(this, (VouchersStatusFilter) null, 1, (Object) null);
        } else if (failure instanceof ServerError) {
            showToast(((ServerError) failure).getMessage());
        }
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public Class<VouchersListViewModel> getViewModelClass() {
        return VouchersListViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_voucher_list;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((VouchersListViewModel) getViewModel()).getVoucherList(), new VouchersListFragment$observatory$1(this));
        LifecycleKt.observe(this, ((VouchersListViewModel) getViewModel()).getSuccessRedeemVoucher(), new VouchersListFragment$observatory$2(this));
        LifecycleKt.observe(this, ((VouchersListViewModel) getViewModel()).getSuccessRedeemPromo(), new VouchersListFragment$observatory$3(this));
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1) {
            ((VouchersListViewModel) getViewModel()).onSuccessResult(i11, intent);
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerVouchersListFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public void onBackPressed() {
        boolean z11;
        Bundle arguments = getArguments();
        if (arguments != null) {
            z11 = arguments.getBoolean(VouchersNavigationActions.VOUCHER_DISABLE_OPENING_HOME_FOR_BACK_BUTTON);
        } else {
            z11 = false;
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        if (!z11) {
            Navigator.Companion.navigate((Context) requireActivity, new NavigatorModel("talabat.action.homeScreen", (Bundle) null, VouchersListFragment$onBackPressed$1.INSTANCE, 2, (DefaultConstructorMarker) null));
        }
        requireActivity.finish();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setup();
        loadUserVouchers();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    @NotNull
    public VouchersListViewModel viewModelBuilder() {
        VouchersListViewModelBuilder vouchersListViewModelBuilder = VouchersListViewModelBuilder.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return vouchersListViewModelBuilder.getVouchersListViewModel(requireActivity, getCoroutineScope());
    }
}
