package splitties.bundle;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n"}, d2 = {"Ljava/lang/ThreadLocal;", "Landroid/os/Bundle;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BundleSpec$currentBundleByThread$2 extends Lambda implements Function0<ThreadLocal<Bundle>> {
    public static final BundleSpec$currentBundleByThread$2 INSTANCE = new BundleSpec$currentBundleByThread$2();

    public BundleSpec$currentBundleByThread$2() {
        super(0);
    }

    @NotNull
    public final ThreadLocal<Bundle> invoke() {
        return new ThreadLocal<>();
    }
}
