package androidx.compose.ui.input.pointer;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputModifier;", "Landroidx/compose/ui/Modifier$Element;", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PointerInputModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull PointerInputModifier pointerInputModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.a(pointerInputModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull PointerInputModifier pointerInputModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.b(pointerInputModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull PointerInputModifier pointerInputModifier, R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.c(pointerInputModifier, r11, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull PointerInputModifier pointerInputModifier, R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.d(pointerInputModifier, r11, function2);
        }

        @NotNull
        @Deprecated
        public static Modifier then(@NotNull PointerInputModifier pointerInputModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return a.a(pointerInputModifier, modifier);
        }
    }

    @NotNull
    PointerInputFilter getPointerInputFilter();
}
