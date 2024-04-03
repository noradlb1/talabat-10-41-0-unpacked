package androidx.test.espresso;

import android.os.Looper;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class IdlingRegistry {
    private static final IdlingRegistry instance = new IdlingRegistry();
    private final Set<Looper> loopers = Collections.synchronizedSet(new HashSet());
    private final Set<IdlingResource> resources = Collections.synchronizedSet(new HashSet());

    public static IdlingRegistry getInstance() {
        return instance;
    }

    public Collection<Looper> getLoopers() {
        return new HashSet(this.loopers);
    }

    public Collection<IdlingResource> getResources() {
        return new HashSet(this.resources);
    }

    public boolean register(IdlingResource... idlingResourceArr) {
        if (idlingResourceArr != null) {
            return this.resources.addAll(Arrays.asList(idlingResourceArr));
        }
        throw new NullPointerException("idlingResources cannot be null!");
    }

    public void registerLooperAsIdlingResource(Looper looper) {
        if (looper == null) {
            throw new NullPointerException("looper cannot be null!");
        } else if (Looper.getMainLooper() != looper) {
            this.loopers.add(looper);
        } else {
            throw new IllegalArgumentException("Not intended for use with main looper!");
        }
    }

    public boolean unregister(IdlingResource... idlingResourceArr) {
        if (idlingResourceArr != null) {
            return this.resources.removeAll(Arrays.asList(idlingResourceArr));
        }
        throw new NullPointerException("idlingResources cannot be null!");
    }

    public boolean unregisterLooperAsIdlingResource(Looper looper) {
        if (looper != null) {
            return this.loopers.remove(looper);
        }
        throw new NullPointerException("looper cannot be null!");
    }
}
