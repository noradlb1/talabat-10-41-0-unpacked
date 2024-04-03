package com.talabat.core.hms.location.data;

import ch.c;
import ch.d;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.talabat.core.hms.location.data.exceptions.HmsApiException;
import com.talabat.core.hms.location.data.exceptions.HmsResolvableApiException;
import com.talabat.location.domain.LocationSettingsResponse;
import com.talabat.location.domain.tasks.Task;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\nj\u0002`\u000b\u0012\u0004\u0012\u00020\f0\tH\u0016J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\tH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0012H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/hms/location/data/LocationResponseTaskWrapper;", "Lcom/talabat/location/domain/tasks/Task;", "Lcom/talabat/location/domain/LocationSettingsResponse;", "huaweiTask", "Lcom/huawei/hmf/tasks/Task;", "Lcom/huawei/hms/location/LocationSettingsResponse;", "(Lcom/huawei/hmf/tasks/Task;)V", "addOnFailureListener", "onFailure", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "addOnSuccessListener", "onSuccess", "isSuccessful", "", "convertToStatusCode", "", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationResponseTaskWrapper implements Task<LocationSettingsResponse> {
    @NotNull
    private final com.huawei.hmf.tasks.Task<com.huawei.hms.location.LocationSettingsResponse> huaweiTask;

    public LocationResponseTaskWrapper(@NotNull com.huawei.hmf.tasks.Task<com.huawei.hms.location.LocationSettingsResponse> task) {
        Intrinsics.checkNotNullParameter(task, "huaweiTask");
        this.huaweiTask = task;
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnFailureListener$lambda-1  reason: not valid java name */
    public static final void m9609addOnFailureListener$lambda1(Function1 function1, LocationResponseTaskWrapper locationResponseTaskWrapper, Exception exc) {
        int i11;
        Object obj;
        Intrinsics.checkNotNullParameter(function1, "$onFailure");
        Intrinsics.checkNotNullParameter(locationResponseTaskWrapper, "this$0");
        if (exc instanceof ResolvableApiException) {
            ResolvableApiException resolvableApiException = (ResolvableApiException) exc;
            if (resolvableApiException.getResolution() != null) {
                int convertToStatusCode = locationResponseTaskWrapper.convertToStatusCode(resolvableApiException.getStatusCode());
                Intrinsics.checkNotNullExpressionValue(exc, "exception");
                obj = new HmsResolvableApiException(convertToStatusCode, resolvableApiException);
            } else {
                obj = new HmsApiException(resolvableApiException.getStatusCode());
            }
            function1.invoke(obj);
            return;
        }
        if (exc instanceof ApiException) {
            i11 = ((ApiException) exc).getStatusCode();
        } else {
            i11 = 8;
        }
        function1.invoke(new HmsApiException(i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnSuccessListener$lambda-0  reason: not valid java name */
    public static final void m9610addOnSuccessListener$lambda0(Function1 function1, com.huawei.hms.location.LocationSettingsResponse locationSettingsResponse) {
        Intrinsics.checkNotNullParameter(function1, "$onSuccess");
        Intrinsics.checkNotNullExpressionValue(locationSettingsResponse, "it");
        function1.invoke(new HmsLocationSettingsResponseWrapper(locationSettingsResponse));
    }

    private final int convertToStatusCode(int i11) {
        int i12 = 6;
        if (i11 != 6) {
            i12 = 8502;
            if (i11 != 8502) {
                return i11;
            }
        }
        return i12;
    }

    @NotNull
    public Task<LocationSettingsResponse> addOnFailureListener(@NotNull Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onFailure");
        this.huaweiTask.addOnFailureListener(new c(function1, this));
        return this;
    }

    @NotNull
    public Task<LocationSettingsResponse> addOnSuccessListener(@NotNull Function1<? super LocationSettingsResponse, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        this.huaweiTask.addOnSuccessListener(new d(function1));
        return this;
    }

    public boolean isSuccessful() {
        return this.huaweiTask.isSuccessful();
    }
}
