package coil.memory;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcoil/memory/EmptyTargetDelegate;", "Lcoil/memory/TargetDelegate;", "()V", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EmptyTargetDelegate extends TargetDelegate {
    @NotNull
    public static final EmptyTargetDelegate INSTANCE = new EmptyTargetDelegate();

    private EmptyTargetDelegate() {
        super((DefaultConstructorMarker) null);
    }
}
