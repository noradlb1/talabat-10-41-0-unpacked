package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Supplier;
import java.math.BigDecimal;
import java.util.Locale;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.engine.ConfigurationParameters;
import r30.a;
import r30.b;

@API(since = "1.3", status = API.Status.EXPERIMENTAL)
public enum DefaultParallelExecutionConfigurationStrategy implements ParallelExecutionConfigurationStrategy {
    FIXED {
        /* access modifiers changed from: private */
        public static /* synthetic */ JUnitException lambda$createConfiguration$0() {
            return new JUnitException(String.format("Configuration parameter '%s' must be set", new Object[]{DefaultParallelExecutionConfigurationStrategy.CONFIG_FIXED_PARALLELISM_PROPERTY_NAME}));
        }

        public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
            int intValue = ((Integer) configurationParameters.get(DefaultParallelExecutionConfigurationStrategy.CONFIG_FIXED_PARALLELISM_PROPERTY_NAME, new a()).orElseThrow(new a())).intValue();
            return new DefaultParallelExecutionConfiguration(intValue, intValue, intValue + 256, intValue, 30);
        }
    },
    DYNAMIC {
        public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
            boolean z11;
            BigDecimal bigDecimal = (BigDecimal) configurationParameters.get(DefaultParallelExecutionConfigurationStrategy.CONFIG_DYNAMIC_FACTOR_PROPERTY_NAME, new b()).orElse(BigDecimal.ONE);
            if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.condition(z11, (Supplier<String>) new b(bigDecimal));
            int max = Math.max(1, bigDecimal.multiply(BigDecimal.valueOf((long) Runtime.getRuntime().availableProcessors())).intValue());
            return new DefaultParallelExecutionConfiguration(max, max, max + 256, max, 30);
        }
    },
    CUSTOM {
        /* access modifiers changed from: private */
        public static /* synthetic */ JUnitException lambda$createConfiguration$0() {
            return new JUnitException("custom.class must be set");
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ParallelExecutionConfigurationStrategy lambda$createConfiguration$1(Class cls) throws Exception {
            Class<ParallelExecutionConfigurationStrategy> cls2 = ParallelExecutionConfigurationStrategy.class;
            boolean isAssignableFrom = cls2.isAssignableFrom(cls);
            Preconditions.condition(isAssignableFrom, "custom.class does not implement " + cls2);
            return (ParallelExecutionConfigurationStrategy) ReflectionUtils.newInstance(cls, new Object[0]);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ JUnitException lambda$createConfiguration$3(String str, Exception exc) {
            return new JUnitException("Could not create configuration for strategy class: " + str, exc);
        }

        public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
            String orElseThrow = configurationParameters.get(DefaultParallelExecutionConfigurationStrategy.CONFIG_CUSTOM_CLASS_PROPERTY_NAME).orElseThrow(new c());
            return (ParallelExecutionConfiguration) ReflectionUtils.tryToLoadClass(orElseThrow).andThenTry(new d()).andThenTry(new e(configurationParameters)).getOrThrow(new f(orElseThrow));
        }
    };
    
    public static final String CONFIG_CUSTOM_CLASS_PROPERTY_NAME = "custom.class";
    public static final String CONFIG_DYNAMIC_FACTOR_PROPERTY_NAME = "dynamic.factor";
    public static final String CONFIG_FIXED_PARALLELISM_PROPERTY_NAME = "fixed.parallelism";
    public static final String CONFIG_STRATEGY_PROPERTY_NAME = "strategy";
    private static final int KEEP_ALIVE_SECONDS = 30;

    public static ParallelExecutionConfigurationStrategy a(ConfigurationParameters configurationParameters) {
        return valueOf(configurationParameters.get(CONFIG_STRATEGY_PROPERTY_NAME).orElse("dynamic").toUpperCase(Locale.ROOT));
    }
}
