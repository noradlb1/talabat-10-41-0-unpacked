package coil.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import coil.fetch.Fetcher;
import coil.request.ImageRequest;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.ViewSizeResolver;
import coil.target.ViewTarget;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a+\u0010\u0005\u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0006\"\b\b\u0000\u0010\u0007*\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u0002H\u0007H\u0000¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0012"}, d2 = {"allowInexactSize", "", "Lcoil/request/ImageRequest;", "getAllowInexactSize", "(Lcoil/request/ImageRequest;)Z", "fetcher", "Lcoil/fetch/Fetcher;", "T", "", "data", "(Lcoil/request/ImageRequest;Ljava/lang/Object;)Lcoil/fetch/Fetcher;", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "drawable", "resId", "", "default", "(Lcoil/request/ImageRequest;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-Requests")
/* renamed from: coil.util.-Requests  reason: invalid class name */
public final class Requests {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: coil.util.-Requests$WhenMappings */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Precision.values().length];
            iArr[Precision.EXACT.ordinal()] = 1;
            iArr[Precision.INEXACT.ordinal()] = 2;
            iArr[Precision.AUTOMATIC.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Nullable
    public static final <T> Fetcher<T> fetcher(@NotNull ImageRequest imageRequest, @NotNull T t11) {
        Intrinsics.checkNotNullParameter(imageRequest, "<this>");
        Intrinsics.checkNotNullParameter(t11, "data");
        Pair<Fetcher<?>, Class<?>> fetcher = imageRequest.getFetcher();
        if (fetcher == null) {
            return null;
        }
        Fetcher<T> component1 = fetcher.component1();
        if (fetcher.component2().isAssignableFrom(t11.getClass())) {
            return component1;
        }
        throw new IllegalStateException((component1.getClass().getName() + " cannot handle data with type " + t11.getClass().getName() + '.').toString());
    }

    public static final boolean getAllowInexactSize(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[imageRequest.getPrecision().ordinal()];
        if (i11 == 1) {
            return false;
        }
        if (i11 == 2) {
            return true;
        }
        if (i11 != 3) {
            throw new NoWhenBranchMatchedException();
        } else if ((imageRequest.getTarget() instanceof ViewTarget) && (((ViewTarget) imageRequest.getTarget()).getView() instanceof ImageView) && (imageRequest.getSizeResolver() instanceof ViewSizeResolver) && ((ViewSizeResolver) imageRequest.getSizeResolver()).getView() == ((ViewTarget) imageRequest.getTarget()).getView()) {
            return true;
        } else {
            if (imageRequest.getDefined().getSizeResolver() != null || !(imageRequest.getSizeResolver() instanceof DisplaySizeResolver)) {
                return false;
            }
            return true;
        }
    }

    @Nullable
    public static final Drawable getDrawableCompat(@NotNull ImageRequest imageRequest, @Nullable Drawable drawable, @Nullable @DrawableRes Integer num, @Nullable Drawable drawable2) {
        Intrinsics.checkNotNullParameter(imageRequest, "<this>");
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return Contexts.getDrawableCompat(imageRequest.getContext(), num.intValue());
    }
}
