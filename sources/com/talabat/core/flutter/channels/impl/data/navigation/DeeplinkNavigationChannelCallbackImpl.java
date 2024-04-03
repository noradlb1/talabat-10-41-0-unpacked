package com.talabat.core.flutter.channels.impl.data.navigation;

import android.content.Context;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.flutter.channels.domain.navigation.DeeplinkNavigationChannelCallback;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/navigation/DeeplinkNavigationChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationChannelCallback;", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "onCanOpenDeeplink", "", "deeplink", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onOpenDeeplink", "context", "Landroid/content/Context;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeeplinkNavigationChannelCallbackImpl implements DeeplinkNavigationChannelCallback {
    @NotNull
    private final DeepLinkNavigator deepLinkNavigator;

    @Inject
    public DeeplinkNavigationChannelCallbackImpl(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "deepLinkNavigator");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    @Nullable
    public Object onCanOpenDeeplink(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return this.deepLinkNavigator.canHandleDeepLink(str, continuation);
    }

    public boolean onOpenDeeplink(@NotNull String str, @NotNull Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "deeplink");
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            DeepLinkNavigator.DefaultImpls.navigateTo$default(this.deepLinkNavigator, context, str, (Function0) null, 4, (Object) null);
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            return false;
        }
        Unit unit = (Unit) obj;
        return true;
    }
}
