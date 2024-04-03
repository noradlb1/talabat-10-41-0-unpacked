package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.utils.ProgressBarLoading;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zv.k;
import zv.l;
import zv.m;

@Instrumented
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/AddCardCustomView$AddCardCustomViewInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "()V", "addCardNavigationInterface", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardNavigationInterface;", "addCardSuccessListener", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardSuccessInterface;", "addLearnMoreListener", "", "navigateToAddCardSuccessScreen", "navigateToThreeDSScreen", "redirectUrl", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setAddCardNavigationInterface", "setAddCardSuccessListener", "showErrorStatusNotification", "errorMessage", "showInvalidCardInputMessage", "showServiceErrorMessage", "toggleAddCardButton", "buttonEnableStatus", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardFragment extends Fragment implements AddCardCustomView.AddCardCustomViewInterface, AnimationHelper, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private WalletAddCardNavigationInterface addCardNavigationInterface;
    @Nullable
    private WalletAddCardSuccessInterface addCardSuccessListener;

    private final void addLearnMoreListener() {
        ((TextView) _$_findCachedViewById(R.id.learn_more)).setOnClickListener(new m(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addLearnMoreListener$lambda-2  reason: not valid java name */
    public static final void m5805addLearnMoreListener$lambda2(WalletAddCardFragment walletAddCardFragment, View view) {
        Intrinsics.checkNotNullParameter(walletAddCardFragment, "this$0");
        FragmentActivity activity = walletAddCardFragment.getActivity();
        if (activity != null) {
            ActivityKt.hideKeyBoard(activity);
        }
        walletAddCardFragment.delay(AnimationSpeed.NORMAL.getValue(), new WalletAddCardFragment$addLearnMoreListener$1$1(walletAddCardFragment, new SecureMoreInfoBottomSheetDialog()));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m5806onViewCreated$lambda0(WalletAddCardFragment walletAddCardFragment, View view) {
        Intrinsics.checkNotNullParameter(walletAddCardFragment, "this$0");
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        ProgressBar progressBar = (ProgressBar) walletAddCardFragment._$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(progressBar, "progress_bar");
        progressBarLoading.showProgress(progressBar);
        ((AddCardCustomView) walletAddCardFragment._$_findCachedViewById(R.id.add_card_custom_view)).addCardToWallet();
        TalabatFillButton talabatFillButton = (TalabatFillButton) walletAddCardFragment._$_findCachedViewById(R.id.save_button);
        if (talabatFillButton != null) {
            talabatFillButton.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m5807onViewCreated$lambda1(WalletAddCardFragment walletAddCardFragment, View view) {
        Intrinsics.checkNotNullParameter(walletAddCardFragment, "this$0");
        WalletAddCardNavigationInterface walletAddCardNavigationInterface = walletAddCardFragment.addCardNavigationInterface;
        if (walletAddCardNavigationInterface != null) {
            walletAddCardNavigationInterface.onBackPressed();
        }
    }

    private final void showErrorStatusNotification(String str) {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(progressBar, "progress_bar");
        progressBarLoading.hideProgress(progressBar);
        delay(AnimationSpeed.VERY_SLOW.getValue(), new WalletAddCardFragment$showErrorStatusNotification$1(this, str));
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

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
    }

    public void navigateToAddCardSuccessScreen() {
        AddCardNavigationUtility.INSTANCE.navigateToAddCardSuccessScreen(getArguments(), getContext(), this.addCardSuccessListener);
    }

    public void navigateToThreeDSScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "redirectUrl");
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putString(WalletNavigatorActions.WALLET_THREE_DS_URL_KEY, str);
        }
        WalletAddCardNavigationInterface walletAddCardNavigationInterface = this.addCardNavigationInterface;
        if (walletAddCardNavigationInterface != null) {
            walletAddCardNavigationInterface.navigateToThreeDsScreen(getArguments());
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletAddCardFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletAddCardFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_wallet_add_card, viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        int i11 = R.id.add_card_custom_view;
        AddCardCustomView addCardCustomView = (AddCardCustomView) _$_findCachedViewById(i11);
        Bundle arguments = getArguments();
        Boolean bool = null;
        if (arguments != null) {
            str = arguments.getString("source");
        } else {
            str = null;
        }
        if (str == null) {
            str = "walletPaymentBottomSheet";
        }
        addCardCustomView.setSource(str);
        ((AddCardCustomView) _$_findCachedViewById(i11)).resetObservers();
        ((AddCardCustomView) _$_findCachedViewById(i11)).setAddCardCustomViewListener(this);
        int i12 = R.id.save_button;
        ((TalabatFillButton) _$_findCachedViewById(i12)).setEnabled(false);
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(progressBar, "progress_bar");
        progressBarLoading.hideProgress(progressBar);
        ((TalabatFillButton) _$_findCachedViewById(i12)).setOnClickListener(new k(this));
        ((ImageButton) _$_findCachedViewById(R.id.back_icon)).setOnClickListener(new l(this));
        addLearnMoreListener();
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            bool = Boolean.valueOf(arguments2.getBoolean(WalletNavigatorActions.EXTRA_WALLET_ADD_CARD_ERROR));
        }
        if (BooleanKt.orFalse(bool)) {
            String string = getString(com.talabat.localization.R.string.invalid_card_info);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…string.invalid_card_info)");
            showErrorStatusNotification(string);
        }
    }

    public final void setAddCardNavigationInterface(@NotNull WalletAddCardNavigationInterface walletAddCardNavigationInterface) {
        Intrinsics.checkNotNullParameter(walletAddCardNavigationInterface, "addCardNavigationInterface");
        this.addCardNavigationInterface = walletAddCardNavigationInterface;
    }

    public final void setAddCardSuccessListener(@NotNull WalletAddCardSuccessInterface walletAddCardSuccessInterface) {
        Intrinsics.checkNotNullParameter(walletAddCardSuccessInterface, "addCardSuccessListener");
        this.addCardSuccessListener = walletAddCardSuccessInterface;
    }

    public void showInvalidCardInputMessage() {
        String string = getString(com.talabat.localization.R.string.invalid_card_info);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…string.invalid_card_info)");
        showErrorStatusNotification(string);
    }

    public void showServiceErrorMessage() {
        String string = getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.something_went_wrong)");
        showErrorStatusNotification(string);
    }

    public void toggleAddCardButton(boolean z11) {
        TalabatFillButton talabatFillButton = (TalabatFillButton) _$_findCachedViewById(R.id.save_button);
        if (talabatFillButton != null) {
            talabatFillButton.setEnabled(z11);
        }
    }
}
