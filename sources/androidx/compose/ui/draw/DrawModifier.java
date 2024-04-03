package androidx.compose.ui.draw;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/Modifier$Element;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DrawModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull DrawModifier drawModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.a(drawModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull DrawModifier drawModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.b(drawModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull DrawModifier drawModifier, R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.c(drawModifier, r11, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull DrawModifier drawModifier, R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.d(drawModifier, r11, function2);
        }

        @NotNull
        @Deprecated
        public static Modifier then(@NotNull DrawModifier drawModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return a.a(drawModifier, modifier);
        }
    }

    void draw(@NotNull ContentDrawScope contentDrawScope);
}
