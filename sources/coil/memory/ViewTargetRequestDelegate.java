package coil.memory;

import androidx.annotation.MainThread;
import androidx.lifecycle.LifecycleObserver;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.util.Extensions;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcoil/memory/ViewTargetRequestDelegate;", "Lcoil/memory/RequestDelegate;", "imageLoader", "Lcoil/ImageLoader;", "request", "Lcoil/request/ImageRequest;", "targetDelegate", "Lcoil/memory/TargetDelegate;", "job", "Lkotlinx/coroutines/Job;", "(Lcoil/ImageLoader;Lcoil/request/ImageRequest;Lcoil/memory/TargetDelegate;Lkotlinx/coroutines/Job;)V", "dispose", "", "restart", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewTargetRequestDelegate extends RequestDelegate {
    @NotNull
    private final ImageLoader imageLoader;
    @NotNull
    private final Job job;
    @NotNull
    private final ImageRequest request;
    @NotNull
    private final TargetDelegate targetDelegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewTargetRequestDelegate(@NotNull ImageLoader imageLoader2, @NotNull ImageRequest imageRequest, @NotNull TargetDelegate targetDelegate2, @NotNull Job job2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(imageLoader2, "imageLoader");
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(targetDelegate2, "targetDelegate");
        Intrinsics.checkNotNullParameter(job2, "job");
        this.imageLoader = imageLoader2;
        this.request = imageRequest;
        this.targetDelegate = targetDelegate2;
        this.job = job2;
    }

    public void dispose() {
        Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
        this.targetDelegate.clear();
        Extensions.setMetadata(this.targetDelegate, (ImageResult.Metadata) null);
        if (this.request.getTarget() instanceof LifecycleObserver) {
            this.request.getLifecycle().removeObserver((LifecycleObserver) this.request.getTarget());
        }
        this.request.getLifecycle().removeObserver(this);
    }

    @MainThread
    public final void restart() {
        this.imageLoader.enqueue(this.request);
    }
}
