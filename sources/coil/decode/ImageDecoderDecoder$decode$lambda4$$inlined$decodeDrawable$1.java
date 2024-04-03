package coil.decode;

import android.graphics.ImageDecoder;
import android.graphics.PostProcessor;
import coil.request.Gifs;
import coil.size.PixelSize;
import coil.size.Size;
import coil.transform.AnimatedTransformation;
import coil.util.GifExtensions;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¨\u0006\u0007"}, d2 = {"Landroid/graphics/ImageDecoder;", "decoder", "Landroid/graphics/ImageDecoder$ImageInfo;", "info", "Landroid/graphics/ImageDecoder$Source;", "source", "", "androidx/core/graphics/ImageDecoderKt$decodeDrawable$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* renamed from: coil.decode.ImageDecoderDecoder$decode$lambda-4$$inlined$decodeDrawable$1  reason: invalid class name */
public final class ImageDecoderDecoder$decode$lambda4$$inlined$decodeDrawable$1 implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f39696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Size f39697b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Options f39698c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f39699d;

    public ImageDecoderDecoder$decode$lambda4$$inlined$decodeDrawable$1(Ref.ObjectRef objectRef, Size size, Options options, Ref.BooleanRef booleanRef) {
        this.f39696a = objectRef;
        this.f39697b = size;
        this.f39698c = options;
        this.f39699d = booleanRef;
    }

    public final void onHeaderDecoded(@NotNull ImageDecoder imageDecoder, @NotNull ImageDecoder.ImageInfo imageInfo, @NotNull ImageDecoder.Source source) {
        int i11;
        PostProcessor postProcessor;
        boolean z11;
        Intrinsics.checkNotNullParameter(imageDecoder, "decoder");
        Intrinsics.checkNotNullParameter(imageInfo, CustomerInfoLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(source, "source");
        File file = (File) this.f39696a.element;
        if (file != null) {
            file.delete();
        }
        if (this.f39697b instanceof PixelSize) {
            android.util.Size a11 = imageInfo.getSize();
            Intrinsics.checkNotNullExpressionValue(a11, BindingAdaptersKt.QUERY_SIZE);
            int width = a11.getWidth();
            int height = a11.getHeight();
            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, ((PixelSize) this.f39697b).getWidth(), ((PixelSize) this.f39697b).getHeight(), this.f39698c.getScale());
            Ref.BooleanRef booleanRef = this.f39699d;
            if (computeSizeMultiplier < 1.0d) {
                z11 = true;
            } else {
                z11 = false;
            }
            booleanRef.element = z11;
            if (z11 || !this.f39698c.getAllowInexactSize()) {
                imageDecoder.setTargetSize(MathKt__MathJVMKt.roundToInt(((double) width) * computeSizeMultiplier), MathKt__MathJVMKt.roundToInt(computeSizeMultiplier * ((double) height)));
            }
        }
        if (GifExtensions.isHardware(this.f39698c.getConfig())) {
            i11 = 3;
        } else {
            i11 = 1;
        }
        imageDecoder.setAllocator(i11);
        imageDecoder.setMemorySizePolicy(this.f39698c.getAllowRgb565() ^ true ? 1 : 0);
        if (this.f39698c.getColorSpace() != null) {
            imageDecoder.setTargetColorSpace(this.f39698c.getColorSpace());
        }
        imageDecoder.setUnpremultipliedRequired(!this.f39698c.getPremultipliedAlpha());
        AnimatedTransformation animatedTransformation = Gifs.animatedTransformation(this.f39698c.getParameters());
        if (animatedTransformation == null) {
            postProcessor = null;
        } else {
            postProcessor = GifExtensions.asPostProcessor(animatedTransformation);
        }
        imageDecoder.setPostProcessor(postProcessor);
    }
}
