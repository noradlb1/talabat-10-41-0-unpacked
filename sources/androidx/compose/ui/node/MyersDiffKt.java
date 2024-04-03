package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0013\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a]\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\bH\u0002\u001a \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a8\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0014H\u0000\u001a]\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0016\u001aU\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010$\u001a\u00020\u0001*\u00020\u00142\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {"applyDiff", "", "oldSize", "", "newSize", "diagonals", "Landroidx/compose/ui/node/IntStack;", "callback", "Landroidx/compose/ui/node/DiffCallback;", "backward", "", "oldStart", "oldEnd", "newStart", "newEnd", "cb", "forward", "Landroidx/compose/ui/node/CenteredArray;", "d", "snake", "", "backward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "calculateDiff", "executeDiff", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "forward-4l5_RBY", "midPoint", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "swap", "i", "j", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MyersDiffKt {
    private static final void applyDiff(int i11, int i12, IntStack intStack, DiffCallback diffCallback) {
        while (intStack.isNotEmpty()) {
            int pop = intStack.pop();
            int pop2 = intStack.pop();
            int pop3 = intStack.pop();
            while (i11 > pop3) {
                i11--;
                diffCallback.remove(i11);
            }
            while (i12 > pop2) {
                i12--;
                diffCallback.insert(i11, i12);
            }
            while (true) {
                int i13 = pop - 1;
                if (pop > 0) {
                    i11--;
                    i12--;
                    diffCallback.same(i11, i12);
                    pop = i13;
                }
            }
        }
        while (i11 > 0) {
            i11--;
            diffCallback.remove(i11);
        }
        while (i12 > 0) {
            i12--;
            diffCallback.insert(i11, i12);
        }
    }

    /* renamed from: backward-4l5_RBY  reason: not valid java name */
    private static final boolean m4698backward4l5_RBY(int i11, int i12, int i13, int i14, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i15, int[] iArr3) {
        boolean z11;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21 = i11;
        int i22 = i13;
        int[] iArr4 = iArr2;
        int i23 = i15;
        int i24 = (i12 - i21) - (i14 - i22);
        if (i24 % 2 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i25 = -i23;
        for (int i26 = i25; i26 <= i23; i26 += 2) {
            if (i26 == i25 || (i26 != i23 && CenteredArray.m4578getimpl(iArr4, i26 + 1) < CenteredArray.m4578getimpl(iArr4, i26 - 1))) {
                i17 = CenteredArray.m4578getimpl(iArr4, i26 + 1);
                i16 = i17;
            } else {
                i17 = CenteredArray.m4578getimpl(iArr4, i26 - 1);
                i16 = i17 - 1;
            }
            int i27 = i14 - ((i12 - i16) - i26);
            if (i23 == 0 || i16 != i17) {
                i18 = i27;
            } else {
                i18 = i27 + 1;
            }
            while (true) {
                if (i16 > i21 && i27 > i22) {
                    if (!diffCallback.areItemsTheSame(i16 - 1, i27 - 1)) {
                        break;
                    }
                    i16--;
                    i27--;
                } else {
                    DiffCallback diffCallback2 = diffCallback;
                }
            }
            DiffCallback diffCallback22 = diffCallback;
            CenteredArray.m4581setimpl(iArr4, i26, i16);
            if (!z11 || (i19 = i24 - i26) < i25 || i19 > i23) {
                int[] iArr5 = iArr;
            } else if (CenteredArray.m4578getimpl(iArr, i19) >= i16) {
                fillSnake(i16, i27, i17, i18, true, iArr3);
                return true;
            }
        }
        return false;
    }

    private static final IntStack calculateDiff(int i11, int i12, DiffCallback diffCallback) {
        int i13 = i11;
        int i14 = i12;
        int i15 = ((i13 + i14) + 1) / 2;
        IntStack intStack = new IntStack(i15 * 3);
        IntStack intStack2 = new IntStack(i15 * 4);
        intStack2.pushRange(0, i13, 0, i14);
        int i16 = (i15 * 2) + 1;
        int[] r62 = CenteredArray.m4575constructorimpl(new int[i16]);
        int[] r22 = CenteredArray.m4575constructorimpl(new int[i16]);
        int[] r15 = Snake.m4782constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int pop = intStack2.pop();
            int pop2 = intStack2.pop();
            int pop3 = intStack2.pop();
            int pop4 = intStack2.pop();
            int i17 = pop4;
            int i18 = pop3;
            int[] iArr = r62;
            int[] iArr2 = r62;
            int i19 = pop2;
            int[] iArr3 = r22;
            int[] iArr4 = r22;
            int i21 = pop;
            if (m4700midPointq5eDKzI(pop4, pop3, pop2, pop, diffCallback, iArr, iArr3, r15)) {
                if (Snake.m4785getDiagonalSizeimpl(r15) > 0) {
                    Snake.m4780addDiagonalToStackimpl(r15, intStack);
                }
                intStack2.pushRange(i17, Snake.m4790getStartXimpl(r15), i19, Snake.m4791getStartYimpl(r15));
                intStack2.pushRange(Snake.m4786getEndXimpl(r15), i18, Snake.m4787getEndYimpl(r15), i21);
            }
            int i22 = i11;
            r62 = iArr2;
            r22 = iArr4;
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i11, i14, 0);
        return intStack;
    }

    public static final void executeDiff(int i11, int i12, @NotNull DiffCallback diffCallback) {
        Intrinsics.checkNotNullParameter(diffCallback, "callback");
        applyDiff(i11, i12, calculateDiff(i11, i12, diffCallback), diffCallback);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [boolean] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, int[]] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void fillSnake(int r1, int r2, int r3, int r4, boolean r5, @org.jetbrains.annotations.NotNull int[] r6) {
        /*
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = 0
            r6[r0] = r1
            r1 = 1
            r6[r1] = r2
            r1 = 2
            r6[r1] = r3
            r1 = 3
            r6[r1] = r4
            r1 = 4
            r6[r1] = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MyersDiffKt.fillSnake(int, int, int, int, boolean, int[]):void");
    }

    /* renamed from: forward-4l5_RBY  reason: not valid java name */
    private static final boolean m4699forward4l5_RBY(int i11, int i12, int i13, int i14, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i15, int[] iArr3) {
        boolean z11;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21 = i12;
        int i22 = i14;
        int[] iArr4 = iArr;
        int i23 = i15;
        int i24 = (i21 - i11) - (i22 - i13);
        if (Math.abs(i24) % 2 == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i25 = -i23;
        for (int i26 = i25; i26 <= i23; i26 += 2) {
            if (i26 == i25 || (i26 != i23 && CenteredArray.m4578getimpl(iArr4, i26 + 1) > CenteredArray.m4578getimpl(iArr4, i26 - 1))) {
                i17 = CenteredArray.m4578getimpl(iArr4, i26 + 1);
                i16 = i17;
            } else {
                i17 = CenteredArray.m4578getimpl(iArr4, i26 - 1);
                i16 = i17 + 1;
            }
            int i27 = (i13 + (i16 - i11)) - i26;
            if (i23 == 0 || i16 != i17) {
                i18 = i27;
            } else {
                i18 = i27 - 1;
            }
            while (true) {
                if (i16 < i21 && i27 < i22) {
                    if (!diffCallback.areItemsTheSame(i16, i27)) {
                        break;
                    }
                    i16++;
                    i27++;
                } else {
                    DiffCallback diffCallback2 = diffCallback;
                }
            }
            DiffCallback diffCallback22 = diffCallback;
            CenteredArray.m4581setimpl(iArr4, i26, i16);
            if (!z11 || (i19 = i24 - i26) < i25 + 1 || i19 > i23 - 1) {
                int[] iArr5 = iArr2;
            } else if (CenteredArray.m4578getimpl(iArr2, i19) <= i16) {
                fillSnake(i17, i18, i16, i27, false, iArr3);
                return true;
            }
        }
        return false;
    }

    /* renamed from: midPoint-q5eDKzI  reason: not valid java name */
    private static final boolean m4700midPointq5eDKzI(int i11, int i12, int i13, int i14, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i15 = i11;
        int i16 = i12;
        int i17 = i16 - i15;
        int i18 = i14 - i13;
        if (i17 >= 1 && i18 >= 1) {
            int i19 = ((i17 + i18) + 1) / 2;
            CenteredArray.m4581setimpl(iArr, 1, i15);
            CenteredArray.m4581setimpl(iArr2, 1, i16);
            int i21 = 0;
            while (i21 < i19) {
                int i22 = i21;
                if (m4699forward4l5_RBY(i11, i12, i13, i14, diffCallback, iArr, iArr2, i21, iArr3) || m4698backward4l5_RBY(i11, i12, i13, i14, diffCallback, iArr, iArr2, i22, iArr3)) {
                    return true;
                }
                i21 = i22 + 1;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final void swap(int[] iArr, int i11, int i12) {
        int i13 = iArr[i11];
        iArr[i11] = iArr[i12];
        iArr[i12] = i13;
    }
}
