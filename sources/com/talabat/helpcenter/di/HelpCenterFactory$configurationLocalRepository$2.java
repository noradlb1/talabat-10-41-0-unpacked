package com.talabat.helpcenter.di;

import com.talabat.configuration.LegacyConfigurationLocalRepository;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/configuration/LegacyConfigurationLocalRepository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterFactory$configurationLocalRepository$2 extends Lambda implements Function0<LegacyConfigurationLocalRepository> {
    public static final HelpCenterFactory$configurationLocalRepository$2 INSTANCE = new HelpCenterFactory$configurationLocalRepository$2();

    public HelpCenterFactory$configurationLocalRepository$2() {
        super(0);
    }

    @NotNull
    public final LegacyConfigurationLocalRepository invoke() {
        return new LegacyConfigurationLocalRepository();
    }
}
