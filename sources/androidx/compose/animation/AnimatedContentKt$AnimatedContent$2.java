package androidx.compose.animation;

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
public final class AnimatedContentKt$AnimatedContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ S f1052g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f1053h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<AnimatedContentScope<S>, ContentTransform> f1054i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Alignment f1055j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function4<AnimatedVisibilityScope, S, Composer, Integer, Unit> f1056k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f1057l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f1058m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedContentKt$AnimatedContent$2(S s11, Modifier modifier, Function1<? super AnimatedContentScope<S>, ContentTransform> function1, Alignment alignment, Function4<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, Unit> function4, int i11, int i12) {
        super(2);
        this.f1052g = s11;
        this.f1053h = modifier;
        this.f1054i = function1;
        this.f1055j = alignment;
        this.f1056k = function4;
        this.f1057l = i11;
        this.f1058m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedContentKt.AnimatedContent(this.f1052g, this.f1053h, this.f1054i, this.f1055j, this.f1056k, composer, this.f1057l | 1, this.f1058m);
    }
}
