package com.talabat.talabatcommon;

import android.app.Application;
import com.google.android.exoplayer2.util.MimeTypes;
import com.talabat.talabatcommon.helpers.SyncLayoutWithLanguageScanner;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00002\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/TalabatCommonDependencies;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "withSelectedLocaleRetriever", "selectedLocale", "Lkotlin/Function0;", "Ljava/util/Locale;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatCommonDependencies {
    @NotNull
    private final Application application;

    public TalabatCommonDependencies(@NotNull Application application2) {
        Intrinsics.checkNotNullParameter(application2, MimeTypes.BASE_TYPE_APPLICATION);
        this.application = application2;
    }

    @NotNull
    public final TalabatCommonDependencies withSelectedLocaleRetriever(@NotNull Function0<Locale> function0) {
        Intrinsics.checkNotNullParameter(function0, "selectedLocale");
        TalabatCommonIntegrationKt.setSelectedLocaleRetriever(new TalabatCommonDependencies$withSelectedLocaleRetriever$1(function0));
        this.application.registerActivityLifecycleCallbacks(new SyncLayoutWithLanguageScanner(TalabatCommonIntegrationKt.getSelectedLocaleRetriever()));
        return this;
    }
}
