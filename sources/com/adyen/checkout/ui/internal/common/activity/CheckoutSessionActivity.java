package com.adyen.checkout.ui.internal.common.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.adyen.checkout.base.LogoApi;
import com.adyen.checkout.core.AuthenticationDetails;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.NetworkingState;
import com.adyen.checkout.core.Observer;
import com.adyen.checkout.core.PaymentHandler;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.PaymentResult;
import com.adyen.checkout.core.RedirectDetails;
import com.adyen.checkout.core.handler.AuthenticationHandler;
import com.adyen.checkout.core.handler.ErrorHandler;
import com.adyen.checkout.core.handler.RedirectHandler;
import com.adyen.checkout.core.internal.model.ChallengeAuthentication;
import com.adyen.checkout.core.internal.model.FingerprintAuthentication;
import com.adyen.checkout.core.model.ChallengeDetails;
import com.adyen.checkout.core.model.FingerprintDetails;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.threeds.Card3DS2Authenticator;
import com.adyen.checkout.threeds.ChallengeResult;
import com.adyen.checkout.threeds.ThreeDS2Exception;
import com.adyen.checkout.ui.internal.common.fragment.ErrorDialogFragment;
import com.adyen.checkout.ui.internal.common.fragment.ProgressDialogFragment;
import com.adyen.checkout.ui.internal.common.model.CheckoutSessionProvider;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public abstract class CheckoutSessionActivity extends AppCompatActivity implements CheckoutSessionProvider, AuthenticationHandler, TraceFieldInterface {
    @NonNull
    public static final String EXTRA_PAYMENT_REFERENCE = "EXTRA_PAYMENT_REFERENCE";
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public Card3DS2Authenticator mCard3DS2Authenticator;
    private PaymentHandler mPaymentHandler;
    /* access modifiers changed from: private */
    public PaymentSession mPaymentSession;

    /* renamed from: com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity$8  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40215a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.checkout.core.model.PaymentResultCode[] r0 = com.adyen.checkout.core.model.PaymentResultCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40215a = r0
                com.adyen.checkout.core.model.PaymentResultCode r1 = com.adyen.checkout.core.model.PaymentResultCode.IDENTIFY_SHOPPER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40215a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.core.model.PaymentResultCode r1 = com.adyen.checkout.core.model.PaymentResultCode.CHALLENGE_SHOPPER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity.AnonymousClass8.<clinit>():void");
        }
    }

    @NonNull
    public LogoApi N() {
        return this.mPaymentHandler.getLogoApi();
    }

    @Nullable
    public PaymentSession O() {
        return this.mPaymentSession;
    }

    public void P(@NonNull CheckoutException checkoutException) {
        if (checkoutException.isFatal()) {
            Intent intent = new Intent();
            intent.putExtra(PaymentMethodHandler.RESULT_CHECKOUT_EXCEPTION, checkoutException);
            setResult(1, intent);
            finish();
            return;
        }
        ErrorDialogFragment.newInstance((Context) this, (Throwable) checkoutException).showIfNotShown(getSupportFragmentManager());
    }

    public void Q(@NonNull PaymentResult paymentResult) {
        Intent intent = new Intent();
        intent.putExtra(PaymentMethodHandler.RESULT_PAYMENT_RESULT, paymentResult);
        setResult(-1, intent);
        finish();
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @NonNull
    public PaymentHandler getPaymentHandler() {
        return this.mPaymentHandler;
    }

    @NonNull
    public PaymentReference getPaymentReference() {
        if (!getIntent().hasExtra(EXTRA_PAYMENT_REFERENCE)) {
            P(new CheckoutException.Builder("Unable to find PaymentReference on Intent.", (Throwable) null).setFatal(true).build());
        }
        return (PaymentReference) getIntent().getParcelableExtra(EXTRA_PAYMENT_REFERENCE);
    }

    public void onAuthenticationDetailsRequired(@NonNull AuthenticationDetails authenticationDetails) {
        if (this.mCard3DS2Authenticator.isReleased()) {
            this.mCard3DS2Authenticator = new Card3DS2Authenticator(this);
        }
        try {
            int i11 = AnonymousClass8.f40215a[authenticationDetails.getResultCode().ordinal()];
            if (i11 == 1) {
                this.mCard3DS2Authenticator.createFingerprint(((FingerprintAuthentication) authenticationDetails.getAuthentication(FingerprintAuthentication.class)).getFingerprintToken(), new Card3DS2Authenticator.FingerprintListener() {
                    public void onFailure(@NonNull ThreeDS2Exception threeDS2Exception) {
                        CheckoutSessionActivity.this.mCard3DS2Authenticator.release();
                        if (CheckoutSessionActivity.this.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                            ErrorDialogFragment.newInstance((Context) CheckoutSessionActivity.this, (Throwable) threeDS2Exception).showIfNotShown(CheckoutSessionActivity.this.getSupportFragmentManager());
                        }
                    }

                    public void onSuccess(@NonNull String str) {
                        CheckoutSessionActivity.this.getPaymentHandler().submitAuthenticationDetails(new FingerprintDetails(str));
                    }
                });
            } else if (i11 != 2) {
                P(new CheckoutException.Builder("Authentication failed.", new IllegalStateException("Unsupported result code: " + authenticationDetails.getResultCode())).build());
            } else {
                this.mCard3DS2Authenticator.presentChallenge(((ChallengeAuthentication) authenticationDetails.getAuthentication(ChallengeAuthentication.class)).getChallengeToken(), new Card3DS2Authenticator.SimpleChallengeListener() {
                    public void onFailure(@NonNull ThreeDS2Exception threeDS2Exception) {
                        CheckoutSessionActivity.this.mCard3DS2Authenticator.release();
                        ErrorDialogFragment.newInstance((Context) CheckoutSessionActivity.this, (Throwable) threeDS2Exception).showIfNotShown(CheckoutSessionActivity.this.getSupportFragmentManager());
                    }

                    public void onSuccess(@NonNull ChallengeResult challengeResult) {
                        CheckoutSessionActivity.this.mCard3DS2Authenticator.release();
                        CheckoutSessionActivity.this.getPaymentHandler().submitAuthenticationDetails(new ChallengeDetails(challengeResult.getPayload()));
                    }
                });
            }
        } catch (CheckoutException e11) {
            P(e11);
        } catch (ThreeDS2Exception e12) {
            P(new CheckoutException.Builder("Authentication failed.", e12).build());
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("CheckoutSessionActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CheckoutSessionActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CheckoutSessionActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        PaymentHandler paymentHandler = getPaymentReference().getPaymentHandler(this);
        this.mPaymentHandler = paymentHandler;
        paymentHandler.getNetworkingStateObservable().observe(this, new Observer<NetworkingState>() {
            public void onChanged(@NonNull NetworkingState networkingState) {
                if (networkingState.isExecutingRequests()) {
                    ProgressDialogFragment.show((AppCompatActivity) CheckoutSessionActivity.this);
                } else {
                    ProgressDialogFragment.hide((AppCompatActivity) CheckoutSessionActivity.this);
                }
            }
        });
        this.mPaymentHandler.getPaymentSessionObservable().observe(this, new Observer<PaymentSession>() {
            public void onChanged(@NonNull PaymentSession paymentSession) {
                PaymentSession unused = CheckoutSessionActivity.this.mPaymentSession = paymentSession;
            }
        });
        this.mPaymentHandler.getPaymentResultObservable().observe(this, new Observer<PaymentResult>() {
            public void onChanged(@NonNull PaymentResult paymentResult) {
                CheckoutSessionActivity.this.Q(paymentResult);
            }
        });
        this.mPaymentHandler.setRedirectHandler(this, new RedirectHandler() {
            public void onRedirectRequired(@NonNull RedirectDetails redirectDetails) {
                CheckoutSessionActivity checkoutSessionActivity = CheckoutSessionActivity.this;
                CheckoutSessionActivity.this.startActivity(RedirectHandlerActivity.newIntent(checkoutSessionActivity, checkoutSessionActivity.getPaymentReference(), redirectDetails));
            }
        });
        this.mPaymentHandler.setErrorHandler(this, new ErrorHandler() {
            public void onError(@NonNull CheckoutException checkoutException) {
                CheckoutSessionActivity.this.P(checkoutException);
            }
        });
        try {
            this.mCard3DS2Authenticator = new Card3DS2Authenticator(this);
            this.mPaymentHandler.setAuthenticationHandler(this, this);
        } catch (NoClassDefFoundError unused2) {
            this.mCard3DS2Authenticator = null;
        }
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
