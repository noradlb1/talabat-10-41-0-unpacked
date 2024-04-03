package com.deliveryhero.impression.view;

import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.lifecycle.LifecycleOwner;
import com.deliveryhero.impression.ImpressionProvider;
import com.deliveryhero.impression.ImpressionRemote;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001%J\b\u0010 \u001a\u00020\fH&J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0017J\b\u0010$\u001a\u00020\"H\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/deliveryhero/impression/view/Tracker;", "", "dataProvider", "Lcom/deliveryhero/impression/ImpressionProvider;", "getDataProvider", "()Lcom/deliveryhero/impression/ImpressionProvider;", "impressionTrackerCallback", "Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;", "getImpressionTrackerCallback", "()Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;", "isEnabled", "Lkotlin/Function0;", "", "()Lkotlin/jvm/functions/Function0;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "parentPosition", "", "getParentPosition", "()Ljava/lang/Integer;", "remote", "Lcom/deliveryhero/impression/ImpressionRemote;", "getRemote", "()Lcom/deliveryhero/impression/ImpressionRemote;", "view", "Landroid/view/ViewGroup;", "getView", "()Landroid/view/ViewGroup;", "isRegistered", "reCalculate", "", "register", "unregister", "ListState", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Tracker {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void reCalculate(@NotNull Tracker tracker) {
            Intrinsics.checkNotNullParameter(tracker, "this");
        }

        @CallSuper
        public static void register(@NotNull Tracker tracker) {
            Intrinsics.checkNotNullParameter(tracker, "this");
            if (tracker.isEnabled().invoke().booleanValue()) {
                tracker.isRegistered();
            }
        }

        @CallSuper
        public static void unregister(@NotNull Tracker tracker) {
            Intrinsics.checkNotNullParameter(tracker, "this");
            tracker.isEnabled().invoke().booleanValue();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/impression/view/Tracker$ListState;", "", "(Ljava/lang/String;I)V", "TO_VISIBLE", "TO_INVISIBLE", "SCROLL_STOPPED", "CONTENT_CHANGED", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ListState {
        TO_VISIBLE,
        TO_INVISIBLE,
        SCROLL_STOPPED,
        CONTENT_CHANGED
    }

    @NotNull
    ImpressionProvider getDataProvider();

    @Nullable
    ImpressionTrackerCallback getImpressionTrackerCallback();

    @Nullable
    LifecycleOwner getLifecycleOwner();

    @Nullable
    Integer getParentPosition();

    @NotNull
    ImpressionRemote getRemote();

    @NotNull
    ViewGroup getView();

    @NotNull
    Function0<Boolean> isEnabled();

    boolean isRegistered();

    void reCalculate();

    @CallSuper
    void register();

    void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner);

    @CallSuper
    void unregister();
}
