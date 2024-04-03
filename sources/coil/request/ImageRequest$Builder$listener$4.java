package coil.request;

import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n"}, d2 = {"Lcoil/request/ImageRequest;", "<anonymous parameter 0>", "Lcoil/request/ImageResult$Metadata;", "<anonymous parameter 1>", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ImageRequest$Builder$listener$4 extends Lambda implements Function2<ImageRequest, ImageResult.Metadata, Unit> {
    public static final ImageRequest$Builder$listener$4 INSTANCE = new ImageRequest$Builder$listener$4();

    public ImageRequest$Builder$listener$4() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ImageRequest) obj, (ImageResult.Metadata) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ImageRequest imageRequest, @NotNull ImageResult.Metadata metadata) {
        Intrinsics.checkNotNullParameter(imageRequest, "$noName_0");
        Intrinsics.checkNotNullParameter(metadata, "$noName_1");
    }
}
