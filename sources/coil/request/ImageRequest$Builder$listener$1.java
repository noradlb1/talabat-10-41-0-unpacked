package coil.request;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcoil/request/ImageRequest;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ImageRequest$Builder$listener$1 extends Lambda implements Function1<ImageRequest, Unit> {
    public static final ImageRequest$Builder$listener$1 INSTANCE = new ImageRequest$Builder$listener$1();

    public ImageRequest$Builder$listener$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ImageRequest) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, "it");
    }
}
