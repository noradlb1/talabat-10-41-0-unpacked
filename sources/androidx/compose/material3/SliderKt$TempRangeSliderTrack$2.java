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
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$TempRangeSliderTrack$2 extends Lambda implements Function1<DrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f8100g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Color> f8101h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f8102i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f8103j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f8104k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Color> f8105l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ float[] f8106m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Color> f8107n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ State<Color> f8108o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f8109p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$TempRangeSliderTrack$2(Ref.FloatRef floatRef, State<Color> state, float f11, float f12, float f13, State<Color> state2, float[] fArr, State<Color> state3, State<Color> state4, Ref.FloatRef floatRef2) {
        super(1);
        this.f8100g = floatRef;
        this.f8101h = state;
        this.f8102i = f11;
        this.f8103j = f12;
        this.f8104k = f13;
        this.f8105l = state2;
        this.f8106m = fArr;
        this.f8107n = state3;
        this.f8108o = state4;
        this.f8109p = floatRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        boolean z11 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(this.f8100g.element, Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) - this.f8100g.element, Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()));
        long j11 = z11 ? Offset2 : Offset;
        long j12 = z11 ? Offset : Offset2;
        long r32 = this.f8101h.getValue().m2929unboximpl();
        float f11 = this.f8102i;
        StrokeCap.Companion companion = StrokeCap.Companion;
        long j13 = j12;
        long j14 = j11;
        b.C(drawScope, r32, j11, j12, f11, companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        b.C(drawScope, this.f8105l.getValue().m2929unboximpl(), OffsetKt.Offset(Offset.m2676getXimpl(j14) + ((Offset.m2676getXimpl(j13) - Offset.m2676getXimpl(j14)) * this.f8104k), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0())), OffsetKt.Offset(Offset.m2676getXimpl(j14) + ((Offset.m2676getXimpl(j13) - Offset.m2676getXimpl(j14)) * this.f8103j), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0())), this.f8102i, companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        float[] fArr = this.f8106m;
        float f12 = this.f8103j;
        float f13 = this.f8104k;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = fArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            float f14 = fArr[i11];
            Boolean valueOf = Boolean.valueOf(f14 > f12 || f14 < f13);
            Object obj = linkedHashMap.get(valueOf);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(valueOf, obj);
            }
            ((List) obj).add(Float.valueOf(f14));
        }
        State<Color> state = this.f8107n;
        State<Color> state2 = this.f8108o;
        Ref.FloatRef floatRef = this.f8109p;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
            Iterable<Number> iterable = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Number floatValue : iterable) {
                arrayList.add(Offset.m2665boximpl(OffsetKt.Offset(Offset.m2676getXimpl(OffsetKt.m2699lerpWko1d7g(j14, j13, floatValue.floatValue())), Offset.m2677getYimpl(drawScope.m3424getCenterF1C5BW0()))));
            }
            long j15 = j13;
            long j16 = j14;
            b.H(drawScope, arrayList, PointMode.Companion.m3188getPointsr_lszbg(), (booleanValue ? state : state2).getValue().m2929unboximpl(), floatRef.element, StrokeCap.Companion.m3254getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            j14 = j16;
            floatRef = floatRef;
            j13 = j15;
        }
    }
}
