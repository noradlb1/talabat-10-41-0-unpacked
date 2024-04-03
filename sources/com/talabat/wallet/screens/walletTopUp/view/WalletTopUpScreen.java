package com.talabat.wallet.screens.walletTopUp.view;

import JsonModels.Response.WalletCalculateCashBackResult;
import JsonModels.Response.WalletTopUpAmountSuggestion;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.R;
import com.talabat.TalabatEditText;
import com.talabat.TalabatTextView;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.splash.core.extension.LifeCycleKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletPaymentFeature;
import com.talabat.talabatcommon.feature.walletPayment.model.request.WalletTopUpRequestModel;
import com.talabat.talabatcommon.feature.walletPayment.model.response.WalletPaymentTransactionStatus;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModelBuilder;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModelImpl;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.helpers.ResponseStatus;
import com.talabat.wallet.helpers.ResponseStatusInterface;
import com.talabat.wallet.helpers.WalletFormatterInterface;
import com.talabat.wallet.screens.walletTopUp.presenter.WalletTopUpPresenter;
import com.talabat.wallet.screens.walletTopUp.view.di.DaggerWalletTopUpScreenComponent;
import com.talabat.wallet.screens.walletTopUpResponse.view.WalletTopUpResponseScreen;
import com.talabat.wallet.ui.paymentThreeDs.view.WalletPaymentThreeDsActivity;
import com.wang.avi.AVLoadingIndicatorView;
import fy.a;
import fy.b;
import fy.c;
import fy.d;
import fy.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001dH\u0002J\b\u0010=\u001a\u00020>H\u0002J(\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0002J\b\u0010E\u001a\u00020;H\u0016J\b\u0010F\u001a\u00020;H\u0002J\b\u0010G\u001a\u00020;H\u0002J\n\u0010H\u001a\u0004\u0018\u000107H\u0016J\b\u0010I\u001a\u00020\u0007H\u0016J\b\u0010J\u001a\u00020;H\u0016J\u0012\u0010K\u001a\u00020;2\b\u0010L\u001a\u0004\u0018\u00010@H\u0014J\b\u0010M\u001a\u00020;H\u0016J\b\u0010N\u001a\u00020;H\u0016J\u0010\u0010O\u001a\u00020;2\u0006\u0010P\u001a\u00020\u0007H\u0016J\b\u0010Q\u001a\u00020;H\u0016J\b\u0010R\u001a\u00020;H\u0016J\b\u0010S\u001a\u00020;H\u0016J\u0012\u0010T\u001a\u00020;2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002J\u0018\u0010W\u001a\u00020;2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0002J \u0010X\u001a\u00020;2\u0016\u0010Y\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eH\u0002J\b\u0010Z\u001a\u00020;H\u0002J\b\u0010[\u001a\u00020;H\u0016J\b\u0010\\\u001a\u00020;H\u0016J\u0012\u0010]\u001a\u00020;2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0016\u0010`\u001a\u00020;2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bH\u0016J\b\u0010d\u001a\u00020;H\u0016J=\u0010e\u001a\u00020;2\b\u0010f\u001a\u0004\u0018\u00010\u00072\b\u0010g\u001a\u0004\u0018\u00010\u00072\b\u0010h\u001a\u0004\u0018\u00010\u00072\b\u0010i\u001a\u0004\u0018\u00010-2\u0006\u0010j\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010kJ\u0012\u0010l\u001a\u00020;2\b\u0010m\u001a\u0004\u0018\u00010nH\u0002J\u0018\u0010o\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001d2\u0006\u0010p\u001a\u00020qH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u000e\u0010\u000f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u000e\u0010\u0013\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R2\u0010\u0016\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0018`\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-XD¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u001e\u00100\u001a\u0002018\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X.¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUp/view/WalletTopUpScreen;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/wallet/screens/walletTopUp/view/WalletTopUpView;", "Lcom/talabat/wallet/helpers/WalletFormatterInterface;", "Lcom/talabat/wallet/helpers/ResponseStatusInterface;", "()V", "AMOUNT", "", "CURRENCY", "EMPTY_STRING", "getEMPTY_STRING", "()Ljava/lang/String;", "ERROR", "INPUT_DATE_FORMAT", "getINPUT_DATE_FORMAT", "MESSAGE", "ONE_SPACE", "OUT_DATE_FORMAT", "getOUT_DATE_FORMAT", "STATUS", "SUCCESS", "ZERO_STRING", "amountCashBackMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "amountCurrency", "buttons", "Ljava/util/ArrayList;", "Landroid/widget/Button;", "Lkotlin/collections/ArrayList;", "cashBack", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "eventType", "", "isCampaignAvailable", "", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mWalletTopUpPresenter", "Lcom/talabat/wallet/screens/walletTopUp/presenter/WalletTopUpPresenter;", "walletPaymentOptionViewModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel;", "activateButton", "", "button", "addThreeDsIntent", "Landroid/content/Intent;", "addThreeDsResponseScreenBundle", "Landroid/os/Bundle;", "successScreenAction", "errorScreenAction", "threeDsUrl", "transactionId", "destroyPresenter", "disableTopUpButton", "enableTopUpButton", "getPresenter", "getScreenName", "onAuthError", "onCreate", "savedInstanceState", "onError", "onServerError", "onTopUpFailure", "message", "onTopUpServerError", "onTopUpSuccess", "onTopUpSuggestionError", "onWalletPaymentError", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "redirectToThreeDsScreen", "resetAllButtons", "buttonArray", "setDefaultTopUpAmount", "setEmptyWalletTopUpSuggestion", "setUpTopupLoader", "setWalletCalculatedCashBack", "walletCalculateCashBackResult", "LJsonModels/Response/WalletCalculateCashBackResult;", "setWalletTopUpAmountSuggestion", "walletTopUpAmountSuggestionList", "", "LJsonModels/Response/WalletTopUpAmountSuggestion;", "setupViewsBeforeServiceRequest", "topUpWallet", "tokenId", "card4Digits", "cardType", "binNumber", "amount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;F)V", "updatePaymentStatus", "walletPaymentDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentDisplayModel;", "updateTopUpEditText", "editText", "Landroid/widget/EditText;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpScreen extends TalabatBase implements WalletTopUpView, WalletFormatterInterface, ResponseStatusInterface {
    @NotNull
    private final String AMOUNT = "amount";
    @NotNull
    private final String CURRENCY = "currency";
    @NotNull
    private final String EMPTY_STRING = "";
    @NotNull
    private final String ERROR = "error";
    @NotNull
    private final String INPUT_DATE_FORMAT = DateConstants.DEFAULT_UTC_FORMAT;
    @NotNull
    private final String MESSAGE = "message";
    @NotNull
    private final String ONE_SPACE = " ";
    @NotNull
    private final String OUT_DATE_FORMAT = "yyyy-MM";
    @NotNull
    private final String STATUS = "status";
    @NotNull
    private final String SUCCESS = "success";
    /* access modifiers changed from: private */
    @NotNull
    public final String ZERO_STRING = "0";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final HashMap<String, Float> amountCashBackMap = new HashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public String amountCurrency = "";
    /* access modifiers changed from: private */
    public ArrayList<Button> buttons;
    private float cashBack;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private CoroutineScope coroutineScope = new WalletTopUpScreen$coroutineScope$1();
    /* access modifiers changed from: private */
    public final int eventType = 4;
    private boolean isCampaignAvailable;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    /* access modifiers changed from: private */
    @Nullable
    public WalletTopUpPresenter mWalletTopUpPresenter;
    private WalletPaymentOptionViewModel walletPaymentOptionViewModel;

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
        button.setBackground(getResources().getDrawable(R.drawable.wallet_top_up_amount_background_selected));
        button.setTextColor(getResources().getColor(R.color.white));
    }

    private final Intent addThreeDsIntent() {
        Intent intent = new Intent(this, WalletPaymentThreeDsActivity.class);
        intent.putExtra(this.CURRENCY, this.amountCurrency);
        intent.putExtra(this.AMOUNT, ((TalabatEditText) _$_findCachedViewById(R.id.top_up_amount)).getText().toString());
        intent.putExtra(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE, this.isCampaignAvailable);
        intent.putExtra(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT, this.cashBack);
        return intent;
    }

    private final Bundle addThreeDsResponseScreenBundle(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(WalletNavigatorActions.WALLET_PAYMENT_SUCCESS_SCREEN_KEY, str);
        bundle.putString(WalletNavigatorActions.WALLET_PAYMENT_ERROR_SCREEN_KEY, str2);
        bundle.putString(WalletNavigatorActions.WALLET_THREE_DS_URL_KEY, str3);
        bundle.putString("transactionId", str4);
        return bundle;
    }

    /* access modifiers changed from: private */
    public final void disableTopUpButton() {
        int i11 = R.id.submit_top_up_button;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setEnabled(false);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setAlpha(0.5f);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setText(getString(R.string.top_up_with_currency));
    }

    /* access modifiers changed from: private */
    public final void enableTopUpButton() {
        int i11 = R.id.submit_top_up_button;
        ((TalabatFillButton) _$_findCachedViewById(i11)).setEnabled(true);
        ((TalabatFillButton) _$_findCachedViewById(i11)).setAlpha(1.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m5994onCreate$lambda0(WalletTopUpScreen walletTopUpScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpScreen, "this$0");
        if (view != null) {
            TalabatEditText talabatEditText = (TalabatEditText) walletTopUpScreen._$_findCachedViewById(R.id.top_up_amount);
            Intrinsics.checkNotNullExpressionValue(talabatEditText, "top_up_amount");
            walletTopUpScreen.updateTopUpEditText((Button) view, talabatEditText);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m5995onCreate$lambda1(WalletTopUpScreen walletTopUpScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpScreen, "this$0");
        if (view != null) {
            TalabatEditText talabatEditText = (TalabatEditText) walletTopUpScreen._$_findCachedViewById(R.id.top_up_amount);
            Intrinsics.checkNotNullExpressionValue(talabatEditText, "top_up_amount");
            walletTopUpScreen.updateTopUpEditText((Button) view, talabatEditText);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m5996onCreate$lambda2(WalletTopUpScreen walletTopUpScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpScreen, "this$0");
        if (view != null) {
            TalabatEditText talabatEditText = (TalabatEditText) walletTopUpScreen._$_findCachedViewById(R.id.top_up_amount);
            Intrinsics.checkNotNullExpressionValue(talabatEditText, "top_up_amount");
            walletTopUpScreen.updateTopUpEditText((Button) view, talabatEditText);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m5997onCreate$lambda3(WalletTopUpScreen walletTopUpScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpScreen, "this$0");
        walletTopUpScreen.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-5  reason: not valid java name */
    public static final void m5998onCreate$lambda5(WalletTopUpScreen walletTopUpScreen, String str, String str2, String str3, String str4, View view) {
        Float f11;
        Editable text;
        String obj;
        Float floatOrNull;
        String str5;
        Editable text2;
        Editable text3;
        String obj2;
        WalletTopUpScreen walletTopUpScreen2 = walletTopUpScreen;
        Intrinsics.checkNotNullParameter(walletTopUpScreen, "this$0");
        int i11 = R.id.submit_top_up_button;
        ((TalabatFillButton) walletTopUpScreen._$_findCachedViewById(i11)).setEnabled(false);
        ((TalabatFillButton) walletTopUpScreen._$_findCachedViewById(i11)).setAlpha(0.5f);
        walletTopUpScreen.startLodingPopup();
        int i12 = R.id.top_up_amount;
        TalabatEditText talabatEditText = (TalabatEditText) walletTopUpScreen._$_findCachedViewById(i12);
        Integer num = null;
        if (talabatEditText == null || (text3 = talabatEditText.getText()) == null || (obj2 = text3.toString()) == null) {
            f11 = null;
        } else {
            f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(obj2);
        }
        if (f11 == null) {
            ((TalabatTextView) walletTopUpScreen._$_findCachedViewById(R.id.cash_back_label)).setText(walletTopUpScreen.getResources().getString(R.string.wallet_cash_back_label, new Object[]{walletTopUpScreen2.amountCurrency, walletTopUpScreen.getAmountWithoutCurrency(Float.valueOf(0.0f))}));
            walletTopUpScreen.disableTopUpButton();
        }
        TalabatEditText talabatEditText2 = (TalabatEditText) walletTopUpScreen._$_findCachedViewById(i12);
        if (talabatEditText2 != null && (text = talabatEditText2.getText()) != null && (obj = text.toString()) != null && (floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(obj)) != null) {
            float floatValue = floatOrNull.floatValue();
            if (floatValue > 0.0f) {
                Context context = walletTopUpScreen.getContext();
                String screenName = walletTopUpScreen.getScreenName();
                TalabatEditText talabatEditText3 = (TalabatEditText) walletTopUpScreen._$_findCachedViewById(i12);
                if (talabatEditText3 == null || (text2 = talabatEditText3.getText()) == null) {
                    str5 = null;
                } else {
                    str5 = text2.toString();
                }
                AppTracker.onWalletTopupAttempted(context, screenName, "wallet", str5);
                if (str != null) {
                    num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                }
                walletTopUpScreen.topUpWallet(str2, str3, str4, num, floatValue);
                return;
            }
            ((TalabatTextView) walletTopUpScreen._$_findCachedViewById(R.id.cash_back_label)).setText(walletTopUpScreen.getResources().getString(R.string.wallet_cash_back_label, new Object[]{walletTopUpScreen2.amountCurrency, "0.0"}));
            walletTopUpScreen.disableTopUpButton();
        }
    }

    /* access modifiers changed from: private */
    public final void onWalletPaymentError(Failure failure) {
        stopLodingPopup();
        Status.Companion companion = Status.Companion;
        String string = getResources().getString(R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, this, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
        enableTopUpButton();
    }

    private final void redirectToThreeDsScreen(String str, String str2) {
        Intent addThreeDsIntent = addThreeDsIntent();
        addThreeDsIntent.putExtras(addThreeDsResponseScreenBundle(WalletNavigatorActions.WALLET_TOP_UP_RESPONSE_ACTION, WalletNavigatorActions.WALLET_TOP_UP_RESPONSE_ACTION, str, str2));
        startActivity(addThreeDsIntent);
    }

    /* access modifiers changed from: private */
    public final void resetAllButtons(ArrayList<Button> arrayList) {
        Iterator<Button> it = arrayList.iterator();
        while (it.hasNext()) {
            Button next = it.next();
            next.setBackground(getResources().getDrawable(R.drawable.wallet_top_up_amount_background));
            next.setTextColor(getResources().getColor(R.color.wallet_menu_text_color));
        }
    }

    private final void setDefaultTopUpAmount() {
        ((TalabatTextView) _$_findCachedViewById(R.id.cash_back_label)).setText(getResources().getString(R.string.wallet_cash_back_label, new Object[]{this.amountCurrency, getAmountWithoutCurrency(Float.valueOf(0.0f))}));
    }

    private final void topUpWallet(String str, String str2, String str3, Integer num, float f11) {
        String str4;
        String str5;
        String str6;
        int i11 = GlobalDataModel.SelectedCountryId;
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
        WalletTopUpRequestModel walletTopUpRequestModel = new WalletTopUpRequestModel(f11, i11, str4, str5, str6, PaymentMethod.CARD.getValue(), IntKt.orZero(num), WalletPaymentFeature.TOP_UP.getValue(), (String) null, 256, (DefaultConstructorMarker) null);
        WalletPaymentOptionViewModel walletPaymentOptionViewModel2 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel2 = null;
        }
        walletPaymentOptionViewModel2.topUpWallet(walletTopUpRequestModel);
    }

    /* access modifiers changed from: private */
    public final void updatePaymentStatus(WalletPaymentDisplayModel walletPaymentDisplayModel) {
        stopLodingPopup();
        if (walletPaymentDisplayModel != null) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[walletPaymentDisplayModel.getWalletTransactionStatus().ordinal()];
            if (i11 == 1) {
                onTopUpFailure(walletPaymentDisplayModel.getErrorMessage());
            } else if (i11 == 2) {
                onTopUpSuccess();
            } else if (i11 != 3) {
                LogManager.debug("unexpected transaction type");
            } else {
                redirectToThreeDsScreen(walletPaymentDisplayModel.getRedirectUrl(), walletPaymentDisplayModel.getWalletTransactionId());
            }
        }
    }

    private final void updateTopUpEditText(Button button, EditText editText) {
        ArrayList<Button> arrayList = this.buttons;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttons");
            arrayList = null;
        }
        resetAllButtons(arrayList);
        activateButton(button);
        editText.setText(button.getText());
        editText.requestFocus();
        editText.setSelection(editText.getText().length());
        ((TalabatTextView) _$_findCachedViewById(R.id.cash_back_label)).setText(getResources().getString(R.string.wallet_cash_back_label, new Object[]{this.amountCurrency, String.valueOf(this.amountCashBackMap.get(button.getText()))}));
        enableTopUpButton();
        if (TalabatUtils.isArabic()) {
            String string = getString(R.string.top_up_with_currency);
            CharSequence text = button.getText();
            String str = this.amountCurrency;
            ((TalabatFillButton) _$_findCachedViewById(R.id.submit_top_up_button)).setText(string + " " + text + " " + str);
            return;
        }
        String string2 = getString(R.string.top_up_with_currency);
        String str2 = this.amountCurrency;
        CharSequence text2 = button.getText();
        ((TalabatFillButton) _$_findCachedViewById(R.id.submit_top_up_button)).setText(string2 + " " + str2 + " " + text2);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public String dateFormatter(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        return WalletFormatterInterface.DefaultImpls.dateFormatter(this, str, str2, str3);
    }

    public void destroyPresenter() {
        this.mWalletTopUpPresenter = null;
    }

    @NotNull
    public String formatAmountWithSign(@Nullable Float f11, boolean z11, boolean z12) {
        return WalletFormatterInterface.DefaultImpls.formatAmountWithSign(this, f11, z11, z12);
    }

    @NotNull
    public String getAmountSign(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountSign(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrency(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountWithoutCurrency(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrencyWithSign(@Nullable Float f11) {
        return WalletFormatterInterface.DefaultImpls.getAmountWithoutCurrencyWithSign(this, f11);
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
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @NotNull
    public String getCurrencyLocale() {
        return WalletFormatterInterface.DefaultImpls.getCurrencyLocale(this);
    }

    @NotNull
    public String getEMPTY_STRING() {
        return this.EMPTY_STRING;
    }

    @NotNull
    public String getINPUT_DATE_FORMAT() {
        return this.INPUT_DATE_FORMAT;
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
    public String getMonthAndYearForMapingAndGrouping(@Nullable String str) {
        return WalletFormatterInterface.DefaultImpls.getMonthAndYearForMapingAndGrouping(this, str);
    }

    @NotNull
    public String getOUT_DATE_FORMAT() {
        return this.OUT_DATE_FORMAT;
    }

    @NotNull
    public String getScreenName() {
        return "Wallet Topup screen";
    }

    public void makeSnackBar(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus) {
        ResponseStatusInterface.DefaultImpls.makeSnackBar(this, view, context, str, responseStatus);
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerWalletTopUpScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wallet_top_up_screen);
        WalletPaymentOptionViewModelImpl walletPaymentOptionViewModel2 = WalletPaymentOptionViewModelBuilder.Companion.getWalletPaymentOptionViewModel(this, this.coroutineScope);
        this.walletPaymentOptionViewModel = walletPaymentOptionViewModel2;
        Integer num = null;
        if (walletPaymentOptionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel2 = null;
        }
        LifeCycleKt.observe(this, walletPaymentOptionViewModel2.getWalletTopUpData(), new WalletTopUpScreen$onCreate$1(this));
        WalletPaymentOptionViewModel walletPaymentOptionViewModel3 = this.walletPaymentOptionViewModel;
        if (walletPaymentOptionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("walletPaymentOptionViewModel");
            walletPaymentOptionViewModel3 = null;
        }
        LifeCycleKt.observe(this, walletPaymentOptionViewModel3.getFailureData(), new WalletTopUpScreen$onCreate$2(this));
        String stringExtra = getIntent().getStringExtra(WalletNavigatorActions.EXTRA_TOKEN_ID);
        String stringExtra2 = getIntent().getStringExtra(WalletNavigatorActions.EXTRA_CARD_4_DIGITS);
        String stringExtra3 = getIntent().getStringExtra("cardType");
        String stringExtra4 = getIntent().getStringExtra("binNumber");
        int i11 = R.id.top_up_amount;
        ((TalabatEditText) _$_findCachedViewById(i11)).requestFocus();
        int i12 = R.id.submit_top_up_button;
        ((TalabatFillButton) _$_findCachedViewById(i12)).setEnabled(false);
        ((TalabatFillButton) _$_findCachedViewById(i12)).setAlpha(0.5f);
        int i13 = R.id.first_select_amount_button;
        TalabatFillButton talabatFillButton = (TalabatFillButton) _$_findCachedViewById(i13);
        Intrinsics.checkNotNullExpressionValue(talabatFillButton, "first_select_amount_button");
        int i14 = R.id.second_select_amount_button;
        TalabatFillButton talabatFillButton2 = (TalabatFillButton) _$_findCachedViewById(i14);
        Intrinsics.checkNotNullExpressionValue(talabatFillButton2, "second_select_amount_button");
        int i15 = R.id.third_select_amount_button;
        TalabatFillButton talabatFillButton3 = (TalabatFillButton) _$_findCachedViewById(i15);
        Intrinsics.checkNotNullExpressionValue(talabatFillButton3, "third_select_amount_button");
        ArrayList<Button> arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(talabatFillButton, talabatFillButton2, talabatFillButton3);
        this.buttons = arrayListOf;
        if (arrayListOf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttons");
            arrayListOf = null;
        }
        resetAllButtons(arrayListOf);
        this.mWalletTopUpPresenter = new WalletTopUpPresenter(getLocationConfigurationRepository(), this, getConfigurationLocalRepository());
        this.amountCurrency = getCurrencyLocale();
        ((TalabatTextView) _$_findCachedViewById(R.id.top_up_currency)).setText(this.amountCurrency);
        WalletTopUpPresenter walletTopUpPresenter = this.mWalletTopUpPresenter;
        if (walletTopUpPresenter != null) {
            String str = this.ZERO_STRING;
            Integer valueOf = Integer.valueOf(this.eventType);
            if (stringExtra4 != null) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(stringExtra4);
            }
            walletTopUpPresenter.getWalletCalculatedCashBack(str, valueOf, num);
        }
        ((TalabatEditText) _$_findCachedViewById(i11)).addTextChangedListener(new WalletTopUpScreen$onCreate$3(this, stringExtra4));
        ((TalabatFillButton) _$_findCachedViewById(i13)).setOnClickListener(new a(this));
        ((TalabatFillButton) _$_findCachedViewById(i14)).setOnClickListener(new b(this));
        ((TalabatFillButton) _$_findCachedViewById(i15)).setOnClickListener(new c(this));
        ((ImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new d(this));
        WalletTopUpPresenter walletTopUpPresenter2 = this.mWalletTopUpPresenter;
        if (walletTopUpPresenter2 != null) {
            walletTopUpPresenter2.setWalletAmountTopUp();
        }
        ((TalabatFillButton) _$_findCachedViewById(i12)).setOnClickListener(new e(this, stringExtra4, stringExtra, stringExtra2, stringExtra3));
    }

    public void onError() {
    }

    public void onServerError() {
        ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.top_up_loading)).setVisibility(4);
        stopLodingPopup();
        enableTopUpButton();
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "root_view");
        String string = getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.server_error_msg)");
        makeSnackBar(relativeLayout, this, string, ResponseStatus.ERROR);
        ((TalabatEditText) _$_findCachedViewById(R.id.top_up_amount)).requestFocus();
    }

    public void onTopUpFailure(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "message");
        Intent intent = new Intent(this, WalletTopUpResponseScreen.class);
        intent.putExtra(this.STATUS, this.ERROR);
        intent.putExtra(this.CURRENCY, this.amountCurrency);
        intent.putExtra(this.AMOUNT, ((TalabatEditText) _$_findCachedViewById(R.id.top_up_amount)).getText().toString());
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            intent.putExtra(this.MESSAGE, getResources().getString(R.string.wallet_generic_error_message));
        } else {
            intent.putExtra(this.MESSAGE, str);
        }
        startActivity(intent);
        finish();
    }

    public void onTopUpServerError() {
        ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.top_up_loading)).setVisibility(4);
    }

    public void onTopUpSuccess() {
        Intent intent = new Intent(this, WalletTopUpResponseScreen.class);
        intent.putExtra(this.STATUS, this.SUCCESS);
        intent.putExtra(this.CURRENCY, this.amountCurrency);
        intent.putExtra(this.AMOUNT, ((TalabatEditText) _$_findCachedViewById(R.id.top_up_amount)).getText().toString());
        intent.putExtra(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE, this.isCampaignAvailable);
        intent.putExtra(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT, this.cashBack);
        startActivity(intent);
        finish();
    }

    public void onTopUpSuggestionError() {
        stopLodingPopup();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "<set-?>");
        this.coroutineScope = coroutineScope2;
    }

    public void setEmptyWalletTopUpSuggestion() {
        ArrayList<Button> arrayList = this.buttons;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttons");
            arrayList = null;
        }
        Iterator<Button> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(4);
        }
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public void setUpTopupLoader() {
        if (this.isCampaignAvailable) {
            ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.top_up_loading)).setVisibility(0);
        }
        ((TalabatTextView) _$_findCachedViewById(R.id.cash_back_label)).setVisibility(4);
    }

    public void setWalletCalculatedCashBack(@Nullable WalletCalculateCashBackResult walletCalculateCashBackResult) {
        Float amount;
        Float f11;
        Float f12;
        boolean z11;
        String obj;
        String obj2;
        Float amount2;
        boolean z12 = true;
        if (!(walletCalculateCashBackResult == null || (amount2 = walletCalculateCashBackResult.getAmount()) == null)) {
            float floatValue = amount2.floatValue();
            if (walletCalculateCashBackResult.isCampaignActive() != null) {
                Boolean isCampaignActive = walletCalculateCashBackResult.isCampaignActive();
                Intrinsics.checkNotNull(isCampaignActive);
                if (isCampaignActive.booleanValue()) {
                    Boolean isCampaignActive2 = walletCalculateCashBackResult.isCampaignActive();
                    Intrinsics.checkNotNull(isCampaignActive2);
                    this.isCampaignAvailable = isCampaignActive2.booleanValue();
                    this.cashBack = floatValue;
                    int i11 = R.id.cash_back_label;
                    ((TalabatTextView) _$_findCachedViewById(i11)).setVisibility(0);
                    ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.top_up_loading)).setVisibility(4);
                    if (TalabatUtils.isArabic()) {
                        ((TalabatTextView) _$_findCachedViewById(i11)).setText(getResources().getString(R.string.wallet_cash_back_label, new Object[]{this.amountCurrency, "+ " + getAmountWithoutCurrency(Float.valueOf(floatValue))}));
                    } else {
                        ((TalabatTextView) _$_findCachedViewById(i11)).setText(getResources().getString(R.string.wallet_cash_back_label, new Object[]{this.amountCurrency, getAmountWithoutCurrency(Float.valueOf(floatValue))}));
                    }
                }
            }
            ((TalabatTextView) _$_findCachedViewById(R.id.cash_back_label)).setVisibility(4);
            ((AVLoadingIndicatorView) _$_findCachedViewById(R.id.top_up_loading)).setVisibility(4);
        }
        int i12 = R.id.top_up_amount;
        ((TalabatEditText) _$_findCachedViewById(i12)).requestFocus();
        ((TalabatEditText) _$_findCachedViewById(i12)).setSelection(((TalabatEditText) _$_findCachedViewById(i12)).getText().length());
        Editable editable = null;
        if (!(walletCalculateCashBackResult == null || (amount = walletCalculateCashBackResult.getAmount()) == null)) {
            amount.floatValue();
            Editable text = ((TalabatEditText) _$_findCachedViewById(i12)).getText();
            if (text == null || (obj2 = text.toString()) == null) {
                f11 = null;
            } else {
                f11 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(obj2);
            }
            if (f11 != null) {
                TalabatFillButton talabatFillButton = (TalabatFillButton) _$_findCachedViewById(R.id.submit_top_up_button);
                Editable text2 = ((TalabatEditText) _$_findCachedViewById(i12)).getText();
                if (text2 == null || (obj = text2.toString()) == null) {
                    f12 = null;
                } else {
                    f12 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(obj);
                }
                Intrinsics.checkNotNull(f12);
                if (f12.floatValue() > 0.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                talabatFillButton.setEnabled(z11);
            }
        }
        TalabatEditText talabatEditText = (TalabatEditText) _$_findCachedViewById(i12);
        if (talabatEditText != null) {
            editable = talabatEditText.getEditableText();
        }
        if (!(editable == null || editable.length() == 0)) {
            z12 = false;
        }
        if (z12) {
            setDefaultTopUpAmount();
        }
    }

    public void setWalletTopUpAmountSuggestion(@NotNull List<WalletTopUpAmountSuggestion> list) {
        Intrinsics.checkNotNullParameter(list, "walletTopUpAmountSuggestionList");
        stopLodingPopup();
        ((TalabatTextView) _$_findCachedViewById(R.id.cash_back_label)).setText(getResources().getString(R.string.wallet_cash_back_label, new Object[]{this.amountCurrency, getAmountWithoutCurrency(Float.valueOf(0.0f))}));
        int i11 = 0;
        for (WalletTopUpAmountSuggestion next : list) {
            int i12 = i11 + 1;
            if (!(next.getTopUpAmount() == null || next.getTopUpCashBack() == null)) {
                ArrayList<Button> arrayList = this.buttons;
                ArrayList<Button> arrayList2 = null;
                if (arrayList == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buttons");
                    arrayList = null;
                }
                arrayList.get(i11).setVisibility(0);
                ArrayList<Button> arrayList3 = this.buttons;
                if (arrayList3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("buttons");
                } else {
                    arrayList2 = arrayList3;
                }
                Float topUpAmount = next.getTopUpAmount();
                Intrinsics.checkNotNull(topUpAmount);
                arrayList2.get(i11).setText(String.valueOf((int) topUpAmount.floatValue()));
                HashMap<String, Float> hashMap = this.amountCashBackMap;
                Float topUpAmount2 = next.getTopUpAmount();
                Intrinsics.checkNotNull(topUpAmount2);
                hashMap.put(String.valueOf((int) topUpAmount2.floatValue()), next.getTopUpCashBack());
            }
            i11 = i12;
        }
    }

    public void setupViewsBeforeServiceRequest() {
        startLodingPopup();
    }

    @Nullable
    public WalletTopUpPresenter getPresenter() {
        return this.mWalletTopUpPresenter;
    }
}
