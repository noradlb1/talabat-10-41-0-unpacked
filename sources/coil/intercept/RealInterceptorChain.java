package coil.intercept;

import android.graphics.Bitmap;
import coil.EventListener;
import coil.intercept.Interceptor;
import coil.request.ImageRequest;
import coil.request.NullRequestData;
import coil.size.Size;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0018\u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\bH\u0002J&\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J\u0019\u0010$\u001a\u00020%2\u0006\u0010\n\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcoil/intercept/RealInterceptorChain;", "Lcoil/intercept/Interceptor$Chain;", "initialRequest", "Lcoil/request/ImageRequest;", "requestType", "", "interceptors", "", "Lcoil/intercept/Interceptor;", "index", "request", "size", "Lcoil/size/Size;", "cached", "Landroid/graphics/Bitmap;", "eventListener", "Lcoil/EventListener;", "(Lcoil/request/ImageRequest;ILjava/util/List;ILcoil/request/ImageRequest;Lcoil/size/Size;Landroid/graphics/Bitmap;Lcoil/EventListener;)V", "getCached", "()Landroid/graphics/Bitmap;", "getEventListener", "()Lcoil/EventListener;", "getIndex", "()I", "getInitialRequest", "()Lcoil/request/ImageRequest;", "getInterceptors", "()Ljava/util/List;", "getRequest", "getRequestType", "getSize", "()Lcoil/size/Size;", "checkRequest", "", "interceptor", "copy", "proceed", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withSize", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RealInterceptorChain implements Interceptor.Chain {
    @Nullable
    private final Bitmap cached;
    @NotNull
    private final EventListener eventListener;
    private final int index;
    @NotNull
    private final ImageRequest initialRequest;
    @NotNull
    private final List<Interceptor> interceptors;
    @NotNull
    private final ImageRequest request;
    private final int requestType;
    @NotNull
    private final Size size;

    public RealInterceptorChain(@NotNull ImageRequest imageRequest, int i11, @NotNull List<? extends Interceptor> list, int i12, @NotNull ImageRequest imageRequest2, @NotNull Size size2, @Nullable Bitmap bitmap, @NotNull EventListener eventListener2) {
        Intrinsics.checkNotNullParameter(imageRequest, "initialRequest");
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(imageRequest2, "request");
        Intrinsics.checkNotNullParameter(size2, BindingAdaptersKt.QUERY_SIZE);
        Intrinsics.checkNotNullParameter(eventListener2, "eventListener");
        this.initialRequest = imageRequest;
        this.requestType = i11;
        this.interceptors = list;
        this.index = i12;
        this.request = imageRequest2;
        this.size = size2;
        this.cached = bitmap;
        this.eventListener = eventListener2;
    }

    public static /* synthetic */ RealInterceptorChain a(RealInterceptorChain realInterceptorChain, int i11, ImageRequest imageRequest, Size size2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = realInterceptorChain.index;
        }
        if ((i12 & 2) != 0) {
            imageRequest = realInterceptorChain.getRequest();
        }
        if ((i12 & 4) != 0) {
            size2 = realInterceptorChain.getSize();
        }
        return realInterceptorChain.copy(i11, imageRequest, size2);
    }

    private final void checkRequest(ImageRequest imageRequest, Interceptor interceptor) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15 = true;
        if (imageRequest.getContext() == this.initialRequest.getContext()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (imageRequest.getData() != NullRequestData.INSTANCE) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (imageRequest.getTarget() == this.initialRequest.getTarget()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    if (imageRequest.getLifecycle() == this.initialRequest.getLifecycle()) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (z14) {
                        if (imageRequest.getSizeResolver() != this.initialRequest.getSizeResolver()) {
                            z15 = false;
                        }
                        if (!z15) {
                            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's size resolver. Use `Interceptor.Chain.withSize` instead.").toString());
                        }
                        return;
                    }
                    throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's lifecycle.").toString());
                }
                throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's target.").toString());
            }
            throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot set the request's data to null.").toString());
        }
        throw new IllegalStateException(("Interceptor '" + interceptor + "' cannot modify the request's context.").toString());
    }

    private final RealInterceptorChain copy(int i11, ImageRequest imageRequest, Size size2) {
        return new RealInterceptorChain(this.initialRequest, this.requestType, this.interceptors, i11, imageRequest, size2, this.cached, this.eventListener);
    }

    @Nullable
    public final Bitmap getCached() {
        return this.cached;
    }

    @NotNull
    public final EventListener getEventListener() {
        return this.eventListener;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final ImageRequest getInitialRequest() {
        return this.initialRequest;
    }

    @NotNull
    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    @NotNull
    public ImageRequest getRequest() {
        return this.request;
    }

    public final int getRequestType() {
        return this.requestType;
    }

    @NotNull
    public Size getSize() {
        return this.size;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object proceed(@org.jetbrains.annotations.NotNull coil.request.ImageRequest r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil.request.ImageResult> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof coil.intercept.RealInterceptorChain$proceed$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            coil.intercept.RealInterceptorChain$proceed$1 r0 = (coil.intercept.RealInterceptorChain$proceed$1) r0
            int r1 = r0.f39757l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f39757l = r1
            goto L_0x0018
        L_0x0013:
            coil.intercept.RealInterceptorChain$proceed$1 r0 = new coil.intercept.RealInterceptorChain$proceed$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f39755j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f39757l
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r12 = r0.f39754i
            coil.intercept.Interceptor r12 = (coil.intercept.Interceptor) r12
            java.lang.Object r0 = r0.f39753h
            coil.intercept.RealInterceptorChain r0 = (coil.intercept.RealInterceptorChain) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0082
        L_0x0031:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r13)
            int r13 = r11.getIndex()
            if (r13 <= 0) goto L_0x0054
            java.util.List r13 = r11.getInterceptors()
            int r2 = r11.getIndex()
            int r2 = r2 - r3
            java.lang.Object r13 = r13.get(r2)
            coil.intercept.Interceptor r13 = (coil.intercept.Interceptor) r13
            r11.checkRequest(r12, r13)
        L_0x0054:
            java.util.List r13 = r11.getInterceptors()
            int r2 = r11.getIndex()
            java.lang.Object r13 = r13.get(r2)
            coil.intercept.Interceptor r13 = (coil.intercept.Interceptor) r13
            int r2 = r11.getIndex()
            int r5 = r2 + 1
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r11
            r6 = r12
            coil.intercept.RealInterceptorChain r12 = a(r4, r5, r6, r7, r8, r9)
            r0.f39753h = r11
            r0.f39754i = r13
            r0.f39757l = r3
            java.lang.Object r12 = r13.intercept(r12, r0)
            if (r12 != r1) goto L_0x007e
            return r1
        L_0x007e:
            r0 = r11
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x0082:
            coil.request.ImageResult r13 = (coil.request.ImageResult) r13
            coil.request.ImageRequest r1 = r13.getRequest()
            r0.checkRequest(r1, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.intercept.RealInterceptorChain.proceed(coil.request.ImageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public RealInterceptorChain withSize(@NotNull Size size2) {
        Intrinsics.checkNotNullParameter(size2, BindingAdaptersKt.QUERY_SIZE);
        return a(this, 0, (ImageRequest) null, size2, 3, (Object) null);
    }
}
