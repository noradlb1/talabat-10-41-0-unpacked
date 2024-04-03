package com.skydoves.landscapist.coil;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import coil.ImageLoader;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.target.Target;
import com.skydoves.landscapist.ImageLoadState;
import com.skydoves.landscapist.palette.BitmapPalette;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.skydoves.landscapist.coil.CoilImage__CoilImageKt$CoilImage$14", f = "CoilImage.kt", i = {}, l = {684}, m = "invokeSuspend", n = {}, s = {})
public final class CoilImage__CoilImageKt$CoilImage$14 extends SuspendLambda implements Function1<Continuation<? super Flow<? extends ImageLoadState>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f53067h;

    /* renamed from: i  reason: collision with root package name */
    public Object f53068i;

    /* renamed from: j  reason: collision with root package name */
    public Object f53069j;

    /* renamed from: k  reason: collision with root package name */
    public Object f53070k;

    /* renamed from: l  reason: collision with root package name */
    public Object f53071l;

    /* renamed from: m  reason: collision with root package name */
    public Object f53072m;

    /* renamed from: n  reason: collision with root package name */
    public int f53073n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableState<Disposable> f53074o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f53075p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f53076q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ Context f53077r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ MutableStateFlow<ImageLoadState> f53078s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f53079t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoilImage__CoilImageKt$CoilImage$14(MutableState<Disposable> mutableState, ImageLoader imageLoader, ImageRequest imageRequest, Context context, MutableStateFlow<ImageLoadState> mutableStateFlow, BitmapPalette bitmapPalette, Continuation<? super CoilImage__CoilImageKt$CoilImage$14> continuation) {
        super(1, continuation);
        this.f53074o = mutableState;
        this.f53075p = imageLoader;
        this.f53076q = imageRequest;
        this.f53077r = context;
        this.f53078s = mutableStateFlow;
        this.f53079t = bitmapPalette;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new CoilImage__CoilImageKt$CoilImage$14(this.f53074o, this.f53075p, this.f53076q, this.f53077r, this.f53078s, this.f53079t, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Flow<? extends ImageLoadState>> continuation) {
        return ((CoilImage__CoilImageKt$CoilImage$14) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f53073n;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            MutableState<Disposable> mutableState = this.f53074o;
            ImageLoader imageLoader = this.f53075p;
            ImageRequest imageRequest = this.f53076q;
            Context context = this.f53077r;
            MutableStateFlow<ImageLoadState> mutableStateFlow = this.f53078s;
            BitmapPalette bitmapPalette = this.f53079t;
            this.f53067h = mutableState;
            this.f53068i = imageLoader;
            this.f53069j = imageRequest;
            this.f53070k = context;
            this.f53071l = mutableStateFlow;
            this.f53072m = bitmapPalette;
            this.f53073n = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            mutableState.setValue(imageLoader.enqueue(imageRequest.newBuilder(context).target((Target) new CoilImage__CoilImageKt$CoilImage$14$invokeSuspend$lambda3$$inlined$target$1(mutableStateFlow, mutableStateFlow, mutableStateFlow, bitmapPalette, imageRequest)).build()));
            cancellableContinuationImpl.resume(mutableStateFlow, new CoilImage__CoilImageKt$CoilImage$14$1$4(mutableState));
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            BitmapPalette bitmapPalette2 = (BitmapPalette) this.f53072m;
            MutableStateFlow mutableStateFlow2 = (MutableStateFlow) this.f53071l;
            Context context2 = (Context) this.f53070k;
            ImageRequest imageRequest2 = (ImageRequest) this.f53069j;
            ImageLoader imageLoader2 = (ImageLoader) this.f53068i;
            MutableState mutableState2 = (MutableState) this.f53067h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
