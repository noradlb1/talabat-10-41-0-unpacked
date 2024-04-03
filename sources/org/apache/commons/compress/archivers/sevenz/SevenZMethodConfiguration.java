package org.apache.commons.compress.archivers.sevenz;

import java.util.Objects;

public class SevenZMethodConfiguration {
    private final SevenZMethod method;
    private final Object options;

    public SevenZMethodConfiguration(SevenZMethod sevenZMethod) {
        this(sevenZMethod, (Object) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SevenZMethodConfiguration sevenZMethodConfiguration = (SevenZMethodConfiguration) obj;
        if (!Objects.equals(this.method, sevenZMethodConfiguration.method) || !Objects.equals(this.options, sevenZMethodConfiguration.options)) {
            return false;
        }
        return true;
    }

    public SevenZMethod getMethod() {
        return this.method;
    }

    public Object getOptions() {
        return this.options;
    }

    public int hashCode() {
        SevenZMethod sevenZMethod = this.method;
        if (sevenZMethod == null) {
            return 0;
        }
        return sevenZMethod.hashCode();
    }

    public SevenZMethodConfiguration(SevenZMethod sevenZMethod, Object obj) {
        this.method = sevenZMethod;
        this.options = obj;
        if (obj != null && !Coders.c(sevenZMethod).a(obj)) {
            throw new IllegalArgumentException("The " + sevenZMethod + " method doesn't support options of type " + obj.getClass());
        }
    }
}
