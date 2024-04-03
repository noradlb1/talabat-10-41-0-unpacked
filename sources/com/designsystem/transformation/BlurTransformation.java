package com.designsystem.transformation;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/designsystem/transformation/BlurTransformation;", "", "context", "Landroid/content/Context;", "radius", "", "sampling", "(Landroid/content/Context;FF)V", "realRadius", "getRealRadius", "()F", "realSampling", "getRealSampling", "transform", "Landroid/graphics/Bitmap;", "source", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BlurTransformation {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final float DEFAULT_SAMPLING = 1.0f;
    @Deprecated
    private static final float MAX_RADIUS = 25.0f;
    @Deprecated
    private static final float MIN_RADIUS = 0.0f;
    @Deprecated
    private static final float MIN_SAMPLING = 1.0f;
    @NotNull
    private final Context context;
    private final float radius;
    private final float sampling;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/designsystem/transformation/BlurTransformation$Companion;", "", "()V", "DEFAULT_SAMPLING", "", "MAX_RADIUS", "MIN_RADIUS", "MIN_SAMPLING", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BlurTransformation(@NotNull Context context2, float f11, float f12) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.radius = f11;
        this.sampling = f12;
    }

    private final float getRealRadius() {
        return RangesKt___RangesKt.coerceIn(this.radius, 0.0f, (float) MAX_RADIUS);
    }

    private final float getRealSampling() {
        return RangesKt___RangesKt.coerceAtLeast(this.sampling, 1.0f);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: android.renderscript.Allocation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.renderscript.RenderScript} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: android.renderscript.ScriptIntrinsicBlur} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.renderscript.RenderScript} */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b2  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap transform(@org.jetbrains.annotations.NotNull android.graphics.Bitmap r10) {
        /*
            r9 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.graphics.Paint r0 = new android.graphics.Paint
            r1 = 3
            r0.<init>(r1)
            int r1 = r10.getWidth()
            float r1 = (float) r1
            float r2 = r9.getRealSampling()
            float r1 = r1 / r2
            int r1 = (int) r1
            int r2 = r10.getHeight()
            float r2 = (float) r2
            float r3 = r9.getRealSampling()
            float r2 = r2 / r3
            int r2 = (int) r2
            r3 = 0
            if (r1 == 0) goto L_0x00b7
            if (r2 != 0) goto L_0x0028
            goto L_0x00b7
        L_0x0028:
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r1, r2, r4)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r1)
            r4 = 1
            float r5 = (float) r4
            float r6 = r9.getRealSampling()
            float r6 = r5 / r6
            float r7 = r9.getRealSampling()
            float r5 = r5 / r7
            r2.scale(r6, r5)
            r5 = 0
            r2.drawBitmap(r10, r5, r5, r0)
            float r10 = r9.getRealRadius()
            int r10 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r10 <= 0) goto L_0x00b6
            android.content.Context r10 = r9.context     // Catch:{ all -> 0x0099 }
            android.renderscript.RenderScript r10 = android.renderscript.RenderScript.create(r10)     // Catch:{ all -> 0x0099 }
            android.renderscript.Allocation$MipmapControl r0 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch:{ all -> 0x0093 }
            android.renderscript.Allocation r0 = android.renderscript.Allocation.createFromBitmap(r10, r1, r0, r4)     // Catch:{ all -> 0x0093 }
            android.renderscript.Type r2 = r0.getType()     // Catch:{ all -> 0x0090 }
            android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r10, r2)     // Catch:{ all -> 0x0090 }
            android.renderscript.Element r4 = android.renderscript.Element.U8_4(r10)     // Catch:{ all -> 0x008b }
            android.renderscript.ScriptIntrinsicBlur r3 = android.renderscript.ScriptIntrinsicBlur.create(r10, r4)     // Catch:{ all -> 0x008b }
            float r4 = r9.getRealRadius()     // Catch:{ all -> 0x008b }
            r3.setRadius(r4)     // Catch:{ all -> 0x008b }
            r3.setInput(r0)     // Catch:{ all -> 0x008b }
            r3.forEach(r2)     // Catch:{ all -> 0x008b }
            r2.copyTo(r1)     // Catch:{ all -> 0x008b }
            if (r10 != 0) goto L_0x007e
            goto L_0x0081
        L_0x007e:
            r10.destroy()
        L_0x0081:
            r0.destroy()
            r2.destroy()
            r3.destroy()
            goto L_0x00b6
        L_0x008b:
            r1 = move-exception
            r8 = r3
            r3 = r10
            r10 = r8
            goto L_0x009d
        L_0x0090:
            r1 = move-exception
            r2 = r3
            goto L_0x0096
        L_0x0093:
            r1 = move-exception
            r0 = r3
            r2 = r0
        L_0x0096:
            r3 = r10
            r10 = r2
            goto L_0x009d
        L_0x0099:
            r1 = move-exception
            r10 = r3
            r0 = r10
            r2 = r0
        L_0x009d:
            if (r3 != 0) goto L_0x00a0
            goto L_0x00a3
        L_0x00a0:
            r3.destroy()
        L_0x00a3:
            if (r0 != 0) goto L_0x00a6
            goto L_0x00a9
        L_0x00a6:
            r0.destroy()
        L_0x00a9:
            if (r2 != 0) goto L_0x00ac
            goto L_0x00af
        L_0x00ac:
            r2.destroy()
        L_0x00af:
            if (r10 != 0) goto L_0x00b2
            goto L_0x00b5
        L_0x00b2:
            r10.destroy()
        L_0x00b5:
            throw r1
        L_0x00b6:
            return r1
        L_0x00b7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.transformation.BlurTransformation.transform(android.graphics.Bitmap):android.graphics.Bitmap");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BlurTransformation(Context context2, float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i11 & 2) != 0 ? 0.0f : f11, (i11 & 4) != 0 ? 1.0f : f12);
    }
}
