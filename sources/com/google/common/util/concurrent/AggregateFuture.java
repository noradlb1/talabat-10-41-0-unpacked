package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    @CheckForNull
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

    public enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    public AggregateFuture(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z11, boolean z12) {
        super(immutableCollection.size());
        this.futures = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
        this.allMustSucceed = z11;
        this.collectsValues = z12;
    }

    private static boolean addCausalChain(Set<Throwable> set, Throwable th2) {
        while (th2 != null) {
            if (!set.add(th2)) {
                return false;
            }
            th2 = th2.getCause();
        }
        return true;
    }

    private void collectValueFromNonCancelledFuture(int i11, Future<? extends InputT> future) {
        try {
            collectOneValue(i11, Futures.getDone(future));
        } catch (ExecutionException e11) {
            handleException(e11.getCause());
        } catch (Error | RuntimeException e12) {
            handleException(e12);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: decrementCountAndMaybeComplete */
    public void lambda$init$1(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        boolean z11;
        int decrementRemainingAndGet = decrementRemainingAndGet();
        if (decrementRemainingAndGet >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "Less than 0 remaining futures");
        if (decrementRemainingAndGet == 0) {
            processCompleted(immutableCollection);
        }
    }

    private void handleException(Throwable th2) {
        Preconditions.checkNotNull(th2);
        if (this.allMustSucceed && !setException(th2) && addCausalChain(getOrInitSeenExceptions(), th2)) {
            log(th2);
        } else if (th2 instanceof Error) {
            log(th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(ListenableFuture listenableFuture, int i11) {
        try {
            if (listenableFuture.isCancelled()) {
                this.futures = null;
                cancel(false);
            } else {
                collectValueFromNonCancelledFuture(i11, listenableFuture);
            }
        } finally {
            lambda$init$1((ImmutableCollection) null);
        }
    }

    private static void log(Throwable th2) {
        String str;
        if (th2 instanceof Error) {
            str = "Input Future failed with Error";
        } else {
            str = "Got more than one input Future failure. Logging failures after the first";
        }
        logger.log(Level.SEVERE, str, th2);
    }

    private void processCompleted(@CheckForNull ImmutableCollection<? extends Future<? extends InputT>> immutableCollection) {
        if (immutableCollection != null) {
            UnmodifiableIterator<? extends Future<? extends InputT>> it = immutableCollection.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                Future future = (Future) it.next();
                if (!future.isCancelled()) {
                    collectValueFromNonCancelledFuture(i11, future);
                }
                i11++;
            }
        }
        clearSeenExceptions();
        handleAllCompleted();
        releaseResources(ReleaseResourcesReason.ALL_INPUT_FUTURES_PROCESSED);
    }

    public final void addInitialException(Set<Throwable> set) {
        Preconditions.checkNotNull(set);
        if (!isCancelled()) {
            Throwable tryInternalFastPathGetFailure = tryInternalFastPathGetFailure();
            Objects.requireNonNull(tryInternalFastPathGetFailure);
            addCausalChain(set, tryInternalFastPathGetFailure);
        }
    }

    public final void afterDone() {
        boolean z11;
        super.afterDone();
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.futures;
        releaseResources(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        boolean isCancelled = isCancelled();
        if (immutableCollection != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (isCancelled && z11) {
            boolean wasInterrupted = wasInterrupted();
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(wasInterrupted);
            }
        }
    }

    public abstract void collectOneValue(int i11, @ParametricNullness InputT inputt);

    public abstract void handleAllCompleted();

    public final void init() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection;
        Objects.requireNonNull(this.futures);
        if (this.futures.isEmpty()) {
            handleAllCompleted();
        } else if (this.allMustSucceed) {
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) it.next();
                listenableFuture.addListener(new h(this, listenableFuture, i11), MoreExecutors.directExecutor());
                i11++;
            }
        } else {
            if (this.collectsValues) {
                immutableCollection = this.futures;
            } else {
                immutableCollection = null;
            }
            i iVar = new i(this, immutableCollection);
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
            while (it2.hasNext()) {
                ((ListenableFuture) it2.next()).addListener(iVar, MoreExecutors.directExecutor());
            }
        }
    }

    @CheckForNull
    public final String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = this.futures;
        if (immutableCollection == null) {
            return super.pendingToString();
        }
        return "futures=" + immutableCollection;
    }

    @ForOverride
    @OverridingMethodsMustInvokeSuper
    public void releaseResources(ReleaseResourcesReason releaseResourcesReason) {
        Preconditions.checkNotNull(releaseResourcesReason);
        this.futures = null;
    }
}
