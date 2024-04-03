package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewModifier$onSizeChanged$1", f = "ContentInViewModifier.kt", i = {0}, l = {195}, m = "invokeSuspend", n = {"job"}, s = {"L$0"})
public final class ContentInViewModifier$onSizeChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f1821h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ContentInViewModifier f1822i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Rect f1823j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Rect f1824k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentInViewModifier$onSizeChanged$1(ContentInViewModifier contentInViewModifier, Rect rect, Rect rect2, Continuation<? super ContentInViewModifier$onSizeChanged$1> continuation) {
        super(2, continuation);
        this.f1822i = contentInViewModifier;
        this.f1823j = rect;
        this.f1824k = rect2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ContentInViewModifier$onSizeChanged$1 contentInViewModifier$onSizeChanged$1 = new ContentInViewModifier$onSizeChanged$1(this.f1822i, this.f1823j, this.f1824k, continuation);
        contentInViewModifier$onSizeChanged$1.L$0 = obj;
        return contentInViewModifier$onSizeChanged$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ContentInViewModifier$onSizeChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th2;
        Job job;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1821h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Job launch$default = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new ContentInViewModifier$onSizeChanged$1$job$1(this.f1822i, this.f1823j, this.f1824k, (Continuation<? super ContentInViewModifier$onSizeChanged$1$job$1>) null), 3, (Object) null);
            this.f1822i.focusAnimationJob = launch$default;
            try {
                this.L$0 = launch$default;
                this.f1821h = 1;
                if (launch$default.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                job = launch$default;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                job = launch$default;
                th2 = th4;
                if (this.f1822i.focusAnimationJob == job) {
                    this.f1822i.focusedChildBeingAnimated = null;
                    this.f1822i.setFocusTargetBounds((Rect) null);
                    this.f1822i.focusAnimationJob = null;
                }
                throw th2;
            }
        } else if (i11 == 1) {
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th5) {
                th2 = th5;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.f1822i.focusAnimationJob == job) {
            this.f1822i.focusedChildBeingAnimated = null;
            this.f1822i.setFocusTargetBounds((Rect) null);
            this.f1822i.focusAnimationJob = null;
        }
        return Unit.INSTANCE;
    }
}
