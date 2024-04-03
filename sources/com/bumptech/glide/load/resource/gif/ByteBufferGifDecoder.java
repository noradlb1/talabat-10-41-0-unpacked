package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {
    private static final GifDecoderFactory GIF_DECODER_FACTORY = new GifDecoderFactory();
    private static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final GifDecoderFactory gifDecoderFactory;
    private final GifHeaderParserPool parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    @VisibleForTesting
    public static class GifDecoderFactory {
        public GifDecoder build(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i11) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i11);
        }
    }

    @VisibleForTesting
    public static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> pool = Util.createQueue(0);

        public synchronized GifHeaderParser obtain(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            poll = this.pool.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.setData(byteBuffer);
        }

        public synchronized void release(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context2) {
        this(context2, Glide.get(context2).getRegistry().getImageHeaderParsers(), Glide.get(context2).getBitmapPool(), Glide.get(context2).getArrayPool());
    }

    private static int getSampleSize(GifHeader gifHeader, int i11, int i12) {
        int i13;
        int min = Math.min(gifHeader.getHeight() / i12, gifHeader.getWidth() / i11);
        if (min == 0) {
            i13 = 0;
        } else {
            i13 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i13);
        if (Log.isLoggable(TAG, 2) && max > 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Downsampling GIF, sampleSize: ");
            sb2.append(max);
            sb2.append(", target dimens: [");
            sb2.append(i11);
            sb2.append(Param.X);
            sb2.append(i12);
            sb2.append("], actual dimens: [");
            sb2.append(gifHeader.getWidth());
            sb2.append(Param.X);
            sb2.append(gifHeader.getHeight());
            sb2.append("]");
        }
        return max;
    }

    public GifDrawableResource decode(@NonNull ByteBuffer byteBuffer, int i11, int i12, @NonNull Options options) {
        GifHeaderParser obtain = this.parserPool.obtain(byteBuffer);
        try {
            return decode(byteBuffer, i11, i12, obtain, options);
        } finally {
            this.parserPool.release(obtain);
        }
    }

    public boolean handles(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return !((Boolean) options.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context2, list, bitmapPool, arrayPool, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    @Nullable
    private GifDrawableResource decode(ByteBuffer byteBuffer, int i11, int i12, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        long logTime = LogTime.getLogTime();
        try {
            GifHeader parseHeader = gifHeaderParser.parseHeader();
            if (parseHeader.getNumFrames() > 0) {
                if (parseHeader.getStatus() == 0) {
                    if (options.get(GifOptions.DECODE_FORMAT) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    GifDecoder build = this.gifDecoderFactory.build(this.provider, parseHeader, byteBuffer, getSampleSize(parseHeader, i11, i12));
                    build.setDefaultBitmapConfig(config);
                    build.advance();
                    Bitmap nextFrame = build.getNextFrame();
                    if (nextFrame == null) {
                        if (Log.isLoggable(TAG, 2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Decoded GIF from stream in ");
                            sb2.append(LogTime.getElapsedMillis(logTime));
                        }
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.context, build, UnitTransformation.get(), i11, i12, nextFrame));
                    if (Log.isLoggable(TAG, 2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Decoded GIF from stream in ");
                        sb3.append(LogTime.getElapsedMillis(logTime));
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Decoded GIF from stream in ");
                sb4.append(LogTime.getElapsedMillis(logTime));
            }
        }
    }

    @VisibleForTesting
    public ByteBufferGifDecoder(Context context2, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory2) {
        this.context = context2.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = gifDecoderFactory2;
        this.provider = new GifBitmapProvider(bitmapPool, arrayPool);
        this.parserPool = gifHeaderParserPool;
    }
}
