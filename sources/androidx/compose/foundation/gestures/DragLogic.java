package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B¡\u0001\u0012<\u0010\u0002\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000b\u0012<\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001d\u001a\u00020\n*\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\n*\u00020\u00042\u0006\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u001d\u0010#\u001a\u00020\n*\u00020\u00042\u0006\u0010 \u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010%R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018RO\u0010\u0002\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000bø\u0001\u0000ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aRO\u0010\f\u001a8\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\b\u000bø\u0001\u0000ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Landroidx/compose/foundation/gestures/DragLogic;", "", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "dragStartInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "getDragStartInteraction", "()Landroidx/compose/runtime/MutableState;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getOnDragStarted", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "getOnDragStopped", "processDragCancel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", "event", "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class DragLogic {
    @NotNull
    private final MutableState<DragInteraction.Start> dragStartInteraction;
    @Nullable
    private final MutableInteractionSource interactionSource;
    @NotNull
    private final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> onDragStarted;
    @NotNull
    private final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> onDragStopped;

    public DragLogic(@NotNull Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, @NotNull Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function32, @NotNull MutableState<DragInteraction.Start> mutableState, @Nullable MutableInteractionSource mutableInteractionSource) {
        Intrinsics.checkNotNullParameter(function3, "onDragStarted");
        Intrinsics.checkNotNullParameter(function32, "onDragStopped");
        Intrinsics.checkNotNullParameter(mutableState, "dragStartInteraction");
        this.onDragStarted = function3;
        this.onDragStopped = function32;
        this.dragStartInteraction = mutableState;
        this.interactionSource = mutableInteractionSource;
    }

    @NotNull
    public final MutableState<DragInteraction.Start> getDragStartInteraction() {
        return this.dragStartInteraction;
    }

    @Nullable
    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @NotNull
    public final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> getOnDragStarted() {
        return this.onDragStarted;
    }

    @NotNull
    public final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> getOnDragStopped() {
        return this.onDragStopped;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragCancel(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.DragLogic$processDragCancel$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.compose.foundation.gestures.DragLogic$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragLogic$processDragCancel$1) r0
            int r1 = r0.f2022l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2022l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.DragLogic$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragLogic$processDragCancel$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f2020j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2022l
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0085
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.f2019i
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            java.lang.Object r2 = r0.f2018h
            androidx.compose.foundation.gestures.DragLogic r2 = (androidx.compose.foundation.gestures.DragLogic) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0065
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r10 = r8.dragStartInteraction
            java.lang.Object r10 = r10.getValue()
            androidx.compose.foundation.interaction.DragInteraction$Start r10 = (androidx.compose.foundation.interaction.DragInteraction.Start) r10
            if (r10 == 0) goto L_0x006b
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L_0x0064
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r10)
            r0.f2018h = r8
            r0.f2019i = r9
            r0.f2022l = r4
            java.lang.Object r10 = r2.emit(r6, r0)
            if (r10 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r2 = r8
        L_0x0065:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r10 = r2.dragStartInteraction
            r10.setValue(r5)
            goto L_0x006c
        L_0x006b:
            r2 = r8
        L_0x006c:
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.ui.unit.Velocity, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r10 = r2.onDragStopped
            androidx.compose.ui.unit.Velocity$Companion r2 = androidx.compose.ui.unit.Velocity.Companion
            long r6 = r2.m5714getZero9UxMQ8M()
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m5694boximpl(r6)
            r0.f2018h = r5
            r0.f2019i = r5
            r0.f2022l = r3
            java.lang.Object r9 = r10.invoke(r9, r2, r0)
            if (r9 != r1) goto L_0x0085
            return r1
        L_0x0085:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragCancel(kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragStart(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope r9, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.DragEvent.DragStarted r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DragLogic$processDragStart$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.compose.foundation.gestures.DragLogic$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DragLogic$processDragStart$1) r0
            int r1 = r0.f2029n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2029n = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.DragLogic$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DragLogic$processDragStart$1
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f2027l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2029n
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005f
            if (r2 == r5) goto L_0x004c
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c6
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            java.lang.Object r9 = r0.f2026k
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = (androidx.compose.foundation.interaction.DragInteraction.Start) r9
            java.lang.Object r10 = r0.f2025j
            androidx.compose.foundation.gestures.DragEvent$DragStarted r10 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r10
            java.lang.Object r2 = r0.f2024i
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            java.lang.Object r4 = r0.f2023h
            androidx.compose.foundation.gestures.DragLogic r4 = (androidx.compose.foundation.gestures.DragLogic) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a2
        L_0x004c:
            java.lang.Object r9 = r0.f2025j
            androidx.compose.foundation.gestures.DragEvent$DragStarted r9 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r9
            java.lang.Object r10 = r0.f2024i
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            java.lang.Object r2 = r0.f2023h
            androidx.compose.foundation.gestures.DragLogic r2 = (androidx.compose.foundation.gestures.DragLogic) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x0085
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r11 = r8.dragStartInteraction
            java.lang.Object r11 = r11.getValue()
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = (androidx.compose.foundation.interaction.DragInteraction.Start) r11
            if (r11 == 0) goto L_0x0084
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L_0x0084
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r11)
            r0.f2023h = r8
            r0.f2024i = r9
            r0.f2025j = r10
            r0.f2029n = r5
            java.lang.Object r11 = r2.emit(r6, r0)
            if (r11 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r2 = r8
        L_0x0085:
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r11.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r2.interactionSource
            if (r5 == 0) goto L_0x00a5
            r0.f2023h = r2
            r0.f2024i = r9
            r0.f2025j = r10
            r0.f2026k = r11
            r0.f2029n = r4
            java.lang.Object r4 = r5.emit(r11, r0)
            if (r4 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r4 = r2
            r2 = r9
            r9 = r11
        L_0x00a2:
            r11 = r9
            r9 = r2
            r2 = r4
        L_0x00a5:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r4 = r2.dragStartInteraction
            r4.setValue(r11)
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.ui.geometry.Offset, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r11 = r2.onDragStarted
            long r4 = r10.m267getStartPointF1C5BW0()
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m2665boximpl(r4)
            r2 = 0
            r0.f2023h = r2
            r0.f2024i = r2
            r0.f2025j = r2
            r0.f2026k = r2
            r0.f2029n = r3
            java.lang.Object r9 = r11.invoke(r9, r10, r0)
            if (r9 != r1) goto L_0x00c6
            return r1
        L_0x00c6:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragStart(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processDragStop(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope r10, @org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.DragEvent.DragStopped r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof androidx.compose.foundation.gestures.DragLogic$processDragStop$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            androidx.compose.foundation.gestures.DragLogic$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragLogic$processDragStop$1) r0
            int r1 = r0.f2035m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2035m = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.gestures.DragLogic$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragLogic$processDragStop$1
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f2033k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2035m
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x008e
        L_0x002d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0035:
            java.lang.Object r10 = r0.f2032j
            androidx.compose.foundation.gestures.DragEvent$DragStopped r10 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r10
            java.lang.Object r11 = r0.f2031i
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            java.lang.Object r2 = r0.f2030h
            androidx.compose.foundation.gestures.DragLogic r2 = (androidx.compose.foundation.gestures.DragLogic) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x006e
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r12 = r9.dragStartInteraction
            java.lang.Object r12 = r12.getValue()
            androidx.compose.foundation.interaction.DragInteraction$Start r12 = (androidx.compose.foundation.interaction.DragInteraction.Start) r12
            if (r12 == 0) goto L_0x0074
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r9.interactionSource
            if (r2 == 0) goto L_0x006d
            androidx.compose.foundation.interaction.DragInteraction$Stop r6 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r6.<init>(r12)
            r0.f2030h = r9
            r0.f2031i = r10
            r0.f2032j = r11
            r0.f2035m = r4
            java.lang.Object r12 = r2.emit(r6, r0)
            if (r12 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r2 = r9
        L_0x006e:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.DragInteraction$Start> r12 = r2.dragStartInteraction
            r12.setValue(r5)
            goto L_0x0075
        L_0x0074:
            r2 = r9
        L_0x0075:
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.ui.unit.Velocity, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r12 = r2.onDragStopped
            long r6 = r11.m268getVelocity9UxMQ8M()
            androidx.compose.ui.unit.Velocity r11 = androidx.compose.ui.unit.Velocity.m5694boximpl(r6)
            r0.f2030h = r5
            r0.f2031i = r5
            r0.f2032j = r5
            r0.f2035m = r3
            java.lang.Object r10 = r12.invoke(r10, r11, r0)
            if (r10 != r1) goto L_0x008e
            return r1
        L_0x008e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragLogic.processDragStop(kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
