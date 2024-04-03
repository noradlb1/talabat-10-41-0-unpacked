package androidx.compose.ui.text.style;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0016J\u0016\u0010\u0010\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000bX¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle;", "", "alpha", "", "getAlpha", "()F", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "merge", "other", "takeOrElse", "Lkotlin/Function0;", "Companion", "Unspecified", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface TextForegroundStyle {
    @NotNull
    public static final Companion Companion = Companion.f10224a;

    /* renamed from: androidx.compose.ui.text.style.TextForegroundStyle$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @NotNull
        public static TextForegroundStyle a(TextForegroundStyle textForegroundStyle, @NotNull TextForegroundStyle textForegroundStyle2) {
            Intrinsics.checkNotNullParameter(textForegroundStyle2, "other");
            boolean z11 = textForegroundStyle2 instanceof BrushStyle;
            if (z11 && (textForegroundStyle instanceof BrushStyle)) {
                return new BrushStyle(((BrushStyle) textForegroundStyle2).getValue(), TextDrawStyleKt.takeOrElse(textForegroundStyle2.getAlpha(), new TextForegroundStyle$merge$1(textForegroundStyle)));
            }
            if (z11 && !(textForegroundStyle instanceof BrushStyle)) {
                return textForegroundStyle2;
            }
            if (z11 || !(textForegroundStyle instanceof BrushStyle)) {
                return textForegroundStyle2.takeOrElse(new TextForegroundStyle$merge$2(textForegroundStyle));
            }
            return textForegroundStyle;
        }

        @NotNull
        public static TextForegroundStyle b(TextForegroundStyle textForegroundStyle, @NotNull Function0 function0) {
            Intrinsics.checkNotNullParameter(function0, "other");
            if (!Intrinsics.areEqual((Object) textForegroundStyle, (Object) Unspecified.INSTANCE)) {
                return textForegroundStyle;
            }
            return (TextForegroundStyle) function0.invoke();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001b\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle$Companion;", "", "()V", "from", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "color", "Landroidx/compose/ui/graphics/Color;", "from-8_81llA", "(J)Landroidx/compose/ui/text/style/TextForegroundStyle;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f10224a = new Companion();

        private Companion() {
        }

        @NotNull
        public final TextForegroundStyle from(@Nullable Brush brush, float f11) {
            if (brush == null) {
                return Unspecified.INSTANCE;
            }
            if (brush instanceof SolidColor) {
                return m5386from8_81llA(TextDrawStyleKt.m5384modulateDxMtmZc(((SolidColor) brush).m3235getValue0d7_KjU(), f11));
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush, f11);
            }
            throw new NoWhenBranchMatchedException();
        }

        @NotNull
        /* renamed from: from-8_81llA  reason: not valid java name */
        public final TextForegroundStyle m5386from8_81llA(long j11) {
            boolean z11;
            if (j11 != Color.Companion.m2955getUnspecified0d7_KjU()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return new ColorStyle(j11, (DefaultConstructorMarker) null);
            }
            return Unspecified.INSTANCE;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u00020\f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle$Unspecified;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "()V", "alpha", "", "getAlpha", "()F", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Unspecified implements TextForegroundStyle {
        public static final int $stable = 0;
        @NotNull
        public static final Unspecified INSTANCE = new Unspecified();

        private Unspecified() {
        }

        public float getAlpha() {
            return Float.NaN;
        }

        @Nullable
        public Brush getBrush() {
            return null;
        }

        /* renamed from: getColor-0d7_KjU  reason: not valid java name */
        public long m5387getColor0d7_KjU() {
            return Color.Companion.m2955getUnspecified0d7_KjU();
        }

        public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
            return CC.a(this, textForegroundStyle);
        }

        public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
            return CC.b(this, function0);
        }
    }

    float getAlpha();

    @Nullable
    Brush getBrush();

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    long m5385getColor0d7_KjU();

    @NotNull
    TextForegroundStyle merge(@NotNull TextForegroundStyle textForegroundStyle);

    @NotNull
    TextForegroundStyle takeOrElse(@NotNull Function0<? extends TextForegroundStyle> function0);
}
