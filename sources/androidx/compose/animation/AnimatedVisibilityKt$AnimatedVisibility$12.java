package androidx.compose.animation;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityKt$AnimatedVisibility$12 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ColumnScope f1142g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableTransitionState<Boolean> f1143h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f1144i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1145j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1146k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f1147l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f1148m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1149n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f1150o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$12(ColumnScope columnScope, MutableTransitionState<Boolean> mutableTransitionState, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1142g = columnScope;
        this.f1143h = mutableTransitionState;
        this.f1144i = modifier;
        this.f1145j = enterTransition;
        this.f1146k = exitTransition;
        this.f1147l = str;
        this.f1148m = function3;
        this.f1149n = i11;
        this.f1150o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedVisibility(this.f1142g, this.f1143h, this.f1144i, this.f1145j, this.f1146k, this.f1147l, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) this.f1148m, composer, this.f1149n | 1, this.f1150o);
    }
}
