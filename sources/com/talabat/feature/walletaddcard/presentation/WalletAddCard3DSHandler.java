package com.talabat.feature.walletaddcard.presentation;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import com.talabat.feature.walletaddcard.presentation.channel.WalletMethodCallHandler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sp.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/walletaddcard/presentation/WalletAddCard3DSHandler;", "", "walletMethodCallHandler", "Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;", "fragment", "Landroidx/fragment/app/Fragment;", "(Lcom/talabat/feature/walletaddcard/presentation/channel/WalletMethodCallHandler;Landroidx/fragment/app/Fragment;)V", "activityResultContract", "Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "getActivityResultContract$annotations", "()V", "getActivityResultContract", "()Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher$annotations", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "open3DSScreen", "", "walletAddCard3dsUrl", "", "com_talabat_feature_wallet-add-card_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCard3DSHandler {
    @NotNull
    private final ActivityResultContracts.StartActivityForResult activityResultContract;
    @NotNull
    private final Fragment fragment;
    @NotNull
    private final ActivityResultLauncher<Intent> launcher;

    @Inject
    public WalletAddCard3DSHandler(@NotNull WalletMethodCallHandler walletMethodCallHandler, @NotNull Fragment fragment2) {
        Intrinsics.checkNotNullParameter(walletMethodCallHandler, "walletMethodCallHandler");
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        this.fragment = fragment2;
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        this.activityResultContract = startActivityForResult;
        ActivityResultLauncher<Intent> registerForActivityResult = fragment2.registerForActivityResult(startActivityForResult, new a(walletMethodCallHandler));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "fragment.registerForActi…sult(it.resultCode)\n    }");
        this.launcher = registerForActivityResult;
    }

    @VisibleForTesting
    public static /* synthetic */ void getActivityResultContract$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLauncher$annotations() {
    }

    /* access modifiers changed from: private */
    /* renamed from: launcher$lambda-0  reason: not valid java name */
    public static final void m10431launcher$lambda0(WalletMethodCallHandler walletMethodCallHandler, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(walletMethodCallHandler, "$walletMethodCallHandler");
        walletMethodCallHandler.onActivityResult(activityResult.getResultCode());
    }

    @NotNull
    public final ActivityResultContracts.StartActivityForResult getActivityResultContract() {
        return this.activityResultContract;
    }

    @NotNull
    public final ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
    }

    public final void open3DSScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "walletAddCard3dsUrl");
        Intent intent = new Intent(this.fragment.requireActivity(), Wallet3DsActivity.class);
        intent.putExtra(Wallet3DsActivity.WALLET_THREE_DS_URL_KEY, str);
        this.launcher.launch(intent);
    }
}
