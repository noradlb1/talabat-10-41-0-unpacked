package com.deliveryhero.perseus.logger;

import com.deliveryhero.perseus.BuildConfig;
import com.deliveryhero.perseus.PerseusParamsConfig;
import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.deliveryhero.perseus.core.session.AppSessionManager;
import com.deliveryhero.perseus.data.local.PerseusConfigLocalDataStore;
import com.deliveryhero.perseus.data.local.PerseusHitsLocalDataStore;
import com.deliveryhero.perseus.data.local.PerseusUserLocalDataStore;
import com.deliveryhero.perseus.data.local.db.entity.DatabaseEventInfo;
import com.deliveryhero.perseus.data.remote.api.PerseusLoggerApi;
import com.deliveryhero.perseus.data.remote.api.model.BackLogInfoRequest;
import com.deliveryhero.perseus.utils.TimeHelperKt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y5.a;
import y5.b;

@Instrumented
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0012H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/perseus/logger/DatabaseInfoLogger;", "", "configurationProvider", "Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "sessionManager", "Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "userLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;", "configLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStore;", "hitsLocalDataStore", "Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStore;", "api", "Lcom/deliveryhero/perseus/data/remote/api/PerseusLoggerApi;", "logger", "Lcom/deliveryhero/perseus/logger/PerseusLogger;", "(Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;Lcom/deliveryhero/perseus/core/session/AppSessionManager;Lcom/deliveryhero/perseus/data/local/PerseusUserLocalDataStore;Lcom/deliveryhero/perseus/data/local/PerseusConfigLocalDataStore;Lcom/deliveryhero/perseus/data/local/PerseusHitsLocalDataStore;Lcom/deliveryhero/perseus/data/remote/api/PerseusLoggerApi;Lcom/deliveryhero/perseus/logger/PerseusLogger;)V", "createBacklogInfoRequest", "Lcom/deliveryhero/perseus/data/remote/api/model/BackLogInfoRequest;", "clock", "Ljava/util/Calendar;", "numberOfDeletedStaleEvents", "", "(Ljava/util/Calendar;Ljava/lang/Integer;)Lcom/deliveryhero/perseus/data/remote/api/model/BackLogInfoRequest;", "logBacklogInfo", "Lio/reactivex/Completable;", "(Ljava/lang/Integer;Ljava/util/Calendar;)Lio/reactivex/Completable;", "logLocal", "", "infoRequest", "logRemote", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseInfoLogger {
    @NotNull
    private final PerseusLoggerApi api;
    @NotNull
    private final PerseusConfigLocalDataStore configLocalDataStore;
    @NotNull
    private final PerseusConfigProvider configurationProvider;
    @NotNull
    private final PerseusHitsLocalDataStore hitsLocalDataStore;
    @NotNull
    private final PerseusLogger logger;
    @NotNull
    private final AppSessionManager sessionManager;
    @NotNull
    private final PerseusUserLocalDataStore userLocalDataStore;

    public DatabaseInfoLogger(@NotNull PerseusConfigProvider perseusConfigProvider, @NotNull AppSessionManager appSessionManager, @NotNull PerseusUserLocalDataStore perseusUserLocalDataStore, @NotNull PerseusConfigLocalDataStore perseusConfigLocalDataStore, @NotNull PerseusHitsLocalDataStore perseusHitsLocalDataStore, @NotNull PerseusLoggerApi perseusLoggerApi, @NotNull PerseusLogger perseusLogger) {
        Intrinsics.checkNotNullParameter(perseusConfigProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(appSessionManager, "sessionManager");
        Intrinsics.checkNotNullParameter(perseusUserLocalDataStore, "userLocalDataStore");
        Intrinsics.checkNotNullParameter(perseusConfigLocalDataStore, "configLocalDataStore");
        Intrinsics.checkNotNullParameter(perseusHitsLocalDataStore, "hitsLocalDataStore");
        Intrinsics.checkNotNullParameter(perseusLoggerApi, "api");
        Intrinsics.checkNotNullParameter(perseusLogger, "logger");
        this.configurationProvider = perseusConfigProvider;
        this.sessionManager = appSessionManager;
        this.userLocalDataStore = perseusUserLocalDataStore;
        this.configLocalDataStore = perseusConfigLocalDataStore;
        this.hitsLocalDataStore = perseusHitsLocalDataStore;
        this.api = perseusLoggerApi;
        this.logger = perseusLogger;
    }

    public static /* synthetic */ BackLogInfoRequest createBacklogInfoRequest$default(DatabaseInfoLogger databaseInfoLogger, Calendar calendar, Integer num, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        return databaseInfoLogger.createBacklogInfoRequest(calendar, num);
    }

    public static /* synthetic */ Completable logBacklogInfo$default(DatabaseInfoLogger databaseInfoLogger, Integer num, Calendar calendar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        }
        return databaseInfoLogger.logBacklogInfo(num, calendar);
    }

    /* access modifiers changed from: private */
    public static final BackLogInfoRequest logBacklogInfo$lambda$0(DatabaseInfoLogger databaseInfoLogger, Calendar calendar, Integer num) {
        Intrinsics.checkNotNullParameter(databaseInfoLogger, "this$0");
        Intrinsics.checkNotNullParameter(calendar, "$clock");
        return databaseInfoLogger.createBacklogInfoRequest(calendar, num);
    }

    /* access modifiers changed from: private */
    public static final CompletableSource logBacklogInfo$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (CompletableSource) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void logLocal(BackLogInfoRequest backLogInfoRequest) {
        String str;
        Gson create = new GsonBuilder().setPrettyPrinting().create();
        PerseusLogger perseusLogger = this.logger;
        if (!(create instanceof Gson)) {
            str = create.toJson((Object) backLogInfoRequest);
        } else {
            str = GsonInstrumentation.toJson(create, (Object) backLogInfoRequest);
        }
        Intrinsics.checkNotNullExpressionValue(str, "gson.toJson(infoRequest)");
        PerseusLogger.i$default(perseusLogger, str, (Throwable) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Completable logRemote(BackLogInfoRequest backLogInfoRequest) {
        return this.api.logBackInfo(backLogInfoRequest);
    }

    @NotNull
    public final BackLogInfoRequest createBacklogInfoRequest(@NotNull Calendar calendar, @Nullable Integer num) {
        long j11;
        Intrinsics.checkNotNullParameter(calendar, "clock");
        Object clone = calendar.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) clone;
        PerseusParamsConfig provideConfig = this.configurationProvider.provideConfig();
        DatabaseEventInfo databaseEventInfo = this.hitsLocalDataStore.databaseEventInfo();
        long batchDispatchHitsDelay = this.configLocalDataStore.getBatchDispatchHitsDelay();
        if (databaseEventInfo.getBacklogSize() > 0) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            j11 = timeUnit.toSeconds(calendar2.getTimeInMillis()) - timeUnit.toSeconds(databaseEventInfo.getOldestMessageTimestamp());
        } else {
            j11 = 0;
        }
        return new BackLogInfoRequest(TimeHelperKt.createTimeStamp(calendar2), provideConfig.getEntity(), databaseEventInfo.getBacklogSize(), j11, num, batchDispatchHitsDelay, provideConfig.getBatchSize(), provideConfig.getAppVersionName(), "Android", provideConfig.getCountryCode(), provideConfig.getGlobalEntityId(), BuildConfig.VERSION_NAME, this.sessionManager.getUserSessionId(), this.userLocalDataStore.getClientId());
    }

    @NotNull
    public final Completable logBacklogInfo(@Nullable Integer num, @NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "clock");
        Completable flatMapCompletable = Single.fromCallable(new a(this, calendar, num)).flatMapCompletable(new b(new DatabaseInfoLogger$logBacklogInfo$2(this.configurationProvider.provideConfig(), this)));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "fun logBacklogInfo(\n    …uest)\n            }\n    }");
        return flatMapCompletable;
    }
}
