package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1", f = "AndroidOverscroll.kt", i = {}, l = {322}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidEdgeEffectOverscrollEffect$effectModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f1433h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ AndroidEdgeEffectOverscrollEffect f1434i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1", f = "AndroidOverscroll.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$effectModifier$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f1435h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(androidEdgeEffectOverscrollEffect, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f1435h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = androidEdgeEffectOverscrollEffect;
                AnonymousClass1 r12 = new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f1437h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public AndroidEdgeEffectOverscrollEffect$effectModifier$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$effectModifier$1> continuation) {
                            super(2, continuation);
                            this.f1434i = androidEdgeEffectOverscrollEffect;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            AndroidEdgeEffectOverscrollEffect$effectModifier$1 androidEdgeEffectOverscrollEffect$effectModifier$1 = new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this.f1434i, continuation);
                            androidEdgeEffectOverscrollEffect$effectModifier$1.L$0 = obj;
                            return androidEdgeEffectOverscrollEffect$effectModifier$1;
                        }

                        @Nullable
                        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((AndroidEdgeEffectOverscrollEffect$effectModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f1433h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                final AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.f1434i;
                                AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f1433h = 1;
                                if (ForEachGestureKt.forEachGesture((PointerInputScope) this.L$0, r12, this) == coroutine_suspended) {
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
