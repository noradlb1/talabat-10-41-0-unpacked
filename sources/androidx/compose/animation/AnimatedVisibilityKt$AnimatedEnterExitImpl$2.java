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
public final class AnimatedVisibilityKt$AnimatedEnterExitImpl$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<T> f1126g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Boolean> f1127h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f1128i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1129j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1130k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f1131l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f1132m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedEnterExitImpl$2(Transition<T> transition, Function1<? super T, Boolean> function1, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f1126g = transition;
        this.f1127h = function1;
        this.f1128i = modifier;
        this.f1129j = enterTransition;
        this.f1130k = exitTransition;
        this.f1131l = function3;
        this.f1132m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedEnterExitImpl(this.f1126g, this.f1127h, this.f1128i, this.f1129j, this.f1130k, this.f1131l, composer, this.f1132m | 1);
    }
}
