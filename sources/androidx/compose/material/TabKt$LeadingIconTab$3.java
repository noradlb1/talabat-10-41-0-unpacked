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
public final class TabKt$LeadingIconTab$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5723g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f5724h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5725i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f5726j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f5727k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f5728l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5729m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f5730n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ long f5731o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f5732p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f5733q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$LeadingIconTab$3(boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean z12, MutableInteractionSource mutableInteractionSource, long j11, long j12, int i11, int i12) {
        super(2);
        this.f5723g = z11;
        this.f5724h = function0;
        this.f5725i = function2;
        this.f5726j = function22;
        this.f5727k = modifier;
        this.f5728l = z12;
        this.f5729m = mutableInteractionSource;
        this.f5730n = j11;
        this.f5731o = j12;
        this.f5732p = i11;
        this.f5733q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabKt.m1407LeadingIconTab0nDMI0(this.f5723g, this.f5724h, this.f5725i, this.f5726j, this.f5727k, this.f5728l, this.f5729m, this.f5730n, this.f5731o, composer, this.f5732p | 1, this.f5733q);
    }
}
