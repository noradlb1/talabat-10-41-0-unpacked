package com.checkout.frames.utils.extensions;

import android.view.View;
import androidx.compose.runtime.ProduceStateScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.checkout.frames.utils.extensions.ModifierExtensionsKt$rememberKeyboardOpenState$1$1", f = "ModifierExtensions.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class ModifierExtensionsKt$rememberKeyboardOpenState$1$1 extends SuspendLambda implements Function2<ProduceStateScope<Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $this_with;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifierExtensionsKt$rememberKeyboardOpenState$1$1(View view, Continuation<? super ModifierExtensionsKt$rememberKeyboardOpenState$1$1> continuation) {
        super(2, continuation);
        this.$this_with = view;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m9327invokeSuspend$lambda0(ProduceStateScope produceStateScope, View view) {
        produceStateScope.setValue(Boolean.valueOf(ViewExtensionsKt.isKeyboardOpen(view)));
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ModifierExtensionsKt$rememberKeyboardOpenState$1$1 modifierExtensionsKt$rememberKeyboardOpenState$1$1 = new ModifierExtensionsKt$rememberKeyboardOpenState$1$1(this.$this_with, continuation);
        modifierExtensionsKt$rememberKeyboardOpenState$1$1.L$0 = obj;
        return modifierExtensionsKt$rememberKeyboardOpenState$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProduceStateScope<Boolean> produceStateScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ModifierExtensionsKt$rememberKeyboardOpenState$1$1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
            final a aVar = new a(produceStateScope, this.$this_with);
            this.$this_with.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            final View view = this.$this_with;
            AnonymousClass1 r12 = new Function0<Unit>() {
                public final void invoke() {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(aVar);
                }
            };
            this.label = 1;
            if (produceStateScope.awaitDispose(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
