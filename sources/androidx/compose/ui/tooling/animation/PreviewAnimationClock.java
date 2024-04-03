package androidx.compose.ui.tooling.animation;

import androidx.annotation.VisibleForTesting;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001:\u00012B\u0017\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0015J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0015J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0007R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002XD¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002XD¢\u0006\u0006\n\u0004\b \u0010!RH\u0010$\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\"j\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005`#8\u0000X\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'RH\u0010+\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020*0\"j\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020*`#8\u0000X\u0004¢\u0006\u0012\n\u0004\b+\u0010%\u0012\u0004\b-\u0010)\u001a\u0004\b,\u0010'R\u0014\u0010.\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "", "", "timeNs", "nanosToMillis", "Landroidx/compose/animation/core/Transition;", "transition", "", "trackTransition", "Landroidx/compose/animation/tooling/ComposeAnimation;", "animation", "a", "b", "composeAnimation", "fromState", "toState", "updateFromAndToStates", "getMaxDuration", "getMaxDurationPerIteration", "", "Landroidx/compose/animation/tooling/ComposeAnimatedProperty;", "getAnimatedProperties", "animationTimeMs", "setClockTime", "dispose", "Lkotlin/Function0;", "setAnimationsTimeCallback", "Lkotlin/jvm/functions/Function0;", "", "TAG", "Ljava/lang/String;", "", "DEBUG", "Z", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "trackedTransitions", "Ljava/util/HashMap;", "getTrackedTransitions$ui_tooling_release", "()Ljava/util/HashMap;", "getTrackedTransitions$ui_tooling_release$annotations", "()V", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock$TransitionState;", "transitionStates", "getTransitionStates$ui_tooling_release", "getTransitionStates$ui_tooling_release$annotations", "transitionStatesLock", "Ljava/lang/Object;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "TransitionState", "ui-tooling_release"}, k = 1, mv = {1, 5, 1})
public class PreviewAnimationClock {
    private final boolean DEBUG;
    @NotNull
    private final String TAG;
    @NotNull
    private final Function0<Unit> setAnimationsTimeCallback;
    @NotNull
    private final HashMap<ComposeAnimation, Transition<Object>> trackedTransitions;
    @NotNull
    private final HashMap<Transition<Object>, TransitionState> transitionStates;
    @NotNull
    private final Object transitionStatesLock;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0001HÆ\u0003J\t\u0010\t\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/tooling/animation/PreviewAnimationClock$TransitionState;", "", "current", "target", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getCurrent", "()Ljava/lang/Object;", "getTarget", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @VisibleForTesting
    public static final class TransitionState {
        @NotNull
        private final Object current;
        @NotNull
        private final Object target;

        public TransitionState(@NotNull Object obj, @NotNull Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "current");
            Intrinsics.checkNotNullParameter(obj2, "target");
            this.current = obj;
            this.target = obj2;
        }

        public static /* synthetic */ TransitionState copy$default(TransitionState transitionState, Object obj, Object obj2, int i11, Object obj3) {
            if ((i11 & 1) != 0) {
                obj = transitionState.current;
            }
            if ((i11 & 2) != 0) {
                obj2 = transitionState.target;
            }
            return transitionState.copy(obj, obj2);
        }

        @NotNull
        public final Object component1() {
            return this.current;
        }

        @NotNull
        public final Object component2() {
            return this.target;
        }

