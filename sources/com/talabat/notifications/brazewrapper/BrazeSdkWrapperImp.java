package com.talabat.notifications.brazewrapper;

import com.braze.Braze;
import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/notifications/brazewrapper/BrazeSdkWrapperImp;", "Lcom/talabat/notifications/brazewrapper/BrazeSdkWrapper;", "braze", "Lcom/braze/Braze;", "(Lcom/braze/Braze;)V", "changeUser", "", "userId", "", "setBooleanCustomUserAttribute", "key", "value", "", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeSdkWrapperImp implements BrazeSdkWrapper {
    @NotNull
    private final Braze braze;

    public BrazeSdkWrapperImp(@NotNull Braze braze2) {
        Intrinsics.checkNotNullParameter(braze2, "braze");
        this.braze = braze2;
    }

    public void changeUser(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        this.braze.changeUser(str);
    }

    public void setBooleanCustomUserAttribute(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        BrazeUser currentUser = this.braze.getCurrentUser();
        if (currentUser != null) {
            currentUser.setCustomUserAttribute(str, z11);
        }
    }
}
