package splitties.bundle;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, d2 = {"putIBinderMethod", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getPutIBinderMethod", "()Ljava/lang/reflect/Method;", "putIBinderMethod$delegate", "Lkotlin/Lazy;", "putBinderCompat", "", "Landroid/os/Bundle;", "key", "", "binder", "Landroid/os/IBinder;", "splitties-bundle_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class Binder_and_BundleKt {
    @NotNull
    private static final Lazy putIBinderMethod$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, Binder_and_BundleKt$putIBinderMethod$2.INSTANCE);

    private static final Method getPutIBinderMethod() {
        return (Method) putIBinderMethod$delegate.getValue();
    }

    public static final void putBinderCompat(@NotNull Bundle bundle, @NotNull String str, @NotNull IBinder iBinder) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(iBinder, "binder");
        getPutIBinderMethod().invoke(bundle, new Object[]{str, iBinder});
    }
}
