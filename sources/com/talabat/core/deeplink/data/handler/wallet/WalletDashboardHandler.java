package com.talabat.core.deeplink.data.handler.wallet;

import android.content.Context;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import com.talabat.core.deeplink.data.handler.Handler;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.flutter.FlutterScreen;
import com.talabat.core.navigation.domain.screen.wallet.CobrandedCreditCardFlutterScreenKt;
import com.talabat.core.navigation.domain.screen.wallet.WalletDashboardScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.customer.domain.CustomerRepository;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/deeplink/data/handler/wallet/WalletDashboardHandler;", "Lcom/talabat/core/deeplink/data/handler/Handler;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "customerRepository", "Lcom/talabat/customer/domain/CustomerRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/navigation/domain/Navigator;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/customer/domain/CustomerRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "canHandle", "", "parsedLinkModel", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "(Lcom/talabat/core/deeplink/data/ParsedLinkModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "", "context", "Landroid/content/Context;", "isWalletDashboardFlutterEnabled", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardHandler implements Handler {
    @NotNull
    private final CustomerRepository customerRepository;
    @NotNull
    private final Navigator navigator;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final String screenName = CobrandedCreditCardFlutterScreenKt.PARAM_SOURCE_VALUE;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public WalletDashboardHandler(@NotNull Navigator navigator2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull CustomerRepository customerRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(navigator2, "navigator");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(customerRepository2, "customerRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.navigator = navigator2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.customerRepository = customerRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    private final boolean isWalletDashboardFlutterEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(EcosystemsFeatureFlagsKeys.IS_FLUTTER_WALLET_DASHBOARD_ENABLED, false);
    }

    @Nullable
    public Object canHandle(@NotNull ParsedLinkModel parsedLinkModel, @NotNull Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(Intrinsics.areEqual((Object) parsedLinkModel.getScreenName(), (Object) getScreenName()));
    }

    @NotNull
    public String getScreenName() {
        return this.screenName;
    }

    public void handle(@NotNull Context context, @NotNull ParsedLinkModel parsedLinkModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parsedLinkModel, "parsedLinkModel");
        if (!isWalletDashboardFlutterEnabled() || !this.customerRepository.isLoggedIn()) {
            this.observabilityManager.track("nativeWalletDashboardNavigation", "WalletDashboard", MapsKt__MapsKt.mapOf(TuplesKt.to("featureFlagStatus", String.valueOf(isWalletDashboardFlutterEnabled())), TuplesKt.to("userLoggedIn", String.valueOf(this.customerRepository.isLoggedIn()))));
            Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new WalletDashboardScreen(new WalletDashboardScreen.WalletDashboardData(false, 1, (DefaultConstructorMarker) null)), (Function1) null, 4, (Object) null);
            return;
        }
        Navigator.DefaultImpls.navigateTo$default(this.navigator, context, new FlutterScreen(new FlutterScreen.FlutterScreenData(CobrandedCreditCardFlutterScreenKt.PARAM_SOURCE_VALUE)), (Function1) null, 4, (Object) null);
    }
}
