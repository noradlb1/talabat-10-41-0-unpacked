package com.talabat.talabatcommon.feature.walletCardManagement.di.module;

import com.talabat.helpers.GlobalDataModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DomainModule$selectedCountryIdProvider$1 extends Lambda implements Function0<Integer> {
    public static final DomainModule$selectedCountryIdProvider$1 INSTANCE = new DomainModule$selectedCountryIdProvider$1();

    public DomainModule$selectedCountryIdProvider$1() {
        super(0);
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(GlobalDataModel.SelectedCountryId);
    }
}
