package com.talabat.helpers;

import com.talabat.fluttercore.data.FlutterConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$setupFwfIntegrator$5 extends Lambda implements Function0<String> {
    public static final TalabatApplication$setupFwfIntegrator$5 INSTANCE = new TalabatApplication$setupFwfIntegrator$5();

    public TalabatApplication$setupFwfIntegrator$5() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        FlutterConstants.Companion companion = FlutterConstants.Companion;
        String str = GlobalDataModel.SelectedLanguage;
        Intrinsics.checkNotNullExpressionValue(str, "SelectedLanguage");
        return companion.selectedLanguage(str);
    }
}
