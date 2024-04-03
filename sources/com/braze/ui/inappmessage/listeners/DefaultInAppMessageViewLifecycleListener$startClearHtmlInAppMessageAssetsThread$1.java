package com.braze.ui.inappmessage.listeners;

import android.app.Activity;
import com.braze.support.BrazeFileUtils;
import com.braze.support.WebContentUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1", f = "DefaultInAppMessageViewLifecycleListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f44138h;

    public DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1(Continuation<? super DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f44138h == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity = BrazeInAppMessageManager.Companion.getInstance().getActivity();
            if (activity != null) {
                BrazeFileUtils.deleteFileOrDirectory(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(activity));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
