package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.resource.ImageDecoderResourceDecoder;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;

@RequiresApi(api = 28)
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final BitmapPool bitmapPool = new BitmapPoolAdapter();

    public Resource<Bitmap> decode(ImageDecoder.Source source, int i11, int i12, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap a11 = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Decoded [");
            sb2.append(a11.getWidth());
            sb2.append(Param.X);
            sb2.append(a11.getHeight());
            sb2.append("] for [");
            sb2.append(i11);
            sb2.append(Param.X);
            sb2.append(i12);
            sb2.append("]");
        }
        return new BitmapResource(a11, this.bitmapPool);
    }
}
