package com.talabat.talabatcommon;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatCommonIntegrationKt$SelectedLocaleRetriever$1 extends Lambda implements Function0<Locale> {
    public static final TalabatCommonIntegrationKt$SelectedLocaleRetriever$1 INSTANCE = new TalabatCommonIntegrationKt$SelectedLocaleRetriever$1();

    public TalabatCommonIntegrationKt$SelectedLocaleRetriever$1() {
        super(0);
    }

    public final Locale invoke() {
        return Locale.getDefault();
    }
}
