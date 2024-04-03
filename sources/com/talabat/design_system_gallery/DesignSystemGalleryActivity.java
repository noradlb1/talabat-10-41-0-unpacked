package com.talabat.design_system_gallery;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.designsystem.marshmallow.views.gridview.TalabtGridView;
import com.designsystem.marshmallow.viewsentity.gridview.GridItemViewEntity;
import com.designsystem.marshmallow.viewsentity.gridview.GridViewsEntity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/talabat/design_system_gallery/DesignSystemGalleryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bindGridView", "", "getGridItems", "", "Lcom/designsystem/marshmallow/viewsentity/gridview/GridItemViewEntity;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DesignSystemGalleryActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    private final void bindGridView() {
        TalabtGridView talabtGridView = (TalabtGridView) findViewById(R.id.gridTest);
        Intrinsics.checkNotNullExpressionValue(talabtGridView, "view");
        TalabtGridView.bind$default(talabtGridView, new GridViewsEntity(getGridItems()), 0, 2, (Object) null);
    }

    private final List<GridItemViewEntity> getGridItems() {
        String string = getResources().getString(R.color.ds_secondary_30);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(0+ c….R.color.ds_secondary_30)");
        String string2 = getResources().getString(R.color.ds_secondary_30);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(0+ c….R.color.ds_secondary_30)");
        String string3 = getResources().getString(R.color.ds_secondary_30);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(0+ c….R.color.ds_secondary_30)");
        String string4 = getResources().getString(R.color.ds_secondary_30);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(0+ c….R.color.ds_secondary_30)");
        String string5 = getResources().getString(R.color.ds_secondary_30);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(0+ c….R.color.ds_secondary_30)");
        String string6 = getResources().getString(R.color.ds_secondary_30);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(0+ c….R.color.ds_secondary_30)");
        String string7 = getResources().getString(R.color.ds_secondary_30);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(0+ c….R.color.ds_secondary_30)");
        return CollectionsKt__CollectionsKt.listOf(new GridItemViewEntity("https://ibb.co/x5H8kRc", "Colors", string, new DesignSystemGalleryActivity$getGridItems$1(this)), new GridItemViewEntity("https://ibb.co/x5H8kRc", "EmptyState", string2, new DesignSystemGalleryActivity$getGridItems$2(this)), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Bottom Sheet", string3, new DesignSystemGalleryActivity$getGridItems$3(this)), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Dividers", string4, new DesignSystemGalleryActivity$getGridItems$4(this)), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Checkbox", string5, new DesignSystemGalleryActivity$getGridItems$5(this)), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Radio Buttons", string6, new DesignSystemGalleryActivity$getGridItems$6(this)), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Switches", string7, new DesignSystemGalleryActivity$getGridItems$7(this)));
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
        TraceMachine.startTracing("DesignSystemGalleryActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "DesignSystemGalleryActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DesignSystemGalleryActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_design_system_gallery);
        bindGridView();
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
