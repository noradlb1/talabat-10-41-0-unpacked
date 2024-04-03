package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;

final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final BarcodeMetadata barcodeMetadata;
    private BoundingBox boundingBox;
    private final DetectionResultColumn[] detectionResultColumns;

    public DetectionResult(BarcodeMetadata barcodeMetadata2, BoundingBox boundingBox2) {
        this.barcodeMetadata = barcodeMetadata2;
        int columnCount = barcodeMetadata2.getColumnCount();
        this.barcodeColumnCount = columnCount;
        this.boundingBox = boundingBox2;
        this.detectionResultColumns = new DetectionResultColumn[(columnCount + 2)];
    }

    private void adjustIndicatorColumnRowNumbers(DetectionResultColumn detectionResultColumn) {
        if (detectionResultColumn != null) {
            ((DetectionResultRowIndicatorColumn) detectionResultColumn).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        }
    }

    private static boolean adjustRowNumber(Codeword codeword, Codeword codeword2) {
        if (codeword2 == null || !codeword2.hasValidRowNumber() || codeword2.getBucket() != codeword.getBucket()) {
            return false;
        }
        codeword.setRowNumber(codeword2.getRowNumber());
        return true;
    }

    private static int adjustRowNumberIfValid(int i11, int i12, Codeword codeword) {
        if (codeword == null || codeword.hasValidRowNumber()) {
            return i12;
        }
        if (!codeword.isValidRowNumber(i11)) {
            return i12 + 1;
        }
        codeword.setRowNumber(i11);
        return 0;
    }

    private int adjustRowNumbers() {
        int adjustRowNumbersByRow = adjustRowNumbersByRow();
        if (adjustRowNumbersByRow == 0) {
            return 0;
        }
        for (int i11 = 1; i11 < this.barcodeColumnCount + 1; i11++) {
            Codeword[] codewords = this.detectionResultColumns[i11].getCodewords();
            for (int i12 = 0; i12 < codewords.length; i12++) {
                Codeword codeword = codewords[i12];
                if (codeword != null && !codeword.hasValidRowNumber()) {
                    adjustRowNumbers(i11, i12, codewords);
                }
            }
        }
        return adjustRowNumbersByRow;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn != null && detectionResultColumnArr[this.barcodeColumnCount + 1] != null) {
            Codeword[] codewords = detectionResultColumn.getCodewords();
            Codeword[] codewords2 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
            for (int i11 = 0; i11 < codewords.length; i11++) {
                Codeword codeword = codewords[i11];
                if (!(codeword == null || codewords2[i11] == null || codeword.getRowNumber() != codewords2[i11].getRowNumber())) {
                    for (int i12 = 1; i12 <= this.barcodeColumnCount; i12++) {
                        Codeword codeword2 = this.detectionResultColumns[i12].getCodewords()[i11];
                        if (codeword2 != null) {
                            codeword2.setRowNumber(codewords[i11].getRowNumber());
                            if (!codeword2.hasValidRowNumber()) {
                                this.detectionResultColumns[i12].getCodewords()[i11] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    private int adjustRowNumbersFromLRI() {
        DetectionResultColumn detectionResultColumn = this.detectionResultColumns[0];
        if (detectionResultColumn == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumn.getCodewords();
        int i11 = 0;
        for (int i12 = 0; i12 < codewords.length; i12++) {
            Codeword codeword = codewords[i12];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                int i13 = 0;
                for (int i14 = 1; i14 < this.barcodeColumnCount + 1 && i13 < 2; i14++) {
                    Codeword codeword2 = this.detectionResultColumns[i14].getCodewords()[i12];
                    if (codeword2 != null) {
                        i13 = adjustRowNumberIfValid(rowNumber, i13, codeword2);
                        if (!codeword2.hasValidRowNumber()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    private int adjustRowNumbersFromRRI() {
        DetectionResultColumn[] detectionResultColumnArr = this.detectionResultColumns;
        int i11 = this.barcodeColumnCount;
        if (detectionResultColumnArr[i11 + 1] == null) {
            return 0;
        }
        Codeword[] codewords = detectionResultColumnArr[i11 + 1].getCodewords();
        int i12 = 0;
        for (int i13 = 0; i13 < codewords.length; i13++) {
            Codeword codeword = codewords[i13];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber();
                int i14 = 0;
                for (int i15 = this.barcodeColumnCount + 1; i15 > 0 && i14 < 2; i15--) {
                    Codeword codeword2 = this.detectionResultColumns[i15].getCodewords()[i13];
                    if (codeword2 != null) {
                        i14 = adjustRowNumberIfValid(rowNumber, i14, codeword2);
                        if (!codeword2.hasValidRowNumber()) {
                            i12++;
                        }
                    }
                }
            }
        }
        return i12;
    }

    public int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    public int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    public int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public DetectionResultColumn getDetectionResultColumn(int i11) {
        return this.detectionResultColumns[i11];
    }

    public DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int i11 = PDF417Common.MAX_CODEWORDS_IN_BARCODE;
        while (true) {
            int adjustRowNumbers = adjustRowNumbers();
            if (adjustRowNumbers > 0 && adjustRowNumbers < i11) {
                i11 = adjustRowNumbers;
            }
        }
        return this.detectionResultColumns;
    }

    public void setBoundingBox(BoundingBox boundingBox2) {
        this.boundingBox = boundingBox2;
    }

    public void setDetectionResultColumn(int i11, DetectionResultColumn detectionResultColumn) {
        this.detectionResultColumns[i11] = detectionResultColumn;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0081, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0085, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r10 = this;
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r0 = r10.detectionResultColumns
            r1 = 0
            r2 = r0[r1]
            r3 = 1
            if (r2 != 0) goto L_0x000d
            int r2 = r10.barcodeColumnCount
            int r2 = r2 + r3
            r2 = r0[r2]
        L_0x000d:
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r4 = r1
        L_0x0013:
            com.google.zxing.pdf417.decoder.Codeword[] r5 = r2.getCodewords()     // Catch:{ all -> 0x007a }
            int r5 = r5.length     // Catch:{ all -> 0x007a }
            if (r4 >= r5) goto L_0x0072
            java.lang.String r5 = "CW %3d:"
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x007a }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x007a }
            r6[r1] = r7     // Catch:{ all -> 0x007a }
            r0.format(r5, r6)     // Catch:{ all -> 0x007a }
            r5 = r1
        L_0x0028:
            int r6 = r10.barcodeColumnCount     // Catch:{ all -> 0x007a }
            r7 = 2
            int r6 = r6 + r7
            if (r5 >= r6) goto L_0x0068
            com.google.zxing.pdf417.decoder.DetectionResultColumn[] r6 = r10.detectionResultColumns     // Catch:{ all -> 0x007a }
            r6 = r6[r5]     // Catch:{ all -> 0x007a }
            java.lang.String r8 = "    |   "
            if (r6 != 0) goto L_0x003c
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007a }
            r0.format(r8, r6)     // Catch:{ all -> 0x007a }
            goto L_0x0065
        L_0x003c:
            com.google.zxing.pdf417.decoder.Codeword[] r6 = r6.getCodewords()     // Catch:{ all -> 0x007a }
            r6 = r6[r4]     // Catch:{ all -> 0x007a }
            if (r6 != 0) goto L_0x004a
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007a }
            r0.format(r8, r6)     // Catch:{ all -> 0x007a }
            goto L_0x0065
        L_0x004a:
            java.lang.String r8 = " %3d|%3d"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x007a }
            int r9 = r6.getRowNumber()     // Catch:{ all -> 0x007a }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x007a }
            r7[r1] = r9     // Catch:{ all -> 0x007a }
            int r6 = r6.getValue()     // Catch:{ all -> 0x007a }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x007a }
            r7[r3] = r6     // Catch:{ all -> 0x007a }
            r0.format(r8, r7)     // Catch:{ all -> 0x007a }
        L_0x0065:
            int r5 = r5 + 1
            goto L_0x0028
        L_0x0068:
            java.lang.String r5 = "%n"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x007a }
            r0.format(r5, r6)     // Catch:{ all -> 0x007a }
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0072:
            java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x007a }
            r0.close()
            return r1
        L_0x007a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x007c }
        L_0x007c:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0085:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DetectionResult.toString():java.lang.String");
    }

    private void adjustRowNumbers(int i11, int i12, Codeword[] codewordArr) {
        Codeword codeword = codewordArr[i12];
        Codeword[] codewords = this.detectionResultColumns[i11 - 1].getCodewords();
        DetectionResultColumn detectionResultColumn = this.detectionResultColumns[i11 + 1];
        Codeword[] codewords2 = detectionResultColumn != null ? detectionResultColumn.getCodewords() : codewords;
        Codeword[] codewordArr2 = new Codeword[14];
        codewordArr2[2] = codewords[i12];
        codewordArr2[3] = codewords2[i12];
        int i13 = 0;
        if (i12 > 0) {
            int i14 = i12 - 1;
            codewordArr2[0] = codewordArr[i14];
            codewordArr2[4] = codewords[i14];
            codewordArr2[5] = codewords2[i14];
        }
        if (i12 > 1) {
            int i15 = i12 - 2;
            codewordArr2[8] = codewordArr[i15];
            codewordArr2[10] = codewords[i15];
            codewordArr2[11] = codewords2[i15];
        }
        if (i12 < codewordArr.length - 1) {
            int i16 = i12 + 1;
            codewordArr2[1] = codewordArr[i16];
            codewordArr2[6] = codewords[i16];
            codewordArr2[7] = codewords2[i16];
        }
        if (i12 < codewordArr.length - 2) {
            int i17 = i12 + 2;
            codewordArr2[9] = codewordArr[i17];
            codewordArr2[12] = codewords[i17];
            codewordArr2[13] = codewords2[i17];
        }
        while (i13 < 14 && !adjustRowNumber(codeword, codewordArr2[i13])) {
            i13++;
        }
    }
}
