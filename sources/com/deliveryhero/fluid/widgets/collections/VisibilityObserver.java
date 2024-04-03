package com.deliveryhero.fluid.widgets.collections;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver;", "", "onViewAppearedOnScreen", "", "reason", "Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver$Reason;", "onViewDisappearedFromScreen", "Reason", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VisibilityObserver {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver$Reason;", "", "(Ljava/lang/String;I)V", "ScrollEvent", "LifeCycle", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Reason {
        ScrollEvent,
        LifeCycle
    }

    void onViewAppearedOnScreen(@NotNull Reason reason);

    void onViewDisappearedFromScreen(@NotNull Reason reason);
}
