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
public final class ChipKt$Chip$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4311g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f4312h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4313i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f4314j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Shape f4315k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ BorderStroke f4316l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ChipColors f4317m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4318n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> f4319o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ int f4320p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f4321q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipKt$Chip$3(Function0<Unit> function0, Modifier modifier, boolean z11, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f4311g = function0;
        this.f4312h = modifier;
        this.f4313i = z11;
        this.f4314j = mutableInteractionSource;
        this.f4315k = shape;
        this.f4316l = borderStroke;
        this.f4317m = chipColors;
        this.f4318n = function2;
        this.f4319o = function3;
        this.f4320p = i11;
        this.f4321q = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ChipKt.Chip(this.f4311g, this.f4312h, this.f4313i, this.f4314j, this.f4315k, this.f4316l, this.f4317m, this.f4318n, this.f4319o, composer, this.f4320p | 1, this.f4321q);
    }
}
