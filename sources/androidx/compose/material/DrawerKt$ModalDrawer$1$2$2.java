package androidx.compose.material;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$ModalDrawer$1$2$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4465g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DrawerState f4466h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f4467i;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1", f = "Drawer.kt", i = {}, l = {421}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.DrawerKt$ModalDrawer$1$2$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f4468h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(drawerState, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f4468h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                DrawerState drawerState = drawerState;
                this.f4468h = 1;
                if (drawerState.close(this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$ModalDrawer$1$2$2(boolean z11, DrawerState drawerState, CoroutineScope coroutineScope) {
        super(0);
        this.f4465g = z11;
        this.f4466h = drawerState;
        this.f4467i = coroutineScope;
    }

    public final void invoke() {
        if (this.f4465g && this.f4466h.getSwipeableState$material_release().getConfirmStateChange$material_release().invoke(DrawerValue.Closed).booleanValue()) {
            CoroutineScope coroutineScope = this.f4467i;
            final DrawerState drawerState = this.f4466h;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
    }
}
