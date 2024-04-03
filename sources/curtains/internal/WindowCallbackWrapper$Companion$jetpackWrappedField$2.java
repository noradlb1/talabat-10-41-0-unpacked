package curtains.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class WindowCallbackWrapper$Companion$jetpackWrappedField$2 extends Lambda implements Function0<Field> {
    public static final WindowCallbackWrapper$Companion$jetpackWrappedField$2 INSTANCE = new WindowCallbackWrapper$Companion$jetpackWrappedField$2();

    public WindowCallbackWrapper$Companion$jetpackWrappedField$2() {
        super(0);
    }

    @Nullable
    public final Field invoke() {
        Class access$getJetpackWrapperClass$p = WindowCallbackWrapper.Companion.getJetpackWrapperClass();
        if (access$getJetpackWrapperClass$p == null) {
            return null;
        }
        try {
            Field declaredField = access$getJetpackWrapperClass$p.getDeclaredField("mWrapped");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }
}
