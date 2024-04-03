package com.talabat.sdsquad.core;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/sdsquad/core/GlideActivityExceptionHandler;", "", "()V", "isValidContextForGlide", "", "context", "Landroid/content/Context;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlideActivityExceptionHandler {
    @NotNull
    public static final GlideActivityExceptionHandler INSTANCE = new GlideActivityExceptionHandler();

    private GlideActivityExceptionHandler() {
    }

    public final boolean isValidContextForGlide(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        if (!(context instanceof Activity)) {
            return true;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }
}
