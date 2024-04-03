package com.talabat.homemaphelper;

import android.app.Activity;
import android.content.IntentSender;
import com.talabat.location.domain.exception.ApiException;
import com.talabat.location.domain.exception.ResolvableApiException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocationFetchRefactor$startLocationUpdates$2 extends Lambda implements Function1<Exception, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CurrentLocationFetchRefactor f60960g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Activity f60961h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CurrentLocationFetchRefactor$startLocationUpdates$2(CurrentLocationFetchRefactor currentLocationFetchRefactor, Activity activity) {
        super(1);
        this.f60960g = currentLocationFetchRefactor;
        this.f60961h = activity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Exception) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        if (((ApiException) exc).getStatusCode() == 6) {
            try {
                this.f60960g.locationRequestInited = false;
                ((ResolvableApiException) exc).startResolutionForResult(this.f60961h, this.f60960g.REQUEST_CHECK_SETTINGS);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }
}
