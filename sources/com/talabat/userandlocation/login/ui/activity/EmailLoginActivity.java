package com.talabat.userandlocation.login.ui.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.fragment.app.FragmentTransaction;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatnavigation.userandlocation.EmailLoginActivityResults;
import com.talabat.userandlocation.login.R;
import com.talabat.userandlocation.login.ui.fragment.EnterEmailFragment;
import com.talabat.userandlocation.login.ui.fragment.EnterPasswordFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\u0005H\u0014J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\"\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002¨\u0006\u0017"}, d2 = {"Lcom/talabat/userandlocation/login/ui/activity/EmailLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroidx/fragment/app/FragmentOnAttachListener;", "()V", "onAttachFragment", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMoveToNextScreen", "data", "", "replaceFragmentNow", "tag", "addToBackStack", "", "setSuccessLoggedInResultAndFinish", "Companion", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EmailLoginActivity extends AppCompatActivity implements FragmentOnAttachListener, TraceFieldInterface {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String TAG_ENTER_EMAIL = "EnterEmailFragment";
    @NotNull
    @Deprecated
    public static final String TAG_ENTER_PASSWORD = "EnterPasswordFragment";
    public Trace _nr_trace;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/userandlocation/login/ui/activity/EmailLoginActivity$Companion;", "", "()V", "TAG_ENTER_EMAIL", "", "TAG_ENTER_PASSWORD", "com_talabat_NewArchi_UserAndLocation_Login_Login"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void g(EmailLoginActivity emailLoginActivity, Fragment fragment, String str, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        emailLoginActivity.replaceFragmentNow(fragment, str, z11);
    }

    /* access modifiers changed from: private */
    public final void onMoveToNextScreen(String str) {
        replaceFragmentNow(EnterPasswordFragment.Companion.newInstance(str), TAG_ENTER_PASSWORD, true);
    }

    private final void replaceFragmentNow(Fragment fragment, String str, boolean z11) {
        FragmentTransaction replace = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, str);
        Intrinsics.checkNotNullExpressionValue(replace, "supportFragmentManager\n …container, fragment, tag)");
        if (z11) {
            replace.addToBackStack((String) null);
        }
        replace.commitAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public final void setSuccessLoggedInResultAndFinish() {
        setResult(EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode());
        finish();
    }

    public void onAttachFragment(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        EnterEmailFragment enterEmailFragment;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        EnterPasswordFragment enterPasswordFragment = null;
        if (fragment instanceof EnterEmailFragment) {
            enterEmailFragment = (EnterEmailFragment) fragment;
        } else {
            enterEmailFragment = null;
        }
        if (enterEmailFragment != null) {
            enterEmailFragment.setMoveToNextListener(new EmailLoginActivity$onAttachFragment$1$1(this));
            enterEmailFragment.setOnBackButtonPressed(new EmailLoginActivity$onAttachFragment$1$2(this));
            enterEmailFragment.setOnSuccessResultFromUserRegistration(new EmailLoginActivity$onAttachFragment$1$3(this));
        }
        if (fragment instanceof EnterPasswordFragment) {
            enterPasswordFragment = (EnterPasswordFragment) fragment;
        }
        if (enterPasswordFragment != null) {
            enterPasswordFragment.setOnBackButtonPressed(new EmailLoginActivity$onAttachFragment$2$1(this));
            enterPasswordFragment.setOnLoginSuccess(new EmailLoginActivity$onAttachFragment$2$2(this));
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("EmailLoginActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "EmailLoginActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "EmailLoginActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_email_login);
        getSupportFragmentManager().addFragmentOnAttachListener(this);
        if (bundle == null) {
            g(this, EnterEmailFragment.Companion.newInstance(), TAG_ENTER_EMAIL, false, 4, (Object) null);
        }
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        getSupportFragmentManager().removeFragmentOnAttachListener(this);
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
