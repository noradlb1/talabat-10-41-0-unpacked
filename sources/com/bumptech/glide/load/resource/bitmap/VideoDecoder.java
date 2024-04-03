package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class VideoDecoder<T> implements ResourceDecoder<T, Bitmap> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    public static final long DEFAULT_FRAME = -1;
    @VisibleForTesting
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final Option<Integer> FRAME_OPTION = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new Option.CacheKeyUpdater<Integer>() {
        private final ByteBuffer buffer = ByteBuffer.allocate(4);

        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.buffer) {
                    this.buffer.position(0);
                    messageDigest.update(this.buffer.putInt(num.intValue()).array());
                }
            }
        }
    });
    private static final String TAG = "VideoDecoder";
    public static final Option<Long> TARGET_FRAME = Option.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new Option.CacheKeyUpdater<Long>() {
        private final ByteBuffer buffer = ByteBuffer.allocate(8);

        public void update(@NonNull byte[] bArr, @NonNull Long l11, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.buffer) {
                this.buffer.position(0);
                messageDigest.update(this.buffer.putLong(l11.longValue()).array());
            }
        }
    });
    private final BitmapPool bitmapPool;
    private final MediaMetadataRetrieverFactory factory;
    private final MediaMetadataRetrieverInitializer<T> initializer;

    public static final class AssetFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<AssetFileDescriptor> {
        private AssetFileDescriptorInitializer() {
        }

        public void initialize(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @RequiresApi(23)
    public static final class ByteBufferInitializer implements MediaMetadataRetrieverInitializer<ByteBuffer> {
        public void initialize(MediaMetadataRetriever mediaMetadataRetriever, final ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new MediaDataSource() {
                public void close() {
                }

                public long getSize() {
                    return (long) byteBuffer.limit();
                }

                public int readAt(long j11, byte[] bArr, int i11, int i12) {
                    if (j11 >= ((long) byteBuffer.limit())) {
                        return -1;
                    }
                    byteBuffer.position((int) j11);
                    int min = Math.min(i12, byteBuffer.remaining());
                    byteBuffer.get(bArr, i11, min);
                    return min;
                }
            });
        }
    }

    @VisibleForTesting
    public static class MediaMetadataRetrieverFactory {
        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    @VisibleForTesting
    public interface MediaMetadataRetrieverInitializer<T> {
        void initialize(MediaMetadataRetriever mediaMetadataRetriever, T t11);
    }

    public static final class ParcelFileDescriptorInitializer implements MediaMetadataRetrieverInitializer<ParcelFileDescriptor> {
        public void initialize(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public VideoDecoder(BitmapPool bitmapPool2, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer) {
        this(bitmapPool2, mediaMetadataRetrieverInitializer, DEFAULT_FACTORY);
    }

    public static ResourceDecoder<AssetFileDescriptor, Bitmap> asset(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new AssetFileDescriptorInitializer());
    }

    @RequiresApi(api = 23)
    public static ResourceDecoder<ByteBuffer, Bitmap> byteBuffer(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new ByteBufferInitializer());
    }

    @Nullable
    private static Bitmap decodeFrame(MediaMetadataRetriever mediaMetadataRetriever, long j11, int i11, int i12, int i13, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap;
        if (Build.VERSION.SDK_INT < 27 || i12 == Integer.MIN_VALUE || i13 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.NONE) {
            bitmap = null;
        } else {
            bitmap = decodeScaledFrame(mediaMetadataRetriever, j11, i11, i12, i13, downsampleStrategy);
        }
        if (bitmap == null) {
            bitmap = decodeOriginalFrame(mediaMetadataRetriever, j11, i11);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new VideoDecoderException();
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever mediaMetadataRetriever, long j11, int i11) {
        return mediaMetadataRetriever.getFrameAtTime(j11, i11);
    }

    @TargetApi(27)
    @Nullable
    private static Bitmap decodeScaledFrame(MediaMetadataRetriever mediaMetadataRetriever, long j11, int i11, int i12, int i13, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                int i14 = parseInt2;
                parseInt2 = parseInt;
                parseInt = i14;
            }
            float scaleFactor = downsampleStrategy.getScaleFactor(parseInt, parseInt2, i12, i13);
            return mediaMetadataRetriever.getScaledFrameAtTime(j11, i11, Math.round(((float) parseInt) * scaleFactor), Math.round(scaleFactor * ((float) parseInt2)));
        } catch (Throwable unused) {
            Log.isLoggable(TAG, 3);
            return null;
        }
    }

    public static ResourceDecoder<ParcelFileDescriptor, Bitmap> parcel(BitmapPool bitmapPool2) {
        return new VideoDecoder(bitmapPool2, new ParcelFileDescriptorInitializer());
    }

    /* JADX INFO: finally extract failed */
    public Resource<Bitmap> decode(@NonNull T t11, int i11, int i12, @NonNull Options options) throws IOException {
        long longValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) options.get(FRAME_OPTION);
            if (num == null) {
                num = 2;
            }
            DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.get(DownsampleStrategy.OPTION);
            if (downsampleStrategy == null) {
                downsampleStrategy = DownsampleStrategy.DEFAULT;
            }
            DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
            MediaMetadataRetriever build = this.factory.build();
            try {
                this.initializer.initialize(build, t11);
                Bitmap decodeFrame = decodeFrame(build, longValue, num.intValue(), i11, i12, downsampleStrategy2);
                build.release();
                return BitmapResource.obtain(decodeFrame, this.bitmapPool);
            } catch (Throwable th2) {
                build.release();
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
    }

    public boolean handles(@NonNull T t11, @NonNull Options options) {
        return true;
    }

    @VisibleForTesting
    public VideoDecoder(BitmapPool bitmapPool2, MediaMetadataRetrieverInitializer<T> mediaMetadataRetrieverInitializer, MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this.bitmapPool = bitmapPool2;
        this.initializer = mediaMetadataRetrieverInitializer;
        this.factory = mediaMetadataRetrieverFactory;
    }
}
