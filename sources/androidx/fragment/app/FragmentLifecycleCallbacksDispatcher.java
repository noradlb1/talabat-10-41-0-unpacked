package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class FragmentLifecycleCallbacksDispatcher {
    @NonNull
    private final FragmentManager mFragmentManager;
    @NonNull
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> mLifecycleCallbacks = new CopyOnWriteArrayList<>();

    public static final class FragmentLifecycleCallbacksHolder {
        @NonNull
        final FragmentManager.FragmentLifecycleCallbacks mCallback;
        final boolean mRecursive;

        public FragmentLifecycleCallbacksHolder(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z11) {
            this.mCallback = fragmentLifecycleCallbacks;
            this.mRecursive = z11;
        }
    }

    public FragmentLifecycleCallbacksDispatcher(@NonNull FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public void dispatchOnFragmentActivityCreated(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentActivityCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentActivityCreated(this.mFragmentManager, fragment, bundle);
            }
        }
    }

    public void dispatchOnFragmentAttached(@NonNull Fragment fragment, boolean z11) {
        Context context = this.mFragmentManager.getHost().getContext();
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentAttached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentAttached(this.mFragmentManager, fragment, context);
            }
        }
    }

    public void dispatchOnFragmentCreated(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentCreated(this.mFragmentManager, fragment, bundle);
            }
        }
    }

    public void dispatchOnFragmentDestroyed(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDestroyed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentDestroyed(this.mFragmentManager, fragment);
            }
        }
    }

    public void dispatchOnFragmentDetached(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentDetached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentDetached(this.mFragmentManager, fragment);
            }
        }
    }

    public void dispatchOnFragmentPaused(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPaused(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentPaused(this.mFragmentManager, fragment);
            }
        }
    }

    public void dispatchOnFragmentPreAttached(@NonNull Fragment fragment, boolean z11) {
        Context context = this.mFragmentManager.getHost().getContext();
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreAttached(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentPreAttached(this.mFragmentManager, fragment, context);
            }
        }
    }

    public void dispatchOnFragmentPreCreated(@NonNull Fragment fragment, @Nullable Bundle bundle, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentPreCreated(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentPreCreated(this.mFragmentManager, fragment, bundle);
            }
        }
    }

    public void dispatchOnFragmentResumed(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentResumed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentResumed(this.mFragmentManager, fragment);
            }
        }
    }

    public void dispatchOnFragmentSaveInstanceState(@NonNull Fragment fragment, @NonNull Bundle bundle, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentSaveInstanceState(this.mFragmentManager, fragment, bundle);
            }
        }
    }

    public void dispatchOnFragmentStarted(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStarted(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentStarted(this.mFragmentManager, fragment);
            }
        }
    }

    public void dispatchOnFragmentStopped(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentStopped(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentStopped(this.mFragmentManager, fragment);
            }
        }
    }

    public void dispatchOnFragmentViewCreated(@NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewCreated(fragment, view, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentViewCreated(this.mFragmentManager, fragment, view, bundle);
            }
        }
    }

    public void dispatchOnFragmentViewDestroyed(@NonNull Fragment fragment, boolean z11) {
        Fragment parent = this.mFragmentManager.getParent();
        if (parent != null) {
            parent.getParentFragmentManager().getLifecycleCallbacksDispatcher().dispatchOnFragmentViewDestroyed(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.mLifecycleCallbacks.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z11 || next.mRecursive) {
                next.mCallback.onFragmentViewDestroyed(this.mFragmentManager, fragment);
            }
        }
    }

    public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z11) {
        this.mLifecycleCallbacks.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z11));
    }

    public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.mLifecycleCallbacks) {
            int size = this.mLifecycleCallbacks.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                } else if (this.mLifecycleCallbacks.get(i11).mCallback == fragmentLifecycleCallbacks) {
                    this.mLifecycleCallbacks.remove(i11);
                    break;
                } else {
                    i11++;
                }
            }
        }
    }
}
