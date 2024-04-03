package com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bz.a;
import bz.b;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.IconStateDisplayModel;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.features.walletCashBack.CashBackCampaignOfferParams;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.adapter.WalletTopUpCardListAdapter;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpCardList.di.DaggerWalletTopUpCardListFragmentComponent;
import com.talabat.wallet.ui.walletTopUp.viewModel.WalletTopUpViewModel;
import com.talabat.wallet.ui.walletTopUp.viewModel.WalletTopUpViewModelBuilder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0002J\u0012\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020/H\u0016J\u0018\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020*2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u000203H\u0016J\b\u00106\u001a\u00020%H\u0016J\u0012\u00107\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0016\u0010=\u001a\u00020%2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?H\u0002J\b\u0010A\u001a\u00020%H\u0002J\u0012\u0010B\u001a\u00020%2\b\u0010C\u001a\u0004\u0018\u00010*H\u0002J\u0012\u0010D\u001a\u00020%2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\u0017\u0010G\u001a\u00020%2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0002\u0010JJ\u0012\u0010K\u001a\u00020%2\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\b\u0010N\u001a\u00020\u0002H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006O"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/WalletTopUpCardListFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/wallet/ui/walletTopUp/viewModel/WalletTopUpViewModel;", "Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/adapter/WalletTopUpCardListAdapter$WalletCreditCardAdapterInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTalabatTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "walletTopUpCardListAdapter", "Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/adapter/WalletTopUpCardListAdapter;", "getWalletTopUpCardListAdapter", "()Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/adapter/WalletTopUpCardListAdapter;", "setWalletTopUpCardListAdapter", "(Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpCardList/adapter/WalletTopUpCardListAdapter;)V", "addCardListener", "", "addViewClickListeners", "backButtonListener", "creditCardItemClicked", "cardDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "getWalletBankPartnerCardMessage", "walletCardDisplayModel", "position", "", "initializeRecyclerView", "layoutId", "observatory", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "populateList", "list", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "showEmptyCardListView", "updateAdapterCell", "walletCreditCardListDataItemAdapterDisplayModel", "updateAddCardIcon", "iconStateDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/IconStateDisplayModel;", "updateEmptyCardListView", "isCardListEmpty", "", "(Ljava/lang/Boolean;)V", "updateView", "walletCreditCardListDataItemWithTypeDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel;", "viewModelBuilder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class WalletTopUpCardListFragment extends BaseFragment implements WalletTopUpCardListAdapter.WalletCreditCardAdapterInterface, AnimationHelper {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public ITalabatFeatureFlag featureFlag;
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public TalabatTracker talabatTracker;
    public WalletTopUpCardListAdapter walletTopUpCardListAdapter;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType.values().length];
            iArr[WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType.QPAY.ordinal()] = 1;
            iArr[WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType.BENEFITS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void addCardListener() {
        ((TextView) _$_findCachedViewById(R.id.add_new_card_button)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addCardListener$lambda-3  reason: not valid java name */
    public static final void m6063addCardListener$lambda3(WalletTopUpCardListFragment walletTopUpCardListFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpCardListFragment, "this$0");
        Context context = walletTopUpCardListFragment.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToAddCardFromSource("talabat.action.Wallet.walletTopUpCardList", ((WalletTopUpViewModel) walletTopUpCardListFragment.getViewModel()).isWalletAddCardFlutterScreenEnabled()));
        }
    }

    private final void addViewClickListeners() {
        addCardListener();
        backButtonListener();
    }

    private final void backButtonListener() {
        ((ImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: backButtonListener$lambda-1  reason: not valid java name */
    public static final void m6064backButtonListener$lambda1(WalletTopUpCardListFragment walletTopUpCardListFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpCardListFragment, "this$0");
        Context context = walletTopUpCardListFragment.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToWalletDashBoard());
        }
    }

    /* access modifiers changed from: private */
    public final void creditCardItemClicked(WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        Context context = getContext();
        if (context != null) {
            ((WalletTopUpViewModel) getViewModel()).onCreditCardClicked(walletCardAdapterDisplayModel);
            Navigator.Companion companion = Navigator.Companion;
            Bundle bundle = new Bundle();
            bundle.putString(WalletNavigatorActions.EXTRA_TOKEN_ID, walletCardAdapterDisplayModel.getTokenId());
            bundle.putString(WalletNavigatorActions.EXTRA_CARD_4_DIGITS, StringsKt___StringsKt.takeLast(walletCardAdapterDisplayModel.getCardNumber(), 4));
            bundle.putString("cardType", walletCardAdapterDisplayModel.getCardType());
            bundle.putString("binNumber", walletCardAdapterDisplayModel.getBinNumber());
            Unit unit = Unit.INSTANCE;
            companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_TOP_UP_SCREEN, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
        }
    }

    private final void initializeRecyclerView() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            setWalletTopUpCardListAdapter(new WalletTopUpCardListAdapter(context, new WalletTopUpCardListFragment$initializeRecyclerView$1$1(this), this, ((WalletTopUpViewModel) getViewModel()).isWalletAddCardFlutterScreenEnabled()));
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.credit_card_list);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(getWalletTopUpCardListAdapter());
        }
    }

    private final void populateList(List<? extends WalletCreditCardListDataItemDisplayModel> list) {
        hideProgress();
        getWalletTopUpCardListAdapter().addItems(list);
        ((WalletTopUpViewModel) getViewModel()).onShowAddCardButton();
    }

    private final void showEmptyCardListView() {
        hideProgress();
        ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(8);
        _$_findCachedViewById(R.id.wallet_empty_view).setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void updateAdapterCell(WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel) {
        if (walletCardAdapterDisplayModel != null && walletCardAdapterDisplayModel.getPosition() > -1) {
            getWalletTopUpCardListAdapter().setAdapterData(walletCardAdapterDisplayModel.getPosition(), walletCardAdapterDisplayModel);
        }
    }

    /* access modifiers changed from: private */
    public final void updateAddCardIcon(IconStateDisplayModel iconStateDisplayModel) {
        if (iconStateDisplayModel instanceof IconStateDisplayModel.ShowIcon) {
            getWalletTopUpCardListAdapter().addItem(new WalletCreditCardListDataItemDisplayModel.AddCardButton());
        } else {
            IObservabilityManager.DefaultImpls.track$default(getObservabilityManager(), "Add card icon not added", "Add card icon", (Map) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void updateEmptyCardListView(Boolean bool) {
        if (BooleanKt.orFalse(bool)) {
            showEmptyCardListView();
        }
    }

    /* access modifiers changed from: private */
    public final void updateView(WalletCreditCardListDataItemWithTypeDisplayModel walletCreditCardListDataItemWithTypeDisplayModel) {
        WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType deflectionType;
        int i11;
        List<WalletCreditCardListDataItemDisplayModel> data;
        if (!(walletCreditCardListDataItemWithTypeDisplayModel == null || (data = walletCreditCardListDataItemWithTypeDisplayModel.getData()) == null || !(!data.isEmpty()))) {
            populateList(data);
        }
        if (walletCreditCardListDataItemWithTypeDisplayModel != null) {
            deflectionType = walletCreditCardListDataItemWithTypeDisplayModel.getDeflectionType();
        } else {
            deflectionType = null;
        }
        if (deflectionType == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[deflectionType.ordinal()];
        }
        if (i11 == 1) {
            int i12 = R.id.ds_alert_view_deflection;
            DSAlertView dSAlertView = (DSAlertView) _$_findCachedViewById(i12);
            Intrinsics.checkNotNullExpressionValue(dSAlertView, "ds_alert_view_deflection");
            dSAlertView.setVisibility(0);
            String string = getString(com.talabat.localization.R.string.wallet_payment_cards_deflection_info_descriptor_qpay);
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …or_qpay\n                )");
            ((DSAlertView) _$_findCachedViewById(i12)).setDescriptor(string);
        } else if (i11 != 2) {
            DSAlertView dSAlertView2 = (DSAlertView) _$_findCachedViewById(R.id.ds_alert_view_deflection);
            Intrinsics.checkNotNullExpressionValue(dSAlertView2, "ds_alert_view_deflection");
            dSAlertView2.setVisibility(8);
        } else {
            int i13 = R.id.ds_alert_view_deflection;
            DSAlertView dSAlertView3 = (DSAlertView) _$_findCachedViewById(i13);
            Intrinsics.checkNotNullExpressionValue(dSAlertView3, "ds_alert_view_deflection");
            dSAlertView3.setVisibility(0);
            String string2 = getString(com.talabat.localization.R.string.wallet_payment_cards_deflection_info_descriptor_bb);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(\n             …ptor_bb\n                )");
            ((DSAlertView) _$_findCachedViewById(i13)).setDescriptor(string2);
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

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
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
    public final ITalabatFeatureFlag getFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlag");
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
    public final TalabatTracker getTalabatTracker() {
        TalabatTracker talabatTracker2 = this.talabatTracker;
        if (talabatTracker2 != null) {
            return talabatTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatTracker");
        return null;
    }

    @NotNull
    public Class<WalletTopUpViewModel> getViewModelClass() {
        return WalletTopUpViewModel.class;
    }

    public void getWalletBankPartnerCardMessage(@NotNull WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel, int i11) {
        Intrinsics.checkNotNullParameter(walletCardAdapterDisplayModel, "walletCardDisplayModel");
        ((WalletTopUpViewModel) getViewModel()).getCashBackCampaignOffer(new CashBackCampaignOfferParams(walletCardAdapterDisplayModel.getBinNumber(), i11));
    }

    @NotNull
    public final WalletTopUpCardListAdapter getWalletTopUpCardListAdapter() {
        WalletTopUpCardListAdapter walletTopUpCardListAdapter2 = this.walletTopUpCardListAdapter;
        if (walletTopUpCardListAdapter2 != null) {
            return walletTopUpCardListAdapter2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("walletTopUpCardListAdapter");
        return null;
    }

    public int layoutId() {
        return R.layout.fragment_wallet_top_up_card_list;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((WalletTopUpViewModel) getViewModel()).getTopUpItemsListDataCredit(), new WalletTopUpCardListFragment$observatory$1(this));
        LifecycleKt.observe(this, ((WalletTopUpViewModel) getViewModel()).getEmptyCardListData(), new WalletTopUpCardListFragment$observatory$2(this));
        LifecycleKt.observe(this, ((WalletTopUpViewModel) getViewModel()).getCardAdapterItemData(), new WalletTopUpCardListFragment$observatory$3(this));
        LifecycleKt.observe(this, ((WalletTopUpViewModel) getViewModel()).getAddCardIconData(), new WalletTopUpCardListFragment$observatory$4(this));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DaggerWalletTopUpCardListFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class)).inject(this);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Boolean bool;
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        showProgress();
        initializeRecyclerView();
        ((WalletTopUpViewModel) getViewModel()).initFeatureFlags();
        ((WalletTopUpViewModel) getViewModel()).getCardList(getConfigurationLocalRepository().selectedCountry().getCountryId());
        ((WalletTopUpViewModel) getViewModel()).getCashBackCampaigns(4);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(extras.getBoolean(WalletNavigatorActions.EXTRA_IS_CARD_SUCCESSFULLY_ADDED));
        }
        if (BooleanKt.orFalse(bool)) {
            delay(AnimationSpeed.VERY_SLOW.getValue(), new WalletTopUpCardListFragment$onViewCreated$1(this));
        }
        addViewClickListeners();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlag = iTalabatFeatureFlag;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setTalabatTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "<set-?>");
        this.talabatTracker = talabatTracker2;
    }

    public final void setWalletTopUpCardListAdapter(@NotNull WalletTopUpCardListAdapter walletTopUpCardListAdapter2) {
        Intrinsics.checkNotNullParameter(walletTopUpCardListAdapter2, "<set-?>");
        this.walletTopUpCardListAdapter = walletTopUpCardListAdapter2;
    }

    @NotNull
    public WalletTopUpViewModel viewModelBuilder() {
        WalletTopUpViewModelBuilder.Companion companion = WalletTopUpViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getWalletTopUpViewModel(requireContext, getCoroutineScope(), getConfigurationLocalRepository(), getFeatureFlag(), getTalabatTracker());
    }
}
