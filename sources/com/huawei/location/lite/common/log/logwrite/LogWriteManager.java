package com.huawei.location.lite.common.log.logwrite;

import android.util.Log;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class LogWriteManager {
    private static final int MAX_WAIT_TIMEOUT = 60;
    /* access modifiers changed from: private */
    public static final Object OBJECT_LOCK = new Object();
    private static final String TAG = "LogWriteManager";
    private static final String THREAD_NAME = "LogWriteThread";
    private static LogWriteManager mInstance = new LogWriteManager();
    private final BlockingQueue<AppLog> blockingQueue = new ArrayBlockingQueue(256);
    /* access modifiers changed from: private */
    public int fileExpiredTime = -1;
    /* access modifiers changed from: private */
    public int fileMaxNum = -1;
    private boolean isInit = false;
    /* access modifiers changed from: private */
    public boolean isStarted = false;
    /* access modifiers changed from: private */
    public volatile String logPath;
    /* access modifiers changed from: private */
    public LogWrite logWrite;
    /* access modifiers changed from: private */
    public int perFileSize = -1;
    private WriteWorker worker = new WriteWorker();

    public class WriteWorker extends Thread {
        public WriteWorker() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                java.lang.Object r1 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.OBJECT_LOCK
                monitor-enter(r1)
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r2 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this     // Catch:{ all -> 0x0075 }
                com.huawei.location.lite.common.log.logwrite.LogWrite r2 = r2.logWrite     // Catch:{ all -> 0x0075 }
                int r3 = r0.perFileSize     // Catch:{ all -> 0x0075 }
                java.lang.String r4 = r0.logPath     // Catch:{ all -> 0x0075 }
                int r5 = r0.fileMaxNum     // Catch:{ all -> 0x0075 }
                int r6 = r0.fileExpiredTime     // Catch:{ all -> 0x0075 }
                r2.init(r3, r4, r5, r6)     // Catch:{ all -> 0x0075 }
                monitor-exit(r1)     // Catch:{ all -> 0x0075 }
            L_0x0021:
                boolean r1 = r0.isStarted
                if (r1 == 0) goto L_0x003e
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r1 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this     // Catch:{ InterruptedException -> 0x0037, Exception -> 0x0032, Error -> 0x002d }
                r1.write(r0)     // Catch:{ InterruptedException -> 0x0037, Exception -> 0x0032, Error -> 0x002d }
                goto L_0x0021
            L_0x002d:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker Error"
                goto L_0x003b
            L_0x0032:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker IllegalMonitorStateException"
                goto L_0x003b
            L_0x0037:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker InterruptedException"
            L_0x003b:
                android.util.Log.i(r0, r1)
            L_0x003e:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker end."
                android.util.Log.i(r0, r1)
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                com.huawei.location.lite.common.log.logwrite.LogWrite r0 = r0.logWrite
                if (r0 == 0) goto L_0x006e
                com.huawei.location.lite.common.log.logwrite.AppLog r0 = new com.huawei.location.lite.common.log.logwrite.AppLog
                java.lang.String r2 = "I"
                java.lang.String r3 = "LogWriteManager"
                java.lang.String r4 = "PrintWoker end."
                java.lang.String r5 = "log"
                r6 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6)
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r1 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                com.huawei.location.lite.common.log.logwrite.LogWrite r1 = r1.logWrite
                r1.writeToFile(r0)
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                com.huawei.location.lite.common.log.logwrite.LogWrite r0 = r0.logWrite
                r0.shutdown()
            L_0x006e:
                com.huawei.location.lite.common.log.logwrite.LogWriteManager r0 = com.huawei.location.lite.common.log.logwrite.LogWriteManager.this
                r1 = 0
                boolean unused = r0.isStarted = r1
                return
            L_0x0075:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0075 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.log.logwrite.LogWriteManager.WriteWorker.run():void");
        }
    }

    private LogWriteManager() {
        Log.i(TAG, "LogWriteManager onCreate");
    }

    public static LogWriteManager getInstance() {
        return mInstance;
    }

    private void start() {
        String str;
        try {
            if (!this.isStarted) {
                this.isStarted = true;
                this.worker.setName(THREAD_NAME);
                this.worker.start();
            }
        } catch (IllegalThreadStateException unused) {
            str = "worker IllegalThreadStateException";
            Log.i(TAG, str);
            this.isStarted = false;
            this.isInit = false;
        } catch (Exception unused2) {
            str = "worker Exception";
            Log.i(TAG, str);
            this.isStarted = false;
            this.isInit = false;
        }
    }

    /* access modifiers changed from: private */
    public void write(LogWriteManager logWriteManager) throws InterruptedException {
        AppLog poll = logWriteManager.blockingQueue.poll(60, TimeUnit.SECONDS);
        LogWrite logWrite2 = this.logWrite;
        if (logWrite2 == null) {
            return;
        }
        if (poll != null) {
            logWrite2.writeToFile(poll);
            return;
        }
        logWrite2.shutdown();
        this.logWrite.writeToFile(logWriteManager.blockingQueue.take());
    }

    public boolean appendLog(AppLog appLog) {
        return this.blockingQueue.offer(appLog);
    }

    public String getLogPath() {
        return this.logPath;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(com.huawei.location.lite.common.log.logwrite.LogWriteParam r4) {
        /*
            r3 = this;
            java.lang.Object r0 = OBJECT_LOCK
            monitor-enter(r0)
            boolean r1 = r3.isInit     // Catch:{ all -> 0x0050 }
            if (r1 != 0) goto L_0x0047
            java.lang.String r1 = "LogWriteManager"
            java.lang.String r2 = "first init"
            android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0050 }
            java.lang.String r1 = r4.getLogPath()     // Catch:{ all -> 0x0050 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x0021
            java.lang.String r4 = "LogWriteManager"
            java.lang.String r1 = "logPath is empty"
            android.util.Log.i(r4, r1)     // Catch:{ all -> 0x0050 }
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return
        L_0x0021:
            java.lang.String r1 = r4.getLogPath()     // Catch:{ all -> 0x0050 }
            r3.logPath = r1     // Catch:{ all -> 0x0050 }
            int r1 = r4.getFileSize()     // Catch:{ all -> 0x0050 }
            r3.perFileSize = r1     // Catch:{ all -> 0x0050 }
            int r1 = r4.getFileNum()     // Catch:{ all -> 0x0050 }
            r3.fileMaxNum = r1     // Catch:{ all -> 0x0050 }
            int r4 = r4.getFileExpiredTime()     // Catch:{ all -> 0x0050 }
            r3.fileExpiredTime = r4     // Catch:{ all -> 0x0050 }
            com.huawei.location.lite.common.log.logwrite.LogWrite r4 = new com.huawei.location.lite.common.log.logwrite.LogWrite     // Catch:{ all -> 0x0050 }
            r4.<init>()     // Catch:{ all -> 0x0050 }
            r3.logWrite = r4     // Catch:{ all -> 0x0050 }
            r3.start()     // Catch:{ all -> 0x0050 }
            r4 = 1
            r3.isInit = r4     // Catch:{ all -> 0x0050 }
            goto L_0x004e
        L_0x0047:
            java.lang.String r4 = "LogWriteManager"
            java.lang.String r1 = "already init"
            android.util.Log.i(r4, r1)     // Catch:{ all -> 0x0050 }
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return
        L_0x0050:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.lite.common.log.logwrite.LogWriteManager.init(com.huawei.location.lite.common.log.logwrite.LogWriteParam):void");
    }

    public void stop() {
        this.isStarted = false;
        appendLog(new AppLog("I", TAG, "printWorker is stop", (Throwable) null));
    }
}
