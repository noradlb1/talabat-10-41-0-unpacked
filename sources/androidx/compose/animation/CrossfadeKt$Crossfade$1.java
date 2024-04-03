package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class CrossfadeKt$Crossfade$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f1215g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f1216h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FiniteAnimationSpec<Float> f1217i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<T, Composer, Integer, Unit> f1218j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f1219k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f1220l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CrossfadeKt$Crossfade$1(T t11, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function3<? super T, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1215g = t11;
        this.f1216h = modifier;
        this.f1217i = finiteAnimationSpec;
        this.f1218j = function3;
        this.f1219k = i11;
        this.f1220l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        CrossfadeKt.Crossfade(this.f1215g, this.f1216h, this.f1217i, this.f1218j, composer, this.f1219k | 1, this.f1220l);
    }
}
