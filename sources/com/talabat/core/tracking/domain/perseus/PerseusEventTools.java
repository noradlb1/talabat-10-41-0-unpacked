package com.talabat.core.tracking.domain.perseus;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H&J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H&J0\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/core/tracking/domain/perseus/PerseusEventTools;", "", "adaptEventName", "", "name", "params", "Landroid/os/Bundle;", "", "addPerseusParams", "eventName", "input", "", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PerseusEventTools {
    @NotNull
    String adaptEventName(@NotNull String str, @NotNull Bundle bundle);

    @NotNull
    String adaptEventName(@NotNull String str, @NotNull Map<String, ? extends Object> map);

    @NotNull
    Map<String, String> addPerseusParams(@NotNull String str, @NotNull Bundle bundle);

    @NotNull
    Map<String, String> addPerseusParams(@NotNull String str, @NotNull Map<String, String> map);
}
