package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HarvestTimer implements Runnable {
    public static final long DEFAULT_HARVEST_PERIOD = 60000;
    private static final long HARVEST_PERIOD_LEEWAY = 1000;
    private static final long NEVER_TICKED = -1;
    protected final Harvester harvester;
    protected long lastTickTime;
    private Lock lock = new ReentrantLock();
    private final AgentLog log = AgentLogManager.getAgentLog();
    protected long period = 60000;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("Harvester"));
    private long startTimeMs;
    private ScheduledFuture tickFuture = null;

    public HarvestTimer(Harvester harvester2) {
        this.harvester = harvester2;
        this.startTimeMs = 0;
    }

    private long now() {
        return System.currentTimeMillis();
    }

    private void tickIfReady() {
        long timeSinceLastTick = timeSinceLastTick();
        if (1000 + timeSinceLastTick >= this.period || timeSinceLastTick == -1) {
            AgentLog agentLog = this.log;
            agentLog.debug("HarvestTimer: time since last tick: " + timeSinceLastTick);
            long now = now();
            try {
                tick();
            } catch (Exception e11) {
                AgentLog agentLog2 = this.log;
                String message = e11.getMessage();
                agentLog2.error("HarvestTimer: Exception in timer tick: " + message);
                e11.printStackTrace();
                AgentHealth.noticeException(e11);
            }
            this.lastTickTime = now;
            AgentLog agentLog3 = this.log;
            agentLog3.debug("Set last tick time to: " + now);
            return;
        }
        AgentLog agentLog4 = this.log;
        long j11 = this.lastTickTime;
        agentLog4.debug("HarvestTimer: Tick is too soon (" + timeSinceLastTick + " delta) Last tick time: " + j11 + " . Skipping.");
    }

    public void cancelPendingTasks() {
        try {
            this.lock.lock();
            ScheduledFuture scheduledFuture = this.tickFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.tickFuture = null;
            }
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isRunning() {
        return this.tickFuture != null;
    }

    public void run() {
        try {
            this.lock.lock();
            tickIfReady();
        } catch (Exception e11) {
            AgentLog agentLog = this.log;
            String message = e11.getMessage();
            agentLog.error("HarvestTimer: Exception in timer tick: " + message);
            e11.printStackTrace();
            AgentHealth.noticeException(e11);
        } catch (Throwable th2) {
            this.lock.unlock();
            throw th2;
        }
        this.lock.unlock();
    }

    public void setPeriod(long j11) {
        this.period = j11;
    }

    public void shutdown() {
        cancelPendingTasks();
        this.scheduler.shutdownNow();
    }

    public void start() {
        if (ApplicationStateMonitor.isAppInBackground()) {
            this.log.warn("HarvestTimer: Attempting to start while app is in background");
        } else if (isRunning()) {
            this.log.warn("HarvestTimer: Attempting to start while already running");
        } else {
            long j11 = this.period;
            if (j11 <= 0) {
                this.log.error("HarvestTimer: Refusing to start with a period of 0 ms");
                return;
            }
            AgentLog agentLog = this.log;
            agentLog.debug("HarvestTimer: Starting with a period of " + j11 + "ms");
            this.startTimeMs = System.currentTimeMillis();
            this.tickFuture = this.scheduler.scheduleAtFixedRate(this, 0, this.period, TimeUnit.MILLISECONDS);
            this.harvester.start();
        }
    }

    public void stop() {
        if (!isRunning()) {
            this.log.warn("HarvestTimer: Attempting to stop when not running");
            return;
        }
        cancelPendingTasks();
        this.log.debug("HarvestTimer: Stopped.");
        this.startTimeMs = 0;
        this.harvester.stop();
    }

    public void tick() {
        this.log.debug("Harvest: tick");
        TicToc ticToc = new TicToc();
        ticToc.tic();
        try {
            if (ApplicationStateMonitor.isAppInBackground()) {
                this.log.error("HarvestTimer: Attempting to harvest while app is in background");
            } else {
                this.harvester.execute();
                this.log.debug("Harvest: executed");
            }
        } catch (Exception e11) {
            AgentLog agentLog = this.log;
            String message = e11.getMessage();
            agentLog.error("HarvestTimer: Exception in harvest execute: " + message);
            e11.printStackTrace();
            AgentHealth.noticeException(e11);
        }
        if (this.harvester.isDisabled()) {
            stop();
        }
        long cVar = ticToc.toc();
        AgentLog agentLog2 = this.log;
        agentLog2.debug("HarvestTimer tick took " + cVar + "ms");
    }

    public void tickNow() {
        try {
            this.scheduler.schedule(new Runnable() {
                public void run() {
                    this.tick();
                }
            }, 0, TimeUnit.SECONDS).get();
        } catch (Exception e11) {
            AgentLog agentLog = this.log;
            String message = e11.getMessage();
            agentLog.error("Exception waiting for tickNow to finish: " + message);
            e11.printStackTrace();
            AgentHealth.noticeException(e11);
        }
    }

    public long timeSinceLastTick() {
        if (this.lastTickTime == 0) {
            return -1;
        }
        return now() - this.lastTickTime;
    }

    public long timeSinceStart() {
        if (this.startTimeMs == 0) {
            return 0;
        }
        return now() - this.startTimeMs;
    }
}
