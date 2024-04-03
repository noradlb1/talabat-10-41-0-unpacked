package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityKt$AnimatedVisibility$10 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RowScope f1133g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f1134h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f1135i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1136j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1137k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f1138l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f1139m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1140n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f1141o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$10(RowScope rowScope, MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1133g = rowScope;
        this.f1134h = mutableTransitionState;
        this.f1135i = modifier;
        this.f1136j = enterTransition;
        this.f1137k = exitTransition;
        this.f1138l = str;
        this.f1139m = function3;
        this.f1140n = i11;
        this.f1141o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedVisibility(this.f1133g, this.f1134h, this.f1135i, this.f1136j, this.f1137k, this.f1138l, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) this.f1139m, composer, this.f1140n | 1, this.f1141o);
    }
}
