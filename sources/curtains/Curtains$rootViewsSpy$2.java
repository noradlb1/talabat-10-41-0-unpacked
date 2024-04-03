package curtains;

import curtains.internal.RootViewsSpy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcurtains/internal/RootViewsSpy;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class Curtains$rootViewsSpy$2 extends Lambda implements Function0<RootViewsSpy> {
    public static final Curtains$rootViewsSpy$2 INSTANCE = new Curtains$rootViewsSpy$2();

    public Curtains$rootViewsSpy$2() {
        super(0);
    }

    @NotNull
    public final RootViewsSpy invoke() {
        return RootViewsSpy.Companion.install();
    }
}
