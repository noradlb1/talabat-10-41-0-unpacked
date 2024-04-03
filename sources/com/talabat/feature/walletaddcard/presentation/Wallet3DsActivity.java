package com.talabat.feature.walletaddcard.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.databinding.ActivityWallet3dsWebViewBinding;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/walletaddcard/presentation/Wallet3DsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/talabat/talabatcommon/databinding/ActivityWallet3dsWebViewBinding;", "getBinding", "()Lcom/talabat/talabatcommon/databinding/ActivityWallet3dsWebViewBinding;", "binding$delegate", "Lkotlin/Lazy;", "addWebViewListener", "", "loadUrl", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "redirectToErrorScreen", "redirectToSuccessScreen", "Companion", "com_talabat_feature_wallet-add-card_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Wallet3DsActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int RESULT_CODE_3DS_FAILED = 201;
    @NotNull
    public static final String WALLET_THREE_DS_URL_KEY = "wallet_three_ds_url_key";
    public Trace _nr_trace;
    @NotNull
    private final Lazy binding$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Wallet3DsActivity$binding$2(this));

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/walletaddcard/presentation/Wallet3DsActivity$Companion;", "", "()V", "RESULT_CODE_3DS_FAILED", "", "WALLET_THREE_DS_URL_KEY", "", "com_talabat_feature_wallet-add-card_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void addWebViewListener() {
        getBinding().wallet3dsWebView.setWebViewClient(new Wallet3DsActivity$addWebViewListener$1(this));
    }

    private final ActivityWallet3dsWebViewBinding getBinding() {
        return (ActivityWallet3dsWebViewBinding) this.binding$delegate.getValue();
    }

    private final void loadUrl() {
        String str;
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra(WALLET_THREE_DS_URL_KEY);
        } else {
            str = null;
        }
        if (str != null) {
            getBinding().wallet3dsWebView.loadUrl(str);
        }
    }

    /* access modifiers changed from: private */
    public final void redirectToErrorScreen() {
        setResult(201);
        finish();
    }

    /* access modifiers changed from: private */
    public final void redirectToSuccessScreen() {
        setResult(-1);
        finish();
    }

    public void onBackPressed() {
        redirectToErrorScreen();
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("Wallet3DsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "Wallet3DsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "Wallet3DsActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView((View) getBinding().getRoot());
        getBinding().wallet3dsNavigationBar.setLeadingIconButton(new DSIconButtonModel(R.drawable.ds_close, new Wallet3DsActivity$onCreate$1(this)));
        getBinding().wallet3dsWebView.getSettings().setJavaScriptEnabled(true);
        addWebViewListener();
        loadUrl();
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
