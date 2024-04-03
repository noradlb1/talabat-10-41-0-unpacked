package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class ServiceManager implements ServiceManagerBridge {
    /* access modifiers changed from: private */
    public static final ListenerCallQueue.Event<Listener> HEALTHY_EVENT = new ListenerCallQueue.Event<Listener>() {
        public String toString() {
            return "healthy()";
        }

        public void call(Listener listener) {
            listener.healthy();
        }
    };
    /* access modifiers changed from: private */
    public static final ListenerCallQueue.Event<Listener> STOPPED_EVENT = new ListenerCallQueue.Event<Listener>() {
        public String toString() {
            return "stopped()";
        }

        public void call(Listener listener) {
            listener.stopped();
        }
    };
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
    private final ImmutableList<Service> services;
    private final ServiceManagerState state;

    public static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }
    }

    public static abstract class Listener {
        public void failure(Service service2) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    public static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        public void doStart() {
            notifyStarted();
        }

        public void doStop() {
            notifyStopped();
        }
    }

    public static final class ServiceListener extends Service.Listener {

        /* renamed from: service  reason: collision with root package name */
        final Service f44701service;
        final WeakReference<ServiceManagerState> state;

        public ServiceListener(Service service2, WeakReference<ServiceManagerState> weakReference) {
            this.f44701service = service2;
            this.state = weakReference;
        }

        public void failed(Service.State state2, Throwable th2) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                if (!(this.f44701service instanceof NoOpService)) {
                    Logger access$200 = ServiceManager.logger;
                    Level level = Level.SEVERE;
                    access$200.log(level, "Service " + this.f44701service + " has failed in the " + state2 + " state.", th2);
                }
                serviceManagerState.transitionService(this.f44701service, state2, Service.State.FAILED);
            }
        }

        public void running() {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.f44701service, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        public void starting() {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.f44701service, Service.State.NEW, Service.State.STARTING);
                if (!(this.f44701service instanceof NoOpService)) {
                    ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.f44701service);
                }
            }
        }

        public void stopping(Service.State state2) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.f44701service, state2, Service.State.STOPPING);
            }
        }

        public void terminated(Service.State state2) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                if (!(this.f44701service instanceof NoOpService)) {
                    ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.f44701service, state2});
                }
                serviceManagerState.transitionService(this.f44701service, state2, Service.State.TERMINATED);
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        boolean z11;
        ImmutableList<E> copyOf = ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning());
            copyOf = ImmutableList.of(new NoOpService());
        }
        ServiceManagerState serviceManagerState = new ServiceManagerState(copyOf);
        this.state = serviceManagerState;
        this.services = copyOf;
        WeakReference weakReference = new WeakReference(serviceManagerState);
        UnmodifiableIterator<E> it = copyOf.iterator();
        while (it.hasNext()) {
            Service service2 = (Service) it.next();
            service2.addListener(new ServiceListener(service2, weakReference), MoreExecutors.directExecutor());
            if (service2.state() == Service.State.NEW) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "Can only manage NEW services, %s", (Object) service2);
        }
        this.state.markReady();
    }

    public void addListener(Listener listener, Executor executor) {
        this.state.addListener(listener, executor);
    }

    public void awaitHealthy() {
        this.state.awaitHealthy();
    }

    public void awaitStopped() {
        this.state.awaitStopped();
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    @CanIgnoreReturnValue
    public ServiceManager startAsync() {
        boolean z11;
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            if (it.next().state() == Service.State.NEW) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "Not all services are NEW, cannot start %s", (Object) this);
        }
        UnmodifiableIterator<Service> it2 = this.services.iterator();
        while (it2.hasNext()) {
            Service next = it2.next();
            try {
                this.state.tryStartTiming(next);
                next.startAsync();
            } catch (IllegalStateException e11) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                logger2.log(level, "Unable to start Service " + next, e11);
            }
        }
        return this;
    }

    public ImmutableMap<Service, Long> startupTimes() {
        return this.state.startupTimes();
    }

    @CanIgnoreReturnValue
    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            it.next().stopAsync();
        }
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Class<?>) ServiceManager.class).add("services", (Object) Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
    }

    public static final class ServiceManagerState {
        final Monitor.Guard awaitHealthGuard;
        final ListenerCallQueue<Listener> listeners;
        final Monitor monitor = new Monitor();
        final int numberOfServices;
        @GuardedBy("monitor")
        boolean ready;
        @GuardedBy("monitor")
        final SetMultimap<Service.State, Service> servicesByState;
        @GuardedBy("monitor")
        final Map<Service, Stopwatch> startupTimers;
        @GuardedBy("monitor")
        final Multiset<Service.State> states;
        final Monitor.Guard stoppedGuard;
        @GuardedBy("monitor")
        boolean transitioned;

        public final class AwaitHealthGuard extends Monitor.Guard {
            public AwaitHealthGuard() {
                super(ServiceManagerState.this.monitor);
            }

            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                int count = ServiceManagerState.this.states.count(Service.State.RUNNING);
                ServiceManagerState serviceManagerState = ServiceManagerState.this;
                if (count == serviceManagerState.numberOfServices || serviceManagerState.states.contains(Service.State.STOPPING) || ServiceManagerState.this.states.contains(Service.State.TERMINATED) || ServiceManagerState.this.states.contains(Service.State.FAILED)) {
                    return true;
                }
                return false;
            }
        }

        public final class StoppedGuard extends Monitor.Guard {
            public StoppedGuard() {
                super(ServiceManagerState.this.monitor);
            }

            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                return ServiceManagerState.this.states.count(Service.State.TERMINATED) + ServiceManagerState.this.states.count(Service.State.FAILED) == ServiceManagerState.this.numberOfServices;
            }
        }

        public ServiceManagerState(ImmutableCollection<Service> immutableCollection) {
            SetMultimap<Service.State, Service> build = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
            this.servicesByState = build;
            this.states = build.keys();
            this.startupTimers = Maps.newIdentityHashMap();
            this.awaitHealthGuard = new AwaitHealthGuard();
            this.stoppedGuard = new StoppedGuard();
            this.listeners = new ListenerCallQueue<>();
            this.numberOfServices = immutableCollection.size();
            build.putAll(Service.State.NEW, immutableCollection);
        }

        public void addListener(Listener listener, Executor executor) {
            this.listeners.addListener(listener, executor);
        }

        public void awaitHealthy() {
            this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
            try {
                checkHealthy();
            } finally {
                this.monitor.leave();
            }
        }

        public void awaitStopped() {
            this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
            this.monitor.leave();
        }

        @GuardedBy("monitor")
        public void checkHealthy() {
            Multiset<Service.State> multiset = this.states;
            Service.State state = Service.State.RUNNING;
            if (multiset.count(state) != this.numberOfServices) {
                throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(state))));
            }
        }

        public void dispatchListenerEvents() {
            Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.listeners.dispatch();
        }

        public void enqueueFailedEvent(final Service service2) {
            this.listeners.enqueue(new ListenerCallQueue.Event<Listener>(this) {
                public String toString() {
                    return "failed({service=" + service2 + "})";
                }

                public void call(Listener listener) {
                    listener.failure(service2);
                }
            });
        }

        public void enqueueHealthyEvent() {
            this.listeners.enqueue(ServiceManager.HEALTHY_EVENT);
        }

        public void enqueueStoppedEvent() {
            this.listeners.enqueue(ServiceManager.STOPPED_EVENT);
        }

        public void markReady() {
            this.monitor.enter();
            try {
                if (!this.transitioned) {
                    this.ready = true;
                    return;
                }
                ArrayList newArrayList = Lists.newArrayList();
                UnmodifiableIterator<Service> it = servicesByState().values().iterator();
                while (it.hasNext()) {
                    Service next = it.next();
                    if (next.state() != Service.State.NEW) {
                        newArrayList.add(next);
                    }
                }
                throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + newArrayList);
            } finally {
                this.monitor.leave();
            }
        }

        /* JADX INFO: finally extract failed */
        public ImmutableSetMultimap<Service.State, Service> servicesByState() {
            ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
            this.monitor.enter();
            try {
                for (Map.Entry entry : this.servicesByState.entries()) {
                    if (!(entry.getValue() instanceof NoOpService)) {
                        builder.put(entry);
                    }
                }
                this.monitor.leave();
                return builder.build();
            } catch (Throwable th2) {
                this.monitor.leave();
                throw th2;
            }
        }

        /* JADX INFO: finally extract failed */
        public ImmutableMap<Service, Long> startupTimes() {
            this.monitor.enter();
            try {
                ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(this.startupTimers.size());
                for (Map.Entry next : this.startupTimers.entrySet()) {
                    Service service2 = (Service) next.getKey();
                    Stopwatch stopwatch = (Stopwatch) next.getValue();
                    if (!stopwatch.isRunning() && !(service2 instanceof NoOpService)) {
                        newArrayListWithCapacity.add(Maps.immutableEntry(service2, Long.valueOf(stopwatch.elapsed(TimeUnit.MILLISECONDS))));
                    }
                }
                this.monitor.leave();
                Collections.sort(newArrayListWithCapacity, Ordering.natural().onResultOf(new Function<Map.Entry<Service, Long>, Long>(this) {
                    public Long apply(Map.Entry<Service, Long> entry) {
                        return entry.getValue();
                    }
                }));
                return ImmutableMap.copyOf(newArrayListWithCapacity);
            } catch (Throwable th2) {
                this.monitor.leave();
                throw th2;
            }
        }

        public void transitionService(Service service2, Service.State state, Service.State state2) {
            boolean z11;
            Preconditions.checkNotNull(service2);
            if (state != state2) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkArgument(z11);
            this.monitor.enter();
            try {
                this.transitioned = true;
                if (this.ready) {
                    Preconditions.checkState(this.servicesByState.remove(state, service2), "Service %s not at the expected location in the state map %s", (Object) service2, (Object) state);
                    Preconditions.checkState(this.servicesByState.put(state2, service2), "Service %s in the state map unexpectedly at %s", (Object) service2, (Object) state2);
                    Stopwatch stopwatch = this.startupTimers.get(service2);
                    if (stopwatch == null) {
                        stopwatch = Stopwatch.createStarted();
                        this.startupTimers.put(service2, stopwatch);
                    }
                    Service.State state3 = Service.State.RUNNING;
                    if (state2.compareTo(state3) >= 0 && stopwatch.isRunning()) {
                        stopwatch.stop();
                        if (!(service2 instanceof NoOpService)) {
                            ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[]{service2, stopwatch});
                        }
                    }
                    Service.State state4 = Service.State.FAILED;
                    if (state2 == state4) {
                        enqueueFailedEvent(service2);
                    }
                    if (this.states.count(state3) == this.numberOfServices) {
                        enqueueHealthyEvent();
                    } else if (this.states.count(Service.State.TERMINATED) + this.states.count(state4) == this.numberOfServices) {
                        enqueueStoppedEvent();
                    }
                    this.monitor.leave();
                    dispatchListenerEvents();
                }
            } finally {
                this.monitor.leave();
                dispatchListenerEvents();
            }
        }

        public void tryStartTiming(Service service2) {
            this.monitor.enter();
            try {
                if (this.startupTimers.get(service2) == null) {
                    this.startupTimers.put(service2, Stopwatch.createStarted());
                }
            } finally {
                this.monitor.leave();
            }
        }

        public void awaitStopped(long j11, TimeUnit timeUnit) throws TimeoutException {
            this.monitor.enter();
            try {
                if (!this.monitor.waitForUninterruptibly(this.stoppedGuard, j11, timeUnit)) {
                    throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                }
            } finally {
                this.monitor.leave();
            }
        }

        public void awaitHealthy(long j11, TimeUnit timeUnit) throws TimeoutException {
            this.monitor.enter();
            try {
                if (this.monitor.waitForUninterruptibly(this.awaitHealthGuard, j11, timeUnit)) {
                    checkHealthy();
                    return;
                }
                throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
            } finally {
                this.monitor.leave();
            }
        }
    }

    public void awaitHealthy(long j11, TimeUnit timeUnit) throws TimeoutException {
        this.state.awaitHealthy(j11, timeUnit);
    }

    public void awaitStopped(long j11, TimeUnit timeUnit) throws TimeoutException {
        this.state.awaitStopped(j11, timeUnit);
    }

    public ImmutableSetMultimap<Service.State, Service> servicesByState() {
        return this.state.servicesByState();
    }
}
