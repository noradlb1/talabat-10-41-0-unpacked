package androidx.compose.ui.draw;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawCacheModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "onBuildCache", "", "params", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DrawCacheModifier extends DrawModifier {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull DrawCacheModifier drawCacheModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.a(drawCacheModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull DrawCacheModifier drawCacheModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.b(drawCacheModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull DrawCacheModifier drawCacheModifier, R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.c(drawCacheModifier, r11, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull DrawCacheModifier drawCacheModifier, R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.d(drawCacheModifier, r11, function2);
        }

        @NotNull
        @Deprecated
        public static Modifier then(@NotNull DrawCacheModifier drawCacheModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return a.a(drawCacheModifier, modifier);
        }
    }

    void onBuildCache(@NotNull BuildDrawCacheParams buildDrawCacheParams);
}
