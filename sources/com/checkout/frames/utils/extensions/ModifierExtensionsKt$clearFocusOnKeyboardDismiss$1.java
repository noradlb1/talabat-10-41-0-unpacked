package com.checkout.frames.utils.extensions;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.platform.CompositionLocalsKt;
import d0.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
public final class ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1 INSTANCE = new ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.checkout.frames.utils.extensions.ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1$1", f = "ModifierExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.checkout.frames.utils.extensions.ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(focusManager, access$rememberKeyboardOpenState, mutableState2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1.m9326invoke$lambda6(access$rememberKeyboardOpenState)) {
                    ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1.m9325invoke$lambda5(mutableState2, true);
                } else if (ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1.m9324invoke$lambda4(mutableState2)) {
                    b.a(focusManager, false, 1, (Object) null);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1() {
        super(3);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final boolean m9322invoke$lambda1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m9323invoke$lambda2(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final boolean m9324invoke$lambda4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final void m9325invoke$lambda5(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-6  reason: not valid java name */
    public static final boolean m9326invoke$lambda6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(201942476);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        if (m9322invoke$lambda1(mutableState)) {
            final State access$rememberKeyboardOpenState = ModifierExtensionsKt.rememberKeyboardOpenState(composer, 0);
            final FocusManager focusManager = (FocusManager) composer.consume(CompositionLocalsKt.getLocalFocusManager());
            EffectsKt.LaunchedEffect((Object) Boolean.valueOf(m9326invoke$lambda6(access$rememberKeyboardOpenState)), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), composer, 64);
        }
        Modifier onFocusEvent = FocusEventModifierKt.onFocusEvent(modifier, new Function1<FocusState, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusState) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FocusState focusState) {
                Intrinsics.checkNotNullParameter(focusState, "it");
                if (ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1.m9322invoke$lambda1(mutableState) != focusState.isFocused()) {
                    ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1.m9323invoke$lambda2(mutableState, focusState.isFocused());
                    if (ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1.m9322invoke$lambda1(mutableState)) {
                        ModifierExtensionsKt$clearFocusOnKeyboardDismiss$1.m9325invoke$lambda5(mutableState2, false);
                    }
                }
            }
        });
        composer.endReplaceableGroup();
        return onFocusEvent;
    }
}
