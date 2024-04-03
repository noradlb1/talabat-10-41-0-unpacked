package org.junit.platform.engine.discovery;

import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ToStringBuilder;
import org.junit.platform.engine.DiscoverySelector;

@API(since = "1.1", status = API.Status.STABLE)
public class ModuleSelector implements DiscoverySelector {
    private final String moduleName;

    public ModuleSelector(String str) {
        this.moduleName = str;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.moduleName, ((ModuleSelector) obj).moduleName);
    }

    public String getModuleName() {
        return this.moduleName;
    }

    @API(since = "1.3", status = API.Status.STABLE)
    public int hashCode() {
        return this.moduleName.hashCode();
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("moduleName", this.moduleName).toString();
    }
}
