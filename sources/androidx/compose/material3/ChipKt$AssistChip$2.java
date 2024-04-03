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
public final class ChipKt$AssistChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f6768g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6769h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f6770i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f6771j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6772k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f6773l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Shape f6774m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ChipColors f6775n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ ChipElevation f6776o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ChipBorder f6777p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f6778q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f6779r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ int f6780s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ int f6781t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$AssistChip$2(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i11, int i12, int i13) {
        super(2);
        this.f6768g = function0;
        this.f6769h = function2;
        this.f6770i = modifier;
        this.f6771j = z11;
        this.f6772k = function22;
        this.f6773l = function23;
        this.f6774m = shape;
        this.f6775n = chipColors;
        this.f6776o = chipElevation;
        this.f6777p = chipBorder;
        this.f6778q = mutableInteractionSource;
        this.f6779r = i11;
        this.f6780s = i12;
        this.f6781t = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.AssistChip(this.f6768g, this.f6769h, this.f6770i, this.f6771j, this.f6772k, this.f6773l, this.f6774m, this.f6775n, this.f6776o, this.f6777p, this.f6778q, composer, this.f6779r | 1, this.f6780s, this.f6781t);
    }
}
