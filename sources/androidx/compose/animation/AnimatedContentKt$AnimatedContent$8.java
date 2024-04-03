package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentKt$AnimatedContent$8 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<S> f1078g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f1079h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<AnimatedContentScope<S>, ContentTransform> f1080i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Alignment f1081j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<S, Object> f1082k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function4<AnimatedVisibilityScope, S, Composer, Integer, Unit> f1083l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f1084m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1085n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedContentKt$AnimatedContent$8(Transition<S> transition, Modifier modifier, Function1<? super AnimatedContentScope<S>, ContentTransform> function1, Alignment alignment, Function1<? super S, ? extends Object> function12, Function4<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, Unit> function4, int i11, int i12) {
        super(2);
        this.f1078g = transition;
        this.f1079h = modifier;
        this.f1080i = function1;
        this.f1081j = alignment;
        this.f1082k = function12;
        this.f1083l = function4;
        this.f1084m = i11;
        this.f1085n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedContentKt.AnimatedContent(this.f1078g, this.f1079h, this.f1080i, this.f1081j, this.f1082k, this.f1083l, composer, this.f1084m | 1, this.f1085n);
    }
}
