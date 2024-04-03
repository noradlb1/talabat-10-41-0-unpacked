package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0010*\u00020\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u0004*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"IsPoolingContainerTag", "", "PoolingContainerListenerHolderTag", "value", "", "isPoolingContainer", "Landroid/view/View;", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "poolingContainerListenerHolder", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "getPoolingContainerListenerHolder", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "addPoolingContainerListener", "", "listener", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "callPoolingContainerOnRelease", "callPoolingContainerOnReleaseForChildren", "Landroid/view/ViewGroup;", "removePoolingContainerListener", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "PoolingContainer")
public final class PoolingContainer {
    private static final int IsPoolingContainerTag = R.id.is_pooling_container_tag;
    private static final int PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(@NotNull View view, @NotNull PoolingContainerListener poolingContainerListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getPoolingContainerListenerHolder(view).addListener(poolingContainerListener);
    }

    public static final void callPoolingContainerOnRelease(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        for (View poolingContainerListenerHolder : ViewKt.getAllViews(view)) {
            getPoolingContainerListenerHolder(poolingContainerListenerHolder).onRelease();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        for (View poolingContainerListenerHolder : ViewGroupKt.getChildren(viewGroup)) {
            getPoolingContainerListenerHolder(poolingContainerListenerHolder).onRelease();
        }
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        int i11 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i11);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i11, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final boolean isPoolingContainer(@NotNull View view) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(IsPoolingContainerTag);
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWithinPoolingContainer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        for (ViewParent next : ViewKt.getAncestors(view)) {
            if ((next instanceof View) && isPoolingContainer((View) next)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(@NotNull View view, @NotNull PoolingContainerListener poolingContainerListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getPoolingContainerListenerHolder(view).removeListener(poolingContainerListener);
    }

    public static final void setPoolingContainer(@NotNull View view, boolean z11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(IsPoolingContainerTag, Boolean.valueOf(z11));
    }
}
