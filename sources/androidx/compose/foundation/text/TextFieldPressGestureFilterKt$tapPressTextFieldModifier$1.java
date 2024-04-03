package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f3584g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f3585h;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2", f = "TextFieldPressGestureFilter.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f3588h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 r02 = new AnonymousClass2(coroutineScope, mutableState, mutableInteractionSource3, rememberUpdatedState, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f3588h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = coroutineScope;
                final MutableState<PressInteraction.Press> mutableState = mutableState;
                final MutableInteractionSource mutableInteractionSource = mutableInteractionSource3;
                AnonymousClass1 r12 = new Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f3593h;

                    /* renamed from: i  reason: collision with root package name */
                    public /* synthetic */ long f3594i;

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m916invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2686unboximpl(), (Continuation) obj3);
                    }

                    @Nullable
                    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
                    public final Object m916invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j11, @Nullable Continuation<? super Unit> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1(Function1<? super Offset, Unit> function1, MutableInteractionSource mutableInteractionSource) {
                            super(3);
                            this.f3584g = function1;
                            this.f3585h = mutableInteractionSource;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        @NotNull
                        @Composable
                        public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
                            Intrinsics.checkNotNullParameter(modifier, "$this$composed");
                            composer.startReplaceableGroup(-102778667);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-102778667, i11, -1, "androidx.compose.foundation.text.tapPressTextFieldModifier.<anonymous> (TextFieldPressGestureFilter.kt:40)");
                            }
                            composer.startReplaceableGroup(773894976);
                            composer.startReplaceableGroup(-492369756);
                            Object rememberedValue = composer.rememberedValue();
                            Composer.Companion companion = Composer.Companion;
                            if (rememberedValue == companion.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                rememberedValue = compositionScopedCoroutineScopeCanceller;
                            }
                            composer.endReplaceableGroup();
                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                            composer.endReplaceableGroup();
                            composer.startReplaceableGroup(-492369756);
                            Object rememberedValue2 = composer.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            composer.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue2;
                            final State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.f3584g, composer, 0);
                            MutableInteractionSource mutableInteractionSource = this.f3585h;
                            composer.startReplaceableGroup(511388516);
                            boolean changed = composer.changed((Object) mutableState) | composer.changed((Object) mutableInteractionSource);
                            Object rememberedValue3 = composer.rememberedValue();
                            if (changed || rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$1$1(mutableState, mutableInteractionSource);
                                composer.updateRememberedValue(rememberedValue3);
                            }
                            composer.endReplaceableGroup();
                            EffectsKt.DisposableEffect((Object) mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue3, composer, 0);
                            Modifier.Companion companion2 = Modifier.Companion;
                            MutableInteractionSource mutableInteractionSource2 = this.f3585h;
                            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                            Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion2, (Object) mutableInteractionSource2, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass2((Continuation<? super AnonymousClass2>) null));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceableGroup();
                            return pointerInput;
                        }
                    }
