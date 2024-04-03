package com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.integration.IntegrationGlobalDataModel;
import com.integration.wallet.WalletIntegrationAppTracker;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentErrorType;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentTransactionStatus;
import com.talabat.talabatcommon.listeners.DebounceQueryTextListener;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletSuggestionButtonsDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpAmountSuggestionDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpButtonDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpCtaState;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpSuggestionsAndLimitsDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModelBuilder;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.features.walletCashBack.model.request.WalletCalculateCashBackRequestModel;
import com.talabat.wallet.ui.walletTopUp.model.WalletCalculateCashBackDisplayModel;
import com.talabat.wallet.ui.walletTopUp.view.walletTopUpScreen.di.DaggerWalletTopUpScreenFragmentComponent;
import com.talabat.wallet.ui.walletTopUp.viewModel.WalletTopUpViewModel;
import com.talabat.wallet.ui.walletTopUp.viewModel.WalletTopUpViewModelBuilder;
import com.wang.avi.AVLoadingIndicatorView;
import fz.a;
import fz.b;
import fz.c;
import fz.d;
import fz.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\u0012\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/H\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020\u000201H\u0016J\b\u00102\u001a\u00020#H\u0002J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020#H\u0016J\u0010\u00106\u001a\u00020#2\u0006\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u00020#2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020/H\u0002J\b\u0010>\u001a\u00020#H\u0016J\u0018\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020#H\u0002J\u001a\u0010D\u001a\u00020#2\u0006\u0010E\u001a\u00020F2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010G\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010H\u001a\u00020#H\u0002J\u0018\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020/H\u0002J \u0010L\u001a\u00020#2\u0016\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\b\u0010N\u001a\u00020#H\u0002J\u0018\u0010O\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u0010P\u001a\u00020/H\u0002J\u0010\u0010Q\u001a\u00020#2\u0006\u0010.\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020#H\u0002J\b\u0010T\u001a\u00020#H\u0002J\u0010\u0010U\u001a\u00020#2\u0006\u0010.\u001a\u00020RH\u0002J=\u0010V\u001a\u00020#2\b\u0010W\u001a\u0004\u0018\u00010/2\b\u0010X\u001a\u0004\u0018\u00010/2\b\u0010Y\u001a\u0004\u0018\u00010/2\b\u0010Z\u001a\u0004\u0018\u0001042\u0006\u0010.\u001a\u00020RH\u0002¢\u0006\u0002\u0010[J\u0012\u0010\\\u001a\u00020#2\b\u0010]\u001a\u0004\u0018\u00010^H\u0002J\u0017\u0010_\u001a\u00020#2\b\u0010`\u001a\u0004\u0018\u00010aH\u0002¢\u0006\u0002\u0010bJ\u0012\u0010c\u001a\u00020#2\b\u0010d\u001a\u0004\u0018\u00010eH\u0002J\u0012\u0010f\u001a\u00020#2\b\u0010g\u001a\u0004\u0018\u00010hH\u0002J\u0012\u0010i\u001a\u00020#2\b\u0010j\u001a\u0004\u0018\u00010kH\u0002J\u0018\u0010l\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010m\u001a\u00020nH\u0002J\u0012\u0010o\u001a\u00020#2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002J\b\u0010r\u001a\u00020\u0002H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X.¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/view/walletTopUpScreen/WalletTopUpScreenFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/wallet/ui/walletTopUp/viewModel/WalletTopUpViewModel;", "()V", "buttons", "Ljava/util/ArrayList;", "Landroid/widget/Button;", "Lkotlin/collections/ArrayList;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTalabatTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "walletPaymentOptionViewModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel;", "activateButton", "", "button", "addButtonClickListeners", "addTextChangeListener", "clearTopUpButton", "disableTopUpButton", "enableTopUpButton", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getCalculatedCashBack", "amount", "", "getViewModelClass", "Ljava/lang/Class;", "hideLoader", "layoutId", "", "observatory", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDebounce", "text", "onResume", "onTopUpFailure", "message", "errorType", "Lcom/talabat/talabatcommon/feature/walletPayment/model/response/WalletPaymentErrorType;", "onTopUpSuccess", "onViewCreated", "view", "Landroid/view/View;", "onWalletPaymentError", "populateButtons", "redirectToThreeDsScreen", "threeDsUrl", "transactionId", "resetAllSuggestionButtons", "buttonArray", "setDefaultAmount", "setSubmitTopUpButtonText", "currency", "showCalculatedCashBack", "", "showLoader", "submitTopUpButtonClickListeners", "topUpAmount", "topUpWallet", "tokenId", "card4Digits", "cardType", "binNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;F)V", "updateCalculatedCashBack", "walletCalculateCashBackDisplayModel", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCalculateCashBackDisplayModel;", "updateCashBackLoader", "isLoaderVisible", "", "(Ljava/lang/Boolean;)V", "updatePaymentStatus", "walletPaymentDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "updateSuggestionButtons", "walletSuggestionButtonsDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletSuggestionButtonsDisplayModel;", "updateTopUpButtons", "walletTopUpButtonDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpButtonDisplayModel;", "updateTopUpEditText", "editText", "Landroid/widget/EditText;", "updateWalletTopUpSuggestionAndLimits", "walletTopUpSuggestionsAndLimitsDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpSuggestionsAndLimitsDisplayModel;", "viewModelBuilder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpScreenFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ArrayList<Button> buttons;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public ITalabatFeatureFlag featureFlag;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public TalabatTracker talabatTracker;
    /* access modifiers changed from: private */
    public WalletPaymentOptionViewModel walletPaymentOptionViewModel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WalletPaymentTransactionStatus.values().length];
            iArr[WalletPaymentTransactionStatus.FAIL.ordinal()] = 1;
            iArr[WalletPaymentTransactionStatus.SUCCESS.ordinal()] = 2;
            iArr[WalletPaymentTransactionStatus.THREE_DS.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void activateButton(Button button) {
        button.setAlpha(1.0f);
        Context context = getContext();
        if (context != null) {
            button.setBackground(ContextCompat.getDrawable(context, R.drawable.wallet_top_up_amount_background_selected));
            button.setTextColor(ContextCompat.getColor(context, com.talabat.wallet.R.color.white));
        }
    }

    private final void addButtonClickListeners() {
        ((TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.first_select_amount_button)).setOnClickListener(new b(this));
        ((TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.second_select_amount_button)).setOnClickListener(new c(this));
        ((TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.third_select_amount_button)).setOnClickListener(new d(this));
        ((ImageButton) _$_findCachedViewById(com.talabat.wallet.R.id.back)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonClickListeners$lambda-4  reason: not valid java name */
    public static final void m6071addButtonClickListeners$lambda4(WalletTopUpScreenFragment walletTopUpScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpScreenFragment, "this$0");
        if (view != null) {
            EditText editText = (EditText) walletTopUpScreenFragment._$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount);
            Intrinsics.checkNotNullExpressionValue(editText, "top_up_amount");
            walletTopUpScreenFragment.updateTopUpEditText((Button) view, editText);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonClickListeners$lambda-5  reason: not valid java name */
    public static final void m6072addButtonClickListeners$lambda5(WalletTopUpScreenFragment walletTopUpScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpScreenFragment, "this$0");
        if (view != null) {
            EditText editText = (EditText) walletTopUpScreenFragment._$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount);
            Intrinsics.checkNotNullExpressionValue(editText, "top_up_amount");
            walletTopUpScreenFragment.updateTopUpEditText((Button) view, editText);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonClickListeners$lambda-6  reason: not valid java name */
    public static final void m6073addButtonClickListeners$lambda6(WalletTopUpScreenFragment walletTopUpScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpScreenFragment, "this$0");
        if (view != null) {
            EditText editText = (EditText) walletTopUpScreenFragment._$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount);
            Intrinsics.checkNotNullExpressionValue(editText, "top_up_amount");
            walletTopUpScreenFragment.updateTopUpEditText((Button) view, editText);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonClickListeners$lambda-7  reason: not valid java name */
    public static final void m6074addButtonClickListeners$lambda7(WalletTopUpScreenFragment walletTopUpScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpScreenFragment, "this$0");
        FragmentActivity activity = walletTopUpScreenFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void addTextChangeListener() {
        ((EditText) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).addTextChangedListener(new DebounceQueryTextListener(1, new WalletTopUpScreenFragment$addTextChangeListener$1(this), getLifecycle(), new WalletTopUpScreenFragment$addTextChangeListener$2(this), (Function1) null, 16, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final void clearTopUpButton() {
        ((EditText) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).requestFocus();
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.cash_back_label)).setText(getResources().getString(com.talabat.localization.R.string.cash_back_label, new Object[]{"0"}));
        ((TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.submit_top_up_button)).setText(getString(com.talabat.localization.R.string.top_up));
        disableTopUpButton();
        ArrayList<Button> arrayList = this.buttons;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttons");
            arrayList = null;
        }
        resetAllSuggestionButtons(arrayList);
    }

    private final void disableTopUpButton() {
        int i11 = com.talabat.wallet.R.id.submit_top_up_button;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setEnabled(false);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setAlpha(0.5f);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setText(getString(com.talabat.localization.R.string.top_up));
    }

    private final void enableTopUpButton() {
        int i11 = com.talabat.wallet.R.id.submit_top_up_button;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setEnabled(true);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setAlpha(1.0f);
    }

    private final void getCalculatedCashBack(String str) {
        Integer num;
        String string;
        WalletTopUpViewModel walletTopUpViewModel = (WalletTopUpViewModel) getViewModel();
        float orZero = FloatKt.orZero(Float.valueOf(Float.parseFloat(str)));
        int countryId = getConfigurationLocalRepository().selectedCountry().getCountryId();
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("binNumber")) == null) {
            num = null;
        } else {
            num = Integer.valueOf(Integer.parseInt(string));
        }
        walletTopUpViewModel.getCalculatedCashBack(new WalletCalculateCashBackRequestModel(orZero, 4, countryId, IntKt.orZero(num)));
    }

    private final void hideLoader() {
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.cash_back_label)).setVisibility(0);
        ((AVLoadingIndicatorView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_loading)).setVisibility(4);
    }

    /* access modifiers changed from: private */
    public final void onDebounce(String str) {
        boolean z11;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            clearTopUpButton();
            ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.cash_back_label)).setText(getResources().getString(com.talabat.localization.R.string.cash_back_label, new Object[]{IntegrationGlobalDataModel.Companion.getFormattedAmountWithoutCurrency(0.0f)}));
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "0", false, 2, (Object) null)) {
            ((EditText) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).getText().clear();
            disableTopUpButton();
            clearTopUpButton();
        } else {
            getCalculatedCashBack(str);
        }
    }

    private final void onTopUpFailure(String str, WalletPaymentErrorType walletPaymentErrorType) {
        boolean z11;
        Context context = getContext();
        if (context != null) {
            Navigator.Companion companion = Navigator.Companion;
            Bundle bundle = new Bundle();
            bundle.putString("status", "failure");
            bundle.putString("amount", ((EditText) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).getText().toString());
            if (str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                bundle.putString("message", getResources().getString(com.talabat.localization.R.string.sorry_something_went_wrong));
            } else {
                bundle.putString("message", str);
            }
            bundle.putSerializable("errorType", walletPaymentErrorType);
            Unit unit = Unit.INSTANCE;
            companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_TOP_UP_RESPONSE_SCREEN, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void onTopUpSuccess() {
        Float f11;
        Context context = getContext();
        if (context != null) {
            Navigator.Companion companion = Navigator.Companion;
            Bundle bundle = new Bundle();
            bundle.putString("status", "success");
            bundle.putString("amount", ((EditText) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).getText().toString());
            WalletCalculateCashBackDisplayModel value = ((WalletTopUpViewModel) getViewModel()).getCalculatedCashBackData().getValue();
            Boolean bool = null;
            if (value != null) {
                f11 = Float.valueOf(value.getAmount());
            } else {
                f11 = null;
            }
            bundle.putFloat(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT, FloatKt.orZero(f11));
            WalletCalculateCashBackDisplayModel value2 = ((WalletTopUpViewModel) getViewModel()).getCalculatedCashBackData().getValue();
            if (value2 != null) {
                bool = Boolean.valueOf(value2.isCampaignActive());
            }
            bundle.putBoolean(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE, BooleanKt.orFalse(bool));
            Unit unit = Unit.INSTANCE;
            companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_TOP_UP_RESPONSE_SCREEN, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onWalletPaymentError(Failure failure) {
        if (failure != null) {
            hideProgress();
            Status.Companion companion = Status.Companion;
            FragmentActivity activity = getActivity();
            String string = getResources().getString(com.talabat.localization.R.string.something_went_wrong);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
            Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
            enableTopUpButton();
        }
    }

    private final void populateButtons() {
        TalabatFillButton talabatFillButton = (TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.first_select_amount_button);
        Intrinsics.checkNotNullExpressionValue(talabatFillButton, "first_select_amount_button");
        TalabatFillButton talabatFillButton2 = (TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.second_select_amount_button);
        Intrinsics.checkNotNullExpressionValue(talabatFillButton2, "second_select_amount_button");
        TalabatFillButton talabatFillButton3 = (TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.third_select_amount_button);
        Intrinsics.checkNotNullExpressionValue(talabatFillButton3, "third_select_amount_button");
        this.buttons = CollectionsKt__CollectionsKt.arrayListOf(talabatFillButton, talabatFillButton2, talabatFillButton3);
    }

    private final void redirectToThreeDsScreen(String str, String str2) {
        Boolean bool;
        Context context = getContext();
        if (context != null) {
            Navigator.Companion companion = Navigator.Companion;
            Bundle bundle = new Bundle();
            bundle.putString("amount", ((EditText) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).getText().toString());
            WalletCalculateCashBackDisplayModel value = ((WalletTopUpViewModel) getViewModel()).getCalculatedCashBackData().getValue();
            Float f11 = null;
            if (value != null) {
                bool = Boolean.valueOf(value.isCampaignActive());
            } else {
                bool = null;
            }
            bundle.putBoolean(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE, BooleanKt.orFalse(bool));
            WalletCalculateCashBackDisplayModel value2 = ((WalletTopUpViewModel) getViewModel()).getCalculatedCashBackData().getValue();
            if (value2 != null) {
                f11 = Float.valueOf(value2.getAmount());
            }
            bundle.putFloat(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT, FloatKt.orZero(f11));
            bundle.putString(WalletNavigatorActions.WALLET_THREE_DS_URL_KEY, str);
            bundle.putString("transactionId", str2);
            Unit unit = Unit.INSTANCE;
            companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_THREE_DS_SCREEN, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
        }
    }

    private final void resetAllSuggestionButtons(ArrayList<Button> arrayList) {
        Iterator<Button> it = arrayList.iterator();
        while (it.hasNext()) {
            Button next = it.next();
            Context context = getContext();
            if (context != null) {
                next.setBackground(ContextCompat.getDrawable(context, R.drawable.wallet_top_up_amount_background));
                next.setTextColor(ContextCompat.getColor(context, com.talabat.wallet.R.color.wallet_menu_text_color));
            }
        }
    }

    private final void setDefaultAmount() {
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.cash_back_label)).setText(getResources().getString(com.talabat.localization.R.string.cash_back_label, new Object[]{IntegrationGlobalDataModel.Companion.getFormattedAmountWithCurrency(0.0f)}));
    }

    private final void setSubmitTopUpButtonText(String str, String str2) {
        String string = getString(com.talabat.localization.R.string.top_up_amount_with_currency);
        ((TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.submit_top_up_button)).setText(string + " " + str2 + " " + str);
    }

    private final void showCalculatedCashBack(float f11) {
        int i11 = com.talabat.wallet.R.id.cash_back_label;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i11)).setText(getResources().getString(com.talabat.localization.R.string.cash_back_label, new Object[]{String.valueOf(IntegrationGlobalDataModel.Companion.getFormattedAmountWithoutCurrency(f11))}));
    }

    private final void showLoader() {
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.cash_back_label)).setVisibility(4);
        ((AVLoadingIndicatorView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_loading)).setVisibility(0);
    }

    private final void submitTopUpButtonClickListeners() {
        ((TalabatFillButton) _$_findCachedViewById(com.talabat.wallet.R.id.submit_top_up_button)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: submitTopUpButtonClickListeners$lambda-2  reason: not valid java name */
    public static final void m6075submitTopUpButtonClickListeners$lambda2(WalletTopUpScreenFragment walletTopUpScreenFragment, View view) {
        Unit unit;
        Editable text;
        String obj;
        Float floatOrNull;
        Intrinsics.checkNotNullParameter(walletTopUpScreenFragment, "this$0");
        int i11 = com.talabat.wallet.R.id.submit_top_up_button;
        ((TalabatFillButton) walletTopUpScreenFragment._$_findCachedViewById(i11)).setEnabled(false);
        ((TalabatFillButton) walletTopUpScreenFragment._$_findCachedViewById(i11)).setAlpha(0.5f);
        FragmentActivity activity = walletTopUpScreenFragment.getActivity();
        if (activity != null) {
            ActivityKt.hideKeyBoard(activity);
        }
        walletTopUpScreenFragment.showProgress();
        EditText editText = (EditText) walletTopUpScreenFragment._$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount);
        if (editText == null || (text = editText.getText()) == null || (obj = text.toString()) == null || (floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(obj)) == null) {
            unit = null;
        } else {
            walletTopUpScreenFragment.topUpAmount(floatOrNull.floatValue());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            walletTopUpScreenFragment.setDefaultAmount();
        }
    }

    private final void topUpAmount(float f11) {
        String str;
        String str2;
        String str3;
        String string;
        if (f11 > 0.0f) {
            Context context = getContext();
            if (context != null) {
                WalletIntegrationAppTracker.Companion.onWalletTopUpAttempted(context, "Wallet Topup screen", "wallet", String.valueOf(f11));
            }
            Bundle arguments = getArguments();
            Integer num = null;
            if (arguments != null) {
                str = arguments.getString(WalletNavigatorActions.EXTRA_TOKEN_ID);
            } else {
                str = null;
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                str2 = arguments2.getString(WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
            } else {
                str2 = null;
            }
            Bundle arguments3 = getArguments();
            if (arguments3 != null) {
                str3 = arguments3.getString("cardType");
            } else {
                str3 = null;
            }
            Bundle arguments4 = getArguments();
            if (!(arguments4 == null || (string = arguments4.getString("binNumber")) == null)) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(string);
            }
            topUpWallet(str, str2, str3, num, f11);
            return;
        }
        setDefaultAmount();
    }

    private final void topUpWallet(String str, String str2, String str3, Integer num, float f11) {
        String str4;
        String str5;
        String str6;
        int countryId = getConfigurationLocalRepository().selectedCountry().getCountryId();
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        if (str2 == null) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if (str3 == null) {
            str6 = "";
        } else {
            str6 = str3;
        }
        WalletTopUpRequestModel walletTopUpRequestModel = new WalletTopUpRequestModel(f11, countryId, str4, str5, str6, PaymentMethod.CARD.getValue(), IntKt.orZero(num), WalletPaymentFeature.TOP_UP.getValue(), (String) null, 256, (DefaultConstructorMarker) null);
        WalletPaymentOptionViewModel walletPaymentOptionViewModel2 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel2 = null;
        }
        walletPaymentOptionViewModel2.topUpWallet(walletTopUpRequestModel);
    }

    /* access modifiers changed from: private */
    public final void updateCalculatedCashBack(WalletCalculateCashBackDisplayModel walletCalculateCashBackDisplayModel) {
        if (walletCalculateCashBackDisplayModel != null && walletCalculateCashBackDisplayModel.isCampaignActive()) {
            showCalculatedCashBack(walletCalculateCashBackDisplayModel.getAmount());
        }
    }

    /* access modifiers changed from: private */
    public final void updateCashBackLoader(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            showLoader();
        } else {
            hideLoader();
        }
    }

    /* access modifiers changed from: private */
    public final void updatePaymentStatus(WalletPaymentDisplayModel walletPaymentDisplayModel) {
        if (walletPaymentDisplayModel != null) {
            hideProgress();
            int i11 = WhenMappings.$EnumSwitchMapping$0[walletPaymentDisplayModel.getWalletTransactionStatus().ordinal()];
            if (i11 == 1) {
                onTopUpFailure(walletPaymentDisplayModel.getErrorMessage(), walletPaymentDisplayModel.getErrorType());
            } else if (i11 == 2) {
                onTopUpSuccess();
            } else if (i11 != 3) {
                LogManager.debug("unexpected transaction type");
            } else {
                redirectToThreeDsScreen(walletPaymentDisplayModel.getRedirectUrl(), walletPaymentDisplayModel.getWalletTransactionId());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateSuggestionButtons(WalletSuggestionButtonsDisplayModel walletSuggestionButtonsDisplayModel) {
        if (walletSuggestionButtonsDisplayModel != null && walletSuggestionButtonsDisplayModel.getResetAllSuggestionButtons()) {
            ArrayList<Button> arrayList = this.buttons;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttons");
                arrayList = null;
            }
            resetAllSuggestionButtons(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public final void updateTopUpButtons(WalletTopUpButtonDisplayModel walletTopUpButtonDisplayModel) {
        String str;
        if (walletTopUpButtonDisplayModel != null) {
            WalletTopUpCtaState walletTopUpCtaState = walletTopUpButtonDisplayModel.getWalletTopUpCtaState();
            if (Intrinsics.areEqual((Object) walletTopUpCtaState, (Object) WalletTopUpCtaState.Disabled.INSTANCE)) {
                disableTopUpButton();
            } else if (Intrinsics.areEqual((Object) walletTopUpCtaState, (Object) WalletTopUpCtaState.Clear.INSTANCE)) {
                clearTopUpButton();
            } else if (Intrinsics.areEqual((Object) walletTopUpCtaState, (Object) WalletTopUpCtaState.Enabled.INSTANCE)) {
                String walletTopUpAmount = walletTopUpButtonDisplayModel.getWalletTopUpAmount();
                Country selectedCountry = getLocationConfigurationRepository().selectedCountry();
                if (selectedCountry != null) {
                    str = selectedCountry.getCurrencyCode();
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                setSubmitTopUpButtonText(walletTopUpAmount, str);
                enableTopUpButton();
            }
        }
    }

    private final void updateTopUpEditText(Button button, EditText editText) {
        ArrayList<Button> arrayList = this.buttons;
        String str = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttons");
            arrayList = null;
        }
        resetAllSuggestionButtons(arrayList);
        activateButton(button);
        editText.setText(button.getText());
        editText.requestFocus();
        editText.setSelection(editText.getText().length());
        WalletPaymentOptionViewModel walletPaymentOptionViewModel2 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel2 = null;
        }
        ((TextView) _$_findCachedViewById(com.talabat.wallet.R.id.cash_back_label)).setText(getResources().getString(com.talabat.localization.R.string.cash_back_label, new Object[]{String.valueOf(IntegrationGlobalDataModel.Companion.getFormattedAmountWithoutCurrency(FloatKt.orZero(walletPaymentOptionViewModel2.getAmountCashBackMap().get(button.getText()))))}));
        enableTopUpButton();
        String obj = button.getText().toString();
        Country selectedCountry = getLocationConfigurationRepository().selectedCountry();
        if (selectedCountry != null) {
            str = selectedCountry.getCurrencyCode();
        }
        if (str == null) {
            str = "";
        }
        setSubmitTopUpButtonText(obj, str);
    }

    /* access modifiers changed from: private */
    public final void updateWalletTopUpSuggestionAndLimits(WalletTopUpSuggestionsAndLimitsDisplayModel walletTopUpSuggestionsAndLimitsDisplayModel) {
        String str;
        if (walletTopUpSuggestionsAndLimitsDisplayModel != null) {
            hideProgress();
            if (!(walletTopUpSuggestionsAndLimitsDisplayModel.getMinTopUpAmount() == 0 || walletTopUpSuggestionsAndLimitsDisplayModel.getMaxTopUpAmount() == 0)) {
                WalletPaymentOptionViewModel walletPaymentOptionViewModel2 = this.walletPaymentOptionViewModel;
                if (walletPaymentOptionViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
                    walletPaymentOptionViewModel2 = null;
                }
                walletPaymentOptionViewModel2.setTopUpMinimumAmount(walletTopUpSuggestionsAndLimitsDisplayModel.getMinTopUpAmount());
                WalletPaymentOptionViewModel walletPaymentOptionViewModel3 = this.walletPaymentOptionViewModel;
                if (walletPaymentOptionViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
                    walletPaymentOptionViewModel3 = null;
                }
                walletPaymentOptionViewModel3.setTopUpMaximumAmount(walletTopUpSuggestionsAndLimitsDisplayModel.getMaxTopUpAmount());
                int i11 = com.talabat.wallet.R.id.max_min_amount;
                ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
                TextView textView = (TextView) _$_findCachedViewById(i11);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Locale locale = Locale.ENGLISH;
                String string = getString(com.talabat.localization.R.string.wallet_card_dashboard_top_up_limit);
                Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…d_dashboard_top_up_limit)");
                Object[] objArr = new Object[3];
                Country selectedCountry = getLocationConfigurationRepository().selectedCountry();
                if (selectedCountry != null) {
                    str = selectedCountry.getCurrencyCode();
                } else {
                    str = null;
                }
                objArr[0] = str;
                objArr[1] = Integer.valueOf(walletTopUpSuggestionsAndLimitsDisplayModel.getMinTopUpAmount());
                objArr[2] = Integer.valueOf(walletTopUpSuggestionsAndLimitsDisplayModel.getMaxTopUpAmount());
                String format = String.format(locale, string, Arrays.copyOf(objArr, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                textView.setText(format);
            }
            int i12 = 0;
            for (WalletTopUpAmountSuggestionDisplayModel next : walletTopUpSuggestionsAndLimitsDisplayModel.getSuggestionsList()) {
                int i13 = i12 + 1;
                ArrayList<Button> arrayList = this.buttons;
                if (arrayList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buttons");
                    arrayList = null;
                }
                arrayList.get(i12).setVisibility(0);
                ArrayList<Button> arrayList2 = this.buttons;
                if (arrayList2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buttons");
                    arrayList2 = null;
                }
                arrayList2.get(i12).setText(String.valueOf((int) next.getAmount()));
                i12 = i13;
            }
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
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
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

    public int layoutId() {
        return com.talabat.wallet.R.layout.fragment_wallet_top_up_screen;
    }

    public void observatory() {
        WalletPaymentOptionViewModel walletPaymentOptionViewModel2 = this.walletPaymentOptionViewModel;
        WalletPaymentOptionViewModel walletPaymentOptionViewModel3 = null;
        if (walletPaymentOptionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel2 = null;
        }
        LifecycleKt.observe(this, walletPaymentOptionViewModel2.getWalletTopUpSuggestionAndLimitsData(), new WalletTopUpScreenFragment$observatory$1(this));
        LifecycleKt.observe(this, ((WalletTopUpViewModel) getViewModel()).getCalculatedCashBackData(), new WalletTopUpScreenFragment$observatory$2(this));
        LifecycleKt.observe(this, ((WalletTopUpViewModel) getViewModel()).getCalculateCashBackLoaderData(), new WalletTopUpScreenFragment$observatory$3(this));
        WalletPaymentOptionViewModel walletPaymentOptionViewModel4 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel4 = null;
        }
        LifecycleKt.observe(this, walletPaymentOptionViewModel4.getWalletTopUpData(), new WalletTopUpScreenFragment$observatory$4(this));
        WalletPaymentOptionViewModel walletPaymentOptionViewModel5 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel5 = null;
        }
        LifecycleKt.observe(this, walletPaymentOptionViewModel5.getFailureData(), new WalletTopUpScreenFragment$observatory$5(this));
        WalletPaymentOptionViewModel walletPaymentOptionViewModel6 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel6 = null;
        }
        LifecycleKt.observe(this, walletPaymentOptionViewModel6.getWalletTopUpButtonData(), new WalletTopUpScreenFragment$observatory$6(this));
        WalletPaymentOptionViewModel walletPaymentOptionViewModel7 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
        } else {
            walletPaymentOptionViewModel3 = walletPaymentOptionViewModel7;
        }
        LifecycleKt.observe(this, walletPaymentOptionViewModel3.getWalletSuggestionButtonsData(), new WalletTopUpScreenFragment$observatory$7(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerWalletTopUpScreenFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Context context = getContext();
        if (context != null) {
            this.walletPaymentOptionViewModel = WalletPaymentOptionViewModelBuilder.Companion.getWalletPaymentOptionViewModel(context, getCoroutineScope());
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        boolean z11;
        super.onResume();
        Editable text = ((EditText) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).getText();
        if (text == null || text.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            enableTopUpButton();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        showProgress();
        populateButtons();
        ArrayList<Button> arrayList = this.buttons;
        String str = null;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttons");
            arrayList = null;
        }
        resetAllSuggestionButtons(arrayList);
        WalletPaymentOptionViewModel walletPaymentOptionViewModel2 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel2 = null;
        }
        WalletPaymentOptionViewModel.getWalletTopUpSuggestionsAndLimits$default(walletPaymentOptionViewModel2, 0, 1, (Object) null);
        getCalculatedCashBack("0");
        ((EditText) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_amount)).requestFocus();
        disableTopUpButton();
        TextView textView = (TextView) _$_findCachedViewById(com.talabat.wallet.R.id.top_up_currency);
        Country selectedCountry = getLocationConfigurationRepository().selectedCountry();
        if (selectedCountry != null) {
            str = selectedCountry.getCurrencyCode();
        }
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        addButtonClickListeners();
        addTextChangeListener();
        submitTopUpButtonClickListeners();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlag = iTalabatFeatureFlag;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setTalabatTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "<set-?>");
        this.talabatTracker = talabatTracker2;
    }

    @NotNull
    public WalletTopUpViewModel viewModelBuilder() {
        WalletTopUpViewModelBuilder.Companion companion = WalletTopUpViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getWalletTopUpViewModel(requireContext, getCoroutineScope(), getConfigurationLocalRepository(), getFeatureFlag(), getTalabatTracker());
    }
}
