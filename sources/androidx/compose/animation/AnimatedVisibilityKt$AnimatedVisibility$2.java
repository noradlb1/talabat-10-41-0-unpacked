package androidx.compose.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedVisibilityKt$AnimatedVisibility$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f1169g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f1170h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1171i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1172j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f1173k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f1174l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f1175m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1176n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$2(boolean z11, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1169g = z11;
        this.f1170h = modifier;
        this.f1171i = enterTransition;
        this.f1172j = exitTransition;
        this.f1173k = str;
        this.f1174l = function3;
        this.f1175m = i11;
        this.f1176n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedVisibility(this.f1169g, this.f1170h, this.f1171i, this.f1172j, this.f1173k, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) this.f1174l, composer, this.f1175m | 1, this.f1176n);
    }
}
