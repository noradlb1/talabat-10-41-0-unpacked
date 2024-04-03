package coil.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.bitmap.BitmapPool;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import coil.transform.AnimatedTransformation;
import coil.transform.PixelOpacity;
import coil.util.GifExtensions;
import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB-\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u0002042\u0006\u00106\u001a\u00020,H\u0016J\u0010\u00107\u001a\u0002042\u0006\u00106\u001a\u00020,H\u0002J\b\u00108\u001a\u0004\u0018\u00010\rJ\b\u00109\u001a\u00020!H\u0016J\b\u0010:\u001a\u00020!H\u0016J\b\u0010;\u001a\u00020!H\u0016J\u0006\u0010<\u001a\u00020!J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u0012H\u0016J\u0010\u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020!H\u0016J\u0010\u0010A\u001a\u0002042\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u000e\u0010E\u001a\u0002042\u0006\u0010&\u001a\u00020!J\b\u0010F\u001a\u000204H\u0016J\b\u0010G\u001a\u000204H\u0016J\u0010\u0010H\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u0012H\u0016J\u0010\u0010I\u001a\u0002042\u0006\u00100\u001a\u00020\u0016H\u0002J\b\u0010J\u001a\u00020\u001eH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0018\u00100\u001a\u00020\u0016*\u00020,8BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u0006L"}, d2 = {"Lcoil/drawable/MovieDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "movie", "Landroid/graphics/Movie;", "pool", "Lcoil/bitmap/BitmapPool;", "config", "Landroid/graphics/Bitmap$Config;", "scale", "Lcoil/size/Scale;", "(Landroid/graphics/Movie;Lcoil/bitmap/BitmapPool;Landroid/graphics/Bitmap$Config;Lcoil/size/Scale;)V", "animatedTransformation", "Lcoil/transform/AnimatedTransformation;", "animatedTransformationPicture", "Landroid/graphics/Picture;", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "currentBounds", "Landroid/graphics/Rect;", "frameTimeMillis", "", "hardwareDx", "", "hardwareDy", "hardwareScale", "isRunning", "", "isSoftwareScalingEnabled", "loopIteration", "", "paint", "Landroid/graphics/Paint;", "pixelOpacity", "Lcoil/transform/PixelOpacity;", "repeatCount", "getScale", "()Lcoil/size/Scale;", "softwareBitmap", "Landroid/graphics/Bitmap;", "softwareCanvas", "Landroid/graphics/Canvas;", "softwareScale", "startTimeMillis", "tempCanvasBounds", "bounds", "getBounds", "(Landroid/graphics/Canvas;)Landroid/graphics/Rect;", "clearAnimationCallbacks", "", "draw", "canvas", "drawFrame", "getAnimatedTransformation", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "getRepeatCount", "registerAnimationCallback", "callback", "setAlpha", "alpha", "setAnimatedTransformation", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setRepeatCount", "start", "stop", "unregisterAnimationCallback", "updateBounds", "updateFrameTime", "Companion", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MovieDrawable extends Drawable implements Animatable2Compat {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REPEAT_INFINITE = -1;
    @Nullable
    private AnimatedTransformation animatedTransformation;
    @Nullable
    private Picture animatedTransformationPicture;
    @NotNull
    private final List<Animatable2Compat.AnimationCallback> callbacks;
    @NotNull
    private final Bitmap.Config config;
    @NotNull
    private final Rect currentBounds;
    private long frameTimeMillis;
    private float hardwareDx;
    private float hardwareDy;
    private float hardwareScale;
    private boolean isRunning;
    private boolean isSoftwareScalingEnabled;
    private int loopIteration;
    @NotNull
    private final Movie movie;
    @NotNull
    private final Paint paint;
    @NotNull
    private PixelOpacity pixelOpacity;
    @NotNull
    private final BitmapPool pool;
    private int repeatCount;
    @NotNull
    private final Scale scale;
    @Nullable
    private Bitmap softwareBitmap;
    @Nullable
    private Canvas softwareCanvas;
    private float softwareScale;
    private long startTimeMillis;
    @NotNull
    private final Rect tempCanvasBounds;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/drawable/MovieDrawable$Companion;", "", "()V", "REPEAT_INFINITE", "", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MovieDrawable(@NotNull Movie movie2) {
        this(movie2, (BitmapPool) null, (Bitmap.Config) null, (Scale) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(movie2, "movie");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MovieDrawable(@NotNull Movie movie2, @NotNull BitmapPool bitmapPool) {
        this(movie2, bitmapPool, (Bitmap.Config) null, (Scale) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(movie2, "movie");
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MovieDrawable(@NotNull Movie movie2, @NotNull BitmapPool bitmapPool, @NotNull Bitmap.Config config2) {
        this(movie2, bitmapPool, config2, (Scale) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(movie2, "movie");
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
        Intrinsics.checkNotNullParameter(config2, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MovieDrawable(Movie movie2, BitmapPool bitmapPool, Bitmap.Config config2, Scale scale2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(movie2, (i11 & 2) != 0 ? BitmapPool.Companion.create(0) : bitmapPool, (i11 & 4) != 0 ? Bitmap.Config.ARGB_8888 : config2, (i11 & 8) != 0 ? Scale.FIT : scale2);
    }

    /* JADX INFO: finally extract failed */
    private final void drawFrame(Canvas canvas) {
        Canvas canvas2 = this.softwareCanvas;
        Bitmap bitmap = this.softwareBitmap;
        if (canvas2 != null && bitmap != null) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            int save = canvas2.save();
            try {
                float f11 = this.softwareScale;
                canvas2.scale(f11, f11);
                this.movie.draw(canvas2, 0.0f, 0.0f, this.paint);
                Picture picture = this.animatedTransformationPicture;
                if (picture != null) {
                    picture.draw(canvas2);
                }
                canvas2.restoreToCount(save);
                int save2 = canvas.save();
                try {
                    canvas.translate(this.hardwareDx, this.hardwareDy);
                    float f12 = this.hardwareScale;
                    canvas.scale(f12, f12);
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
                } finally {
                    canvas.restoreToCount(save2);
                }
            } catch (Throwable th2) {
                canvas2.restoreToCount(save);
                throw th2;
            }
        }
    }

    private final Rect getBounds(Canvas canvas) {
        Rect rect = this.tempCanvasBounds;
        rect.set(0, 0, canvas.getWidth(), canvas.getHeight());
        return rect;
    }

    private final void updateBounds(Rect rect) {
        if (!Intrinsics.areEqual((Object) this.currentBounds, (Object) rect)) {
            this.currentBounds.set(rect);
            int width = rect.width();
            int height = rect.height();
            int width2 = this.movie.width();
            int height2 = this.movie.height();
            if (width2 > 0 && height2 > 0) {
                double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width2, height2, width, height, this.scale);
                if (!this.isSoftwareScalingEnabled) {
                    computeSizeMultiplier = RangesKt___RangesKt.coerceAtMost(computeSizeMultiplier, 1.0d);
                }
                float f11 = (float) computeSizeMultiplier;
                this.softwareScale = f11;
                int i11 = (int) (((float) width2) * f11);
                int i12 = (int) (f11 * ((float) height2));
                Bitmap bitmap = this.pool.get(i11, i12, this.config);
                Bitmap bitmap2 = this.softwareBitmap;
                if (bitmap2 != null) {
                    this.pool.put(bitmap2);
                }
                this.softwareBitmap = bitmap;
                this.softwareCanvas = new Canvas(bitmap);
                if (this.isSoftwareScalingEnabled) {
                    this.hardwareScale = 1.0f;
                    this.hardwareDx = 0.0f;
                    this.hardwareDy = 0.0f;
                    return;
                }
                float computeSizeMultiplier2 = (float) DecodeUtils.computeSizeMultiplier(i11, i12, width, height, this.scale);
                this.hardwareScale = computeSizeMultiplier2;
                float f12 = ((float) width) - (((float) i11) * computeSizeMultiplier2);
                float f13 = (float) 2;
                this.hardwareDx = ((float) rect.left) + (f12 / f13);
                this.hardwareDy = ((float) rect.top) + ((((float) height) - (computeSizeMultiplier2 * ((float) i12))) / f13);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean updateFrameTime() {
        /*
            r7 = this;
            android.graphics.Movie r0 = r7.movie
            int r0 = r0.duration()
            r1 = 0
            if (r0 != 0) goto L_0x000b
            r0 = r1
            goto L_0x002f
        L_0x000b:
            boolean r2 = r7.isRunning
            if (r2 == 0) goto L_0x0015
            long r2 = android.os.SystemClock.uptimeMillis()
            r7.frameTimeMillis = r2
        L_0x0015:
            long r2 = r7.frameTimeMillis
            long r4 = r7.startTimeMillis
            long r2 = r2 - r4
            int r2 = (int) r2
            int r3 = r2 / r0
            r7.loopIteration = r3
            int r4 = r7.repeatCount
            r5 = -1
            if (r4 == r5) goto L_0x0026
            if (r3 > r4) goto L_0x0027
        L_0x0026:
            r1 = 1
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            int r3 = r3 * r0
            int r0 = r2 - r3
        L_0x002c:
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x002f:
            android.graphics.Movie r2 = r7.movie
            r2.setTime(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.drawable.MovieDrawable.updateFrameTime():boolean");
    }

    public void clearAnimationCallbacks() {
        this.callbacks.clear();
    }

    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        boolean updateFrameTime = updateFrameTime();
        if (this.isSoftwareScalingEnabled) {
            updateBounds(getBounds(canvas));
            int save = canvas.save();
            try {
                float f11 = ((float) 1) / this.softwareScale;
                canvas.scale(f11, f11);
                drawFrame(canvas);
            } finally {
                canvas.restoreToCount(save);
            }
        } else {
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, Param.BOUNDS);
            updateBounds(bounds);
            drawFrame(canvas);
        }
        if (!this.isRunning || !updateFrameTime) {
            stop();
        } else {
            invalidateSelf();
        }
    }

    @Nullable
    public final AnimatedTransformation getAnimatedTransformation() {
        return this.animatedTransformation;
    }

    @NotNull
    public final Bitmap.Config getConfig() {
        return this.config;
    }

    public int getIntrinsicHeight() {
        return this.movie.height();
    }

    public int getIntrinsicWidth() {
        return this.movie.width();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r2.pixelOpacity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOpacity() {
        /*
            r2 = this;
            android.graphics.Paint r0 = r2.paint
            int r0 = r0.getAlpha()
            r1 = 255(0xff, float:3.57E-43)
            if (r0 != r1) goto L_0x001e
            coil.transform.PixelOpacity r0 = r2.pixelOpacity
            coil.transform.PixelOpacity r1 = coil.transform.PixelOpacity.OPAQUE
            if (r0 == r1) goto L_0x001c
            coil.transform.PixelOpacity r1 = coil.transform.PixelOpacity.UNCHANGED
            if (r0 != r1) goto L_0x001e
            android.graphics.Movie r0 = r2.movie
            boolean r0 = r0.isOpaque()
            if (r0 == 0) goto L_0x001e
        L_0x001c:
            r0 = -1
            goto L_0x001f
        L_0x001e:
            r0 = -3
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.drawable.MovieDrawable.getOpacity():int");
    }

    public final int getRepeatCount() {
        return this.repeatCount;
    }

    @NotNull
    public final Scale getScale() {
        return this.scale;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void registerAnimationCallback(@NotNull Animatable2Compat.AnimationCallback animationCallback) {
        Intrinsics.checkNotNullParameter(animationCallback, "callback");
        this.callbacks.add(animationCallback);
    }

    public void setAlpha(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= 255) {
            z11 = true;
        }
        if (z11) {
            this.paint.setAlpha(i11);
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid alpha: ", Integer.valueOf(i11)).toString());
    }

    public final void setAnimatedTransformation(@Nullable AnimatedTransformation animatedTransformation2) {
        this.animatedTransformation = animatedTransformation2;
        if (animatedTransformation2 == null || this.movie.width() <= 0 || this.movie.height() <= 0) {
            this.animatedTransformationPicture = null;
            this.pixelOpacity = PixelOpacity.UNCHANGED;
            this.isSoftwareScalingEnabled = false;
        } else {
            Picture picture = new Picture();
            Canvas beginRecording = picture.beginRecording(this.movie.width(), this.movie.height());
            Intrinsics.checkNotNullExpressionValue(beginRecording, "picture.beginRecording(m….width(), movie.height())");
            this.pixelOpacity = animatedTransformation2.transform(beginRecording);
            picture.endRecording();
            this.animatedTransformationPicture = picture;
            this.isSoftwareScalingEnabled = true;
        }
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public final void setRepeatCount(int i11) {
        boolean z11;
        if (i11 >= -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.repeatCount = i11;
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid repeatCount: ", Integer.valueOf(i11)).toString());
    }

    public void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            int i11 = 0;
            this.loopIteration = 0;
            this.startTimeMillis = SystemClock.uptimeMillis();
            List<Animatable2Compat.AnimationCallback> list = this.callbacks;
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i12 = i11 + 1;
                    list.get(i11).onAnimationStart(this);
                    if (i12 > size) {
                        break;
                    }
                    i11 = i12;
                }
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.isRunning) {
            int i11 = 0;
            this.isRunning = false;
            List<Animatable2Compat.AnimationCallback> list = this.callbacks;
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i12 = i11 + 1;
                    list.get(i11).onAnimationEnd(this);
                    if (i12 <= size) {
                        i11 = i12;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public boolean unregisterAnimationCallback(@NotNull Animatable2Compat.AnimationCallback animationCallback) {
        Intrinsics.checkNotNullParameter(animationCallback, "callback");
        return this.callbacks.remove(animationCallback);
    }

    @JvmOverloads
    public MovieDrawable(@NotNull Movie movie2, @NotNull BitmapPool bitmapPool, @NotNull Bitmap.Config config2, @NotNull Scale scale2) {
        Intrinsics.checkNotNullParameter(movie2, "movie");
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
        Intrinsics.checkNotNullParameter(config2, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        Intrinsics.checkNotNullParameter(scale2, "scale");
        this.movie = movie2;
        this.pool = bitmapPool;
        this.config = config2;
        this.scale = scale2;
        this.paint = new Paint(3);
        this.callbacks = new ArrayList();
        this.currentBounds = new Rect();
        this.tempCanvasBounds = new Rect();
        this.softwareScale = 1.0f;
        this.hardwareScale = 1.0f;
        this.repeatCount = -1;
        this.pixelOpacity = PixelOpacity.UNCHANGED;
        if (!(!GifExtensions.isHardware(config2))) {
            throw new IllegalArgumentException("Bitmap config must not be hardware.".toString());
        }
    }
}
