package com.talabat.core.parser.data;

import com.google.gson.Gson;
import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerParserCoreLibComponent {

    public static final class Builder {
        private Builder() {
        }

        public ParserCoreLibComponent build() {
            return new ParserCoreLibComponentImpl();
        }

        @Deprecated
        public Builder parserCoreLibModule(ParserCoreLibModule parserCoreLibModule) {
            Preconditions.checkNotNull(parserCoreLibModule);
            return this;
        }
    }

    public static final class ParserCoreLibComponentImpl implements ParserCoreLibComponent {
        private Provider<Gson> gsonProvider;
        private Provider<Moshi> moshiProvider;
        private final ParserCoreLibComponentImpl parserCoreLibComponentImpl;

        private ParserCoreLibComponentImpl() {
            this.parserCoreLibComponentImpl = this;
            initialize();
        }

        private void initialize() {
            this.gsonProvider = SingleCheck.provider(ParserCoreLibModule_GsonFactory.create());
            this.moshiProvider = SingleCheck.provider(ParserCoreLibModule_MoshiFactory.create());
        }

        public Gson getGson() {
            return this.gsonProvider.get();
        }

        public Moshi getMoshi() {
            return this.moshiProvider.get();
        }
    }

    private DaggerParserCoreLibComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ParserCoreLibComponent create() {
        return new Builder().build();
    }
}
