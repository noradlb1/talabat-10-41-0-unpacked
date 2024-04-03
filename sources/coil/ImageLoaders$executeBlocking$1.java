package coil;

import coil.request.ImageRequest;
import coil.request.ImageResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcoil/request/ImageResult;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "coil.ImageLoaders$executeBlocking$1", f = "ImageLoaders.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
public final class ImageLoaders$executeBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f39667h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ImageLoader f39668i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f39669j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoaders$executeBlocking$1(ImageLoader imageLoader, ImageRequest imageRequest, Continuation<? super ImageLoaders$executeBlocking$1> continuation) {
        super(2, continuation);
        this.f39668i = imageLoader;
        this.f39669j = imageRequest;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImageLoaders$executeBlocking$1(this.f39668i, this.f39669j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ImageResult> continuation) {
        return ((ImageLoaders$executeBlocking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f39667h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ImageLoader imageLoader = this.f39668i;
            ImageRequest imageRequest = this.f39669j;
            this.f39667h = 1;
            obj = imageLoader.execute(imageRequest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
