package curtains.internal;

import android.view.View;
import curtains.OnRootViewsChangedListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0004\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcurtains/internal/RootViewsSpy;", "", "()V", "delegatingViewList", "curtains/internal/RootViewsSpy$delegatingViewList$1", "Lcurtains/internal/RootViewsSpy$delegatingViewList$1;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcurtains/OnRootViewsChangedListener;", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "copyRootViewList", "", "Landroid/view/View;", "Companion", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class RootViewsSpy {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final RootViewsSpy$delegatingViewList$1 delegatingViewList;
    @NotNull
    private final CopyOnWriteArrayList<OnRootViewsChangedListener> listeners;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcurtains/internal/RootViewsSpy$Companion;", "", "()V", "install", "Lcurtains/internal/RootViewsSpy;", "curtains_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RootViewsSpy install() {
            RootViewsSpy rootViewsSpy = new RootViewsSpy((DefaultConstructorMarker) null);
            WindowManagerSpy.INSTANCE.swapWindowManagerGlobalMViews(new RootViewsSpy$Companion$install$1$1(rootViewsSpy));
            return rootViewsSpy;
        }
    }

    private RootViewsSpy() {
        this.listeners = new CopyOnWriteArrayList<>();
        this.delegatingViewList = new RootViewsSpy$delegatingViewList$1(this);
    }

    @NotNull
    public final List<View> copyRootViewList() {
        return CollectionsKt___CollectionsKt.toList(this.delegatingViewList);
    }

    @NotNull
    public final CopyOnWriteArrayList<OnRootViewsChangedListener> getListeners() {
        return this.listeners;
    }

    public /* synthetic */ RootViewsSpy(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
