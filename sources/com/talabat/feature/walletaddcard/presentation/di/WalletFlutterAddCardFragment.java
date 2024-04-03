package com.talabat.feature.walletaddcard.presentation.di;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.walletaddcard.domain.WalletAddCardFeatureApi;
import com.talabat.feature.walletaddcard.presentation.WalletAddCard3DSHandler;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardNavigationUtility;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardSuccessInterface;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/walletaddcard/presentation/di/WalletFlutterAddCardFragment;", "Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler$WalletAddCardMethodChannelCallback;", "()V", "walletAddCard3DSHandler", "Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;", "getWalletAddCard3DSHandler", "()Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;", "setWalletAddCard3DSHandler", "(Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;)V", "walletMethodCallHandler", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;", "getWalletMethodCallHandler", "()Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;", "setWalletMethodCallHandler", "(Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;)V", "getRoute", "", "navigateToAddCardSuccessScreen", "", "onAttach", "context", "Landroid/content/Context;", "open3DSScreen", "walletAddCard3dsUrl", "setUpExtraChannels", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "com_talabat_feature_wallet-add-card_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletFlutterAddCardFragment extends PreWarmedFlutterFragment implements WalletMethodCallHandler.WalletAddCardMethodChannelCallback {
    @Inject
    public WalletAddCard3DSHandler walletAddCard3DSHandler;
    @Inject
    public WalletMethodCallHandler walletMethodCallHandler;

    public WalletFlutterAddCardFragment() {
        super(PreWarmedEngines.ENGINE_FOR_WALLET_ADD_CARD, (RemoteConfiguration) null, 2, (DefaultConstructorMarker) null);
    }

    @NotNull
    public String getRoute() {
        return "/wallet-add-card";
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
        AddCardNavigationUtility.INSTANCE.navigateToAddCardSuccessScreen(getArguments(), requireContext(), (WalletAddCardSuccessInterface) null);
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerWalletAddCardFragmentComponent.factory().create(LifecycleOwnerKt.getLifecycleScope(this), this, this, (WalletAddCardFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(WalletAddCardFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    public void open3DSScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "walletAddCard3dsUrl");
        getWalletAddCard3DSHandler().open3DSScreen(str);
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
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
