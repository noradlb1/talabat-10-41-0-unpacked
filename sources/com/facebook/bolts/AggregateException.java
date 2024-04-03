package com.facebook.bolts;

import androidx.core.app.NotificationCompat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/bolts/AggregateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "detailMessage", "", "innerThrowables", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "printStackTrace", "", "err", "Ljava/io/PrintStream;", "Ljava/io/PrintWriter;", "Companion", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AggregateException extends Exception {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 1;
    @NotNull
    private final List<Throwable> innerThrowables;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/bolts/AggregateException$Companion;", "", "()V", "serialVersionUID", "", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AggregateException(@org.jetbrains.annotations.Nullable java.lang.String r2, @org.jetbrains.annotations.Nullable java.util.List<? extends java.lang.Throwable> r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0015
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x0015
            r0 = 0
            java.lang.Object r0 = r3.get(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            r1.<init>(r2, r0)
            if (r3 != 0) goto L_0x001f
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x001f:
            java.util.List r2 = java.util.Collections.unmodifiableList(r3)
            java.lang.String r3 = "unmodifiableList(innerThrowables ?: emptyList())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.innerThrowables = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.bolts.AggregateException.<init>(java.lang.String, java.util.List):void");
    }

    public void printStackTrace(@NotNull PrintStream printStream) {
        Intrinsics.checkNotNullParameter(printStream, NotificationCompat.CATEGORY_ERROR);
        super.printStackTrace(printStream);
        int i11 = -1;
        for (Throwable next : this.innerThrowables) {
            printStream.append(StringUtils.LF);
            printStream.append("  Inner throwable #");
            i11++;
            printStream.append(String.valueOf(i11));
            printStream.append(": ");
            if (next != null) {
                next.printStackTrace(printStream);
            }
            printStream.append(StringUtils.LF);
        }
    }

    public void printStackTrace(@NotNull PrintWriter printWriter) {
        Intrinsics.checkNotNullParameter(printWriter, NotificationCompat.CATEGORY_ERROR);
        super.printStackTrace(printWriter);
        int i11 = -1;
        for (Throwable next : this.innerThrowables) {
            printWriter.append(StringUtils.LF);
            printWriter.append("  Inner throwable #");
            i11++;
            printWriter.append(String.valueOf(i11));
            printWriter.append(": ");
            if (next != null) {
                next.printStackTrace(printWriter);
            }
            printWriter.append(StringUtils.LF);
        }
    }
}
