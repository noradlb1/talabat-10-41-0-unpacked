package splitties.bundle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"Ljava/lang/ThreadLocal;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BundleSpec$isReadOnlyByThread$2 extends Lambda implements Function0<ThreadLocal<Boolean>> {
    public static final BundleSpec$isReadOnlyByThread$2 INSTANCE = new BundleSpec$isReadOnlyByThread$2();

    public BundleSpec$isReadOnlyByThread$2() {
        super(0);
    }

    @NotNull
    public final ThreadLocal<Boolean> invoke() {
        return new ThreadLocal<>();
    }
}
