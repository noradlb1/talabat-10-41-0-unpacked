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
public final class ChipKt$FilterChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6871g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6872h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6873i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f6874j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f6875k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6876l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6877m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Shape f6878n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ SelectableChipColors f6879o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ SelectableChipElevation f6880p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ SelectableChipBorder f6881q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6882r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f6883s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6884t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f6885u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$FilterChip$2(boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, SelectableChipBorder selectableChipBorder, MutableInteractionSource mutableInteractionSource, int i11, int i12, int i13) {
        super(2);
        this.f6871g = z11;
        this.f6872h = function0;
        this.f6873i = function2;
        this.f6874j = modifier;
        this.f6875k = z12;
        this.f6876l = function22;
        this.f6877m = function23;
        this.f6878n = shape;
        this.f6879o = selectableChipColors;
        this.f6880p = selectableChipElevation;
        this.f6881q = selectableChipBorder;
        this.f6882r = mutableInteractionSource;
        this.f6883s = i11;
        this.f6884t = i12;
        this.f6885u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.FilterChip(this.f6871g, this.f6872h, this.f6873i, this.f6874j, this.f6875k, this.f6876l, this.f6877m, this.f6878n, this.f6879o, this.f6880p, this.f6881q, this.f6882r, composer, this.f6883s | 1, this.f6884t, this.f6885u);
    }
}
