package com.designsystem.ds_toast;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u000b"}, d2 = {"Landroidx/compose/ui/Modifier;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSToastHostStateKt$swipeToDismiss$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f33221g;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.designsystem.ds_toast.DSToastHostStateKt$swipeToDismiss$1$1", f = "DSToastHostState.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.designsystem.ds_toast.DSToastHostStateKt$swipeToDismiss$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f33222h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(function0, continuation);
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
            int i11 = this.f33222h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                final Function0<Unit> function0 = function0;
                AnonymousClass1 r12 = new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f33224h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public DSToastHostStateKt$swipeToDismiss$1(Function0<Unit> function0) {
                            super(3);
                            this.f33221g = function0;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        @NotNull
                        @Composable
                        public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
                            Intrinsics.checkNotNullParameter(modifier, "$this$composed");
                            composer.startReplaceableGroup(-1524424860);
                            Unit unit = Unit.INSTANCE;
                            final Function0<Unit> function0 = this.f33221g;
                            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
                            composer.endReplaceableGroup();
                            return pointerInput;
                        }
                    }
