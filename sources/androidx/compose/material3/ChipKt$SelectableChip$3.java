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
public final class ChipKt$SelectableChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6920g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f6921h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6922i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6923j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6924k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ TextStyle f6925l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6926m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6927n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6928o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Shape f6929p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ SelectableChipColors f6930q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ SelectableChipElevation f6931r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f6932s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ float f6933t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f6934u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6935v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ int f6936w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f6937x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$SelectableChip$3(boolean z11, Modifier modifier, Function0<Unit> function0, boolean z12, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, float f11, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f6920g = z11;
        this.f6921h = modifier;
        this.f6922i = function0;
        this.f6923j = z12;
        this.f6924k = function2;
        this.f6925l = textStyle;
        this.f6926m = function22;
        this.f6927n = function23;
        this.f6928o = function24;
        this.f6929p = shape;
        this.f6930q = selectableChipColors;
        this.f6931r = selectableChipElevation;
        this.f6932s = borderStroke;
        this.f6933t = f11;
        this.f6934u = paddingValues;
        this.f6935v = mutableInteractionSource;
        this.f6936w = i11;
        this.f6937x = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        boolean z11 = this.f6920g;
        boolean z12 = z11;
        ChipKt.m1542SelectableChipu0RnIRE(z12, this.f6921h, this.f6922i, this.f6923j, this.f6924k, this.f6925l, this.f6926m, this.f6927n, this.f6928o, this.f6929p, this.f6930q, this.f6931r, this.f6932s, this.f6933t, this.f6934u, this.f6935v, composer2, this.f6936w | 1, this.f6937x);
    }
}
