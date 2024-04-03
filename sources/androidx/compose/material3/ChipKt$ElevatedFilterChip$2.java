package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ChipKt$ElevatedFilterChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6844g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6845h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6846i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f6847j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f6848k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6849l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6850m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Shape f6851n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ SelectableChipColors f6852o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ SelectableChipElevation f6853p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ SelectableChipBorder f6854q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6855r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f6856s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6857t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f6858u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$ElevatedFilterChip$2(boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, SelectableChipBorder selectableChipBorder, MutableInteractionSource mutableInteractionSource, int i11, int i12, int i13) {
        super(2);
        this.f6844g = z11;
        this.f6845h = function0;
        this.f6846i = function2;
        this.f6847j = modifier;
        this.f6848k = z12;
        this.f6849l = function22;
        this.f6850m = function23;
        this.f6851n = shape;
        this.f6852o = selectableChipColors;
        this.f6853p = selectableChipElevation;
        this.f6854q = selectableChipBorder;
        this.f6855r = mutableInteractionSource;
        this.f6856s = i11;
        this.f6857t = i12;
        this.f6858u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.ElevatedFilterChip(this.f6844g, this.f6845h, this.f6846i, this.f6847j, this.f6848k, this.f6849l, this.f6850m, this.f6851n, this.f6852o, this.f6853p, this.f6854q, this.f6855r, composer, this.f6856s | 1, this.f6857t, this.f6858u);
    }
}
