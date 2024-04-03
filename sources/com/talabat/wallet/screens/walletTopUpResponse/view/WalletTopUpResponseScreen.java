package com.talabat.wallet.screens.walletTopUpResponse.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.text.HtmlCompat;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.helpers.ResponseStatus;
import com.talabat.wallet.helpers.ResponseStatusInterface;
import com.talabat.wallet.helpers.WalletCurrencyFormatter;
import com.talabat.wallet.screens.walletDashboard.view.WalletTransactionDashboardScreen;
import com.talabat.wallet.screens.walletTopUpResponse.presenter.WalletTopUpScreenPresenter;
import com.talabat.wallet.screens.walletTopUpResponse.view.di.DaggerWalletTopUpResponseScreenComponent;
import com.talabat.wallet.screens.walletTopupCardList.view.WalletTopupCardListScreen;
import hy.a;
import hy.b;
import hy.c;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.AppTracker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020&H\u0016J\b\u0010+\u001a\u00020&H\u0016J\n\u0010,\u001a\u0004\u0018\u00010$H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020&H\u0016J\u0012\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020&H\u0016J\b\u00103\u001a\u00020&H\u0016J\b\u00104\u001a\u00020&H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/talabat/wallet/screens/walletTopUpResponse/view/WalletTopUpResponseScreen;", "Lcom/talabat/helpers/TalabatBase;", "Lcom/talabat/wallet/screens/walletTopUpResponse/view/WalletTopUpResponseView;", "Lcom/talabat/wallet/helpers/ResponseStatusInterface;", "Lcom/talabat/wallet/helpers/WalletCurrencyFormatter;", "()V", "AMOUNT", "", "CURRENCY", "EMPTY_STRING", "getEMPTY_STRING", "()Ljava/lang/String;", "ERROR", "MESSAGE", "STATUS", "SUCCESS", "amount", "getAmount", "setAmount", "(Ljava/lang/String;)V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "currency", "getCurrency", "setCurrency", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "mWalletTopUpScreenPresenter", "Lcom/talabat/wallet/screens/walletTopUpResponse/presenter/WalletTopUpScreenPresenter;", "addBalance", "", "balance", "", "(Ljava/lang/Float;)V", "destroyPresenter", "displayServerErrorMessage", "getPresenter", "getScreenName", "onAuthError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onError", "redirectToLoginScreen", "setupViewsBeforeServiceRequest", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTopUpResponseScreen extends TalabatBase implements WalletTopUpResponseView, ResponseStatusInterface, WalletCurrencyFormatter {
    @NotNull
    private final String AMOUNT = "amount";
    @NotNull
    private final String CURRENCY = "currency";
    @NotNull
    private final String EMPTY_STRING = "";
    @NotNull
    private final String ERROR = "error";
    @NotNull
    private final String MESSAGE = "message";
    @NotNull
    private final String STATUS = "status";
    @NotNull
    private final String SUCCESS = "success";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private String amount = "";
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private String currency = "";
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Nullable
    private WalletTopUpScreenPresenter mWalletTopUpScreenPresenter;

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m5999onCreate$lambda0(WalletTopUpResponseScreen walletTopUpResponseScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpResponseScreen, "this$0");
        walletTopUpResponseScreen.startActivity(new Intent(walletTopUpResponseScreen, WalletTopupCardListScreen.class));
        walletTopUpResponseScreen.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m6000onCreate$lambda1(WalletTopUpResponseScreen walletTopUpResponseScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpResponseScreen, "this$0");
        walletTopUpResponseScreen.startActivity(new Intent(walletTopUpResponseScreen, WalletTransactionDashboardScreen.class));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m6001onCreate$lambda2(WalletTopUpResponseScreen walletTopUpResponseScreen, View view) {
        Intrinsics.checkNotNullParameter(walletTopUpResponseScreen, "this$0");
        walletTopUpResponseScreen.startActivity(new Intent(walletTopUpResponseScreen, WalletTransactionDashboardScreen.class));
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

    public void addBalance(@Nullable Float f11) {
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        String str = getResources().getString(R.string.your_available_credit_is) + "<b> " + this.currency + " " + getAmountWithoutCurrency(f11) + "</b>";
        if (TalabatUtils.isArabic()) {
            str = getResources().getString(R.string.your_available_credit_is) + "<b> " + getAmountWithoutCurrency(f11) + " " + this.currency + "</b>";
        }
        ((TalabatTextView) _$_findCachedViewById(R.id.available_credit_text_view)).setText(HtmlCompat.fromHtml(str, 0));
    }

    public void destroyPresenter() {
        this.mWalletTopUpScreenPresenter = null;
    }

    public void displayServerErrorMessage() {
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) _$_findCachedViewById(R.id.root_view);
        Intrinsics.checkNotNullExpressionValue(coordinatorLayout, "root_view");
        String string = getString(R.string.server_error_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.server_error_msg)");
        makeSnackBar(coordinatorLayout, this, string, ResponseStatus.ERROR);
    }

    @NotNull
    public final String getAmount() {
        return this.amount;
    }

    @NotNull
    public String getAmountWithoutCurrency(@Nullable Float f11) {
        return WalletCurrencyFormatter.DefaultImpls.getAmountWithoutCurrency(this, f11);
    }

    @NotNull
    public String getAmountWithoutCurrencyWithSign(@Nullable Float f11) {
        return WalletCurrencyFormatter.DefaultImpls.getAmountWithoutCurrencyWithSign(this, f11);
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
    public final String getCurrency() {
        return this.currency;
    }

    @NotNull
    public String getEMPTY_STRING() {
        return this.EMPTY_STRING;
    }

    @NotNull
    public String getLocaleCurrency() {
        return WalletCurrencyFormatter.DefaultImpls.getLocaleCurrency(this);
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
    public String getScreenName() {
        return "";
    }

    public void makeSnackBar(@NotNull View view, @NotNull Context context, @NotNull String str, @NotNull ResponseStatus responseStatus) {
        ResponseStatusInterface.DefaultImpls.makeSnackBar(this, view, context, str, responseStatus);
    }

    public void onAuthError() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        DaggerWalletTopUpResponseScreenComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wallet_top_up_response_screen);
        Bundle extras = getIntent().getExtras();
        String str4 = null;
        if (extras != null) {
            str = extras.getString(this.STATUS);
        } else {
            str = null;
        }
        this.mWalletTopUpScreenPresenter = new WalletTopUpScreenPresenter(getConfigurationLocalRepository(), getLocationConfigurationRepository(), this);
        String str5 = "";
        if (StringsKt__StringsJVMKt.equals(str, this.SUCCESS, true)) {
            Bundle extras2 = getIntent().getExtras();
            if (extras2 != null) {
                str3 = extras2.getString(this.CURRENCY);
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = str5;
            }
            this.currency = str3;
            Bundle extras3 = getIntent().getExtras();
            if (extras3 != null) {
                str4 = extras3.getString(this.AMOUNT);
            }
            if (str4 == null) {
                str4 = str5;
            }
            this.amount = str4;
            AppTracker.onWalletTopupSuccess(getContext(), "Wallet Topup success screen", "wallet", this.amount, str5);
            ((ImageView) _$_findCachedViewById(R.id.status_icon)).setBackgroundResource(R.drawable.wallet_success_icon);
            int i11 = R.id.top_up_status_text_view;
            ((TalabatTextView) _$_findCachedViewById(i11)).setVisibility(0);
            ((TalabatTextView) _$_findCachedViewById(R.id.top_up_wallet_text_view)).setVisibility(0);
            ((TalabatFillButton) _$_findCachedViewById(R.id.go_to_wallet)).setVisibility(0);
            ((TalabatTextView) _$_findCachedViewById(R.id.available_credit_text_view)).setVisibility(0);
            int i12 = R.id.top_up_amount;
            ((TalabatTextView) _$_findCachedViewById(i12)).setVisibility(0);
            ((TalabatTextView) _$_findCachedViewById(i12)).setText(this.currency + " " + this.amount);
            float floatExtra = getIntent().getFloatExtra(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT, 0.0f);
            if (getIntent().getBooleanExtra(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE, false) && floatExtra > 0.0f) {
                ((TalabatTextView) _$_findCachedViewById(R.id.top_up_waiting_message)).setVisibility(0);
            }
            WalletTopUpScreenPresenter walletTopUpScreenPresenter = this.mWalletTopUpScreenPresenter;
            if (walletTopUpScreenPresenter != null) {
                walletTopUpScreenPresenter.setWalletCreditBalance();
            }
            ((TalabatTextView) _$_findCachedViewById(i11)).setText(getString(R.string.top_up_successful));
        } else {
            Bundle extras4 = getIntent().getExtras();
            if (extras4 != null) {
                str2 = extras4.getString(this.CURRENCY);
            } else {
                str2 = null;
            }
            if (str2 != null) {
                str5 = str2;
            }
            this.amount = str5;
            Bundle extras5 = getIntent().getExtras();
            if (extras5 != null) {
                str4 = extras5.getString(this.MESSAGE);
            }
            AppTracker.onWalletTopupFailed(getContext(), "Wallet Topup fail screen", "wallet", this.amount, str4);
            int i13 = R.id.error_message_text_view;
            ((TalabatTextView) _$_findCachedViewById(i13)).setVisibility(0);
            ((TalabatStrokeButton) _$_findCachedViewById(R.id.got_to_wallet_button)).setVisibility(0);
            ((TalabatFillButton) _$_findCachedViewById(R.id.try_another_card_button)).setVisibility(0);
            ((TalabatTextView) _$_findCachedViewById(R.id.top_up_status_text_view)).setText(getString(R.string.top_up_failed));
            ((TalabatTextView) _$_findCachedViewById(i13)).setText(str4);
            ((ImageView) _$_findCachedViewById(R.id.status_icon)).setBackgroundResource(R.drawable.wallet_failure_icon);
        }
        ((TalabatFillButton) _$_findCachedViewById(R.id.try_another_card_button)).setOnClickListener(new a(this));
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.got_to_wallet_button)).setOnClickListener(new b(this));
        ((TalabatFillButton) _$_findCachedViewById(R.id.go_to_wallet)).setOnClickListener(new c(this));
    }

    public void onError() {
    }

    public void redirectToLoginScreen() {
    }

    public final void setAmount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.amount = str;
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCurrency(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currency = str;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public void setupViewsBeforeServiceRequest() {
        ((ProgressBar) _$_findCachedViewById(R.id.progress_bar)).setVisibility(0);
    }

    @Nullable
    public WalletTopUpScreenPresenter getPresenter() {
        return this.mWalletTopUpScreenPresenter;
    }
}
