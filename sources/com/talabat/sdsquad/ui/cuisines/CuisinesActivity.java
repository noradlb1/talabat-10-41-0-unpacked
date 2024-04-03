package com.talabat.sdsquad.ui.cuisines;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.cuisines.CuisinesFragment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/CuisinesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    private static final String ARG_SELECTED_CUISINE_ID = "selectedCuisineId";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/sdsquad/ui/cuisines/CuisinesActivity$Companion;", "", "()V", "ARG_SELECTED_CUISINE_ID", "", "startForResult", "", "context", "Landroidx/fragment/app/Fragment;", "requestCode", "", "selectedCuisine", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void startForResult(@NotNull Fragment fragment, int i11, int i12) {
            Intrinsics.checkNotNullParameter(fragment, "context");
            Intent intent = new Intent(fragment.getContext(), CuisinesActivity.class);
            intent.putExtra(CuisinesActivity.ARG_SELECTED_CUISINE_ID, i12);
            fragment.startActivityForResult(intent, i11);
        }
    }

    @JvmStatic
    public static final void startForResult(@NotNull Fragment fragment, int i11, int i12) {
        Companion.startForResult(fragment, i11, i12);
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
        int i11;
        TraceMachine.startTracing("CuisinesActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CuisinesActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CuisinesActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_cuisines);
        getWindow().setLayout(-1, -1);
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int i12 = R.id.container;
            CuisinesFragment.Companion companion = CuisinesFragment.Companion;
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                i11 = extras.getInt(ARG_SELECTED_CUISINE_ID);
            } else {
                i11 = 0;
            }
            beginTransaction.replace(i12, companion.newInstance(i11)).commitNow();
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
}
