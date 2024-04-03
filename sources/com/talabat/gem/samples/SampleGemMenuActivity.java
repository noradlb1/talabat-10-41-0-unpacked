package com.talabat.gem.samples;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/talabat/gem/samples/SampleGemMenuActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/talabat/gem/adapters/presentation/GemView;", "()V", "calculatedSubTotal", "", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "initialize", "", "getInitialize", "()Lkotlin/Unit;", "Lkotlin/Unit;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SampleGemMenuActivity extends AppCompatActivity implements GemView, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public double calculatedSubTotal;
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final Unit initialize;

    public SampleGemMenuActivity() {
        ActivityKt.withLayout(this, R.layout.sample_gem_menu_activity, new SampleGemMenuActivity$initialize$1(this));
        this.initialize = Unit.INSTANCE;
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

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemView.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public void onCleared() {
        GemView.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemView.DefaultImpls.onClearedImplementation(this);
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    @NotNull
    public Unit getInitialize() {
        return this.initialize;
    }
}
