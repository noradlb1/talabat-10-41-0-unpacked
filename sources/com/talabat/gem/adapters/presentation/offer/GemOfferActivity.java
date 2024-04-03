package com.talabat.gem.adapters.presentation.offer;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.fwfprojectskeys.domain.projects.adex.AdExFeatureFlagsKeys;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.menu.MenuScreen;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.di.DaggerGemOfferActivityComponent;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.helpers.SyncLayoutWithLanguage;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import datamodels.Restaurant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.automation.utils.AutomationTestingIntegrator;

@Instrumented
@SyncLayoutWithLanguage
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/talabat/gem/adapters/presentation/offer/GemOfferActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/talabat/gem/adapters/presentation/GemView;", "()V", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "initialize", "", "getInitialize", "()Lkotlin/Unit;", "Lkotlin/Unit;", "checkInstrumentURL", "checkVisibilityThreshold", "percentage", "", "generateItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "navigateToMenu", "gemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "restaurant", "Ldatamodels/Restaurant;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemOfferActivity extends AppCompatActivity implements GemView, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final Unit initialize;

    public GemOfferActivity() {
        int i11 = R.layout.gem_offer_activity;
        if (this instanceof View) {
            ViewKt.withLayout((View) this, i11, new GemOfferActivity$special$$inlined$bind$1(this, this));
        } else {
            ActivityKt.withLayout(this, i11, new GemOfferActivity$special$$inlined$bind$2(this, this));
        }
        this.initialize = Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void checkInstrumentURL() {
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
    public final void checkVisibilityThreshold(float f11) {
        if (f11 >= 0.7f) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.titleHeaderTextView);
            Intrinsics.checkNotNullExpressionValue(textView, "titleHeaderTextView");
            ViewKt.visible(textView);
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.titleHeaderTextView);
        Intrinsics.checkNotNullExpressionValue(textView2, "titleHeaderTextView");
        ViewKt.invisible(textView2);
    }

    /* access modifiers changed from: private */
    public final RecyclerView.ItemDecoration generateItemDecoration(Context context) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, 1);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.divider_container_gem_items);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        return dividerItemDecoration;
    }

    /* access modifiers changed from: private */
    public final void navigateToMenu(GemRestaurant gemRestaurant, Restaurant restaurant) {
        GlobalDataModel.ShopClickOrigin = "Gem";
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        AnalyticsPort.DefaultImpls.onShopClicked$default(IntegrationKt.getAnalytics(), gemRestaurant, (String) null, 2, (Object) null);
        if (IntegrationKt.getFeatureFlags().getFeatureFlag(AdExFeatureFlagsKeys.ENABLE_GEM_POPUP_DEEPLINK_NAVIGATION_TO_MENU, false)) {
            String str = "talabat://?s=vendor-menu&branchId=" + restaurant.branchId + "&deliveryMode=" + restaurant.deliveryMode() + "&intraFlutterNavigation=true";
            if (!StringsKt__StringsJVMKt.isBlank("Gem")) {
                str = str + "&shopClickOrigin=" + "Gem";
            }
            DeepLinkNavigator.DefaultImpls.navigateTo$default(getDeepLinkNavigator(), this, str, (Function0) null, 4, (Object) null);
            return;
        }
        Navigator navigator = IntegrationKt.getNavigator();
        int i11 = restaurant.branchId;
        String deliveryMode = restaurant.deliveryMode();
        Intrinsics.checkNotNullExpressionValue(deliveryMode, "restaurant.deliveryMode()");
        Navigator.DefaultImpls.navigateTo$default(navigator, this, new MenuScreen(new MenuScreen.MenuData(i11, deliveryMode, restaurant.isProRestaurant, "Gem", -1)), (Function1) null, 4, (Object) null);
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
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
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

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("GemOfferActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "GemOfferActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GemOfferActivity#onCreate", (ArrayList<String>) null);
        }
        DaggerGemOfferActivityComponent.factory().create((DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
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

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    @NotNull
    public Unit getInitialize() {
        return this.initialize;
    }
}
