package androidx.compose.ui.layout;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/OnRemeasuredModifier;", "Landroidx/compose/ui/Modifier$Element;", "onRemeasured", "", "size", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface OnRemeasuredModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull OnRemeasuredModifier onRemeasuredModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.a(onRemeasuredModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull OnRemeasuredModifier onRemeasuredModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.b(onRemeasuredModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull OnRemeasuredModifier onRemeasuredModifier, R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.c(onRemeasuredModifier, r11, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull OnRemeasuredModifier onRemeasuredModifier, R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.d(onRemeasuredModifier, r11, function2);
        }

        @NotNull
        @Deprecated
        public static Modifier then(@NotNull OnRemeasuredModifier onRemeasuredModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return a.a(onRemeasuredModifier, modifier);
        }
    }

    /* renamed from: onRemeasured-ozmzZPI  reason: not valid java name */
    void m4525onRemeasuredozmzZPI(long j11);
}
