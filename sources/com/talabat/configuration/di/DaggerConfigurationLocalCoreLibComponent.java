package com.talabat.configuration.di;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.LegacyConfigurationLocalRepository;
import com.talabat.configuration.LegacyConfigurationLocalRepository_Factory;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerConfigurationLocalCoreLibComponent {

    public static final class Builder {
        private Builder() {
        }

        public ConfigurationLocalCoreLibComponent build() {
            return new ConfigurationLocalCoreLibComponentImpl();
        }
    }

    public static final class ConfigurationLocalCoreLibComponentImpl implements ConfigurationLocalCoreLibComponent {
        private final ConfigurationLocalCoreLibComponentImpl configurationLocalCoreLibComponentImpl;
        private Provider<LegacyConfigurationLocalRepository> legacyConfigurationLocalRepositoryProvider;

        private ConfigurationLocalCoreLibComponentImpl() {
            this.configurationLocalCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.legacyConfigurationLocalRepositoryProvider = SingleCheck.provider(LegacyConfigurationLocalRepository_Factory.create());
        }

        public MutableConfigurationLocalRepository getMutableRepository() {
            return this.legacyConfigurationLocalRepositoryProvider.get();
        }

        public ConfigurationLocalRepository getRepository() {
            return this.legacyConfigurationLocalRepositoryProvider.get();
        }
    }

    private DaggerConfigurationLocalCoreLibComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ConfigurationLocalCoreLibComponent create() {
        return new Builder().build();
    }
}
