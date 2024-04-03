package com.talabat.wallet.ui.walletTransactionDetail.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.gson.Gson;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.network.imageDownloader.TransformType;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatcommon.utils.FullScreenLoaderInterface;
import com.talabat.talabatcommon.utils.ProgressBarLoading;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDetailHeaderDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionDisplayModelState;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletTransactionType;
import com.talabat.wallet.ui.walletTransactionDetail.view.di.DaggerWalletTransactionDetailFragmentComponent;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletDetailCreditExpiredView;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletDetailCreditVoucherView;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletDetailTransactionCommonView;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletDetailTransactionPaidView;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionDetailRechargeView;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionDetailRefundSent;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionDetailRiderTipView;
import com.talabat.wallet.ui.walletTransactionDetail.view.walletTransactionBodyView.WalletTransactionRefundView;
import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailViewModelBuilder;
import com.talabat.wallet.ui.walletTransactionDetail.viewModel.WalletTransactionDetailViewModelImpl;
import datamodels.OrderDetails;
import hz.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020+2\u0006\u0010,\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020+2\u0006\u00100\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020+2\u0006\u00100\u001a\u000207H\u0002J\u0010\u00108\u001a\u00020+2\u0006\u0010,\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020+2\u0006\u00100\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020+H\u0016J\u000e\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020+H\u0016J\u0010\u0010A\u001a\u00020+2\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010B\u001a\u00020+H\u0002J\u0010\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020EH\u0016J&\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u001a\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020G2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J\b\u0010P\u001a\u00020+H\u0002J\u0010\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020RH\u0002J\b\u0010U\u001a\u00020+H\u0016J\u0010\u0010V\u001a\u00020+2\u0006\u00100\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020+H\u0016J\u0012\u0010Y\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010ZH\u0002J\u0012\u0010[\u001a\u00020+2\b\u0010\\\u001a\u0004\u0018\u00010WH\u0002J\b\u0010]\u001a\u00020\u0014H\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/WalletTransactionDetailFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletDetailTransactionPaidView$WalletPaidDetailOrderDetailInterface;", "Lcom/talabat/talabatcommon/utils/FullScreenLoaderInterface;", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/walletTransactionBodyView/WalletTransactionRefundView$WalletRefundOrderDetailInterface;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "factory", "Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "Lcom/talabat/wallet/ui/walletTransactionDetail/viewModel/WalletTransactionDetailViewModelImpl;", "helpDeeplinkBuilder", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "getHelpDeeplinkBuilder", "()Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "setHelpDeeplinkBuilder", "(Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;)V", "isRefundRevertedSuccessful", "", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "viewModel", "attachCommonView", "", "walletTransactionDisplayModelState", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessCommonViewTransaction;", "attachCreditExpiredView", "attachCreditVoucherView", "model", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessCreditVoucherViewTransaction;", "attachPaymentView", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessPaymentViewTransaction;", "attachRechargeView", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRechargeViewTransaction;", "attachRefundSentView", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRefundSentViewTransaction;", "attachRefundView", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRefundViewTransaction;", "attachRiderTipView", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState$SuccessRiderTipViewTransaction;", "hideLoader", "navigate", "orderDetail", "Ldatamodels/OrderDetails;", "navigateToHelpCenter", "navigateToOrderDetail", "navigateToWalletDashBoard", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "showError", "message", "", "showImageMerchantIcon", "imageUrl", "showLoader", "showTransactionAmount", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDetailHeaderDisplayModel;", "updateRefundRevertedStatus", "updateTransactionDetailBody", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletTransactionDisplayModelState;", "updateTransactionDetailHeader", "walletTransactionDetailHeaderDisplayModel", "viewModelBuilder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailFragment extends Fragment implements WalletDetailTransactionPaidView.WalletPaidDetailOrderDetailInterface, FullScreenLoaderInterface, WalletTransactionRefundView.WalletRefundOrderDetailInterface, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @NotNull
    private BaseViewModelFactory<WalletTransactionDetailViewModelImpl> factory = new BaseViewModelFactory<>(new WalletTransactionDetailFragment$factory$1(this));
    @Inject
    public IHelpCenterDeeplinkBuilder helpDeeplinkBuilder;
    private boolean isRefundRevertedSuccessful;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public Navigator navigator;
    private WalletTransactionDetailViewModelImpl viewModel;

    private final void attachCommonView(WalletTransactionDisplayModelState.SuccessCommonViewTransaction successCommonViewTransaction) {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        Context context = getContext();
        if (context != null) {
            WalletDetailTransactionCommonView walletDetailTransactionCommonView = new WalletDetailTransactionCommonView(context);
            ((FrameLayout) _$_findCachedViewById(R.id.transaction_detail_body_container)).addView(walletDetailTransactionCommonView);
            walletDetailTransactionCommonView.addViewToContainer(successCommonViewTransaction.getData());
        }
    }

    private final void attachCreditExpiredView() {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        Context context = getContext();
        if (context != null) {
            ((FrameLayout) _$_findCachedViewById(R.id.transaction_detail_body_container)).addView(new WalletDetailCreditExpiredView(context));
        }
    }

    private final void attachCreditVoucherView(WalletTransactionDisplayModelState.SuccessCreditVoucherViewTransaction successCreditVoucherViewTransaction) {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        Context context = getContext();
        if (context != null) {
            WalletDetailCreditVoucherView walletDetailCreditVoucherView = new WalletDetailCreditVoucherView(context);
            ((FrameLayout) _$_findCachedViewById(R.id.transaction_detail_body_container)).addView(walletDetailCreditVoucherView);
            walletDetailCreditVoucherView.addViewToParent(successCreditVoucherViewTransaction.getData());
        }
    }

    private final void attachPaymentView(WalletTransactionDisplayModelState.SuccessPaymentViewTransaction successPaymentViewTransaction) {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        Context context = getContext();
        if (context != null) {
            WalletDetailTransactionPaidView walletDetailTransactionPaidView = new WalletDetailTransactionPaidView(context);
            ((FrameLayout) _$_findCachedViewById(R.id.transaction_detail_body_container)).addView(walletDetailTransactionPaidView);
            walletDetailTransactionPaidView.setFullScreenLoaderListener(this);
            walletDetailTransactionPaidView.setWalletPaidDetailOrderDetailListener(this);
            walletDetailTransactionPaidView.addViewToParent(successPaymentViewTransaction.getData());
        }
    }

    private final void attachRechargeView(WalletTransactionDisplayModelState.SuccessRechargeViewTransaction successRechargeViewTransaction) {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        Context context = getContext();
        if (context != null) {
            WalletTransactionDetailRechargeView walletTransactionDetailRechargeView = new WalletTransactionDetailRechargeView(context);
            ((FrameLayout) _$_findCachedViewById(R.id.transaction_detail_body_container)).addView(walletTransactionDetailRechargeView);
            walletTransactionDetailRechargeView.addViewToParent(successRechargeViewTransaction.getData());
        }
    }

    private final void attachRefundSentView(WalletTransactionDisplayModelState.SuccessRefundSentViewTransaction successRefundSentViewTransaction) {
        Context context = getContext();
        if (context != null) {
            WalletTransactionDetailRefundSent walletTransactionDetailRefundSent = new WalletTransactionDetailRefundSent(context);
            ((FrameLayout) _$_findCachedViewById(R.id.transaction_detail_body_container)).addView(walletTransactionDetailRefundSent);
            walletTransactionDetailRefundSent.setWalletRefundOrderDetailListener(this);
            walletTransactionDetailRefundSent.addViewToParent(successRefundSentViewTransaction.getData());
            ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
            View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
            progressBarLoading.hideProgress(_$_findCachedViewById);
        }
    }

    private final void attachRefundView(WalletTransactionDisplayModelState.SuccessRefundViewTransaction successRefundViewTransaction) {
        Context context = getContext();
        if (context != null) {
            WalletTransactionRefundView walletTransactionRefundView = new WalletTransactionRefundView(context);
            ((FrameLayout) _$_findCachedViewById(R.id.transaction_detail_body_container)).addView(walletTransactionRefundView);
            walletTransactionRefundView.setFullScreenLoaderListener(this);
            walletTransactionRefundView.setWalletRefundOrderDetailListener(this);
            walletTransactionRefundView.addViewToParent(successRefundViewTransaction.getData());
        }
    }

    private final void attachRiderTipView(WalletTransactionDisplayModelState.SuccessRiderTipViewTransaction successRiderTipViewTransaction) {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        Context context = getContext();
        if (context != null) {
            WalletTransactionDetailRiderTipView walletTransactionDetailRiderTipView = new WalletTransactionDetailRiderTipView(context);
            ((FrameLayout) _$_findCachedViewById(R.id.transaction_detail_body_container)).addView(walletTransactionDetailRiderTipView);
            walletTransactionDetailRiderTipView.addViewToParent(successRiderTipViewTransaction.getData());
        }
    }

    private final void navigateToWalletDashBoard() {
        if (this.isRefundRevertedSuccessful) {
            Context context = getContext();
            if (context != null) {
                com.talabat.talabatnavigation.Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToWalletDashBoard());
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m6076onViewCreated$lambda1(WalletTransactionDetailFragment walletTransactionDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailFragment, "this$0");
        walletTransactionDetailFragment.navigateToWalletDashBoard();
    }

    private final void showError() {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
    }

    private final void showImageMerchantIcon(String str) {
        Context context = getContext();
        if (context != null) {
            ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.transaction_logo);
            Intrinsics.checkNotNullExpressionValue(imageView, "transaction_logo");
            ImageDownloadHelper.Companion.downloadImageSpecificTransform$default(companion, context, str, imageView, 0, 0, TransformType.CIRCLE_CROP, 24, (Object) null);
        }
    }

    private final void showTransactionAmount(WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        int transactionTypeId = walletTransactionDetailHeaderDisplayModel.getTransactionTypeId();
        Integer value = WalletTransactionType.T_LIFE_CASH_PAYMENT.getValue();
        if (value != null && transactionTypeId == value.intValue()) {
            ((TextView) _$_findCachedViewById(R.id.transaction_amount)).setText(StringsKt__StringsKt.removeRange((CharSequence) CurrencyFormatter.Companion.formatAmountWithSign(getLocationConfigurationRepository(), walletTransactionDetailHeaderDisplayModel.getAmount(), true), 0, 1).toString());
        } else {
            ((TextView) _$_findCachedViewById(R.id.transaction_amount)).setText(CurrencyFormatter.Companion.formatAmountWithSign(getLocationConfigurationRepository(), walletTransactionDetailHeaderDisplayModel.getAmount(), true));
        }
    }

    /* access modifiers changed from: private */
    public final void updateTransactionDetailBody(WalletTransactionDisplayModelState walletTransactionDisplayModelState) {
        if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.Loading) {
            ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
            View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
            progressBarLoading.showProgress(_$_findCachedViewById);
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.Default) {
            ProgressBarLoading progressBarLoading2 = ProgressBarLoading.INSTANCE;
            View _$_findCachedViewById2 = _$_findCachedViewById(R.id.progress_bar);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById2, "progress_bar");
            progressBarLoading2.hideProgress(_$_findCachedViewById2);
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.Error) {
            showError();
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.SuccessCommonViewTransaction) {
            attachCommonView((WalletTransactionDisplayModelState.SuccessCommonViewTransaction) walletTransactionDisplayModelState);
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.SuccessPaymentViewTransaction) {
            attachPaymentView((WalletTransactionDisplayModelState.SuccessPaymentViewTransaction) walletTransactionDisplayModelState);
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.SuccessCreditVoucherViewTransaction) {
            attachCreditVoucherView((WalletTransactionDisplayModelState.SuccessCreditVoucherViewTransaction) walletTransactionDisplayModelState);
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.SuccessCreditExpiredViewTransaction) {
            attachCreditExpiredView();
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.SuccessRiderTipViewTransaction) {
            attachRiderTipView((WalletTransactionDisplayModelState.SuccessRiderTipViewTransaction) walletTransactionDisplayModelState);
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.SuccessRechargeViewTransaction) {
            attachRechargeView((WalletTransactionDisplayModelState.SuccessRechargeViewTransaction) walletTransactionDisplayModelState);
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.SuccessRefundViewTransaction) {
            attachRefundView((WalletTransactionDisplayModelState.SuccessRefundViewTransaction) walletTransactionDisplayModelState);
        } else if (walletTransactionDisplayModelState instanceof WalletTransactionDisplayModelState.SuccessRefundSentViewTransaction) {
            attachRefundSentView((WalletTransactionDisplayModelState.SuccessRefundSentViewTransaction) walletTransactionDisplayModelState);
        }
    }

    /* access modifiers changed from: private */
    public final void updateTransactionDetailHeader(WalletTransactionDetailHeaderDisplayModel walletTransactionDetailHeaderDisplayModel) {
        if (walletTransactionDetailHeaderDisplayModel != null) {
            ((TextView) _$_findCachedViewById(R.id.transaction_name)).setText(walletTransactionDetailHeaderDisplayModel.getName());
            Context context = getContext();
            if (context != null) {
                DateUtils.Companion companion = DateUtils.Companion;
                String date = walletTransactionDetailHeaderDisplayModel.getDate();
                String string = context.getString(com.talabat.localization.R.string.wallet_transaction__date_format);
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(com.talabat…transaction__date_format)");
                ((TextView) _$_findCachedViewById(R.id.transaction_date)).setText(companion.getLocalizedFormattedDateString(date, string));
            }
            showImageMerchantIcon(walletTransactionDetailHeaderDisplayModel.getImageUrl());
            showTransactionAmount(walletTransactionDetailHeaderDisplayModel);
        }
    }

    /* access modifiers changed from: private */
    public final WalletTransactionDetailViewModelImpl viewModelBuilder() {
        return WalletTransactionDetailViewModelBuilder.Companion.getWalletTransactionViewModelBuilder(getConfigurationLocalRepository());
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
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final IHelpCenterDeeplinkBuilder getHelpDeeplinkBuilder() {
        IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder = this.helpDeeplinkBuilder;
        if (iHelpCenterDeeplinkBuilder != null) {
            return iHelpCenterDeeplinkBuilder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helpDeeplinkBuilder");
        return null;
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
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    public void hideLoader() {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
    }

    public final void navigate(@NotNull OrderDetails orderDetails) {
        Intrinsics.checkNotNullParameter(orderDetails, "orderDetail");
        String json = GsonInstrumentation.toJson(new Gson(), (Object) orderDetails);
        Context context = getContext();
        if (context != null) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_ORDER_DETAIL_SCREEN, (Bundle) null, new WalletTransactionDetailFragment$navigate$1$1(json, orderDetails), 2, (DefaultConstructorMarker) null));
        }
    }

    public void navigateToHelpCenter() {
        if (getContext() != null) {
            DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireActivity, IHelpCenterDeeplinkBuilder.DefaultImpls.build$default(getHelpDeeplinkBuilder(), (String) null, (String) null, 3, (Object) null), (Function0) null, 4, (Object) null);
        }
    }

    public void navigateToOrderDetail(@NotNull OrderDetails orderDetails) {
        Intrinsics.checkNotNullParameter(orderDetails, "orderDetail");
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        navigate(orderDetails);
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerWalletTransactionDetailFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (HelpCenterFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(HelpCenterFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletTransactionDetailFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletTransactionDetailFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_wallet_transaction_detail, viewGroup, false);
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

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.showProgress(_$_findCachedViewById);
        this.viewModel = (WalletTransactionDetailViewModelImpl) ViewModelInjectorKt.injectViewModel((Fragment) this, WalletTransactionDetailViewModelImpl.class, (ViewModelProvider.Factory) this.factory);
        Bundle arguments = getArguments();
        WalletTransactionDetailViewModelImpl walletTransactionDetailViewModelImpl = null;
        if (arguments != null) {
            WalletTransactionDetailViewModelImpl walletTransactionDetailViewModelImpl2 = this.viewModel;
            if (walletTransactionDetailViewModelImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                walletTransactionDetailViewModelImpl2 = null;
            }
            walletTransactionDetailViewModelImpl2.onLoadWalletTransactionDetail(arguments.getInt("transactionType"), arguments.getInt("transactionId"));
        }
        ((ImageButton) _$_findCachedViewById(R.id.back_icon)).setOnClickListener(new a(this));
        WalletTransactionDetailViewModelImpl walletTransactionDetailViewModelImpl3 = this.viewModel;
        if (walletTransactionDetailViewModelImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletTransactionDetailViewModelImpl3 = null;
        }
        LifecycleKt.observe(this, walletTransactionDetailViewModelImpl3.getWalletTransactionDetailData(), new WalletTransactionDetailFragment$onViewCreated$3(this));
        WalletTransactionDetailViewModelImpl walletTransactionDetailViewModelImpl4 = this.viewModel;
        if (walletTransactionDetailViewModelImpl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            walletTransactionDetailViewModelImpl = walletTransactionDetailViewModelImpl4;
        }
        LifecycleKt.observe(this, walletTransactionDetailViewModelImpl.getWalletTransactionDetailHeaderData(), new WalletTransactionDetailFragment$onViewCreated$4(this));
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setHelpDeeplinkBuilder(@NotNull IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        Intrinsics.checkNotNullParameter(iHelpCenterDeeplinkBuilder, "<set-?>");
        this.helpDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public void showLoader() {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.showProgress(_$_findCachedViewById);
    }

    public void updateRefundRevertedStatus() {
        this.isRefundRevertedSuccessful = true;
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        showError();
    }
}
