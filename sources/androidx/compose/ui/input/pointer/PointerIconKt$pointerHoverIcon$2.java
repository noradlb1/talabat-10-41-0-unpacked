package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class PointerIconKt$pointerHoverIcon$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PointerIcon f9775g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f9776h;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1", f = "PointerIcon.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f9777h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(z11, pointerIconService, pointerIcon2, continuation);
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
            int i11 = this.f9777h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final boolean z11 = z11;
                final PointerIconService pointerIconService = pointerIconService;
                final PointerIcon pointerIcon = pointerIcon2;
                AnonymousClass1 r12 = new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f9781h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public PointerIconKt$pointerHoverIcon$2(PointerIcon pointerIcon, boolean z11) {
                            super(3);
                            this.f9775g = pointerIcon;
                            this.f9776h = z11;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        @NotNull
                        @Composable
                        public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
                            Modifier modifier2;
                            Intrinsics.checkNotNullParameter(modifier, "$this$composed");
                            composer.startReplaceableGroup(811087536);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(811087536, i11, -1, "androidx.compose.ui.input.pointer.pointerHoverIcon.<anonymous> (PointerIcon.kt:67)");
                            }
                            final PointerIconService pointerIconService = (PointerIconService) composer.consume(CompositionLocalsKt.getLocalPointerIconService());
                            if (pointerIconService == null) {
                                modifier2 = Modifier.Companion;
                            } else {
                                PointerIcon pointerIcon = this.f9775g;
                                Boolean valueOf = Boolean.valueOf(this.f9776h);
                                final boolean z11 = this.f9776h;
                                final PointerIcon pointerIcon2 = this.f9775g;
                                modifier2 = SuspendingPointerInputFilterKt.pointerInput(modifier, pointerIcon, valueOf, new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceableGroup();
                            return modifier2;
                        }
                    }
