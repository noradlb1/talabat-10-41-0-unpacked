package androidx.window.layout;

import android.graphics.Rect;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    @NotNull
    public final Boolean invoke() {
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Class access$foldingFeatureClass = safeWindowLayoutComponentProvider.foldingFeatureClass(this.$classLoader);
        boolean z11 = false;
        Method method = access$foldingFeatureClass.getMethod("getBounds", new Class[0]);
        Method method2 = access$foldingFeatureClass.getMethod("getType", new Class[0]);
        Method method3 = access$foldingFeatureClass.getMethod("getState", new Class[0]);
        Intrinsics.checkNotNullExpressionValue(method, "getBoundsMethod");
        if (safeWindowLayoutComponentProvider.doesReturn(method, (KClass<?>) Reflection.getOrCreateKotlinClass(Rect.class)) && safeWindowLayoutComponentProvider.isPublic(method)) {
            Intrinsics.checkNotNullExpressionValue(method2, "getTypeMethod");
            Class cls = Integer.TYPE;
            if (safeWindowLayoutComponentProvider.doesReturn(method2, (KClass<?>) Reflection.getOrCreateKotlinClass(cls)) && safeWindowLayoutComponentProvider.isPublic(method2)) {
                Intrinsics.checkNotNullExpressionValue(method3, "getStateMethod");
                if (safeWindowLayoutComponentProvider.doesReturn(method3, (KClass<?>) Reflection.getOrCreateKotlinClass(cls)) && safeWindowLayoutComponentProvider.isPublic(method3)) {
                    z11 = true;
                }
            }
        }
        return Boolean.valueOf(z11);
    }
}
