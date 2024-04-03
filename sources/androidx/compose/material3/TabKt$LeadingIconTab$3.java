package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class TabKt$LeadingIconTab$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8513g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8514h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8515i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f8516j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Modifier f8517k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f8518l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f8519m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f8520n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8521o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f8522p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f8523q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabKt$LeadingIconTab$3(boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, boolean z12, long j11, long j12, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f8513g = z11;
        this.f8514h = function0;
        this.f8515i = function2;
        this.f8516j = function22;
        this.f8517k = modifier;
        this.f8518l = z12;
        this.f8519m = j11;
        this.f8520n = j12;
        this.f8521o = mutableInteractionSource;
        this.f8522p = i11;
        this.f8523q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        TabKt.m1881LeadingIconTabwqdebIU(this.f8513g, this.f8514h, this.f8515i, this.f8516j, this.f8517k, this.f8518l, this.f8519m, this.f8520n, this.f8521o, composer, this.f8522p | 1, this.f8523q);
    }
}
