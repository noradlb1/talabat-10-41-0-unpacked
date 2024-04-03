package coil.decode;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(28)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0019\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ1\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcoil/decode/ImageDecoderDecoder;", "Lcoil/decode/Decoder;", "()V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "enforceMinimumFrameDelay", "", "(Landroid/content/Context;Z)V", "(ZLandroid/content/Context;)V", "decode", "Lcoil/decode/DecodeResult;", "pool", "Lcoil/bitmap/BitmapPool;", "source", "Lokio/BufferedSource;", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Lokio/BufferedSource;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "mimeType", "", "Companion", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageDecoderDecoder implements Decoder {
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
    @Nullable
    public final Context context;
    /* access modifiers changed from: private */
    public final boolean enforceMinimumFrameDelay;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/decode/ImageDecoderDecoder$Companion;", "", "()V", "ANIMATED_TRANSFORMATION_KEY", "", "ANIMATION_END_CALLBACK_KEY", "ANIMATION_START_CALLBACK_KEY", "REPEAT_COUNT_KEY", "coil-gif_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ImageDecoderDecoder(boolean z11, Context context2) {
        this.enforceMinimumFrameDelay = z11;
        this.context = context2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: coil.decode.Options} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01ac, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c1, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c5, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01a1, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01a5, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a8, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(@org.jetbrains.annotations.NotNull coil.bitmap.BitmapPool r11, @org.jetbrains.annotations.NotNull okio.BufferedSource r12, @org.jetbrains.annotations.NotNull coil.size.Size r13, @org.jetbrains.annotations.NotNull coil.decode.Options r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super coil.decode.DecodeResult> r15) {
        /*
            r10 = this;
            boolean r11 = r15 instanceof coil.decode.ImageDecoderDecoder$decode$1
            if (r11 == 0) goto L_0x0013
            r11 = r15
            coil.decode.ImageDecoderDecoder$decode$1 r11 = (coil.decode.ImageDecoderDecoder$decode$1) r11
            int r0 = r11.f39707o
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r11.f39707o = r0
            goto L_0x0018
        L_0x0013:
            coil.decode.ImageDecoderDecoder$decode$1 r11 = new coil.decode.ImageDecoderDecoder$decode$1
            r11.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r11.f39705m
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f39707o
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x005d
            if (r1 == r3) goto L_0x0042
            if (r1 != r2) goto L_0x003a
            java.lang.Object r12 = r11.f39702j
            android.graphics.drawable.Drawable r12 = (android.graphics.drawable.Drawable) r12
            java.lang.Object r13 = r11.f39701i
            kotlin.jvm.internal.Ref$BooleanRef r13 = (kotlin.jvm.internal.Ref.BooleanRef) r13
            java.lang.Object r11 = r11.f39700h
            coil.decode.Options r11 = (coil.decode.Options) r11
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x018c
        L_0x003a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0042:
            java.lang.Object r12 = r11.f39704l
            kotlin.jvm.internal.Ref$BooleanRef r12 = (kotlin.jvm.internal.Ref.BooleanRef) r12
            java.lang.Object r13 = r11.f39703k
            r14 = r13
            coil.decode.Options r14 = (coil.decode.Options) r14
            java.lang.Object r13 = r11.f39702j
            coil.size.Size r13 = (coil.size.Size) r13
            java.lang.Object r13 = r11.f39701i
            okio.BufferedSource r13 = (okio.BufferedSource) r13
            java.lang.Object r13 = r11.f39700h
            coil.decode.ImageDecoderDecoder r13 = (coil.decode.ImageDecoderDecoder) r13
            kotlin.ResultKt.throwOnFailure(r15)
            r13 = r12
            goto L_0x013a
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$BooleanRef r15 = new kotlin.jvm.internal.Ref$BooleanRef
            r15.<init>()
            r11.f39700h = r10
            r11.f39701i = r12
            r11.f39702j = r13
            r11.f39703k = r14
            r11.f39704l = r15
            r11.f39707o = r3
            kotlinx.coroutines.CancellableContinuationImpl r1 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r11)
            r1.<init>(r5, r3)
            r1.initCancellability()
            coil.decode.InterruptibleSource r5 = new coil.decode.InterruptibleSource     // Catch:{ Exception -> 0x01c2 }
            okio.Source r12 = (okio.Source) r12     // Catch:{ Exception -> 0x01c2 }
            r5.<init>(r1, r12)     // Catch:{ Exception -> 0x01c2 }
            kotlin.jvm.internal.Ref$ObjectRef r12 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x01bd }
            r12.<init>()     // Catch:{ all -> 0x01bd }
            okio.BufferedSource r6 = okio.Okio.buffer((okio.Source) r5)     // Catch:{ all -> 0x01ad }
            boolean r7 = r10.enforceMinimumFrameDelay     // Catch:{ all -> 0x01ad }
            if (r7 == 0) goto L_0x00a4
            boolean r7 = coil.decode.DecodeUtils.isGif(r6)     // Catch:{ all -> 0x01ad }
            if (r7 == 0) goto L_0x00a4
            coil.decode.FrameDelayRewritingSource r7 = new coil.decode.FrameDelayRewritingSource     // Catch:{ all -> 0x01ad }
            okio.Source r6 = (okio.Source) r6     // Catch:{ all -> 0x01ad }
            r7.<init>(r6)     // Catch:{ all -> 0x01ad }
            okio.BufferedSource r6 = okio.Okio.buffer((okio.Source) r7)     // Catch:{ all -> 0x01ad }
        L_0x00a4:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01ad }
            r8 = 30
            if (r7 < r8) goto L_0x00c6
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x01ad }
            r3 = r6
            okio.BufferedSource r3 = (okio.BufferedSource) r3     // Catch:{ all -> 0x00bf }
            byte[] r3 = r3.readByteArray()     // Catch:{ all -> 0x00bf }
            kotlin.io.CloseableKt.closeFinally(r6, r4)     // Catch:{ all -> 0x01ad }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3)     // Catch:{ all -> 0x01ad }
            android.graphics.ImageDecoder$Source r3 = android.graphics.ImageDecoder.createSource(r3)     // Catch:{ all -> 0x01ad }
            goto L_0x00fd
        L_0x00bf:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r11)     // Catch:{ all -> 0x01ad }
            throw r13     // Catch:{ all -> 0x01ad }
        L_0x00c6:
            java.lang.String r7 = "tmp"
            android.content.Context r8 = r10.context     // Catch:{ all -> 0x01ad }
            if (r8 != 0) goto L_0x00d0
        L_0x00ce:
            r8 = r4
            goto L_0x00dc
        L_0x00d0:
            java.io.File r8 = r8.getCacheDir()     // Catch:{ all -> 0x01ad }
            if (r8 != 0) goto L_0x00d7
            goto L_0x00ce
        L_0x00d7:
            r8.mkdirs()     // Catch:{ all -> 0x01ad }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01ad }
        L_0x00dc:
            java.io.File r7 = java.io.File.createTempFile(r7, r4, r8)     // Catch:{ all -> 0x01ad }
            r12.element = r7     // Catch:{ all -> 0x01ad }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x01ad }
            r8 = r6
            okio.BufferedSource r8 = (okio.BufferedSource) r8     // Catch:{ all -> 0x01a6 }
            r9 = 0
            okio.Sink r3 = okio.Okio__JvmOkioKt.sink$default(r7, r9, r3, r4)     // Catch:{ all -> 0x01a6 }
            r8.readAll(r3)     // Catch:{ all -> 0x019f }
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x01a6 }
            kotlin.io.CloseableKt.closeFinally(r6, r4)     // Catch:{ all -> 0x01ad }
            T r3 = r12.element     // Catch:{ all -> 0x01ad }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x01ad }
            android.graphics.ImageDecoder$Source r3 = android.graphics.ImageDecoder.createSource(r3)     // Catch:{ all -> 0x01ad }
        L_0x00fd:
            java.lang.String r6 = "if (SDK_INT >= 30) {\n   …mpFile)\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)     // Catch:{ all -> 0x01ad }
            coil.decode.ImageDecoderDecoder$decode$lambda-4$$inlined$decodeDrawable$1 r6 = new coil.decode.ImageDecoderDecoder$decode$lambda-4$$inlined$decodeDrawable$1     // Catch:{ all -> 0x01ad }
            r6.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x01ad }
            android.graphics.drawable.Drawable r13 = android.graphics.ImageDecoder.decodeDrawable(r3, r6)     // Catch:{ all -> 0x01ad }
            java.lang.String r3 = "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Drawable {\n    return ImageDecoder.decodeDrawable(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)     // Catch:{ all -> 0x01ad }
            T r12 = r12.element     // Catch:{ all -> 0x01bd }
            java.io.File r12 = (java.io.File) r12     // Catch:{ all -> 0x01bd }
            if (r12 != 0) goto L_0x0117
            goto L_0x011e
        L_0x0117:
            boolean r12 = r12.delete()     // Catch:{ all -> 0x01bd }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)     // Catch:{ all -> 0x01bd }
        L_0x011e:
            java.lang.Object r12 = kotlin.Result.m6329constructorimpl(r13)     // Catch:{ all -> 0x01bd }
            r1.resumeWith(r12)     // Catch:{ all -> 0x01bd }
            r5.clearInterrupt()     // Catch:{ Exception -> 0x01c2 }
            java.lang.Object r12 = r1.getResult()
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r12 != r13) goto L_0x0135
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r11)
        L_0x0135:
            if (r12 != r0) goto L_0x0138
            return r0
        L_0x0138:
            r13 = r15
            r15 = r12
        L_0x013a:
            r12 = r15
            android.graphics.drawable.Drawable r12 = (android.graphics.drawable.Drawable) r12
            boolean r15 = r12 instanceof android.graphics.drawable.AnimatedImageDrawable
            if (r15 == 0) goto L_0x0197
            r15 = r12
            android.graphics.drawable.AnimatedImageDrawable r15 = (android.graphics.drawable.AnimatedImageDrawable) r15
            coil.request.Parameters r1 = r14.getParameters()
            java.lang.Integer r1 = coil.request.Gifs.repeatCount(r1)
            if (r1 != 0) goto L_0x0150
            r1 = -1
            goto L_0x0154
        L_0x0150:
            int r1 = r1.intValue()
        L_0x0154:
            r15.setRepeatCount(r1)
            coil.request.Parameters r15 = r14.getParameters()
            kotlin.jvm.functions.Function0 r15 = coil.request.Gifs.animationStartCallback(r15)
            coil.request.Parameters r1 = r14.getParameters()
            kotlin.jvm.functions.Function0 r1 = coil.request.Gifs.animationEndCallback(r1)
            if (r15 != 0) goto L_0x016b
            if (r1 == 0) goto L_0x018d
        L_0x016b:
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r3 = r3.getImmediate()
            coil.decode.ImageDecoderDecoder$decode$drawable$1 r5 = new coil.decode.ImageDecoderDecoder$decode$drawable$1
            r5.<init>(r12, r15, r1, r4)
            r11.f39700h = r14
            r11.f39701i = r13
            r11.f39702j = r12
            r11.f39703k = r4
            r11.f39704l = r4
            r11.f39707o = r2
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r3, r5, r11)
            if (r11 != r0) goto L_0x018b
            return r0
        L_0x018b:
            r11 = r14
        L_0x018c:
            r14 = r11
        L_0x018d:
            coil.drawable.ScaleDrawable r11 = new coil.drawable.ScaleDrawable
            coil.size.Scale r14 = r14.getScale()
            r11.<init>(r12, r14)
            r12 = r11
        L_0x0197:
            coil.decode.DecodeResult r11 = new coil.decode.DecodeResult
            boolean r13 = r13.element
            r11.<init>(r12, r13)
            return r11
        L_0x019f:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x01a1 }
        L_0x01a1:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r11)     // Catch:{ all -> 0x01a6 }
            throw r13     // Catch:{ all -> 0x01a6 }
        L_0x01a6:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x01a8 }
        L_0x01a8:
            r13 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r11)     // Catch:{ all -> 0x01ad }
            throw r13     // Catch:{ all -> 0x01ad }
        L_0x01ad:
            r11 = move-exception
            T r12 = r12.element     // Catch:{ all -> 0x01bd }
            java.io.File r12 = (java.io.File) r12     // Catch:{ all -> 0x01bd }
            if (r12 != 0) goto L_0x01b5
            goto L_0x01bc
        L_0x01b5:
            boolean r12 = r12.delete()     // Catch:{ all -> 0x01bd }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)     // Catch:{ all -> 0x01bd }
        L_0x01bc:
            throw r11     // Catch:{ all -> 0x01bd }
        L_0x01bd:
            r11 = move-exception
            r5.clearInterrupt()     // Catch:{ Exception -> 0x01c2 }
            throw r11     // Catch:{ Exception -> 0x01c2 }
        L_0x01c2:
            r11 = move-exception
            boolean r12 = r11 instanceof java.lang.InterruptedException
            if (r12 != 0) goto L_0x01cd
            boolean r12 = r11 instanceof java.io.InterruptedIOException
            if (r12 == 0) goto L_0x01cc
            goto L_0x01cd
        L_0x01cc:
            throw r11
        L_0x01cd:
            java.util.concurrent.CancellationException r12 = new java.util.concurrent.CancellationException
            java.lang.String r13 = "Blocking call was interrupted due to parent cancellation."
            r12.<init>(r13)
            java.lang.Throwable r11 = r12.initCause(r11)
            java.lang.String r12 = "CancellationException(\"B…n.\").initCause(exception)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.ImageDecoderDecoder.decode(coil.bitmap.BitmapPool, okio.BufferedSource, coil.size.Size, coil.decode.Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean handles(@NotNull BufferedSource bufferedSource, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        if (DecodeUtils.isGif(bufferedSource) || DecodeUtils.isAnimatedWebP(bufferedSource) || (Build.VERSION.SDK_INT >= 30 && DecodeUtils.isAnimatedHeif(bufferedSource))) {
            return true;
        }
        return false;
    }

    @Deprecated(message = "Migrate to the constructor that accepts a Context.", replaceWith = @ReplaceWith(expression = "ImageDecoderDecoder(context)", imports = {}))
    public ImageDecoderDecoder() {
        this(false, (Context) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageDecoderDecoder(@NotNull Context context2) {
        this(false, context2);
        Intrinsics.checkNotNullParameter(context2, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageDecoderDecoder(@NotNull Context context2, boolean z11) {
        this(z11, context2);
        Intrinsics.checkNotNullParameter(context2, "context");
    }
}
