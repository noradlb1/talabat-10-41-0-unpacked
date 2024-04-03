package androidx.core.graphics;

import android.graphics.ImageDecoder;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "decoder", "Landroid/graphics/ImageDecoder;", "info", "Landroid/graphics/ImageDecoder$ImageInfo;", "source", "Landroid/graphics/ImageDecoder$Source;", "onHeaderDecoded"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class ImageDecoderKt$decodeBitmap$1 implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function3<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, Unit> f11280a;

    public ImageDecoderKt$decodeBitmap$1(Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> function3) {
        this.f11280a = function3;
    }

    public final void onHeaderDecoded(@NotNull ImageDecoder imageDecoder, @NotNull ImageDecoder.ImageInfo imageInfo, @NotNull ImageDecoder.Source source) {
        Intrinsics.checkNotNullParameter(imageDecoder, "decoder");
        Intrinsics.checkNotNullParameter(imageInfo, CustomerInfoLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(source, "source");
        this.f11280a.invoke(imageDecoder, imageInfo, source);
    }
}
