package androidx.compose.ui.layout;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J)\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0005\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/Modifier$Element;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface LayoutModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull LayoutModifier layoutModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.a(layoutModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull LayoutModifier layoutModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.b(layoutModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull LayoutModifier layoutModifier, R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.c(layoutModifier, r11, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull LayoutModifier layoutModifier, R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.d(layoutModifier, r11, function2);
        }

        @Deprecated
        public static int maxIntrinsicHeight(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return a.a(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i11);
        }

        @Deprecated
        public static int maxIntrinsicWidth(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return a.b(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i11);
        }

        @Deprecated
        public static int minIntrinsicHeight(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return a.c(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i11);
        }

        @Deprecated
        public static int minIntrinsicWidth(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return a.d(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i11);
        }

        @NotNull
        @Deprecated
        public static Modifier then(@NotNull LayoutModifier layoutModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return a.a(layoutModifier, modifier);
        }
    }

    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11);

    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11);

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    MeasureResult m4481measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11);

    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11);

    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11);
}
