package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\n\u001ak\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\r*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u0002H\r*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u0001H\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0011\u001aI\u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0012\u001ax\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00150\u0014\"\b\b\u0000\u0010\u0002*\u0002H\r\"\b\b\u0001\u0010\r*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172.\u0010\u0018\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001ae\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\r0\u0001\"\b\b\u0000\u0010\r*\u00020\u0003\"\b\b\u0001\u0010\u0002*\u0002H\r*\b\u0012\u0004\u0012\u0002H\u00020\u00012.\u0010\u0018\u001a*\b\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"separatorPage", "Landroidx/paging/TransformablePage;", "T", "", "separator", "originalPageOffsets", "", "hintOriginalPageOffset", "", "hintOriginalIndex", "(Ljava/lang/Object;[III)Landroidx/paging/TransformablePage;", "addSeparatorPage", "", "R", "", "adjacentPageBefore", "adjacentPageAfter", "(Ljava/util/List;Ljava/lang/Object;Landroidx/paging/TransformablePage;Landroidx/paging/TransformablePage;II)V", "(Ljava/util/List;Ljava/lang/Object;[III)V", "insertEventSeparators", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PageEvent;", "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "generator", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "insertInternalSeparators", "(Landroidx/paging/TransformablePage;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 2, mv = {1, 4, 2})
public final class SeparatorsKt {
    public static final <T> void addSeparatorPage(@NotNull List<TransformablePage<T>> list, @Nullable T t11, @NotNull int[] iArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "$this$addSeparatorPage");
        Intrinsics.checkNotNullParameter(iArr, "originalPageOffsets");
        if (t11 != null) {
            list.add(separatorPage(t11, iArr, i11, i12));
        }
    }

    @NotNull
    public static final <T extends R, R> Flow<PageEvent<R>> insertEventSeparators(@NotNull Flow<? extends PageEvent<T>> flow, @NotNull TerminalSeparatorType terminalSeparatorType, @NotNull Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(flow, "$this$insertEventSeparators");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(function3, "generator");
        return new SeparatorsKt$insertEventSeparators$$inlined$map$1(flow, new SeparatorState(terminalSeparatorType, new SeparatorsKt$insertEventSeparators$separatorState$1(function3, (Continuation) null)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R, T extends R> java.lang.Object insertInternalSeparators(@org.jetbrains.annotations.NotNull androidx.paging.TransformablePage<T> r11, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super T, ? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.TransformablePage<R>> r13) {
        /*
            boolean r0 = r13 instanceof androidx.paging.SeparatorsKt$insertInternalSeparators$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            androidx.paging.SeparatorsKt$insertInternalSeparators$1 r0 = (androidx.paging.SeparatorsKt$insertInternalSeparators$1) r0
            int r1 = r0.f37122i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37122i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.SeparatorsKt$insertInternalSeparators$1 r0 = new androidx.paging.SeparatorsKt$insertInternalSeparators$1
            r0.<init>(r13)
        L_0x0018:
            java.lang.Object r13 = r0.f37121h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f37122i
            r3 = 1
            if (r2 == 0) goto L_0x004e
            if (r2 != r3) goto L_0x0046
            int r11 = r0.f37129p
            int r12 = r0.f37128o
            java.lang.Object r2 = r0.f37127n
            java.lang.Object r4 = r0.f37126m
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            java.lang.Object r5 = r0.f37125l
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r6 = r0.f37124k
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            java.lang.Object r7 = r0.f37123j
            androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
            kotlin.ResultKt.throwOnFailure(r13)
            r9 = r1
            r1 = r0
            r0 = r6
            r6 = r5
            r5 = r4
            r4 = r9
            goto L_0x00d9
        L_0x0046:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r13)
            java.util.List r13 = r11.getData()
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x005c
            return r11
        L_0x005c:
            java.util.List r13 = r11.getData()
            int r13 = r13.size()
            int r13 = r13 + 4
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r13)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r13)
            java.util.List r13 = r11.getData()
            java.lang.Object r13 = kotlin.collections.CollectionsKt___CollectionsKt.first(r13)
            r2.add(r13)
            java.util.List r13 = r11.getHintOriginalIndices()
            if (r13 == 0) goto L_0x008e
            java.lang.Object r13 = kotlin.collections.CollectionsKt___CollectionsKt.first(r13)
            java.lang.Integer r13 = (java.lang.Integer) r13
            if (r13 == 0) goto L_0x008e
            int r13 = r13.intValue()
            goto L_0x008f
        L_0x008e:
            r13 = 0
        L_0x008f:
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)
            r4.add(r13)
            java.util.List r13 = r11.getData()
            int r13 = r13.size()
            r5 = r2
            r2 = r1
            r1 = r0
            r0 = r12
            r12 = r11
            r11 = r13
            r13 = r3
        L_0x00a5:
            if (r13 >= r11) goto L_0x00f6
            java.util.List r6 = r12.getData()
            java.lang.Object r6 = r6.get(r13)
            java.util.List r7 = r12.getData()
            int r8 = r13 + -1
            java.lang.Object r7 = r7.get(r8)
            r1.f37123j = r12
            r1.f37124k = r0
            r1.f37125l = r5
            r1.f37126m = r4
            r1.f37127n = r6
            r1.f37128o = r13
            r1.f37129p = r11
            r1.f37122i = r3
            java.lang.Object r7 = r0.invoke(r7, r6, r1)
            if (r7 != r2) goto L_0x00d0
            return r2
        L_0x00d0:
            r9 = r7
            r7 = r12
            r12 = r13
            r13 = r9
            r10 = r4
            r4 = r2
            r2 = r6
            r6 = r5
            r5 = r10
        L_0x00d9:
            if (r13 == 0) goto L_0x00e5
            r6.add(r13)
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r5.add(r13)
        L_0x00e5:
            r6.add(r2)
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r5.add(r13)
            int r13 = r12 + 1
            r2 = r4
            r4 = r5
            r5 = r6
            r12 = r7
            goto L_0x00a5
        L_0x00f6:
            int r11 = r5.size()
            java.util.List r13 = r12.getData()
            int r13 = r13.size()
            if (r11 != r13) goto L_0x0105
            goto L_0x0113
        L_0x0105:
            androidx.paging.TransformablePage r11 = new androidx.paging.TransformablePage
            int[] r13 = r12.getOriginalPageOffsets()
            int r12 = r12.getHintOriginalPageOffset()
            r11.<init>(r13, r5, r12, r4)
            r12 = r11
        L_0x0113:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorsKt.insertInternalSeparators(androidx.paging.TransformablePage, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public static final <T> TransformablePage<T> separatorPage(@NotNull T t11, @NotNull int[] iArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(t11, "separator");
        Intrinsics.checkNotNullParameter(iArr, "originalPageOffsets");
        return new TransformablePage<>(iArr, CollectionsKt__CollectionsJVMKt.listOf(t11), i11, CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i12)));
    }

    public static final <R, T extends R> void addSeparatorPage(@NotNull List<TransformablePage<R>> list, @Nullable R r11, @Nullable TransformablePage<T> transformablePage, @Nullable TransformablePage<T> transformablePage2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(list, "$this$addSeparatorPage");
        int[] iArr = null;
        int[] originalPageOffsets = transformablePage != null ? transformablePage.getOriginalPageOffsets() : null;
        if (transformablePage2 != null) {
            iArr = transformablePage2.getOriginalPageOffsets();
        }
        if (originalPageOffsets != null && iArr != null) {
            originalPageOffsets = CollectionsKt___CollectionsKt.toIntArray(CollectionsKt___CollectionsKt.sorted(ArraysKt___ArraysKt.distinct(ArraysKt___ArraysJvmKt.plus(originalPageOffsets, iArr))));
        } else if (originalPageOffsets == null && iArr != null) {
            originalPageOffsets = iArr;
        } else if (originalPageOffsets == null || iArr != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        addSeparatorPage(list, r11, originalPageOffsets, i11, i12);
    }
}
