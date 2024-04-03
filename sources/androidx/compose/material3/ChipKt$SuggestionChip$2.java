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
public final class ChipKt$SuggestionChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6938g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6939h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6940i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6941j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6942k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Shape f6943l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ChipColors f6944m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ChipElevation f6945n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ChipBorder f6946o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6947p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f6948q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6949r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$SuggestionChip$2(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i11, int i12) {
        super(2);
        this.f6938g = function0;
        this.f6939h = function2;
        this.f6940i = modifier;
        this.f6941j = z11;
        this.f6942k = function22;
        this.f6943l = shape;
        this.f6944m = chipColors;
        this.f6945n = chipElevation;
        this.f6946o = chipBorder;
        this.f6947p = mutableInteractionSource;
        this.f6948q = i11;
        this.f6949r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.SuggestionChip(this.f6938g, this.f6939h, this.f6940i, this.f6941j, this.f6942k, this.f6943l, this.f6944m, this.f6945n, this.f6946o, this.f6947p, composer, this.f6948q | 1, this.f6949r);
    }
}
