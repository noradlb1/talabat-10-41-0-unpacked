package coil.request;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcoil/request/ErrorResult;", "Lcoil/request/ImageResult;", "drawable", "Landroid/graphics/drawable/Drawable;", "request", "Lcoil/request/ImageRequest;", "throwable", "", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Ljava/lang/Throwable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getRequest", "()Lcoil/request/ImageRequest;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ErrorResult extends ImageResult {
    @Nullable
    private final Drawable drawable;
    @NotNull
    private final ImageRequest request;
    @NotNull
    private final Throwable throwable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ErrorResult(@Nullable Drawable drawable2, @NotNull ImageRequest imageRequest, @NotNull Throwable th2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        this.drawable = drawable2;
        this.request = imageRequest;
        this.throwable = th2;
    }

    public static /* synthetic */ ErrorResult copy$default(ErrorResult errorResult, Drawable drawable2, ImageRequest imageRequest, Throwable th2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            drawable2 = errorResult.getDrawable();
        }
        if ((i11 & 2) != 0) {
            imageRequest = errorResult.getRequest();
        }
        if ((i11 & 4) != 0) {
            th2 = errorResult.throwable;
        }
        return errorResult.copy(drawable2, imageRequest, th2);
    }

    @Nullable
    public final Drawable component1() {
        return getDrawable();
    }

    @NotNull
    public final ImageRequest component2() {
        return getRequest();
    }

    @NotNull
    public final Throwable component3() {
        return this.throwable;
    }

    @NotNull
    public final ErrorResult copy(@Nullable Drawable drawable2, @NotNull ImageRequest imageRequest, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(imageRequest, "request");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        return new ErrorResult(drawable2, imageRequest, th2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.areEqual((Object) getDrawable(), (Object) errorResult.getDrawable()) && Intrinsics.areEqual((Object) getRequest(), (Object) errorResult.getRequest()) && Intrinsics.areEqual((Object) this.throwable, (Object) errorResult.throwable);
    }

    @Nullable
    public Drawable getDrawable() {
        return this.drawable;
    }

    @NotNull
    public ImageRequest getRequest() {
        return this.request;
    }

    @NotNull
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public int hashCode() {
        return ((((getDrawable() == null ? 0 : getDrawable().hashCode()) * 31) + getRequest().hashCode()) * 31) + this.throwable.hashCode();
    }

    @NotNull
    public String toString() {
        return "ErrorResult(drawable=" + getDrawable() + ", request=" + getRequest() + ", throwable=" + this.throwable + ')';
    }
}
