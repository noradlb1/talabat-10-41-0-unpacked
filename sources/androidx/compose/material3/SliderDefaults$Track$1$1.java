package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import f0.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderDefaults$Track$1$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Color> f7924g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SliderPositions f7925h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Color> f7926i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ State<Color> f7927j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Color> f7928k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderDefaults$Track$1$1(State<Color> state, SliderPositions sliderPositions, State<Color> state2, State<Color> state3, State<Color> state4) {
        super(1);
        this.f7924g = state;
        this.f7925h = sliderPositions;
        this.f7926i = state2;
        this.f7927j = state3;
        this.f7928k = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$Canvas");
        boolean z11 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(0.0f, Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()));
        long j11 = z11 ? Offset2 : Offset;
        long j12 = z11 ? Offset : Offset2;
        float r18 = drawScope2.m5447toPx0680j_4(SliderKt.TickSize);
        float r19 = drawScope2.m5447toPx0680j_4(SliderKt.getTrackHeight());
        long r22 = this.f7924g.getValue().m2929unboximpl();
        StrokeCap.Companion companion = StrokeCap.Companion;
        float f11 = r19;
        long j13 = j12;
        long j14 = j11;
        b.C(drawScope, r22, j11, j12, f11, companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        b.C(drawScope, this.f7926i.getValue().m2929unboximpl(), OffsetKt.Offset(Offset.m2676getXimpl(j14) + ((Offset.m2676getXimpl(j13) - Offset.m2676getXimpl(j14)) * 0.0f), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0())), OffsetKt.Offset(Offset.m2676getXimpl(j14) + ((Offset.m2676getXimpl(j13) - Offset.m2676getXimpl(j14)) * this.f7925h.getPositionFraction()), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0())), f11, companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        float[] tickFractions = this.f7925h.getTickFractions();
        SliderPositions sliderPositions = this.f7925h;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = tickFractions.length;
        for (int i11 = 0; i11 < length; i11++) {
            float f12 = tickFractions[i11];
            Boolean valueOf = Boolean.valueOf(f12 > sliderPositions.getPositionFraction() || f12 < 0.0f);
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(Float.valueOf(f12));
        }
        State<Color> state = this.f7927j;
        State<Color> state2 = this.f7928k;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
            Iterable<Number> iterable = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Number floatValue : iterable) {
                arrayList.add(Offset.m2665boximpl(OffsetKt.Offset(Offset.m2676getXimpl(OffsetKt.m2699lerpWko1d7g(j14, j13, floatValue.floatValue())), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()))));
            }
            long j15 = j14;
            long j16 = j13;
            b.H(drawScope, arrayList, PointMode.Companion.m3188getPointsr_lszbg(), (booleanValue ? state : state2).getValue().m2929unboximpl(), r18, StrokeCap.Companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            j13 = j16;
            j14 = j15;
        }
    }
}
