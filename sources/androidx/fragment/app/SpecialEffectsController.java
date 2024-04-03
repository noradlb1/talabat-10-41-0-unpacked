package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

abstract class SpecialEffectsController {
    private final ViewGroup mContainer;
    boolean mIsContainerPostponed = false;
    boolean mOperationDirectionIsPop = false;
    final ArrayList<Operation> mPendingOperations = new ArrayList<>();
    final ArrayList<Operation> mRunningOperations = new ArrayList<>();

    /* renamed from: androidx.fragment.app.SpecialEffectsController$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = r0
                r1 = 1
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r2 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.ADDING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r3 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.REMOVING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact r4 = androidx.fragment.app.SpecialEffectsController.Operation.LifecycleImpact.NONE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r3
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0043 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x004d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.SpecialEffectsController.AnonymousClass3.<clinit>():void");
        }
    }

    public static class FragmentStateManagerOperation extends Operation {
        @NonNull
        private final FragmentStateManager mFragmentStateManager;

        public FragmentStateManagerOperation(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull FragmentStateManager fragmentStateManager, @NonNull CancellationSignal cancellationSignal) {
            super(state, lifecycleImpact, fragmentStateManager.getFragment(), cancellationSignal);
            this.mFragmentStateManager = fragmentStateManager;
        }

        public void complete() {
            super.complete();
            this.mFragmentStateManager.moveToExpectedState();
        }

        public void onStart() {
            if (getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                Fragment fragment = this.mFragmentStateManager.getFragment();
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("requestFocus: Saved focused view ");
                        sb2.append(findFocus);
                        sb2.append(" for Fragment ");
                        sb2.append(fragment);
                    }
                }
                View requireView = getFragment().requireView();
                if (requireView.getParent() == null) {
                    this.mFragmentStateManager.addViewToContainer();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
            } else if (getLifecycleImpact() == Operation.LifecycleImpact.REMOVING) {
                Fragment fragment2 = this.mFragmentStateManager.getFragment();
                View requireView2 = fragment2.requireView();
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Clearing focus ");
                    sb3.append(requireView2.findFocus());
                    sb3.append(" on view ");
                    sb3.append(requireView2);
                    sb3.append(" for Fragment ");
                    sb3.append(fragment2);
                }
                requireView2.clearFocus();
            }
        }
    }

    public SpecialEffectsController(@NonNull ViewGroup viewGroup) {
        this.mContainer = viewGroup;
    }

    private void enqueue(@NonNull Operation.State state, @NonNull Operation.LifecycleImpact lifecycleImpact, @NonNull FragmentStateManager fragmentStateManager) {
        synchronized (this.mPendingOperations) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            Operation findPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
            if (findPendingOperation != null) {
                findPendingOperation.mergeWith(state, lifecycleImpact);
                return;
            }
            final FragmentStateManagerOperation fragmentStateManagerOperation = new FragmentStateManagerOperation(state, lifecycleImpact, fragmentStateManager, cancellationSignal);
            this.mPendingOperations.add(fragmentStateManagerOperation);
            fragmentStateManagerOperation.addCompletionListener(new Runnable() {
                public void run() {
                    if (SpecialEffectsController.this.mPendingOperations.contains(fragmentStateManagerOperation)) {
                        fragmentStateManagerOperation.getFinalState().applyState(fragmentStateManagerOperation.getFragment().mView);
                    }
                }
            });
            fragmentStateManagerOperation.addCompletionListener(new Runnable() {
                public void run() {
                    SpecialEffectsController.this.mPendingOperations.remove(fragmentStateManagerOperation);
                    SpecialEffectsController.this.mRunningOperations.remove(fragmentStateManagerOperation);
                }
            });
        }
    }

    @Nullable
    private Operation findPendingOperation(@NonNull Fragment fragment) {
        Iterator<Operation> it = this.mPendingOperations.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.isCanceled()) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    private Operation findRunningOperation(@NonNull Fragment fragment) {
        Iterator<Operation> it = this.mRunningOperations.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getFragment().equals(fragment) && !next.isCanceled()) {
                return next;
            }
        }
        return null;
    }

    @NonNull
    public static SpecialEffectsController getOrCreateController(@NonNull ViewGroup viewGroup, @NonNull FragmentManager fragmentManager) {
        return getOrCreateController(viewGroup, fragmentManager.getSpecialEffectsControllerFactory());
    }

    private void updateFinalState() {
        Iterator<Operation> it = this.mPendingOperations.iterator();
        while (it.hasNext()) {
            Operation next = it.next();
            if (next.getLifecycleImpact() == Operation.LifecycleImpact.ADDING) {
                next.mergeWith(Operation.State.from(next.getFragment().requireView().getVisibility()), Operation.LifecycleImpact.NONE);
            }
        }
    }

    public void enqueueAdd(@NonNull Operation.State state, @NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb2.append(fragmentStateManager.getFragment());
        }
        enqueue(state, Operation.LifecycleImpact.ADDING, fragmentStateManager);
    }

    public void enqueueHide(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb2.append(fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.GONE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public void enqueueRemove(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb2.append(fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.REMOVED, Operation.LifecycleImpact.REMOVING, fragmentStateManager);
    }

    public void enqueueShow(@NonNull FragmentStateManager fragmentStateManager) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb2.append(fragmentStateManager.getFragment());
        }
        enqueue(Operation.State.VISIBLE, Operation.LifecycleImpact.NONE, fragmentStateManager);
    }

    public abstract void executeOperations(@NonNull List<Operation> list, boolean z11);

    public void executePendingOperations() {
        if (!this.mIsContainerPostponed) {
            if (!ViewCompat.isAttachedToWindow(this.mContainer)) {
                forceCompleteAllOperations();
                this.mOperationDirectionIsPop = false;
                return;
            }
            synchronized (this.mPendingOperations) {
                if (!this.mPendingOperations.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.mRunningOperations);
                    this.mRunningOperations.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Operation operation = (Operation) it.next();
                        if (FragmentManager.isLoggingEnabled(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SpecialEffectsController: Cancelling operation ");
                            sb2.append(operation);
                        }
                        operation.cancel();
                        if (!operation.isComplete()) {
                            this.mRunningOperations.add(operation);
                        }
                    }
                    updateFinalState();
                    ArrayList arrayList2 = new ArrayList(this.mPendingOperations);
                    this.mPendingOperations.clear();
                    this.mRunningOperations.addAll(arrayList2);
                    boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(2);
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((Operation) it2.next()).onStart();
                    }
                    executeOperations(arrayList2, this.mOperationDirectionIsPop);
                    this.mOperationDirectionIsPop = false;
                    boolean isLoggingEnabled2 = FragmentManager.isLoggingEnabled(2);
                }
            }
        }
    }

    public void forceCompleteAllOperations() {
        String str;
        String str2;
        FragmentManager.isLoggingEnabled(2);
        boolean isAttachedToWindow = ViewCompat.isAttachedToWindow(this.mContainer);
        synchronized (this.mPendingOperations) {
            updateFinalState();
            Iterator<Operation> it = this.mPendingOperations.iterator();
            while (it.hasNext()) {
                it.next().onStart();
            }
            Iterator it2 = new ArrayList(this.mRunningOperations).iterator();
            while (it2.hasNext()) {
                Operation operation = (Operation) it2.next();
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.mContainer + " is not attached to window. ";
                    }
                    sb2.append(str2);
                    sb2.append("Cancelling running operation ");
                    sb2.append(operation);
                }
                operation.cancel();
            }
            Iterator it3 = new ArrayList(this.mPendingOperations).iterator();
            while (it3.hasNext()) {
                Operation operation2 = (Operation) it3.next();
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    if (isAttachedToWindow) {
                        str = "";
                    } else {
                        str = "Container " + this.mContainer + " is not attached to window. ";
                    }
                    sb3.append(str);
                    sb3.append("Cancelling pending operation ");
                    sb3.append(operation2);
                }
                operation2.cancel();
            }
        }
    }

    public void forcePostponedExecutePendingOperations() {
        if (this.mIsContainerPostponed) {
            FragmentManager.isLoggingEnabled(2);
            this.mIsContainerPostponed = false;
            executePendingOperations();
        }
    }

    @Nullable
    public Operation.LifecycleImpact getAwaitingCompletionLifecycleImpact(@NonNull FragmentStateManager fragmentStateManager) {
        Operation.LifecycleImpact lifecycleImpact;
        Operation findPendingOperation = findPendingOperation(fragmentStateManager.getFragment());
        if (findPendingOperation != null) {
            lifecycleImpact = findPendingOperation.getLifecycleImpact();
        } else {
            lifecycleImpact = null;
        }
        Operation findRunningOperation = findRunningOperation(fragmentStateManager.getFragment());
        if (findRunningOperation == null || (lifecycleImpact != null && lifecycleImpact != Operation.LifecycleImpact.NONE)) {
            return lifecycleImpact;
        }
        return findRunningOperation.getLifecycleImpact();
    }

    @NonNull
    public ViewGroup getContainer() {
        return this.mContainer;
    }

    public void markPostponedState() {
        synchronized (this.mPendingOperations) {
            updateFinalState();
            this.mIsContainerPostponed = false;
            int size = this.mPendingOperations.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Operation operation = this.mPendingOperations.get(size);
                Operation.State from = Operation.State.from(operation.getFragment().mView);
                Operation.State finalState = operation.getFinalState();
                Operation.State state = Operation.State.VISIBLE;
                if (finalState == state && from != state) {
                    this.mIsContainerPostponed = operation.getFragment().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public void updateOperationDirection(boolean z11) {
        this.mOperationDirectionIsPop = z11;
    }

    public static class Operation {
        @NonNull
        private final List<Runnable> mCompletionListeners = new ArrayList();
        @NonNull
        private State mFinalState;
        @NonNull
        private final Fragment mFragment;
        private boolean mIsCanceled = false;
        private boolean mIsComplete = false;
        @NonNull
        private LifecycleImpact mLifecycleImpact;
        @NonNull
        private final HashSet<CancellationSignal> mSpecialEffectsSignals = new HashSet<>();

        public enum LifecycleImpact {
            NONE,
            ADDING,
            REMOVING
        }

        public Operation(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact, @NonNull Fragment fragment, @NonNull CancellationSignal cancellationSignal) {
            this.mFinalState = state;
            this.mLifecycleImpact = lifecycleImpact;
            this.mFragment = fragment;
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
                public void onCancel() {
                    Operation.this.cancel();
                }
            });
        }

        public final void addCompletionListener(@NonNull Runnable runnable) {
            this.mCompletionListeners.add(runnable);
        }

        public final void cancel() {
            if (!isCanceled()) {
                this.mIsCanceled = true;
                if (this.mSpecialEffectsSignals.isEmpty()) {
                    complete();
                    return;
                }
                Iterator it = new ArrayList(this.mSpecialEffectsSignals).iterator();
                while (it.hasNext()) {
                    ((CancellationSignal) it.next()).cancel();
                }
            }
        }

        @CallSuper
        public void complete() {
            if (!this.mIsComplete) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    sb2.append(this);
                    sb2.append(" has called complete.");
                }
                this.mIsComplete = true;
                for (Runnable run : this.mCompletionListeners) {
                    run.run();
                }
            }
        }

        public final void completeSpecialEffect(@NonNull CancellationSignal cancellationSignal) {
            if (this.mSpecialEffectsSignals.remove(cancellationSignal) && this.mSpecialEffectsSignals.isEmpty()) {
                complete();
            }
        }

        @NonNull
        public State getFinalState() {
            return this.mFinalState;
        }

        @NonNull
        public final Fragment getFragment() {
            return this.mFragment;
        }

        @NonNull
        public LifecycleImpact getLifecycleImpact() {
            return this.mLifecycleImpact;
        }

        public final boolean isCanceled() {
            return this.mIsCanceled;
        }

        public final boolean isComplete() {
            return this.mIsComplete;
        }

        public final void markStartedSpecialEffect(@NonNull CancellationSignal cancellationSignal) {
            onStart();
            this.mSpecialEffectsSignals.add(cancellationSignal);
        }

        public final void mergeWith(@NonNull State state, @NonNull LifecycleImpact lifecycleImpact) {
            int i11 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact[lifecycleImpact.ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: For fragment ");
                        sb2.append(this.mFragment);
                        sb2.append(" mFinalState = ");
                        sb2.append(this.mFinalState);
                        sb2.append(" -> REMOVED. mLifecycleImpact  = ");
                        sb2.append(this.mLifecycleImpact);
                        sb2.append(" to REMOVING.");
                    }
                    this.mFinalState = State.REMOVED;
                    this.mLifecycleImpact = LifecycleImpact.REMOVING;
                } else if (i11 == 3 && this.mFinalState != State.REMOVED) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: For fragment ");
                        sb3.append(this.mFragment);
                        sb3.append(" mFinalState = ");
                        sb3.append(this.mFinalState);
                        sb3.append(" -> ");
                        sb3.append(state);
                        sb3.append(". ");
                    }
                    this.mFinalState = state;
                }
            } else if (this.mFinalState == State.REMOVED) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("SpecialEffectsController: For fragment ");
                    sb4.append(this.mFragment);
                    sb4.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    sb4.append(this.mLifecycleImpact);
                    sb4.append(" to ADDING.");
                }
                this.mFinalState = State.VISIBLE;
                this.mLifecycleImpact = LifecycleImpact.ADDING;
            }
        }

        public void onStart() {
        }

        @NonNull
        public String toString() {
            return "Operation " + "{" + Integer.toHexString(System.identityHashCode(this)) + "} " + "{" + "mFinalState = " + this.mFinalState + "} " + "{" + "mLifecycleImpact = " + this.mLifecycleImpact + "} " + "{" + "mFragment = " + this.mFragment + "}";
        }

        public enum State {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            @NonNull
            public static State from(@NonNull View view) {
                if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                    return INVISIBLE;
                }
                return from(view.getVisibility());
            }

            public void applyState(@NonNull View view) {
                int i11 = AnonymousClass3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[ordinal()];
                if (i11 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SpecialEffectsController: Removing view ");
                            sb2.append(view);
                            sb2.append(" from container ");
                            sb2.append(viewGroup);
                        }
                        viewGroup.removeView(view);
                    }
                } else if (i11 == 2) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: Setting view ");
                        sb3.append(view);
                        sb3.append(" to VISIBLE");
                    }
                    view.setVisibility(0);
                } else if (i11 == 3) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("SpecialEffectsController: Setting view ");
                        sb4.append(view);
                        sb4.append(" to GONE");
                    }
                    view.setVisibility(8);
                } else if (i11 == 4) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("SpecialEffectsController: Setting view ");
                        sb5.append(view);
                        sb5.append(" to INVISIBLE");
                    }
                    view.setVisibility(4);
                }
            }

            @NonNull
            public static State from(int i11) {
                if (i11 == 0) {
                    return VISIBLE;
                }
                if (i11 == 4) {
                    return INVISIBLE;
                }
                if (i11 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i11);
            }
        }
    }

    @NonNull
    public static SpecialEffectsController getOrCreateController(@NonNull ViewGroup viewGroup, @NonNull SpecialEffectsControllerFactory specialEffectsControllerFactory) {
        int i11 = R.id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i11);
        if (tag instanceof SpecialEffectsController) {
            return (SpecialEffectsController) tag;
        }
        SpecialEffectsController createController = specialEffectsControllerFactory.createController(viewGroup);
        viewGroup.setTag(i11, createController);
        return createController;
    }
}
