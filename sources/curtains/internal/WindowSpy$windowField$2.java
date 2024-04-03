package curtains.internal;

import android.os.Build;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class WindowSpy$windowField$2 extends Lambda implements Function0<Field> {
    public static final WindowSpy$windowField$2 INSTANCE = new WindowSpy$windowField$2();

    public WindowSpy$windowField$2() {
        super(0);
    }

    @Nullable
    public final Field invoke() {
        Class access$getDecorViewClass$p = WindowSpy.INSTANCE.getDecorViewClass();
        if (access$getDecorViewClass$p == null) {
            return null;
        }
        int i11 = Build.VERSION.SDK_INT;
        String str = i11 >= 24 ? "mWindow" : "this$0";
        try {
            Field declaredField = access$getDecorViewClass$p.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected exception retrieving ");
            sb2.append(access$getDecorViewClass$p);
            sb2.append('#');
            sb2.append(str);
            sb2.append(" on API ");
            sb2.append(i11);
            return null;
        }
    }
}
