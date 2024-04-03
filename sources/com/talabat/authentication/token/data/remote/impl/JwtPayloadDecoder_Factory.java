package com.talabat.authentication.token.data.remote.impl;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class JwtPayloadDecoder_Factory implements Factory<JwtPayloadDecoder> {
    private final Provider<Moshi> moshiProvider;

    public JwtPayloadDecoder_Factory(Provider<Moshi> provider) {
        this.moshiProvider = provider;
    }

    public static JwtPayloadDecoder_Factory create(Provider<Moshi> provider) {
        return new JwtPayloadDecoder_Factory(provider);
    }

    public static JwtPayloadDecoder newInstance(Moshi moshi) {
        return new JwtPayloadDecoder(moshi);
    }

    public JwtPayloadDecoder get() {
        return newInstance(this.moshiProvider.get());
    }
}
