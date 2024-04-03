package com.talabat.cuisines.navigation;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.util.MimeTypes;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.cuisines.CuisinesIntegratorKt;
import com.talabat.cuisines.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0015¨\u0006\u0007"}, d2 = {"Lcom/talabat/cuisines/navigation/SampleCuisinesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SampleCuisinesActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

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

    @SuppressLint({"SetTextI18n"})
    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("SampleCuisinesActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SampleCuisinesActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SampleCuisinesActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, MimeTypes.BASE_TYPE_APPLICATION);
        CuisinesIntegratorKt.CuisinesIntegration(application, SampleCuisinesActivity$onCreate$1.INSTANCE);
        SampleCuisinesActivityKt.getCache().clear();
        SampleCuisinesActivityKt.getCache().put("AllCuisines", SampleCuisinesActivityKt.cuisinesStubs());
        SampleCuisinesActivityKt.getCache().put("AllCollectionsCuisines", SampleCuisinesActivityKt.cuisinesStubs());
        setContentView(R.layout.activity_sample);
        ((CuisineView) _$_findCachedViewById(R.id.cuisinesView)).invoke(new SampleCuisinesActivity$onCreate$2(this));
        ((CollectionsCuisineView) _$_findCachedViewById(R.id.collectionsCuisinesView)).invoke(new SampleCuisinesActivity$onCreate$3(this));
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
