package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/ThreadLocal;", "T", "Ljava/lang/ThreadLocal;", "initialValue", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "get", "()Ljava/lang/Object;", "remove", "", "set", "value", "(Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class ThreadLocal<T> extends ThreadLocal<T> {
    @NotNull
    private final Function0<T> initialValue;

    public ThreadLocal(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initialValue");
        this.initialValue = function0;
    }

    public T get() {
        return super.get();
    }

    @Nullable
    public T initialValue() {
        return this.initialValue.invoke();
    }

    public void remove() {
        super.remove();
    }

    public void set(T t11) {
        super.set(t11);
    }
}
