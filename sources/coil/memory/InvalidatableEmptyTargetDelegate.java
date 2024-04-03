package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.bitmap.BitmapReferenceCounter;
import coil.request.SuccessResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcoil/memory/InvalidatableEmptyTargetDelegate;", "Lcoil/memory/TargetDelegate;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "(Lcoil/bitmap/BitmapReferenceCounter;)V", "success", "", "result", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InvalidatableEmptyTargetDelegate extends TargetDelegate {
    @NotNull
    private final BitmapReferenceCounter referenceCounter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InvalidatableEmptyTargetDelegate(@NotNull BitmapReferenceCounter bitmapReferenceCounter) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(bitmapReferenceCounter, "referenceCounter");
        this.referenceCounter = bitmapReferenceCounter;
    }

    @Nullable
    public Object success(@NotNull SuccessResult successResult, @NotNull Continuation<? super Unit> continuation) {
        BitmapDrawable bitmapDrawable;
        BitmapReferenceCounter bitmapReferenceCounter = this.referenceCounter;
        Drawable drawable = successResult.getDrawable();
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmapDrawable = (BitmapDrawable) drawable;
        } else {
            bitmapDrawable = null;
        }
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
        if (bitmap != null) {
            bitmapReferenceCounter.setValid(bitmap, false);
        }
        return Unit.INSTANCE;
    }
}
