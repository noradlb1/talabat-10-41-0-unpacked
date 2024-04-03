package org.junit.platform.engine.support.descriptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.TestSource;

@API(since = "1.0", status = API.Status.STABLE)
public class CompositeTestSource implements TestSource {
    private static final long serialVersionUID = 1;
    private final List<TestSource> sources;

    private CompositeTestSource(Collection<? extends TestSource> collection) {
        Preconditions.notEmpty(collection, "TestSource collection must not be null or empty");
        Preconditions.containsNoNullElements(collection, "individual TestSources must not be null");
        this.sources = Collections.unmodifiableList(new ArrayList(collection));
    }

    public static CompositeTestSource from(Collection<? extends TestSource> collection) {
        return new CompositeTestSource(collection);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.sources.equals(((CompositeTestSource) obj).sources);
    }

    public final List<TestSource> getSources() {
        return this.sources;
    }

    public int hashCode() {
        return this.sources.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("sources", this.sources).toString();
    }
}
