package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.MainThread;
import coil.request.ErrorResult;
import coil.request.SuccessResult;
import coil.target.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0017J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u0019\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0004\u0015\u0016\u0017\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcoil/memory/TargetDelegate;", "", "()V", "target", "Lcoil/target/Target;", "getTarget", "()Lcoil/target/Target;", "clear", "", "error", "result", "Lcoil/request/ErrorResult;", "(Lcoil/request/ErrorResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "placeholder", "Landroid/graphics/drawable/Drawable;", "cached", "Landroid/graphics/Bitmap;", "success", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcoil/memory/EmptyTargetDelegate;", "Lcoil/memory/InvalidatableEmptyTargetDelegate;", "Lcoil/memory/InvalidatableTargetDelegate;", "Lcoil/memory/PoolableTargetDelegate;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class TargetDelegate {
    private TargetDelegate() {
    }

    public /* synthetic */ TargetDelegate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @MainThread
    public void clear() {
    }

    @Nullable
    @MainThread
    public Object error(@NotNull ErrorResult errorResult, @NotNull Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Nullable
    public Target getTarget() {
        return null;
    }

    @MainThread
    public void start(@Nullable Drawable drawable, @Nullable Bitmap bitmap) {
    }

    @Nullable
    @MainThread
    public Object success(@NotNull SuccessResult successResult, @NotNull Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
