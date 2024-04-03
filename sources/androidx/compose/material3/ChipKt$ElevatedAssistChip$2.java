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
public final class ChipKt$ElevatedAssistChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6830g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6831h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6832i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6833j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6834k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6835l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Shape f6836m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ChipColors f6837n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ChipElevation f6838o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ChipBorder f6839p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6840q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6841r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f6842s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6843t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$ElevatedAssistChip$2(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i11, int i12, int i13) {
        super(2);
        this.f6830g = function0;
        this.f6831h = function2;
        this.f6832i = modifier;
        this.f6833j = z11;
        this.f6834k = function22;
        this.f6835l = function23;
        this.f6836m = shape;
        this.f6837n = chipColors;
        this.f6838o = chipElevation;
        this.f6839p = chipBorder;
        this.f6840q = mutableInteractionSource;
        this.f6841r = i11;
        this.f6842s = i12;
        this.f6843t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.ElevatedAssistChip(this.f6830g, this.f6831h, this.f6832i, this.f6833j, this.f6834k, this.f6835l, this.f6836m, this.f6837n, this.f6838o, this.f6839p, this.f6840q, composer, this.f6841r | 1, this.f6842s, this.f6843t);
    }
}
