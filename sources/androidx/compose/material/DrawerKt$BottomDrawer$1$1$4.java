package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class DrawerKt$BottomDrawer$1$1$4 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f4421g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BottomDrawerState f4422h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f4423i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerKt$BottomDrawer$1$1$4(String str, BottomDrawerState bottomDrawerState, CoroutineScope coroutineScope) {
        super(1);
        this.f4421g = str;
        this.f4422h = bottomDrawerState;
        this.f4423i = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, this.f4421g);
        if (this.f4422h.isOpen()) {
            final BottomDrawerState bottomDrawerState = this.f4422h;
            final CoroutineScope coroutineScope = this.f4423i;
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1", f = "Drawer.kt", i = {}, l = {580}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material.DrawerKt$BottomDrawer$1$1$4$1$1  reason: invalid class name */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                    /* renamed from: h  reason: collision with root package name */
                    public int f4426h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass1(bottomDrawerState, continuation);
                    }

                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i11 = this.f4426h;
                        if (i11 == 0) {
                            ResultKt.throwOnFailure(obj);
                            BottomDrawerState bottomDrawerState = bottomDrawerState;
                            this.f4426h = 1;
                            if (bottomDrawerState.close(this) == coroutine_suspended) {
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

                @NotNull
                public final Boolean invoke() {
                    if (((Boolean) bottomDrawerState.getConfirmStateChange$material_release().invoke(BottomDrawerValue.Closed)).booleanValue()) {
                        CoroutineScope coroutineScope = coroutineScope;
                        final BottomDrawerState bottomDrawerState = bottomDrawerState;
                        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                    }
                    return Boolean.TRUE;
                }
            }, 1, (Object) null);
        }
    }
}
