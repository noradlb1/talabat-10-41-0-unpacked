package org.junit.platform.engine.support.hierarchical;

import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public class ExclusiveResource {
    @API(since = "1.7", status = API.Status.EXPERIMENTAL)
    public static final String GLOBAL_KEY = "org.junit.platform.engine.support.hierarchical.ExclusiveResource.GLOBAL_KEY";

    /* renamed from: a  reason: collision with root package name */
    public static final ExclusiveResource f28069a = new ExclusiveResource("org.junit.platform.engine.support.hierarchical.ExclusiveResource.GLOBAL_KEY", LockMode.READ);

    /* renamed from: b  reason: collision with root package name */
    public static final ExclusiveResource f28070b = new ExclusiveResource("org.junit.platform.engine.support.hierarchical.ExclusiveResource.GLOBAL_KEY", LockMode.READ_WRITE);
    private int hash;
    private final String key;
    private final LockMode lockMode;

    public enum LockMode {
        READ_WRITE,
        READ
    }

    public ExclusiveResource(String str, LockMode lockMode2) {
        this.key = Preconditions.notBlank(str, "key must not be blank");
        this.lockMode = (LockMode) Preconditions.notNull(lockMode2, "lockMode must not be null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExclusiveResource exclusiveResource = (ExclusiveResource) obj;
        if (!Objects.equals(this.key, exclusiveResource.key) || this.lockMode != exclusiveResource.lockMode) {
            return false;
        }
        return true;
    }

    public String getKey() {
        return this.key;
    }

    public LockMode getLockMode() {
        return this.lockMode;
    }

    public int hashCode() {
        int i11 = this.hash;
        if (i11 != 0) {
            return i11;
        }
        int hash2 = Objects.hash(new Object[]{this.key, this.lockMode});
        this.hash = hash2;
        return hash2;
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("key", this.key).append("lockMode", this.lockMode).toString();
    }
}
