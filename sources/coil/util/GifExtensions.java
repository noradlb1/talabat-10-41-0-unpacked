package coil.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PostProcessor;
import android.graphics.drawable.Animatable2;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.transform.AnimatedTransformation;
import coil.transform.PixelOpacity;
import com.facebook.internal.NativeProtocol;
import f3.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0001\u001a(\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0001\u001a0\u0010\u0014\u001a\u00020\r\"\u0004\b\u0000\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00150\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\r0\u0018H\bø\u0001\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"flag", "", "Lcoil/transform/PixelOpacity;", "getFlag", "(Lcoil/transform/PixelOpacity;)I", "isHardware", "", "Landroid/graphics/Bitmap$Config;", "(Landroid/graphics/Bitmap$Config;)Z", "animatable2CallbackOf", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "onStart", "Lkotlin/Function0;", "", "onEnd", "animatable2CompatCallbackOf", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "asPostProcessor", "Landroid/graphics/PostProcessor;", "Lcoil/transform/AnimatedTransformation;", "forEachIndices", "T", "", "action", "Lkotlin/Function1;", "coil-gif_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-GifExtensions")
/* renamed from: coil.util.-GifExtensions  reason: invalid class name */
public final class GifExtensions {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: coil.util.-GifExtensions$WhenMappings */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PixelOpacity.values().length];
            iArr[PixelOpacity.UNCHANGED.ordinal()] = 1;
            iArr[PixelOpacity.TRANSLUCENT.ordinal()] = 2;
            iArr[PixelOpacity.OPAQUE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @RequiresApi(23)
    @NotNull
    public static final Animatable2.AnimationCallback animatable2CallbackOf(@Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        return new GifExtensions$animatable2CallbackOf$1(function0, function02);
    }

    @NotNull
    public static final Animatable2Compat.AnimationCallback animatable2CompatCallbackOf(@Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        return new GifExtensions$animatable2CompatCallbackOf$1(function0, function02);
    }

    @RequiresApi(28)
    @NotNull
    public static final PostProcessor asPostProcessor(@NotNull AnimatedTransformation animatedTransformation) {
        Intrinsics.checkNotNullParameter(animatedTransformation, "<this>");
        return new b(animatedTransformation);
    }

    /* access modifiers changed from: private */
    /* renamed from: asPostProcessor$lambda-0  reason: not valid java name */
    public static final int m9135asPostProcessor$lambda0(AnimatedTransformation animatedTransformation, Canvas canvas) {
        Intrinsics.checkNotNullParameter(animatedTransformation, "$this_asPostProcessor");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        return getFlag(animatedTransformation.transform(canvas));
    }

    public static final <T> void forEachIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        int size = list.size() - 1;
        if (size >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                function1.invoke(list.get(i11));
                if (i12 <= size) {
                    i11 = i12;
                } else {
                    return;
                }
            }
        }
    }

    public static final int getFlag(@NotNull PixelOpacity pixelOpacity) {
        Intrinsics.checkNotNullParameter(pixelOpacity, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[pixelOpacity.ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return -3;
        }
        if (i11 == 3) {
            return -1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isHardware(@NotNull Bitmap.Config config) {
        Intrinsics.checkNotNullParameter(config, "<this>");
        if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.HARDWARE) {
            return false;
        }
        return true;
    }
}
