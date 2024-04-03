package com.talabat.sdsquad.ui.collections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.sdsquad.R;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/talabat/sdsquad/ui/collections/CollectionsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/sdsquad/ui/collections/CollectionsActivity$Companion;", "", "()V", "start", "", "context", "Landroid/content/Context;", "latitude", "", "longitude", "areaId", "", "cityId", "countryId", "collection", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull String str, @NotNull String str2, int i11, int i12, int i13, @NotNull CollectionDisplayModel collectionDisplayModel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            Intrinsics.checkNotNullParameter(collectionDisplayModel, GemAccessor.COMPONENT_COLLECTION);
            Intent intent = new Intent(context, CollectionsActivity.class);
            intent.putExtra("latitude", str);
            intent.putExtra("longitude", str2);
            intent.putExtra("areaId", i11);
            intent.putExtra("cityId", i12);
            intent.putExtra("countryId", i13);
            intent.putExtra(GemAccessor.COMPONENT_COLLECTION, collectionDisplayModel);
            context.startActivity(intent);
        }
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
        TraceMachine.startTracing("CollectionsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CollectionsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CollectionsActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_collections);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, CollectionsFragment.Companion.newInstance(getIntent().getStringExtra("latitude"), getIntent().getStringExtra("longitude"), getIntent().getIntExtra("areaId", 0), getIntent().getIntExtra("cityId", 0), getIntent().getIntExtra("countryId", 0), (CollectionDisplayModel) getIntent().getParcelableExtra(GemAccessor.COMPONENT_COLLECTION))).commitNow();
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
