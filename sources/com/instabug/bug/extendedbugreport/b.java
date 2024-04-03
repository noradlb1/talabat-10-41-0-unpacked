package com.instabug.bug.extendedbugreport;

import android.content.Context;
import com.instabug.bug.R;
import com.instabug.bug.model.e;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.LocaleUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class b {
    public static List a(Context context, a aVar) {
        return a(context, aVar == a.ENABLED_WITH_REQUIRED_FIELDS);
    }

    private static List a(Context context, boolean z11) {
        ArrayList arrayList = new ArrayList();
        Locale locale = InstabugCore.getLocale(context);
        int i11 = R.string.instabug_str_steps_to_reproduce;
        String localeStringResource = LocaleUtils.getLocaleStringResource(locale, i11, context);
        Locale locale2 = Locale.ENGLISH;
        e eVar = new e(localeStringResource, LocaleUtils.getLocaleStringResource(locale2, i11, context), z11, "repro_steps");
        eVar.a(R.string.ibg_extended_report_steps_to_reproduce_edit_text_description);
        arrayList.add(eVar);
        Locale locale3 = InstabugCore.getLocale(context);
        int i12 = R.string.instabug_str_actual_results;
        e eVar2 = new e(LocaleUtils.getLocaleStringResource(locale3, i12, context), LocaleUtils.getLocaleStringResource(locale2, i12, context), z11, "actual_result");
        eVar2.a(R.string.ibg_extended_report_actual_results_edit_text_description);
        arrayList.add(eVar2);
        Locale locale4 = InstabugCore.getLocale(context);
        int i13 = R.string.instabug_str_expected_results;
        e eVar3 = new e(LocaleUtils.getLocaleStringResource(locale4, i13, context), LocaleUtils.getLocaleStringResource(locale2, i13, context), z11, "expected_result");
        eVar3.a(R.string.ibg_extended_report_expected_results_edit_text_description);
        arrayList.add(eVar3);
        return arrayList;
    }
}
