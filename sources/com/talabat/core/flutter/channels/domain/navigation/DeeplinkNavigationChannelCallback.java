package com.talabat.core.flutter.channels.domain.navigation;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/navigation/DeeplinkNavigationChannelCallback;", "", "onCanOpenDeeplink", "", "deeplink", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onOpenDeeplink", "context", "Landroid/content/Context;", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DeeplinkNavigationChannelCallback {
    @Nullable
    Object onCanOpenDeeplink(@NotNull String str, @NotNull Continuation<? super Boolean> continuation);

    boolean onOpenDeeplink(@NotNull String str, @NotNull Context context);
}
