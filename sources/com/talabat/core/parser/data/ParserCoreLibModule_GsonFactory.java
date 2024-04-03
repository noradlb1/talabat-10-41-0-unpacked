package com.talabat.core.parser.data;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata
public final class ParserCoreLibModule_GsonFactory implements Factory<Gson> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ParserCoreLibModule_GsonFactory INSTANCE = new ParserCoreLibModule_GsonFactory();

        private InstanceHolder() {
        }
    }

    public static ParserCoreLibModule_GsonFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Gson gson() {
        return (Gson) Preconditions.checkNotNullFromProvides(ParserCoreLibModule.INSTANCE.gson());
    }

    public Gson get() {
        return gson();
    }
}
