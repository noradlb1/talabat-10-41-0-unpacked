package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityKt$AnimatedVisibility$8 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f1195g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f1196h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1197i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1198j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f1199k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f1200l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f1201m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1202n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$8(MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1195g = mutableTransitionState;
        this.f1196h = modifier;
        this.f1197i = enterTransition;
        this.f1198j = exitTransition;
        this.f1199k = str;
        this.f1200l = function3;
        this.f1201m = i11;
        this.f1202n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedVisibility(this.f1195g, this.f1196h, this.f1197i, this.f1198j, this.f1199k, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) this.f1200l, composer, this.f1201m | 1, this.f1202n);
    }
}
