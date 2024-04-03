package com.talabat.wallet.ui.walletTopUp.view.walletTopUpResponseScreen;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.integration.IntegrationGlobalDataModel;
import com.integration.wallet.WalletIntegrationAppTracker;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentErrorType;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModelBuilder;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.ui.walletTopUp.view.di.DaggerWalletTopUpResponseScreenFragmentComponent;
import ez.a;
import ez.b;
import ez.c;
import ez.d;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\u0012\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010-\u001a\u00020\u0002H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006."}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpResponseScreen/WalletTopUpResponseScreenFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getErrorMessage", "", "bundle", "Landroid/os/Bundle;", "getErrorType", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentErrorType;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "observatory", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "setFailureViewsVisibility", "errorType", "setSuccessViewsVisibility", "setViewsData", "showCloseButton", "showCtaAsGoBackToTopUpButton", "showCtaAsGoBackToWalletButton", "showCtaAsTryAnotherCardButton", "showFailureView", "showSuccessView", "updateWalletBalance", "walletBalanceDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "viewModelBuilder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class WalletTopUpResponseScreenFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WalletPaymentErrorType.values().length];
            iArr[WalletPaymentErrorType.CARD_PAYMENT_ERROR.ordinal()] = 1;
            iArr[WalletPaymentErrorType.OVER_ALL_CAP_ERROR.ordinal()] = 2;
            iArr[WalletPaymentErrorType.GENERIC_ERROR.ordinal()] = 3;
            iArr[WalletPaymentErrorType.NO_ERROR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final String getErrorMessage(Bundle bundle) {
        String str;
        if (bundle != null) {
            if (bundle.containsKey("message")) {
                str = bundle.getString("message");
                if (str == null) {
                    str = "";
                }
            } else {
                str = getResources().getString(R.string.sorry_something_went_wrong);
                Intrinsics.checkNotNullExpressionValue(str, "{\n                resour…went_wrong)\n            }");
            }
            if (str != null) {
                return str;
            }
        }
        String string = getResources().getString(R.string.sorry_something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…rry_something_went_wrong)");
        return string;
    }

    private final WalletPaymentErrorType getErrorType(Bundle bundle) {
        WalletPaymentErrorType walletPaymentErrorType;
        if (bundle != null) {
            if (bundle.containsKey("errorType")) {
                Serializable serializable = bundle.getSerializable("errorType");
                if (serializable != null) {
                    walletPaymentErrorType = (WalletPaymentErrorType) serializable;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentErrorType");
                }
            } else {
                walletPaymentErrorType = WalletPaymentErrorType.GENERIC_ERROR;
            }
            if (walletPaymentErrorType != null) {
                return walletPaymentErrorType;
            }
        }
        return WalletPaymentErrorType.GENERIC_ERROR;
    }

    private final void setFailureViewsVisibility(WalletPaymentErrorType walletPaymentErrorType) {
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_status_text_view)).setText(getString(R.string.top_up_failed));
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.error_message_text_view)).setVisibility(0);
        int i11 = WhenMappings.$EnumSwitchMapping$0[walletPaymentErrorType.ordinal()];
        if (i11 == 1) {
            showCtaAsTryAnotherCardButton();
        } else if (i11 == 2) {
            showCloseButton();
            showCtaAsGoBackToTopUpButton();
        } else if (i11 == 3 || i11 == 4) {
            showCtaAsGoBackToWalletButton();
        }
    }

    private final void setSuccessViewsVisibility() {
        ((ImageView) _$_findCachedViewById(com.talabat.wallet.R.id.close_button)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(com.talabat.wallet.R.id.status_icon)).setBackgroundResource(com.talabat.wallet.R.drawable.ic_wallet_top_up_success);
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_status_text_view)).setVisibility(0);
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_wallet_text_view)).setVisibility(0);
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.available_credit_text_view)).setVisibility(0);
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).setVisibility(0);
        showCtaAsGoBackToWalletButton();
    }

    private final void setViewsData() {
        Float f11;
        Float f12;
        String string;
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_status_text_view)).setText(getString(R.string.top_up_successful));
        TextView textView = (TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount);
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        Bundle arguments = getArguments();
        Boolean bool = null;
        if (arguments == null || (string = arguments.getString("amount")) == null) {
            f11 = null;
        } else {
            f11 = Float.valueOf(Float.parseFloat(string));
        }
        textView.setText(companion.getFormattedAmountWithCurrency(FloatKt.orZero(f11)));
        if (getConfigurationLocalRepository().selectedCountry() == Country.OMAN) {
            ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_wallet_text_view)).setText(getString(R.string.wallet_top_up_response_success_message_talabat_credit));
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            f12 = Float.valueOf(arguments2.getFloat(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT));
        } else {
            f12 = null;
        }
        float orZero = FloatKt.orZero(f12);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            bool = Boolean.valueOf(arguments3.getBoolean(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE));
        }
        if (BooleanKt.orFalse(bool) && orZero > 0.0f) {
            ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_waiting_message)).setVisibility(0);
        }
    }

    private final void showCloseButton() {
        int i11 = com.talabat.wallet.R.id.close_button;
        ((ImageView) _$_findCachedViewById(i11)).setOnClickListener(new a(this));
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: showCloseButton$lambda-10  reason: not valid java name */
    public static final void m6067showCloseButton$lambda10(WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpResponseScreenFragment, "this$0");
        Context context = walletTopUpResponseScreenFragment.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_TOP_UP_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
            FragmentActivity activity = walletTopUpResponseScreenFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void showCtaAsGoBackToTopUpButton() {
        int i11 = com.talabat.wallet.R.id.cta;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setOnClickListener(new d(this));
        ((TalabatFillButton) _$_findCachedViewById(i11)).setText(getString(R.string.go_back_to_top_up));
    }

    /* access modifiers changed from: private */
    /* renamed from: showCtaAsGoBackToTopUpButton$lambda-8  reason: not valid java name */
    public static final void m6068showCtaAsGoBackToTopUpButton$lambda8(WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpResponseScreenFragment, "this$0");
        Context context = walletTopUpResponseScreenFragment.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_TOP_UP_SCREEN, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
            FragmentActivity activity = walletTopUpResponseScreenFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void showCtaAsGoBackToWalletButton() {
        String str;
        int i11 = com.talabat.wallet.R.id.cta;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setOnClickListener(new b(this));
        TalabatFillButton talabatFillButton = (TalabatFillButton) _$_findCachedViewById(i11);
        if (getConfigurationLocalRepository().selectedCountry() == Country.OMAN) {
            str = getString(R.string.go_back_to_talabat_credit);
        } else {
            str = getString(R.string.go_back_to_talabat_pay);
        }
        talabatFillButton.setText(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: showCtaAsGoBackToWalletButton$lambda-4  reason: not valid java name */
    public static final void m6069showCtaAsGoBackToWalletButton$lambda4(WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpResponseScreenFragment, "this$0");
        Context context = walletTopUpResponseScreenFragment.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToWalletDashBoard());
            FragmentActivity activity = walletTopUpResponseScreenFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void showCtaAsTryAnotherCardButton() {
        int i11 = com.talabat.wallet.R.id.cta;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setOnClickListener(new c(this));
        ((TalabatFillButton) _$_findCachedViewById(i11)).setText(getString(R.string.try_another_card));
    }

    /* access modifiers changed from: private */
    /* renamed from: showCtaAsTryAnotherCardButton$lambda-6  reason: not valid java name */
    public static final void m6070showCtaAsTryAnotherCardButton$lambda6(WalletTopUpResponseScreenFragment walletTopUpResponseScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpResponseScreenFragment, "this$0");
        Context context = walletTopUpResponseScreenFragment.getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel("talabat.action.Wallet.walletTopUpCardList", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
            FragmentActivity activity = walletTopUpResponseScreenFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void showFailureView() {
        Float f11;
        String string;
        String errorMessage = getErrorMessage(getArguments());
        WalletPaymentErrorType errorType = getErrorType(getArguments());
        Context context = getContext();
        if (context != null) {
            WalletIntegrationAppTracker.Companion companion = WalletIntegrationAppTracker.Companion;
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString("amount")) == null) {
                f11 = null;
            } else {
                f11 = Float.valueOf(Float.parseFloat(string));
            }
            companion.onWalletTopUpFailure(context, "Wallet Topup success screen", "wallet", String.valueOf(FloatKt.orZero(f11)), errorMessage);
        }
        setFailureViewsVisibility(errorType);
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.error_message_text_view)).setText(errorMessage);
        ((ImageView) _$_findCachedViewById(com.talabat.wallet.R.id.status_icon)).setBackgroundResource(com.talabat.wallet.R.drawable.ic_wallet_top_up_failed);
        hideProgress();
    }

    private final void showSuccessView() {
        Float f11;
        String string;
        Context context = getContext();
        if (context != null) {
            WalletIntegrationAppTracker.Companion companion = WalletIntegrationAppTracker.Companion;
            Bundle arguments = getArguments();
            if (arguments == null || (string = arguments.getString("amount")) == null) {
                f11 = null;
            } else {
                f11 = Float.valueOf(Float.parseFloat(string));
            }
            companion.onWalletTopUpSuccess(context, "Wallet Topup success screen", "wallet", String.valueOf(FloatKt.orZero(f11)), StringUtils.empty(StringCompanionObject.INSTANCE));
        }
        setSuccessViewsVisibility();
        setViewsData();
        showProgress();
        WalletPaymentOptionViewModel.getWalletBalance$default((WalletPaymentOptionViewModel) getViewModel(), 0, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateWalletBalance(WalletBalanceDisplayModel walletBalanceDisplayModel) {
        if (walletBalanceDisplayModel != null) {
            hideProgress();
            String string = getResources().getString(R.string.your_available_credit_is);
            String formattedAmountWithCurrency = IntegrationGlobalDataModel.Companion.getFormattedAmountWithCurrency(walletBalanceDisplayModel.getWalletBalance());
            ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.available_credit_text_view)).setText(HtmlCompat.fromHtml(string + "<b> " + formattedAmountWithCurrency + "</b>", 0));
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

    public void failureHere(@Nullable Failure failure) {
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
        hideProgress();
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
    public Class<WalletPaymentOptionViewModel> getViewModelClass() {
        return WalletPaymentOptionViewModel.class;
    }

    public int layoutId() {
        return com.talabat.wallet.R.layout.fragment_wallet_top_up_response_screen;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) getViewModel()).getWalletBalanceData(), new WalletTopUpResponseScreenFragment$observatory$1(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerWalletTopUpResponseScreenFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("status");
        } else {
            str = null;
        }
        if (StringsKt__StringsJVMKt.equals$default(str, "success", false, 2, (Object) null)) {
            showSuccessView();
            return;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("status");
        } else {
            str2 = null;
        }
        if (StringsKt__StringsJVMKt.equals$default(str2, "failure", false, 2, (Object) null)) {
            showFailureView();
        } else {
            LogManager.debug("unsupported view");
        }
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @NotNull
    public WalletPaymentOptionViewModel viewModelBuilder() {
        WalletPaymentOptionViewModelBuilder.Companion companion = WalletPaymentOptionViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getWalletPaymentOptionViewModel(requireContext, getCoroutineScope());
    }
}
