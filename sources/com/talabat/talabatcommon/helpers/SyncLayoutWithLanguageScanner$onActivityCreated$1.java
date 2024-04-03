package com.talabat.talabatcommon.helpers;

import android.app.Activity;
import android.content.res.Resources;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SyncLayoutWithLanguageScanner$onActivityCreated$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Activity f61735g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SyncLayoutWithLanguageScanner f61736h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SyncLayoutWithLanguageScanner$onActivityCreated$1(Activity activity, SyncLayoutWithLanguageScanner syncLayoutWithLanguageScanner) {
        super(0);
        this.f61735g = activity;
        this.f61736h = syncLayoutWithLanguageScanner;
    }

    public final void invoke() {
        Activity activity = this.f61735g;
        if (!this.f61736h.isAnnotationPresent(activity)) {
            activity = null;
        }
        if (activity != null) {
            SyncLayoutWithLanguageScanner syncLayoutWithLanguageScanner = this.f61736h;
            Resources resources = activity.getResources();
            resources.getConfiguration().setLayoutDirection((Locale) syncLayoutWithLanguageScanner.selectedLocale.invoke());
            resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
        }
    }
}
