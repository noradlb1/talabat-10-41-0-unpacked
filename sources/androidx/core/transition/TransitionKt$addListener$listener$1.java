package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<Transition, Unit> f11438a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<Transition, Unit> f11439b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1<Transition, Unit> f11440c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function1<Transition, Unit> f11441d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Function1<Transition, Unit> f11442e;

    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14, Function1<? super Transition, Unit> function15) {
        this.f11438a = function1;
        this.f11439b = function12;
        this.f11440c = function13;
        this.f11441d = function14;
        this.f11442e = function15;
    }

    public void onTransitionCancel(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.f11441d.invoke(transition);
    }

    public void onTransitionEnd(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.f11438a.invoke(transition);
    }

    public void onTransitionPause(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.f11440c.invoke(transition);
    }

    public void onTransitionResume(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.f11439b.invoke(transition);
    }

    public void onTransitionStart(@NotNull Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        this.f11442e.invoke(transition);
    }
}
