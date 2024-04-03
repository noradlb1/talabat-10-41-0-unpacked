package com.talabat.sdsquad.ui.restaurantssearch;

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
import com.talabat.sdsquad.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/VendorSearchActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorSearchActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    private static final String ARG_AREA_ID = "areaId";
    @NotNull
    private static final String ARG_CITY_ID = "cityId";
    @NotNull
    private static final String ARG_COLLECTION_ID = "collectionId";
    @NotNull
    private static final String ARG_COUNTRY_ID = "countryId";
    @NotNull
    private static final String ARG_LATITUDE = "latitude";
    @NotNull
    private static final String ARG_LONGITUDE = "longitude";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/ui/restaurantssearch/VendorSearchActivity$Companion;", "", "()V", "ARG_AREA_ID", "", "ARG_CITY_ID", "ARG_COLLECTION_ID", "ARG_COUNTRY_ID", "ARG_LATITUDE", "ARG_LONGITUDE", "start", "", "context", "Landroid/content/Context;", "latitude", "longitude", "areaId", "", "cityId", "countryId", "collectionId", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, String str2, int i11, int i12, int i13, int i14, int i15, Object obj) {
            companion.start(context, str, str2, i11, i12, i13, (i15 & 64) != 0 ? 0 : i14);
        }

        public final void start(@NotNull Context context, @NotNull String str, @NotNull String str2, int i11, int i12, int i13, int i14) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "latitude");
            Intrinsics.checkNotNullParameter(str2, "longitude");
            Intent intent = new Intent(context, VendorSearchActivity.class);
            intent.putExtra("latitude", str);
            intent.putExtra("longitude", str2);
            intent.putExtra("countryId", i13);
            intent.putExtra("cityId", i12);
            intent.putExtra("collectionId", i14);
            intent.putExtra("areaId", i11);
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
        TraceMachine.startTracing("VendorSearchActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "VendorSearchActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VendorSearchActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_vendor_search);
        String stringExtra = getIntent().getStringExtra("latitude");
        String stringExtra2 = getIntent().getStringExtra("longitude");
        int intExtra = getIntent().getIntExtra("countryId", 0);
        int intExtra2 = getIntent().getIntExtra("areaId", 0);
        int intExtra3 = getIntent().getIntExtra("cityId", 0);
        int intExtra4 = getIntent().getIntExtra("collectionId", 0);
        if (bundle == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.containerFragment, VendorSearchFragment.Companion.newInstance(stringExtra, stringExtra2, intExtra2, intExtra3, intExtra, intExtra4)).commitNow();
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
