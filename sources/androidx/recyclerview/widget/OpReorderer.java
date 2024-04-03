package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

class OpReorderer {
    final Callback mCallback;

    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i11, int i12, int i13, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z11 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z11 = true;
            } else if (z11) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i11, AdapterHelper.UpdateOp updateOp, int i12, AdapterHelper.UpdateOp updateOp2) {
        int i13;
        int i14 = updateOp.itemCount;
        int i15 = updateOp2.positionStart;
        if (i14 < i15) {
            i13 = -1;
        } else {
            i13 = 0;
        }
        int i16 = updateOp.positionStart;
        if (i16 < i15) {
            i13++;
        }
        if (i15 <= i16) {
            updateOp.positionStart = i16 + updateOp2.itemCount;
        }
        int i17 = updateOp2.positionStart;
        if (i17 <= i14) {
            updateOp.itemCount = i14 + updateOp2.itemCount;
        }
        updateOp2.positionStart = i17 + i13;
        list.set(i11, updateOp2);
        list.set(i12, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i11, int i12) {
        AdapterHelper.UpdateOp updateOp = list.get(i11);
        AdapterHelper.UpdateOp updateOp2 = list.get(i12);
        int i13 = updateOp2.cmd;
        if (i13 == 1) {
            swapMoveAdd(list, i11, updateOp, i12, updateOp2);
        } else if (i13 == 2) {
            swapMoveRemove(list, i11, updateOp, i12, updateOp2);
        } else if (i13 == 4) {
            swapMoveUpdate(list, i11, updateOp, i12, updateOp2);
        }
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder != -1) {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            } else {
                return;
            }
        }
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i11, AdapterHelper.UpdateOp updateOp, int i12, AdapterHelper.UpdateOp updateOp2) {
        boolean z11;
        int i13 = updateOp.positionStart;
        int i14 = updateOp.itemCount;
        boolean z12 = false;
        if (i13 < i14) {
            if (updateOp2.positionStart == i13 && updateOp2.itemCount == i14 - i13) {
                z11 = false;
                z12 = true;
            } else {
                z11 = false;
            }
        } else if (updateOp2.positionStart == i14 + 1 && updateOp2.itemCount == i13 - i14) {
            z11 = true;
            z12 = true;
        } else {
            z11 = true;
        }
        int i15 = updateOp2.positionStart;
        if (i14 < i15) {
            updateOp2.positionStart = i15 - 1;
        } else {
            int i16 = updateOp2.itemCount;
            if (i14 < i15 + i16) {
                updateOp2.itemCount = i16 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i12);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i17 = updateOp.positionStart;
        int i18 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i17 <= i18) {
            updateOp2.positionStart = i18 + 1;
        } else {
            int i19 = updateOp2.itemCount;
            if (i17 < i18 + i19) {
                updateOp3 = this.mCallback.obtainUpdateOp(2, i17 + 1, (i18 + i19) - i17, (Object) null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z12) {
            list.set(i11, updateOp2);
            list.remove(i12);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z11) {
            if (updateOp3 != null) {
                int i21 = updateOp.positionStart;
                if (i21 > updateOp3.positionStart) {
                    updateOp.positionStart = i21 - updateOp3.itemCount;
                }
                int i22 = updateOp.itemCount;
                if (i22 > updateOp3.positionStart) {
                    updateOp.itemCount = i22 - updateOp3.itemCount;
                }
            }
            int i23 = updateOp.positionStart;
            if (i23 > updateOp2.positionStart) {
                updateOp.positionStart = i23 - updateOp2.itemCount;
            }
            int i24 = updateOp.itemCount;
            if (i24 > updateOp2.positionStart) {
                updateOp.itemCount = i24 - updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                int i25 = updateOp.positionStart;
                if (i25 >= updateOp3.positionStart) {
                    updateOp.positionStart = i25 - updateOp3.itemCount;
                }
                int i26 = updateOp.itemCount;
                if (i26 >= updateOp3.positionStart) {
                    updateOp.itemCount = i26 - updateOp3.itemCount;
                }
            }
            int i27 = updateOp.positionStart;
            if (i27 >= updateOp2.positionStart) {
                updateOp.positionStart = i27 - updateOp2.itemCount;
            }
            int i28 = updateOp.itemCount;
            if (i28 >= updateOp2.positionStart) {
                updateOp.itemCount = i28 - updateOp2.itemCount;
            }
        }
        list.set(i11, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i12, updateOp);
        } else {
            list.remove(i12);
        }
        if (updateOp3 != null) {
            list.add(i11, updateOp3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void swapMoveUpdate(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto L_0x000d
            int r1 = r1 - r3
            r13.positionStart = r1
            goto L_0x0020
        L_0x000d:
            int r5 = r13.itemCount
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0020
            int r5 = r5 - r3
            r13.itemCount = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.mCallback
            int r1 = r11.positionStart
            java.lang.Object r5 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r3, r5)
            goto L_0x0021
        L_0x0020:
            r0 = r4
        L_0x0021:
            int r1 = r11.positionStart
            int r5 = r13.positionStart
            if (r1 > r5) goto L_0x002b
            int r5 = r5 + r3
            r13.positionStart = r5
            goto L_0x0041
        L_0x002b:
            int r6 = r13.itemCount
            int r7 = r5 + r6
            if (r1 >= r7) goto L_0x0041
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r8.mCallback
            int r1 = r1 + r3
            java.lang.Object r3 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r4.obtainUpdateOp(r2, r1, r5, r3)
            int r1 = r13.itemCount
            int r1 = r1 - r5
            r13.itemCount = r1
        L_0x0041:
            r9.set(r12, r11)
            int r11 = r13.itemCount
            if (r11 <= 0) goto L_0x004c
            r9.set(r10, r13)
            goto L_0x0054
        L_0x004c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.mCallback
            r11.recycleUpdateOp(r13)
        L_0x0054:
            if (r0 == 0) goto L_0x0059
            r9.add(r10, r0)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r9.add(r10, r4)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveUpdate(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
