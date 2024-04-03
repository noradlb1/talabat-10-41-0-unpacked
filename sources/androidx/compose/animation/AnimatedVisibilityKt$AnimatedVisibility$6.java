package androidx.compose.animation;

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
public final class AnimatedVisibilityKt$AnimatedVisibility$6 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ColumnScope f1186g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f1187h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f1188i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EnterTransition f1189j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ExitTransition f1190k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f1191l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f1192m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f1193n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f1194o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedVisibility$6(ColumnScope columnScope, boolean z11, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f1186g = columnScope;
        this.f1187h = z11;
        this.f1188i = modifier;
        this.f1189j = enterTransition;
        this.f1190k = exitTransition;
        this.f1191l = str;
        this.f1192m = function3;
        this.f1193n = i11;
        this.f1194o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AnimatedVisibilityKt.AnimatedVisibility(this.f1186g, this.f1187h, this.f1188i, this.f1189j, this.f1190k, this.f1191l, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) this.f1192m, composer, this.f1193n | 1, this.f1194o);
    }
}
