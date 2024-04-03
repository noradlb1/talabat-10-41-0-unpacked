package org.junit.platform.engine.discovery;

import com.newrelic.agent.android.agentdata.HexAttribute;
import java.util.Objects;
import n30.a;
import org.apiguardian.api.API;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.0", status = API.Status.STABLE)
public class ClassSelector implements DiscoverySelector {
    private final String className;
    private Class<?> javaClass;

    public ClassSelector(String str) {
        this.className = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ PreconditionViolationException lambda$getJavaClass$0(Exception exc) {
        return new PreconditionViolationException("Could not load class with name: " + this.className, exc);
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.className, ((ClassSelector) obj).className);
    }

    public String getClassName() {
        return this.className;
    }

    public Class<?> getJavaClass() {
        if (this.javaClass == null) {
            this.javaClass = ReflectionUtils.tryToLoadClass(this.className).getOrThrow(new a(this));
        }
        return this.javaClass;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return this.className.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append(HexAttribute.HEX_ATTR_CLASS_NAME, this.className).toString();
    }

    public ClassSelector(Class<?> cls) {
        this.className = cls.getName();
        this.javaClass = cls;
    }
}
