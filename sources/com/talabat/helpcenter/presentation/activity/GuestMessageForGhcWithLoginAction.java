package com.talabat.helpcenter.presentation.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.designsystem.ds_button.DSPrimaryButton;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.helpcenter.R;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xr.a;
import xr.b;

@Instrumented
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/talabat/helpcenter/presentation/activity/GuestMessageForGhcWithLoginAction;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestMessageForGhcWithLoginAction extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String FROM = "from";
    @NotNull
    public static final String GUEST_MESSAGE_FOR_GHC_WITH_LOGIN_ACTION = "GuestMessageForGhcWithLoginAction";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/helpcenter/presentation/activity/GuestMessageForGhcWithLoginAction$Companion;", "", "()V", "FROM", "", "GUEST_MESSAGE_FOR_GHC_WITH_LOGIN_ACTION", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m10620onCreate$lambda1(GuestMessageForGhcWithLoginAction guestMessageForGhcWithLoginAction, View view) {
        Intrinsics.checkNotNullParameter(guestMessageForGhcWithLoginAction, "this$0");
        Navigator.Companion companion = Navigator.Companion;
        Bundle bundle = new Bundle();
        bundle.putString("from", GUEST_MESSAGE_FOR_GHC_WITH_LOGIN_ACTION);
        Unit unit = Unit.INSTANCE;
        companion.navigate((Context) guestMessageForGhcWithLoginAction, new NavigatorModel(LegacyTalabatActions.OPEN_LOGIN_SCREEN_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m10621onCreate$lambda2(GuestMessageForGhcWithLoginAction guestMessageForGhcWithLoginAction, View view) {
        Intrinsics.checkNotNullParameter(guestMessageForGhcWithLoginAction, "this$0");
        guestMessageForGhcWithLoginAction.onBackPressed();
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
        TraceMachine.startTracing(GUEST_MESSAGE_FOR_GHC_WITH_LOGIN_ACTION);
        try {
            TraceMachine.enterMethod(this._nr_trace, "GuestMessageForGhcWithLoginAction#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GuestMessageForGhcWithLoginAction#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_guest_message_for_ghc_with_login_action);
        ((DSPrimaryButton) _$_findCachedViewById(R.id.help_center_guest_login_btn)).setOnClickListener(new a(this));
        ((ImageButton) _$_findCachedViewById(R.id.guest_help_center_back_button)).setOnClickListener(new b(this));
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
