package org.junit.platform.commons.logging;

import e30.c;
import j$.util.Collection;
import j$.util.stream.Stream;
import j30.a;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.apiguardian.api.API;
import org.junit.platform.commons.JUnitException;
import z1.b;

@API(since = "1.1", status = API.Status.INTERNAL)
public class LogRecordListener {
    private final ThreadLocal<List<LogRecord>> logRecords = new b(new c());

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$stream$0(Level level, LogRecord logRecord) {
        return logRecord.getLevel() == level;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$stream$2(Level level, LogRecord logRecord) {
        return logRecord.getLevel() == level;
    }

    public void clear() {
        this.logRecords.get().clear();
    }

    public void logRecordSubmitted(LogRecord logRecord) {
        this.logRecords.get().add(logRecord);
    }

    public Stream<LogRecord> stream() {
        return Collection.EL.stream(this.logRecords.get());
    }

    public Stream<LogRecord> stream(Level level) {
        if (level != null) {
            return stream().filter(new j30.c(level));
        }
        throw new JUnitException("Level must not be null");
    }

    public Stream<LogRecord> stream(Class<?> cls) {
        if (cls != null) {
            return stream().filter(new a(cls));
        }
        throw new JUnitException("Class must not be null");
    }

    public Stream<LogRecord> stream(Class<?> cls, Level level) {
        if (level != null) {
            return stream(cls).filter(new j30.b(level));
        }
        throw new JUnitException("Level must not be null");
    }
}
