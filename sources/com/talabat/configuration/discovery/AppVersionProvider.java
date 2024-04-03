package com.talabat.configuration.discovery;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/configuration/discovery/AppVersionProvider;", "", "appVersion", "", "compareVersionTo", "", "other", "(Ljava/lang/String;)Ljava/lang/Long;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AppVersionProvider {
    @Nullable
    String appVersion();

    @Nullable
    Long compareVersionTo(@NotNull String str);
}
