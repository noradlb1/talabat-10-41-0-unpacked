package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityKt$AnimatedVisibility$13 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<T> f1151g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Boolean> f1152h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f1153i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1154j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1155k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f1156l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f1157m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1158n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$13(Transition<T> transition, Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1151g = transition;
        this.f1152h = function1;
        this.f1153i = modifier;
        this.f1154j = enterTransition;
        this.f1155k = exitTransition;
        this.f1156l = function3;
        this.f1157m = i11;
        this.f1158n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedVisibility(this.f1151g, this.f1152h, this.f1153i, this.f1154j, this.f1155k, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) this.f1156l, composer, this.f1157m | 1, this.f1158n);
    }
}
