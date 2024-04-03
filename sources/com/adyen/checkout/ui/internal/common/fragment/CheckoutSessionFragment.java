package com.adyen.checkout.ui.internal.common.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.base.internal.Objects;
import com.adyen.checkout.core.Observer;
import com.adyen.checkout.core.PaymentHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.internal.common.model.CheckoutSessionProvider;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public abstract class CheckoutSessionFragment extends Fragment implements CheckoutSessionProvider, TraceFieldInterface {
    public Trace _nr_trace;
    private PaymentHandler mPaymentHandler;
    private PaymentReference mPaymentReference;
    /* access modifiers changed from: private */
    public PaymentSession mPaymentSession;

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @NonNull
    public PaymentHandler getPaymentHandler() {
        if (this.mPaymentHandler == null) {
            this.mPaymentHandler = getPaymentReference().getPaymentHandler(getActivity());
        }
        return this.mPaymentHandler;
    }

    @NonNull
    public PaymentReference getPaymentReference() {
        if (this.mPaymentReference == null) {
            this.mPaymentReference = (PaymentReference) Objects.requireNonNull(((Bundle) Objects.requireNonNull(getArguments(), "Arguments Bundle is null.")).getParcelable("ARG_PAYMENT_REFERENCE"), "PaymentReference is null.");
        }
        return this.mPaymentReference;
    }

    @NonNull
    public LogoApi i0() {
        return getPaymentHandler().getLogoApi();
    }

    @Nullable
    public PaymentSession j0() {
        return this.mPaymentSession;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("CheckoutSessionFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CheckoutSessionFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CheckoutSessionFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        getPaymentHandler().getPaymentSessionObservable().observe(getActivity(), new Observer<PaymentSession>() {
            public void onChanged(@NonNull PaymentSession paymentSession) {
                PaymentSession unused = CheckoutSessionFragment.this.mPaymentSession = paymentSession;
            }
        });
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
