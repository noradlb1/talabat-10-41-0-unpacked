package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TabKt$Tab$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5737g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5738h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f5739i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f5740j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5741k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5742l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5743m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f5744n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f5745o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5746p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f5747q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$Tab$3(boolean z11, Function0<Unit> function0, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource mutableInteractionSource, long j11, long j12, int i11, int i12) {
        super(2);
        this.f5737g = z11;
        this.f5738h = function0;
        this.f5739i = modifier;
        this.f5740j = z12;
        this.f5741k = function2;
        this.f5742l = function22;
        this.f5743m = mutableInteractionSource;
        this.f5744n = j11;
        this.f5745o = j12;
        this.f5746p = i11;
        this.f5747q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabKt.m1408Tab0nDMI0(this.f5737g, this.f5738h, this.f5739i, this.f5740j, this.f5741k, this.f5742l, this.f5743m, this.f5744n, this.f5745o, composer, this.f5746p | 1, this.f5747q);
    }
}
