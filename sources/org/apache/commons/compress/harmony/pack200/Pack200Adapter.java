package org.apache.commons.compress.harmony.pack200;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.compress.java.util.jar.Pack200;

public abstract class Pack200Adapter {
    protected static final int DEFAULT_BUFFER_SIZE = 8192;
    private final SortedMap<String, String> properties = new TreeMap();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.support.addPropertyChangeListener(propertyChangeListener);
    }

    public void completed(double d11) {
        firePropertyChange(Pack200.Packer.PROGRESS, (Object) null, String.valueOf((int) (d11 * 100.0d)));
    }

    public void firePropertyChange(String str, Object obj, Object obj2) {
        this.support.firePropertyChange(str, obj, obj2);
    }

    public SortedMap<String, String> properties() {
        return this.properties;
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.support.removePropertyChangeListener(propertyChangeListener);
    }
}
