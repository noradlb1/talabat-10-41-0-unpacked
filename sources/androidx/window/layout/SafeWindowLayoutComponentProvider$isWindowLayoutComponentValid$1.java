package androidx.window.layout;

import android.app.Activity;
import j$.util.function.Consumer;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    @NotNull
    public final Boolean invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Class access$windowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
        boolean z11 = false;
        Class<Consumer> cls = Consumer.class;
        Method method = access$windowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", new Class[]{Activity.class, cls});
        Method method2 = access$windowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", new Class[]{cls});
        Intrinsics.checkNotNullExpressionValue(method, "addListenerMethod");
        if (safeWindowLayoutComponentProvider.isPublic(method)) {
            Intrinsics.checkNotNullExpressionValue(method2, "removeListenerMethod");
            if (safeWindowLayoutComponentProvider.isPublic(method2)) {
                z11 = true;
            }
        }
        return Boolean.valueOf(z11);
    }
}
