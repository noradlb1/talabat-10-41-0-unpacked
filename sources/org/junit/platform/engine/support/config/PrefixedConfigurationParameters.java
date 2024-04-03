package org.junit.platform.engine.support.config;

import j$.util.Optional;
import j$.util.function.Function;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.ConfigurationParameters;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public class PrefixedConfigurationParameters implements ConfigurationParameters {
    private final ConfigurationParameters delegate;
    private final String prefix;

    public PrefixedConfigurationParameters(ConfigurationParameters configurationParameters, String str) {
        this.delegate = (ConfigurationParameters) Preconditions.notNull(configurationParameters, "delegate must not be null");
        this.prefix = Preconditions.notBlank(str, "prefix must not be null or blank");
    }

    private String prefixed(String str) {
        return this.prefix + str;
    }

    public Optional<String> get(String str) {
        return this.delegate.get(prefixed(str));
    }

    public Optional<Boolean> getBoolean(String str) {
        return this.delegate.getBoolean(prefixed(str));
    }

    public Set<String> keySet() {
        return this.delegate.keySet();
    }

    public int size() {
        return this.delegate.size();
    }

    public <T> Optional<T> get(String str, Function<String, T> function) {
        return this.delegate.get(prefixed(str), function);
    }
}
