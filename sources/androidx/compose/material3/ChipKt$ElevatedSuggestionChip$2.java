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
public final class ChipKt$ElevatedSuggestionChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6859g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6860h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6861i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6862j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6863k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f6864l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ChipColors f6865m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ChipElevation f6866n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ChipBorder f6867o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6868p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6869q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6870r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$ElevatedSuggestionChip$2(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f6859g = function0;
        this.f6860h = function2;
        this.f6861i = modifier;
        this.f6862j = z11;
        this.f6863k = function22;
        this.f6864l = shape;
        this.f6865m = chipColors;
        this.f6866n = chipElevation;
        this.f6867o = chipBorder;
        this.f6868p = mutableInteractionSource;
        this.f6869q = i11;
        this.f6870r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.ElevatedSuggestionChip(this.f6859g, this.f6860h, this.f6861i, this.f6862j, this.f6863k, this.f6864l, this.f6865m, this.f6866n, this.f6867o, this.f6868p, composer, this.f6869q | 1, this.f6870r);
    }
}
