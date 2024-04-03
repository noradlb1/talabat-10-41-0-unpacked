package coil.decode;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import coil.util.GifExtensions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "coil.decode.ImageDecoderDecoder$decode$drawable$1", f = "ImageDecoderDecoder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageDecoderDecoder$decode$drawable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f39708h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Drawable f39709i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f39710j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f39711k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageDecoderDecoder$decode$drawable$1(Drawable drawable, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super ImageDecoderDecoder$decode$drawable$1> continuation) {
        super(2, continuation);
        this.f39709i = drawable;
        this.f39710j = function0;
        this.f39711k = function02;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ImageDecoderDecoder$decode$drawable$1(this.f39709i, this.f39710j, this.f39711k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ImageDecoderDecoder$decode$drawable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f39708h == 0) {
            ResultKt.throwOnFailure(obj);
            ((AnimatedImageDrawable) this.f39709i).registerAnimationCallback(GifExtensions.animatable2CallbackOf(this.f39710j, this.f39711k));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
