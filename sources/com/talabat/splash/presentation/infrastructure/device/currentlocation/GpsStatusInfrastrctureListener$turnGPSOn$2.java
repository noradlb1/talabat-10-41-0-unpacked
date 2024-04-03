package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import android.content.IntentSender;
import android.util.Log;
import com.talabat.location.domain.exception.ApiException;
import com.talabat.location.domain.exception.ResolvableApiException;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GpsStatusInfrastrctureListener$turnGPSOn$2 extends Lambda implements Function1<Exception, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GpsStatusInfrastrctureListener f61501g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GpsStatusInfrastrctureListener$turnGPSOn$2(GpsStatusInfrastrctureListener gpsStatusInfrastrctureListener) {
        super(1);
        this.f61501g = gpsStatusInfrastrctureListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Exception) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        if (exc instanceof ResolvableApiException) {
            try {
                this.f61501g.postValue(new GpsStatus.GpsDenyFailure((ResolvableApiException) exc));
            } catch (IntentSender.SendIntentException unused) {
                Log.i("ContentValues", "PendingIntent unable to execute request.");
            }
        } else if (exc instanceof ApiException) {
            ApiException apiException = (ApiException) exc;
            if (apiException.getStatusCode() == 8502) {
                Log.e("ContentValues", "Location settings are inadequate, and cannot be fixed here. Fix in Settings.");
                return;
            }
            int statusCode = apiException.getStatusCode();
            Log.e("ContentValues", "Gps settings API exception with code " + statusCode);
        }
    }
}
