package com.talabat.sdsquad.ui.filters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.sdsquad.R;
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
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/FiltersActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    private static final String ARG_SELECTED_FILTERS = "ARG_SELECTED_FILTERS";
    @NotNull
    private static final String ARG_SELECTED_SORT = "ARG_SELECTED_SORT";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J7\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/FiltersActivity$Companion;", "", "()V", "ARG_SELECTED_FILTERS", "", "ARG_SELECTED_SORT", "start", "", "context", "Landroid/content/Context;", "startForResult", "Landroidx/fragment/app/Fragment;", "requestCode", "", "selectedSort", "selectedFilters", "Ljava/util/ArrayList;", "(Landroidx/fragment/app/Fragment;ILjava/lang/Integer;Ljava/util/ArrayList;)V", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, FiltersActivity.class));
        }

        @JvmStatic
        public final void startForResult(@NotNull Fragment fragment, int i11, @Nullable Integer num, @Nullable ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(fragment, "context");
            Intent intent = new Intent(fragment.getContext(), FiltersActivity.class);
            intent.putExtra(FiltersActivity.ARG_SELECTED_SORT, num);
            intent.putExtra(FiltersActivity.ARG_SELECTED_FILTERS, arrayList);
            fragment.startActivityForResult(intent, i11);
        }
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        Companion.start(context);
    }

    @JvmStatic
    public static final void startForResult(@NotNull Fragment fragment, int i11, @Nullable Integer num, @Nullable ArrayList<Integer> arrayList) {
        Companion.startForResult(fragment, i11, num, arrayList);
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
        TraceMachine.startTracing("FiltersActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "FiltersActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "FiltersActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_filters);
        getWindow().setLayout(-1, -1);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, FiltersFragment.Companion.getInstance(Integer.valueOf(getIntent().getIntExtra(ARG_SELECTED_SORT, 0)), getIntent().getIntegerArrayListExtra(ARG_SELECTED_FILTERS))).commit();
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
