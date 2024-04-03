package com.talabat.location.domain.exception;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/location/domain/exception/ApiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "statusCode", "", "getStatusCode", "()I", "com_talabat_core_location_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ApiException extends Exception {
    public abstract int getStatusCode();
}
