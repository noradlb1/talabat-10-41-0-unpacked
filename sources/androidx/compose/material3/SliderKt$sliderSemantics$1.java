package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$sliderSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8176g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ClosedFloatingPointRange<Float> f8177h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8178i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f8179j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Float, Unit> f8180k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f8181l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$sliderSemantics$1(boolean z11, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i11, float f11, Function1<? super Float, Unit> function1, Function0<Unit> function0) {
        super(1);
        this.f8176g = z11;
        this.f8177h = closedFloatingPointRange;
        this.f8178i = i11;
        this.f8179j = f11;
        this.f8180k = function1;
        this.f8181l = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        if (!this.f8176g) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.f8177h;
        final int i11 = this.f8178i;
        final float f11 = this.f8179j;
        final Function1<Float, Unit> function1 = this.f8180k;
        final Function0<Unit> function0 = this.f8181l;
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, (String) null, new Function1<Float, Boolean>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }

            @NotNull
            public final Boolean invoke(float f11) {
                int i11;
                float coerceIn = RangesKt___RangesKt.coerceIn(f11, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
                int i12 = i11;
                boolean z11 = false;
                if (i12 > 0 && (i11 = i12 + 1) >= 0) {
                    float f12 = coerceIn;
                    float f13 = f12;
                    int i13 = 0;
                    while (true) {
                        float lerp = MathHelpersKt.lerp(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), ((float) i13) / ((float) (i11 + 1)));
                        float f14 = lerp - coerceIn;
                        if (Math.abs(f14) <= f12) {
                            f12 = Math.abs(f14);
                            f13 = lerp;
                        }
                        if (i13 == i11) {
                            break;
                        }
                        i13++;
                    }
                    coerceIn = f13;
                }
                if (!(coerceIn == f11)) {
                    function1.invoke(Float.valueOf(coerceIn));
                    Function0<Unit> function0 = function0;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }
        }, 1, (Object) null);
    }
}
