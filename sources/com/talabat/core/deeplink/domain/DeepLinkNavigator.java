package com.talabat.core.deeplink.domain;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fH&\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "", "canHandleDeepLink", "", "link", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateTo", "", "context", "Landroid/content/Context;", "onNavigationCompletionCallback", "Lkotlin/Function0;", "com_talabat_core_deeplink_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DeepLinkNavigator {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void navigateTo$default(DeepLinkNavigator deepLinkNavigator, Context context, String str, Function0 function0, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    function0 = null;
                }
                deepLinkNavigator.navigateTo(context, str, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateTo");
        }
    }

    @Nullable
    Object canHandleDeepLink(@NotNull String str, @NotNull Continuation<? super Boolean> continuation);

    void navigateTo(@NotNull Context context, @NotNull String str, @Nullable @androidx.annotation.Nullable Function0<Unit> function0);
}
