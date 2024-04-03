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
public final class ChipKt$InputChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6892g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6893h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6894i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Modifier f6895j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f6896k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6897l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6898m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6899n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Shape f6900o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ SelectableChipColors f6901p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ SelectableChipElevation f6902q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ SelectableChipBorder f6903r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6904s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6905t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f6906u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ int f6907v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$InputChip$3(boolean z11, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z12, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, SelectableChipBorder selectableChipBorder, MutableInteractionSource mutableInteractionSource, int i11, int i12, int i13) {
        super(2);
        this.f6892g = z11;
        this.f6893h = function0;
        this.f6894i = function2;
        this.f6895j = modifier;
        this.f6896k = z12;
        this.f6897l = function22;
        this.f6898m = function23;
        this.f6899n = function24;
        this.f6900o = shape;
        this.f6901p = selectableChipColors;
        this.f6902q = selectableChipElevation;
        this.f6903r = selectableChipBorder;
        this.f6904s = mutableInteractionSource;
        this.f6905t = i11;
        this.f6906u = i12;
        this.f6907v = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        boolean z11 = this.f6892g;
        boolean z12 = z11;
        ChipKt.InputChip(z12, this.f6893h, this.f6894i, this.f6895j, this.f6896k, this.f6897l, this.f6898m, this.f6899n, this.f6900o, this.f6901p, this.f6902q, this.f6903r, this.f6904s, composer, this.f6905t | 1, this.f6906u, this.f6907v);
    }
}
