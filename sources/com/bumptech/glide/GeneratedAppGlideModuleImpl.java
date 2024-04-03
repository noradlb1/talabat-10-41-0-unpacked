package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule;
import com.talabat.talabatcommon.helpers.TalabatGlideModule;
import java.util.Collections;
import java.util.Set;

final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
    private final TalabatGlideModule appGlideModule = new TalabatGlideModule();

    public GeneratedAppGlideModuleImpl(Context context) {
        Log.isLoggable("Glide", 3);
    }

    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        this.appGlideModule.applyOptions(context, glideBuilder);
    }

    @NonNull
    public Set<Class<?>> getExcludedModuleClasses() {
        return Collections.emptySet();
    }

    public boolean isManifestParsingEnabled() {
        return this.appGlideModule.isManifestParsingEnabled();
    }

    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        new OkHttpLibraryGlideModule().registerComponents(context, glide, registry);
        this.appGlideModule.registerComponents(context, glide, registry);
    }

    @NonNull
    public GeneratedRequestManagerFactory getRequestManagerFactory() {
        return new GeneratedRequestManagerFactory();
    }
}
