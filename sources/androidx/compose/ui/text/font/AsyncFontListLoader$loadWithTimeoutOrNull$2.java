package androidx.compose.ui.text.font;

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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
public final class AsyncFontListLoader$loadWithTimeoutOrNull$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10168h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AsyncFontListLoader f10169i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Font f10170j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFontListLoader$loadWithTimeoutOrNull$2(AsyncFontListLoader asyncFontListLoader, Font font, Continuation<? super AsyncFontListLoader$loadWithTimeoutOrNull$2> continuation) {
        super(2, continuation);
        this.f10169i = asyncFontListLoader;
        this.f10170j = font;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AsyncFontListLoader$loadWithTimeoutOrNull$2(this.f10169i, this.f10170j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<Object> continuation) {
        return ((AsyncFontListLoader$loadWithTimeoutOrNull$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10168h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PlatformFontLoader access$getPlatformFontLoader$p = this.f10169i.platformFontLoader;
            Font font = this.f10170j;
            this.f10168h = 1;
            obj = access$getPlatformFontLoader$p.awaitLoad(font, this);
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
