package com.talabat.feature.tokenization.data.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class NonEnglishNumbersMapper_Factory implements Factory<NonEnglishNumbersMapper> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final NonEnglishNumbersMapper_Factory INSTANCE = new NonEnglishNumbersMapper_Factory();

        private InstanceHolder() {
        }
    }

    public static NonEnglishNumbersMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NonEnglishNumbersMapper newInstance() {
        return new NonEnglishNumbersMapper();
    }

    public NonEnglishNumbersMapper get() {
        return newInstance();
    }
}
