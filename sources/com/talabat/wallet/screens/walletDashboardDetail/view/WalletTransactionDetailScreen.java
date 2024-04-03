package com.talabat.wallet.screens.walletDashboardDetail.view;

import JsonModels.Response.WalletCreditTransactionDetailCashBack;
import JsonModels.Response.WalletCreditTransactionDetailObject;
import JsonModels.Response.WalletCreditTransactionDetailResponse;
import JsonModels.Response.WalletTransactionTypes;
import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import ay.a;
import ay.b;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.OrderDetailsScreen;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.TalabatBase;
import com.talabat.talabatcommon.utils.DateConstants;
import com.talabat.talabatcommon.views.TalabatStrokeButton;
import com.talabat.wallet.helpers.CreditCardHelperInterface;
import com.talabat.wallet.helpers.ResponseStatus;
import com.talabat.wallet.helpers.ResponseStatusInterface;
import com.talabat.wallet.helpers.WalletFormatterInterface;
import com.talabat.wallet.screens.walletDashboardDetail.presenter.WalletTransactionListDetailPresenter;
import com.talabat.wallet.screens.walletDashboardDetail.view.di.DaggerWalletTransactionDetailScreenComponent;
import datamodels.OrderDetails;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Instrumented
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020#H\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020#H\u0016J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020#H\u0016J\u0012\u0010/\u001a\u00020#2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020#H\u0016J\u0012\u00106\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u00107\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u00108\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u00109\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010:\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010;\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0012\u0010<\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u000f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/talabat/wallet/screens/walletDashboardDetail/view/WalletTransactionDetailScreen;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/wallet/screens/walletDashboardDetail/view/WalletTransactionDetailView;", "Lcom/talabat/wallet/helpers/WalletFormatterInterface;", "Lcom/talabat/wallet/helpers/CreditCardHelperInterface;", "Lcom/talabat/wallet/helpers/ResponseStatusInterface;", "()V", "EMPTY_STRING", "", "getEMPTY_STRING", "()Ljava/lang/String;", "INPUT_DATE_FORMAT", "getINPUT_DATE_FORMAT", "OUT_DATE_FORMAT", "getOUT_DATE_FORMAT", "TRANSACTION_DETAIL_INTENT_KEY", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mWalletTransactionListDetailPresenter", "Lcom/talabat/wallet/screens/walletDashboardDetail/presenter/WalletTransactionListDetailPresenter;", "orderId", "transactionType", "", "transactionTypeIntetentKey", "addWalletTransactionDetail", "", "walletCreditTransactionDetailResponse", "LJsonModels/Response/WalletCreditTransactionDetailResponse;", "destroyPresenter", "displayServerErrorMessage", "getPresenter", "getScreenName", "onAuthError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "onOrderDetailsRecieved", "orderDetails", "Ldatamodels/OrderDetails;", "setRefundViewAndData", "walletCreditTransactionDetailObject", "LJsonModels/Response/WalletCreditTransactionDetailObject;", "setupProgressBarBeforeServiceRequest", "showCashBackReversalTransactionTypeView", "showCreditExpiredTransactionTypeView", "showCreditVoucherTransactionTypeView", "showPaidTransactionTypeView", "showRechargeTransactionTypeView", "showRefundTransactionTypeView", "showRiderTipTransactionTypeView", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailScreen extends TalabatBase implements WalletTransactionDetailView, WalletFormatterInterface, CreditCardHelperInterface, ResponseStatusInterface {
    @NotNull
    private final String EMPTY_STRING = "";
    @NotNull
    private final String INPUT_DATE_FORMAT = DateConstants.DEFAULT_UTC_FORMAT;
    @NotNull
    private final String OUT_DATE_FORMAT = "LLLL dd, yyyy, 'at' h:mm a";
    @NotNull
    private final String TRANSACTION_DETAIL_INTENT_KEY = "transactionId";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletTransactionListDetailPresenter mWalletTransactionListDetailPresenter;
    @Nullable
    private String orderId;
    private int transactionType = -1;
    @NotNull
    private final String transactionTypeIntetentKey = "transactionType";

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m5977onCreate$lambda0(WalletTransactionDetailScreen walletTransactionDetailScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailScreen, "this$0");
        walletTransactionDetailScreen.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m5978onCreate$lambda2(WalletTransactionDetailScreen walletTransactionDetailScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailScreen, "this$0");
        ((ProgressBar) walletTransactionDetailScreen._$_findCachedViewById(R.id.progressBar)).setVisibility(0);
        String str = walletTransactionDetailScreen.orderId;
        WalletTransactionListDetailPresenter walletTransactionListDetailPresenter = walletTransactionDetailScreen.mWalletTransactionListDetailPresenter;
        if (walletTransactionListDetailPresenter != null) {
            walletTransactionListDetailPresenter.getOrderDetailsBeforeNavigation(str);
        }
    }

    private final void setRefundViewAndData(WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        String str;
        WalletCreditTransactionDetailCashBack cashBack;
        Float amount;
        Integer expiryDays;
        ((ConstraintLayout) _$_findCachedViewById(R.id.refund_credit_container)).setVisibility(0);
        if (!(walletCreditTransactionDetailObject == null || (expiryDays = walletCreditTransactionDetailObject.getExpiryDays()) == null)) {
            expiryDays.intValue();
            Integer expiryDays2 = walletCreditTransactionDetailObject.getExpiryDays();
            if (expiryDays2 != null && expiryDays2.intValue() == 0) {
                ((TalabatTextView) _$_findCachedViewById(R.id.expiry_date)).setText(getResources().getString(R.string.refund_expiry_date_zero));
            } else {
                ((TalabatTextView) _$_findCachedViewById(R.id.expiry_date)).setText(getResources().getString(R.string.refund_expiry_date_string, new Object[]{String.valueOf(walletCreditTransactionDetailObject.getExpiryDays())}));
            }
        }
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.refund_source);
        if (walletCreditTransactionDetailObject != null) {
            str = walletCreditTransactionDetailObject.getCreditSource();
        } else {
            str = null;
        }
        talabatTextView.setText(str);
        if (walletCreditTransactionDetailObject != null && (cashBack = walletCreditTransactionDetailObject.getCashBack()) != null && (amount = cashBack.getAmount()) != null) {
            float floatValue = amount.floatValue();
            int i11 = R.id.refund_cashback_container;
            _$_findCachedViewById(i11).setVisibility(0);
            if (floatValue < 0.0f) {
                ((TalabatTextView) _$_findCachedViewById(i11).findViewById(R.id.cashback_amount)).setTextColor(ContextCompat.getColor(getContext(), R.color.talabat_red));
            }
            ((TalabatTextView) _$_findCachedViewById(i11).findViewById(R.id.cashback_amount)).setText(formatAmountWithSign(Float.valueOf(floatValue), false, true));
        }
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

    public void addWalletTransactionDetail(@Nullable WalletCreditTransactionDetailResponse walletCreditTransactionDetailResponse) {
        WalletCreditTransactionDetailObject result;
        String str;
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
        if (walletCreditTransactionDetailResponse != null && (result = walletCreditTransactionDetailResponse.getResult()) != null) {
            Glide.with(getContext()).load(result.getImageUrl()).apply((BaseRequestOptions<?>) RequestOptions.circleCropTransform().circleCrop()).into((ImageView) _$_findCachedViewById(R.id.transaction_logo));
            ((TalabatTextView) _$_findCachedViewById(R.id.transaction_name)).setText(result.getName());
            String date = result.getDate();
            String input_date_format = getINPUT_DATE_FORMAT();
            String string = getString(R.string.wallet_transaction__date_format);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…transaction__date_format)");
            ((TalabatTextView) _$_findCachedViewById(R.id.transaction_date)).setText(dateFormatter(date, input_date_format, string));
            int i11 = this.transactionType;
            Integer value = WalletTransactionTypes.TLIFE_CASH_PAYMENT.getValue();
            if (value != null && i11 == value.intValue()) {
                ((TalabatTextView) _$_findCachedViewById(R.id.transaction_amount)).setText(getResources().getString(R.string.detail_transaction_amount_string, new Object[]{StringsKt__StringsKt.removeRange((CharSequence) formatAmountWithSign(result.getAmount(), false, true), 0, 1).toString()}));
            } else {
                ((TalabatTextView) _$_findCachedViewById(R.id.transaction_amount)).setText(getResources().getString(R.string.detail_transaction_amount_string, new Object[]{formatAmountWithSign(result.getAmount(), false, true)}));
            }
            WalletTransactionListDetailPresenter presenter = getPresenter();
            if (presenter != null) {
                presenter.setTransactionTypeType(result);
            }
            WalletCreditTransactionDetailObject result2 = walletCreditTransactionDetailResponse.getResult();
            if (result2 != null) {
                str = result2.getOrderId();
            } else {
                str = null;
            }
            this.orderId = str;
        }
    }

    @NotNull
    public String dateFormatter(@Nullable String str, @NotNull String str2, @NotNull String str3) {
        return WalletFormatterInterface.DefaultImpls.dateFormatter(this, str, str2, str3);
    }

    public void destroyPresenter() {
        this.mWalletTransactionListDetailPresenter = null;
    }

    public void displayServerErrorMessage() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.root_view_detail_transaction);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "root_view_detail_transaction");
        String string = getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.server_error_msg)");
        makeSnackBar(constraintLayout, this, string, ResponseStatus.ERROR);
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
        return ScreenNames.WALLET_TRANSACTION_DETAIL_SCREEN;
    }

    public boolean hasCardExpired(@NotNull String str, @NotNull String str2) {
        return CreditCardHelperInterface.DefaultImpls.hasCardExpired(this, str, str2);
    }

    public void makeSnackBar(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus) {
        ResponseStatusInterface.DefaultImpls.makeSnackBar(this, view, context, str, responseStatus);
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        DaggerWalletTransactionDetailScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_credit_transaction_detail);
        int intExtra = getIntent().getIntExtra(this.TRANSACTION_DETAIL_INTENT_KEY, -1);
        this.transactionType = getIntent().getIntExtra(this.transactionTypeIntetentKey, -1);
        ((ImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new a(this));
        WalletTransactionListDetailPresenter walletTransactionListDetailPresenter = new WalletTransactionListDetailPresenter(getConfigurationLocalRepository(), getLocationConfigurationRepository(), this);
        this.mWalletTransactionListDetailPresenter = walletTransactionListDetailPresenter;
        walletTransactionListDetailPresenter.setWalletCreditTransactionDetail(this.transactionType, Integer.valueOf(intExtra));
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.view_order_summary_button)).setOnClickListener(new b(this));
    }

    public void onError() {
    }

    public void onOrderDetailsRecieved(@Nullable OrderDetails orderDetails) {
        String str;
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(8);
        if (orderDetails != null) {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) orderDetails);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) orderDetails);
            }
            Intent intent = new Intent(this, OrderDetailsScreen.class);
            intent.putExtra("value", str);
            intent.putExtra("statusBoolean", orderDetails.status);
            startActivity(intent);
        }
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public void setupProgressBarBeforeServiceRequest() {
        ((ProgressBar) _$_findCachedViewById(R.id.progressBar)).setVisibility(0);
    }

    public void showCashBackReversalTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        Float f11;
        WalletCreditTransactionDetailCashBack cashBack;
        Float amount;
        ((ConstraintLayout) _$_findCachedViewById(R.id.transaction_amount_container)).setVisibility(0);
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.view_order_summary_button)).setVisibility(0);
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.tpay_amount);
        if (walletCreditTransactionDetailObject != null) {
            f11 = walletCreditTransactionDetailObject.getAmount();
        } else {
            f11 = null;
        }
        talabatTextView.setText(formatAmountWithSign(f11, false, true));
        if (walletCreditTransactionDetailObject != null && (cashBack = walletCreditTransactionDetailObject.getCashBack()) != null && (amount = cashBack.getAmount()) != null) {
            float floatValue = amount.floatValue();
            _$_findCachedViewById(R.id.divider_view).setVisibility(0);
            int i11 = R.id.paid_cashback_container;
            _$_findCachedViewById(i11).setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(i11);
            int i12 = R.id.cashback_amount;
            ((TalabatTextView) _$_findCachedViewById.findViewById(i12)).setVisibility(0);
            if (floatValue < 0.0f) {
                ((TalabatTextView) _$_findCachedViewById(i11).findViewById(i12)).setTextColor(ContextCompat.getColor(this, R.color.talabat_red));
            }
            ((TalabatTextView) _$_findCachedViewById(i11).findViewById(i12)).setText(formatAmountWithSign(Float.valueOf(floatValue), false, true));
        }
    }

    public void showCreditExpiredTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        ((ConstraintLayout) _$_findCachedViewById(R.id.expired_card_container)).setVisibility(0);
    }

    public void showCreditVoucherTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        Float amount;
        if (walletCreditTransactionDetailObject != null && (amount = walletCreditTransactionDetailObject.getAmount()) != null) {
            float floatValue = amount.floatValue();
            ((ConstraintLayout) _$_findCachedViewById(R.id.voucher_container)).setVisibility(0);
            ((TalabatTextView) _$_findCachedViewById(R.id.voucher_amount)).setText(formatAmountWithSign(Float.valueOf(floatValue), false, true));
        }
    }

    public void showPaidTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        String str;
        boolean z11;
        WalletCreditTransactionDetailCashBack cashBack;
        Float amount;
        ((ConstraintLayout) _$_findCachedViewById(R.id.transaction_amount_container)).setVisibility(0);
        Float f11 = null;
        if (walletCreditTransactionDetailObject != null) {
            str = walletCreditTransactionDetailObject.getOrderId();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            ((TalabatStrokeButton) _$_findCachedViewById(R.id.view_order_summary_button)).setVisibility(0);
        }
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.tpay_amount);
        if (walletCreditTransactionDetailObject != null) {
            f11 = walletCreditTransactionDetailObject.getAmount();
        }
        talabatTextView.setText(formatAmountWithSign(f11, false, true));
        if (walletCreditTransactionDetailObject != null && (cashBack = walletCreditTransactionDetailObject.getCashBack()) != null && (amount = cashBack.getAmount()) != null) {
            float floatValue = amount.floatValue();
            _$_findCachedViewById(R.id.divider_view).setVisibility(0);
            int i11 = R.id.paid_cashback_container;
            _$_findCachedViewById(i11).setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(i11);
            int i12 = R.id.cashback_amount;
            ((TalabatTextView) _$_findCachedViewById.findViewById(i12)).setVisibility(0);
            if (floatValue < 0.0f) {
                ((TalabatTextView) _$_findCachedViewById(i11).findViewById(i12)).setTextColor(ContextCompat.getColor(this, R.color.talabat_red));
            }
            ((TalabatTextView) _$_findCachedViewById(i11).findViewById(i12)).setText(formatAmountWithSign(Float.valueOf(floatValue), false, true));
        }
    }

    public void showRechargeTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        String str;
        String str2;
        String str3;
        WalletCreditTransactionDetailCashBack cashBack;
        Float amount;
        ((ConstraintLayout) _$_findCachedViewById(R.id.recharge_container)).setVisibility(0);
        Float f11 = null;
        if (walletCreditTransactionDetailObject != null) {
            str = walletCreditTransactionDetailObject.getCardType();
        } else {
            str = null;
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.credit_card_logo);
        Intrinsics.checkNotNullExpressionValue(imageView, "credit_card_logo");
        setCardTypeIcon(str, imageView);
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.credit_card_name);
        Resources resources = getResources();
        Object[] objArr = new Object[2];
        if (walletCreditTransactionDetailObject != null) {
            str2 = walletCreditTransactionDetailObject.getCardType();
        } else {
            str2 = null;
        }
        objArr[0] = str2;
        if (walletCreditTransactionDetailObject != null) {
            str3 = walletCreditTransactionDetailObject.getCard4Digits();
        } else {
            str3 = null;
        }
        objArr[1] = str3;
        talabatTextView.setText(resources.getString(R.string.credit_card_name_string_transaction_detail, objArr));
        TalabatTextView talabatTextView2 = (TalabatTextView) _$_findCachedViewById(R.id.credit_card_amount_deducted);
        if (walletCreditTransactionDetailObject != null) {
            f11 = walletCreditTransactionDetailObject.getAmount();
        }
        talabatTextView2.setText(formatAmountWithSign(f11, true, true));
        if (walletCreditTransactionDetailObject != null && (cashBack = walletCreditTransactionDetailObject.getCashBack()) != null && (amount = cashBack.getAmount()) != null) {
            float floatValue = amount.floatValue();
            int i11 = R.id.recharge_cashback_container;
            _$_findCachedViewById(i11).setVisibility(0);
            if (floatValue < 0.0f) {
                ((TalabatTextView) _$_findCachedViewById(i11).findViewById(R.id.cashback_amount)).setTextColor(ContextCompat.getColor(this, R.color.talabat_red));
            }
            ((TalabatTextView) _$_findCachedViewById(i11).findViewById(R.id.cashback_amount)).setText(formatAmountWithSign(Float.valueOf(floatValue), false, true));
        }
    }

    public void showRefundTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        setRefundViewAndData(walletCreditTransactionDetailObject);
    }

    public void showRiderTipTransactionTypeView(@Nullable WalletCreditTransactionDetailObject walletCreditTransactionDetailObject) {
        Float amount;
        if (walletCreditTransactionDetailObject != null && (amount = walletCreditTransactionDetailObject.getAmount()) != null) {
            float floatValue = amount.floatValue();
            ((ConstraintLayout) _$_findCachedViewById(R.id.rider_tip_container)).setVisibility(0);
            ((TalabatTextView) _$_findCachedViewById(R.id.rider_tip_amount)).setText(StringsKt___StringsKt.drop(formatAmountWithSign(Float.valueOf(floatValue), true, true), 1));
        }
    }

    @Nullable
    public WalletTransactionListDetailPresenter getPresenter() {
        return this.mWalletTransactionListDetailPresenter;
    }
}
