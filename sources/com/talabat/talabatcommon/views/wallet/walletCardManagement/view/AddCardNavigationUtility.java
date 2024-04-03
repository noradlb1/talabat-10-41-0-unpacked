package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.WalletAddCardDialogFragment;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/AddCardNavigationUtility;", "", "()V", "navigateToAddCardSource", "", "context", "Landroid/content/Context;", "destination", "", "navigateToAddCardSuccessScreen", "arguments", "Landroid/os/Bundle;", "listener", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardSuccessInterface;", "navigateToSubscriptionDetailScreen", "subscriptionMemberId", "showAddCardDialogFragment", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardDialogFragment$WalletAddCardDialogFragmentInterface;", "source", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddCardNavigationUtility {
    @NotNull
    public static final AddCardNavigationUtility INSTANCE = new AddCardNavigationUtility();

    private AddCardNavigationUtility() {
    }

    private final void navigateToAddCardSource(Context context, String str) {
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToAction(str));
        }
    }

    private final void navigateToSubscriptionDetailScreen(Context context, String str) {
        if (context != null) {
            Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createSubscriptionDetailNavigation(str, WalletNavigatorActions.WALLET_ADD_CARD_ACTIVITY, "talabat.action.Wallet.SubscriptionDetailActivity", true));
        }
    }

    public final void navigateToAddCardSuccessScreen(@Nullable Bundle bundle, @Nullable Context context, @Nullable WalletAddCardSuccessInterface walletAddCardSuccessInterface) {
        String str;
        boolean z11;
        String str2 = null;
        if (bundle != null) {
            str = bundle.getString("subscriptionMemberId");
        } else {
            str = null;
        }
        if (bundle != null) {
            str2 = bundle.getString("source");
        }
        if (str2 == null) {
            str2 = "";
        }
        boolean z12 = true;
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            navigateToSubscriptionDetailScreen(context, str);
        } else if (!StringsKt__StringsJVMKt.equals(str2, "walletPaymentBottomSheet", false)) {
            if (str2.length() <= 0) {
                z12 = false;
            }
            if (z12) {
                navigateToAddCardSource(context, str2);
            } else {
                LogManager.debug("invalid argument");
            }
        } else if (walletAddCardSuccessInterface != null) {
            walletAddCardSuccessInterface.navigateToAddCardSuccess();
        }
    }

    public final void showAddCardDialogFragment(@Nullable FragmentManager fragmentManager, @NotNull WalletAddCardDialogFragment.WalletAddCardDialogFragmentInterface walletAddCardDialogFragmentInterface, @NotNull String str) {
        Intrinsics.checkNotNullParameter(walletAddCardDialogFragmentInterface, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(str, "source");
        WalletAddCardDialogFragment walletAddCardDialogFragment = new WalletAddCardDialogFragment(walletAddCardDialogFragmentInterface);
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        walletAddCardDialogFragment.setArguments(bundle);
        if (fragmentManager != null) {
            walletAddCardDialogFragment.show(fragmentManager, "");
        }
    }
}
