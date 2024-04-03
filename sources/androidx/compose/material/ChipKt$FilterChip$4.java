package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChipKt$FilterChip$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4352g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4353h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f4354i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f4355j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4356k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f4357l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f4358m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SelectableChipColors f4359n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4360o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4361p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4362q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4363r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f4364s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f4365t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ int f4366u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$FilterChip$4(boolean z11, Function0<Unit> function0, Modifier modifier, boolean z12, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12, int i13) {
        super(2);
        this.f4352g = z11;
        this.f4353h = function0;
        this.f4354i = modifier;
        this.f4355j = z12;
        this.f4356k = mutableInteractionSource;
        this.f4357l = shape;
        this.f4358m = borderStroke;
        this.f4359n = selectableChipColors;
        this.f4360o = function2;
        this.f4361p = function22;
        this.f4362q = function23;
        this.f4363r = function3;
        this.f4364s = i11;
        this.f4365t = i12;
        this.f4366u = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.FilterChip(this.f4352g, this.f4353h, this.f4354i, this.f4355j, this.f4356k, this.f4357l, this.f4358m, this.f4359n, this.f4360o, this.f4361p, this.f4362q, this.f4363r, composer, this.f4364s | 1, this.f4365t, this.f4366u);
    }
}
