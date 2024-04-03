package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    private final boolean isLeft;

    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z11) {
        super(boundingBox);
        this.isLeft = z11;
    }

    private void adjustIncompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        BoundingBox boundingBox = getBoundingBox();
        if (this.isLeft) {
            resultPoint = boundingBox.getTopLeft();
        } else {
            resultPoint = boundingBox.getTopRight();
        }
        if (this.isLeft) {
            resultPoint2 = boundingBox.getBottomLeft();
        } else {
            resultPoint2 = boundingBox.getBottomRight();
        }
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) resultPoint2.getY());
        Codeword[] codewords = getCodewords();
        int i11 = -1;
        int i12 = 0;
        int i13 = 1;
        for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) resultPoint.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
            Codeword codeword = codewords[imageRowToCodewordIndex2];
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int rowNumber = codeword.getRowNumber() - i11;
                if (rowNumber == 0) {
                    i12++;
                } else {
                    if (rowNumber == 1) {
                        i13 = Math.max(i13, i12);
                        i11 = codeword.getRowNumber();
                    } else if (codeword.getRowNumber() >= barcodeMetadata.getRowCount()) {
                        codewords[imageRowToCodewordIndex2] = null;
                    } else {
                        i11 = codeword.getRowNumber();
                    }
                    i12 = 1;
                }
            }
        }
    }

    private void removeIncorrectCodewords(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i11 = 0; i11 < codewordArr.length; i11++) {
            Codeword codeword = codewordArr[i11];
            if (codeword != null) {
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (rowNumber > barcodeMetadata.getRowCount()) {
                    codewordArr[i11] = null;
                } else {
                    if (!this.isLeft) {
                        rowNumber += 2;
                    }
                    int i12 = rowNumber % 3;
                    if (i12 != 0) {
                        if (i12 != 1) {
                            if (i12 == 2 && value + 1 != barcodeMetadata.getColumnCount()) {
                                codewordArr[i11] = null;
                            }
                        } else if (value / 3 != barcodeMetadata.getErrorCorrectionLevel() || value % 3 != barcodeMetadata.getRowCountLowerPart()) {
                            codewordArr[i11] = null;
                        }
                    } else if ((value * 3) + 1 != barcodeMetadata.getRowCountUpperPart()) {
                        codewordArr[i11] = null;
                    }
                }
            }
        }
    }

    private void setRowNumbers() {
        for (Codeword codeword : getCodewords()) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
            }
        }
    }

    public void adjustCompleteIndicatorColumnRowNumbers(BarcodeMetadata barcodeMetadata) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        boolean z11;
        boolean z12;
        Codeword[] codewords = getCodewords();
        setRowNumbers();
        removeIncorrectCodewords(codewords, barcodeMetadata);
        BoundingBox boundingBox = getBoundingBox();
        if (this.isLeft) {
            resultPoint = boundingBox.getTopLeft();
        } else {
            resultPoint = boundingBox.getTopRight();
        }
        if (this.isLeft) {
            resultPoint2 = boundingBox.getBottomLeft();
        } else {
            resultPoint2 = boundingBox.getBottomRight();
        }
        int imageRowToCodewordIndex = imageRowToCodewordIndex((int) resultPoint2.getY());
        int i11 = -1;
        int i12 = 0;
        int i13 = 1;
        for (int imageRowToCodewordIndex2 = imageRowToCodewordIndex((int) resultPoint.getY()); imageRowToCodewordIndex2 < imageRowToCodewordIndex; imageRowToCodewordIndex2++) {
            Codeword codeword = codewords[imageRowToCodewordIndex2];
            if (codeword != null) {
                int rowNumber = codeword.getRowNumber() - i11;
                if (rowNumber == 0) {
                    i12++;
                } else {
                    if (rowNumber == 1) {
                        i13 = Math.max(i13, i12);
                        i11 = codeword.getRowNumber();
                    } else if (rowNumber < 0 || codeword.getRowNumber() >= barcodeMetadata.getRowCount() || rowNumber > imageRowToCodewordIndex2) {
                        codewords[imageRowToCodewordIndex2] = null;
                    } else {
                        if (i13 > 2) {
                            rowNumber *= i13 - 2;
                        }
                        if (rowNumber >= imageRowToCodewordIndex2) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        for (int i14 = 1; i14 <= rowNumber && !z11; i14++) {
                            if (codewords[imageRowToCodewordIndex2 - i14] != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                        }
                        if (z11) {
                            codewords[imageRowToCodewordIndex2] = null;
                        } else {
                            i11 = codeword.getRowNumber();
                        }
                    }
                    i12 = 1;
                }
            }
        }
    }

    public BarcodeMetadata getBarcodeMetadata() {
        Codeword[] codewords = getCodewords();
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewords) {
            if (codeword != null) {
                codeword.setRowNumberAsRowIndicatorColumn();
                int value = codeword.getValue() % 30;
                int rowNumber = codeword.getRowNumber();
                if (!this.isLeft) {
                    rowNumber += 2;
                }
                int i11 = rowNumber % 3;
                if (i11 == 0) {
                    barcodeValue2.setValue((value * 3) + 1);
                } else if (i11 == 1) {
                    barcodeValue4.setValue(value / 3);
                    barcodeValue3.setValue(value % 3);
                } else if (i11 == 2) {
                    barcodeValue.setValue(value + 1);
                }
            }
        }
        if (barcodeValue.getValue().length == 0 || barcodeValue2.getValue().length == 0 || barcodeValue3.getValue().length == 0 || barcodeValue4.getValue().length == 0 || barcodeValue.getValue()[0] <= 0 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] < 3 || barcodeValue2.getValue()[0] + barcodeValue3.getValue()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.getValue()[0], barcodeValue2.getValue()[0], barcodeValue3.getValue()[0], barcodeValue4.getValue()[0]);
        removeIncorrectCodewords(codewords, barcodeMetadata);
        return barcodeMetadata;
    }

    public int[] getRowHeights() {
        int rowNumber;
        BarcodeMetadata barcodeMetadata = getBarcodeMetadata();
        if (barcodeMetadata == null) {
            return null;
        }
        adjustIncompleteIndicatorColumnRowNumbers(barcodeMetadata);
        int rowCount = barcodeMetadata.getRowCount();
        int[] iArr = new int[rowCount];
        for (Codeword codeword : getCodewords()) {
            if (codeword != null && (rowNumber = codeword.getRowNumber()) < rowCount) {
                iArr[rowNumber] = iArr[rowNumber] + 1;
            }
        }
        return iArr;
    }

    public boolean isLeft() {
        return this.isLeft;
    }

    public String toString() {
        return "IsLeft: " + this.isLeft + 10 + super.toString();
    }
}
