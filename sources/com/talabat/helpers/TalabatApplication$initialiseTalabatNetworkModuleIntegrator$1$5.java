package com.talabat.helpers;

import datamodels.Token;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$5 extends Lambda implements Function0<String> {
    public static final TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$5 INSTANCE = new TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$5();

    public TalabatApplication$initialiseTalabatNetworkModuleIntegrator$1$5() {
        super(0);
    }

    @Nullable
    public final String invoke() {
        Token token = GlobalDataModel.token;
        if (token != null) {
            return token.access_token;
        }
        return null;
    }
}
