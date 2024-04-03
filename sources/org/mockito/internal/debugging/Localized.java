package org.mockito.internal.debugging;

import org.mockito.invocation.Location;

public class Localized<T> {
    private final Location location = new LocationImpl();
    private final T object;

    public Localized(T t11) {
        this.object = t11;
    }

    public Location getLocation() {
        return this.location;
    }

    public T getObject() {
        return this.object;
    }
}