        @NotNull
        public final TransitionState copy(@NotNull Object obj, @NotNull Object obj2) {
            Intrinsics.checkNotNullParameter(obj, "current");
            Intrinsics.checkNotNullParameter(obj2, "target");
            return new TransitionState(obj, obj2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TransitionState)) {
                return false;
            }
            TransitionState transitionState = (TransitionState) obj;
            return Intrinsics.areEqual(this.current, transitionState.current) && Intrinsics.areEqual(this.target, transitionState.target);
        }

        @NotNull
        public final Object getCurrent() {
            return this.current;
        }

        @NotNull
        public final Object getTarget() {
            return this.target;
        }

        public int hashCode() {
            return (this.current.hashCode() * 31) + this.target.hashCode();
        }

        @NotNull
        public String toString() {
            return "TransitionState(current=" + this.current + ", target=" + this.target + ')';
        }
    }

    public PreviewAnimationClock() {
        this((Function0) null, 1, (DefaultConstructorMarker) null);
    }

    public PreviewAnimationClock(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "setAnimationsTimeCallback");
        this.setAnimationsTimeCallback = function0;
        this.TAG = "PreviewAnimationClock";
        this.trackedTransitions = new HashMap<>();
        this.transitionStates = new HashMap<>();
        this.transitionStatesLock = new Object();
    }

    @VisibleForTesting
    public static /* synthetic */ void getTrackedTransitions$ui_tooling_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTransitionStates$ui_tooling_release$annotations() {
    }

    private final long nanosToMillis(long j11) {
        return (j11 + ((long) 999999)) / ((long) 1000000);
    }

    @VisibleForTesting
    public void a(@NotNull ComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, Param.ANIMATION);
    }

    @VisibleForTesting
    public void b(@NotNull ComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, Param.ANIMATION);
    }

    public final void dispose() {
        for (Map.Entry<ComposeAnimation, Transition<Object>> key : this.trackedTransitions.entrySet()) {
            b((ComposeAnimation) key.getKey());
        }
        this.trackedTransitions.clear();
        this.transitionStates.clear();
    }

    @NotNull
    public final List<ComposeAnimatedProperty> getAnimatedProperties(@NotNull ComposeAnimation composeAnimation) {
        ComposeAnimatedProperty composeAnimatedProperty;
        Intrinsics.checkNotNullParameter(composeAnimation, Param.ANIMATION);
        if (composeAnimation.getType() != ComposeAnimationType.TRANSITION_ANIMATION) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Transition transition = this.trackedTransitions.get(composeAnimation);
        if (transition == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Transition.TransitionAnimationState transitionAnimationState : transition.getAnimations()) {
            Object value = transitionAnimationState.getValue();
            if (value == null) {
                composeAnimatedProperty = null;
            } else {
                composeAnimatedProperty = new ComposeAnimatedProperty(transitionAnimationState.getLabel(), value);
            }
            if (composeAnimatedProperty != null) {
                arrayList.add(composeAnimatedProperty);
            }
        }
        return arrayList;
    }

    public final long getMaxDuration() {
        HashMap<ComposeAnimation, Transition<Object>> hashMap = this.trackedTransitions;
        ArrayList arrayList = new ArrayList(hashMap.size());
        Iterator<Map.Entry<ComposeAnimation, Transition<Object>>> it = hashMap.entrySet().iterator();
        while (true) {
            long j11 = -1;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (((ComposeAnimation) next.getKey()).getType() == ComposeAnimationType.TRANSITION_ANIMATION) {
                j11 = nanosToMillis(((Transition) next.getValue()).getTotalDurationNanos());
            }
            arrayList.add(Long.valueOf(j11));
        }
        Long l11 = (Long) CollectionsKt.maxOrNull((Iterable) arrayList);
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    public final long getMaxDurationPerIteration() {
        HashMap<ComposeAnimation, Transition<Object>> hashMap = this.trackedTransitions;
        ArrayList arrayList = new ArrayList(hashMap.size());
        Iterator<Map.Entry<ComposeAnimation, Transition<Object>>> it = hashMap.entrySet().iterator();
        while (true) {
            long j11 = -1;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (((ComposeAnimation) next.getKey()).getType() == ComposeAnimationType.TRANSITION_ANIMATION) {
                j11 = nanosToMillis(((Transition) next.getValue()).getTotalDurationNanos());
            }
            arrayList.add(Long.valueOf(j11));
        }
        Long l11 = (Long) CollectionsKt.maxOrNull((Iterable) arrayList);
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    @NotNull
    public final HashMap<ComposeAnimation, Transition<Object>> getTrackedTransitions$ui_tooling_release() {
        return this.trackedTransitions;
    }

    @NotNull
    public final HashMap<Transition<Object>, TransitionState> getTransitionStates$ui_tooling_release() {
        return this.transitionStates;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        r1 = (androidx.compose.animation.core.Transition) r1.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setClockTime(long r5) {
        /*
            r4 = this;
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r5 = r0.toNanos(r5)
            java.util.HashMap<androidx.compose.animation.tooling.ComposeAnimation, androidx.compose.animation.core.Transition<java.lang.Object>> r0 = r4.trackedTransitions
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0010:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0049
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            androidx.compose.animation.tooling.ComposeAnimation r2 = (androidx.compose.animation.tooling.ComposeAnimation) r2
            androidx.compose.animation.tooling.ComposeAnimationType r2 = r2.getType()
            androidx.compose.animation.tooling.ComposeAnimationType r3 = androidx.compose.animation.tooling.ComposeAnimationType.TRANSITION_ANIMATION
            if (r2 != r3) goto L_0x0010
            java.lang.Object r1 = r1.getValue()
            androidx.compose.animation.core.Transition r1 = (androidx.compose.animation.core.Transition) r1
            java.util.HashMap r2 = r4.getTransitionStates$ui_tooling_release()
            java.lang.Object r2 = r2.get(r1)
            androidx.compose.ui.tooling.animation.PreviewAnimationClock$TransitionState r2 = (androidx.compose.ui.tooling.animation.PreviewAnimationClock.TransitionState) r2
            if (r2 != 0) goto L_0x003d
            goto L_0x0010
        L_0x003d:
            java.lang.Object r3 = r2.getCurrent()
            java.lang.Object r2 = r2.getTarget()
            r1.seek(r3, r2, r5)
            goto L_0x0010
        L_0x0049:
            kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r4.setAnimationsTimeCallback
            r5.invoke()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.setClockTime(long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r5.DEBUG == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("Transition ");
        r0.append(r6);
        r0.append(" is now tracked");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        r0 = androidx.compose.ui.tooling.animation.ComposeAnimationParserKt.parse(r6);
        r5.trackedTransitions.put(r0, r6);
        a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void trackTransition(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.Transition<java.lang.Object> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "transition"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object r0 = r5.transitionStatesLock
            monitor-enter(r0)
            java.util.HashMap r1 = r5.getTransitionStates$ui_tooling_release()     // Catch:{ all -> 0x0064 }
            boolean r1 = r1.containsKey(r6)     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x002a
            boolean r1 = r5.DEBUG     // Catch:{ all -> 0x0064 }
            if (r1 == 0) goto L_0x0028
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r1.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "Transition "
            r1.append(r2)     // Catch:{ all -> 0x0064 }
            r1.append(r6)     // Catch:{ all -> 0x0064 }
            java.lang.String r6 = " is already being tracked"
            r1.append(r6)     // Catch:{ all -> 0x0064 }
        L_0x0028:
            monitor-exit(r0)
            return
        L_0x002a:
            java.util.HashMap r1 = r5.getTransitionStates$ui_tooling_release()     // Catch:{ all -> 0x0064 }
            androidx.compose.ui.tooling.animation.PreviewAnimationClock$TransitionState r2 = new androidx.compose.ui.tooling.animation.PreviewAnimationClock$TransitionState     // Catch:{ all -> 0x0064 }
            java.lang.Object r3 = r6.getCurrentState()     // Catch:{ all -> 0x0064 }
            java.lang.Object r4 = r6.getTargetState()     // Catch:{ all -> 0x0064 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0064 }
            r1.put(r6, r2)     // Catch:{ all -> 0x0064 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0064 }
            monitor-exit(r0)
            boolean r0 = r5.DEBUG
            if (r0 == 0) goto L_0x0057
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Transition "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = " is now tracked"
            r0.append(r1)
        L_0x0057:
            androidx.compose.animation.tooling.ComposeAnimation r0 = androidx.compose.ui.tooling.animation.ComposeAnimationParserKt.parse(r6)
            java.util.HashMap<androidx.compose.animation.tooling.ComposeAnimation, androidx.compose.animation.core.Transition<java.lang.Object>> r1 = r5.trackedTransitions
            r1.put(r0, r6)
            r5.a(r0)
            return
        L_0x0064:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.trackTransition(androidx.compose.animation.core.Transition):void");
    }

    public final void updateFromAndToStates(@NotNull ComposeAnimation composeAnimation, @NotNull Object obj, @NotNull Object obj2) {
        T t11;
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(obj, "fromState");
        Intrinsics.checkNotNullParameter(obj2, "toState");
        if (composeAnimation.getType() == ComposeAnimationType.TRANSITION_ANIMATION) {
            Set<Map.Entry<ComposeAnimation, Transition<Object>>> entrySet = this.trackedTransitions.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "trackedTransitions.entries");
            Iterator<T> it = entrySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it.next();
                if (Intrinsics.areEqual(((Map.Entry) t11).getKey(), (Object) composeAnimation)) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) t11;
            if (entry != null) {
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "transitionEntry.value");
                Transition transition = (Transition) value;
                synchronized (this.transitionStatesLock) {
                    getTransitionStates$ui_tooling_release().put(transition, new TransitionState(obj, obj2));
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreviewAnimationClock(Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
