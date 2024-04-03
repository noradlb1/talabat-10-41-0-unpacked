package org.junit.platform.engine.support.descriptor;

import com.newrelic.agent.android.hybrid.data.HexAttribute;
import io.flutter.plugins.firebase.crashlytics.Constants;
import j$.util.Optional;
import java.io.Serializable;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.0", status = API.Status.STABLE)
public class FilePosition implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(FilePosition.class);
    private static final long serialVersionUID = 1;
    private final Integer column;
    private final int line;

    private FilePosition(int i11) {
        Preconditions.condition(i11 > 0, "line number must be greater than zero");
        this.line = i11;
        this.column = null;
    }

    public static FilePosition from(int i11) {
        return new FilePosition(i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.util.Optional<org.junit.platform.engine.support.descriptor.FilePosition> fromQuery(java.lang.String r11) {
        /*
            boolean r0 = org.junit.platform.commons.util.StringUtils.isNotBlank(r11)
            r1 = 0
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "&"
            java.lang.String[] r0 = r11.split(r0)     // Catch:{ IllegalArgumentException -> 0x004e }
            int r2 = r0.length     // Catch:{ IllegalArgumentException -> 0x004e }
            r3 = 0
            r5 = r1
            r6 = r5
            r4 = r3
        L_0x0012:
            if (r4 >= r2) goto L_0x005b
            r7 = r0[r4]     // Catch:{ IllegalArgumentException -> 0x004c }
            java.lang.String r8 = "="
            java.lang.String[] r7 = r7.split(r8)     // Catch:{ IllegalArgumentException -> 0x004c }
            int r8 = r7.length     // Catch:{ IllegalArgumentException -> 0x004c }
            r9 = 2
            if (r8 != r9) goto L_0x0044
            r8 = r7[r3]     // Catch:{ IllegalArgumentException -> 0x004c }
            r9 = 1
            if (r5 != 0) goto L_0x0034
            java.lang.String r10 = "line"
            boolean r10 = r10.equals(r8)     // Catch:{ IllegalArgumentException -> 0x004c }
            if (r10 == 0) goto L_0x0034
            r7 = r7[r9]     // Catch:{ IllegalArgumentException -> 0x004c }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalArgumentException -> 0x004c }
            goto L_0x0044
        L_0x0034:
            if (r6 != 0) goto L_0x0044
            java.lang.String r10 = "column"
            boolean r8 = r10.equals(r8)     // Catch:{ IllegalArgumentException -> 0x004c }
            if (r8 == 0) goto L_0x0044
            r7 = r7[r9]     // Catch:{ IllegalArgumentException -> 0x004c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ IllegalArgumentException -> 0x004c }
        L_0x0044:
            if (r5 == 0) goto L_0x0049
            if (r6 == 0) goto L_0x0049
            goto L_0x005b
        L_0x0049:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x004c:
            r0 = move-exception
            goto L_0x0051
        L_0x004e:
            r0 = move-exception
            r5 = r1
            r6 = r5
        L_0x0051:
            org.junit.platform.commons.logging.Logger r2 = logger
            p30.f r3 = new p30.f
            r3.<init>(r11)
            r2.debug(r0, r3)
        L_0x005b:
            if (r5 == 0) goto L_0x0071
            org.junit.platform.engine.support.descriptor.FilePosition r11 = new org.junit.platform.engine.support.descriptor.FilePosition
            int r0 = r5.intValue()
            if (r6 != 0) goto L_0x0069
            r11.<init>(r0)
            goto L_0x0070
        L_0x0069:
            int r1 = r6.intValue()
            r11.<init>(r0, r1)
        L_0x0070:
            r1 = r11
        L_0x0071:
            j$.util.Optional r11 = j$.util.Optional.ofNullable(r1)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.platform.engine.support.descriptor.FilePosition.fromQuery(java.lang.String):j$.util.Optional");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$fromQuery$0(String str) {
        return "Failed to parse 'line' and/or 'column' from query string: " + str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FilePosition filePosition = (FilePosition) obj;
        if (this.line != filePosition.line || !Objects.equals(this.column, filePosition.column)) {
            return false;
        }
        return true;
    }

    public Optional<Integer> getColumn() {
        return Optional.ofNullable(this.column);
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.line), this.column});
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append(Constants.LINE, Integer.valueOf(this.line)).append(HexAttribute.HEX_ATTR_JSERROR_COLUMN, getColumn().orElse(-1)).toString();
    }

    public static FilePosition from(int i11, int i12) {
        return new FilePosition(i11, i12);
    }

    private FilePosition(int i11, int i12) {
        boolean z11 = true;
        Preconditions.condition(i11 > 0, "line number must be greater than zero");
        Preconditions.condition(i12 <= 0 ? false : z11, "column number must be greater than zero");
        this.line = i11;
        this.column = Integer.valueOf(i12);
    }
}
