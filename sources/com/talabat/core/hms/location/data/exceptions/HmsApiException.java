package com.talabat.core.hms.location.data.exceptions;

import com.talabat.location.domain.exception.ApiException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/hms/location/data/exceptions/HmsApiException;", "Lcom/talabat/location/domain/exception/ApiException;", "statusCode", "", "(I)V", "getStatusCode", "()I", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsApiException extends ApiException {
    private final int statusCode;

    public HmsApiException(int i11) {
        this.statusCode = i11;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
