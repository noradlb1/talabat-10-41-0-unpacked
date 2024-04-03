package com.talabat.wallet.ui.walletTransactionDetail.view.refundBottomSheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.utils.CreditCardHelperInterface;
import com.talabat.talabatcommon.utils.CurrencyFormatter;
import com.talabat.talabatcommon.views.TalabatStrokeButton;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletTransactionDetail.model.WalletRefundBottomSheetDisplayModel;
import com.talabat.wallet.ui.walletTransactionDetail.view.di.DaggerWalletTransactionDetailRefundFragmentComponent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import jz.a;
import jz.b;
import jz.c;
import jz.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001!B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0006\u0010\u001c\u001a\u00020\u000eJ\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\""}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/utils/CreditCardHelperInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "listener", "Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundFragment$WalletTransactionDetailRefundFragmentInterface;", "(Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundFragment$WalletTransactionDetailRefundFragmentInterface;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setOnClickListeners", "showErrorScreen", "showRefundInfo", "displayModel", "Lcom/talabat/wallet/ui/walletTransactionDetail/model/WalletRefundBottomSheetDisplayModel;", "showSuccessScreen", "WalletTransactionDetailRefundFragmentInterface", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailRefundFragment extends Fragment implements CreditCardHelperInterface, AnimationHelper, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final WalletTransactionDetailRefundFragmentInterface listener;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/walletTransactionDetail/view/refundBottomSheet/WalletTransactionDetailRefundFragment$WalletTransactionDetailRefundFragmentInterface;", "", "closeBottomSheetDialog", "", "revertRefund", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletTransactionDetailRefundFragmentInterface {
        void closeBottomSheetDialog();

        void revertRefund();
    }

    public WalletTransactionDetailRefundFragment(@NotNull WalletTransactionDetailRefundFragmentInterface walletTransactionDetailRefundFragmentInterface) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailRefundFragmentInterface, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = walletTransactionDetailRefundFragmentInterface;
    }

    private final void setOnClickListeners() {
        ((LinearLayout) _$_findCachedViewById(R.id.send_refund)).setOnClickListener(new a(this));
        ((TextView) _$_findCachedViewById(R.id.success_dismiss)).setOnClickListener(new b(this));
        ((TextView) _$_findCachedViewById(R.id.failure_dismiss)).setOnClickListener(new c(this));
        ((TalabatStrokeButton) _$_findCachedViewById(R.id.keep_credit_in_card)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListeners$lambda-0  reason: not valid java name */
    public static final void m6077setOnClickListeners$lambda0(WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailRefundFragment, "this$0");
        walletTransactionDetailRefundFragment._$_findCachedViewById(R.id.progress_bar).setVisibility(0);
        walletTransactionDetailRefundFragment.listener.revertRefund();
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListeners$lambda-1  reason: not valid java name */
    public static final void m6078setOnClickListeners$lambda1(WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailRefundFragment, "this$0");
        walletTransactionDetailRefundFragment.listener.closeBottomSheetDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListeners$lambda-2  reason: not valid java name */
    public static final void m6079setOnClickListeners$lambda2(WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailRefundFragment, "this$0");
        walletTransactionDetailRefundFragment.listener.closeBottomSheetDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: setOnClickListeners$lambda-3  reason: not valid java name */
    public static final void m6080setOnClickListeners$lambda3(WalletTransactionDetailRefundFragment walletTransactionDetailRefundFragment, View view) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailRefundFragment, "this$0");
        walletTransactionDetailRefundFragment.listener.closeBottomSheetDialog();
    }

    private final void showRefundInfo(WalletRefundBottomSheetDisplayModel walletRefundBottomSheetDisplayModel) {
        ((TextView) _$_findCachedViewById(R.id.refund_amount)).setText(CurrencyFormatter.Companion.formatAmount(getLocationConfigurationRepository(), walletRefundBottomSheetDisplayModel.getRevertAmount(), true));
        PaymentMethod paymentMethod = walletRefundBottomSheetDisplayModel.getPaymentMethod();
        String cardType = walletRefundBottomSheetDisplayModel.getCardType();
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.credit_card_icon);
        Intrinsics.checkNotNullExpressionValue(imageView, "credit_card_icon");
        displayPaymentIcon(paymentMethod, cardType, imageView);
        Context context = getContext();
        if (context != null) {
            PaymentMethod paymentMethod2 = walletRefundBottomSheetDisplayModel.getPaymentMethod();
            String cardType2 = walletRefundBottomSheetDisplayModel.getCardType();
            String takeLast = StringsKt___StringsKt.takeLast(walletRefundBottomSheetDisplayModel.getCard4Digits(), 4);
            TextView textView = (TextView) _$_findCachedViewById(R.id.credit_card_number);
            Intrinsics.checkNotNullExpressionValue(textView, "credit_card_number");
            displayPaymentName(paymentMethod2, cardType2, takeLast, textView, context);
        }
        ((TextView) _$_findCachedViewById(R.id.refund_bottom_sheet_message)).setText(getString(com.talabat.localization.R.string.bank_revert_message, String.valueOf(walletRefundBottomSheetDisplayModel.getRevertMinDays()), String.valueOf(walletRefundBottomSheetDisplayModel.getRevertMaxDays())));
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

    public void displayPaymentIcon(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentIcon(this, paymentMethod, str, imageView);
    }

    public void displayPaymentName(@NotNull PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull TextView textView, @NotNull Context context) {
        CreditCardHelperInterface.DefaultImpls.displayPaymentName(this, paymentMethod, str, str2, textView, context);
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

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerWalletTransactionDetailRefundFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletTransactionDetailRefundFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletTransactionDetailRefundFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.view_wallet_refund_botttom_sheet, viewGroup, false);
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
        WalletRefundBottomSheetDisplayModel walletRefundBottomSheetDisplayModel;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (walletRefundBottomSheetDisplayModel = (WalletRefundBottomSheetDisplayModel) arguments.getParcelable(WalletNavigatorActions.EXTRA_REFUND_BOTTOM_SHEET)) == null) {
            walletRefundBottomSheetDisplayModel = new WalletRefundBottomSheetDisplayModel((PaymentMethod) null, (String) null, 0.0f, 0, 0, (String) null, 63, (DefaultConstructorMarker) null);
        }
        showRefundInfo(walletRefundBottomSheetDisplayModel);
        setOnClickListeners();
    }

    public void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView) {
        CreditCardHelperInterface.DefaultImpls.setCardTypeIcon(this, str, imageView);
    }

    public void setExpiryInformation(@NotNull String str, @NotNull String str2, @NotNull TextView textView, @Nullable Context context) {
        CreditCardHelperInterface.DefaultImpls.setExpiryInformation(this, str, str2, textView, context);
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void showErrorScreen() {
        _$_findCachedViewById(R.id.progress_bar).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.refund_container)).setVisibility(4);
        _$_findCachedViewById(R.id.refund_failure_container).setVisibility(0);
    }

    public final void showSuccessScreen() {
        _$_findCachedViewById(R.id.progress_bar).setVisibility(8);
        ((ConstraintLayout) _$_findCachedViewById(R.id.refund_container)).setVisibility(4);
        _$_findCachedViewById(R.id.refund_success_container).setVisibility(0);
    }
}
