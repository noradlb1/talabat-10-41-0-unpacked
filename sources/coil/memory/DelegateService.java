package coil.memory;

import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import coil.EventListener;
import coil.ImageLoader;
import coil.bitmap.BitmapReferenceCounter;
import coil.request.ImageRequest;
import coil.target.PoolableViewTarget;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.util.Extensions;
import coil.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\"\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil/memory/DelegateService;", "", "imageLoader", "Lcoil/ImageLoader;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/util/Logger;)V", "createRequestDelegate", "Lcoil/memory/RequestDelegate;", "request", "Lcoil/request/ImageRequest;", "targetDelegate", "Lcoil/memory/TargetDelegate;", "job", "Lkotlinx/coroutines/Job;", "createTargetDelegate", "target", "Lcoil/target/Target;", "type", "", "eventListener", "Lcoil/EventListener;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DelegateService {
    @NotNull
    private final ImageLoader imageLoader;
    @Nullable
    private final Logger logger;
    @NotNull
    private final BitmapReferenceCounter referenceCounter;

    public DelegateService(@NotNull ImageLoader imageLoader2, @NotNull BitmapReferenceCounter bitmapReferenceCounter, @Nullable Logger logger2) {
        Intrinsics.checkNotNullParameter(imageLoader2, "imageLoader");
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        this.imageLoader = imageLoader2;
        this.referenceCounter = bitmapReferenceCounter;
        this.logger = logger2;
    }

    @NotNull
    @MainThread
    public final RequestDelegate createRequestDelegate(@NotNull ImageRequest imageRequest, @NotNull TargetDelegate targetDelegate, @NotNull Job job) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(targetDelegate, "targetDelegate");
        Intrinsics.checkNotNullParameter(job, "job");
        Lifecycle lifecycle = imageRequest.getLifecycle();
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            ViewTargetRequestDelegate viewTargetRequestDelegate = new ViewTargetRequestDelegate(this.imageLoader, imageRequest, targetDelegate, job);
            lifecycle.addObserver(viewTargetRequestDelegate);
            if (target instanceof LifecycleObserver) {
                LifecycleObserver lifecycleObserver = (LifecycleObserver) target;
                lifecycle.removeObserver(lifecycleObserver);
                lifecycle.addObserver(lifecycleObserver);
            }
            ViewTarget viewTarget = (ViewTarget) target;
            Extensions.getRequestManager(viewTarget.getView()).setCurrentRequest(viewTargetRequestDelegate);
            if (ViewCompat.isAttachedToWindow(viewTarget.getView())) {
                return viewTargetRequestDelegate;
            }
            Extensions.getRequestManager(viewTarget.getView()).onViewDetachedFromWindow(viewTarget.getView());
            return viewTargetRequestDelegate;
        }
        BaseRequestDelegate baseRequestDelegate = new BaseRequestDelegate(lifecycle, job);
        lifecycle.addObserver(baseRequestDelegate);
        return baseRequestDelegate;
    }

    @NotNull
    @MainThread
    public final TargetDelegate createTargetDelegate(@Nullable Target target, int i11, @NotNull EventListener eventListener) {
        TargetDelegate invalidatableTargetDelegate;
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("Invalid type.".toString());
            } else if (target == null) {
                return new InvalidatableEmptyTargetDelegate(this.referenceCounter);
            } else {
                invalidatableTargetDelegate = new InvalidatableTargetDelegate(target, this.referenceCounter, eventListener, this.logger);
            }
        } else if (target == null) {
            return EmptyTargetDelegate.INSTANCE;
        } else {
            if (target instanceof PoolableViewTarget) {
                invalidatableTargetDelegate = new PoolableTargetDelegate((PoolableViewTarget) target, this.referenceCounter, eventListener, this.logger);
            } else {
                invalidatableTargetDelegate = new InvalidatableTargetDelegate(target, this.referenceCounter, eventListener, this.logger);
            }
        }
        return invalidatableTargetDelegate;
    }
}
