package androidx.compose.runtime;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import w.a;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\b\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\u0004H$R\u0017\u0010\n\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00008\u0016@TX\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0006¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/AbstractApplier;", "T", "Landroidx/compose/runtime/Applier;", "node", "", "down", "(Ljava/lang/Object;)V", "up", "clear", "a", "root", "Ljava/lang/Object;", "getRoot", "()Ljava/lang/Object;", "", "stack", "Ljava/util/List;", "<set-?>", "current", "getCurrent", "b", "<init>", "runtime_release"}, k = 1, mv = {1, 7, 1})
public abstract class AbstractApplier<T> implements Applier<T> {
    public static final int $stable = 8;
    private T current;
    private final T root;
    @NotNull
    private final List<T> stack = new ArrayList();

    public AbstractApplier(T t11) {
        this.root = t11;
        this.current = t11;
    }

    public abstract void a();

    public void b(T t11) {
        this.current = t11;
    }

    public final void clear() {
        this.stack.clear();
        b(this.root);
        a();
    }

    public void down(T t11) {
        this.stack.add(getCurrent());
        b(t11);
    }

    public T getCurrent() {
        return this.current;
    }

    public final T getRoot() {
        return this.root;
    }

    public /* synthetic */ void onBeginChanges() {
        a.a(this);
    }

    public /* synthetic */ void onEndChanges() {
        a.b(this);
    }

    public void up() {
        if (!this.stack.isEmpty()) {
            List<T> list = this.stack;
            b(list.remove(list.size() - 1));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
