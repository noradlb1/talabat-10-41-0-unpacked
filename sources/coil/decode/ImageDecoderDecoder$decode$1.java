package coil.decode;

import coil.bitmap.BitmapPool;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.decode.ImageDecoderDecoder", f = "ImageDecoderDecoder.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {174, 148}, m = "decode", n = {"this", "source", "size", "options", "isSampled", "options", "isSampled", "baseDrawable"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2"})
public final class ImageDecoderDecoder$decode$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39700h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39701i;

    /* renamed from: j  reason: collision with root package name */
    public Object f39702j;

    /* renamed from: k  reason: collision with root package name */
    public Object f39703k;

    /* renamed from: l  reason: collision with root package name */
    public Object f39704l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f39705m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ ImageDecoderDecoder f39706n;

    /* renamed from: o  reason: collision with root package name */
    public int f39707o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageDecoderDecoder$decode$1(ImageDecoderDecoder imageDecoderDecoder, Continuation<? super ImageDecoderDecoder$decode$1> continuation) {
        super(continuation);
        this.f39706n = imageDecoderDecoder;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39705m = obj;
        this.f39707o |= Integer.MIN_VALUE;
        return this.f39706n.decode((BitmapPool) null, (BufferedSource) null, (Size) null, (Options) null, this);
    }
}
