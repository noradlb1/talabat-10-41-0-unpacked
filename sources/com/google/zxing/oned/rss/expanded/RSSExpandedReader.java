package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.bytebuddy.jar.asm.Opcodes;

public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM = {0, 348, 1388, 2948, 3988};
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, Opcodes.D2L, 7, 21, 63}, new int[]{189, Opcodes.I2B, 13, 39, 117, Opcodes.F2L, 209, 205}, new int[]{Opcodes.INSTANCEOF, Opcodes.IFGT, 49, Opcodes.I2S, 19, 57, Opcodes.LOOKUPSWITCH, 91}, new int[]{62, Opcodes.INVOKEDYNAMIC, Opcodes.L2I, Opcodes.MULTIANEWARRAY, Opcodes.RET, 85, 44, Opcodes.IINC}, new int[]{Opcodes.INVOKEINTERFACE, Opcodes.I2L, 188, Opcodes.D2I, 4, 12, 36, 108}, new int[]{113, 128, Opcodes.LRETURN, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, Opcodes.IFLE, 52, Opcodes.IFGE}, new int[]{46, 138, 203, Opcodes.NEW, Opcodes.F2I, 206, 196, Opcodes.IF_ACMPNE}, new int[]{76, 17, 51, Opcodes.IFEQ, 37, 111, 122, 155}, new int[]{43, 129, Opcodes.ARETURN, 106, 107, 110, 119, Opcodes.I2C}, new int[]{16, 48, Opcodes.D2F, 10, 30, 90, 59, Opcodes.RETURN}, new int[]{109, 116, Opcodes.L2F, 200, Opcodes.GETSTATIC, 112, 125, Opcodes.IF_ICMPLE}, new int[]{70, 210, 208, 202, Opcodes.INVOKESTATIC, 130, Opcodes.PUTSTATIC, 115}, new int[]{134, Opcodes.ATHROW, Opcodes.DCMPL, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, Opcodes.IFNULL, 172, 94, 71, 2}, new int[]{6, 18, 54, Opcodes.IF_ICMPGE, 64, 192, Opcodes.IFNE, 40}, new int[]{120, Opcodes.FCMPL, 25, 75, 14, 42, 126, Opcodes.GOTO}, new int[]{79, 26, 78, 23, 69, 207, Opcodes.IFNONNULL, Opcodes.DRETURN}, new int[]{103, 98, 83, 38, 114, 131, Opcodes.INVOKEVIRTUAL, 124}, new int[]{Opcodes.IF_ICMPLT, 61, Opcodes.INVOKESPECIAL, 127, Opcodes.TABLESWITCH, 88, 53, Opcodes.IF_ICMPEQ}, new int[]{55, Opcodes.IF_ACMPEQ, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, Opcodes.MONITORENTER, Opcodes.IF_ICMPNE, 58, Opcodes.FRETURN, 100, 89}};
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void adjustOddEvenCounts(int r11) throws com.google.zxing.NotFoundException {
        /*
            r10 = this;
            int[] r0 = r10.getOddCounts()
            int r0 = com.google.zxing.common.detector.MathUtils.sum(r0)
            int[] r1 = r10.getEvenCounts()
            int r1 = com.google.zxing.common.detector.MathUtils.sum(r1)
            r2 = 4
            r3 = 1
            r4 = 0
            r5 = 13
            if (r0 <= r5) goto L_0x001a
            r7 = r3
            r6 = r4
            goto L_0x0021
        L_0x001a:
            if (r0 >= r2) goto L_0x001f
            r6 = r3
            r7 = r4
            goto L_0x0021
        L_0x001f:
            r6 = r4
            r7 = r6
        L_0x0021:
            if (r1 <= r5) goto L_0x0026
            r5 = r3
            r2 = r4
            goto L_0x002d
        L_0x0026:
            if (r1 >= r2) goto L_0x002b
            r2 = r3
            r5 = r4
            goto L_0x002d
        L_0x002b:
            r2 = r4
            r5 = r2
        L_0x002d:
            int r8 = r0 + r1
            int r8 = r8 - r11
            r11 = r0 & 1
            if (r11 != r3) goto L_0x0036
            r11 = r3
            goto L_0x0037
        L_0x0036:
            r11 = r4
        L_0x0037:
            r9 = r1 & 1
            if (r9 != 0) goto L_0x003c
            r4 = r3
        L_0x003c:
            if (r8 != r3) goto L_0x0053
            if (r11 == 0) goto L_0x0049
            if (r4 != 0) goto L_0x0044
            r7 = r3
            goto L_0x004c
        L_0x0044:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0049:
            if (r4 == 0) goto L_0x004e
            r5 = r3
        L_0x004c:
            r3 = r6
            goto L_0x007e
        L_0x004e:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0053:
            r9 = -1
            if (r8 != r9) goto L_0x0069
            if (r11 == 0) goto L_0x0060
            if (r4 != 0) goto L_0x005b
            goto L_0x007e
        L_0x005b:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0060:
            if (r4 == 0) goto L_0x0064
            r2 = r3
            goto L_0x004c
        L_0x0064:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0069:
            if (r8 != 0) goto L_0x00c8
            if (r11 == 0) goto L_0x007b
            if (r4 == 0) goto L_0x0076
            if (r0 >= r1) goto L_0x0073
            r5 = r3
            goto L_0x007e
        L_0x0073:
            r2 = r3
            r7 = r2
            goto L_0x004c
        L_0x0076:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x007b:
            if (r4 != 0) goto L_0x00c3
            goto L_0x004c
        L_0x007e:
            if (r3 == 0) goto L_0x0093
            if (r7 != 0) goto L_0x008e
            int[] r11 = r10.getOddCounts()
            float[] r0 = r10.getOddRoundingErrors()
            com.google.zxing.oned.rss.AbstractRSSReader.increment(r11, r0)
            goto L_0x0093
        L_0x008e:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x0093:
            if (r7 == 0) goto L_0x00a0
            int[] r11 = r10.getOddCounts()
            float[] r0 = r10.getOddRoundingErrors()
            com.google.zxing.oned.rss.AbstractRSSReader.decrement(r11, r0)
        L_0x00a0:
            if (r2 == 0) goto L_0x00b5
            if (r5 != 0) goto L_0x00b0
            int[] r11 = r10.getEvenCounts()
            float[] r0 = r10.getOddRoundingErrors()
            com.google.zxing.oned.rss.AbstractRSSReader.increment(r11, r0)
            goto L_0x00b5
        L_0x00b0:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00b5:
            if (r5 == 0) goto L_0x00c2
            int[] r11 = r10.getEvenCounts()
            float[] r0 = r10.getEvenRoundingErrors()
            com.google.zxing.oned.rss.AbstractRSSReader.decrement(r11, r0)
        L_0x00c2:
            return
        L_0x00c3:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        L_0x00c8:
            com.google.zxing.NotFoundException r11 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.adjustOddEvenCounts(int):void");
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int checksumPortion = rightChar.getChecksumPortion();
        int i11 = 2;
        for (int i12 = 1; i12 < this.pairs.size(); i12++) {
            ExpandedPair expandedPair2 = this.pairs.get(i12);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i11++;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i11++;
            }
        }
        if (((i11 - 4) * 211) + (checksumPortion % 211) == leftChar.getValue()) {
            return true;
        }
        return false;
    }

    private List<ExpandedPair> checkRows(boolean z11) {
        List<ExpandedPair> list = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z11) {
            Collections.reverse(this.rows);
        }
        try {
            list = checkRows(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z11) {
            Collections.reverse(this.rows);
        }
        return list;
    }

    public static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new Result(parseInformation, (byte[]) null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i11) throws NotFoundException {
        boolean z11;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i11 < 0) {
            if (list.isEmpty()) {
                i11 = 0;
            } else {
                i11 = list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
            }
        }
        if (list.size() % 2 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.startFromEven) {
            z11 = !z11;
        }
        boolean z12 = false;
        while (i11 < size) {
            z12 = !bitArray.get(i11);
            if (!z12) {
                break;
            }
            i11++;
        }
        int i12 = 0;
        boolean z13 = z12;
        int i13 = i11;
        while (i11 < size) {
            if (bitArray.get(i11) != z13) {
                decodeFinderCounters[i12] = decodeFinderCounters[i12] + 1;
            } else {
                if (i12 == 3) {
                    if (z11) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i13;
                        iArr[1] = i11;
                        return;
                    }
                    if (z11) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i13 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i12--;
                } else {
                    i12++;
                }
                decodeFinderCounters[i12] = 1;
                z13 = !z13;
            }
            i11++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(BitArray bitArray, int i11) {
        if (bitArray.get(i11)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i11));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i11));
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z11, boolean z12) {
        return finderPattern.getValue() != 0 || !z11 || !z12;
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        boolean z11;
        boolean z12;
        Iterator<ExpandedRow> it = iterable2.iterator();
        do {
            z11 = false;
            if (it.hasNext()) {
                ExpandedRow next = it.next();
                Iterator<ExpandedPair> it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z11 = true;
                        continue;
                        break;
                    }
                    ExpandedPair next2 = it2.next();
                    Iterator<ExpandedPair> it3 = next.getPairs().iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                z12 = true;
                                continue;
                                break;
                            }
                        } else {
                            z12 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z12) {
                        continue;
                        break;
                    }
                }
            } else {
                return false;
            }
        } while (!z11);
        return true;
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        boolean z11;
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr.length) {
                int i11 = 0;
                while (true) {
                    if (i11 >= list.size()) {
                        z11 = true;
                        break;
                    } else if (list.get(i11).getFinderPattern().getValue() != iArr[i11]) {
                        z11 = false;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i11, boolean z11) {
        int i12;
        int i13;
        int i14;
        if (z11) {
            int i15 = this.startEnd[0] - 1;
            while (i15 >= 0 && !bitArray.get(i15)) {
                i15--;
            }
            int i16 = i15 + 1;
            int[] iArr = this.startEnd;
            i14 = iArr[0] - i16;
            i12 = iArr[1];
            i13 = i16;
        } else {
            int[] iArr2 = this.startEnd;
            int i17 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i12 = nextUnset;
            i13 = i17;
            i14 = nextUnset - this.startEnd[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i14;
        try {
            return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i13, i12}, i13, i12, i11);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        boolean z11;
        Iterator<ExpandedRow> it = list2.iterator();
        while (it.hasNext()) {
            ExpandedRow next = it.next();
            if (next.getPairs().size() != list.size()) {
                Iterator<ExpandedPair> it2 = next.getPairs().iterator();
                while (true) {
                    z11 = true;
                    if (!it2.hasNext()) {
                        break;
                    }
                    ExpandedPair next2 = it2.next();
                    Iterator<ExpandedPair> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            if (next2.equals(it3.next())) {
                                continue;
                                break;
                            }
                        } else {
                            z11 = false;
                            continue;
                            break;
                        }
                    }
                    if (!z11) {
                        z11 = false;
                        break;
                    }
                }
                if (z11) {
                    it.remove();
                }
            }
        }
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i11 = 0; i11 < length / 2; i11++) {
            int i12 = iArr[i11];
            int i13 = (length - i11) - 1;
            iArr[i11] = iArr[i13];
            iArr[i13] = i12;
        }
    }

    private void storeRow(int i11, boolean z11) {
        boolean z12 = false;
        int i12 = 0;
        boolean z13 = false;
        while (true) {
            if (i12 >= this.rows.size()) {
                break;
            }
            ExpandedRow expandedRow = this.rows.get(i12);
            if (expandedRow.getRowNumber() > i11) {
                z12 = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                z13 = expandedRow.isEquivalent(this.pairs);
                i12++;
            }
        }
        if (!z12 && !z13 && !isPartialRow(this.pairs, this.rows)) {
            this.rows.add(i12, new ExpandedRow(this.pairs, i11, z11));
            removePartialRows(this.pairs, this.rows);
        }
    }

    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z11, boolean z12) throws NotFoundException {
        int i11;
        BitArray bitArray2 = bitArray;
        int[] dataCharacterCounters = getDataCharacterCounters();
        for (int i12 = 0; i12 < dataCharacterCounters.length; i12++) {
            dataCharacterCounters[i12] = 0;
        }
        if (z12) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i13 = 0;
            for (int length = dataCharacterCounters.length - 1; i13 < length; length--) {
                int i14 = dataCharacterCounters[i13];
                dataCharacterCounters[i13] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i14;
                i13++;
            }
        }
        float sum = ((float) MathUtils.sum(dataCharacterCounters)) / 17.0f;
        float f11 = ((float) (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0])) / 15.0f;
        if (Math.abs(sum - f11) / f11 <= 0.3f) {
            int[] oddCounts = getOddCounts();
            int[] evenCounts = getEvenCounts();
            float[] oddRoundingErrors = getOddRoundingErrors();
            float[] evenRoundingErrors = getEvenRoundingErrors();
            for (int i15 = 0; i15 < dataCharacterCounters.length; i15++) {
                float f12 = (((float) dataCharacterCounters[i15]) * 1.0f) / sum;
                int i16 = (int) (0.5f + f12);
                if (i16 <= 0) {
                    if (f12 >= 0.3f) {
                        i16 = 1;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                } else if (i16 > 8) {
                    if (f12 <= 8.7f) {
                        i16 = 8;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i17 = i15 / 2;
                if ((i15 & 1) == 0) {
                    oddCounts[i17] = i16;
                    oddRoundingErrors[i17] = f12 - ((float) i16);
                } else {
                    evenCounts[i17] = i16;
                    evenRoundingErrors[i17] = f12 - ((float) i16);
                }
            }
            adjustOddEvenCounts(17);
            int value = finderPattern.getValue() * 4;
            if (z11) {
                i11 = 0;
            } else {
                i11 = 2;
            }
            int i18 = ((value + i11) + (z12 ^ true ? 1 : 0)) - 1;
            int i19 = 0;
            int i21 = 0;
            for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                if (isNotA1left(finderPattern, z11, z12)) {
                    i19 += oddCounts[length2] * WEIGHTS[i18][length2 * 2];
                }
                i21 += oddCounts[length2];
            }
            int i22 = 0;
            for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                if (isNotA1left(finderPattern, z11, z12)) {
                    i22 += evenCounts[length3] * WEIGHTS[i18][(length3 * 2) + 1];
                }
            }
            int i23 = i19 + i22;
            if ((i21 & 1) != 0 || i21 > 13 || i21 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i24 = (13 - i21) / 2;
            int i25 = SYMBOL_WIDEST[i24];
            return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i25, true) * EVEN_TOTAL_SUBSET[i24]) + RSSUtils.getRSSvalue(evenCounts, 9 - i25, false) + GSUM[i24], i23);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decodeRow(int i11, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i11, bitArray));
        } catch (NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i11, bitArray));
        }
    }

    public List<ExpandedPair> decodeRow2pairs(int i11, BitArray bitArray) throws NotFoundException {
        boolean z11 = false;
        while (!z11) {
            try {
                List<ExpandedPair> list = this.pairs;
                list.add(retrieveNextPair(bitArray, list, i11));
            } catch (NotFoundException e11) {
                if (!this.pairs.isEmpty()) {
                    z11 = true;
                } else {
                    throw e11;
                }
            }
        }
        if (checkChecksum()) {
            return this.pairs;
        }
        boolean z12 = !this.rows.isEmpty();
        storeRow(i11, false);
        if (z12) {
            List<ExpandedPair> checkRows = checkRows(false);
            if (checkRows != null) {
                return checkRows;
            }
            List<ExpandedPair> checkRows2 = checkRows(true);
            if (checkRows2 != null) {
                return checkRows2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public List<ExpandedRow> getRows() {
        return this.rows;
    }

    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i11) throws NotFoundException {
        boolean z11;
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        if (list.size() % 2 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.startFromEven) {
            z11 = !z11;
        }
        int i12 = -1;
        boolean z12 = true;
        do {
            findNextPair(bitArray, list, i12);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i11, z11);
            if (parseFoundFinderPattern == null) {
                i12 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z12 = false;
                continue;
            }
        } while (z12);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z11, true);
        if (list.isEmpty() || !list.get(list.size() - 1).mustBeLast()) {
            try {
                dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z11, false);
            } catch (NotFoundException unused) {
                dataCharacter = null;
            }
            return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i11) throws NotFoundException {
        while (i11 < this.rows.size()) {
            ExpandedRow expandedRow = this.rows.get(i11);
            this.pairs.clear();
            for (ExpandedRow pairs2 : list) {
                this.pairs.addAll(pairs2.getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (!isValidSequence(this.pairs)) {
                i11++;
            } else if (checkChecksum()) {
                return this.pairs;
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i11 + 1);
                } catch (NotFoundException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
