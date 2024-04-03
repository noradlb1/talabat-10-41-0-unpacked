package com.talabat.talabatcommon.helpers;

import com.talabat.talabatcommon.TalabatCommonIntegrationKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DynamicLocalizationKt$toLocalizedString$1 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f61734g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicLocalizationKt$toLocalizedString$1(int i11) {
        super(0);
        this.f61734g = i11;
    }

    @NotNull
    public final String invoke() {
        return DynamicLocalizationKt.a(TalabatCommonIntegrationKt.getAppContext(), this.f61734g, (Locale) null, 2, (Object) null);
    }
}
