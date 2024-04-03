package org.junit.platform.engine.reporting;

import j$.time.LocalDateTime;
import j$.util.Map;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import o30.a;
import o30.b;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "1.0", status = API.Status.STABLE)
public final class ReportEntry {
    private final Map<String, String> keyValuePairs = new LinkedHashMap();
    private final LocalDateTime timestamp = LocalDateTime.now();

    /* access modifiers changed from: private */
    public void add(String str, String str2) {
        Preconditions.notBlank(str, "key must not be null or blank");
        Preconditions.notBlank(str2, "value must not be null or blank");
        this.keyValuePairs.put(str, str2);
    }

    public static ReportEntry from(Map<String, String> map) {
        Preconditions.notNull(map, "keyValuePairs must not be null");
        ReportEntry reportEntry = new ReportEntry();
        Map.EL.forEach(map, new a(reportEntry));
        return reportEntry;
    }

    public final java.util.Map<String, String> getKeyValuePairs() {
        return Collections.unmodifiableMap(this.keyValuePairs);
    }

    public final LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        ToStringBuilder toStringBuilder = new ToStringBuilder((Object) this);
        toStringBuilder.append("timestamp", this.timestamp);
        Map.EL.forEach(this.keyValuePairs, new b(toStringBuilder));
        return toStringBuilder.toString();
    }

    public static ReportEntry from(String str, String str2) {
        ReportEntry reportEntry = new ReportEntry();
        reportEntry.add(str, str2);
        return reportEntry;
    }
}
