package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityKt$AnimatedVisibility$17 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1161g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f1162h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1163i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1164j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f1165k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f1166l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f1167m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1168n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$17(boolean z11, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, boolean z12, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f1161g = z11;
        this.f1162h = modifier;
        this.f1163i = enterTransition;
        this.f1164j = exitTransition;
        this.f1165k = z12;
        this.f1166l = function2;
        this.f1167m = i11;
        this.f1168n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedVisibility(this.f1161g, this.f1162h, this.f1163i, this.f1164j, this.f1165k, (Function2<? super Composer, ? super Integer, Unit>) this.f1166l, composer, this.f1167m | 1, this.f1168n);
    }
}
