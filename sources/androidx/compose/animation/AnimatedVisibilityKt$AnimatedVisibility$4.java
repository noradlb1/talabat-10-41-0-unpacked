package androidx.compose.animation;

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
public final class AnimatedVisibilityKt$AnimatedVisibility$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RowScope f1177g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f1178h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f1179i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1180j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1181k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f1182l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f1183m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1184n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f1185o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$4(RowScope rowScope, boolean z11, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1177g = rowScope;
        this.f1178h = z11;
        this.f1179i = modifier;
        this.f1180j = enterTransition;
        this.f1181k = exitTransition;
        this.f1182l = str;
        this.f1183m = function3;
        this.f1184n = i11;
        this.f1185o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedVisibility(this.f1177g, this.f1178h, this.f1179i, this.f1180j, this.f1181k, this.f1182l, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) this.f1183m, composer, this.f1184n | 1, this.f1185o);
    }
}
