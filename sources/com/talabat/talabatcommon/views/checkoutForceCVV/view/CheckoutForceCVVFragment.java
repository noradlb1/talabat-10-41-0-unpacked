package com.talabat.talabatcommon.views.checkoutForceCVV.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.materialedittext.MaterialEditText;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.bugreport.TalabatBugReportManager;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.checkoutForceCVV.di.DaggerCheckoutForceCVVFragmentComponent;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardValidator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kv.a;
import kv.b;
import kv.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u001a\u0010!\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006("}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVFragment;", "Landroidx/fragment/app/Fragment;", "cardNumber", "", "checkoutForceCVVFragmentInterface", "Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVFragment$CheckoutForceCVVFragmentInterface;", "(Ljava/lang/String;Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVFragment$CheckoutForceCVVFragmentInterface;)V", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "getPaymentConfigurationRepository", "()Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "setPaymentConfigurationRepository", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;)V", "addSecurityCodeListener", "", "cancelButtonClickListener", "disAbleSearchButtonOnKeyboard", "editText", "Landroid/widget/EditText;", "hideKeyBoard", "view", "Landroid/view/View;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "payButtonOnClickListener", "showCVVIcon", "cvvLength", "", "updatePayButtonStatus", "CheckoutForceCVVFragmentInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutForceCVVFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final String cardNumber;
    @NotNull
    private final CheckoutForceCVVFragmentInterface checkoutForceCVVFragmentInterface;
    @Inject
    public PaymentConfigurationRepository paymentConfigurationRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/checkoutForceCVV/view/CheckoutForceCVVFragment$CheckoutForceCVVFragmentInterface;", "", "closeBottomSheet", "", "sendCVVToParentScreen", "cvv", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface CheckoutForceCVVFragmentInterface {
        void closeBottomSheet();

        void sendCVVToParentScreen(@NotNull String str);
    }

    public CheckoutForceCVVFragment(@NotNull String str, @NotNull CheckoutForceCVVFragmentInterface checkoutForceCVVFragmentInterface2) {
        Intrinsics.checkNotNullParameter(str, "cardNumber");
        Intrinsics.checkNotNullParameter(checkoutForceCVVFragmentInterface2, "checkoutForceCVVFragmentInterface");
        this.cardNumber = str;
        this.checkoutForceCVVFragmentInterface = checkoutForceCVVFragmentInterface2;
    }

    private final void addSecurityCodeListener() {
        ((MaterialEditText) _$_findCachedViewById(R.id.checkout_security_code)).addTextChangedListener(new CheckoutForceCVVFragment$addSecurityCodeListener$1(this));
    }

    private final void cancelButtonClickListener() {
        ((ImageView) _$_findCachedViewById(R.id.cancel_button)).setOnClickListener(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: cancelButtonClickListener$lambda-1  reason: not valid java name */
    public static final void m5760cancelButtonClickListener$lambda1(CheckoutForceCVVFragment checkoutForceCVVFragment, View view) {
        Intrinsics.checkNotNullParameter(checkoutForceCVVFragment, "this$0");
        MaterialEditText materialEditText = (MaterialEditText) checkoutForceCVVFragment._$_findCachedViewById(R.id.checkout_security_code);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "checkout_security_code");
        checkoutForceCVVFragment.hideKeyBoard(materialEditText);
        checkoutForceCVVFragment.checkoutForceCVVFragmentInterface.closeBottomSheet();
    }

    private final void disAbleSearchButtonOnKeyboard(EditText editText) {
        editText.setOnEditorActionListener(new b());
    }

    /* access modifiers changed from: private */
    /* renamed from: disAbleSearchButtonOnKeyboard$lambda-3  reason: not valid java name */
    public static final boolean m5761disAbleSearchButtonOnKeyboard$lambda3(TextView textView, int i11, KeyEvent keyEvent) {
        return i11 == 3;
    }

    private final void hideKeyBoard(View view) {
        Object obj;
        Context context = getContext();
        if (context != null) {
            obj = context.getSystemService("input_method");
        } else {
            obj = null;
        }
        if (obj != null) {
            ((InputMethodManager) obj).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void payButtonOnClickListener() {
        ((TalabatFillButton) _$_findCachedViewById(R.id.pay_button)).setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: payButtonOnClickListener$lambda-2  reason: not valid java name */
    public static final void m5762payButtonOnClickListener$lambda2(CheckoutForceCVVFragment checkoutForceCVVFragment, View view) {
        String str;
        Editable text;
        Intrinsics.checkNotNullParameter(checkoutForceCVVFragment, "this$0");
        ((TalabatFillButton) checkoutForceCVVFragment._$_findCachedViewById(R.id.pay_button)).setEnabled(false);
        CheckoutForceCVVFragmentInterface checkoutForceCVVFragmentInterface2 = checkoutForceCVVFragment.checkoutForceCVVFragmentInterface;
        int i11 = R.id.checkout_security_code;
        MaterialEditText materialEditText = (MaterialEditText) checkoutForceCVVFragment._$_findCachedViewById(i11);
        if (materialEditText == null || (text = materialEditText.getText()) == null) {
            str = null;
        } else {
            str = text.toString();
        }
        if (str == null) {
            str = "";
        }
        checkoutForceCVVFragmentInterface2.sendCVVToParentScreen(str);
        MaterialEditText materialEditText2 = (MaterialEditText) checkoutForceCVVFragment._$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(materialEditText2, "checkout_security_code");
        checkoutForceCVVFragment.hideKeyBoard(materialEditText2);
        checkoutForceCVVFragment.checkoutForceCVVFragmentInterface.closeBottomSheet();
    }

    private final void showCVVIcon(int i11) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (i11 == 3) {
            ((ImageView) _$_findCachedViewById(R.id.ic_cvv_sample)).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_show_cvv));
        } else {
            ((ImageView) _$_findCachedViewById(R.id.ic_cvv_sample)).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_show_cvv_amex));
        }
    }

    /* access modifiers changed from: private */
    public final void updatePayButtonStatus(int i11) {
        boolean z11;
        TalabatFillButton talabatFillButton = (TalabatFillButton) _$_findCachedViewById(R.id.pay_button);
        if (i11 == WalletCardValidator.INSTANCE.getCardType(this.cardNumber, getPaymentConfigurationRepository().walletConfig().isAmexAvailable()).getCvvLength()) {
            z11 = true;
        } else {
            z11 = false;
        }
        talabatFillButton.setEnabled(z11);
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

    @NotNull
    public final PaymentConfigurationRepository getPaymentConfigurationRepository() {
        PaymentConfigurationRepository paymentConfigurationRepository2 = this.paymentConfigurationRepository;
        if (paymentConfigurationRepository2 != null) {
            return paymentConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentConfigurationRepository");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerCheckoutForceCVVFragmentComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "CheckoutForceCVVFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CheckoutForceCVVFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_checkout_force_cvv, viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroyView() {
        TalabatBugReportManager talabatBugReportManager = TalabatBugReportManager.INSTANCE;
        MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(R.id.checkout_security_code);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "checkout_security_code");
        talabatBugReportManager.removeViewBlocking(materialEditText);
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
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        int cvvLength = WalletCardValidator.INSTANCE.getCardType(this.cardNumber, getPaymentConfigurationRepository().walletConfig().isAmexAvailable()).getCvvLength();
        ((TextView) _$_findCachedViewById(R.id.force_cvv_message)).setText(getString(com.talabat.localization.R.string.checkout_security_code_message, String.valueOf(cvvLength)));
        showCVVIcon(cvvLength);
        int i11 = R.id.checkout_security_code;
        ((MaterialEditText) _$_findCachedViewById(i11)).setFilters(new InputFilter[]{new InputFilter.LengthFilter(cvvLength)});
        ((MaterialEditText) _$_findCachedViewById(i11)).requestFocus();
        addSecurityCodeListener();
        MaterialEditText materialEditText = (MaterialEditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(materialEditText, "checkout_security_code");
        disAbleSearchButtonOnKeyboard(materialEditText);
        payButtonOnClickListener();
        cancelButtonClickListener();
        TalabatBugReportManager talabatBugReportManager = TalabatBugReportManager.INSTANCE;
        MaterialEditText materialEditText2 = (MaterialEditText) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(materialEditText2, "checkout_security_code");
        talabatBugReportManager.blockViewsRecording(materialEditText2);
    }

    public final void setPaymentConfigurationRepository(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "<set-?>");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }
}
