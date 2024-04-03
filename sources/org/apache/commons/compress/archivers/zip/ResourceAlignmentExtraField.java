package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;
import kotlin.jvm.internal.ShortCompanionObject;
import net.bytebuddy.asm.Advice;

public class ResourceAlignmentExtraField implements ZipExtraField {
    private static final int ALLOW_METHOD_MESSAGE_CHANGE_FLAG = 32768;
    public static final int BASE_SIZE = 2;
    public static final ZipShort ID = new ZipShort(41246);
    private short alignment;
    private boolean allowMethodChange;
    private int padding;

    public ResourceAlignmentExtraField() {
    }

    public boolean allowMethodChange() {
        return this.allowMethodChange;
    }

    public short getAlignment() {
        return this.alignment;
    }

    public byte[] getCentralDirectoryData() {
        return ZipShort.getBytes(this.alignment | (this.allowMethodChange ? ShortCompanionObject.MIN_VALUE : 0));
    }

    public ZipShort getCentralDirectoryLength() {
        return new ZipShort(2);
    }

    public ZipShort getHeaderId() {
        return ID;
    }

    public byte[] getLocalFileDataData() {
        short s11;
        byte[] bArr = new byte[(this.padding + 2)];
        short s12 = this.alignment;
        if (this.allowMethodChange) {
            s11 = ShortCompanionObject.MIN_VALUE;
        } else {
            s11 = 0;
        }
        ZipShort.putShort(s12 | s11, bArr, 0);
        return bArr;
    }

    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.padding + 2);
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        boolean z11;
        if (i12 >= 2) {
            int value = ZipShort.getValue(bArr, i11);
            this.alignment = (short) (value & Advice.MethodSizeHandler.UNDEFINED_SIZE);
            if ((value & 32768) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.allowMethodChange = z11;
            return;
        }
        throw new ZipException("Too short content for ResourceAlignmentExtraField (0xa11e): " + i12);
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        parseFromCentralDirectoryData(bArr, i11, i12);
        this.padding = i12 - 2;
    }

    public ResourceAlignmentExtraField(int i11) {
        this(i11, false);
    }

    public ResourceAlignmentExtraField(int i11, boolean z11) {
        this(i11, z11, 0);
    }

    public ResourceAlignmentExtraField(int i11, boolean z11, int i12) {
        if (i11 < 0 || i11 > 32767) {
            throw new IllegalArgumentException("Alignment must be between 0 and 0x7fff, was: " + i11);
        } else if (i12 >= 0) {
            this.alignment = (short) i11;
            this.allowMethodChange = z11;
            this.padding = i12;
        } else {
            throw new IllegalArgumentException("Padding must not be negative, was: " + i12);
        }
    }
}
