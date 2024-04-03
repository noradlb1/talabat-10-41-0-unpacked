package com.talabat.splash.data.preferences;

import android.content.SharedPreferences;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.MutableConfigurationRemoteRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.splash.domain.model.AppInfoResponseWrapper;
import com.talabat.talabatcore.logger.LogManager;
import javax.inject.Inject;
import kotlin.ExperimentalStdlibApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/splash/data/preferences/AppInfoLocalDataSourceImp;", "Lcom/talabat/splash/data/preferences/AppInfoLocalDataSource;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "sharedPreferences", "Landroid/content/SharedPreferences;", "mutableConfigurationRemoteRepository", "Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/talabat/configuration/discovery/AppVersionProvider;Landroid/content/SharedPreferences;Lcom/talabat/configuration/MutableConfigurationRemoteRepository;Lcom/squareup/moshi/Moshi;)V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/splash/domain/model/AppInfoResponseWrapper;", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "jsonAdapter$delegate", "Lkotlin/Lazy;", "cacheAppInfo", "", "appInfoResponseWrapper", "getAppInfo", "invalidateAppInfoCache", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalStdlibApi
public final class AppInfoLocalDataSourceImp implements AppInfoLocalDataSource {
    @NotNull
    @Deprecated
    private static final String APP_INFO_PREFERENCE_INVALIDATED_ONCE_KEY = "app_info_preference_invalidated_once_key";
    @NotNull
    @Deprecated
    private static final String APP_INFO_PREFERENCE_KEY = "appInfoPreferenceKey";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Lazy jsonAdapter$delegate;
    @NotNull
    private final MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository;
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/splash/data/preferences/AppInfoLocalDataSourceImp$Companion;", "", "()V", "APP_INFO_PREFERENCE_INVALIDATED_ONCE_KEY", "", "APP_INFO_PREFERENCE_KEY", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AppInfoLocalDataSourceImp(@NotNull AppVersionProvider appVersionProvider, @NotNull SharedPreferences sharedPreferences2, @NotNull MutableConfigurationRemoteRepository mutableConfigurationRemoteRepository2, @NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(mutableConfigurationRemoteRepository2, "mutableConfigurationRemoteRepository");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.sharedPreferences = sharedPreferences2;
        this.mutableConfigurationRemoteRepository = mutableConfigurationRemoteRepository2;
        this.jsonAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new AppInfoLocalDataSourceImp$jsonAdapter$2(moshi));
        Long compareVersionTo = appVersionProvider.compareVersionTo("9.10");
        if (compareVersionTo != null) {
            long longValue = compareVersionTo.longValue();
            if (longValue >= 0 && !sharedPreferences2.getBoolean(APP_INFO_PREFERENCE_INVALIDATED_ONCE_KEY, false)) {
                SharedPreferences.Editor edit = sharedPreferences2.edit();
                Intrinsics.checkNotNullExpressionValue(edit, "editor");
                edit.putBoolean(APP_INFO_PREFERENCE_INVALIDATED_ONCE_KEY, true);
                edit.remove(APP_INFO_PREFERENCE_KEY);
                edit.apply();
                mutableConfigurationRemoteRepository2.setCachedAppRemoteConfig((String) null);
                LogManager.info("App Info cache has been invalidated! comp=" + longValue);
            }
        }
    }

    private final JsonAdapter<AppInfoResponseWrapper> getJsonAdapter() {
        return (JsonAdapter) this.jsonAdapter$delegate.getValue();
    }

    public void cacheAppInfo(@NotNull AppInfoResponseWrapper appInfoResponseWrapper) {
        Intrinsics.checkNotNullParameter(appInfoResponseWrapper, "appInfoResponseWrapper");
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        String json = getJsonAdapter().toJson(appInfoResponseWrapper);
        edit.putString(APP_INFO_PREFERENCE_KEY, json);
        edit.apply();
        this.mutableConfigurationRemoteRepository.setCachedAppRemoteConfig(json);
    }

    @Nullable
    public AppInfoResponseWrapper getAppInfo() {
        boolean z11;
        String string = this.sharedPreferences.getString(APP_INFO_PREFERENCE_KEY, (String) null);
        if (string == null || string.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        this.mutableConfigurationRemoteRepository.setCachedAppRemoteConfig(string);
        return getJsonAdapter().fromJson(string);
    }

    public void invalidateAppInfoCache() {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.remove(APP_INFO_PREFERENCE_KEY);
        edit.apply();
        this.mutableConfigurationRemoteRepository.setCachedAppRemoteConfig((String) null);
    }
}
