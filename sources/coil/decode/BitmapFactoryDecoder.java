package coil.decode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.os.Build;
import coil.bitmap.BitmapPool;
import coil.size.Size;
import coil.util.Bitmaps;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import net.bytebuddy.implementation.MethodDelegation;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 #2\u00020\u0001:\u0003#$%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J1\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J$\u0010!\u001a\u00020\r*\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/Decoder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "paint", "Landroid/graphics/Paint;", "applyExifTransformations", "Landroid/graphics/Bitmap;", "pool", "Lcoil/bitmap/BitmapPool;", "inBitmap", "config", "Landroid/graphics/Bitmap$Config;", "isFlipped", "", "rotationDegrees", "", "decode", "Lcoil/decode/DecodeResult;", "source", "Lokio/BufferedSource;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Lokio/BufferedSource;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeInterruptible", "Lokio/Source;", "handles", "mimeType", "", "shouldReadExifData", "computeConfig", "Landroid/graphics/BitmapFactory$Options;", "Companion", "ExceptionCatchingSource", "ExifInterfaceInputStream", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BitmapFactoryDecoder implements Decoder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int GIGABYTE_IN_BYTES = 1073741824;
    @NotNull
    private static final String MIME_TYPE_HEIC = "image/heic";
    @NotNull
    private static final String MIME_TYPE_HEIF = "image/heif";
    @NotNull
    private static final String MIME_TYPE_JPEG = "image/jpeg";
    @NotNull
    private static final String MIME_TYPE_WEBP = "image/webp";
    @NotNull
    private static final String[] SUPPORTED_EXIF_MIME_TYPES = {"image/jpeg", MIME_TYPE_WEBP, MIME_TYPE_HEIC, MIME_TYPE_HEIF};
    @NotNull
    private final Context context;
    @NotNull
    private final Paint paint = new Paint(3);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Companion;", "", "()V", "GIGABYTE_IN_BYTES", "", "MIME_TYPE_HEIC", "", "MIME_TYPE_HEIF", "MIME_TYPE_JPEG", "MIME_TYPE_WEBP", "SUPPORTED_EXIF_MIME_TYPES", "", "[Ljava/lang/String;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R.\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ExceptionCatchingSource extends ForwardingSource {
        @Nullable
        private Exception exception;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ExceptionCatchingSource(@NotNull Source source) {
            super(source);
            Intrinsics.checkNotNullParameter(source, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        }

        @Nullable
        public final Exception getException() {
            return this.exception;
        }

        public long read(@NotNull Buffer buffer, long j11) {
            Intrinsics.checkNotNullParameter(buffer, "sink");
            try {
                return super.read(buffer, j11);
            } catch (Exception e11) {
                this.exception = e11;
                throw e11;
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExifInterfaceInputStream;", "Ljava/io/InputStream;", "delegate", "(Ljava/io/InputStream;)V", "availableBytes", "", "available", "close", "", "interceptBytesRead", "bytesRead", "read", "b", "", "off", "len", "skip", "", "n", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ExifInterfaceInputStream extends InputStream {
        private volatile int availableBytes = 1073741824;
        @NotNull
        private final InputStream delegate;

        public ExifInterfaceInputStream(@NotNull InputStream inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
            this.delegate = inputStream;
        }

        private final int interceptBytesRead(int i11) {
            if (i11 == -1) {
                this.availableBytes = 0;
            }
            return i11;
        }

        public int available() {
            return this.availableBytes;
        }

        public void close() {
            this.delegate.close();
        }

        public int read() {
            return interceptBytesRead(this.delegate.read());
        }

        public long skip(long j11) {
            return this.delegate.skip(j11);
        }

        public int read(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "b");
            return interceptBytesRead(this.delegate.read(bArr));
        }

        public int read(@NotNull byte[] bArr, int i11, int i12) {
            Intrinsics.checkNotNullParameter(bArr, "b");
            return interceptBytesRead(this.delegate.read(bArr, i11, i12));
        }
    }

    public BitmapFactoryDecoder(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r0 == false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.graphics.Bitmap applyExifTransformations(coil.bitmap.BitmapPool r8, android.graphics.Bitmap r9, android.graphics.Bitmap.Config r10, boolean r11, int r12) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            if (r12 <= 0) goto L_0x0006
            r2 = r0
            goto L_0x0007
        L_0x0006:
            r2 = r1
        L_0x0007:
            if (r11 != 0) goto L_0x000c
            if (r2 != 0) goto L_0x000c
            return r9
        L_0x000c:
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            int r4 = r9.getWidth()
            float r4 = (float) r4
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r5
            int r6 = r9.getHeight()
            float r6 = (float) r6
            float r6 = r6 / r5
            if (r11 == 0) goto L_0x0028
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            r3.postScale(r11, r5, r4, r6)
        L_0x0028:
            if (r2 == 0) goto L_0x002e
            float r11 = (float) r12
            r3.postRotate(r11, r4, r6)
        L_0x002e:
            android.graphics.RectF r11 = new android.graphics.RectF
            int r2 = r9.getWidth()
            float r2 = (float) r2
            int r4 = r9.getHeight()
            float r4 = (float) r4
            r5 = 0
            r11.<init>(r5, r5, r2, r4)
            r3.mapRect(r11)
            float r2 = r11.left
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0049
            r4 = r0
            goto L_0x004a
        L_0x0049:
            r4 = r1
        L_0x004a:
            if (r4 == 0) goto L_0x0056
            float r4 = r11.top
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = r1
        L_0x0054:
            if (r0 != 0) goto L_0x005d
        L_0x0056:
            float r0 = -r2
            float r11 = r11.top
            float r11 = -r11
            r3.postTranslate(r0, r11)
        L_0x005d:
            r11 = 90
            if (r12 == r11) goto L_0x0072
            r11 = 270(0x10e, float:3.78E-43)
            if (r12 == r11) goto L_0x0072
            int r11 = r9.getWidth()
            int r12 = r9.getHeight()
            android.graphics.Bitmap r10 = r8.get(r11, r12, r10)
            goto L_0x007e
        L_0x0072:
            int r11 = r9.getHeight()
            int r12 = r9.getWidth()
            android.graphics.Bitmap r10 = r8.get(r11, r12, r10)
        L_0x007e:
            android.graphics.Canvas r11 = new android.graphics.Canvas
            r11.<init>(r10)
            android.graphics.Paint r12 = r7.paint
            r11.drawBitmap(r9, r3, r12)
            r8.put(r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.applyExifTransformations(coil.bitmap.BitmapPool, android.graphics.Bitmap, android.graphics.Bitmap$Config, boolean, int):android.graphics.Bitmap");
    }

    private final Bitmap.Config computeConfig(BitmapFactory.Options options, Options options2, boolean z11, int i11) {
        Bitmap.Config config = options2.getConfig();
        if (z11 || i11 > 0) {
            config = Bitmaps.toSoftware(config);
        }
        if (options2.getAllowRgb565() && config == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual((Object) options.outMimeType, (Object) "image/jpeg")) {
            config = Bitmap.Config.RGB_565;
        }
        if (Build.VERSION.SDK_INT < 26 || options.outConfig != Bitmap.Config.RGBA_F16 || config == Bitmap.Config.HARDWARE) {
            return config;
        }
        return Bitmap.Config.RGBA_F16;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01f7, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01fb, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01fc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0204, code lost:
        r2.put(r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:75:0x0192, B:98:0x01f5] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01ed A[SYNTHETIC, Splitter:B:91:0x01ed] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil.decode.DecodeResult decodeInterruptible(coil.bitmap.BitmapPool r26, okio.Source r27, coil.size.Size r28, coil.decode.Options r29) {
        /*
            r25 = this;
            r7 = r25
            r2 = r26
            r0 = r28
            android.graphics.BitmapFactory$Options r8 = new android.graphics.BitmapFactory$Options
            r8.<init>()
            coil.decode.BitmapFactoryDecoder$ExceptionCatchingSource r1 = new coil.decode.BitmapFactoryDecoder$ExceptionCatchingSource
            r3 = r27
            r1.<init>(r3)
            okio.BufferedSource r3 = okio.Okio.buffer((okio.Source) r1)
            r9 = 1
            r8.inJustDecodeBounds = r9
            okio.BufferedSource r4 = r3.peek()
            java.io.InputStream r4 = r4.inputStream()
            r5 = 0
            com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeStream(r4, r5, r8)
            java.lang.Exception r4 = r1.getException()
            if (r4 != 0) goto L_0x0210
            r10 = 0
            r8.inJustDecodeBounds = r10
            java.lang.String r4 = r8.outMimeType
            boolean r4 = r7.shouldReadExifData(r4)
            if (r4 == 0) goto L_0x0059
            androidx.exifinterface.media.ExifInterface r4 = new androidx.exifinterface.media.ExifInterface
            coil.decode.BitmapFactoryDecoder$ExifInterfaceInputStream r6 = new coil.decode.BitmapFactoryDecoder$ExifInterfaceInputStream
            okio.BufferedSource r11 = r3.peek()
            java.io.InputStream r11 = r11.inputStream()
            r6.<init>(r11)
            r4.<init>((java.io.InputStream) r6)
            java.lang.Exception r6 = r1.getException()
            if (r6 != 0) goto L_0x0058
            boolean r6 = r4.isFlipped()
            int r4 = r4.getRotationDegrees()
            r11 = r4
            goto L_0x005b
        L_0x0058:
            throw r6
        L_0x0059:
            r6 = r10
            r11 = r6
        L_0x005b:
            r4 = 90
            if (r11 == r4) goto L_0x0066
            r4 = 270(0x10e, float:3.78E-43)
            if (r11 != r4) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r4 = r10
            goto L_0x0067
        L_0x0066:
            r4 = r9
        L_0x0067:
            if (r4 == 0) goto L_0x006c
            int r12 = r8.outHeight
            goto L_0x006e
        L_0x006c:
            int r12 = r8.outWidth
        L_0x006e:
            if (r4 == 0) goto L_0x0073
            int r4 = r8.outWidth
            goto L_0x0075
        L_0x0073:
            int r4 = r8.outHeight
        L_0x0075:
            r13 = r29
            android.graphics.Bitmap$Config r14 = r7.computeConfig(r8, r13, r6, r11)
            r8.inPreferredConfig = r14
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 26
            if (r14 < r15) goto L_0x0090
            android.graphics.ColorSpace r15 = r29.getColorSpace()
            if (r15 == 0) goto L_0x0090
            android.graphics.ColorSpace r15 = r29.getColorSpace()
            r8.inPreferredColorSpace = r15
        L_0x0090:
            boolean r15 = r29.getPremultipliedAlpha()
            r8.inPremultiplied = r15
            r15 = 24
            if (r14 >= r15) goto L_0x009c
            r14 = r9
            goto L_0x009d
        L_0x009c:
            r14 = r10
        L_0x009d:
            r8.inMutable = r14
            r8.inScaled = r10
            int r15 = r8.outWidth
            java.lang.String r5 = "inPreferredConfig"
            if (r15 <= 0) goto L_0x0177
            int r10 = r8.outHeight
            if (r10 > 0) goto L_0x00b0
            r0 = r9
            r15 = r11
            r9 = r5
            goto L_0x017a
        L_0x00b0:
            boolean r13 = r0 instanceof coil.size.PixelSize
            if (r13 != 0) goto L_0x00cb
            r8.inSampleSize = r9
            r0 = 0
            r8.inScaled = r0
            if (r14 == 0) goto L_0x00c6
            android.graphics.Bitmap$Config r0 = r8.inPreferredConfig
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            android.graphics.Bitmap r0 = r2.getDirty(r15, r10, r0)
            r8.inBitmap = r0
        L_0x00c6:
            r9 = r5
            r15 = r11
        L_0x00c8:
            r0 = 0
            goto L_0x0182
        L_0x00cb:
            coil.size.PixelSize r0 = (coil.size.PixelSize) r0
            int r10 = r0.component1()
            int r0 = r0.component2()
            coil.size.Scale r13 = r29.getScale()
            int r13 = coil.decode.DecodeUtils.calculateInSampleSize(r12, r4, r10, r0, r13)
            r8.inSampleSize = r13
            double r14 = (double) r12
            r28 = r10
            double r9 = (double) r13
            double r16 = r14 / r9
            double r9 = (double) r4
            double r13 = (double) r13
            double r18 = r9 / r13
            r4 = r28
            double r9 = (double) r4
            double r13 = (double) r0
            coil.size.Scale r24 = r29.getScale()
            r20 = r9
            r22 = r13
            double r9 = coil.decode.DecodeUtils.computeSizeMultiplier((double) r16, (double) r18, (double) r20, (double) r22, (coil.size.Scale) r24)
            boolean r0 = r29.getAllowInexactSize()
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 == 0) goto L_0x0105
            double r9 = kotlin.ranges.RangesKt___RangesKt.coerceAtMost((double) r9, (double) r13)
        L_0x0105:
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x010b
            r0 = 1
            goto L_0x010c
        L_0x010b:
            r0 = 0
        L_0x010c:
            r4 = 1
            r0 = r0 ^ r4
            r8.inScaled = r0
            if (r0 == 0) goto L_0x012e
            int r0 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r0 <= 0) goto L_0x0124
            double r13 = (double) r4
            double r13 = r13 / r9
            int r0 = kotlin.math.MathKt__MathJVMKt.roundToInt((double) r13)
            r8.inDensity = r0
            r8.inTargetDensity = r4
            goto L_0x012e
        L_0x0124:
            r8.inDensity = r4
            double r13 = (double) r4
            double r13 = r13 * r9
            int r0 = kotlin.math.MathKt__MathJVMKt.roundToInt((double) r13)
            r8.inTargetDensity = r0
        L_0x012e:
            boolean r0 = r8.inMutable
            if (r0 == 0) goto L_0x00c6
            int r0 = r8.inSampleSize
            r4 = 1
            if (r0 != r4) goto L_0x014b
            boolean r4 = r8.inScaled
            if (r4 != 0) goto L_0x014b
            int r0 = r8.outWidth
            int r4 = r8.outHeight
            android.graphics.Bitmap$Config r9 = r8.inPreferredConfig
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            android.graphics.Bitmap r0 = r2.getDirty(r0, r4, r9)
            r9 = r5
            r15 = r11
            goto L_0x0173
        L_0x014b:
            int r4 = r8.outWidth
            double r13 = (double) r4
            r15 = r11
            double r11 = (double) r0
            double r13 = r13 / r11
            int r11 = r8.outHeight
            double r11 = (double) r11
            r16 = r5
            double r4 = (double) r0
            double r11 = r11 / r4
            double r13 = r13 * r9
            r4 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r13 = r13 + r4
            double r13 = java.lang.Math.ceil(r13)
            int r0 = (int) r13
            double r9 = r9 * r11
            double r9 = r9 + r4
            double r4 = java.lang.Math.ceil(r9)
            int r4 = (int) r4
            android.graphics.Bitmap$Config r5 = r8.inPreferredConfig
            r9 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            android.graphics.Bitmap r0 = r2.getDirty(r0, r4, r5)
        L_0x0173:
            r8.inBitmap = r0
            goto L_0x00c8
        L_0x0177:
            r9 = r5
            r15 = r11
            r0 = 1
        L_0x017a:
            r8.inSampleSize = r0
            r0 = 0
            r8.inScaled = r0
            r4 = 0
            r8.inBitmap = r4
        L_0x0182:
            android.graphics.Bitmap r4 = r8.inBitmap
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x01fe }
            r5 = r3
            okio.BufferedSource r5 = (okio.BufferedSource) r5     // Catch:{ all -> 0x01f2 }
            java.io.InputStream r5 = r5.inputStream()     // Catch:{ all -> 0x01f2 }
            r10 = 0
            android.graphics.Bitmap r5 = com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation.decodeStream(r5, r10, r8)     // Catch:{ all -> 0x01f0 }
            kotlin.io.CloseableKt.closeFinally(r3, r10)     // Catch:{ all -> 0x01fc }
            java.lang.Exception r1 = r1.getException()     // Catch:{ all -> 0x01ee }
            if (r1 != 0) goto L_0x01ed
            if (r5 == 0) goto L_0x01e1
            android.content.Context r1 = r29.getContext()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.densityDpi
            r5.setDensity(r1)
            android.graphics.Bitmap$Config r4 = r8.inPreferredConfig
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            r1 = r25
            r2 = r26
            r3 = r5
            r5 = r6
            r6 = r15
            android.graphics.Bitmap r1 = r1.applyExifTransformations(r2, r3, r4, r5, r6)
            coil.decode.DecodeResult r2 = new coil.decode.DecodeResult
            android.content.Context r3 = r7.context
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r4 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.graphics.drawable.BitmapDrawable r4 = new android.graphics.drawable.BitmapDrawable
            r4.<init>(r3, r1)
            int r1 = r8.inSampleSize
            r3 = 1
            if (r1 > r3) goto L_0x01dc
            boolean r1 = r8.inScaled
            if (r1 == 0) goto L_0x01da
            goto L_0x01dc
        L_0x01da:
            r9 = r0
            goto L_0x01dd
        L_0x01dc:
            r9 = r3
        L_0x01dd:
            r2.<init>(r4, r9)
            return r2
        L_0x01e1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01ed:
            throw r1     // Catch:{ all -> 0x01ee }
        L_0x01ee:
            r0 = move-exception
            goto L_0x0201
        L_0x01f0:
            r0 = move-exception
            goto L_0x01f4
        L_0x01f2:
            r0 = move-exception
            r10 = 0
        L_0x01f4:
            r1 = r0
            throw r1     // Catch:{ all -> 0x01f6 }
        L_0x01f6:
            r0 = move-exception
            r5 = r0
            kotlin.io.CloseableKt.closeFinally(r3, r1)     // Catch:{ all -> 0x01fc }
            throw r5     // Catch:{ all -> 0x01fc }
        L_0x01fc:
            r0 = move-exception
            goto L_0x0200
        L_0x01fe:
            r0 = move-exception
            r10 = 0
        L_0x0200:
            r5 = r10
        L_0x0201:
            if (r4 != 0) goto L_0x0204
            goto L_0x0207
        L_0x0204:
            r2.put(r4)
        L_0x0207:
            if (r5 == r4) goto L_0x020f
            if (r5 != 0) goto L_0x020c
            goto L_0x020f
        L_0x020c:
            r2.put(r5)
        L_0x020f:
            throw r0
        L_0x0210:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.decodeInterruptible(coil.bitmap.BitmapPool, okio.Source, coil.size.Size, coil.decode.Options):coil.decode.DecodeResult");
    }

    private final boolean shouldReadExifData(String str) {
        return str != null && ArraysKt___ArraysKt.contains((T[]) SUPPORTED_EXIF_MIME_TYPES, str);
    }

    @Nullable
    public Object decode(@NotNull BitmapPool bitmapPool, @NotNull BufferedSource bufferedSource, @NotNull Size size, @NotNull Options options, @NotNull Continuation<? super DecodeResult> continuation) {
        InterruptibleSource interruptibleSource;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        try {
            interruptibleSource = new InterruptibleSource(cancellableContinuationImpl, bufferedSource);
            cancellableContinuationImpl.resumeWith(Result.m6329constructorimpl(decodeInterruptible(bitmapPool, interruptibleSource, size, options)));
            interruptibleSource.clearInterrupt();
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Exception e11) {
            if ((e11 instanceof InterruptedException) || (e11 instanceof InterruptedIOException)) {
                Throwable initCause = new CancellationException("Blocking call was interrupted due to parent cancellation.").initCause(e11);
                Intrinsics.checkNotNullExpressionValue(initCause, "CancellationException(\"B…n.\").initCause(exception)");
                throw initCause;
            }
            throw e11;
        } catch (Throwable th2) {
            interruptibleSource.clearInterrupt();
            throw th2;
        }
    }

    public boolean handles(@NotNull BufferedSource bufferedSource, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return true;
    }
}
