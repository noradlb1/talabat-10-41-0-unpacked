package com.talabat.filters.navigation;

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
import com.talabat.filters.FiltersIntegratorKt;
import com.talabat.filters.R;
import datamodels.filters.SelectableFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.Selectables;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0015J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/talabat/filters/navigation/SampleFiltersActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "selectionText", "", "wrapper", "Ldatamodels/filters/Selectables;", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SampleFiltersActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    /* access modifiers changed from: private */
    public final String selectionText(Selectables selectables) {
        String str;
        List<SelectableSortType> selectableSortTypes;
        List<SelectableFilter> selectableFilters;
        String str2 = null;
        if (selectables == null || (selectableFilters = selectables.getSelectableFilters()) == null) {
            str = null;
        } else {
            str = CollectionsKt___CollectionsKt.joinToString$default(selectableFilters, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SampleFiltersActivity$selectionText$1.INSTANCE, 31, (Object) null);
        }
        if (!(selectables == null || (selectableSortTypes = selectables.getSelectableSortTypes()) == null)) {
            str2 = CollectionsKt___CollectionsKt.joinToString$default(selectableSortTypes, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SampleFiltersActivity$selectionText$2.INSTANCE, 31, (Object) null);
        }
        return "\n\nFilters : \n[" + str + "]\nSorts : \n[" + str2 + "]\n";
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

    @SuppressLint({"SetTextI18n"})
    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("SampleFiltersActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SampleFiltersActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SampleFiltersActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        Application application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, MimeTypes.BASE_TYPE_APPLICATION);
        FiltersIntegratorKt.FiltersIntegration(application, SampleFiltersActivity$onCreate$1.INSTANCE);
        SampleFiltersActivityKt.getCache().clear();
        SampleFiltersActivityKt.initializeAllSortsStubs();
        SampleFiltersActivityKt.initializeAllFiltersStubs(1, 2, 3, 4, 5, 11, 12, 21, 24);
        SampleFiltersActivityKt.initializeAllRestaurantsStubs(TuplesKt.to(111, CollectionsKt__CollectionsKt.listOf(1, 11, 21, 500)), TuplesKt.to(112, CollectionsKt__CollectionsKt.listOf(2, 12, 500)), TuplesKt.to(113, CollectionsKt__CollectionsKt.listOf(3, 500)), TuplesKt.to(114, CollectionsKt__CollectionsKt.listOf(4, 24, 500)), TuplesKt.to(111112, CollectionsKt__CollectionsKt.listOf(1, 2, 500)), TuplesKt.to(112000, CollectionsKt__CollectionsKt.listOf(2, 12, 500)), TuplesKt.to(115, null));
        setContentView(R.layout.activity_sample);
        RestaurantsFiltersView restaurantsFiltersView = (RestaurantsFiltersView) _$_findCachedViewById(R.id.filtersViewLayout);
        Intrinsics.checkNotNullExpressionValue(restaurantsFiltersView, "filtersViewLayout");
        FiltersViewKt.invoke(restaurantsFiltersView, new SampleFiltersActivity$onCreate$2(this));
        CollectionsFiltersView collectionsFiltersView = (CollectionsFiltersView) _$_findCachedViewById(R.id.collectionsFiltersViewLayout);
        Intrinsics.checkNotNullExpressionValue(collectionsFiltersView, "collectionsFiltersViewLayout");
        FiltersViewKt.invoke$default(collectionsFiltersView, 500, (Function1) null, new SampleFiltersActivity$onCreate$3(this), 2, (Object) null);
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
