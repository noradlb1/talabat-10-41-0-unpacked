package curtains.internal;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class WindowSpy$decorViewClass$2 extends Lambda implements Function0<Class<?>> {
    public static final WindowSpy$decorViewClass$2 INSTANCE = new WindowSpy$decorViewClass$2();

    public WindowSpy$decorViewClass$2() {
        super(0);
    }

    @Nullable
    public final Class<?> invoke() {
        int i11 = Build.VERSION.SDK_INT;
        String str = i11 >= 24 ? "com.android.internal.policy.DecorView" : i11 == 23 ? "com.android.internal.policy.PhoneWindow$DecorView" : "com.android.internal.policy.impl.PhoneWindow$DecorView";
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected exception loading ");
            sb2.append(str);
            sb2.append(" on API ");
            sb2.append(i11);
            return null;
        }
    }
}
