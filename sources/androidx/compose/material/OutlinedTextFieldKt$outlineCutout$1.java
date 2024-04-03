package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OutlinedTextFieldKt$outlineCutout$1 extends Lambda implements Function1<ContentDrawScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f4921g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f4922h;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Rtl.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutlinedTextFieldKt$outlineCutout$1(long j11, PaddingValues paddingValues) {
        super(1);
        this.f4921g = j11;
        this.f4922h = paddingValues;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        float f11;
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
        float r02 = Size.m2745getWidthimpl(this.f4921g);
        if (r02 > 0.0f) {
            float r22 = contentDrawScope.m5447toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
            float r32 = contentDrawScope.m5447toPx0680j_4(this.f4922h.m497calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - r22;
            float f12 = (float) 2;
            float f13 = r02 + r32 + (r22 * f12);
            LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            if (iArr[layoutDirection.ordinal()] == 1) {
                f11 = Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc()) - f13;
            } else {
                f11 = RangesKt___RangesKt.coerceAtLeast(r32, 0.0f);
            }
            float f14 = f11;
            if (iArr[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                f13 = Size.m2745getWidthimpl(contentDrawScope.m3425getSizeNHjbRc()) - RangesKt___RangesKt.coerceAtLeast(r32, 0.0f);
            }
            float f15 = f13;
            float r03 = Size.m2742getHeightimpl(this.f4921g);
            float f16 = (-r03) / f12;
            float f17 = r03 / f12;
            int r12 = ClipOp.Companion.m2907getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope.getDrawContext();
            long r13 = drawContext.m3403getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m3475clipRectN_I0leg(f14, f16, f15, f17, r12);
            contentDrawScope.drawContent();
            drawContext.getCanvas().restore();
            drawContext.m3404setSizeuvyYCjk(r13);
            return;
        }
        contentDrawScope.drawContent();
    }
}
