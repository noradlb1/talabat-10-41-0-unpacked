package com.google.firebase.crashlytics.internal.persistence;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import t9.a;
import t9.b;
import t9.c;
import t9.d;

public class CrashlyticsReportPersistence {
    private static final String AQS_SESSION_ID_FILENAME = "app-quality-session-id";
    private static final String EVENT_COUNTER_FORMAT = "%010d";
    private static final int EVENT_COUNTER_WIDTH = 10;
    private static final FilenameFilter EVENT_FILE_FILTER = new d();
    private static final String EVENT_FILE_NAME_PREFIX = "event";
    private static final int EVENT_NAME_LENGTH = 15;
    private static final Comparator<? super File> LATEST_SESSION_ID_FIRST_COMPARATOR = new c();
    private static final int MAX_OPEN_SESSIONS = 8;
    private static final String NORMAL_EVENT_SUFFIX = "";
    private static final String PRIORITY_EVENT_SUFFIX = "_";
    private static final String REPORT_FILE_NAME = "report";
    private static final String SESSION_START_TIMESTAMP_FILE_NAME = "start-time";
    private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final FileStore fileStore;
    private final CrashlyticsAppQualitySessionsSubscriber sessionsSubscriber;
    private final SettingsProvider settingsProvider;

    public CrashlyticsReportPersistence(FileStore fileStore2, SettingsProvider settingsProvider2, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        this.fileStore = fileStore2;
        this.settingsProvider = settingsProvider2;
        this.sessionsSubscriber = crashlyticsAppQualitySessionsSubscriber;
    }

    private SortedSet<String> capAndGetOpenSessions(@Nullable String str) {
        this.fileStore.cleanupPreviousFileSystems();
        SortedSet<String> openSessionIds = getOpenSessionIds();
        if (str != null) {
            openSessionIds.remove(str);
        }
        if (openSessionIds.size() <= 8) {
            return openSessionIds;
        }
        while (openSessionIds.size() > 8) {
            String last = openSessionIds.last();
            Logger logger = Logger.getLogger();
            logger.d("Removing session over cap: " + last);
            this.fileStore.deleteSessionFiles(last);
            openSessionIds.remove(last);
        }
        return openSessionIds;
    }

    private static int capFilesCount(List<File> list, int i11) {
        int size = list.size();
        for (File next : list) {
            if (size <= i11) {
                return size;
            }
            FileStore.recursiveDelete(next);
            size--;
        }
        return size;
    }

    private void capFinalizedReports() {
        int i11 = this.settingsProvider.getSettingsSync().sessionData.maxCompleteSessionsCount;
        List<File> allFinalizedReportFiles = getAllFinalizedReportFiles();
        int size = allFinalizedReportFiles.size();
        if (size > i11) {
            for (File delete : allFinalizedReportFiles.subList(i11, size)) {
                delete.delete();
            }
        }
    }

    private static long convertTimestampFromSecondsToMs(long j11) {
        return j11 * 1000;
    }

    private void deleteFiles(List<File> list) {
        for (File delete : list) {
            delete.delete();
        }
    }

    @NonNull
    private static String generateEventFilename(int i11, boolean z11) {
        String str;
        String format = String.format(Locale.US, EVENT_COUNTER_FORMAT, new Object[]{Integer.valueOf(i11)});
        if (z11) {
            str = "_";
        } else {
            str = "";
        }
        return "event" + format + str;
    }

