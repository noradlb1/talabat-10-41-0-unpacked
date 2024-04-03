package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.VerifyWalletTransactionDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletThreeDSURLRedirectionState;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletTopUpResponseScreenState;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModelBuilder;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.viewModel.WalletPaymentOptionViewModelImpl;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\u001a\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010#\u001a\u00020\u0007J\b\u0010$\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0016H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0012\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u000202H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModel;", "walletPaymentThreeDsFragmentInterface", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment$WalletPaymentThreeDsFragmentInterface;", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment$WalletPaymentThreeDsFragmentInterface;)V", "addWebViewListener", "", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getTopUpBundle", "Landroid/os/Bundle;", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "", "loadUrl", "navigateToResponseScreen", "intent", "Landroid/content/Intent;", "statusKey", "", "navigateToTransactionResponseScreen", "verifyWalletTransactionDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/VerifyWalletTransactionDisplayModel;", "observatory", "onTopUpFromBottomSheetFailure", "onTopUpFromBottomSheetSuccessful", "onTopUpFromDialogFragmentFailure", "onTopUpFromDialogFragmentSuccess", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "redirectToErrorScreen", "redirectToFullScreenError", "redirectToFullScreenSuccess", "redirectToMigratedErrorScreen", "redirectToMigratedScreen", "statusValue", "redirectToMigratedSuccessResponseScreen", "updateWalletThreeDSRedirectionState", "walletThreeDSURLRedirectionState", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletThreeDSURLRedirectionState;", "updateWalletTopUpResponseScreenState", "walletTopUpResponseScreenState", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletTopUpResponseScreenState;", "verifyTransactionStatus", "viewModelBuilder", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/viewModel/WalletPaymentOptionViewModelImpl;", "WalletPaymentThreeDsFragmentInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class WalletPaymentThreeDsFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private final WalletPaymentThreeDsFragmentInterface walletPaymentThreeDsFragmentInterface;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment$WalletPaymentThreeDsFragmentInterface;", "", "bottomSheetTopUpFailure", "", "bottomSheetTopUpSuccessful", "topUpFailure", "topUpSuccessful", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletPaymentThreeDsFragmentInterface {
        void bottomSheetTopUpFailure();

        void bottomSheetTopUpSuccessful();

        void topUpFailure();

        void topUpSuccessful();
    }

    public WalletPaymentThreeDsFragment(@NotNull WalletPaymentThreeDsFragmentInterface walletPaymentThreeDsFragmentInterface2) {
        Intrinsics.checkNotNullParameter(walletPaymentThreeDsFragmentInterface2, "walletPaymentThreeDsFragmentInterface");
        this.walletPaymentThreeDsFragmentInterface = walletPaymentThreeDsFragmentInterface2;
    }

    public static final /* synthetic */ WalletPaymentOptionViewModel access$getViewModel(WalletPaymentThreeDsFragment walletPaymentThreeDsFragment) {
        return (WalletPaymentOptionViewModel) walletPaymentThreeDsFragment.getViewModel();
    }

    private final void addWebViewListener() {
        Boolean bool;
        Bundle arguments = getArguments();
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.getBoolean(WalletNavigatorActions.EXTRA_SHOULD_IGNORE_TOP_UP_VERIFICATION, false));
        } else {
            bool = null;
        }
        ((WebView) _$_findCachedViewById(R.id.wallet_payment_three_ds_web_view)).setWebViewClient(new WalletPaymentThreeDsFragment$addWebViewListener$1(this, BooleanKt.orFalse(bool)));
    }

    private final Bundle getTopUpBundle() {
        Bundle bundle = new Bundle();
        Bundle arguments = getArguments();
        if (arguments != null) {
            bundle.putString("amount", arguments.getString("amount"));
            bundle.putBoolean(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE, arguments.getBoolean(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_IS_TOP_UP_CAMPAIGN_AVAILABLE));
            bundle.putFloat(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT, arguments.getFloat(WalletNavigatorActions.EXTRA_TOP_UP_SCREEN_WALLET_CASH_BACK_AMOUNT));
        }
        return bundle;
    }

    private final void loadUrl() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(WalletNavigatorActions.WALLET_THREE_DS_URL_KEY);
        } else {
            str = null;
        }
        if (str != null) {
            ((WebView) _$_findCachedViewById(R.id.wallet_payment_three_ds_web_view)).loadUrl(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r3.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void navigateToResponseScreen(android.content.Intent r3, java.lang.String r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x000d
            android.os.Bundle r0 = r3.getExtras()
            if (r0 == 0) goto L_0x000d
            java.lang.String r4 = r0.getString(r4)
            goto L_0x000e
        L_0x000d:
            r4 = 0
        L_0x000e:
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentThreeDsFragment$navigateToResponseScreen$1 r1 = new com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentThreeDsFragment$navigateToResponseScreen$1
            r1.<init>(r3)
            com.talabat.talabatcommon.extentions.SafeLetKt.safeLet(r4, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentThreeDsFragment.navigateToResponseScreen(android.content.Intent, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void navigateToTransactionResponseScreen(VerifyWalletTransactionDisplayModel verifyWalletTransactionDisplayModel) {
        Boolean bool;
        Bundle arguments = getArguments();
        Boolean bool2 = null;
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.getBoolean(WalletNavigatorActions.EXTRA_IS_TOP_UP_FROM_DIALOG_FRAGMENT));
        } else {
            bool = null;
        }
        boolean orFalse = BooleanKt.orFalse(bool);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            bool2 = Boolean.valueOf(arguments2.getBoolean(WalletNavigatorActions.EXTRA_IS_PAYMENT_NAVIGATION_FROM_BOTTOM_SHEET));
        }
        boolean orFalse2 = BooleanKt.orFalse(bool2);
        if (verifyWalletTransactionDisplayModel != null) {
            ((WalletPaymentOptionViewModel) getViewModel()).onNavigateToResponseScreen(verifyWalletTransactionDisplayModel.isTransactionSuccessful(), orFalse2, orFalse);
        }
    }

    private final void onTopUpFromBottomSheetFailure() {
        this.walletPaymentThreeDsFragmentInterface.bottomSheetTopUpFailure();
    }

    private final void onTopUpFromBottomSheetSuccessful() {
        this.walletPaymentThreeDsFragmentInterface.bottomSheetTopUpSuccessful();
    }

    private final void onTopUpFromDialogFragmentFailure() {
        this.walletPaymentThreeDsFragmentInterface.topUpFailure();
    }

    private final void onTopUpFromDialogFragmentSuccess() {
        this.walletPaymentThreeDsFragmentInterface.topUpSuccessful();
    }

    private final void redirectToFullScreenError() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            intent.putExtra("status", "error");
        }
        navigateToResponseScreen(intent, WalletNavigatorActions.WALLET_PAYMENT_ERROR_SCREEN_KEY);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void redirectToFullScreenSuccess() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            intent.putExtra("status", "success");
        }
        navigateToResponseScreen(intent, WalletNavigatorActions.WALLET_PAYMENT_SUCCESS_SCREEN_KEY);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final void redirectToMigratedErrorScreen() {
        redirectToMigratedScreen("failure");
    }

    private final void redirectToMigratedScreen(String str) {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion companion = Navigator.Companion;
            Bundle topUpBundle = getTopUpBundle();
            topUpBundle.putString("status", str);
            Unit unit = Unit.INSTANCE;
            companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_TOP_UP_RESPONSE_SCREEN, topUpBundle, WalletPaymentThreeDsFragment$redirectToMigratedScreen$1$2.INSTANCE));
        }
    }

    private final void redirectToMigratedSuccessResponseScreen() {
        redirectToMigratedScreen("success");
    }

    /* access modifiers changed from: private */
    public final void updateWalletThreeDSRedirectionState(WalletThreeDSURLRedirectionState walletThreeDSURLRedirectionState) {
        if (walletThreeDSURLRedirectionState instanceof WalletThreeDSURLRedirectionState.SuccessWithoutTopUpVerification) {
            ((WalletPaymentOptionViewModel) getViewModel()).onIgnoreTopUpVerification();
        } else if (walletThreeDSURLRedirectionState instanceof WalletThreeDSURLRedirectionState.SuccessWithTopUpVerification) {
            verifyTransactionStatus();
        } else if (walletThreeDSURLRedirectionState instanceof WalletThreeDSURLRedirectionState.RedirectionFailure) {
            redirectToErrorScreen();
        }
    }

    /* access modifiers changed from: private */
    public final void updateWalletTopUpResponseScreenState(WalletTopUpResponseScreenState walletTopUpResponseScreenState) {
        if (walletTopUpResponseScreenState instanceof WalletTopUpResponseScreenState.BottomSheetSuccess) {
            onTopUpFromBottomSheetSuccessful();
        } else if (walletTopUpResponseScreenState instanceof WalletTopUpResponseScreenState.BottomSheetFailure) {
            onTopUpFromBottomSheetFailure();
        } else if (walletTopUpResponseScreenState instanceof WalletTopUpResponseScreenState.DialogFragmentSuccess) {
            onTopUpFromDialogFragmentSuccess();
        } else if (walletTopUpResponseScreenState instanceof WalletTopUpResponseScreenState.DialogFragmentFailure) {
            onTopUpFromDialogFragmentFailure();
        } else if (walletTopUpResponseScreenState instanceof WalletTopUpResponseScreenState.MigratedFullScreenSuccess) {
            redirectToMigratedSuccessResponseScreen();
        } else if (walletTopUpResponseScreenState instanceof WalletTopUpResponseScreenState.MigratedFullScreenFailure) {
            redirectToMigratedErrorScreen();
        } else if (walletTopUpResponseScreenState instanceof WalletTopUpResponseScreenState.SuccessFullScreen) {
            redirectToFullScreenSuccess();
        } else if (walletTopUpResponseScreenState instanceof WalletTopUpResponseScreenState.FailureFullScreen) {
            redirectToFullScreenError();
        }
    }

    private final void verifyTransactionStatus() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("transactionId");
        } else {
            str = null;
        }
        if (str != null) {
            ((WalletPaymentOptionViewModel) getViewModel()).verifyWalletTransaction(str);
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
        hideProgress();
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
    }

    @NotNull
    public Class<WalletPaymentOptionViewModel> getViewModelClass() {
        return WalletPaymentOptionViewModel.class;
    }

    public int layoutId() {
        return R.layout.fragment_wallet_payment_three_ds;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) getViewModel()).getVerifyWalletTransactionData(), new WalletPaymentThreeDsFragment$observatory$1(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) getViewModel()).getWalletThreeDSURLRedirectionData(), new WalletPaymentThreeDsFragment$observatory$2(this));
        LifecycleKt.observe(this, ((WalletPaymentOptionViewModel) getViewModel()).getWalletTopUpResponseScreenStateData(), new WalletPaymentThreeDsFragment$observatory$3(this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((WebView) _$_findCachedViewById(R.id.wallet_payment_three_ds_web_view)).getSettings().setJavaScriptEnabled(true);
        loadUrl();
        addWebViewListener();
    }

    public final void redirectToErrorScreen() {
        Boolean bool;
        Bundle arguments = getArguments();
        Boolean bool2 = null;
        if (arguments != null) {
            bool = Boolean.valueOf(arguments.getBoolean(WalletNavigatorActions.EXTRA_IS_TOP_UP_FROM_DIALOG_FRAGMENT));
        } else {
            bool = null;
        }
        boolean orFalse = BooleanKt.orFalse(bool);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            bool2 = Boolean.valueOf(arguments2.getBoolean(WalletNavigatorActions.EXTRA_IS_PAYMENT_NAVIGATION_FROM_BOTTOM_SHEET));
        }
        ((WalletPaymentOptionViewModel) getViewModel()).onRedirectToErrorScreen(BooleanKt.orFalse(bool2), orFalse);
    }

    @NotNull
    public WalletPaymentOptionViewModelImpl viewModelBuilder() {
        WalletPaymentOptionViewModelBuilder.Companion companion = WalletPaymentOptionViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getWalletPaymentOptionViewModel(requireContext, getCoroutineScope());
    }
}
