package com.designsystem.ds_toast;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/designsystem/ds_toast/ToastHostState;", "", "()V", "ActionableToastDuration", "", "NonActionableToastDuration", "SwipeToDismissThreshold", "", "ToastFadeInMillis", "ToastFadeOutMillis", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ToastHostState {
    public static final long ActionableToastDuration = 5000;
    @NotNull
    public static final ToastHostState INSTANCE = new ToastHostState();
    public static final long NonActionableToastDuration = 4000;
    public static final int SwipeToDismissThreshold = 30;
    public static final int ToastFadeInMillis = 150;
    public static final int ToastFadeOutMillis = 150;

    private ToastHostState() {
    }
}
