package com.talabat.design_system_gallery;

import android.annotation.SuppressLint;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0003J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/talabat/design_system_gallery/ColorsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "bindGridView", "", "getGridItems", "", "Lcom/designsystem/marshmallow/viewsentity/gridview/GridItemViewEntity;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ColorsActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    private final void bindGridView() {
        TalabtGridView talabtGridView = (TalabtGridView) findViewById(R.id.colors_grid);
        Intrinsics.checkNotNullExpressionValue(talabtGridView, "view");
        TalabtGridView.bind$default(talabtGridView, new GridViewsEntity(getGridItems()), 0, 2, (Object) null);
    }

    @SuppressLint({"ResourceType"})
    private final List<GridItemViewEntity> getGridItems() {
        String string = getResources().getString(R.color.ds_primary_100);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…w.R.color.ds_primary_100)");
        String string2 = getResources().getString(R.color.ds_primary_65);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(com.…ow.R.color.ds_primary_65)");
        String string3 = getResources().getString(R.color.primary_30);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(com.…ommon.R.color.primary_30)");
        String string4 = getResources().getString(R.color.ds_primary_10);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(com.…ow.R.color.ds_primary_10)");
        String string5 = getResources().getString(R.color.ds_primary_4);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(com.…low.R.color.ds_primary_4)");
        String string6 = getResources().getString(R.color.ds_secondary_100);
        Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(com.…R.color.ds_secondary_100)");
        String string7 = getResources().getString(R.color.ds_secondary_30);
        Intrinsics.checkNotNullExpressionValue(string7, "resources.getString(com.….R.color.ds_secondary_30)");
        String string8 = getResources().getString(R.color.ds_secondary_10);
        Intrinsics.checkNotNullExpressionValue(string8, "resources.getString(com.….R.color.ds_secondary_10)");
        String string9 = getResources().getString(R.color.ds_secondary_4);
        Intrinsics.checkNotNullExpressionValue(string9, "resources.getString(com.…w.R.color.ds_secondary_4)");
        String string10 = getResources().getString(R.color.ds_promo_100);
        Intrinsics.checkNotNullExpressionValue(string10, "resources.getString(com.…low.R.color.ds_promo_100)");
        String string11 = getResources().getString(R.color.ds_promo_35);
        Intrinsics.checkNotNullExpressionValue(string11, "resources.getString(com.…llow.R.color.ds_promo_35)");
        String string12 = getResources().getString(R.color.ds_promo_10);
        Intrinsics.checkNotNullExpressionValue(string12, "resources.getString(com.…llow.R.color.ds_promo_10)");
        String string13 = getResources().getString(R.color.ds_promo_4);
        Intrinsics.checkNotNullExpressionValue(string13, "resources.getString(com.…allow.R.color.ds_promo_4)");
        String string14 = getResources().getString(R.color.ds_neutral_100);
        Intrinsics.checkNotNullExpressionValue(string14, "resources.getString(com.…w.R.color.ds_neutral_100)");
        String string15 = getResources().getString(R.color.ds_neutral_70);
        Intrinsics.checkNotNullExpressionValue(string15, "resources.getString(com.…ow.R.color.ds_neutral_70)");
        String string16 = getResources().getString(R.color.ds_neutral_55);
        Intrinsics.checkNotNullExpressionValue(string16, "resources.getString(com.…ow.R.color.ds_neutral_55)");
        String string17 = getResources().getString(R.color.neutral_35);
        Intrinsics.checkNotNullExpressionValue(string17, "resources.getString(com.…ommon.R.color.neutral_35)");
        String string18 = getResources().getString(R.color.ds_neutral_10);
        Intrinsics.checkNotNullExpressionValue(string18, "resources.getString(com.…ow.R.color.ds_neutral_10)");
        String string19 = getResources().getString(R.color.ds_neutral_4);
        Intrinsics.checkNotNullExpressionValue(string19, "resources.getString(com.…low.R.color.ds_neutral_4)");
        String string20 = getResources().getString(R.color.ds_neutral_white);
        Intrinsics.checkNotNullExpressionValue(string20, "resources.getString(com.…R.color.ds_neutral_white)");
        String string21 = getResources().getString(R.color.ds_success_100);
        Intrinsics.checkNotNullExpressionValue(string21, "resources.getString(com.…w.R.color.ds_success_100)");
        String string22 = getResources().getString(R.color.ds_success_30);
        Intrinsics.checkNotNullExpressionValue(string22, "resources.getString(com.…ow.R.color.ds_success_30)");
        String string23 = getResources().getString(R.color.ds_success_10);
        Intrinsics.checkNotNullExpressionValue(string23, "resources.getString(com.…ow.R.color.ds_success_10)");
        String string24 = getResources().getString(R.color.success_4);
        Intrinsics.checkNotNullExpressionValue(string24, "resources.getString(com.…common.R.color.success_4)");
        String string25 = getResources().getString(R.color.ds_alert_100);
        Intrinsics.checkNotNullExpressionValue(string25, "resources.getString(com.…low.R.color.ds_alert_100)");
        String string26 = getResources().getString(R.color.ds_alert_30);
        Intrinsics.checkNotNullExpressionValue(string26, "resources.getString(com.…llow.R.color.ds_alert_30)");
        String string27 = getResources().getString(R.color.ds_alert_10);
        Intrinsics.checkNotNullExpressionValue(string27, "resources.getString(com.…llow.R.color.ds_alert_10)");
        String string28 = getResources().getString(R.color.ds_alert_4);
        Intrinsics.checkNotNullExpressionValue(string28, "resources.getString(com.…allow.R.color.ds_alert_4)");
        String string29 = getResources().getString(R.color.ds_danger_100);
        Intrinsics.checkNotNullExpressionValue(string29, "resources.getString(com.…ow.R.color.ds_danger_100)");
        String string30 = getResources().getString(R.color.ds_danger_30);
        Intrinsics.checkNotNullExpressionValue(string30, "resources.getString(com.…low.R.color.ds_danger_30)");
        String string31 = getResources().getString(R.color.ds_danger_10);
        Intrinsics.checkNotNullExpressionValue(string31, "resources.getString(com.…low.R.color.ds_danger_10)");
        String string32 = getResources().getString(R.color.ds_danger_4);
        Intrinsics.checkNotNullExpressionValue(string32, "resources.getString(com.…llow.R.color.ds_danger_4)");
        return CollectionsKt__CollectionsKt.listOf(new GridItemViewEntity("https://ibb.co/x5H8kRc", "Primary 100", string, ColorsActivity$getGridItems$1.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Primary 65", string2, ColorsActivity$getGridItems$2.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Primary 30", string3, ColorsActivity$getGridItems$3.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Primary 10", string4, ColorsActivity$getGridItems$4.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Primary 4", string5, ColorsActivity$getGridItems$5.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Secondary 100", string6, ColorsActivity$getGridItems$6.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Secondary 30", string7, ColorsActivity$getGridItems$7.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Secondary 10", string8, ColorsActivity$getGridItems$8.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Secondary 4", string9, ColorsActivity$getGridItems$9.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Promo 100", string10, ColorsActivity$getGridItems$10.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Promo 30", string11, ColorsActivity$getGridItems$11.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Promo 10", string12, ColorsActivity$getGridItems$12.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Promo 4", string13, ColorsActivity$getGridItems$13.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Neutral 100", string14, ColorsActivity$getGridItems$14.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Neutral 70", string15, ColorsActivity$getGridItems$15.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Neutral 55", string16, ColorsActivity$getGridItems$16.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Neutral 35", string17, ColorsActivity$getGridItems$17.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Neutral 10", string18, ColorsActivity$getGridItems$18.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Neutral 4", string19, ColorsActivity$getGridItems$19.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Neutral White", string20, ColorsActivity$getGridItems$20.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Success 100", string21, ColorsActivity$getGridItems$21.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Success 30", string22, ColorsActivity$getGridItems$22.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Success 10", string23, ColorsActivity$getGridItems$23.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Success 4", string24, ColorsActivity$getGridItems$24.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Alert 100", string25, ColorsActivity$getGridItems$25.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Alert 30", string26, ColorsActivity$getGridItems$26.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Alert 10", string27, ColorsActivity$getGridItems$27.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Alert 4", string28, ColorsActivity$getGridItems$28.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Danger 100", string29, ColorsActivity$getGridItems$29.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Danger 30", string30, ColorsActivity$getGridItems$30.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Danger 10", string31, ColorsActivity$getGridItems$31.INSTANCE), new GridItemViewEntity("https://ibb.co/x5H8kRc", "Danger 4", string32, ColorsActivity$getGridItems$32.INSTANCE));
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
        TraceMachine.startTracing("ColorsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ColorsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ColorsActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_colors);
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
