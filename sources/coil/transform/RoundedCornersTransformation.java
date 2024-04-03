package coil.transform;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Px;
import coil.bitmap.BitmapPool;
import coil.decode.DecodeUtils;
import coil.size.OriginalSize;
import coil.size.PixelSize;
import coil.size.Scale;
import coil.size.Size;
import coil.util.Bitmaps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J)\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcoil/transform/RoundedCornersTransformation;", "Lcoil/transform/Transformation;", "radius", "", "(F)V", "topLeft", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "equals", "", "other", "", "hashCode", "", "key", "", "toString", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcoil/bitmap/BitmapPool;", "input", "size", "Lcoil/size/Size;", "(Lcoil/bitmap/BitmapPool;Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RoundedCornersTransformation implements Transformation {
    private final float bottomLeft;
    private final float bottomRight;
    private final float topLeft;
    private final float topRight;

    public RoundedCornersTransformation() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, (DefaultConstructorMarker) null);
    }

    public RoundedCornersTransformation(@Px float f11, @Px float f12, @Px float f13, @Px float f14) {
        this.topLeft = f11;
        this.topRight = f12;
        this.bottomLeft = f13;
        this.bottomRight = f14;
        if (!(f11 >= 0.0f && f12 >= 0.0f && f13 >= 0.0f && f14 >= 0.0f)) {
            throw new IllegalArgumentException("All radii must be >= 0.".toString());
        }
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (this.topLeft == roundedCornersTransformation.topLeft) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (this.topRight == roundedCornersTransformation.topRight) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (this.bottomLeft == roundedCornersTransformation.bottomLeft) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        if (this.bottomRight == roundedCornersTransformation.bottomRight) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z14) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.topLeft) * 31) + Float.floatToIntBits(this.topRight)) * 31) + Float.floatToIntBits(this.bottomLeft)) * 31) + Float.floatToIntBits(this.bottomRight);
    }

    @NotNull
    public String key() {
        return RoundedCornersTransformation.class.getName() + SignatureVisitor.SUPER + this.topLeft + AbstractJsonLexerKt.COMMA + this.topRight + AbstractJsonLexerKt.COMMA + this.bottomLeft + AbstractJsonLexerKt.COMMA + this.bottomRight;
    }

    @NotNull
    public String toString() {
        return "RoundedCornersTransformation(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ')';
    }

    @Nullable
    public Object transform(@NotNull BitmapPool bitmapPool, @NotNull Bitmap bitmap, @NotNull Size size, @NotNull Continuation<? super Bitmap> continuation) {
        int i11;
        int i12;
        Paint paint = new Paint(3);
        if (size instanceof PixelSize) {
            PixelSize pixelSize = (PixelSize) size;
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(bitmap.getWidth(), bitmap.getHeight(), pixelSize.getWidth(), pixelSize.getHeight(), Scale.FILL);
            i12 = MathKt__MathJVMKt.roundToInt(((double) pixelSize.getWidth()) / computeSizeMultiplier);
            i11 = MathKt__MathJVMKt.roundToInt(((double) pixelSize.getHeight()) / computeSizeMultiplier);
        } else if (size instanceof OriginalSize) {
            i12 = bitmap.getWidth();
            i11 = bitmap.getHeight();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Bitmap bitmap2 = bitmapPool.get(i12, i11, Bitmaps.getSafeConfig(bitmap));
        Canvas canvas = new Canvas(bitmap2);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Matrix matrix = new Matrix();
        matrix.setTranslate(((float) (i12 - bitmap.getWidth())) / 2.0f, ((float) (i11 - bitmap.getHeight())) / 2.0f);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float f11 = this.topLeft;
        float f12 = this.topRight;
        float f13 = this.bottomRight;
        float f14 = this.bottomLeft;
        float[] fArr = {f11, f11, f12, f12, f13, f13, f14, f14};
        RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return bitmap2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoundedCornersTransformation(float f11, float f12, float f13, float f14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? 0.0f : f11, (i11 & 2) != 0 ? 0.0f : f12, (i11 & 4) != 0 ? 0.0f : f13, (i11 & 8) != 0 ? 0.0f : f14);
    }

    public RoundedCornersTransformation(@Px float f11) {
        this(f11, f11, f11, f11);
    }
}
