package com.instabug.library.sessionV3.cache;

import com.instabug.library.model.v3Session.c0;
import com.instabug.library.model.v3Session.g;
import java.util.List;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SessionCacheManager {

    public static final class a {
        public static /* synthetic */ void a(SessionCacheManager sessionCacheManager, c0 c0Var, c0 c0Var2, List list, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    list = null;
                }
                sessionCacheManager.changeSyncStatus(c0Var, c0Var2, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeSyncStatus");
        }
    }

    void changeSyncStatus(@NotNull c0 c0Var, @NotNull c0 c0Var2, @Nullable List<String> list);

    void deleteAllSessions();

    void deleteSessionByID(@NotNull List<String> list);

    long insertOrUpdate(@NotNull g gVar);

    void migrateUUID(@NotNull String str, @NotNull String str2);

    @Nullable
    g queryLastSession();

    @NotNull
    List<g> querySessions(@Nullable c0 c0Var, @Nullable Integer num);

    @NotNull
    List<Pair<String, c0>> querySessionsIdsBySyncStatus(@NotNull c0... c0VarArr);

    void trimToLimit(int i11);

    void updateSessionDuration(@NotNull String str, long j11);
}
