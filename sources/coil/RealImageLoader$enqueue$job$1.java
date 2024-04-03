package coil;

import coil.request.ErrorResult;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "coil.RealImageLoader$enqueue$job$1", f = "RealImageLoader.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
public final class RealImageLoader$enqueue$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f39671h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RealImageLoader f39672i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f39673j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealImageLoader$enqueue$job$1(RealImageLoader realImageLoader, ImageRequest imageRequest, Continuation<? super RealImageLoader$enqueue$job$1> continuation) {
        super(2, continuation);
        this.f39672i = realImageLoader;
        this.f39673j = imageRequest;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RealImageLoader$enqueue$job$1(this.f39672i, this.f39673j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RealImageLoader$enqueue$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f39671h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            RealImageLoader realImageLoader = this.f39672i;
            ImageRequest imageRequest = this.f39673j;
            this.f39671h = 1;
            obj = realImageLoader.executeMain(imageRequest, 0, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ImageResult imageResult = (ImageResult) obj;
        if (!(imageResult instanceof ErrorResult)) {
            return Unit.INSTANCE;
        }
        throw ((ErrorResult) imageResult).getThrowable();
    }
}
