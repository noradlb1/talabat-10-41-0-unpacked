package org.koin.androidx.scope;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.koin.android.scope.AndroidScopeComponent;
import org.koin.core.scope.Scope;

@Instrumented
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8VX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lorg/koin/androidx/scope/ScopeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lorg/koin/android/scope/AndroidScopeComponent;", "contentLayoutId", "", "initialiseScope", "", "(IZ)V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "scope$delegate", "Lorg/koin/androidx/scope/LifecycleScopeDelegate;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ScopeActivity extends AppCompatActivity implements AndroidScopeComponent, TraceFieldInterface {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f62657i = {Reflection.property1(new PropertyReference1Impl(ScopeActivity.class, "scope", "getScope()Lorg/koin/core/scope/Scope;", 0))};
    public Trace _nr_trace;
    private final boolean initialiseScope;
    @NotNull
    private final LifecycleScopeDelegate scope$delegate;

    public ScopeActivity() {
        this(0, false, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScopeActivity(int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i11, (i12 & 2) != 0 ? true : z11);
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public Scope getScope() {
        return this.scope$delegate.getValue((LifecycleOwner) this, (KProperty<?>) f62657i[0]);
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("ScopeActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ScopeActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ScopeActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (this.initialiseScope) {
            getScope().getLogger().debug(Intrinsics.stringPlus("Open Activity Scope: ", getScope()));
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

    public ScopeActivity(@LayoutRes int i11, boolean z11) {
        super(i11);
        this.initialiseScope = z11;
        this.scope$delegate = ComponentActivityExtKt.activityScope(this);
    }
}
