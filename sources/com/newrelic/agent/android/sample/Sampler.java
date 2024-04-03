package com.newrelic.agent.android.sample;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Sample;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Sampler implements TraceLifecycleAware, Runnable {
    private static final int KB_IN_MB = 1024;
    private static final int[] PID = {Process.myPid()};
    protected static final long SAMPLE_FREQ_MS = 100;
    protected static final long SAMPLE_FREQ_MS_MAX = 250;
    protected static boolean cpuSamplingDisabled = false;
    /* access modifiers changed from: private */
    public static final AgentLog log = AgentLogManager.getAgentLog();
    protected static Sampler sampler;
    private static final ReentrantLock samplerLock = new ReentrantLock();
    protected static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Sampler"));
    private final ActivityManager activityManager;
    private RandomAccessFile appStatFile;
    protected final AtomicBoolean isRunning = new AtomicBoolean(false);
    private Long lastAppCpuTime;
    private Long lastCpuTime;
    private RandomAccessFile procStatFile;
    protected long sampleFreqMs = 100;
    protected ScheduledFuture sampleFuture;
    private Metric samplerServiceMetric;
    private final EnumMap<Sample.SampleType, Collection<Sample>> samples;

    public Sampler(Context context) {
        EnumMap<Sample.SampleType, Collection<Sample>> enumMap = new EnumMap<>(Sample.SampleType.class);
        this.samples = enumMap;
        this.activityManager = (ActivityManager) context.getSystemService("activity");
        enumMap.put(Sample.SampleType.MEMORY, new ArrayList());
        enumMap.put(Sample.SampleType.CPU, new ArrayList());
    }

    /* JADX INFO: finally extract failed */
    public static Map<Sample.SampleType, Collection<Sample>> copySamples() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            if (sampler == null) {
                reentrantLock.unlock();
                HashMap hashMap = new HashMap();
                reentrantLock.unlock();
                return hashMap;
            }
            EnumMap enumMap = new EnumMap(sampler.samples);
            for (Sample.SampleType next : sampler.samples.keySet()) {
                enumMap.put(next, new ArrayList(sampler.samples.get(next)));
            }
            samplerLock.unlock();
            return Collections.unmodifiableMap(enumMap);
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
    }

    private Collection<Sample> getSampleCollection(Sample.SampleType sampleType) {
        return this.samples.get(sampleType);
    }

    public static void init(Context context) {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            if (sampler == null) {
                Sampler provideSampler = provideSampler(context);
                sampler = provideSampler;
                provideSampler.sampleFreqMs = 100;
                provideSampler.samplerServiceMetric = new Metric("samplerServiceTime");
                TraceMachine.addTraceListener(sampler);
                if (Build.VERSION.SDK_INT >= 24) {
                    cpuSamplingDisabled = true;
                    log.debug("CPU sampling not supported in Android 8 and above.");
                }
                log.debug("Sampler initialized");
            }
            reentrantLock.unlock();
        } catch (Exception e11) {
            AgentLog agentLog = log;
            agentLog.error("Sampler init failed: " + e11.getMessage());
            shutdown();
            samplerLock.unlock();
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
    }

    public static boolean isRunning() {
        ScheduledFuture scheduledFuture;
        Sampler sampler2 = sampler;
        if (sampler2 == null || (scheduledFuture = sampler2.sampleFuture) == null) {
            return false;
        }
        return !scheduledFuture.isDone();
    }

    public static Sampler provideSampler(Context context) {
        return new Sampler(context);
    }

    private void resetCpuSampler() {
        this.lastCpuTime = null;
        this.lastAppCpuTime = null;
        RandomAccessFile randomAccessFile = this.appStatFile;
        if (randomAccessFile != null && this.procStatFile != null) {
            try {
                randomAccessFile.close();
                this.procStatFile.close();
                this.appStatFile = null;
                this.procStatFile = null;
            } catch (IOException e11) {
                AgentLog agentLog = log;
                agentLog.debug("Exception hit while resetting CPU sampler: " + e11.getMessage());
                AgentHealth.noticeException((Exception) e11);
            }
        }
    }

    public static Sample sampleCpuInstance() {
        Sampler sampler2 = sampler;
        if (sampler2 == null) {
            return null;
        }
        return sampler2.sampleCpu();
    }

    public static Sample sampleMemory() {
        Sampler sampler2 = sampler;
        if (sampler2 == null) {
            return null;
        }
        return sampleMemory(sampler2.activityManager);
    }

    public static void shutdown() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            Sampler sampler2 = sampler;
            if (sampler2 != null) {
                TraceMachine.removeTraceListener(sampler2);
                stopNow();
                sampler = null;
                log.debug("Sampler shutdown");
            }
            reentrantLock.unlock();
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
    }

    public static void start() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            Sampler sampler2 = sampler;
            if (sampler2 != null) {
                sampler2.schedule();
                log.debug("Sampler started");
            }
            reentrantLock.unlock();
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
    }

    public static void stop() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            Sampler sampler2 = sampler;
            if (sampler2 != null) {
                sampler2.stop(false);
                log.debug("Sampler stopped");
            }
            reentrantLock.unlock();
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
    }

    public static void stopNow() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            Sampler sampler2 = sampler;
            if (sampler2 != null) {
                sampler2.stop(true);
                log.debug("Sampler hard stopped");
            }
            reentrantLock.unlock();
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
    }

    public void clear() {
        for (Collection<Sample> clear : this.samples.values()) {
            clear.clear();
        }
    }

    public void monitorSamplerServiceTime(double d11) {
        this.samplerServiceMetric.sample(d11);
        if (Double.valueOf(this.samplerServiceMetric.getTotal() / ((double) this.samplerServiceMetric.getCount())).doubleValue() > ((double) this.sampleFreqMs)) {
            AgentLog agentLog = log;
            agentLog.debug("Sampler: sample service time has been exceeded. Increase by 10%");
            this.sampleFreqMs = Math.min((long) (((float) this.sampleFreqMs) * 1.1f), 250);
            ScheduledFuture scheduledFuture = this.sampleFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.sampleFuture = scheduler.scheduleWithFixedDelay(this, 0, this.sampleFreqMs, TimeUnit.MILLISECONDS);
            agentLog.debug(String.format("Sampler scheduler restarted; sampling will now occur every %d ms.", new Object[]{Long.valueOf(this.sampleFreqMs)}));
            this.samplerServiceMetric.clear();
        }
    }

    public void onEnterMethod() {
        if (!this.isRunning.get()) {
            start();
        }
    }

    public void onExitMethod() {
    }

    public void onTraceComplete(final ActivityTrace activityTrace) {
        scheduler.execute(new Runnable() {
            public void run() {
                try {
                    Sampler.this.stop(true);
                    activityTrace.setVitals(Sampler.copySamples());
                    Sampler.this.clear();
                } catch (RuntimeException e11) {
                    Sampler.log.error(e11.toString());
                }
            }
        });
    }

    public void onTraceRename(ActivityTrace activityTrace) {
    }

    public void onTraceStart(ActivityTrace activityTrace) {
        start();
    }

    public void run() {
        try {
            if (this.isRunning.get()) {
                sample();
            }
        } catch (Exception e11) {
            log.error("Caught exception while running the sampler", e11);
            AgentHealth.noticeException(e11);
        }
    }

    public void sample() {
        TicToc ticToc = new TicToc();
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            ticToc.tic();
            Sample sampleMemory = sampleMemory();
            if (sampleMemory != null) {
                getSampleCollection(Sample.SampleType.MEMORY).add(sampleMemory);
            }
            Sample sampleCpu = sampleCpu();
            if (sampleCpu != null) {
                getSampleCollection(Sample.SampleType.CPU).add(sampleCpu);
            }
        } catch (Exception e11) {
            AgentLog agentLog = log;
            agentLog.error("Sampling failed: " + e11.getMessage());
            AgentHealth.noticeException(e11);
            reentrantLock = samplerLock;
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
        reentrantLock.unlock();
        monitorSamplerServiceTime((double) ticToc.toc());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x00ae A[Catch:{ Exception -> 0x00e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bb A[Catch:{ Exception -> 0x00e8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.newrelic.agent.android.tracing.Sample sampleCpu() {
        /*
            r10 = this;
            java.lang.String r0 = "r"
            java.lang.String r1 = " "
            boolean r2 = cpuSamplingDisabled
            r3 = 0
            if (r2 == 0) goto L_0x000a
            return r3
        L_0x000a:
            java.io.RandomAccessFile r2 = r10.procStatFile     // Catch:{ Exception -> 0x00e8 }
            if (r2 == 0) goto L_0x001e
            java.io.RandomAccessFile r4 = r10.appStatFile     // Catch:{ Exception -> 0x00e8 }
            if (r4 != 0) goto L_0x0013
            goto L_0x001e
        L_0x0013:
            r4 = 0
            r2.seek(r4)     // Catch:{ Exception -> 0x00e8 }
            java.io.RandomAccessFile r0 = r10.appStatFile     // Catch:{ Exception -> 0x00e8 }
            r0.seek(r4)     // Catch:{ Exception -> 0x00e8 }
            goto L_0x0049
        L_0x001e:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00e8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e8 }
            r4.<init>()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ Exception -> 0x00e8 }
            int[] r5 = PID     // Catch:{ Exception -> 0x00e8 }
            r6 = 0
            r5 = r5[r6]     // Catch:{ Exception -> 0x00e8 }
            r4.append(r5)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r5 = "/stat"
            r4.append(r5)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x00e8 }
            r2.<init>(r4, r0)     // Catch:{ Exception -> 0x00e8 }
            r10.appStatFile = r2     // Catch:{ Exception -> 0x00e8 }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r4 = "/proc/stat"
            r2.<init>(r4, r0)     // Catch:{ Exception -> 0x00e8 }
            r10.procStatFile = r2     // Catch:{ Exception -> 0x00e8 }
        L_0x0049:
            java.io.RandomAccessFile r0 = r10.procStatFile     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r0 = r0.readLine()     // Catch:{ Exception -> 0x00e8 }
            java.io.RandomAccessFile r2 = r10.appStatFile     // Catch:{ Exception -> 0x00e8 }
            java.lang.String r2 = r2.readLine()     // Catch:{ Exception -> 0x00e8 }
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ Exception -> 0x00e8 }
            java.lang.String[] r1 = r2.split(r1)     // Catch:{ Exception -> 0x00e8 }
            r2 = 2
            r2 = r0[r2]     // Catch:{ Exception -> 0x00e8 }
            long r4 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x00e8 }
            r2 = 3
            r2 = r0[r2]     // Catch:{ Exception -> 0x00e8 }
            long r6 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x00e8 }
            long r4 = r4 + r6
            r2 = 4
            r2 = r0[r2]     // Catch:{ Exception -> 0x00e8 }
            long r6 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x00e8 }
            long r4 = r4 + r6
            r2 = 5
            r2 = r0[r2]     // Catch:{ Exception -> 0x00e8 }
            long r6 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x00e8 }
            long r4 = r4 + r6
            r2 = 6
            r2 = r0[r2]     // Catch:{ Exception -> 0x00e8 }
            long r6 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x00e8 }
            long r4 = r4 + r6
            r2 = 7
            r2 = r0[r2]     // Catch:{ Exception -> 0x00e8 }
            long r6 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x00e8 }
            long r4 = r4 + r6
            r2 = 8
            r0 = r0[r2]     // Catch:{ Exception -> 0x00e8 }
            long r6 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00e8 }
            long r4 = r4 + r6
            r0 = 13
            r0 = r1[r0]     // Catch:{ Exception -> 0x00e8 }
            long r6 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00e8 }
            r0 = 14
            r0 = r1[r0]     // Catch:{ Exception -> 0x00e8 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00e8 }
            long r6 = r6 + r0
            java.lang.Long r0 = r10.lastCpuTime     // Catch:{ Exception -> 0x00e8 }
            if (r0 != 0) goto L_0x00bb
            java.lang.Long r0 = r10.lastAppCpuTime     // Catch:{ Exception -> 0x00e8 }
            if (r0 != 0) goto L_0x00bb
            java.lang.Long r0 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x00e8 }
            r10.lastCpuTime = r0     // Catch:{ Exception -> 0x00e8 }
            java.lang.Long r0 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00e8 }
            r10.lastAppCpuTime = r0     // Catch:{ Exception -> 0x00e8 }
            return r3
        L_0x00bb:
            com.newrelic.agent.android.tracing.Sample r0 = new com.newrelic.agent.android.tracing.Sample     // Catch:{ Exception -> 0x00e8 }
            com.newrelic.agent.android.tracing.Sample$SampleType r1 = com.newrelic.agent.android.tracing.Sample.SampleType.CPU     // Catch:{ Exception -> 0x00e8 }
            r0.<init>((com.newrelic.agent.android.tracing.Sample.SampleType) r1)     // Catch:{ Exception -> 0x00e8 }
            java.lang.Long r1 = r10.lastAppCpuTime     // Catch:{ Exception -> 0x00e8 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00e8 }
            long r1 = r6 - r1
            double r1 = (double) r1     // Catch:{ Exception -> 0x00e8 }
            java.lang.Long r8 = r10.lastCpuTime     // Catch:{ Exception -> 0x00e8 }
            long r8 = r8.longValue()     // Catch:{ Exception -> 0x00e8 }
            long r8 = r4 - r8
            double r8 = (double) r8     // Catch:{ Exception -> 0x00e8 }
            double r1 = r1 / r8
            r8 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r1 = r1 * r8
            r0.setSampleValue((double) r1)     // Catch:{ Exception -> 0x00e8 }
            java.lang.Long r1 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x00e8 }
            r10.lastCpuTime = r1     // Catch:{ Exception -> 0x00e8 }
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x00e8 }
            r10.lastAppCpuTime = r1     // Catch:{ Exception -> 0x00e8 }
            return r0
        L_0x00e8:
            r0 = move-exception
            r1 = 1
            cpuSamplingDisabled = r1
            com.newrelic.agent.android.logging.AgentLog r1 = log
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Exception hit while CPU sampling: "
            r2.append(r4)
            java.lang.String r4 = r0.getMessage()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.debug(r2)
            com.newrelic.agent.android.harvest.AgentHealth.noticeException((java.lang.Exception) r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.sample.Sampler.sampleCpu():com.newrelic.agent.android.tracing.Sample");
    }

    public void schedule() {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            if (!this.isRunning.get()) {
                clear();
                this.sampleFuture = scheduler.scheduleWithFixedDelay(this, 0, this.sampleFreqMs, TimeUnit.MILLISECONDS);
                this.isRunning.set(true);
                log.debug(String.format("Sampler scheduler started; sampling will occur every %d ms.", new Object[]{Long.valueOf(this.sampleFreqMs)}));
            }
        } catch (Exception e11) {
            AgentLog agentLog = log;
            agentLog.error("Sampler scheduling failed: " + e11.getMessage());
            AgentHealth.noticeException(e11);
            reentrantLock = samplerLock;
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
        reentrantLock.unlock();
    }

    public static Sample sampleMemory(ActivityManager activityManager2) {
        int totalPss;
        try {
            Debug.MemoryInfo[] processMemoryInfo = activityManager2.getProcessMemoryInfo(PID);
            if (processMemoryInfo.length <= 0 || (totalPss = processMemoryInfo[0].getTotalPss()) < 0) {
                return null;
            }
            Sample sample = new Sample(Sample.SampleType.MEMORY);
            sample.setSampleValue(((double) totalPss) / 1024.0d);
            return sample;
        } catch (Exception e11) {
            AgentLog agentLog = log;
            agentLog.error("Sample memory failed: " + e11.getMessage());
            AgentHealth.noticeException(e11);
            return null;
        }
    }

    public void stop(boolean z11) {
        ReentrantLock reentrantLock = samplerLock;
        reentrantLock.lock();
        try {
            if (this.isRunning.get()) {
                this.isRunning.set(false);
                ScheduledFuture scheduledFuture = this.sampleFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(z11);
                }
                resetCpuSampler();
                log.debug("Sampler canceled");
            }
            reentrantLock.unlock();
        } catch (Exception e11) {
            AgentLog agentLog = log;
            agentLog.error("Sampler stop failed: " + e11.getMessage());
            AgentHealth.noticeException(e11);
            samplerLock.unlock();
        } catch (Throwable th2) {
            samplerLock.unlock();
            throw th2;
        }
    }
}
