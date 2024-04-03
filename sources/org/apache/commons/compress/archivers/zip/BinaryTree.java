package org.apache.commons.compress.archivers.zip;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.utils.IOUtils;

class BinaryTree {
    private static final int NODE = -2;
    private static final int UNDEFINED = -1;
    private final int[] tree;

    public BinaryTree(int i11) {
        if (i11 < 0 || i11 > 30) {
            throw new IllegalArgumentException("depth must be bigger than 0 and not bigger than 30 but is " + i11);
        }
        int[] iArr = new int[((int) ((1 << (i11 + 1)) - 1))];
        this.tree = iArr;
        Arrays.fill(iArr, -1);
    }

    public static BinaryTree a(InputStream inputStream, int i11) throws IOException {
        if (i11 >= 0) {
            int read = inputStream.read() + 1;
            if (read != 0) {
                byte[] readRange = IOUtils.readRange(inputStream, read);
                if (readRange.length == read) {
                    int[] iArr = new int[i11];
                    int length = readRange.length;
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (i12 < length) {
                        byte b11 = readRange[i12];
                        int i15 = ((b11 & 240) >> 4) + 1;
                        if (i13 + i15 <= i11) {
                            int i16 = (b11 & Ascii.SI) + 1;
                            int i17 = 0;
                            while (i17 < i15) {
                                iArr[i13] = i16;
                                i17++;
                                i13++;
                            }
                            i14 = Math.max(i14, i16);
                            i12++;
                        } else {
                            throw new IOException("Number of values exceeds given total number of values");
                        }
                    }
                    int[] iArr2 = new int[i11];
                    for (int i18 = 0; i18 < i11; i18++) {
                        iArr2[i18] = i18;
                    }
                    int[] iArr3 = new int[i11];
                    int i19 = 0;
                    for (int i21 = 0; i21 < i11; i21++) {
                        for (int i22 = 0; i22 < i11; i22++) {
                            if (iArr[i22] == i21) {
                                iArr3[i19] = i21;
                                iArr2[i19] = i22;
                                i19++;
                            }
                        }
                    }
                    int[] iArr4 = new int[i11];
                    int i23 = 0;
                    int i24 = 0;
                    int i25 = 0;
                    for (int i26 = i11 - 1; i26 >= 0; i26--) {
                        i23 += i24;
                        int i27 = iArr3[i26];
                        if (i27 != i25) {
                            i24 = 1 << (16 - i27);
                            i25 = i27;
                        }
                        iArr4[iArr2[i26]] = i23;
                    }
                    BinaryTree binaryTree = new BinaryTree(i14);
                    for (int i28 = 0; i28 < i11; i28++) {
                        int i29 = iArr[i28];
                        if (i29 > 0) {
                            binaryTree.addLeaf(0, Integer.reverse(iArr4[i28] << 16), i29, i28);
                        }
                    }
                    return binaryTree;
                }
                throw new EOFException();
            }
            throw new IOException("Cannot read the size of the encoded tree, unexpected end of stream");
        }
        throw new IllegalArgumentException("totalNumberOfValues must be bigger than 0, is " + i11);
    }

    public void addLeaf(int i11, int i12, int i13, int i14) {
        if (i13 == 0) {
            int[] iArr = this.tree;
            if (iArr[i11] == -1) {
                iArr[i11] = i14;
                return;
            }
            throw new IllegalArgumentException("Tree value at index " + i11 + " has already been assigned (" + this.tree[i11] + ")");
        }
        this.tree[i11] = -2;
        addLeaf((i11 * 2) + 1 + (i12 & 1), i12 >>> 1, i13 - 1, i14);
    }

    public int read(BitStream bitStream) throws IOException {
        int i11 = 0;
        while (true) {
            int a11 = bitStream.a();
            if (a11 == -1) {
                return -1;
            }
            int i12 = (i11 * 2) + 1 + a11;
            int i13 = this.tree[i12];
            if (i13 == -2) {
                i11 = i12;
            } else if (i13 != -1) {
                return i13;
            } else {
                throw new IOException("The child " + a11 + " of node at index " + i11 + " is not defined");
            }
        }
    }
}
