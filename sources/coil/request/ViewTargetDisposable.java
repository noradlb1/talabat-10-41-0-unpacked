package coil.request;

import coil.annotation.ExperimentalCoilApi;
import coil.target.ViewTarget;
import coil.util.Extensions;
import com.visa.checkout.PurchaseInfo;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcoil/request/ViewTargetDisposable;", "Lcoil/request/Disposable;", "requestId", "Ljava/util/UUID;", "target", "Lcoil/target/ViewTarget;", "(Ljava/util/UUID;Lcoil/target/ViewTarget;)V", "isDisposed", "", "()Z", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewTargetDisposable implements Disposable {
    @NotNull
    private final UUID requestId;
    @NotNull
    private final ViewTarget<?> target;

    public ViewTargetDisposable(@NotNull UUID uuid, @NotNull ViewTarget<?> viewTarget) {
        Intrinsics.checkNotNullParameter(uuid, PurchaseInfo.REQUEST_ID);
        Intrinsics.checkNotNullParameter(viewTarget, "target");
        this.requestId = uuid;
        this.target = viewTarget;
    }

    @Nullable
    @ExperimentalCoilApi
    public Object await(@NotNull Continuation<? super Unit> continuation) {
        if (isDisposed()) {
            return Unit.INSTANCE;
        }
        Job currentRequestJob = Extensions.getRequestManager(this.target.getView()).getCurrentRequestJob();
        if (currentRequestJob != null) {
            Object join = currentRequestJob.join(continuation);
            if (join == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return join;
            }
            return Unit.INSTANCE;
        } else if (IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() == null) {
            return null;
        } else {
            return Unit.INSTANCE;
        }
    }

    public void dispose() {
        if (!isDisposed()) {
            Extensions.getRequestManager(this.target.getView()).clearCurrentRequest();
        }
    }

    public boolean isDisposed() {
        return !Intrinsics.areEqual((Object) Extensions.getRequestManager(this.target.getView()).getCurrentRequestId(), (Object) this.requestId);
    }
}
