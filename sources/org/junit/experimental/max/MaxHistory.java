package org.junit.experimental.max;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class MaxHistory implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<String, Long> fDurations = new HashMap();
    private final Map<String, Long> fFailureTimestamps = new HashMap();
    private final File fHistoryStore;

    public final class RememberingListener extends RunListener {
        private long overallStart;
        private Map<Description, Long> starts;

        private RememberingListener() {
            this.overallStart = System.currentTimeMillis();
            this.starts = new HashMap();
        }

        public void testFailure(Failure failure) throws Exception {
            MaxHistory.this.f(failure.getDescription(), this.overallStart);
        }

        public void testFinished(Description description) throws Exception {
            MaxHistory.this.e(description, System.nanoTime() - this.starts.get(description).longValue());
        }

        public void testRunFinished(Result result) throws Exception {
            MaxHistory.this.save();
        }

        public void testStarted(Description description) throws Exception {
            this.starts.put(description, Long.valueOf(System.nanoTime()));
        }
    }

    public class TestComparator implements Comparator<Description> {
        private TestComparator() {
        }

        private Long getFailure(Description description) {
            Long b11 = MaxHistory.this.b(description);
            if (b11 == null) {
                return 0L;
            }
            return b11;
        }

        public int compare(Description description, Description description2) {
            if (MaxHistory.this.d(description)) {
                return -1;
            }
            if (MaxHistory.this.d(description2)) {
                return 1;
            }
            int compareTo = getFailure(description2).compareTo(getFailure(description));
            return compareTo != 0 ? compareTo : MaxHistory.this.c(description).compareTo(MaxHistory.this.c(description2));
        }
    }

    private MaxHistory(File file) {
        this.fHistoryStore = file;
    }

    public static MaxHistory forFolder(File file) {
        if (file.exists()) {
            try {
                return readHistory(file);
            } catch (CouldNotReadCoreException e11) {
                e11.printStackTrace();
                file.delete();
            }
        }
        return new MaxHistory(file);
    }

    private static MaxHistory readHistory(File file) throws CouldNotReadCoreException {
        ObjectInputStream objectInputStream;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                MaxHistory maxHistory = (MaxHistory) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                return maxHistory;
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        } catch (Exception e11) {
            throw new CouldNotReadCoreException(e11);
        }
    }

    /* access modifiers changed from: private */
    public void save() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.fHistoryStore));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public Long b(Description description) {
        return this.fFailureTimestamps.get(description.toString());
    }

    public Long c(Description description) {
        return this.fDurations.get(description.toString());
    }

    public boolean d(Description description) {
        return !this.fDurations.containsKey(description.toString());
    }

    public void e(Description description, long j11) {
        this.fDurations.put(description.toString(), Long.valueOf(j11));
    }

    public void f(Description description, long j11) {
        this.fFailureTimestamps.put(description.toString(), Long.valueOf(j11));
    }

    public RunListener listener() {
        return new RememberingListener();
    }

    public Comparator<Description> testComparator() {
        return new TestComparator();
    }
}
