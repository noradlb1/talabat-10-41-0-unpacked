package com.talabat.riderinfo.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.navigation.domain.screen.riderchat.RiderChatScreen;
import com.talabat.riderinfo.R;
import com.talabat.riderinfo.presentation.viewmodel.RiderChatDeepLinkViewModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ut.a;
import ut.b;

@Instrumented
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/talabat/riderinfo/presentation/activity/RiderChatDeepLinkActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "viewModel", "Lcom/talabat/riderinfo/presentation/viewmodel/RiderChatDeepLinkViewModel;", "getViewModel", "()Lcom/talabat/riderinfo/presentation/viewmodel/RiderChatDeepLinkViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getOrderId", "", "hideLoading", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onProgressBarStatusChanges", "status", "", "onRiderChatErrorStatusChanges", "hasError", "showLoading", "Companion", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderChatDeepLinkActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ORDER_ID_KEY = "order_id";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new RiderChatDeepLinkActivity$viewModel$2(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/riderinfo/presentation/activity/RiderChatDeepLinkActivity$Companion;", "", "()V", "ORDER_ID_KEY", "", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String getOrderId() {
        String str;
        RiderChatScreen.RiderChatData riderChatData;
        Intent intent = getIntent();
        if (intent == null || (riderChatData = (RiderChatScreen.RiderChatData) intent.getParcelableExtra("navigatorData")) == null) {
            str = null;
        } else {
            str = riderChatData.getOrderId();
        }
        if (getIntent().hasExtra(ORDER_ID_KEY)) {
            return getIntent().getStringExtra(ORDER_ID_KEY);
        }
        return str;
    }

    private final RiderChatDeepLinkViewModel getViewModel() {
        return (RiderChatDeepLinkViewModel) this.viewModel$delegate.getValue();
    }

    private final void hideLoading() {
        ((ProgressBar) _$_findCachedViewById(R.id.rider_chat_deeplink_loading_view)).setVisibility(8);
        finish();
    }

    /* access modifiers changed from: private */
    public final void onProgressBarStatusChanges(boolean z11) {
        if (z11) {
            showLoading();
        } else {
            hideLoading();
        }
    }

    /* access modifiers changed from: private */
    public final void onRiderChatErrorStatusChanges(boolean z11) {
        if (z11) {
            Toast.makeText(this, getString(com.talabat.localization.R.string.chat_error_message), 1).show();
            finish();
        }
    }

    private final void showLoading() {
        ((ProgressBar) _$_findCachedViewById(R.id.rider_chat_deeplink_loading_view)).setVisibility(0);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onCreate(@Nullable Bundle bundle) {
        boolean z11;
        TraceMachine.startTracing("RiderChatDeepLinkActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "RiderChatDeepLinkActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RiderChatDeepLinkActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_rider_chat_deep_link);
        getViewModel().getProgressBarStatusLiveData().observe(this, new a(this));
        getViewModel().getRiderChatErrorLiveData().observe(this, new b(this));
        String orderId = getOrderId();
        if (orderId != null) {
            if (orderId.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                getViewModel().onCreate(orderId);
                TraceMachine.exitMethod();
            }
        }
        finish();
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
