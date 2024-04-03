package coil.drawable;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 U2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB9\b\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fBA\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\b\u0010\u001f\u001a\u00020 H\u0016J!\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\tH\u0017J\n\u0010)\u001a\u0004\u0018\u00010*H\u0017J\b\u0010+\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\tH\u0016J\b\u0010-\u001a\u00020\tH\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020\u0001H\u0016J\b\u00100\u001a\u00020\u000bH\u0016J\b\u00101\u001a\u00020 H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0014J\u0010\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\tH\u0014J\u0010\u00107\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u000208H\u0014J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\u0011H\u0016J \u0010;\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001dH\u0016J\u0010\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\tH\u0016J\u0012\u0010A\u001a\u00020 2\b\u0010B\u001a\u0004\u0018\u00010*H\u0017J\u0010\u0010C\u001a\u00020 2\u0006\u0010D\u001a\u00020\tH\u0017J\u0012\u0010E\u001a\u00020 2\b\u0010F\u001a\u0004\u0018\u00010GH\u0017J\u0012\u0010H\u001a\u00020 2\b\u0010I\u001a\u0004\u0018\u00010JH\u0017J\u0012\u0010K\u001a\u00020 2\b\u0010L\u001a\u0004\u0018\u00010MH\u0017J\b\u0010\u0004\u001a\u00020 H\u0016J\b\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u0011H\u0016J\u0018\u0010P\u001a\u00020 2\u0006\u0010/\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=H\u0016J\u001d\u0010Q\u001a\u00020 2\u0006\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u000204H\u0001¢\u0006\u0002\bTR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcoil/drawable/CrossfadeDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat;", "start", "end", "scale", "Lcoil/size/Scale;", "durationMillis", "", "fadeStart", "", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/size/Scale;IZ)V", "preferExactIntrinsicSize", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/size/Scale;IZZ)V", "callbacks", "", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "getDurationMillis", "()I", "getFadeStart", "()Z", "intrinsicHeight", "intrinsicWidth", "maxAlpha", "getPreferExactIntrinsicSize", "getScale", "()Lcoil/size/Scale;", "startTimeMillis", "", "state", "clearAnimationCallbacks", "", "computeIntrinsicDimension", "startSize", "endSize", "(Ljava/lang/Integer;Ljava/lang/Integer;)I", "draw", "canvas", "Landroid/graphics/Canvas;", "getAlpha", "getColorFilter", "Landroid/graphics/ColorFilter;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "invalidateDrawable", "who", "isRunning", "markDone", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "onLevelChange", "level", "onStateChange", "", "registerAnimationCallback", "callback", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "setAlpha", "alpha", "setColorFilter", "colorFilter", "setTint", "tintColor", "setTintBlendMode", "blendMode", "Landroid/graphics/BlendMode;", "setTintList", "tint", "Landroid/content/res/ColorStateList;", "setTintMode", "tintMode", "Landroid/graphics/PorterDuff$Mode;", "stop", "unregisterAnimationCallback", "unscheduleDrawable", "updateBounds", "drawable", "targetBounds", "updateBounds$coil_base_release", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CrossfadeDrawable extends Drawable implements Drawable.Callback, Animatable2Compat {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_DURATION = 100;
    private static final int STATE_DONE = 2;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_START = 0;
    @NotNull
    private final List<Animatable2Compat.AnimationCallback> callbacks;
    private final int durationMillis;
    @Nullable
    private final Drawable end;
    private final boolean fadeStart;
    private final int intrinsicHeight;
    private final int intrinsicWidth;
    private int maxAlpha;
    private final boolean preferExactIntrinsicSize;
    @NotNull
    private final Scale scale;
    @Nullable
    private Drawable start;
    private long startTimeMillis;
    private int state;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/drawable/CrossfadeDrawable$Companion;", "", "()V", "DEFAULT_DURATION", "", "STATE_DONE", "STATE_RUNNING", "STATE_START", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @SinceKotlin(version = "999.9")
    @JvmOverloads
    public CrossfadeDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        this(drawable, drawable2, (Scale) null, 0, false, 28, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @SinceKotlin(version = "999.9")
    @JvmOverloads
    public CrossfadeDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2, @NotNull Scale scale2) {
        this(drawable, drawable2, scale2, 0, false, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(scale2, "scale");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @SinceKotlin(version = "999.9")
    @JvmOverloads
    public CrossfadeDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2, @NotNull Scale scale2, int i11) {
        this(drawable, drawable2, scale2, i11, false, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(scale2, "scale");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale2, int i11, boolean z11, boolean z12, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, drawable2, (i12 & 4) != 0 ? Scale.FIT : scale2, (i12 & 8) != 0 ? 100 : i11, (i12 & 16) != 0 ? true : z11, (i12 & 32) != 0 ? false : z12);
    }

    private final int computeIntrinsicDimension(Integer num, Integer num2) {
        int i11;
        int i12 = -1;
        if (!this.preferExactIntrinsicSize) {
            if (num != null && num.intValue() == -1) {
                return -1;
            }
            if (num2 != null && num2.intValue() == -1) {
                return -1;
            }
        }
        if (num == null) {
            i11 = -1;
        } else {
            i11 = num.intValue();
        }
        if (num2 != null) {
            i12 = num2.intValue();
        }
        return Math.max(i11, i12);
    }

    private final void markDone() {
        this.state = 2;
        this.start = null;
        List<Animatable2Compat.AnimationCallback> list = this.callbacks;
        int size = list.size() - 1;
        if (size >= 0) {
            int i11 = 0;
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

    public void clearAnimationCallbacks() {
        this.callbacks.clear();
    }

    public void draw(@NotNull Canvas canvas) {
        boolean z11;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i11 = this.state;
        if (i11 == 0) {
            Drawable drawable2 = this.start;
            if (drawable2 != null) {
                drawable2.setAlpha(this.maxAlpha);
                int save = canvas.save();
                try {
                    drawable2.draw(canvas);
                } finally {
                    canvas.restoreToCount(save);
                }
            }
        } else if (i11 == 2) {
            Drawable drawable3 = this.end;
            if (drawable3 != null) {
                drawable3.setAlpha(this.maxAlpha);
                int save2 = canvas.save();
                try {
                    drawable3.draw(canvas);
                } finally {
                    canvas.restoreToCount(save2);
                }
            }
        } else {
            double uptimeMillis = ((double) (SystemClock.uptimeMillis() - this.startTimeMillis)) / ((double) this.durationMillis);
            double coerceIn = RangesKt___RangesKt.coerceIn(uptimeMillis, 0.0d, 1.0d);
            int i12 = this.maxAlpha;
            int i13 = (int) (coerceIn * ((double) i12));
            if (this.fadeStart) {
                i12 -= i13;
            }
            if (uptimeMillis >= 1.0d) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 && (drawable = this.start) != null) {
                drawable.setAlpha(i12);
                int save3 = canvas.save();
                try {
                    drawable.draw(canvas);
                } finally {
                    canvas.restoreToCount(save3);
                }
            }
            Drawable drawable4 = this.end;
            if (drawable4 != null) {
                drawable4.setAlpha(i13);
                int save4 = canvas.save();
                try {
                    drawable4.draw(canvas);
                } finally {
                    canvas.restoreToCount(save4);
                }
            }
            if (z11) {
                markDone();
            } else {
                invalidateSelf();
            }
        }
    }

    @RequiresApi(19)
    public int getAlpha() {
        return this.maxAlpha;
    }

    @RequiresApi(21)
    @Nullable
    public ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        Drawable drawable;
        int i11 = this.state;
        if (i11 == 0) {
            Drawable drawable2 = this.start;
            if (drawable2 == null) {
                return null;
            }
            return drawable2.getColorFilter();
        } else if (i11 == 1) {
            Drawable drawable3 = this.end;
            if (drawable3 == null) {
                colorFilter = null;
            } else {
                colorFilter = drawable3.getColorFilter();
            }
            if (colorFilter != null) {
                return colorFilter;
            }
            Drawable drawable4 = this.start;
            if (drawable4 == null) {
                return null;
            }
            return drawable4.getColorFilter();
        } else if (i11 == 2 && (drawable = this.end) != null) {
            return drawable.getColorFilter();
        } else {
            return null;
        }
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getFadeStart() {
        return this.fadeStart;
    }

    public int getIntrinsicHeight() {
        return this.intrinsicHeight;
    }

    public int getIntrinsicWidth() {
        return this.intrinsicWidth;
    }

    public int getOpacity() {
        Drawable drawable = this.start;
        Drawable drawable2 = this.end;
        int i11 = this.state;
        if (i11 == 0) {
            if (drawable == null) {
                return -2;
            }
            return drawable.getOpacity();
        } else if (i11 == 2) {
            if (drawable2 == null) {
                return -2;
            }
            return drawable2.getOpacity();
        } else if (drawable != null && drawable2 != null) {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        } else {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        }
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    @NotNull
    public final Scale getScale() {
        return this.scale;
    }

    public void invalidateDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        invalidateSelf();
    }

    public boolean isRunning() {
        return this.state == 1;
    }

    public void onBoundsChange(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
        Drawable drawable = this.start;
        if (drawable != null) {
            updateBounds$coil_base_release(drawable, rect);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            updateBounds$coil_base_release(drawable2, rect);
        }
    }

    public boolean onLevelChange(int i11) {
        boolean z11;
        boolean z12;
        Drawable drawable = this.start;
        if (drawable == null) {
            z11 = false;
        } else {
            z11 = drawable.setLevel(i11);
        }
        Drawable drawable2 = this.end;
        if (drawable2 == null) {
            z12 = false;
        } else {
            z12 = drawable2.setLevel(i11);
        }
        if (z11 || z12) {
            return true;
        }
        return false;
    }

    public boolean onStateChange(@NotNull int[] iArr) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(iArr, "state");
        Drawable drawable = this.start;
        if (drawable == null) {
            z11 = false;
        } else {
            z11 = drawable.setState(iArr);
        }
        Drawable drawable2 = this.end;
        if (drawable2 == null) {
            z12 = false;
        } else {
            z12 = drawable2.setState(iArr);
        }
        if (z11 || z12) {
            return true;
        }
        return false;
    }

    public void registerAnimationCallback(@NotNull Animatable2Compat.AnimationCallback animationCallback) {
        Intrinsics.checkNotNullParameter(animationCallback, "callback");
        this.callbacks.add(animationCallback);
    }

    public void scheduleDrawable(@NotNull Drawable drawable, @NotNull Runnable runnable, long j11) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        Intrinsics.checkNotNullParameter(runnable, "what");
        scheduleSelf(runnable, j11);
    }

    public void setAlpha(int i11) {
        boolean z11 = false;
        if (i11 >= 0 && i11 <= 255) {
            z11 = true;
        }
        if (z11) {
            this.maxAlpha = i11;
            return;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid alpha: ", Integer.valueOf(i11)).toString());
    }

    @RequiresApi(21)
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    @RequiresApi(21)
    public void setTint(int i11) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTint(i11);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTint(i11);
        }
    }

    @RequiresApi(29)
    public void setTintBlendMode(@Nullable BlendMode blendMode) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    @RequiresApi(21)
    public void setTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    @RequiresApi(21)
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.start;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.end;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r4 = this;
            android.graphics.drawable.Drawable r0 = r4.start
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            r2 = 0
            if (r1 == 0) goto L_0x000a
            android.graphics.drawable.Animatable r0 = (android.graphics.drawable.Animatable) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 != 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0.start()
        L_0x0011:
            android.graphics.drawable.Drawable r0 = r4.end
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            if (r1 == 0) goto L_0x001a
            r2 = r0
            android.graphics.drawable.Animatable r2 = (android.graphics.drawable.Animatable) r2
        L_0x001a:
            if (r2 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            r2.start()
        L_0x0020:
            int r0 = r4.state
            if (r0 == 0) goto L_0x0025
            return
        L_0x0025:
            r0 = 1
            r4.state = r0
            long r0 = android.os.SystemClock.uptimeMillis()
            r4.startTimeMillis = r0
            java.util.List<androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback> r0 = r4.callbacks
            int r1 = r0.size()
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x0049
            r2 = 0
        L_0x0039:
            int r3 = r2 + 1
            java.lang.Object r2 = r0.get(r2)
            androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback r2 = (androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback) r2
            r2.onAnimationStart(r4)
            if (r3 <= r1) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r2 = r3
            goto L_0x0039
        L_0x0049:
            r4.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.drawable.CrossfadeDrawable.start():void");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop() {
        /*
            r3 = this;
            android.graphics.drawable.Drawable r0 = r3.start
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            r2 = 0
            if (r1 == 0) goto L_0x000a
            android.graphics.drawable.Animatable r0 = (android.graphics.drawable.Animatable) r0
            goto L_0x000b
        L_0x000a:
            r0 = r2
        L_0x000b:
            if (r0 != 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0.stop()
        L_0x0011:
            android.graphics.drawable.Drawable r0 = r3.end
            boolean r1 = r0 instanceof android.graphics.drawable.Animatable
            if (r1 == 0) goto L_0x001a
            r2 = r0
            android.graphics.drawable.Animatable r2 = (android.graphics.drawable.Animatable) r2
        L_0x001a:
            if (r2 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            r2.stop()
        L_0x0020:
            int r0 = r3.state
            r1 = 2
            if (r0 == r1) goto L_0x0028
            r3.markDone()
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.drawable.CrossfadeDrawable.stop():void");
    }

    public boolean unregisterAnimationCallback(@NotNull Animatable2Compat.AnimationCallback animationCallback) {
        Intrinsics.checkNotNullParameter(animationCallback, "callback");
        return this.callbacks.remove(animationCallback);
    }

    public void unscheduleDrawable(@NotNull Drawable drawable, @NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(drawable, "who");
        Intrinsics.checkNotNullParameter(runnable, "what");
        unscheduleSelf(runnable);
    }

    @VisibleForTesting
    public final void updateBounds$coil_base_release(@NotNull Drawable drawable, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(rect, "targetBounds");
        int intrinsicWidth2 = drawable.getIntrinsicWidth();
        int intrinsicHeight2 = drawable.getIntrinsicHeight();
        if (intrinsicWidth2 <= 0 || intrinsicHeight2 <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int width = rect.width();
        int height = rect.height();
        double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(intrinsicWidth2, intrinsicHeight2, width, height, this.scale);
        double d11 = (double) 2;
        int roundToInt = MathKt__MathJVMKt.roundToInt((((double) width) - (((double) intrinsicWidth2) * computeSizeMultiplier)) / d11);
        int roundToInt2 = MathKt__MathJVMKt.roundToInt((((double) height) - (computeSizeMultiplier * ((double) intrinsicHeight2))) / d11);
        drawable.setBounds(rect.left + roundToInt, rect.top + roundToInt2, rect.right - roundToInt, rect.bottom - roundToInt2);
    }

    public CrossfadeDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2, @NotNull Scale scale2, int i11, boolean z11, boolean z12) {
        Integer num;
        Integer num2;
        Drawable drawable3;
        Intrinsics.checkNotNullParameter(scale2, "scale");
        this.scale = scale2;
        this.durationMillis = i11;
        this.fadeStart = z11;
        this.preferExactIntrinsicSize = z12;
        this.callbacks = new ArrayList();
        Drawable drawable4 = null;
        if (drawable == null) {
            num = null;
        } else {
            num = Integer.valueOf(drawable.getIntrinsicWidth());
        }
        this.intrinsicWidth = computeIntrinsicDimension(num, drawable2 == null ? null : Integer.valueOf(drawable2.getIntrinsicWidth()));
        if (drawable == null) {
            num2 = null;
        } else {
            num2 = Integer.valueOf(drawable.getIntrinsicHeight());
        }
        this.intrinsicHeight = computeIntrinsicDimension(num2, drawable2 == null ? null : Integer.valueOf(drawable2.getIntrinsicHeight()));
        if (drawable == null) {
            drawable3 = null;
        } else {
            drawable3 = drawable.mutate();
        }
        this.start = drawable3;
        drawable4 = drawable2 != null ? drawable2.mutate() : drawable4;
        this.end = drawable4;
        this.maxAlpha = 255;
        if (i11 > 0) {
            Drawable drawable5 = this.start;
            if (drawable5 != null) {
                drawable5.setCallback(this);
            }
            if (drawable4 != null) {
                drawable4.setCallback(this);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("durationMillis must be > 0.".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale2, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, drawable2, (i12 & 4) != 0 ? Scale.FIT : scale2, (i12 & 8) != 0 ? 100 : i11, (i12 & 16) != 0 ? true : z11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @SinceKotlin(version = "999.9")
    @JvmOverloads
    public CrossfadeDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2, @NotNull Scale scale2, int i11, boolean z11) {
        this(drawable, drawable2, scale2, i11, z11, false, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(scale2, "scale");
    }
}
