package com.talabat.talabatcommon.helpers;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.TalabatCommonIntegrationKt;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0001\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0002¨\u0006\u000b"}, d2 = {"getLocaleStringResource", "", "Landroid/content/Context;", "resourceId", "", "requestedLocale", "Ljava/util/Locale;", "toLocalizedString", "defaultValue", "updateLocale", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DynamicLocalizationKt {
    public static /* synthetic */ String a(Context context, int i11, Locale locale, int i12, Object obj) throws Resources.NotFoundException {
        if ((i12 & 2) != 0) {
            Locale invoke = TalabatCommonIntegrationKt.getSelectedLocaleRetriever().invoke();
            Intrinsics.checkNotNullExpressionValue(invoke, "SelectedLocaleRetriever()");
            locale = invoke;
        }
        return getLocaleStringResource(context, i11, locale);
    }

    private static final String getLocaleStringResource(Context context, int i11, Locale locale) throws Resources.NotFoundException {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration).getText(i11).toString();
    }

    @NotNull
    public static final String toLocalizedString(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        String str2 = (String) CoroutinesKt.returnHandling$default((Function1) null, (Object) null, new DynamicLocalizationKt$toLocalizedString$1(i11), 3, (Object) null);
        if (str2 == null) {
            return str;
        }
        return str2;
    }

    public static /* synthetic */ String toLocalizedString$default(int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = String.valueOf(i11);
        }
        return toLocalizedString(i11, str);
    }

    public static final void updateLocale(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TalabatUtils.changeLocale(context, GlobalDataModel.SelectedLanguage);
    }
}
