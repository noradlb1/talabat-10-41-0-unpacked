package yj;

import com.talabat.QuickOrderScreen;
import com.talabat.di.QuickOrderScreenComponent;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class r {
    static {
        QuickOrderScreenComponent.Companion companion = QuickOrderScreenComponent.Companion;
    }

    @JvmStatic
    public static void a(@NotNull QuickOrderScreen quickOrderScreen) {
        QuickOrderScreenComponent.Companion.injectDependencies(quickOrderScreen);
    }
}
