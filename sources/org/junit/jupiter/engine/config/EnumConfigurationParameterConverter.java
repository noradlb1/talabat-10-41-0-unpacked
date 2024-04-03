package org.junit.jupiter.engine.config;

import c30.l;
import c30.m;
import c30.n;
import j$.util.Optional;
import j$.util.function.Function;
import java.lang.Enum;
import java.util.Locale;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.ConfigurationParameters;

@API(since = "5.8", status = API.Status.INTERNAL)
public class EnumConfigurationParameterConverter<E extends Enum<E>> {
    private static final Logger logger = LoggerFactory.getLogger(EnumConfigurationParameterConverter.class);
    private final String enumDisplayName;
    private final Class<E> enumType;

    public EnumConfigurationParameterConverter(Class<E> cls, String str) {
        this.enumType = cls;
        this.enumDisplayName = str;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$get$0(Enum enumR, String str) {
        return String.format("Using %s '%s' set via the '%s' configuration parameter.", new Object[]{this.enumDisplayName, enumR, str});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String lambda$get$1(String str, String str2, Enum enumR) {
        return String.format("Invalid %s '%s' set via the '%s' configuration parameter. Falling back to the %s default value.", new Object[]{this.enumDisplayName, str, str2, enumR.name()});
    }

    public E c(ConfigurationParameters configurationParameters, String str, E e11) {
        Preconditions.notNull(configurationParameters, "ConfigurationParameters must not be null");
        Objects.requireNonNull(configurationParameters);
        return get(str, new n(configurationParameters), e11);
    }

    public E get(String str, Function<String, Optional<String>> function, E e11) {
        Optional apply = function.apply(str);
        if (apply.isPresent()) {
            String str2 = null;
            try {
                str2 = ((String) apply.get()).trim().toUpperCase(Locale.ROOT);
                E valueOf = Enum.valueOf(this.enumType, str2);
                logger.config(new l(this, valueOf, str));
                return valueOf;
            } catch (Exception unused) {
                logger.warn(new m(this, str2, str, e11));
            }
        }
        return e11;
    }
}
