package com.talabat.gem.adapters.presentation.collections.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.helpers.GlobalConstants;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.helpers.SyncLayoutWithLanguage;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tq.a;
import tq.b;
import tracking.gtm.automation.utils.AutomationTestingIntegrator;

@Instrumented
@SyncLayoutWithLanguage
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\u0012\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\tH\u0002J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\tH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\tX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/talabat/gem/adapters/presentation/collections/list/GemCollectionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/talabat/gem/adapters/presentation/GemView;", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "initialize", "", "getInitialize", "()Lkotlin/Unit;", "Lkotlin/Unit;", "isPaused", "", "()Z", "setPaused", "(Z)V", "checkIfNavigateToHome", "checkIfNavigateToHome$com_talabat_Components_gem_gem", "checkInstrumentURL", "checkVisibilityThreshold", "percentage", "", "configureToolbar", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionActivity extends AppCompatActivity implements GemView, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final Unit initialize;
    private boolean isPaused;

    public GemCollectionActivity() {
        int i11 = R.layout.v2_gem_collection_activity;
        if (this instanceof View) {
            ViewKt.withLayout((View) this, i11, new GemCollectionActivity$special$$inlined$bind$1(this, this));
        } else {
            ActivityKt.withLayout(this, i11, new GemCollectionActivity$special$$inlined$bind$2(this, this));
        }
        this.initialize = Unit.INSTANCE;
    }

    private final void checkInstrumentURL() {
        if (AutomationTestingIntegrator.INSTANCE.isAutomationProcess().invoke().booleanValue()) {
            int i11 = R.id.llContainer;
            ViewGroup.LayoutParams layoutParams = ((LinearLayout) _$_findCachedViewById(i11)).getLayoutParams();
            if (layoutParams != null) {
                ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior((CoordinatorLayout.Behavior) null);
                ((LinearLayout) _$_findCachedViewById(i11)).requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
    }

    /* access modifiers changed from: private */
    public final void configureToolbar() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        int i11 = com.designsystem.marshmallow.R.color.ds_secondary_10;
        window.setStatusBarColor(ContextCompat.getColor(this, i11));
        int i12 = R.id.mainToolbar;
        ((Toolbar) _$_findCachedViewById(i12)).setNavigationOnClickListener(new a(this));
        ((Toolbar) _$_findCachedViewById(i12)).setNavigationIcon(com.talabat.talabatcommon.R.drawable.ic_m_back_black);
        ((CollapsingToolbarLayout) _$_findCachedViewById(R.id.collapsingToolbar)).setContentScrimColor(ContextCompat.getColor(this, i11));
        ((AppBarLayout) _$_findCachedViewById(R.id.appbarLayout)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b(this));
        checkInstrumentURL();
    }

    /* access modifiers changed from: private */
    /* renamed from: configureToolbar$lambda-1  reason: not valid java name */
    public static final void m10536configureToolbar$lambda1(GemCollectionActivity gemCollectionActivity, View view) {
        Intrinsics.checkNotNullParameter(gemCollectionActivity, "this$0");
        GemCollectionActivityKt.close(gemCollectionActivity, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: configureToolbar$lambda-2  reason: not valid java name */
    public static final void m10537configureToolbar$lambda2(GemCollectionActivity gemCollectionActivity, AppBarLayout appBarLayout, int i11) {
        Intrinsics.checkNotNullParameter(gemCollectionActivity, "this$0");
        gemCollectionActivity.checkVisibilityThreshold(((float) Math.abs(i11)) / ((float) appBarLayout.getTotalScrollRange()));
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

    public final void checkIfNavigateToHome$com_talabat_Components_gem_gem() {
        if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            Navigator.Companion.navigate((Context) this, new NavigatorModel("talabat.action.homeScreen", (Bundle) null, GemCollectionActivity$checkIfNavigateToHome$1.INSTANCE, 2, (DefaultConstructorMarker) null));
        }
    }

    public final void checkVisibilityThreshold(float f11) {
        if (f11 >= 0.7f) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.gemTimerToolbarContainer);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "gemTimerToolbarContainer");
            ViewKt.visible(linearLayout);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.gemTimerToolbarContainer);
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "gemTimerToolbarContainer");
        ViewKt.invisible(linearLayout2);
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    public final boolean isPaused() {
        return this.isPaused;
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

    public final void setPaused(boolean z11) {
        this.isPaused = z11;
    }

    @NotNull
    public Unit getInitialize() {
        return this.initialize;
    }
}
