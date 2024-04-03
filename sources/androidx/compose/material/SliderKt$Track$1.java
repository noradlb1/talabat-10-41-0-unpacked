package androidx.compose.material;

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

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$Track$1 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f5241g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Color> f5242h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f5243i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f5244j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f5245k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Color> f5246l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ List<Float> f5247m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Color> f5248n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ State<Color> f5249o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$Track$1(float f11, State<Color> state, float f12, float f13, float f14, State<Color> state2, List<Float> list, State<Color> state3, State<Color> state4) {
        super(1);
        this.f5241g = f11;
        this.f5242h = state;
        this.f5243i = f12;
        this.f5244j = f13;
        this.f5245k = f14;
        this.f5246l = state2;
        this.f5247m = list;
        this.f5248n = state3;
        this.f5249o = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        boolean z11 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(this.f5241g, Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) - this.f5241g, Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()));
        long j11 = z11 ? Offset2 : Offset;
        long j12 = z11 ? Offset : Offset2;
        long r32 = this.f5242h.getValue().m2929unboximpl();
        float f11 = this.f5243i;
        StrokeCap.Companion companion = StrokeCap.Companion;
        long j13 = j12;
        long j14 = j11;
        b.C(drawScope, r32, j11, j12, f11, companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        b.C(drawScope, this.f5246l.getValue().m2929unboximpl(), OffsetKt.Offset(Offset.m2676getXimpl(j14) + ((Offset.m2676getXimpl(j13) - Offset.m2676getXimpl(j14)) * this.f5245k), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0())), OffsetKt.Offset(Offset.m2676getXimpl(j14) + ((Offset.m2676getXimpl(j13) - Offset.m2676getXimpl(j14)) * this.f5244j), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0())), this.f5243i, companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        float f12 = this.f5244j;
        float f13 = this.f5245k;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : this.f5247m) {
            float floatValue = ((Number) next).floatValue();
            Boolean valueOf = Boolean.valueOf(floatValue > f12 || floatValue < f13);
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(next);
        }
        State<Color> state = this.f5248n;
        State<Color> state2 = this.f5249o;
        float f14 = this.f5243i;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
            Iterable<Number> iterable = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Number floatValue2 : iterable) {
                arrayList.add(Offset.m2665boximpl(OffsetKt.Offset(Offset.m2676getXimpl(OffsetKt.m2699lerpWko1d7g(j14, j13, floatValue2.floatValue())), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()))));
            }
            long j15 = j13;
            long j16 = j14;
            b.H(drawScope, arrayList, PointMode.Companion.m3188getPointsr_lszbg(), (booleanValue ? state : state2).getValue().m2929unboximpl(), f14, StrokeCap.Companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            j14 = j16;
            f14 = f14;
            j13 = j15;
        }
    }
}
