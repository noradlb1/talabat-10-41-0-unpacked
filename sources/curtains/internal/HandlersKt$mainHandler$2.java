package curtains.internal;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Handler;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class HandlersKt$mainHandler$2 extends Lambda implements Function0<Handler> {
    public static final HandlersKt$mainHandler$2 INSTANCE = new HandlersKt$mainHandler$2();

    public HandlersKt$mainHandler$2() {
        super(0);
    }

    @NotNull
    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
