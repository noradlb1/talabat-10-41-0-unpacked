package coil;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Lcoil/request/ImageRequest$Builder;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ImageViews$load$2 extends Lambda implements Function1<ImageRequest.Builder, Unit> {
    public static final ImageViews$load$2 INSTANCE = new ImageViews$load$2();

    public ImageViews$load$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ImageRequest.Builder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ImageRequest.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$null");
    }
}
