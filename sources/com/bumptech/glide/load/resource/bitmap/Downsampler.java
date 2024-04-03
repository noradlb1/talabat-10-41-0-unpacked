package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class Downsampler {
    public static final Option<Boolean> ALLOW_HARDWARE_CONFIG;
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);
    @Deprecated
    public static final Option<DownsampleStrategy> DOWNSAMPLE_STRATEGY = DownsampleStrategy.OPTION;
    private static final DecodeCallbacks EMPTY_CALLBACKS = new DecodeCallbacks() {
        public void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) {
        }

        public void onObtainBounds() {
        }
    };
    public static final Option<Boolean> FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS;
    private static final String ICO_MIME_TYPE = "image/x-ico";
    private static final Set<String> NO_DOWNSAMPLE_PRE_N_MIME_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{WBMP_MIME_TYPE, ICO_MIME_TYPE})));
    private static final Queue<BitmapFactory.Options> OPTIONS_QUEUE = Util.createQueue(0);
    public static final Option<PreferredColorSpace> PREFERRED_COLOR_SPACE = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);
    static final String TAG = "Downsampler";
    private static final Set<ImageHeaderParser.ImageType> TYPES_THAT_USE_POOL_PRE_KITKAT = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    private static final String WBMP_MIME_TYPE = "image/vnd.wap.wbmp";
    private final BitmapPool bitmapPool;
    private final ArrayPool byteArrayPool;
    private final DisplayMetrics displayMetrics;
    private final HardwareConfigState hardwareConfigState = HardwareConfigState.getInstance();
    private final List<ImageHeaderParser> parsers;

    public interface DecodeCallbacks {
        void onDecodeComplete(BitmapPool bitmapPool, Bitmap bitmap) throws IOException;

        void onObtainBounds();
    }

    static {
        Boolean bool = Boolean.FALSE;
        FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        ALLOW_HARDWARE_CONFIG = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public Downsampler(List<ImageHeaderParser> list, DisplayMetrics displayMetrics2, BitmapPool bitmapPool2, ArrayPool arrayPool) {
        this.parsers = list;
        this.displayMetrics = (DisplayMetrics) Preconditions.checkNotNull(displayMetrics2);
        this.bitmapPool = (BitmapPool) Preconditions.checkNotNull(bitmapPool2);
        this.byteArrayPool = (ArrayPool) Preconditions.checkNotNull(arrayPool);
    }

    private static int adjustTargetDensityForError(double d11) {
        int densityMultiplier = getDensityMultiplier(d11);
        int round = round(((double) densityMultiplier) * d11);
        return round((d11 / ((double) (((float) round) / ((float) densityMultiplier)))) * ((double) round));
    }

    private void calculateConfig(ImageReader imageReader, DecodeFormat decodeFormat, boolean z11, boolean z12, BitmapFactory.Options options, int i11, int i12) {
        boolean z13;
        Bitmap.Config config;
        if (!this.hardwareConfigState.setHardwareConfigIfAllowed(i11, i12, options, z11, z12)) {
            if (decodeFormat != DecodeFormat.PREFER_ARGB_8888) {
                try {
                    z13 = imageReader.getImageType().hasAlpha();
                } catch (IOException unused) {
                    if (Log.isLoggable(TAG, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Cannot determine whether the image has alpha or not from header, format ");
                        sb2.append(decodeFormat);
                    }
                    z13 = false;
                }
                if (z13) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                options.inPreferredConfig = config;
                if (config == Bitmap.Config.RGB_565) {
                    options.inDither = true;
                    return;
                }
                return;
            }
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        }
    }

    private static void calculateScaling(ImageHeaderParser.ImageType imageType, ImageReader imageReader, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2, DownsampleStrategy downsampleStrategy, int i11, int i12, int i13, int i14, int i15, BitmapFactory.Options options) throws IOException {
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        double d11;
        ImageHeaderParser.ImageType imageType2 = imageType;
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        int i23 = i12;
        int i24 = i13;
        int i25 = i14;
        int i26 = i15;
        BitmapFactory.Options options2 = options;
        if (i23 <= 0 || i24 <= 0) {
            String str = TAG;
            String str2 = Param.X;
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to determine dimensions for: ");
                sb2.append(imageType2);
                sb2.append(" with target [");
                sb2.append(i25);
                sb2.append(str2);
                sb2.append(i26);
                sb2.append("]");
                return;
            }
            return;
        }
        if (isRotationRequired(i11)) {
            i16 = i23;
            i17 = i24;
        } else {
            i17 = i23;
            i16 = i24;
        }
        float scaleFactor = downsampleStrategy2.getScaleFactor(i17, i16, i25, i26);
        if (scaleFactor > 0.0f) {
            DownsampleStrategy.SampleSizeRounding sampleSizeRounding = downsampleStrategy2.getSampleSizeRounding(i17, i16, i25, i26);
            if (sampleSizeRounding != null) {
                float f11 = (float) i17;
                float f12 = (float) i16;
                int round = i17 / round((double) (scaleFactor * f11));
                int round2 = i16 / round((double) (scaleFactor * f12));
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding2 = DownsampleStrategy.SampleSizeRounding.MEMORY;
                if (sampleSizeRounding == sampleSizeRounding2) {
                    i18 = Math.max(round, round2);
                } else {
                    i18 = Math.min(round, round2);
                }
                int i27 = Build.VERSION.SDK_INT;
                String str3 = Param.X;
                String str4 = TAG;
                if (i27 > 23 || !NO_DOWNSAMPLE_PRE_N_MIME_TYPES.contains(options2.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(i18));
                    if (sampleSizeRounding == sampleSizeRounding2 && ((float) max) < 1.0f / scaleFactor) {
                        max <<= 1;
                    }
                    i19 = max;
                } else {
                    i19 = 1;
                }
                options2.inSampleSize = i19;
                if (imageType2 == ImageHeaderParser.ImageType.JPEG) {
                    float min = (float) Math.min(i19, 8);
                    i21 = (int) Math.ceil((double) (f11 / min));
                    i22 = (int) Math.ceil((double) (f12 / min));
                    int i28 = i19 / 8;
                    if (i28 > 0) {
                        i21 /= i28;
                        i22 /= i28;
                    }
                } else {
                    if (imageType2 == ImageHeaderParser.ImageType.PNG || imageType2 == ImageHeaderParser.ImageType.PNG_A) {
                        float f13 = (float) i19;
                        i21 = (int) Math.floor((double) (f11 / f13));
                        d11 = Math.floor((double) (f12 / f13));
                    } else if (imageType2 == ImageHeaderParser.ImageType.WEBP || imageType2 == ImageHeaderParser.ImageType.WEBP_A) {
                        if (i27 >= 24) {
                            float f14 = (float) i19;
                            i21 = Math.round(f11 / f14);
                            i22 = Math.round(f12 / f14);
                        } else {
                            float f15 = (float) i19;
                            i21 = (int) Math.floor((double) (f11 / f15));
                            d11 = Math.floor((double) (f12 / f15));
                        }
                    } else if (i17 % i19 == 0 && i16 % i19 == 0) {
                        i21 = i17 / i19;
                        i22 = i16 / i19;
                    } else {
                        int[] dimensions = getDimensions(imageReader, options2, decodeCallbacks, bitmapPool2);
                        i21 = dimensions[0];
                        i22 = dimensions[1];
                    }
                    i22 = (int) d11;
                }
                double scaleFactor2 = (double) downsampleStrategy2.getScaleFactor(i21, i22, i25, i26);
                options2.inTargetDensity = adjustTargetDensityForError(scaleFactor2);
                options2.inDensity = getDensityMultiplier(scaleFactor2);
                if (isScaling(options)) {
                    options2.inScaled = true;
                } else {
                    options2.inTargetDensity = 0;
                    options2.inDensity = 0;
                }
                if (Log.isLoggable(str4, 2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Calculate scaling, source: [");
                    sb3.append(i12);
                    String str5 = str3;
                    sb3.append(str5);
                    sb3.append(i13);
                    sb3.append("], degreesToRotate: ");
                    sb3.append(i11);
                    sb3.append(", target: [");
                    sb3.append(i25);
                    sb3.append(str5);
                    sb3.append(i26);
                    sb3.append("], power of two scaled: [");
                    sb3.append(i21);
                    sb3.append(str5);
                    sb3.append(i22);
                    sb3.append("], exact scale factor: ");
                    sb3.append(scaleFactor);
                    sb3.append(", power of 2 sample size: ");
                    sb3.append(i19);
                    sb3.append(", adjusted scale factor: ");
                    sb3.append(scaleFactor2);
                    sb3.append(", target density: ");
                    sb3.append(options2.inTargetDensity);
                    sb3.append(", density: ");
                    sb3.append(options2.inDensity);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        int i29 = i24;
        String str6 = Param.X;
        int i31 = i23;
        throw new IllegalArgumentException("Cannot scale with factor: " + scaleFactor + " from: " + downsampleStrategy2 + ", source: [" + i31 + str6 + i29 + "], target: [" + i25 + str6 + i26 + "]");
    }

    private Bitmap decodeFromWrappedStreams(ImageReader imageReader, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z11, int i11, int i12, boolean z12, DecodeCallbacks decodeCallbacks) throws IOException {
        boolean z13;
        int i13;
        int i14;
        int i15;
        String str;
        int i16;
        ColorSpace.Named named;
        int i17;
        int i18;
        float f11;
        BitmapFactory.Options options2 = options;
        DecodeCallbacks decodeCallbacks2 = decodeCallbacks;
        long logTime = LogTime.getLogTime();
        int[] dimensions = getDimensions(imageReader, options2, decodeCallbacks2, this.bitmapPool);
        boolean z14 = false;
        int i19 = dimensions[0];
        int i21 = dimensions[1];
        String str2 = options2.outMimeType;
        if (i19 == -1 || i21 == -1) {
            z13 = false;
        } else {
            z13 = z11;
        }
        int imageOrientation = imageReader.getImageOrientation();
        int exifOrientationDegrees = TransformationUtils.getExifOrientationDegrees(imageOrientation);
        boolean isExifOrientationRequired = TransformationUtils.isExifOrientationRequired(imageOrientation);
        int i22 = i11;
        if (i22 == Integer.MIN_VALUE) {
            i14 = i12;
            if (isRotationRequired(exifOrientationDegrees)) {
                i13 = i21;
            } else {
                i13 = i19;
            }
        } else {
            i14 = i12;
            i13 = i22;
        }
        if (i14 != Integer.MIN_VALUE) {
            i15 = i14;
        } else if (isRotationRequired(exifOrientationDegrees)) {
            i15 = i19;
        } else {
            i15 = i21;
        }
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        ImageHeaderParser.ImageType imageType2 = imageType;
        calculateScaling(imageType, imageReader, decodeCallbacks, this.bitmapPool, downsampleStrategy, exifOrientationDegrees, i19, i21, i13, i15, options);
        int i23 = imageOrientation;
        String str3 = str2;
        int i24 = i21;
        int i25 = i19;
        DecodeCallbacks decodeCallbacks3 = decodeCallbacks2;
        BitmapFactory.Options options3 = options2;
        calculateConfig(imageReader, decodeFormat, z13, isExifOrientationRequired, options, i13, i15);
        int i26 = Build.VERSION.SDK_INT;
        int i27 = options3.inSampleSize;
        if (shouldUsePool(imageType2)) {
            if (i25 < 0 || i24 < 0 || !z12) {
                if (isScaling(options)) {
                    f11 = ((float) options3.inTargetDensity) / ((float) options3.inDensity);
                } else {
                    f11 = 1.0f;
                }
                int i28 = options3.inSampleSize;
                float f12 = (float) i28;
                String str4 = TAG;
                i18 = Math.round(((float) ((int) Math.ceil((double) (((float) i25) / f12)))) * f11);
                i17 = Math.round(((float) ((int) Math.ceil((double) (((float) i24) / f12)))) * f11);
                str = str4;
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculated target [");
                    sb2.append(i18);
                    sb2.append(Param.X);
                    sb2.append(i17);
                    sb2.append("] for source [");
                    sb2.append(i25);
                    sb2.append(Param.X);
                    sb2.append(i24);
                    sb2.append("], sampleSize: ");
                    sb2.append(i28);
                    sb2.append(", targetDensity: ");
                    sb2.append(options3.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options3.inDensity);
                    sb2.append(", density multiplier: ");
                    sb2.append(f11);
                }
            } else {
                str = TAG;
                i18 = i13;
                i17 = i15;
            }
            if (i18 > 0 && i17 > 0) {
                setInBitmap(options3, this.bitmapPool, i18, i17);
            }
        } else {
            str = TAG;
        }
        if (i26 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && options.outColorSpace != null && options.outColorSpace.isWideGamut()) {
                z14 = true;
            }
            if (z14) {
                named = ColorSpace.Named.DISPLAY_P3;
            } else {
                named = ColorSpace.Named.SRGB;
            }
            options3.inPreferredColorSpace = ColorSpace.get(named);
        } else if (i26 >= 26) {
            options3.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap decodeStream = decodeStream(imageReader, options3, decodeCallbacks3, this.bitmapPool);
        decodeCallbacks3.onDecodeComplete(this.bitmapPool, decodeStream);
        if (Log.isLoggable(str, 2)) {
            i16 = i23;
            logDecode(i25, i24, str3, options, decodeStream, i11, i12, logTime);
        } else {
            i16 = i23;
        }
        if (decodeStream == null) {
            return null;
        }
        decodeStream.setDensity(this.displayMetrics.densityDpi);
        Bitmap rotateImageExif = TransformationUtils.rotateImageExif(this.bitmapPool, decodeStream, i16);
        if (decodeStream.equals(rotateImageExif)) {
            return rotateImageExif;
        }
        this.bitmapPool.put(decodeStream);
        return rotateImageExif;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader r4, android.graphics.BitmapFactory.Options r5, com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeCallbacks r6, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto L_0x000a
            r6.onObtainBounds()
            r4.stopGrowingBuffers()
        L_0x000a:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r3.lock()
            android.graphics.Bitmap r4 = r4.decodeBitmap(r5)     // Catch:{ IllegalArgumentException -> 0x0025 }
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r5.unlock()
            return r4
        L_0x0023:
            r4 = move-exception
            goto L_0x0049
        L_0x0025:
            r3 = move-exception
            java.io.IOException r0 = newIoExceptionForInBitmapAssertion(r3, r0, r1, r2, r5)     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch:{ all -> 0x0023 }
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0048
            r7.put(r1)     // Catch:{ IOException -> 0x0047 }
            r1 = 0
            r5.inBitmap = r1     // Catch:{ IOException -> 0x0047 }
            android.graphics.Bitmap r4 = decodeStream(r4, r5, r6, r7)     // Catch:{ IOException -> 0x0047 }
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r5.unlock()
            return r4
        L_0x0047:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0048:
            throw r0     // Catch:{ all -> 0x0023 }
        L_0x0049:
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getBitmapDrawableLock()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(com.bumptech.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Downsampler$DecodeCallbacks, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):android.graphics.Bitmap");
    }

    @TargetApi(19)
    @Nullable
    private static String getBitmapString(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + Param.X + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options getDefaultOptions() {
        BitmapFactory.Options poll;
        synchronized (Downsampler.class) {
            Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                resetOptions(poll);
            }
        }
        return poll;
    }

    private static int getDensityMultiplier(double d11) {
        if (d11 > 1.0d) {
            d11 = 1.0d / d11;
        }
        return (int) Math.round(d11 * 2.147483647E9d);
    }

    private static int[] getDimensions(ImageReader imageReader, BitmapFactory.Options options, DecodeCallbacks decodeCallbacks, BitmapPool bitmapPool2) throws IOException {
        options.inJustDecodeBounds = true;
        decodeStream(imageReader, options, decodeCallbacks, bitmapPool2);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String getInBitmapString(BitmapFactory.Options options) {
        return getBitmapString(options.inBitmap);
    }

    private static boolean isRotationRequired(int i11) {
        return i11 == 90 || i11 == 270;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r1.inDensity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isScaling(android.graphics.BitmapFactory.Options r1) {
        /*
            int r0 = r1.inTargetDensity
            if (r0 <= 0) goto L_0x000c
            int r1 = r1.inDensity
            if (r1 <= 0) goto L_0x000c
            if (r0 == r1) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.isScaling(android.graphics.BitmapFactory$Options):boolean");
    }

    private static void logDecode(int i11, int i12, String str, BitmapFactory.Options options, Bitmap bitmap, int i13, int i14, long j11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Decoded ");
        sb2.append(getBitmapString(bitmap));
        sb2.append(" from [");
        sb2.append(i11);
        sb2.append(Param.X);
        sb2.append(i12);
        sb2.append("] ");
        sb2.append(str);
        sb2.append(" with inBitmap ");
        sb2.append(getInBitmapString(options));
        sb2.append(" for [");
        sb2.append(i13);
        sb2.append(Param.X);
        sb2.append(i14);
        sb2.append("], sample size: ");
        sb2.append(options.inSampleSize);
        sb2.append(", density: ");
        sb2.append(options.inDensity);
        sb2.append(", target density: ");
        sb2.append(options.inTargetDensity);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        sb2.append(", duration: ");
        sb2.append(LogTime.getElapsedMillis(j11));
    }

    private static IOException newIoExceptionForInBitmapAssertion(IllegalArgumentException illegalArgumentException, int i11, int i12, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i11 + ", outHeight: " + i12 + ", outMimeType: " + str + ", inBitmap: " + getInBitmapString(options), illegalArgumentException);
    }

    private static void releaseOptions(BitmapFactory.Options options) {
        resetOptions(options);
        Queue<BitmapFactory.Options> queue = OPTIONS_QUEUE;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void resetOptions(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int round(double d11) {
        return (int) (d11 + 0.5d);
    }

    @TargetApi(26)
    private static void setInBitmap(BitmapFactory.Options options, BitmapPool bitmapPool2, int i11, int i12) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bitmapPool2.getDirty(i11, i12, config);
    }

    private boolean shouldUsePool(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i11, int i12, Options options) throws IOException {
        return decode(inputStream, i11, i12, options, EMPTY_CALLBACKS);
    }

    public boolean handles(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    public boolean handles(InputStream inputStream) {
        return true;
    }

    public boolean handles(ByteBuffer byteBuffer) {
        return true;
    }

    public Resource<Bitmap> decode(InputStream inputStream, int i11, int i12, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        return decode((ImageReader) new ImageReader.InputStreamImageReader(inputStream, this.parsers, this.byteArrayPool), i11, i12, options, decodeCallbacks);
    }

    @RequiresApi(21)
    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i11, int i12, Options options) throws IOException {
        return decode((ImageReader) new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.parsers, this.byteArrayPool), i11, i12, options, EMPTY_CALLBACKS);
    }

    private Resource<Bitmap> decode(ImageReader imageReader, int i11, int i12, Options options, DecodeCallbacks decodeCallbacks) throws IOException {
        Options options2 = options;
        byte[] bArr = (byte[]) this.byteArrayPool.get(65536, byte[].class);
        BitmapFactory.Options defaultOptions = getDefaultOptions();
        defaultOptions.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) options2.get(DECODE_FORMAT);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options2.get(PREFERRED_COLOR_SPACE);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options2.get(DownsampleStrategy.OPTION);
        boolean booleanValue = ((Boolean) options2.get(FIX_BITMAP_SIZE_TO_REQUESTED_DIMENSIONS)).booleanValue();
        Option option = ALLOW_HARDWARE_CONFIG;
        try {
            return BitmapResource.obtain(decodeFromWrappedStreams(imageReader, defaultOptions, downsampleStrategy, decodeFormat, preferredColorSpace, options2.get(option) != null && ((Boolean) options2.get(option)).booleanValue(), i11, i12, booleanValue, decodeCallbacks), this.bitmapPool);
        } finally {
            releaseOptions(defaultOptions);
            this.byteArrayPool.put(bArr);
        }
    }
}
