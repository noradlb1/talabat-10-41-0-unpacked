package coil.transform;

import android.content.Context;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(18)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J)\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcoil/transform/BlurTransformation;", "Lcoil/transform/Transformation;", "context", "Landroid/content/Context;", "radius", "", "sampling", "(Landroid/content/Context;FF)V", "equals", "", "other", "", "hashCode", "", "key", "", "toString", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcoil/bitmap/BitmapPool;", "input", "size", "Lcoil/size/Size;", "(Lcoil/bitmap/BitmapPool;Landroid/graphics/Bitmap;Lcoil/size/Size;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BlurTransformation implements Transformation {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final float DEFAULT_RADIUS = 10.0f;
    @Deprecated
    private static final float DEFAULT_SAMPLING = 1.0f;
    @NotNull
    private final Context context;
    private final float radius;
    private final float sampling;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil/transform/BlurTransformation$Companion;", "", "()V", "DEFAULT_RADIUS", "", "DEFAULT_SAMPLING", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BlurTransformation(@NotNull Context context2) {
        this(context2, 0.0f, 0.0f, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BlurTransformation(@NotNull Context context2, float f11) {
        this(context2, f11, 0.0f, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    @JvmOverloads
    public BlurTransformation(@NotNull Context context2, float f11, float f12) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.radius = f11;
        this.sampling = f12;
        double d11 = (double) f11;
        boolean z11 = true;
        if (0.0d <= d11 && d11 <= 25.0d) {
            if (!(f12 <= 0.0f ? false : z11)) {
                throw new IllegalArgumentException("sampling must be > 0.".toString());
            }
            return;
        }
        throw new IllegalArgumentException("radius must be in [0, 25].".toString());
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        boolean z12;
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlurTransformation) {
            BlurTransformation blurTransformation = (BlurTransformation) obj;
            if (Intrinsics.areEqual((Object) this.context, (Object) blurTransformation.context)) {
                if (this.radius == blurTransformation.radius) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (this.sampling == blurTransformation.sampling) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.context.hashCode() * 31) + Float.floatToIntBits(this.radius)) * 31) + Float.floatToIntBits(this.sampling);
    }

    @NotNull
    public String key() {
        return BlurTransformation.class.getName() + SignatureVisitor.SUPER + this.radius + SignatureVisitor.SUPER + this.sampling;
    }

    @NotNull
    public String toString() {
        return "BlurTransformation(context=" + this.context + ", radius=" + this.radius + ", sampling=" + this.sampling + ')';
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: android.renderscript.RenderScript} */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object transform(@org.jetbrains.annotations.NotNull coil.bitmap.BitmapPool r6, @org.jetbrains.annotations.NotNull android.graphics.Bitmap r7, @org.jetbrains.annotations.NotNull coil.size.Size r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r9) {
        /*
            r5 = this;
            android.graphics.Paint r8 = new android.graphics.Paint
            r9 = 3
            r8.<init>(r9)
            int r9 = r7.getWidth()
            float r9 = (float) r9
            float r0 = r5.sampling
            float r9 = r9 / r0
            int r9 = (int) r9
            int r0 = r7.getHeight()
            float r0 = (float) r0
            float r1 = r5.sampling
            float r0 = r0 / r1
            int r0 = (int) r0
            android.graphics.Bitmap$Config r1 = coil.util.Bitmaps.getSafeConfig(r7)
            android.graphics.Bitmap r6 = r6.get(r9, r0, r1)
            android.graphics.Canvas r9 = new android.graphics.Canvas
            r9.<init>(r6)
            r0 = 1
            float r1 = (float) r0
            float r2 = r5.sampling
            float r3 = r1 / r2
            float r1 = r1 / r2
            r9.scale(r3, r1)
            r1 = 0
            r9.drawBitmap(r7, r1, r1, r8)
            r7 = 0
            android.content.Context r8 = r5.context     // Catch:{ all -> 0x007c }
            android.renderscript.RenderScript r8 = android.renderscript.RenderScript.create(r8)     // Catch:{ all -> 0x007c }
            android.renderscript.Allocation$MipmapControl r9 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch:{ all -> 0x0076 }
            android.renderscript.Allocation r9 = android.renderscript.Allocation.createFromBitmap(r8, r6, r9, r0)     // Catch:{ all -> 0x0076 }
            android.renderscript.Type r0 = r9.getType()     // Catch:{ all -> 0x0073 }
            android.renderscript.Allocation r0 = android.renderscript.Allocation.createTyped(r8, r0)     // Catch:{ all -> 0x0073 }
            android.renderscript.Element r1 = android.renderscript.Element.U8_4(r8)     // Catch:{ all -> 0x006e }
            android.renderscript.ScriptIntrinsicBlur r7 = android.renderscript.ScriptIntrinsicBlur.create(r8, r1)     // Catch:{ all -> 0x006e }
            float r1 = r5.radius     // Catch:{ all -> 0x006e }
            r7.setRadius(r1)     // Catch:{ all -> 0x006e }
            r7.setInput(r9)     // Catch:{ all -> 0x006e }
            r7.forEach(r0)     // Catch:{ all -> 0x006e }
            r0.copyTo(r6)     // Catch:{ all -> 0x006e }
            if (r8 != 0) goto L_0x0061
            goto L_0x0064
        L_0x0061:
            r8.destroy()
        L_0x0064:
            r9.destroy()
            r0.destroy()
            r7.destroy()
            return r6
        L_0x006e:
            r6 = move-exception
            r4 = r8
            r8 = r7
            r7 = r4
            goto L_0x0080
        L_0x0073:
            r6 = move-exception
            r0 = r7
            goto L_0x0079
        L_0x0076:
            r6 = move-exception
            r9 = r7
            r0 = r9
        L_0x0079:
            r7 = r8
            r8 = r0
            goto L_0x0080
        L_0x007c:
            r6 = move-exception
            r8 = r7
            r9 = r8
            r0 = r9
        L_0x0080:
            if (r7 != 0) goto L_0x0083
            goto L_0x0086
        L_0x0083:
            r7.destroy()
        L_0x0086:
            if (r9 != 0) goto L_0x0089
            goto L_0x008c
        L_0x0089:
            r9.destroy()
        L_0x008c:
            if (r0 != 0) goto L_0x008f
            goto L_0x0092
        L_0x008f:
            r0.destroy()
        L_0x0092:
            if (r8 != 0) goto L_0x0095
            goto L_0x0098
        L_0x0095:
            r8.destroy()
        L_0x0098:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.transform.BlurTransformation.transform(coil.bitmap.BitmapPool, android.graphics.Bitmap, coil.size.Size, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlurTransformation(Context context2, float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i11 & 2) != 0 ? 10.0f : f11, (i11 & 4) != 0 ? 1.0f : f12);
    }
}
