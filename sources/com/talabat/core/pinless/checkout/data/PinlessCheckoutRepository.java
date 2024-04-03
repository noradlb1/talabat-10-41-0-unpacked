package com.talabat.core.pinless.checkout.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.pinless.checkout.domain.PinlessCheckoutFeatureRepository;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.domain.location.GeoCoordinate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/pinless/checkout/data/PinlessCheckoutRepository;", "Lcom/talabat/core/pinless/checkout/domain/PinlessCheckoutFeatureRepository;", "context", "Landroid/content/Context;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Landroid/content/Context;Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "manuallyPinnedLocationOfUser", "Lcom/talabat/domain/location/GeoCoordinate;", "getManuallyPinnedLocationOfUser", "()Lcom/talabat/domain/location/GeoCoordinate;", "setManuallyPinnedLocationOfUser", "(Lcom/talabat/domain/location/GeoCoordinate;)V", "sharedPref", "Landroid/content/SharedPreferences;", "value", "", "userPinnedLocationCount", "getUserPinnedLocationCount", "()I", "setUserPinnedLocationCount", "(I)V", "com_talabat_core_pinless-checkout_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PinlessCheckoutRepository implements PinlessCheckoutFeatureRepository {
    @Nullable
    private GeoCoordinate manuallyPinnedLocationOfUser;
    @NotNull
    private final SharedPreferences sharedPref;
    @NotNull
    private final TalabatTracker talabatTracker;
    private int userPinnedLocationCount;

    @Inject
    public PinlessCheckoutRepository(@NotNull Context context, @NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.talabat.feature.pinless.checkout.data.PIN_LESS_CHECOUT_PREF", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context\n        .getShar…EF, Context.MODE_PRIVATE)");
        this.sharedPref = sharedPreferences;
    }

    @Nullable
    public GeoCoordinate getManuallyPinnedLocationOfUser() {
        return this.manuallyPinnedLocationOfUser;
    }

    public int getUserPinnedLocationCount() {
        Integer num;
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m6329constructorimpl(Integer.valueOf(this.sharedPref.getInt("USER_PIN_LOCATION_COUNT", 0)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r22 = Result.m6332exceptionOrNullimpl(num);
        if (r22 != null) {
            TalabatTracker talabatTracker2 = this.talabatTracker;
            StackTraceElement[] stackTrace = r22.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "it.stackTrace");
            talabatTracker2.track(new FailedToSharedPrefEvent("Read", "value = 0", ArraysKt___ArraysKt.take((T[]) stackTrace, 5).toString()));
        }
        if (Result.m6335isFailureimpl(num)) {
            num = 0;
        }
        return ((Number) num).intValue();
    }

    public void setManuallyPinnedLocationOfUser(@Nullable GeoCoordinate geoCoordinate) {
        this.manuallyPinnedLocationOfUser = geoCoordinate;
    }

    public void setUserPinnedLocationCount(int i11) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            this.sharedPref.edit().putInt("USER_PIN_LOCATION_COUNT", i11).apply();
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            StackTraceElement[] stackTrace = r02.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "it.stackTrace");
            this.talabatTracker.track(new FailedToSharedPrefEvent("Write", "value = " + i11, ArraysKt___ArraysKt.take((T[]) stackTrace, 5).toString()));
        }
        this.userPinnedLocationCount = i11;
    }
}
