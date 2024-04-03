package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginTargetApp;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0014J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/CustomTabMainActivity;", "Landroid/app/Activity;", "()V", "redirectReceiver", "Landroid/content/BroadcastReceiver;", "shouldCloseCustomTab", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "sendResult", "resultCode", "", "resultIntent", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomTabMainActivity extends Activity implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final String EXTRA_ACTION;
    @NotNull
    @JvmField
    public static final String EXTRA_CHROME_PACKAGE;
    @NotNull
    @JvmField
    public static final String EXTRA_PARAMS;
    @NotNull
    @JvmField
    public static final String EXTRA_TARGET_APP;
    @NotNull
    @JvmField
    public static final String EXTRA_URL;
    @NotNull
    @JvmField
    public static final String NO_ACTIVITY_EXCEPTION;
    @NotNull
    @JvmField
    public static final String REFRESH_ACTION;
    public Trace _nr_trace;
    @Nullable
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/CustomTabMainActivity$Companion;", "", "()V", "EXTRA_ACTION", "", "EXTRA_CHROME_PACKAGE", "EXTRA_PARAMS", "EXTRA_TARGET_APP", "EXTRA_URL", "NO_ACTIVITY_EXCEPTION", "REFRESH_ACTION", "parseResponseUri", "Landroid/os/Bundle;", "urlString", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Bundle parseResponseUri(String str) {
            Uri parse = Uri.parse(str);
            Utility utility = Utility.INSTANCE;
            Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
            parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
            return parseUrlQueryString;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.values().length];
            iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        Class<CustomTabMainActivity> cls = CustomTabMainActivity.class;
        EXTRA_ACTION = Intrinsics.stringPlus(cls.getSimpleName(), ".extra_action");
        EXTRA_PARAMS = Intrinsics.stringPlus(cls.getSimpleName(), ".extra_params");
        EXTRA_CHROME_PACKAGE = Intrinsics.stringPlus(cls.getSimpleName(), ".extra_chromePackage");
        EXTRA_URL = Intrinsics.stringPlus(cls.getSimpleName(), ".extra_url");
        EXTRA_TARGET_APP = Intrinsics.stringPlus(cls.getSimpleName(), ".extra_targetApp");
        REFRESH_ACTION = Intrinsics.stringPlus(cls.getSimpleName(), ".action_refresh");
        NO_ACTIVITY_EXCEPTION = Intrinsics.stringPlus(cls.getSimpleName(), ".no_activity_exception");
    }

    private final void sendResult(int i11, Intent intent) {
        Bundle bundle;
        BroadcastReceiver broadcastReceiver = this.redirectReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            if (stringExtra != null) {
                bundle = Companion.parseResponseUri(stringExtra);
            } else {
                bundle = new Bundle();
            }
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            Intent createProtocolResultIntent = NativeProtocol.createProtocolResultIntent(intent2, bundle, (FacebookException) null);
            if (createProtocolResultIntent != null) {
                intent = createProtocolResultIntent;
            }
            setResult(i11, intent);
        } else {
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            Intent intent3 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
            setResult(i11, NativeProtocol.createProtocolResultIntent(intent3, (Bundle) null, (FacebookException) null));
        }
        finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        CustomTab customTab;
        TraceMachine.startTracing("CustomTabMainActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CustomTabMainActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CustomTabMainActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        String str = CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION;
        if (Intrinsics.areEqual((Object) str, (Object) getIntent().getAction())) {
            setResult(0);
            finish();
            TraceMachine.exitMethod();
            return;
        }
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra(EXTRA_ACTION);
            if (stringExtra == null) {
                TraceMachine.exitMethod();
                return;
            }
            Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
            String stringExtra2 = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
            if (WhenMappings.$EnumSwitchMapping$0[LoginTargetApp.Companion.fromString(getIntent().getStringExtra(EXTRA_TARGET_APP)).ordinal()] == 1) {
                customTab = new InstagramCustomTab(stringExtra, bundleExtra);
            } else {
                customTab = new CustomTab(stringExtra, bundleExtra);
            }
            boolean openCustomTab = customTab.openCustomTab(this, stringExtra2);
            this.shouldCloseCustomTab = false;
            if (!openCustomTab) {
                setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
                finish();
                TraceMachine.exitMethod();
                return;
            }
            CustomTabMainActivity$onCreate$redirectReceiver$1 customTabMainActivity$onCreate$redirectReceiver$1 = new CustomTabMainActivity$onCreate$redirectReceiver$1(this);
            this.redirectReceiver = customTabMainActivity$onCreate$redirectReceiver$1;
            LocalBroadcastManager.getInstance(this).registerReceiver(customTabMainActivity$onCreate$redirectReceiver$1, new IntentFilter(str));
        }
        TraceMachine.exitMethod();
    }

    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        super.onNewIntent(intent);
        if (Intrinsics.areEqual((Object) REFRESH_ACTION, (Object) intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (Intrinsics.areEqual((Object) CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, (Object) intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, (Intent) null);
        }
        this.shouldCloseCustomTab = true;
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
