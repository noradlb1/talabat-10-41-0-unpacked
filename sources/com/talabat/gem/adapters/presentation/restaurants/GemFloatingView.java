package com.talabat.gem.adapters.presentation.restaurants;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.talabat.gem.adapters.presentation.ConfigurationsKt;
import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.adapters.presentation.GemFlowTrackerKt;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.adapters.presentation.GemViewKt;
import com.talabat.gem.adapters.presentation.GemViewsDsl;
import com.talabat.gem.adapters.presentation.offer.GemOfferActivity;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import com.talabat.talabatcommon.views.StartForResultCallbacks;
import com.talabat.talabatcommon.views.StartForResultExecutor;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.ReplaySubject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\u001d\u001a\u00020\u00112\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\u0002\b\u001eH\u0002J\f\u0010\u001f\u001a\u00020\u0011*\u00020 H\u0002J\u0014\u0010!\u001a\u00020\u0011*\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0016\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00110\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/gem/adapters/presentation/restaurants/GemFloatingView;", "Landroid/widget/LinearLayout;", "Lcom/talabat/gem/adapters/presentation/GemView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "configurations", "Lio/reactivex/subjects/ReplaySubject;", "Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "kotlin.jvm.PlatformType", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "initialize", "", "getInitialize", "()Lkotlin/Unit;", "Lkotlin/Unit;", "onCancelledAction", "Lkotlin/Function0;", "onDisabledAction", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "onEnabledAction", "onSelectedAction", "Lkotlin/Function1;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "invoke", "Lkotlin/ExtensionFunctionType;", "openOffers", "Landroid/view/View;", "registerOnMenuBackClicked", "Lcom/talabat/gem/adapters/presentation/restaurants/GemFloatingViewModel;", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemFloatingView extends LinearLayout implements GemView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public final ReplaySubject<GemEntryViewConfigurations> configurations;
    @NotNull
    private final CompositeDisposable disposables;
    @NotNull
    private final Unit initialize;
    /* access modifiers changed from: private */
    @NotNull
    public Function0<Unit> onCancelledAction;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onDisabledAction;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onEnabledAction;
    /* access modifiers changed from: private */
    @NotNull
    public Function1<? super GemRestaurant, Unit> onSelectedAction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.disposables = new CompositeDisposable();
        this.configurations = ConfigurationsKt.Configurations();
        this.onSelectedAction = GemFloatingView$onSelectedAction$1.INSTANCE;
        this.onCancelledAction = GemFloatingView$onCancelledAction$1.INSTANCE;
        GemViewKt.withGemFlowTracking(this, context, new GemFloatingView$initialize$1(this, context));
        this.initialize = Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void openOffers(View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        StartForResultExecutor<GemRestaurant> startActivityForResult = RouterKt.startActivityForResult(context, GemOfferActivity.class);
        StartForResultCallbacks startForResultCallbacks = new StartForResultCallbacks();
        startForResultCallbacks.getOn().success(new GemFloatingView$openOffers$1$1(this));
        startForResultCallbacks.getOn().cancelled(new GemFloatingView$openOffers$1$2(this));
        startActivityForResult.with(startForResultCallbacks);
    }

    /* access modifiers changed from: private */
    public final void registerOnMenuBackClicked(GemFloatingViewModel gemFloatingViewModel, Context context) {
        if (!(context instanceof AppCompatActivity)) {
            context = null;
        }
        if (context != null) {
            BroadcastsKt.registerToBroadcast$default((FragmentActivity) (AppCompatActivity) context, GemFlowTrackerKt.ACTION_MENU_TO_RESTAURANTS, (Lifecycle.State) null, (Function1) new GemFloatingView$registerOnMenuBackClicked$3(gemFloatingViewModel, this), 2, (Object) null);
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

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemView.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    @GemViewsDsl
    public final void invoke(@NotNull Function1<? super GemEntryViewConfigurations, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "configurations");
        ReplaySubject<GemEntryViewConfigurations> replaySubject = this.configurations;
        GemEntryViewConfigurations gemEntryViewConfigurations = new GemEntryViewConfigurations();
        function1.invoke(gemEntryViewConfigurations);
        RxKt.plusAssign(replaySubject, gemEntryViewConfigurations);
    }

    public void onCleared() {
        GemView.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemView.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public Unit getInitialize() {
        return this.initialize;
    }
}
