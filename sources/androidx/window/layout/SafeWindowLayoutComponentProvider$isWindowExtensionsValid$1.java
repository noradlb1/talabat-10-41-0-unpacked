package androidx.window.layout;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    @NotNull
    public final Boolean invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        boolean z11 = false;
        Method method = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader).getMethod("getWindowLayoutComponent", new Class[0]);
        Class access$windowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
        Intrinsics.checkNotNullExpressionValue(method, "getWindowLayoutComponentMethod");
        if (safeWindowLayoutComponentProvider.isPublic(method)) {
            Intrinsics.checkNotNullExpressionValue(access$windowLayoutComponentClass, "windowLayoutComponentClass");
            if (safeWindowLayoutComponentProvider.doesReturn(method, (Class<?>) access$windowLayoutComponentClass)) {
                z11 = true;
            }
        }
        return Boolean.valueOf(z11);
    }
}
