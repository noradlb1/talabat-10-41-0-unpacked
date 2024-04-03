package org.tukaani.xz.index;

public class BlockInfo {

    /* renamed from: a  reason: collision with root package name */
    public IndexDecoder f63424a;
    public int blockNumber = -1;
    public long compressedOffset = -1;
    public long uncompressedOffset = -1;
    public long uncompressedSize = -1;
    public long unpaddedSize = -1;

    public BlockInfo(IndexDecoder indexDecoder) {
        this.f63424a = indexDecoder;
    }

    public int getCheckType() {
        return this.f63424a.getStreamFlags().checkType;
    }

    public boolean hasNext() {
        return this.f63424a.hasRecord(this.blockNumber + 1);
    }

    public void setNext() {
        this.f63424a.setBlockInfo(this, this.blockNumber + 1);
    }
}
