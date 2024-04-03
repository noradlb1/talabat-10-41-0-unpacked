package com.talabat.core.parser.data;

import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class ParserCoreLibModule_MoshiFactory implements Factory<Moshi> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ParserCoreLibModule_MoshiFactory INSTANCE = new ParserCoreLibModule_MoshiFactory();

        private InstanceHolder() {
        }
    }

    public static ParserCoreLibModule_MoshiFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Moshi moshi() {
        return (Moshi) Preconditions.checkNotNullFromProvides(ParserCoreLibModule.INSTANCE.moshi());
    }

    public Moshi get() {
        return moshi();
    }
}
