package com.deliveryhero.fluid.widgets.collections;

import com.deliveryhero.fluid.widgets.collections.VisibilityObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/deliveryhero/fluid/widgets/collections/VisibilityObserver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChildVisibilityNotifier$onChildViewAttachedToWindow$1 extends Lambda implements Function1<VisibilityObserver, Unit> {
    public static final ChildVisibilityNotifier$onChildViewAttachedToWindow$1 INSTANCE = new ChildVisibilityNotifier$onChildViewAttachedToWindow$1();

    public ChildVisibilityNotifier$onChildViewAttachedToWindow$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VisibilityObserver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull VisibilityObserver visibilityObserver) {
        Intrinsics.checkNotNullParameter(visibilityObserver, "$this$notifyToAllChildViewsOf");
        visibilityObserver.onViewAppearedOnScreen(VisibilityObserver.Reason.ScrollEvent);
    }
}
