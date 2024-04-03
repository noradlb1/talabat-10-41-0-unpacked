package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$onSizeChanged$1$job$1", f = "ContentInViewModifier.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
public final class ContentInViewModifier$onSizeChanged$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1825h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ContentInViewModifier f1826i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Rect f1827j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Rect f1828k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentInViewModifier$onSizeChanged$1$job$1(ContentInViewModifier contentInViewModifier, Rect rect, Rect rect2, Continuation<? super ContentInViewModifier$onSizeChanged$1$job$1> continuation) {
        super(2, continuation);
        this.f1826i = contentInViewModifier;
        this.f1827j = rect;
        this.f1828k = rect2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ContentInViewModifier$onSizeChanged$1$job$1(this.f1826i, this.f1827j, this.f1828k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ContentInViewModifier$onSizeChanged$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1825h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ContentInViewModifier contentInViewModifier = this.f1826i;
            Rect rect = this.f1827j;
            Rect rect2 = this.f1828k;
            this.f1825h = 1;
            if (contentInViewModifier.performBringIntoView(rect, rect2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
