package com.talabat.gem.adapters.presentation.home;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.core.experiment.data.Experiments;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.ConfigurationsKt;
import com.talabat.gem.adapters.presentation.GemEntryViewConfigurations;
import com.talabat.gem.adapters.presentation.GemFlowTrackerKt;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.gem.domain.entities.GemMode;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.lifecycle.AutoDisposableDsl;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq.a;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u00011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J'\u0010%\u001a\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u001c¢\u0006\u0002\b&H\u0002¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u001fH\u0002J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001fH\u0002J\u0014\u0010,\u001a\u00020\u0017*\u00020\u000f2\u0006\u0010)\u001a\u00020\u001fH\u0002J\u001e\u0010-\u001a\u00020\u0017*\u00020\u000f2\u0006\u0010)\u001a\u00020\u001f2\b\b\u0002\u0010.\u001a\u00020/H\u0002J\u0011\u00100\u001a\u000201*\u00020\u000fH\u0002¢\u0006\u0002\u00102J\f\u00103\u001a\u00020\u0017*\u00020\u000fH\u0002J\u0014\u00104\u001a\u00020\u0017*\u00020\u000f2\u0006\u00105\u001a\u000206H\u0002J\u0014\u00107\u001a\u00020\u0017*\u00020\u000f2\u0006\u00108\u001a\u000209H\u0002J\f\u0010:\u001a\u00020;*\u00020\u000fH\u0002R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00140\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00170\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001f0\u001f0\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/talabat/gem/adapters/presentation/home/GemSwimlanesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/talabat/gem/adapters/presentation/GemView;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "configurations", "Lio/reactivex/subjects/ReplaySubject;", "Lcom/talabat/gem/adapters/presentation/GemEntryViewConfigurations;", "kotlin.jvm.PlatformType", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "initialize", "Landroid/view/View;", "getInitialize", "()Landroid/view/View;", "mode", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/domain/entities/GemMode;", "onCancelledAction", "Lkotlin/Function0;", "", "onDisabledAction", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "onEnabledAction", "onSelectedAction", "Lkotlin/Function1;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "removeTopMargin", "", "triggerHeightAnimation", "generateItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "invoke", "Lkotlin/ExtensionFunctionType;", "invoke$com_talabat_Components_gem_gem", "invokeCallbacksAndAnalytics", "visible", "isAlreadyGone", "isAlreadyVisible", "adjustTopMargin", "animateLayoutChanges", "duration", "", "layoutManager", "com/talabat/gem/adapters/presentation/home/GemSwimlanesViewHolder$layoutManager$1", "(Landroid/view/View;)Lcom/talabat/gem/adapters/presentation/home/GemSwimlanesViewHolder$layoutManager$1;", "onAnimationFinished", "onAnimationUpdated", "animator", "Landroid/animation/ValueAnimator;", "registerAnalyticsTrigger", "viewModel", "Lcom/talabat/gem/adapters/presentation/home/GemSwimlanesViewModel;", "targetVisibleHeight", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemSwimlanesViewHolder extends RecyclerView.ViewHolder implements GemView {
    /* access modifiers changed from: private */
    @NotNull
    public final ReplaySubject<GemEntryViewConfigurations> configurations = ConfigurationsKt.Configurations();
    @NotNull
    private final CompositeDisposable disposables = new CompositeDisposable();
    @NotNull
    private final View initialize;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorSubject<GemMode> mode;
    /* access modifiers changed from: private */
    @NotNull
    public Function0<Unit> onCancelledAction = GemSwimlanesViewHolder$onCancelledAction$1.INSTANCE;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onDisabledAction;
    /* access modifiers changed from: private */
    @Nullable
    public SingleAccess<Function0<Unit>> onEnabledAction;
    /* access modifiers changed from: private */
    @NotNull
    public Function1<? super GemRestaurant, Unit> onSelectedAction = GemSwimlanesViewHolder$onSelectedAction$1.INSTANCE;
    private final boolean removeTopMargin;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorSubject<Boolean> triggerHeightAnimation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSwimlanesViewHolder(@NotNull ViewGroup viewGroup) {
        super(FunctionalAdaptersKt.inflateView(viewGroup, R.layout.gem_swimlane_view));
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        BehaviorSubject<GemMode> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<GemMode>()");
        this.mode = create;
        BehaviorSubject<Boolean> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<Boolean>()");
        this.triggerHeightAnimation = create2;
        TalabatExperimentConstants talabatExperimentConstants = TalabatExperimentConstants.VERTICAL_LAUNCH_EXPERIMENT;
        boolean z11 = false;
        this.removeTopMargin = (((Number) Experiments.withSafeExperiment$default(talabatExperimentConstants, (Object) null, (ITalabatExperiment) null, (Function1) null, 12, (Object) null)).intValue() == 1 || ((Number) Experiments.withSafeExperiment$default(talabatExperimentConstants, (Object) null, (ITalabatExperiment) null, (Function1) null, 12, (Object) null)).intValue() == 2) ? true : z11;
        this.initialize = AutoDisposableKt.withViewHolder(this, new GemSwimlanesViewHolder$initialize$1(viewGroup, this));
    }

    private final void adjustTopMargin(View view, boolean z11) {
        int i11;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i12 = 0;
        if (z11) {
            i11 = (int) FloatKt.convertDpToPixels(40.0f);
        } else {
            i11 = 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            if (!this.removeTopMargin) {
                i12 = i11;
            }
            marginLayoutParams.topMargin = i12;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    private final void animateLayoutChanges(View view, boolean z11, long j11) {
        int i11;
        adjustTopMargin(view, z11);
        if (z11) {
            i11 = targetVisibleHeight(view);
        } else {
            i11 = 0;
        }
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        ViewKt.get(view2, Boolean.valueOf(z11), 8);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{view.getMeasuredHeight(), i11});
        ofInt.setDuration(j11);
        ofInt.addUpdateListener(new a(this, view));
        Intrinsics.checkNotNullExpressionValue(ofInt, "animator");
        ofInt.addListener(new GemSwimlanesViewHolder$animateLayoutChanges$$inlined$addListener$default$1(this, view));
        ofInt.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: animateLayoutChanges$lambda-2  reason: not valid java name */
    public static final void m10538animateLayoutChanges$lambda2(GemSwimlanesViewHolder gemSwimlanesViewHolder, View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(gemSwimlanesViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(view, "$this_animateLayoutChanges");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        gemSwimlanesViewHolder.onAnimationUpdated(view, valueAnimator);
    }

    public static /* synthetic */ void b(GemSwimlanesViewHolder gemSwimlanesViewHolder, View view, boolean z11, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 16;
        }
        gemSwimlanesViewHolder.animateLayoutChanges(view, z11, j11);
    }

    /* access modifiers changed from: private */
    public final RecyclerView.ItemDecoration generateItemDecoration(Context context) {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, 1);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.divider_container_gem_swimlane_items);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        return dividerItemDecoration;
    }

    /* access modifiers changed from: private */
    public final void invokeCallbacksAndAnalytics(boolean z11) {
        Function0 value;
        Function0 value2;
        if (!z11) {
            SingleAccess<Function0<Unit>> singleAccess = this.onDisabledAction;
            if (singleAccess != null && (value2 = singleAccess.getValue()) != null) {
                value2.invoke();
                return;
            }
            return;
        }
        SingleAccess<Function0<Unit>> singleAccess2 = this.onEnabledAction;
        if (!(singleAccess2 == null || (value = singleAccess2.getValue()) == null)) {
            value.invoke();
        }
        IntegrationKt.getAnalytics().onGemHomeSwimlaneShown();
    }

    /* access modifiers changed from: private */
    public final boolean isAlreadyGone(boolean z11) {
        if (!z11) {
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            if (!ViewKt.isVisible(view)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final boolean isAlreadyVisible(boolean z11) {
        if (z11) {
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            if (ViewKt.isVisible(view)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final GemSwimlanesViewHolder$layoutManager$1 layoutManager(View view) {
        return new GemSwimlanesViewHolder$layoutManager$1(view.getContext());
    }

    /* access modifiers changed from: private */
    public final void onAnimationFinished(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = -2;
        view.setLayoutParams(layoutParams);
    }

    private final void onAnimationUpdated(View view, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            int intValue = ((Integer) animatedValue).intValue();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = intValue;
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* access modifiers changed from: private */
    public final void registerAnalyticsTrigger(View view, GemSwimlanesViewModel gemSwimlanesViewModel) {
        Context context = view.getContext();
        if (!(context instanceof AppCompatActivity)) {
            context = null;
        }
        if (context != null) {
            BroadcastsKt.registerToBroadcast$default((FragmentActivity) (AppCompatActivity) context, GemFlowTrackerKt.ACTION_MENU_TO_HOME, (Lifecycle.State) null, (Function1) new GemSwimlanesViewHolder$registerAnalyticsTrigger$3(gemSwimlanesViewModel, this), 2, (Object) null);
        }
    }

    private final int targetVisibleHeight(View view) {
        view.measure(-1, -2);
        int measuredHeight = view.getMeasuredHeight();
        view.getLayoutParams().height = 0;
        return measuredHeight;
    }

    @AutoDisposableDsl
    public void autoDispose(@NotNull Function0<? extends Disposable> function0) {
        GemView.DefaultImpls.autoDispose(this, function0);
    }

    @NotNull
    public CompositeDisposable getDisposables() {
        return this.disposables;
    }

    @NotNull
    public final GemSwimlanesViewHolder invoke$com_talabat_Components_gem_gem(@NotNull Function1<? super GemEntryViewConfigurations, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "configurations");
        ReplaySubject<GemEntryViewConfigurations> replaySubject = this.configurations;
        GemEntryViewConfigurations gemEntryViewConfigurations = new GemEntryViewConfigurations();
        function1.invoke(gemEntryViewConfigurations);
        RxKt.plusAssign(replaySubject, gemEntryViewConfigurations);
        return this;
    }

    public void onCleared() {
        GemView.DefaultImpls.onCleared(this);
    }

    @AutoDisposableDsl
    public void onClearedImplementation() {
        GemView.DefaultImpls.onClearedImplementation(this);
    }

    @NotNull
    public View getInitialize() {
        return this.initialize;
    }
}
