package com.talabat.helpers;

import android.content.SharedPreferences;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.cache.impl.DiskCache;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CustomerInfo;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/talabat/helpers/TalabatApplication$subscribeToTheChangesInCustomerInfo$1", "Lio/reactivex/Observer;", "Ldatamodels/CustomerInfo;", "onComplete", "", "onError", "e", "", "onNext", "customerInfo", "onSubscribe", "d", "Lio/reactivex/disposables/Disposable;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$subscribeToTheChangesInCustomerInfo$1 implements Observer<CustomerInfo> {
    public void onComplete() {
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "e");
        LogManager.logException(th2);
    }

    public void onSubscribe(@NotNull Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "d");
    }

    public void onNext(@NotNull CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        if (customerInfo.f13850id > 0) {
            DiskCache diskCache = new DiskCache((String) null, (SharedPreferences) null, 3, (DefaultConstructorMarker) null);
            String valueOf = String.valueOf(customerInfo.f13850id);
            ObservabilityManager.INSTANCE.trackUserId(valueOf);
            String string = diskCache.getString("lastOrderId");
            if (string == null) {
                string = "";
            }
            ObservabilityManager.trackAttribute("lastOrderId", string);
            FirebaseCrashlytics.getInstance().setUserId(valueOf);
        }
    }
}
