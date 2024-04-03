package coil.request;

import coil.annotation.ExperimentalCoilApi;
import coil.request.ImageRequest;
import coil.transform.AnimatedTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u0003H\u0007\u001a\u0012\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005*\u00020\u0003\u001a\u0012\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005*\u00020\u0003\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\u00012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a\u0011\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"animatedTransformation", "Lcoil/request/ImageRequest$Builder;", "Lcoil/transform/AnimatedTransformation;", "Lcoil/request/Parameters;", "animationEndCallback", "Lkotlin/Function0;", "", "animationStartCallback", "onAnimationEnd", "callback", "onAnimationStart", "repeatCount", "", "(Lcoil/request/Parameters;)Ljava/lang/Integer;", "coil-gif_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "Gifs")
public final class Gifs {
    @NotNull
    @ExperimentalCoilApi
    public static final ImageRequest.Builder animatedTransformation(@NotNull ImageRequest.Builder builder, @NotNull AnimatedTransformation animatedTransformation) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(animatedTransformation, "animatedTransformation");
        return ImageRequest.Builder.setParameter$default(builder, "coil#animated_transformation", animatedTransformation, (String) null, 4, (Object) null);
    }

    @Nullable
    public static final Function0<Unit> animationEndCallback(@NotNull Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "<this>");
        return (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(parameters.value("coil#animation_end_callback"), 0);
    }

    @Nullable
    public static final Function0<Unit> animationStartCallback(@NotNull Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "<this>");
        return (Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(parameters.value("coil#animation_start_callback"), 0);
    }

    @NotNull
    public static final ImageRequest.Builder onAnimationEnd(@NotNull ImageRequest.Builder builder, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return ImageRequest.Builder.setParameter$default(builder, "coil#animation_end_callback", function0, (String) null, 4, (Object) null);
    }

    @NotNull
    public static final ImageRequest.Builder onAnimationStart(@NotNull ImageRequest.Builder builder, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return ImageRequest.Builder.setParameter$default(builder, "coil#animation_start_callback", function0, (String) null, 4, (Object) null);
    }

    @NotNull
    public static final ImageRequest.Builder repeatCount(@NotNull ImageRequest.Builder builder, int i11) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (i11 >= -1) {
            return ImageRequest.Builder.setParameter$default(builder, "coil#repeat_count", Integer.valueOf(i11), (String) null, 4, (Object) null);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid repeatCount: ", Integer.valueOf(i11)).toString());
    }

    @Nullable
    @ExperimentalCoilApi
    public static final AnimatedTransformation animatedTransformation(@NotNull Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "<this>");
        return (AnimatedTransformation) parameters.value("coil#animated_transformation");
    }

    @Nullable
    public static final Integer repeatCount(@NotNull Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "<this>");
        return (Integer) parameters.value("coil#repeat_count");
    }
}
