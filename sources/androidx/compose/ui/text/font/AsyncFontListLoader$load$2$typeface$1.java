package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0000\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.ui.text.font.AsyncFontListLoader$load$2$typeface$1", f = "FontListFontFamilyTypefaceAdapter.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
public final class AsyncFontListLoader$load$2$typeface$1 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f10161h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AsyncFontListLoader f10162i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Font f10163j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFontListLoader$load$2$typeface$1(AsyncFontListLoader asyncFontListLoader, Font font, Continuation<? super AsyncFontListLoader$load$2$typeface$1> continuation) {
        super(1, continuation);
        this.f10162i = asyncFontListLoader;
        this.f10163j = font;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new AsyncFontListLoader$load$2$typeface$1(this.f10162i, this.f10163j, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<Object> continuation) {
        return ((AsyncFontListLoader$load$2$typeface$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f10161h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            AsyncFontListLoader asyncFontListLoader = this.f10162i;
            Font font = this.f10163j;
            this.f10161h = 1;
            obj = asyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(font, this);
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