    private List<File> getAllFinalizedReportFiles() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.fileStore.getPriorityReports());
        arrayList.addAll(this.fileStore.getNativeReports());
        Comparator<? super File> comparator = LATEST_SESSION_ID_FIRST_COMPARATOR;
        Collections.sort(arrayList, comparator);
        List<File> reports = this.fileStore.getReports();
        Collections.sort(reports, comparator);
        arrayList.addAll(reports);
        return arrayList;
    }

    @NonNull
    private static String getEventNameWithoutPriority(@NonNull String str) {
        return str.substring(0, EVENT_NAME_LENGTH);
    }

    private static boolean isHighPriorityEventFile(@NonNull String str) {
        if (!str.startsWith("event") || !str.endsWith("_")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean isNormalPriorityEventFile(@NonNull File file, @NonNull String str) {
        if (!str.startsWith("event") || str.endsWith("_")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int oldestEventFileFirst(@NonNull File file, @NonNull File file2) {
        return getEventNameWithoutPriority(file.getName()).compareTo(getEventNameWithoutPriority(file2.getName()));
    }

    @NonNull
    private static String readTextFile(@NonNull File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), UTF_8);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        throw th;
    }

    private void synthesizeNativeReportFile(@NonNull File file, @NonNull CrashlyticsReport.FilesPayload filesPayload, @NonNull String str, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = TRANSFORM;
            writeTextFile(this.fileStore.getNativeReport(str), crashlyticsReportJsonTransform.reportToJson(crashlyticsReportJsonTransform.reportFromJson(readTextFile(file)).withNdkPayload(filesPayload).withApplicationExitInfo(applicationExitInfo)));
        } catch (IOException e11) {
            Logger logger = Logger.getLogger();
            logger.w("Could not synthesize final native report file for " + file, e11);
        }
    }

    private void synthesizeReport(String str, long j11) {
        boolean z11;
        List<File> sessionFiles = this.fileStore.getSessionFiles(str, EVENT_FILE_FILTER);
        if (sessionFiles.isEmpty()) {
            Logger.getLogger().v("Session " + str + " has no events.");
            return;
        }
        Collections.sort(sessionFiles);
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = sessionFiles.iterator();
        loop0:
        while (true) {
            z11 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                File next = it.next();
                try {
                    arrayList.add(TRANSFORM.eventFromJson(readTextFile(next)));
                    if (z11 || isHighPriorityEventFile(next.getName())) {
                        z11 = true;
                    }
                } catch (IOException e11) {
                    Logger.getLogger().w("Could not add event to report for " + next, e11);
                }
            }
        }
        if (arrayList.isEmpty()) {
            Logger.getLogger().w("Could not parse event files for session " + str);
            return;
        }
        synthesizeReportFile(this.fileStore.getSessionFile(str, REPORT_FILE_NAME), arrayList, j11, z11, UserMetadata.readUserId(str, this.fileStore), tryReadTextFile(this.fileStore.getSessionFile(str, AQS_SESSION_ID_FILENAME)));
    }

    private void synthesizeReportFile(@NonNull File file, @NonNull List<CrashlyticsReport.Session.Event> list, long j11, boolean z11, @Nullable String str, @Nullable String str2) {
        File file2;
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = TRANSFORM;
            CrashlyticsReport withEvents = crashlyticsReportJsonTransform.reportFromJson(readTextFile(file)).withSessionEndFields(j11, z11, str).withAppQualitySessionId(str2).withEvents(ImmutableList.from(list));
            CrashlyticsReport.Session session = withEvents.getSession();
            if (session != null) {
                Logger logger = Logger.getLogger();
                logger.d("appQualitySessionId: " + str2);
                if (z11) {
                    file2 = this.fileStore.getPriorityReport(session.getIdentifier());
                } else {
                    file2 = this.fileStore.getReport(session.getIdentifier());
                }
                writeTextFile(file2, crashlyticsReportJsonTransform.reportToJson(withEvents));
            }
        } catch (IOException e11) {
            Logger logger2 = Logger.getLogger();
            logger2.w("Could not synthesize final report file for " + file, e11);
        }
    }

    private int trimEvents(String str, int i11) {
        List<File> sessionFiles = this.fileStore.getSessionFiles(str, new a());
        Collections.sort(sessionFiles, new b());
        return capFilesCount(sessionFiles, i11);
    }

    @Nullable
    private static String tryReadTextFile(@NonNull File file) {
        try {
            return readTextFile(file);
        } catch (IOException unused) {
            return null;
        }
    }

    private static void writeTextFile(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public void deleteAllReports() {
        deleteFiles(this.fileStore.getReports());
        deleteFiles(this.fileStore.getPriorityReports());
        deleteFiles(this.fileStore.getNativeReports());
    }

    public void finalizeReports(@Nullable String str, long j11) {
        for (String next : capAndGetOpenSessions(str)) {
            Logger logger = Logger.getLogger();
            logger.v("Finalizing report for session " + next);
            synthesizeReport(next, j11);
            this.fileStore.deleteSessionFiles(next);
        }
        capFinalizedReports();
    }

    public void finalizeSessionWithNativeEvent(String str, CrashlyticsReport.FilesPayload filesPayload, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        File sessionFile = this.fileStore.getSessionFile(str, REPORT_FILE_NAME);
        Logger logger = Logger.getLogger();
        logger.d("Writing native session report for " + str + " to file: " + sessionFile);
        synthesizeNativeReportFile(sessionFile, filesPayload, str, applicationExitInfo);
    }

    public SortedSet<String> getOpenSessionIds() {
        return new TreeSet(this.fileStore.getAllOpenSessionIds()).descendingSet();
    }

    public long getStartTimestampMillis(String str) {
        return this.fileStore.getSessionFile(str, SESSION_START_TIMESTAMP_FILE_NAME).lastModified();
    }

    public boolean hasFinalizedReports() {
        if (!this.fileStore.getReports().isEmpty() || !this.fileStore.getPriorityReports().isEmpty() || !this.fileStore.getNativeReports().isEmpty()) {
            return true;
        }
        return false;
    }

    @NonNull
    public List<CrashlyticsReportWithSessionId> loadFinalizedReports() {
        List<File> allFinalizedReportFiles = getAllFinalizedReportFiles();
        ArrayList arrayList = new ArrayList();
        for (File next : allFinalizedReportFiles) {
            try {
                arrayList.add(CrashlyticsReportWithSessionId.create(TRANSFORM.reportFromJson(readTextFile(next)), next.getName(), next));
            } catch (IOException e11) {
                Logger logger = Logger.getLogger();
                logger.w("Could not load report file " + next + "; deleting", e11);
                next.delete();
            }
        }
        return arrayList;
    }

    public void persistEvent(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str) {
        persistEvent(event, str, false);
    }

    public void persistReport(@NonNull CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session session = crashlyticsReport.getSession();
        if (session == null) {
            Logger.getLogger().d("Could not get session for report");
            return;
        }
        String identifier = session.getIdentifier();
        try {
            writeTextFile(this.fileStore.getSessionFile(identifier, REPORT_FILE_NAME), TRANSFORM.reportToJson(crashlyticsReport));
            writeTextFile(this.fileStore.getSessionFile(identifier, SESSION_START_TIMESTAMP_FILE_NAME), "", session.getStartedAt());
        } catch (IOException e11) {
            Logger logger = Logger.getLogger();
            logger.d("Could not persist report for session " + identifier, e11);
        }
    }

    public void persistEvent(@NonNull CrashlyticsReport.Session.Event event, @NonNull String str, boolean z11) {
        int i11 = this.settingsProvider.getSettingsSync().sessionData.maxCustomExceptionEvents;
        try {
            writeTextFile(this.fileStore.getSessionFile(str, generateEventFilename(this.eventCounter.getAndIncrement(), z11)), TRANSFORM.eventToJson(event));
            String appQualitySessionId = this.sessionsSubscriber.getAppQualitySessionId();
            if (appQualitySessionId == null) {
                Logger logger = Logger.getLogger();
                logger.w("Missing AQS session id for Crashlytics session " + str);
            } else {
                writeTextFile(this.fileStore.getSessionFile(str, AQS_SESSION_ID_FILENAME), appQualitySessionId);
            }
        } catch (IOException e11) {
            Logger logger2 = Logger.getLogger();
            logger2.w("Could not persist event for session " + str, e11);
        }
        trimEvents(str, i11);
    }

    private static void writeTextFile(File file, String str, long j11) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(convertTimestampFromSecondsToMs(j11));
            outputStreamWriter.close();
            return;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
