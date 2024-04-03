package com.talabat.talabatcommon.exception;

import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.logger.impl.TimberLogger;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.IOException;
import java.net.SocketException;
import kotlin.Metadata;
import retrofit2.HttpException;
import yu.a;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"setRxErrorHandler", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RxErrorHandlerKt {
    public static final void setRxErrorHandler() {
        RxJavaPlugins.setErrorHandler(new a());
    }

    /* access modifiers changed from: private */
    /* renamed from: setRxErrorHandler$lambda-0  reason: not valid java name */
    public static final void m9348setRxErrorHandler$lambda0(Throwable th2) {
        boolean z11;
        if (th2 instanceof UndeliverableException) {
            Throwable cause = th2.getCause();
            boolean z12 = true;
            if (cause instanceof IOException) {
                z11 = true;
            } else {
                z11 = cause instanceof SocketException;
            }
            if (z11) {
                LogManager.logException(cause);
                return;
            }
            if (!(cause instanceof InterruptedException)) {
                z12 = cause instanceof HttpException;
            }
            if (z12) {
                LogManager.logException(cause);
            } else {
                TimberLogger.INSTANCE.error(th2, "UndeliverableException happened");
            }
        }
    }
}
