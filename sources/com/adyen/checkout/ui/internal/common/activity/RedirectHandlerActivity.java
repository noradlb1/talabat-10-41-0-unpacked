package com.adyen.checkout.ui.internal.common.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import com.adyen.checkout.core.PaymentHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.RedirectDetails;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.RedirectUtil;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetFragmentKt;
import java.util.ArrayList;

@Instrumented
public class RedirectHandlerActivity extends AppCompatActivity implements TraceFieldInterface {
    private static final int CHECK_REDIRECT_DELAY_MILLIS = 1500;
    private static final String EXTRA_PAYMENT_REFERENCE = "EXTRA_PAYMENT_REFERENCE";
    private static final String EXTRA_REDIRECT_DETAILS = "EXTRA_REDIRECT_DETAILS";
    private static final int REQUEST_CODE_REDIRECT = 1;
    private static final String STATE_ON_ACTIVITY_RESULT_CALLED_FOR_REDIRECT = "STATE_ON_ACTIVITY_RESULT_CALLED_FOR_REDIRECT";
    private static final String STATE_ON_NEW_INTENT_CALLED_FOR_REDIRECT = "STATE_ON_NEW_INTENT_CALLED_FOR_REDIRECT";
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public boolean mOnActivityResultCalledForRedirect;
    /* access modifiers changed from: private */
    public boolean mOnNewIntentCalledForRedirect;
    private PaymentHandler mPaymentHandler;
    private PaymentReference mPaymentReference;

    @NonNull
    private View createContentView() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_dialog_size);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(layoutParams);
        progressBar.setIndeterminate(true);
        ThemeUtil.applyPrimaryThemeColor(this, progressBar.getProgressDrawable(), progressBar.getIndeterminateDrawable());
        return progressBar;
    }

    @NonNull
    private Intent createRedirectIntent(@NonNull Uri uri) {
        if (RedirectUtil.determineResolveResult((Context) this, uri).getResolveType() == RedirectUtil.ResolveType.APPLICATION) {
            return new Intent("android.intent.action.VIEW", uri);
        }
        CustomTabsIntent build = new CustomTabsIntent.Builder().setShowTitle(true).setToolbarColor(ThemeUtil.getPrimaryThemeColor(this)).build();
        build.intent.setData(uri);
        return build.intent;
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull RedirectDetails redirectDetails) {
        Intent intent = new Intent(context, RedirectHandlerActivity.class);
        intent.putExtra("EXTRA_PAYMENT_REFERENCE", paymentReference);
        intent.putExtra(EXTRA_REDIRECT_DETAILS, redirectDetails);
        return intent;
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1) {
            this.mOnActivityResultCalledForRedirect = true;
        }
    }

    public void onBackPressed() {
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public void onCreate(@Nullable Bundle bundle) {
        boolean z11;
        TraceMachine.startTracing("RedirectHandlerActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "RedirectHandlerActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RedirectHandlerActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(createContentView());
        boolean z12 = false;
        overridePendingTransition(0, 0);
        PaymentReference paymentReference = (PaymentReference) getIntent().getParcelableExtra("EXTRA_PAYMENT_REFERENCE");
        this.mPaymentReference = paymentReference;
        if (paymentReference == null) {
            finish();
            TraceMachine.exitMethod();
            return;
        }
        this.mPaymentHandler = paymentReference.getPaymentHandler(this);
        if (bundle == null || !bundle.getBoolean(STATE_ON_ACTIVITY_RESULT_CALLED_FOR_REDIRECT)) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.mOnActivityResultCalledForRedirect = z11;
        if (bundle != null && bundle.getBoolean(STATE_ON_NEW_INTENT_CALLED_FOR_REDIRECT)) {
            z12 = true;
        }
        this.mOnNewIntentCalledForRedirect = z12;
        if (bundle == null) {
            Intent createRedirectIntent = createRedirectIntent(((RedirectDetails) getIntent().getParcelableExtra(EXTRA_REDIRECT_DETAILS)).getUri());
            if (Build.VERSION.SDK_INT >= 30 || createRedirectIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(createRedirectIntent, 1);
            } else {
                Toast.makeText(getApplicationContext(), R.string.checkout_error_redirect_failed, 1).show();
                finish();
            }
        }
        TraceMachine.exitMethod();
    }

    public void onNewIntent(@NonNull Intent intent) {
        super.onNewIntent(intent);
        Uri data = intent.getData();
        if (data != null) {
            this.mOnNewIntentCalledForRedirect = true;
            this.mPaymentHandler.handleRedirectResult(data);
            finish();
        }
    }

    public void onResume() {
        super.onResume();
        getWindow().getDecorView().postDelayed(new Runnable() {
            public void run() {
                if (RedirectHandlerActivity.this.mOnActivityResultCalledForRedirect && !RedirectHandlerActivity.this.mOnNewIntentCalledForRedirect) {
                    RedirectHandlerActivity.this.finish();
                    RedirectHandlerActivity.this.overridePendingTransition(0, 0);
                }
            }
        }, PaymentWidgetBottomSheetFragmentKt.DURATION_DELAY_DURING_FAILURE);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(STATE_ON_ACTIVITY_RESULT_CALLED_FOR_REDIRECT, this.mOnActivityResultCalledForRedirect);
        bundle.putBoolean(STATE_ON_NEW_INTENT_CALLED_FOR_REDIRECT, this.mOnNewIntentCalledForRedirect);
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
