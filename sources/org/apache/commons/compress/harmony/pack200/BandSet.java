package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BandSet {
    private static final int[] effortThresholds = {0, 0, 1000, 500, 100, 100, 100, 100, 100, 0};
    private long[] canonicalLargest;
    private long[] canonicalSmallest;
    final int effort;
    protected final SegmentHeader segmentHeader;

    public class BandAnalysisResults {
        /* access modifiers changed from: private */
        public Codec betterCodec;
        /* access modifiers changed from: private */
        public byte[] encodedBand;
        /* access modifiers changed from: private */
        public int[] extraMetadata;
        /* access modifiers changed from: private */
        public int numCodecsTried = 0;
        /* access modifiers changed from: private */
        public int saved = 0;

        public BandAnalysisResults() {
        }

        public static /* synthetic */ int access$408(BandAnalysisResults bandAnalysisResults) {
            int i11 = bandAnalysisResults.numCodecsTried;
            bandAnalysisResults.numCodecsTried = i11 + 1;
            return i11;
        }
    }

    public class BandData {
        private double averageAbsoluteDelta = 0.0d;
        private double averageAbsoluteValue = 0.0d;
        private final int[] band;
        private int deltaIsAscending = 0;
        /* access modifiers changed from: private */
        public Map distinctValues;
        /* access modifiers changed from: private */
        public int largest = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        public int largestDelta;
        private int smallDeltaCount = 0;
        /* access modifiers changed from: private */
        public int smallest = Integer.MAX_VALUE;
        /* access modifiers changed from: private */
        public int smallestDelta;

        public BandData(int[] iArr) {
            Integer num;
            this.band = iArr;
            for (int i11 = 0; i11 < iArr.length; i11++) {
                int i12 = iArr[i11];
                if (i12 < this.smallest) {
                    this.smallest = i12;
                }
                if (i12 > this.largest) {
                    this.largest = i12;
                }
                if (i11 != 0) {
                    int i13 = i12 - iArr[i11 - 1];
                    if (i13 < this.smallestDelta) {
                        this.smallestDelta = i13;
                    }
                    if (i13 > this.largestDelta) {
                        this.largestDelta = i13;
                    }
                    if (i13 >= 0) {
                        this.deltaIsAscending++;
                    }
                    this.averageAbsoluteDelta += ((double) Math.abs(i13)) / ((double) (iArr.length - 1));
                    if (Math.abs(i13) < 256) {
                        this.smallDeltaCount++;
                    }
                } else {
                    int i14 = iArr[0];
                    this.smallestDelta = i14;
                    this.largestDelta = i14;
                }
                this.averageAbsoluteValue += ((double) Math.abs(iArr[i11])) / ((double) iArr.length);
                if (BandSet.this.effort > 3) {
                    if (this.distinctValues == null) {
                        this.distinctValues = new HashMap();
                    }
                    Integer valueOf = Integer.valueOf(iArr[i11]);
                    Integer num2 = (Integer) this.distinctValues.get(valueOf);
                    if (num2 == null) {
                        num = 1;
                    } else {
                        num = Integer.valueOf(num2.intValue() + 1);
                    }
                    this.distinctValues.put(valueOf, num);
                }
            }
        }

        public boolean anyNegatives() {
            return this.smallest < 0;
        }

        public boolean mainlyPositiveDeltas() {
            return ((float) this.deltaIsAscending) / ((float) this.band.length) > 0.95f;
        }

        public boolean mainlySmallDeltas() {
            return ((float) this.smallDeltaCount) / ((float) this.band.length) > 0.7f;
        }

        public int numDistinctValues() {
            Map map = this.distinctValues;
            if (map == null) {
                return this.band.length;
            }
            return map.size();
        }

        public boolean wellCorrelated() {
            return this.averageAbsoluteDelta * 3.1d < this.averageAbsoluteValue;
        }
    }

    public BandSet(int i11, SegmentHeader segmentHeader2) {
        this.effort = i11;
        this.segmentHeader = segmentHeader2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0099, code lost:
        if (r0 >= 0.04d) goto L_0x00ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults analyseBand(java.lang.String r13, int[] r14, org.apache.commons.compress.harmony.pack200.BHSDCodec r15) throws org.apache.commons.compress.harmony.pack200.Pack200Exception {
        /*
            r12 = this;
            org.apache.commons.compress.harmony.pack200.BandSet$BandAnalysisResults r8 = new org.apache.commons.compress.harmony.pack200.BandSet$BandAnalysisResults
            r8.<init>()
            long[] r0 = r12.canonicalLargest
            if (r0 != 0) goto L_0x0032
            r0 = 116(0x74, float:1.63E-43)
            long[] r1 = new long[r0]
            r12.canonicalLargest = r1
            long[] r0 = new long[r0]
            r12.canonicalSmallest = r0
            r0 = 1
        L_0x0014:
            long[] r1 = r12.canonicalLargest
            int r2 = r1.length
            if (r0 >= r2) goto L_0x0032
            org.apache.commons.compress.harmony.pack200.BHSDCodec r2 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCanonicalCodec(r0)
            long r2 = r2.largest()
            r1[r0] = r2
            long[] r1 = r12.canonicalSmallest
            org.apache.commons.compress.harmony.pack200.BHSDCodec r2 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getCanonicalCodec(r0)
            long r2 = r2.smallest()
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0032:
            org.apache.commons.compress.harmony.pack200.BandSet$BandData r9 = new org.apache.commons.compress.harmony.pack200.BandSet$BandData
            r9.<init>(r14)
            byte[] r10 = r15.encode((int[]) r14)
            byte[] unused = r8.encodedBand = r10
            int r0 = r10.length
            int r1 = r14.length
            int r1 = r1 + 23
            int r2 = r12.effort
            int r2 = r2 * 2
            int r1 = r1 - r2
            if (r0 > r1) goto L_0x004a
            return r8
        L_0x004a:
            boolean r0 = r9.anyNegatives()
            if (r0 != 0) goto L_0x006a
            int r0 = r9.largest
            long r0 = (long) r0
            org.apache.commons.compress.harmony.pack200.BHSDCodec r2 = org.apache.commons.compress.harmony.pack200.Codec.BYTE1
            long r3 = r2.largest()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x006a
            byte[] r13 = r2.encode((int[]) r14)
            byte[] unused = r8.encodedBand = r13
            org.apache.commons.compress.harmony.pack200.Codec unused = r8.betterCodec = r2
            return r8
        L_0x006a:
            int r0 = r12.effort
            r1 = 3
            if (r0 <= r1) goto L_0x00ab
            java.lang.String r0 = "POPULATION"
            boolean r0 = r13.equals(r0)
            if (r0 != 0) goto L_0x00ab
            int r0 = r9.numDistinctValues()
            float r1 = (float) r0
            int r2 = r14.length
            float r2 = (float) r2
            float r1 = r1 / r2
            r2 = 100
            if (r0 < r2) goto L_0x009b
            double r0 = (double) r1
            r2 = 4581421828931458171(0x3f947ae147ae147b, double:0.02)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x009b
            int r2 = r12.effort
            r3 = 6
            if (r2 <= r3) goto L_0x00ab
            r2 = 4585925428558828667(0x3fa47ae147ae147b, double:0.04)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ab
        L_0x009b:
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r9
            r5 = r8
            r0.encodeWithPopulationCodec(r1, r2, r3, r4, r5)
            boolean r0 = r12.timeToStop(r8)
            if (r0 == 0) goto L_0x00ab
            return r8
        L_0x00ab:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = r9.mainlyPositiveDeltas()
            if (r1 == 0) goto L_0x00c1
            boolean r1 = r9.mainlySmallDeltas()
            if (r1 == 0) goto L_0x00c1
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs2
            r0.add(r1)
        L_0x00c1:
            boolean r1 = r9.wellCorrelated()
            if (r1 == 0) goto L_0x0120
            boolean r1 = r9.mainlyPositiveDeltas()
            if (r1 == 0) goto L_0x00fc
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs1
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs3
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs4
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs5
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs1
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs3
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs4
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs5
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs2
            r0.add(r1)
            goto L_0x0177
        L_0x00fc:
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs1
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs3
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs2
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs4
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs5
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaSignedCodecs1
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaSignedCodecs2
            r0.add(r1)
            goto L_0x0177
        L_0x0120:
            boolean r1 = r9.anyNegatives()
            if (r1 == 0) goto L_0x014a
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaSignedCodecs1
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaSignedCodecs2
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs1
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs2
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs3
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs4
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaSignedCodecs5
            r0.add(r1)
            goto L_0x0177
        L_0x014a:
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs1
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs3
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs4
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs5
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.nonDeltaUnsignedCodecs2
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs1
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs3
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs4
            r0.add(r1)
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r1 = org.apache.commons.compress.harmony.pack200.CanonicalCodecFamilies.deltaUnsignedCodecs5
            r0.add(r1)
        L_0x0177:
            java.lang.String r1 = "cpint"
            boolean r1 = r13.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0186
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.String r2 = ""
            r1.print(r2)
        L_0x0186:
            java.util.Iterator r11 = r0.iterator()
        L_0x018a:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x01a7
            java.lang.Object r0 = r11.next()
            r7 = r0
            org.apache.commons.compress.harmony.pack200.BHSDCodec[] r7 = (org.apache.commons.compress.harmony.pack200.BHSDCodec[]) r7
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r4 = r9
            r5 = r8
            r6 = r10
            r0.tryCodecs(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = r12.timeToStop(r8)
            if (r0 == 0) goto L_0x018a
        L_0x01a7:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.pack200.BandSet.analyseBand(java.lang.String, int[], org.apache.commons.compress.harmony.pack200.BHSDCodec):org.apache.commons.compress.harmony.pack200.BandSet$BandAnalysisResults");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012e, code lost:
        r9 = r19;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void encodeWithPopulationCodec(java.lang.String r18, int[] r19, org.apache.commons.compress.harmony.pack200.BHSDCodec r20, org.apache.commons.compress.harmony.pack200.BandSet.BandData r21, org.apache.commons.compress.harmony.pack200.BandSet.BandAnalysisResults r22) throws org.apache.commons.compress.harmony.pack200.Pack200Exception {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            r3 = r22
            int r4 = r22.numCodecsTried
            r5 = 3
            int r4 = r4 + r5
            int unused = r3.numCodecsTried = r4
            java.util.Map r4 = r21.distinctValues
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Set r7 = r4.keySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x0022:
            boolean r8 = r7.hasNext()
            r9 = 256(0x100, float:3.59E-43)
            r10 = 2
            if (r8 == 0) goto L_0x0047
            java.lang.Object r8 = r7.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.Object r11 = r4.get(r8)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r11 > r10) goto L_0x0043
            int r10 = r4.size()
            if (r10 >= r9) goto L_0x0022
        L_0x0043:
            r6.add(r8)
            goto L_0x0022
        L_0x0047:
            int r7 = r4.size()
            r8 = 255(0xff, float:3.57E-43)
            if (r7 <= r8) goto L_0x0057
            u20.a r7 = new u20.a
            r7.<init>(r4)
            java.util.Collections.sort(r6, r7)
        L_0x0057:
            org.apache.commons.compress.harmony.pack200.IntList r4 = new org.apache.commons.compress.harmony.pack200.IntList
            r4.<init>()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r8 = 0
            r11 = r8
        L_0x0063:
            int r12 = r6.size()
            if (r11 >= r12) goto L_0x0079
            java.lang.Object r12 = r6.get(r11)
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)
            r7.put(r12, r13)
            int r11 = r11 + 1
            goto L_0x0063
        L_0x0079:
            int r11 = r1.length
            int[] r11 = new int[r11]
            r12 = r8
        L_0x007d:
            int r13 = r1.length
            r14 = 1
            if (r12 >= r13) goto L_0x00a1
            r13 = r1[r12]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.Object r13 = r7.get(r13)
            java.lang.Integer r13 = (java.lang.Integer) r13
            if (r13 != 0) goto L_0x0097
            r11[r12] = r8
            r13 = r1[r12]
            r4.add(r13)
            goto L_0x009e
        L_0x0097:
            int r13 = r13.intValue()
            int r13 = r13 + r14
            r11[r12] = r13
        L_0x009e:
            int r12 = r12 + 1
            goto L_0x007d
        L_0x00a1:
            int r1 = r6.size()
            int r1 = r1 - r14
            java.lang.Object r1 = r6.get(r1)
            r6.add(r1)
            int[] r1 = r0.integerListToArray(r6)
            int[] r4 = r4.toArray()
            java.lang.String r7 = "POPULATION"
            org.apache.commons.compress.harmony.pack200.BandSet$BandAnalysisResults r1 = r0.analyseBand(r7, r1, r2)
            org.apache.commons.compress.harmony.pack200.BandSet$BandAnalysisResults r4 = r0.analyseBand(r7, r4, r2)
            int r6 = r6.size()
            int r6 = r6 - r14
            r12 = 0
            if (r6 >= r9) goto L_0x00d3
            org.apache.commons.compress.harmony.pack200.BHSDCodec r6 = org.apache.commons.compress.harmony.pack200.Codec.BYTE1
            byte[] r6 = r6.encode((int[]) r11)
            r7 = r6
            r13 = r8
            r9 = r12
        L_0x00d0:
            r6 = r14
            goto L_0x0141
        L_0x00d3:
            org.apache.commons.compress.harmony.pack200.BandSet$BandAnalysisResults r7 = r0.analyseBand(r7, r11, r2)
            org.apache.commons.compress.harmony.pack200.Codec r9 = r7.betterCodec
            byte[] r7 = r7.encodedBand
            if (r9 != 0) goto L_0x00e2
            r9 = r2
        L_0x00e2:
            r11 = r9
            org.apache.commons.compress.harmony.pack200.BHSDCodec r11 = (org.apache.commons.compress.harmony.pack200.BHSDCodec) r11
            int r13 = r11.getL()
            int r15 = r11.getH()
            int r16 = r11.getS()
            int r10 = r11.getB()
            boolean r11 = r11.isDelta()
            if (r16 != 0) goto L_0x013c
            if (r11 != 0) goto L_0x013c
            if (r10 <= r14) goto L_0x0112
            org.apache.commons.compress.harmony.pack200.BHSDCodec r11 = new org.apache.commons.compress.harmony.pack200.BHSDCodec
            int r10 = r10 - r14
            r11.<init>(r10, r15)
            long r10 = r11.largest()
            r19 = r9
            long r8 = (long) r6
            int r6 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x0114
            r6 = 0
            goto L_0x0115
        L_0x0112:
            r19 = r9
        L_0x0114:
            r6 = r14
        L_0x0115:
            if (r6 == 0) goto L_0x013e
            switch(r13) {
                case 4: goto L_0x0139;
                case 8: goto L_0x0135;
                case 16: goto L_0x0131;
                case 32: goto L_0x012d;
                case 64: goto L_0x012b;
                case 128: goto L_0x0129;
                case 192: goto L_0x0127;
                case 224: goto L_0x0124;
                case 240: goto L_0x0121;
                case 248: goto L_0x011e;
                case 252: goto L_0x011b;
                default: goto L_0x011a;
            }
        L_0x011a:
            goto L_0x013e
        L_0x011b:
            r6 = 11
            goto L_0x012e
        L_0x011e:
            r6 = 10
            goto L_0x012e
        L_0x0121:
            r6 = 9
            goto L_0x012e
        L_0x0124:
            r6 = 8
            goto L_0x012e
        L_0x0127:
            r6 = 7
            goto L_0x012e
        L_0x0129:
            r6 = 6
            goto L_0x012e
        L_0x012b:
            r6 = 5
            goto L_0x012e
        L_0x012d:
            r6 = 4
        L_0x012e:
            r9 = r19
            goto L_0x0141
        L_0x0131:
            r9 = r19
            r6 = r5
            goto L_0x0141
        L_0x0135:
            r9 = r19
            r6 = 2
            goto L_0x0141
        L_0x0139:
            r9 = r19
            goto L_0x00d0
        L_0x013c:
            r19 = r9
        L_0x013e:
            r9 = r19
            r6 = 0
        L_0x0141:
            byte[] r8 = r1.encodedBand
            byte[] r10 = r4.encodedBand
            org.apache.commons.compress.harmony.pack200.Codec r1 = r1.betterCodec
            org.apache.commons.compress.harmony.pack200.Codec r4 = r4.betterCodec
            if (r1 != 0) goto L_0x0155
            r11 = r14
            goto L_0x0156
        L_0x0155:
            r11 = 0
        L_0x0156:
            int r11 = r11 + 141
            int r15 = r6 * 4
            int r11 = r11 + r15
            if (r4 != 0) goto L_0x015f
            r15 = 2
            goto L_0x0160
        L_0x015f:
            r15 = 0
        L_0x0160:
            int r11 = r11 + r15
            org.apache.commons.compress.harmony.pack200.IntList r15 = new org.apache.commons.compress.harmony.pack200.IntList
            r15.<init>(r5)
            if (r1 == 0) goto L_0x0178
            int[] r5 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifier(r1, r12)
            r14 = 0
        L_0x016d:
            int r12 = r5.length
            if (r14 >= r12) goto L_0x0178
            r12 = r5[r14]
            r15.add(r12)
            int r14 = r14 + 1
            goto L_0x016d
        L_0x0178:
            if (r6 != 0) goto L_0x018b
            r5 = 0
            int[] r6 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifier(r9, r5)
            r5 = 0
        L_0x0180:
            int r12 = r6.length
            if (r5 >= r12) goto L_0x018b
            r12 = r6[r5]
            r15.add(r12)
            int r5 = r5 + 1
            goto L_0x0180
        L_0x018b:
            if (r4 == 0) goto L_0x019e
            r5 = 0
            int[] r5 = org.apache.commons.compress.harmony.pack200.CodecEncoding.getSpecifier(r4, r5)
            r6 = 0
        L_0x0193:
            int r12 = r5.length
            if (r6 >= r12) goto L_0x019e
            r12 = r5[r6]
            r15.add(r12)
            int r6 = r6 + 1
            goto L_0x0193
        L_0x019e:
            int[] r5 = r15.toArray()
            org.apache.commons.compress.harmony.pack200.BHSDCodec r6 = org.apache.commons.compress.harmony.pack200.Codec.UNSIGNED5
            byte[] r6 = r6.encode((int[]) r5)
            boolean r12 = r20.isSigned()
            if (r12 == 0) goto L_0x01b1
            int r11 = -1 - r11
            goto L_0x01b6
        L_0x01b1:
            int r12 = r20.getL()
            int r11 = r11 + r12
        L_0x01b6:
            r12 = 1
            int[] r12 = new int[r12]
            r14 = 0
            r12[r14] = r11
            byte[] r2 = r2.encode((int[]) r12)
            int r11 = r2.length
            int r12 = r8.length
            int r11 = r11 + r12
            int r12 = r7.length
            int r11 = r11 + r12
            int r12 = r10.length
            int r11 = r11 + r12
            int r12 = r6.length
            int r12 = r12 + r11
            byte[] r14 = r22.encodedBand
            int r14 = r14.length
            if (r12 >= r14) goto L_0x0215
            int r12 = r22.saved
            byte[] r14 = r22.encodedBand
            int r14 = r14.length
            int r6 = r6.length
            int r6 = r6 + r11
            int r14 = r14 - r6
            int r12 = r12 + r14
            int unused = r3.saved = r12
            byte[] r6 = new byte[r11]
            int r11 = r2.length
            r12 = 0
            java.lang.System.arraycopy(r2, r12, r6, r12, r11)
            int r11 = r2.length
            int r14 = r8.length
            java.lang.System.arraycopy(r8, r12, r6, r11, r14)
            int r11 = r2.length
            int r14 = r8.length
            int r11 = r11 + r14
            int r14 = r7.length
            java.lang.System.arraycopy(r7, r12, r6, r11, r14)
            int r2 = r2.length
            int r8 = r8.length
            int r2 = r2 + r8
            int r7 = r7.length
            int r2 = r2 + r7
            int r7 = r10.length
            java.lang.System.arraycopy(r10, r12, r6, r2, r7)
            byte[] unused = r3.encodedBand = r6
            int[] unused = r3.extraMetadata = r5
            if (r13 == 0) goto L_0x020d
            org.apache.commons.compress.harmony.pack200.PopulationCodec r2 = new org.apache.commons.compress.harmony.pack200.PopulationCodec
            r2.<init>((org.apache.commons.compress.harmony.pack200.Codec) r1, (int) r13, (org.apache.commons.compress.harmony.pack200.Codec) r4)
            org.apache.commons.compress.harmony.pack200.Codec unused = r3.betterCodec = r2
            goto L_0x0215
        L_0x020d:
            org.apache.commons.compress.harmony.pack200.PopulationCodec r2 = new org.apache.commons.compress.harmony.pack200.PopulationCodec
            r2.<init>((org.apache.commons.compress.harmony.pack200.Codec) r1, (org.apache.commons.compress.harmony.pack200.Codec) r9, (org.apache.commons.compress.harmony.pack200.Codec) r4)
            org.apache.commons.compress.harmony.pack200.Codec unused = r3.betterCodec = r2
        L_0x0215:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.pack200.BandSet.encodeWithPopulationCodec(java.lang.String, int[], org.apache.commons.compress.harmony.pack200.BHSDCodec, org.apache.commons.compress.harmony.pack200.BandSet$BandData, org.apache.commons.compress.harmony.pack200.BandSet$BandAnalysisResults):void");
    }

    private long[] flatten(long[][] jArr) {
        int i11 = 0;
        for (long[] length : jArr) {
            i11 += length.length;
        }
        long[] jArr2 = new long[i11];
        int i12 = 0;
        for (long[] jArr3 : jArr) {
            int i13 = 0;
            while (true) {
                if (i13 >= jArr3.length) {
                    break;
                }
                jArr2[i12] = jArr3[i13];
                i12++;
                i13++;
            }
        }
        return jArr2;
    }

    private boolean timeToStop(BandAnalysisResults bandAnalysisResults) {
        if (this.effort > 6) {
            if (bandAnalysisResults.numCodecsTried >= this.effort * 2) {
                return true;
            }
            return false;
        } else if (bandAnalysisResults.numCodecsTried >= this.effort) {
            return true;
        } else {
            return false;
        }
    }

    private void tryCodecs(String str, int[] iArr, BHSDCodec bHSDCodec, BandData bandData, BandAnalysisResults bandAnalysisResults, byte[] bArr, BHSDCodec[] bHSDCodecArr) throws Pack200Exception {
        int i11 = 0;
        while (i11 < bHSDCodecArr.length) {
            BHSDCodec bHSDCodec2 = bHSDCodecArr[i11];
            if (!bHSDCodec2.equals(bHSDCodec)) {
                if (bHSDCodec2.isDelta()) {
                    if (bHSDCodec2.largest() >= ((long) bandData.largestDelta) && bHSDCodec2.smallest() <= ((long) bandData.smallestDelta) && bHSDCodec2.largest() >= ((long) bandData.largest) && bHSDCodec2.smallest() <= ((long) bandData.smallest)) {
                        byte[] encode = bHSDCodec2.encode(iArr);
                        BandAnalysisResults.access$408(bandAnalysisResults);
                        int length = (bArr.length - encode.length) - bHSDCodec.encode(CodecEncoding.getSpecifier(bHSDCodec2, (Codec) null)).length;
                        if (length > bandAnalysisResults.saved) {
                            Codec unused = bandAnalysisResults.betterCodec = bHSDCodec2;
                            byte[] unused2 = bandAnalysisResults.encodedBand = encode;
                            int unused3 = bandAnalysisResults.saved = length;
                        }
                    }
                } else if (bHSDCodec2.largest() >= ((long) bandData.largest) && bHSDCodec2.smallest() <= ((long) bandData.smallest)) {
                    byte[] encode2 = bHSDCodec2.encode(iArr);
                    BandAnalysisResults.access$408(bandAnalysisResults);
                    int length2 = (bArr.length - encode2.length) - bHSDCodec.encode(CodecEncoding.getSpecifier(bHSDCodec2, (Codec) null)).length;
                    if (length2 > bandAnalysisResults.saved) {
                        Codec unused4 = bandAnalysisResults.betterCodec = bHSDCodec2;
                        byte[] unused5 = bandAnalysisResults.encodedBand = encode2;
                        int unused6 = bandAnalysisResults.saved = length2;
                    }
                }
                if (!timeToStop(bandAnalysisResults)) {
                    i11++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public int[] cpEntryListToArray(List list) {
        int size = list.size();
        int[] iArr = new int[size];
        int i11 = 0;
        while (i11 < size) {
            int index = ((ConstantPoolEntry) list.get(i11)).getIndex();
            iArr[i11] = index;
            if (index >= 0) {
                i11++;
            } else {
                throw new RuntimeException("Index should be > 0");
            }
        }
        return iArr;
    }

    public int[] cpEntryOrNullListToArray(List list) {
        int i11;
        int size = list.size();
        int[] iArr = new int[size];
        int i12 = 0;
        while (i12 < size) {
            ConstantPoolEntry constantPoolEntry = (ConstantPoolEntry) list.get(i12);
            if (constantPoolEntry == null) {
                i11 = 0;
            } else {
                i11 = constantPoolEntry.getIndex() + 1;
            }
            iArr[i12] = i11;
            if (constantPoolEntry == null || constantPoolEntry.getIndex() >= 0) {
                i12++;
            } else {
                throw new RuntimeException("Index should be > 0");
            }
        }
        return iArr;
    }

    public byte[] encodeBandInt(String str, int[] iArr, BHSDCodec bHSDCodec) throws Pack200Exception {
        byte[] bArr;
        int i11;
        int i12 = this.effort;
        if (i12 <= 1 || iArr.length < effortThresholds[i12]) {
            bArr = null;
        } else {
            BandAnalysisResults analyseBand = analyseBand(str, iArr, bHSDCodec);
            Codec access$000 = analyseBand.betterCodec;
            bArr = analyseBand.encodedBand;
            if (access$000 != null) {
                if (access$000 instanceof BHSDCodec) {
                    int[] specifier = CodecEncoding.getSpecifier(access$000, bHSDCodec);
                    int i13 = specifier[0];
                    if (specifier.length > 1) {
                        for (int i14 = 1; i14 < specifier.length; i14++) {
                            this.segmentHeader.appendBandCodingSpecifier(specifier[i14]);
                        }
                    }
                    if (bHSDCodec.isSigned()) {
                        i11 = -1 - i13;
                    } else {
                        i11 = i13 + bHSDCodec.getL();
                    }
                    byte[] encode = bHSDCodec.encode(new int[]{i11});
                    byte[] bArr2 = new byte[(encode.length + bArr.length)];
                    System.arraycopy(encode, 0, bArr2, 0, encode.length);
                    System.arraycopy(bArr, 0, bArr2, encode.length, bArr.length);
                    return bArr2;
                } else if (access$000 instanceof PopulationCodec) {
                    int[] access$200 = analyseBand.extraMetadata;
                    for (int appendBandCodingSpecifier : access$200) {
                        this.segmentHeader.appendBandCodingSpecifier(appendBandCodingSpecifier);
                    }
                    return bArr;
                } else {
                    boolean z11 = access$000 instanceof RunCodec;
                }
            }
        }
        if (iArr.length <= 0) {
            return new byte[0];
        }
        if (bArr == null) {
            bArr = bHSDCodec.encode(iArr);
        }
        int i15 = iArr[0];
        if (bHSDCodec.getB() != 1) {
            if (bHSDCodec.isSigned() && i15 >= -256 && i15 <= -1) {
                byte[] encode2 = bHSDCodec.encode(new int[]{-1 - CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec)});
                byte[] bArr3 = new byte[(encode2.length + bArr.length)];
                System.arraycopy(encode2, 0, bArr3, 0, encode2.length);
                System.arraycopy(bArr, 0, bArr3, encode2.length, bArr.length);
                return bArr3;
            } else if (!bHSDCodec.isSigned() && i15 >= bHSDCodec.getL() && i15 <= bHSDCodec.getL() + 255) {
                byte[] encode3 = bHSDCodec.encode(new int[]{CodecEncoding.getSpecifierForDefaultCodec(bHSDCodec) + bHSDCodec.getL()});
                byte[] bArr4 = new byte[(encode3.length + bArr.length)];
                System.arraycopy(encode3, 0, bArr4, 0, encode3.length);
                System.arraycopy(bArr, 0, bArr4, encode3.length, bArr.length);
                return bArr4;
            }
        }
        return bArr;
    }

    public byte[] encodeFlags(String str, long[] jArr, BHSDCodec bHSDCodec, BHSDCodec bHSDCodec2, boolean z11) throws Pack200Exception {
        if (!z11) {
            int[] iArr = new int[jArr.length];
            for (int i11 = 0; i11 < jArr.length; i11++) {
                iArr[i11] = (int) jArr[i11];
            }
            return encodeBandInt(str, iArr, bHSDCodec);
        }
        int[] iArr2 = new int[jArr.length];
        int[] iArr3 = new int[jArr.length];
        for (int i12 = 0; i12 < jArr.length; i12++) {
            long j11 = jArr[i12];
            iArr2[i12] = (int) (j11 >> 32);
            iArr3[i12] = (int) j11;
        }
        byte[] encodeBandInt = encodeBandInt(str, iArr2, bHSDCodec2);
        byte[] encodeBandInt2 = encodeBandInt(str, iArr3, bHSDCodec);
        byte[] bArr = new byte[(encodeBandInt.length + encodeBandInt2.length)];
        System.arraycopy(encodeBandInt, 0, bArr, 0, encodeBandInt.length);
        System.arraycopy(encodeBandInt2, 0, bArr, encodeBandInt.length + 1, encodeBandInt2.length);
        return bArr;
    }

    public byte[] encodeScalar(int[] iArr, BHSDCodec bHSDCodec) throws Pack200Exception {
        return bHSDCodec.encode(iArr);
    }

    public int[] integerListToArray(List list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = ((Integer) list.get(i11)).intValue();
        }
        return iArr;
    }

    public long[] longListToArray(List list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i11 = 0; i11 < size; i11++) {
            jArr[i11] = ((Long) list.get(i11)).longValue();
        }
        return jArr;
    }

    public abstract void pack(OutputStream outputStream) throws IOException, Pack200Exception;

    public byte[] encodeScalar(int i11, BHSDCodec bHSDCodec) throws Pack200Exception {
        return bHSDCodec.encode(i11);
    }

    public byte[] encodeFlags(String str, long[][] jArr, BHSDCodec bHSDCodec, BHSDCodec bHSDCodec2, boolean z11) throws Pack200Exception {
        return encodeFlags(str, flatten(jArr), bHSDCodec, bHSDCodec2, z11);
    }
}
