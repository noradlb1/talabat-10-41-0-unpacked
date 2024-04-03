package com.deliveryhero.perseus.optin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.RequiresOptIn;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/deliveryhero/perseus/optin/ExperimentalPerseusApi;", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RequiresOptIn(level = RequiresOptIn.Level.ERROR, message = "This API is experimental and is subject to change, as such it's safer not to use outside of the SDK")
@Retention(RetentionPolicy.RUNTIME)
public @interface ExperimentalPerseusApi {
}
