package a0;

import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class a {
    static {
        Modifier.Companion companion = Modifier.Companion;
    }

    @NotNull
    public static Modifier a(Modifier modifier, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "other");
        if (modifier2 == Modifier.Companion) {
            return modifier;
        }
        return new CombinedModifier(modifier, modifier2);
    }
}
