package a0;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class b {
    public static boolean a(Modifier.Element element, @NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return ((Boolean) function1.invoke(element)).booleanValue();
    }

    public static boolean b(Modifier.Element element, @NotNull Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return ((Boolean) function1.invoke(element)).booleanValue();
    }

    public static Object c(Modifier.Element element, Object obj, @NotNull Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return function2.invoke(obj, element);
    }

    public static Object d(Modifier.Element element, Object obj, @NotNull Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return function2.invoke(element, obj);
    }
}
