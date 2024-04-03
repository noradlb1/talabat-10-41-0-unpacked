package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nHHø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"suspendWithStateAtLeastUnchecked", "R", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchNeeded", "", "lifecycleDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "block", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withResumed", "withStarted", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WithLifecycleStateKt {
    @Nullable
    @PublishedApi
    public static final <R> Object suspendWithStateAtLeastUnchecked(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, boolean z11, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(state, lifecycle, cancellableContinuationImpl, function0);
        if (z11) {
            coroutineDispatcher.dispatch(EmptyCoroutineContext.INSTANCE, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(lifecycle, withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1));
        } else {
            lifecycle.addObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
        }
        cancellableContinuationImpl.invokeOnCancellation(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(coroutineDispatcher, lifecycle, withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull Lifecycle lifecycle, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    @Nullable
    @PublishedApi
    public static final <R> Object withStateAtLeastUnchecked(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @PublishedApi
    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
        boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
        if (!isDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull Function0<? extends R> function0, @NotNull Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            boolean isDispatchNeeded = immediate.isDispatchNeeded(continuation.getContext());
            if (!isDispatchNeeded) {
                if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                    throw new LifecycleDestroyedException();
                } else if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, isDispatchNeeded, immediate, new WithLifecycleStateKt$withStateAtLeastUnchecked$2(function0), continuation);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
