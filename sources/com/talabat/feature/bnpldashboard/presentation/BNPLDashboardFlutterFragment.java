package com.talabat.feature.bnpldashboard.presentation;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.bnpldashboard.presentation.channel.BNPLDashboardMethodCallHandler;
import com.talabat.feature.bnpldashboard.presentation.di.DaggerBNPLDashboardFlutterFragmentComponent;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.walletaddcard.domain.WalletAddCardFeatureApi;
import com.talabat.feature.walletaddcard.presentation.WalletAddCard3DSHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001.B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001eH\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/talabat/feature/bnpldashboard/presentation/BNPLDashboardFlutterFragment;", "Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler$WalletAddCardMethodChannelCallback;", "Lcom/talabat/feature/bnpldashboard/presentation/BNPLDashboardChannelCallback;", "()V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "helpCenterDeeplinkBuilder", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "getHelpCenterDeeplinkBuilder", "()Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "setHelpCenterDeeplinkBuilder", "(Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;)V", "walletAddCard3DSHandler", "Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;", "getWalletAddCard3DSHandler", "()Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;", "setWalletAddCard3DSHandler", "(Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;)V", "walletMethodCallHandler", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;", "getWalletMethodCallHandler", "()Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;", "setWalletMethodCallHandler", "(Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;)V", "getRoute", "", "navigateToAddCardSuccessScreen", "", "navigateToHelpCenter", "orderId", "", "navigateToOrderDetailScreen", "encryptedOrderId", "onAttach", "context", "Landroid/content/Context;", "open3DSScreen", "walletAddCard3dsUrl", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "Companion", "com_talabat_feature_bnpl-dashboard_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLDashboardFlutterFragment extends PreWarmedFlutterFragment implements WalletMethodCallHandler.WalletAddCardMethodChannelCallback, BNPLDashboardChannelCallback {
    @NotNull
    @Deprecated
    private static final String BNPL_CHANNEL = "com.talabat.flutter/bnplDashboard";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String ENCRYPTED_ORDER_ID_KEY = "ENCRYPTED_ORDER_ID";
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public IHelpCenterDeeplinkBuilder helpCenterDeeplinkBuilder;
    @Inject
    public WalletAddCard3DSHandler walletAddCard3DSHandler;
    @Inject
    public WalletMethodCallHandler walletMethodCallHandler;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/bnpldashboard/presentation/BNPLDashboardFlutterFragment$Companion;", "", "()V", "BNPL_CHANNEL", "", "ENCRYPTED_ORDER_ID_KEY", "com_talabat_feature_bnpl-dashboard_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BNPLDashboardFlutterFragment() {
        super(PreWarmedEngines.ENGINE_FOR_BNPL_DASHBOARD, (RemoteConfiguration) null, 2, (DefaultConstructorMarker) null);
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
    public final IHelpCenterDeeplinkBuilder getHelpCenterDeeplinkBuilder() {
        IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder = this.helpCenterDeeplinkBuilder;
        if (iHelpCenterDeeplinkBuilder != null) {
            return iHelpCenterDeeplinkBuilder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helpCenterDeeplinkBuilder");
        return null;
    }

    @NotNull
    public String getRoute() {
        return "/bnpl-dashboard";
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

    public void navigateToAddCardSuccessScreen() {
    }

    public void navigateToHelpCenter(int i11) {
        DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireActivity, IHelpCenterDeeplinkBuilder.DefaultImpls.build$default(getHelpCenterDeeplinkBuilder(), String.valueOf(i11), (String) null, 2, (Object) null), (Function0) null, 4, (Object) null);
    }

    public void navigateToOrderDetailScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        Navigator.Companion companion = Navigator.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.navigate(requireContext, new NavigatorModel(WalletNavigatorActions.OPEN_ORDER_DETAIL_SCREEN, (Bundle) null, new BNPLDashboardFlutterFragment$navigateToOrderDetailScreen$1(str), 2, (DefaultConstructorMarker) null));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerBNPLDashboardFlutterFragmentComponent.factory().create(LifecycleOwnerKt.getLifecycleScope(this), this, this, (WalletAddCardFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(WalletAddCardFeatureApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (HelpCenterFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(HelpCenterFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    public void open3DSScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "walletAddCard3dsUrl");
        getWalletAddCard3DSHandler().open3DSScreen(str);
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setHelpCenterDeeplinkBuilder(@NotNull IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        Intrinsics.checkNotNullParameter(iHelpCenterDeeplinkBuilder, "<set-?>");
        this.helpCenterDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        String string = requireArguments().getString(WalletNavigatorActions.EXTRA_EVENT_ORIGIN_BNPL_DASHBOARD, "");
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), BNPL_CHANNEL);
        Intrinsics.checkNotNullExpressionValue(string, "eventOrigin");
        methodChannel.setMethodCallHandler(new BNPLDashboardMethodCallHandler(string, this));
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
}
