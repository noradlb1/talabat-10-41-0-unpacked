package coil.decode;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcoil/decode/GifDecoder;", "Lcoil/decode/Decoder;", "enforceMinimumFrameDelay", "", "(Z)V", "decode", "Lcoil/decode/DecodeResult;", "pool", "Lcoil/bitmap/BitmapPool;", "source", "Lokio/BufferedSource;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Lokio/BufferedSource;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "mimeType", "", "Companion", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GifDecoder implements Decoder {
    @NotNull
    public static final String ANIMATED_TRANSFORMATION_KEY = "coil#animated_transformation";
    @NotNull
    public static final String ANIMATION_END_CALLBACK_KEY = "coil#animation_end_callback";
    @NotNull
    public static final String ANIMATION_START_CALLBACK_KEY = "coil#animation_start_callback";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String REPEAT_COUNT_KEY = "coil#repeat_count";
    /* access modifiers changed from: private */
    public final boolean enforceMinimumFrameDelay;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/decode/GifDecoder$Companion;", "", "()V", "ANIMATED_TRANSFORMATION_KEY", "", "ANIMATION_END_CALLBACK_KEY", "ANIMATION_START_CALLBACK_KEY", "REPEAT_COUNT_KEY", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public GifDecoder() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public GifDecoder(boolean z11) {
        this.enforceMinimumFrameDelay = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d9, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00dd, code lost:
        throw r8;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(@org.jetbrains.annotations.NotNull coil.bitmap.BitmapPool r6, @org.jetbrains.annotations.NotNull okio.BufferedSource r7, @org.jetbrains.annotations.NotNull coil.size.Size r8, @org.jetbrains.annotations.NotNull coil.decode.Options r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil.decode.DecodeResult> r10) {
        /*
            r5 = this;
            kotlinx.coroutines.CancellableContinuationImpl r8 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r10)
            r1 = 1
            r8.<init>(r0, r1)
            r8.initCancellability()
            coil.decode.InterruptibleSource r0 = new coil.decode.InterruptibleSource     // Catch:{ Exception -> 0x00e3 }
            okio.Source r7 = (okio.Source) r7     // Catch:{ Exception -> 0x00e3 }
            r0.<init>(r8, r7)     // Catch:{ Exception -> 0x00e3 }
            boolean r7 = r5.enforceMinimumFrameDelay     // Catch:{ all -> 0x00de }
            if (r7 == 0) goto L_0x0024
            coil.decode.FrameDelayRewritingSource r7 = new coil.decode.FrameDelayRewritingSource     // Catch:{ all -> 0x00de }
            r7.<init>(r0)     // Catch:{ all -> 0x00de }
            okio.BufferedSource r7 = okio.Okio.buffer((okio.Source) r7)     // Catch:{ all -> 0x00de }
            goto L_0x0028
        L_0x0024:
            okio.BufferedSource r7 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x00de }
        L_0x0028:
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x00de }
            r2 = r7
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ all -> 0x00d7 }
            java.io.InputStream r2 = r2.inputStream()     // Catch:{ all -> 0x00d7 }
            android.graphics.Movie r2 = android.graphics.Movie.decodeStream(r2)     // Catch:{ all -> 0x00d7 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r7, r3)     // Catch:{ all -> 0x00de }
            r7 = 0
            if (r2 == 0) goto L_0x0049
            int r3 = r2.width()     // Catch:{ all -> 0x00de }
            if (r3 <= 0) goto L_0x0049
            int r3 = r2.height()     // Catch:{ all -> 0x00de }
            if (r3 <= 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r1 = r7
        L_0x004a:
            if (r1 == 0) goto L_0x00cb
            coil.drawable.MovieDrawable r1 = new coil.drawable.MovieDrawable     // Catch:{ all -> 0x00de }
            boolean r3 = r2.isOpaque()     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x005d
            boolean r3 = r9.getAllowRgb565()     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x005d
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ all -> 0x00de }
            goto L_0x006e
        L_0x005d:
            android.graphics.Bitmap$Config r3 = r9.getConfig()     // Catch:{ all -> 0x00de }
            boolean r3 = coil.util.GifExtensions.isHardware(r3)     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x006a
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x00de }
            goto L_0x006e
        L_0x006a:
            android.graphics.Bitmap$Config r3 = r9.getConfig()     // Catch:{ all -> 0x00de }
        L_0x006e:
            coil.size.Scale r4 = r9.getScale()     // Catch:{ all -> 0x00de }
            r1.<init>(r2, r6, r3, r4)     // Catch:{ all -> 0x00de }
            coil.request.Parameters r6 = r9.getParameters()     // Catch:{ all -> 0x00de }
            java.lang.Integer r6 = coil.request.Gifs.repeatCount(r6)     // Catch:{ all -> 0x00de }
            if (r6 != 0) goto L_0x0081
            r6 = -1
            goto L_0x0085
        L_0x0081:
            int r6 = r6.intValue()     // Catch:{ all -> 0x00de }
        L_0x0085:
            r1.setRepeatCount(r6)     // Catch:{ all -> 0x00de }
            coil.request.Parameters r6 = r9.getParameters()     // Catch:{ all -> 0x00de }
            kotlin.jvm.functions.Function0 r6 = coil.request.Gifs.animationStartCallback(r6)     // Catch:{ all -> 0x00de }
            coil.request.Parameters r2 = r9.getParameters()     // Catch:{ all -> 0x00de }
            kotlin.jvm.functions.Function0 r2 = coil.request.Gifs.animationEndCallback(r2)     // Catch:{ all -> 0x00de }
            if (r6 != 0) goto L_0x009c
            if (r2 == 0) goto L_0x00a3
        L_0x009c:
            androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback r6 = coil.util.GifExtensions.animatable2CompatCallbackOf(r6, r2)     // Catch:{ all -> 0x00de }
            r1.registerAnimationCallback(r6)     // Catch:{ all -> 0x00de }
        L_0x00a3:
            coil.request.Parameters r6 = r9.getParameters()     // Catch:{ all -> 0x00de }
            coil.transform.AnimatedTransformation r6 = coil.request.Gifs.animatedTransformation(r6)     // Catch:{ all -> 0x00de }
            r1.setAnimatedTransformation(r6)     // Catch:{ all -> 0x00de }
            coil.decode.DecodeResult r6 = new coil.decode.DecodeResult     // Catch:{ all -> 0x00de }
            r6.<init>(r1, r7)     // Catch:{ all -> 0x00de }
            java.lang.Object r6 = kotlin.Result.m6329constructorimpl(r6)     // Catch:{ all -> 0x00de }
            r8.resumeWith(r6)     // Catch:{ all -> 0x00de }
            r0.clearInterrupt()     // Catch:{ Exception -> 0x00e3 }
            java.lang.Object r6 = r8.getResult()
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r6 != r7) goto L_0x00ca
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r10)
        L_0x00ca:
            return r6
        L_0x00cb:
            java.lang.String r6 = "Failed to decode GIF."
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00de }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00de }
            r7.<init>(r6)     // Catch:{ all -> 0x00de }
            throw r7     // Catch:{ all -> 0x00de }
        L_0x00d7:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x00d9 }
        L_0x00d9:
            r8 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r6)     // Catch:{ all -> 0x00de }
            throw r8     // Catch:{ all -> 0x00de }
        L_0x00de:
            r6 = move-exception
            r0.clearInterrupt()     // Catch:{ Exception -> 0x00e3 }
            throw r6     // Catch:{ Exception -> 0x00e3 }
        L_0x00e3:
            r6 = move-exception
            boolean r7 = r6 instanceof java.lang.InterruptedException
            if (r7 != 0) goto L_0x00ee
            boolean r7 = r6 instanceof java.io.InterruptedIOException
            if (r7 == 0) goto L_0x00ed
            goto L_0x00ee
        L_0x00ed:
            throw r6
        L_0x00ee:
            java.util.concurrent.CancellationException r7 = new java.util.concurrent.CancellationException
            java.lang.String r8 = "Blocking call was interrupted due to parent cancellation."
            r7.<init>(r8)
            java.lang.Throwable r6 = r7.initCause(r6)
            java.lang.String r7 = "CancellationException(\"B…n.\").initCause(exception)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.GifDecoder.decode(coil.bitmap.BitmapPool, okio.BufferedSource, coil.size.Size, coil.decode.Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean handles(@NotNull BufferedSource bufferedSource, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        return DecodeUtils.isGif(bufferedSource);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GifDecoder(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11);
    }
}
