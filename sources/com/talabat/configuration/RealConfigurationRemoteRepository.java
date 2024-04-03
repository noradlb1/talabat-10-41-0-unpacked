package com.talabat.configuration;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.configuration.di.AppInfoRest;
import com.talabat.configuration.remote.ConfigurationRemoteRest;
import com.talabat.configuration.remote.mapper.AppRemoteConfigMapper;
import com.talabat.configuration.remote.model.AppInfoEntity;
import com.talabat.configuration.remote.model.RootAppInfoEntity;
import dagger.Reusable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR?\u0010\u0010\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012 \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/talabat/configuration/RealConfigurationRemoteRepository;", "Lcom/talabat/configuration/MutableConfigurationRemoteRepository;", "Lcom/talabat/configuration/AppInfoContainer;", "appInfoRemote", "Lcom/talabat/configuration/remote/ConfigurationRemoteRest;", "appRemoteConfigMapper", "Lcom/talabat/configuration/remote/mapper/AppRemoteConfigMapper;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/talabat/configuration/remote/ConfigurationRemoteRest;Lcom/talabat/configuration/remote/mapper/AppRemoteConfigMapper;Lcom/squareup/moshi/Moshi;)V", "cachedAppInfoEntity", "Lcom/talabat/configuration/remote/model/AppInfoEntity;", "getCachedAppInfoEntity", "()Lcom/talabat/configuration/remote/model/AppInfoEntity;", "setCachedAppInfoEntity", "(Lcom/talabat/configuration/remote/model/AppInfoEntity;)V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/remote/model/RootAppInfoEntity;", "kotlin.jvm.PlatformType", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "jsonAdapter$delegate", "Lkotlin/Lazy;", "appRemoteConfig", "Lcom/talabat/configuration/AppRemoteConfig;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCachedAppRemoteConfig", "", "appRemoteConfigJson", "", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Reusable
public final class RealConfigurationRemoteRepository implements MutableConfigurationRemoteRepository, AppInfoContainer {
    @NotNull
    private final ConfigurationRemoteRest appInfoRemote;
    @NotNull
    private final AppRemoteConfigMapper appRemoteConfigMapper;
    @Nullable
    private AppInfoEntity cachedAppInfoEntity;
    @NotNull
    private final Lazy jsonAdapter$delegate;

    @Inject
    public RealConfigurationRemoteRepository(@AppInfoRest @NotNull ConfigurationRemoteRest configurationRemoteRest, @NotNull AppRemoteConfigMapper appRemoteConfigMapper2, @NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(configurationRemoteRest, "appInfoRemote");
        Intrinsics.checkNotNullParameter(appRemoteConfigMapper2, "appRemoteConfigMapper");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.appInfoRemote = configurationRemoteRest;
        this.appRemoteConfigMapper = appRemoteConfigMapper2;
        this.jsonAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new RealConfigurationRemoteRepository$jsonAdapter$2(moshi));
    }

    private final JsonAdapter<RootAppInfoEntity> getJsonAdapter() {
        return (JsonAdapter) this.jsonAdapter$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object appRemoteConfig(int r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.configuration.AppRemoteConfig> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.configuration.RealConfigurationRemoteRepository$appRemoteConfig$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.configuration.RealConfigurationRemoteRepository$appRemoteConfig$1 r0 = (com.talabat.configuration.RealConfigurationRemoteRepository$appRemoteConfig$1) r0
            int r1 = r0.f55764k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55764k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.configuration.RealConfigurationRemoteRepository$appRemoteConfig$1 r0 = new com.talabat.configuration.RealConfigurationRemoteRepository$appRemoteConfig$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f55762i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55764k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f55761h
            com.talabat.configuration.RealConfigurationRemoteRepository r5 = (com.talabat.configuration.RealConfigurationRemoteRepository) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0046
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.configuration.remote.ConfigurationRemoteRest r6 = r4.appInfoRemote
            r0.f55761h = r4
            r0.f55764k = r3
            java.lang.Object r6 = r6.appinfo(r5, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r5 = r4
        L_0x0046:
            com.talabat.configuration.remote.model.AppInfoEntity r6 = (com.talabat.configuration.remote.model.AppInfoEntity) r6
            r5.setCachedAppInfoEntity(r6)
            com.talabat.configuration.remote.mapper.AppRemoteConfigMapper r5 = r5.appRemoteConfigMapper
            com.talabat.configuration.AppRemoteConfig r5 = r5.apply((com.talabat.configuration.remote.model.AppInfoEntity) r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.RealConfigurationRemoteRepository.appRemoteConfig(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public AppInfoEntity getCachedAppInfoEntity() {
        return this.cachedAppInfoEntity;
    }

    public void setCachedAppInfoEntity(@Nullable AppInfoEntity appInfoEntity) {
        this.cachedAppInfoEntity = appInfoEntity;
    }

    public void setCachedAppRemoteConfig(@Nullable String str) {
        RootAppInfoEntity rootAppInfoEntity;
        AppInfoEntity appInfoEntity = null;
        if (str != null) {
            JsonAdapter<RootAppInfoEntity> jsonAdapter = getJsonAdapter();
            Intrinsics.checkNotNullExpressionValue(jsonAdapter, "jsonAdapter");
            rootAppInfoEntity = jsonAdapter.fromJson(str);
        } else {
            rootAppInfoEntity = null;
        }
        if (rootAppInfoEntity != null) {
            appInfoEntity = rootAppInfoEntity.getAppInfoEntity();
        }
        setCachedAppInfoEntity(appInfoEntity);
    }
}
