package qz;

import android.graphics.ImageDecoder;
import io.flutter.embedding.engine.FlutterJNI;

public final /* synthetic */ class a implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f24087a;

    public /* synthetic */ a(long j11) {
        this.f24087a = j11;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        FlutterJNI.lambda$decodeImage$0(this.f24087a, imageDecoder, imageInfo, source);
    }
}
