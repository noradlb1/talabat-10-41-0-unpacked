package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ChipKt$Chip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f6793g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6794h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6795i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6796j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6797k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ long f6798l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6799m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6800n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Shape f6801o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ChipColors f6802p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ ChipElevation f6803q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6804r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ float f6805s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6806t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6807u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f6808v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f6809w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$Chip$2(Modifier modifier, Function0<Unit> function0, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, float f11, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f6793g = modifier;
        this.f6794h = function0;
        this.f6795i = z11;
        this.f6796j = function2;
        this.f6797k = textStyle;
        this.f6798l = j11;
        this.f6799m = function22;
        this.f6800n = function23;
        this.f6801o = shape;
        this.f6802p = chipColors;
        this.f6803q = chipElevation;
        this.f6804r = borderStroke;
        this.f6805s = f11;
        this.f6806t = paddingValues;
        this.f6807u = mutableInteractionSource;
        this.f6808v = i11;
        this.f6809w = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Modifier modifier = this.f6793g;
        Modifier modifier2 = modifier;
        ChipKt.m1540ChipnkUnTEs(modifier2, this.f6794h, this.f6795i, this.f6796j, this.f6797k, this.f6798l, this.f6799m, this.f6800n, this.f6801o, this.f6802p, this.f6803q, this.f6804r, this.f6805s, this.f6806t, this.f6807u, composer2, this.f6808v | 1, this.f6809w);
    }
}
