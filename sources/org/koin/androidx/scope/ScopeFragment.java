package org.koin.androidx.scope;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8VX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lorg/koin/androidx/scope/ScopeFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/koin/android/scope/AndroidScopeComponent;", "contentLayoutId", "", "initialiseScope", "", "(IZ)V", "scope", "Lorg/koin/core/scope/Scope;", "getScope", "()Lorg/koin/core/scope/Scope;", "scope$delegate", "Lorg/koin/androidx/scope/LifecycleScopeDelegate;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "koin-android_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ScopeFragment extends Fragment implements AndroidScopeComponent, TraceFieldInterface {
    public static final /* synthetic */ KProperty<Object>[] C = {Reflection.property1(new PropertyReference1Impl(ScopeFragment.class, "scope", "getScope()Lorg/koin/core/scope/Scope;", 0))};
    public Trace _nr_trace;
    private final boolean initialiseScope;
    @NotNull
    private final LifecycleScopeDelegate scope$delegate;

    public ScopeFragment() {
        this(0, false, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScopeFragment(int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
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
        return this.scope$delegate.getValue((LifecycleOwner) this, (KProperty<?>) C[0]);
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
        if (this.initialiseScope) {
            getScope().getLogger().debug(Intrinsics.stringPlus("Open Fragment Scope: ", getScope()));
        }
    }

    public ScopeFragment(@LayoutRes int i11, boolean z11) {
        super(i11);
        this.initialiseScope = z11;
        this.scope$delegate = FragmentExtKt.fragmentScope(this);
    }
}
