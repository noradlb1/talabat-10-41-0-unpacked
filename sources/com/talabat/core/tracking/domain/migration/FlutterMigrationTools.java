package com.talabat.core.tracking.domain.migration;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH&J,\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH&J&\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH&J4\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;", "", "addMigrationParameters", "", "", "methodName", "eventName", "input", "", "", "props", "logGaEvent", "params", "Landroid/os/Bundle;", "removeMigrationParameters", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FlutterMigrationTools {
    @NotNull
    Map<String, String> addMigrationParameters(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map);

    /* renamed from: addMigrationParameters  reason: collision with other method in class */
    void m9613addMigrationParameters(@NotNull String str, @NotNull String str2, @NotNull Map<String, Object> map);

    void logGaEvent(@NotNull String str, @NotNull Bundle bundle);

    void logGaEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map);

    @NotNull
    Map<String, Object> removeMigrationParameters(@NotNull String str, @NotNull Map<String, ? extends Object> map);

    void removeMigrationParameters(@NotNull String str, @NotNull Bundle bundle);
}
