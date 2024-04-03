package androidx.compose.material;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$1$1", f = "Drawer.kt", i = {}, l = {634}, m = "invokeSuspend", n = {}, s = {})
public final class DrawerKt$BottomDrawerScrim$dismissModifier$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f4448h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f4449i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawerScrim$dismissModifier$1$1(Function0<Unit> function0, Continuation<? super DrawerKt$BottomDrawerScrim$dismissModifier$1$1> continuation) {
        super(2, continuation);
        this.f4449i = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DrawerKt$BottomDrawerScrim$dismissModifier$1$1 drawerKt$BottomDrawerScrim$dismissModifier$1$1 = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(this.f4449i, continuation);
        drawerKt$BottomDrawerScrim$dismissModifier$1$1.L$0 = obj;
        return drawerKt$BottomDrawerScrim$dismissModifier$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DrawerKt$BottomDrawerScrim$dismissModifier$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f4448h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final Function0<Unit> function0 = this.f4449i;
            AnonymousClass1 r72 = new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m1237invokek4lQ0M(((Offset) obj).m2686unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m1237invokek4lQ0M(long j11) {
                    function0.invoke();
                }
            };
            this.f4448h = 1;
            if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, (Function1) null, (Function1) null, (Function3) null, r72, this, 7, (Object) null) == coroutine_suspended) {
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
