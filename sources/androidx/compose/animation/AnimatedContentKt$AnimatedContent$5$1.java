package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentKt$AnimatedContent$5$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<S> f1059g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ S f1060h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f1061i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<AnimatedContentScope<S>, ContentTransform> f1062j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AnimatedContentScope<S> f1063k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function4<AnimatedVisibilityScope, S, Composer, Integer, Unit> f1064l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ SnapshotStateList<S> f1065m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedContentKt$AnimatedContent$5$1(Transition<S> transition, S s11, int i11, Function1<? super AnimatedContentScope<S>, ContentTransform> function1, AnimatedContentScope<S> animatedContentScope, Function4<? super AnimatedVisibilityScope, ? super S, ? super Composer, ? super Integer, Unit> function4, SnapshotStateList<S> snapshotStateList) {
        super(2);
        this.f1059g = transition;
        this.f1060h = s11;
        this.f1061i = i11;
        this.f1062j = function1;
        this.f1063k = animatedContentScope;
        this.f1064l = function4;
        this.f1065m = snapshotStateList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: androidx.compose.animation.ExitTransition} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r15, int r16) {
        /*
            r14 = this;
            r0 = r14
            r7 = r15
            r1 = r16 & 11
            r2 = 2
            if (r1 != r2) goto L_0x0013
            boolean r1 = r15.getSkipping()
            if (r1 != 0) goto L_0x000e
            goto L_0x0013
        L_0x000e:
            r15.skipToGroupEnd()
            goto L_0x00f3
        L_0x0013:
            kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r1 = r0.f1062j
            androidx.compose.animation.AnimatedContentScope<S> r2 = r0.f1063k
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r3)
            java.lang.Object r4 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r5.getEmpty()
            if (r4 != r6) goto L_0x0033
            java.lang.Object r1 = r1.invoke(r2)
            r4 = r1
            androidx.compose.animation.ContentTransform r4 = (androidx.compose.animation.ContentTransform) r4
            r15.updateRememberedValue(r4)
        L_0x0033:
            r15.endReplaceableGroup()
            androidx.compose.animation.ContentTransform r4 = (androidx.compose.animation.ContentTransform) r4
            androidx.compose.animation.core.Transition<S> r1 = r0.f1059g
            androidx.compose.animation.core.Transition$Segment r1 = r1.getSegment()
            java.lang.Object r1 = r1.getTargetState()
            S r2 = r0.f1060h
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            kotlin.jvm.functions.Function1<androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r2 = r0.f1062j
            androidx.compose.animation.AnimatedContentScope<S> r6 = r0.f1063k
            r8 = 1157296644(0x44faf204, float:2007.563)
            r15.startReplaceableGroup(r8)
            boolean r1 = r15.changed((java.lang.Object) r1)
            java.lang.Object r8 = r15.rememberedValue()
            if (r1 != 0) goto L_0x0066
            java.lang.Object r1 = r5.getEmpty()
            if (r8 != r1) goto L_0x0073
        L_0x0066:
            java.lang.Object r1 = r2.invoke(r6)
            androidx.compose.animation.ContentTransform r1 = (androidx.compose.animation.ContentTransform) r1
            androidx.compose.animation.ExitTransition r8 = r1.getInitialContentExit()
            r15.updateRememberedValue(r8)
        L_0x0073:
            r15.endReplaceableGroup()
            r6 = r8
            androidx.compose.animation.ExitTransition r6 = (androidx.compose.animation.ExitTransition) r6
            S r1 = r0.f1060h
            androidx.compose.animation.core.Transition<S> r2 = r0.f1059g
            r15.startReplaceableGroup(r3)
            java.lang.Object r3 = r15.rememberedValue()
            java.lang.Object r5 = r5.getEmpty()
            if (r3 != r5) goto L_0x009a
            androidx.compose.animation.AnimatedContentScope$ChildData r3 = new androidx.compose.animation.AnimatedContentScope$ChildData
            java.lang.Object r2 = r2.getTargetState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r3.<init>(r1)
            r15.updateRememberedValue(r3)
        L_0x009a:
            r15.endReplaceableGroup()
            androidx.compose.animation.AnimatedContentScope$ChildData r3 = (androidx.compose.animation.AnimatedContentScope.ChildData) r3
            androidx.compose.animation.EnterTransition r5 = r4.getTargetContentEnter()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$1 r2 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$1
            r2.<init>(r4)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutModifierKt.layout(r1, r2)
            S r2 = r0.f1060h
            androidx.compose.animation.core.Transition<S> r4 = r0.f1059g
            java.lang.Object r4 = r4.getTargetState()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            r3.setTarget(r2)
            androidx.compose.ui.Modifier r3 = r1.then(r3)
            androidx.compose.animation.core.Transition<S> r1 = r0.f1059g
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$3 r2 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$3
            S r4 = r0.f1060h
            r2.<init>(r4)
            androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4 r4 = new androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1$4
            androidx.compose.animation.AnimatedContentScope<S> r9 = r0.f1063k
            S r10 = r0.f1060h
            kotlin.jvm.functions.Function4<androidx.compose.animation.AnimatedVisibilityScope, S, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r11 = r0.f1064l
            int r12 = r0.f1061i
            androidx.compose.runtime.snapshots.SnapshotStateList<S> r13 = r0.f1065m
            r8 = r4
            r8.<init>(r9, r10, r11, r12, r13)
            r8 = -1816907410(0xffffffff93b4316e, float:-4.548713E-27)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r8, r9, r4)
            int r4 = r0.f1061i
            r4 = r4 & 14
            r9 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 | r4
            r10 = 0
            r4 = r5
            r5 = r6
            r6 = r8
            r7 = r15
            r8 = r9
            r9 = r10
            androidx.compose.animation.AnimatedVisibilityKt.AnimatedVisibility(r1, r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.animation.EnterTransition) r4, (androidx.compose.animation.ExitTransition) r5, (kotlin.jvm.functions.Function3<? super androidx.compose.animation.AnimatedVisibilityScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
        L_0x00f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt$AnimatedContent$5$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
