package curtains.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
public final class WindowManagerSpy$windowManagerInstance$2 extends Lambda implements Function0<Object> {
    public static final WindowManagerSpy$windowManagerInstance$2 INSTANCE = new WindowManagerSpy$windowManagerInstance$2();

    public WindowManagerSpy$windowManagerInstance$2() {
        super(0);
    }

    @Nullable
    public final Object invoke() {
        Class access$getWindowManagerClass$p = WindowManagerSpy.INSTANCE.getWindowManagerClass();
        if (access$getWindowManagerClass$p != null) {
            return access$getWindowManagerClass$p.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        }
        return null;
    }
}
