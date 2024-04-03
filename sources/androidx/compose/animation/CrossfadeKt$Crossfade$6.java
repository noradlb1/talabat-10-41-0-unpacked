package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
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
public final class CrossfadeKt$Crossfade$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<T> f1229g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f1230h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiniteAnimationSpec<Float> f1231i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<T, Object> f1232j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<T, Composer, Integer, Unit> f1233k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f1234l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f1235m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CrossfadeKt$Crossfade$6(Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function1<? super T, ? extends Object> function1, Function3<? super T, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1229g = transition;
        this.f1230h = modifier;
        this.f1231i = finiteAnimationSpec;
        this.f1232j = function1;
        this.f1233k = function3;
        this.f1234l = i11;
        this.f1235m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CrossfadeKt.Crossfade(this.f1229g, this.f1230h, this.f1231i, this.f1232j, this.f1233k, composer, this.f1234l | 1, this.f1235m);
    }
}
