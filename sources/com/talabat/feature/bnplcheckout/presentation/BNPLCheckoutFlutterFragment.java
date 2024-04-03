package com.talabat.feature.bnplcheckout.presentation;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.bnplcheckout.di.DaggerBNPLCheckoutFlutterFragmentComponent;
import com.talabat.feature.bnplcheckout.presentation.channel.BNPLCheckoutChannelCallback;
import com.talabat.feature.bnplcheckout.presentation.channel.BNPLCheckoutMethodCallHandler;
import com.talabat.feature.walletaddcard.domain.WalletAddCardFeatureApi;
import com.talabat.feature.walletaddcard.presentation.WalletAddCard3DSHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.LagecyTalabatNavigatorExtKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\u00013B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001cH\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-H\u0016J,\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001c2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c02H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00064"}, d2 = {"Lcom/talabat/feature/bnplcheckout/presentation/BNPLCheckoutFlutterFragment;", "Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "Lcom/talabat/feature/bnplcheckout/presentation/channel/BNPLCheckoutChannelCallback;", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler$WalletAddCardMethodChannelCallback;", "()V", "isPaymentFallbackFlow", "", "termsAndConditionsConfigurationRepository", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "getTermsAndConditionsConfigurationRepository", "()Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "termsAndConditionsConfigurationRepository$delegate", "Lkotlin/Lazy;", "walletAddCard3DSHandler", "Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;", "getWalletAddCard3DSHandler", "()Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;", "setWalletAddCard3DSHandler", "(Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;)V", "walletMethodCallHandler", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;", "getWalletMethodCallHandler", "()Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;", "setWalletMethodCallHandler", "(Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;)V", "closeBottomSheet", "", "getRoute", "", "isChangeCardClicked", "navigateToAddCardSuccessScreen", "onAttach", "context", "Landroid/content/Context;", "onBackPressedFromFlutter", "withArgs", "", "open3DSScreen", "walletAddCard3dsUrl", "openTermsAndConditionsScreen", "placeOrder", "cardInfo", "Lcom/talabat/feature/bnplcheckout/presentation/CardInfo;", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "track", "eventName", "featureName", "attributes", "", "Companion", "com_talabat_feature_bnpl-checkout_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLCheckoutFlutterFragment extends PreWarmedFlutterFragment implements BNPLCheckoutChannelCallback, WalletMethodCallHandler.WalletAddCardMethodChannelCallback {
    @NotNull
    private static final String BNPL_ADDITIONAL_PAYMENT_METHOD = "{pm}";
    @NotNull
    private static final String BNPL_CHANNEL = "com.talabat.flutter/bnplCheckout";
    @NotNull
    private static final String BNPL_PAYMENT_METHOD = "{type}";
    @NotNull
    private static final String BNPL_TERMS_AND_CONDITION_ADDITIONAL_PAYMENT_METHOD_VALUE = "2";
    @NotNull
    private static final String BNPL_TERMS_AND_CONDITION_QUERY_VALUE = "5";
    @NotNull
    public static final String CARD_INFO_EXTRA = "cardInfo";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String IS_CHANGE_CARD_CTA_CLICKED = "isChangeCardClicked";
    @NotNull
    public static final String IS_PAYMENT_FALLBACK_FLOW = "isPaymentFallbackFlow";
    @NotNull
    public static final String OPTED_OUT_FROM_BNPL_FALLBACK_OPTION_EXTRA = "optedOutFromFallbackOption";
    @NotNull
    public static final String ORDER_AMOUNT_EXTRA = "amount";
    @NotNull
    public static final String PLAN_ID_EXTRA = "planId";
    @NotNull
    public static final String REQUEST_KEY = "bnplCheckoutFlutterFragmentRequestKey";
    private boolean isPaymentFallbackFlow;
    @NotNull
    private final Lazy termsAndConditionsConfigurationRepository$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new BNPLCheckoutFlutterFragment$termsAndConditionsConfigurationRepository$2(this));
    @Inject
    public WalletAddCard3DSHandler walletAddCard3DSHandler;
    @Inject
    public WalletMethodCallHandler walletMethodCallHandler;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/bnplcheckout/presentation/BNPLCheckoutFlutterFragment$Companion;", "", "()V", "BNPL_ADDITIONAL_PAYMENT_METHOD", "", "BNPL_CHANNEL", "BNPL_PAYMENT_METHOD", "BNPL_TERMS_AND_CONDITION_ADDITIONAL_PAYMENT_METHOD_VALUE", "BNPL_TERMS_AND_CONDITION_QUERY_VALUE", "CARD_INFO_EXTRA", "IS_CHANGE_CARD_CTA_CLICKED", "IS_PAYMENT_FALLBACK_FLOW", "OPTED_OUT_FROM_BNPL_FALLBACK_OPTION_EXTRA", "ORDER_AMOUNT_EXTRA", "PLAN_ID_EXTRA", "REQUEST_KEY", "com_talabat_feature_bnpl-checkout_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BNPLCheckoutFlutterFragment() {
        super(PreWarmedEngines.ENGINE_FOR_BNPL_CHECKOUT, (RemoteConfiguration) null, 2, (DefaultConstructorMarker) null);
    }

    private final TermsAndConditionsConfigurationRepository getTermsAndConditionsConfigurationRepository() {
        return (TermsAndConditionsConfigurationRepository) this.termsAndConditionsConfigurationRepository$delegate.getValue();
    }

    public void closeBottomSheet() {
        if (this.isPaymentFallbackFlow) {
            getParentFragmentManager().beginTransaction().remove(this).commit();
            return;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            ((DSBottomSheet) parentFragment).dismiss();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.designsystem.ds_bottom_sheet_v2.DSBottomSheet");
    }

    @NotNull
    public String getRoute() {
        return this.isPaymentFallbackFlow ? "/bnpl-payment-fallback" : "/pay-later";
    }

    @NotNull
    public final WalletAddCard3DSHandler getWalletAddCard3DSHandler() {
        WalletAddCard3DSHandler walletAddCard3DSHandler2 = this.walletAddCard3DSHandler;
        if (walletAddCard3DSHandler2 != null) {
            return walletAddCard3DSHandler2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("walletAddCard3DSHandler");
        return null;
    }

    @NotNull
    public final WalletMethodCallHandler getWalletMethodCallHandler() {
        WalletMethodCallHandler walletMethodCallHandler2 = this.walletMethodCallHandler;
        if (walletMethodCallHandler2 != null) {
            return walletMethodCallHandler2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("walletMethodCallHandler");
        return null;
    }

    public boolean isChangeCardClicked() {
        boolean z11;
        Bundle arguments = getArguments();
        if (arguments != null) {
            z11 = arguments.getBoolean(IS_CHANGE_CARD_CTA_CLICKED);
        } else {
            z11 = false;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            arguments2.remove(IS_CHANGE_CARD_CTA_CLICKED);
        }
        return z11;
    }

    public void navigateToAddCardSuccessScreen() {
    }

    public void onAttach(@NotNull Context context) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerBNPLCheckoutFlutterFragmentComponent.factory().create(LifecycleOwnerKt.getLifecycleScope(this), this, this, (WalletAddCardFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(WalletAddCardFeatureApi.class)).inject(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z11 = arguments.getBoolean(IS_PAYMENT_FALLBACK_FLOW);
        } else {
            z11 = false;
        }
        this.isPaymentFallbackFlow = z11;
        super.onAttach(context);
    }

    public void onBackPressedFromFlutter() {
        closeBottomSheet();
    }

    public void open3DSScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "walletAddCard3dsUrl");
        getWalletAddCard3DSHandler().open3DSScreen(str);
    }

    public void openTermsAndConditionsScreen() {
        String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(getTermsAndConditionsConfigurationRepository().config().checkoutPaymentTermsUrl(), "{type}", "5", false, 4, (Object) null), "{pm}", "2", false, 4, (Object) null);
        Navigator.Companion companion = Navigator.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String string = getString(R.string.pay_later);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ation.R.string.pay_later)");
        LagecyTalabatNavigatorExtKt.navigateToMainFAQ(companion, context, string, replace$default);
    }

    public void placeOrder(@NotNull CardInfo cardInfo) {
        Intrinsics.checkNotNullParameter(cardInfo, CARD_INFO_EXTRA);
        getParentFragmentManager().setFragmentResult(REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to(CARD_INFO_EXTRA, cardInfo)));
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor(), BNPL_CHANNEL).setMethodCallHandler(new BNPLCheckoutMethodCallHandler(this, requireArguments().getString(PLAN_ID_EXTRA), requireArguments().getString("amount")));
        new MethodChannel(flutterEngine.getDartExecutor(), WalletMethodCallHandler.WALLET_CHANNEL).setMethodCallHandler(getWalletMethodCallHandler());
    }

    public final void setWalletAddCard3DSHandler(@NotNull WalletAddCard3DSHandler walletAddCard3DSHandler2) {
        Intrinsics.checkNotNullParameter(walletAddCard3DSHandler2, "<set-?>");
        this.walletAddCard3DSHandler = walletAddCard3DSHandler2;
    }

    public final void setWalletMethodCallHandler(@NotNull WalletMethodCallHandler walletMethodCallHandler2) {
        Intrinsics.checkNotNullParameter(walletMethodCallHandler2, "<set-?>");
        this.walletMethodCallHandler = walletMethodCallHandler2;
    }

    public void track(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(str2, "featureName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
    }

    public void onBackPressedFromFlutter(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "withArgs");
        if ((obj instanceof String) && Intrinsics.areEqual(obj, (Object) "/bnpl-payment-fallback")) {
            getParentFragmentManager().setFragmentResult(REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to(OPTED_OUT_FROM_BNPL_FALLBACK_OPTION_EXTRA, Boolean.TRUE)));
        }
        closeBottomSheet();
    }
}
