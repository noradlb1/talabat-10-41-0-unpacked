package com.talabat.core.flutter.channels.impl.data.useraccount;

import android.app.Activity;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallback;
import com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallbackHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/useraccount/UserAccountChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/useraccount/UserAccountChannelCallback;", "()V", "homeChannelCallbackHandler", "Lcom/talabat/core/flutter/channels/domain/useraccount/UserAccountChannelCallbackHandler;", "getSelectedCountryCode", "", "onAttached", "", "activity", "Landroid/app/Activity;", "onDetached", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAccountChannelCallbackImpl implements UserAccountChannelCallback {
    @Nullable
    private UserAccountChannelCallbackHandler homeChannelCallbackHandler;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getSelectedCountryCode();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getSelectedCountryCode() {
        /*
            r1 = this;
            com.talabat.core.flutter.channels.domain.useraccount.UserAccountChannelCallbackHandler r0 = r1.homeChannelCallbackHandler
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getSelectedCountryCode()
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            java.lang.String r0 = ""
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.flutter.channels.impl.data.useraccount.UserAccountChannelCallbackImpl.getSelectedCountryCode():java.lang.String");
    }

    public void onAttached(@NotNull Activity activity) {
        UserAccountChannelCallbackHandler userAccountChannelCallbackHandler;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof UserAccountChannelCallbackHandler) {
            userAccountChannelCallbackHandler = (UserAccountChannelCallbackHandler) activity;
        } else {
            userAccountChannelCallbackHandler = null;
        }
        this.homeChannelCallbackHandler = userAccountChannelCallbackHandler;
    }

    public void onDetached() {
        this.homeChannelCallbackHandler = null;
    }
}
