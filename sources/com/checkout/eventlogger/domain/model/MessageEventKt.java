package com.checkout.eventlogger.domain.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", "toStackTraceString", "(Ljava/lang/Throwable;)Ljava/lang/String;", "logger_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class MessageEventKt {
    public static final String access$toStackTraceString(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
