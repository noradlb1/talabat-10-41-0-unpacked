package androidx.compose.ui.semantics;

import a0.b;
import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n0.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsModifier;", "Landroidx/compose/ui/Modifier$Element;", "id", "", "getId$annotations", "()V", "getId", "()I", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SemanticsModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull SemanticsModifier semanticsModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.a(semanticsModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull SemanticsModifier semanticsModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return b.b(semanticsModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull SemanticsModifier semanticsModifier, R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.c(semanticsModifier, r11, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull SemanticsModifier semanticsModifier, R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return b.d(semanticsModifier, r11, function2);
        }

        @Deprecated
        public static int getId(@NotNull SemanticsModifier semanticsModifier) {
            return a.a(semanticsModifier);
        }

        @Deprecated(message = "SemanticsModifier.id is now unused and has been set to a fixed value. Retrieve the id from LayoutInfo instead.", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public static /* synthetic */ void getId$annotations() {
        }

        @NotNull
        @Deprecated
        public static Modifier then(@NotNull SemanticsModifier semanticsModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return a0.a.a(semanticsModifier, modifier);
        }
    }

    int getId();

    @NotNull
    SemanticsConfiguration getSemanticsConfiguration();
}
