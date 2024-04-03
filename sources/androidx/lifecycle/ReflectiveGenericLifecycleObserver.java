package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;

@Deprecated
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {
    private final ClassesInfoCache.CallbackInfo mInfo;
    private final Object mWrapped;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.mWrapped = obj;
        this.mInfo = ClassesInfoCache.f35975a.a(obj.getClass());
    }

    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.mInfo.a(lifecycleOwner, event, this.mWrapped);
    }
}
