package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import i.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class EventManagerImpl implements EventManager, EventListener {
    public static final int DEFAULT_MAX_EVENT_BUFFER_SIZE = 1000;
    public static final int DEFAULT_MAX_EVENT_BUFFER_TIME = 600;
    public static final int DEFAULT_MIN_EVENT_BUFFER_SIZE = 64;
    public static final int DEFAULT_MIN_EVENT_BUFFER_TIME = 60;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private AtomicReference<List<AnalyticsEvent>> events;
    private final AtomicInteger eventsDropped;
    private final AtomicInteger eventsEvicted;
    private final AtomicInteger eventsRecorded;
    private long firstEventTimestamp;
    private final AtomicBoolean initialized;
    AtomicReference<EventManager> instance;
    private final AtomicReference<EventListener> listener;
    int maxBufferTimeInSec;
    int maxEventPoolSize;
    private final AtomicBoolean transmitRequired;

    public EventManagerImpl() {
        this(1000, 600);
    }

    public boolean addEvent(AnalyticsEvent analyticsEvent) {
        String str;
        if (!this.initialized.get()) {
            this.eventsDropped.incrementAndGet();
            return false;
        } else if (!this.listener.get().onEventAdded(analyticsEvent)) {
            AgentLog agentLog = log;
            String name2 = analyticsEvent.getName();
            agentLog.warn("Listener dropped new event[" + name2 + "]");
            this.eventsDropped.incrementAndGet();
            return false;
        } else {
            if (isMaxEventBufferTimeExceeded()) {
                this.listener.get().onEventQueueTimeExceeded(this.maxBufferTimeInSec);
            }
            synchronized (this.events.get()) {
                int size = this.events.get().size();
                if (size == 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.firstEventTimestamp = currentTimeMillis;
                    AgentLog agentLog2 = log;
                    agentLog2.debug("EventManager.addEvent(): Queue is empty, setting first event timestamp to " + currentTimeMillis);
                }
                if (size >= this.maxEventPoolSize) {
                    try {
                        if (this.listener.get().onEventOverflow(analyticsEvent)) {
                            AgentLog agentLog3 = log;
                            String name3 = analyticsEvent.getName();
                            agentLog3.warn("Listener dropped overflow event[" + name3 + "]");
                            this.eventsDropped.incrementAndGet();
                            agentLog3.debug("Event queue is full, scheduling harvest");
                            return false;
                        }
                        int random = (int) (Math.random() * ((double) this.eventsRecorded.get()));
                        if (random < this.maxEventPoolSize) {
                            if (this.listener.get().onEventEvicted((AnalyticsEvent) this.events.get().get(random))) {
                                this.events.get().remove(random);
                                this.eventsEvicted.incrementAndGet();
                            }
                        } else if (this.listener.get().onEventEvicted(analyticsEvent)) {
                            this.eventsDropped.incrementAndGet();
                            return false;
                        }
                        this.listener.get().onEventQueueSizeExceeded(size);
                        log.debug("Event queue is full, scheduling harvest");
                    } finally {
                        str = "Event queue is full, scheduling harvest";
                        log.debug(str);
                    }
                }
                if (!this.events.get().add(analyticsEvent)) {
                    return false;
                }
                this.eventsRecorded.incrementAndGet();
                return true;
            }
        }
    }

    public void empty() {
        Collection<AnalyticsEvent> queuedEventsSnapshot = getQueuedEventsSnapshot();
        if (queuedEventsSnapshot.size() > 0) {
            AgentLog agentLog = log;
            int size = queuedEventsSnapshot.size();
            agentLog.warn("EventManager.empty(): dropped [" + size + "] events");
        }
        queuedEventsSnapshot.clear();
        this.firstEventTimestamp = 0;
    }

    public int getEventsDropped() {
        return this.eventsDropped.get();
    }

    public int getEventsEjected() {
        return this.eventsEvicted.get();
    }

    public int getEventsRecorded() {
        return this.eventsRecorded.get();
    }

    public EventListener getListener() {
        return this.listener.get();
    }

    public int getMaxEventBufferTime() {
        return this.maxBufferTimeInSec;
    }

    public int getMaxEventPoolSize() {
        return this.maxEventPoolSize;
    }

    public Collection<AnalyticsEvent> getQueuedEvents() {
        Collection<AnalyticsEvent> unmodifiableCollection;
        synchronized (this.events.get()) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.events.get());
        }
        return unmodifiableCollection;
    }

    public Collection<AnalyticsEvent> getQueuedEventsSnapshot() {
        Collection<AnalyticsEvent> andSet;
        synchronized (this.events.get()) {
            this.listener.get().onEventFlush();
            this.transmitRequired.set(false);
            andSet = this.events.getAndSet(Collections.synchronizedList(new ArrayList(this.maxEventPoolSize)));
        }
        return andSet;
    }

    public void initialize(AgentConfiguration agentConfiguration) {
        if (!this.initialized.compareAndSet(false, true)) {
            log.verbose("EventManagerImpl.initialize(): Has already been initialized. Bypassing...");
            return;
        }
        this.firstEventTimestamp = 0;
        this.eventsRecorded.set(0);
        this.eventsEvicted.set(0);
        empty();
        this.listener.get().onStart(this);
    }

    public boolean isMaxEventBufferTimeExceeded() {
        if (this.firstEventTimestamp <= 0 || System.currentTimeMillis() - this.firstEventTimestamp <= ((long) (this.maxBufferTimeInSec * 1000))) {
            return false;
        }
        return true;
    }

    public boolean isMaxEventPoolSizeExceeded() {
        return this.events.get().size() > this.maxEventPoolSize;
    }

    public boolean isTransmitRequired() {
        if ((this.initialized.get() || this.events.get().size() <= 0) && !this.transmitRequired.compareAndSet(true, false) && !isMaxEventPoolSizeExceeded() && !isMaxEventBufferTimeExceeded()) {
            return false;
        }
        return true;
    }

    public boolean onEventAdded(AnalyticsEvent analyticsEvent) {
        AgentLog agentLog = log;
        AnalyticsEventCategory category = analyticsEvent.getCategory();
        agentLog.debug("Event [" + category + "] added to queue");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_ADDED);
        return true;
    }

    public boolean onEventEvicted(AnalyticsEvent analyticsEvent) {
        AgentLog agentLog = log;
        String name2 = analyticsEvent.getName();
        agentLog.warn("Event [" + name2 + "] evicted from queue");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_EVICTED);
        this.transmitRequired.set(true);
        return true;
    }

    public void onEventFlush() {
    }

    public boolean onEventOverflow(AnalyticsEvent analyticsEvent) {
        AgentLog agentLog = log;
        String name2 = analyticsEvent.getName();
        agentLog.warn("Event queue overflow adding event [" + name2 + "]");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_OVERFLOW);
        this.transmitRequired.set(true);
        return false;
    }

    public void onEventQueueSizeExceeded(int i11) {
        AgentLog agentLog = log;
        int i12 = this.maxEventPoolSize;
        agentLog.warn("Event queue size [" + i11 + "] exceeded max[" + i12 + "]");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_QUEUE_SIZE_EXCEEDED);
        this.transmitRequired.set(true);
    }

    public void onEventQueueTimeExceeded(int i11) {
        AgentLog agentLog = log;
        agentLog.warn("Event queue time [" + i11 + "] exceeded");
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_EVENT_QUEUE_TIME_EXCEEDED);
        this.transmitRequired.set(true);
    }

    public void onShutdown() {
        if (!this.events.get().isEmpty()) {
            AgentLog agentLog = log;
            int size = this.events.get().size();
            agentLog.warn("Event manager is shutting down with [" + size + "] events remaining in the queue");
        }
        this.transmitRequired.set(true);
    }

    public void onStart(EventManager eventManager) {
    }

    public void setEventListener(EventListener eventListener) {
        if (eventListener != null) {
            this.listener.set(eventListener);
        } else {
            this.listener.set(this);
        }
    }

    public void setMaxEventBufferTime(int i11) {
        if (i11 < 60) {
            log.error("Event buffer time cannot be shorter than 60 seconds");
            i11 = 60;
        }
        if (i11 > 600) {
            log.warn("Event buffer time should not be longer than 600 seconds");
            i11 = 600;
        }
        this.maxBufferTimeInSec = i11;
    }

    public void setMaxEventPoolSize(int i11) {
        if (i11 < 64) {
            log.error("Event queue cannot be smaller than 64");
            i11 = 64;
        }
        if (i11 > 1000) {
            log.warn("Event queue should not be larger than 1000");
        }
        this.maxEventPoolSize = i11;
    }

    public void setTransmitRequired() {
        this.transmitRequired.set(true);
    }

    public void shutdown() {
        this.listener.get().onShutdown();
        this.initialized.set(false);
    }

    public int size() {
        return this.events.get().size();
    }

    public EventManagerImpl(int i11, int i12) {
        this.initialized = new AtomicBoolean(false);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.eventsRecorded = atomicInteger;
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        this.eventsEvicted = atomicInteger2;
        AtomicInteger atomicInteger3 = new AtomicInteger(0);
        this.eventsDropped = atomicInteger3;
        this.transmitRequired = new AtomicBoolean(true);
        this.listener = new AtomicReference<>(this);
        this.instance = new AtomicReference<>((Object) null);
        this.events = new AtomicReference<>(Collections.synchronizedList(new ArrayList(i11)));
        this.maxBufferTimeInSec = i12;
        this.maxEventPoolSize = i11;
        this.firstEventTimestamp = 0;
        atomicInteger.set(0);
        atomicInteger2.set(0);
        atomicInteger3.set(0);
        b.a(this.instance, (Object) null, this);
    }

    public void empty(Collection<AnalyticsEvent> collection) {
        this.events.get().removeAll(collection);
    }
}
