package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class MetadataItem extends Table {

    public static final class Vector extends BaseVector {
        public Vector __assign(int i11, int i12, ByteBuffer byteBuffer) {
            b(i11, i12, byteBuffer);
            return this;
        }

        public MetadataItem get(int i11) {
            return get(new MetadataItem(), i11);
        }

        public MetadataItem get(MetadataItem metadataItem, int i11) {
            return metadataItem.__assign(Table.b(a(i11), this.f35915a), this.f35915a);
        }
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_12_0();
    }

    public static void addCodepoints(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addOffset(6, i11, 0);
    }

    public static void addCompatAdded(FlatBufferBuilder flatBufferBuilder, short s11) {
        flatBufferBuilder.addShort(3, s11, 0);
    }

    public static void addEmojiStyle(FlatBufferBuilder flatBufferBuilder, boolean z11) {
        flatBufferBuilder.addBoolean(1, z11, false);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, short s11) {
        flatBufferBuilder.addShort(5, s11, 0);
    }

    public static void addId(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.addInt(0, i11, 0);
    }

    public static void addSdkAdded(FlatBufferBuilder flatBufferBuilder, short s11) {
        flatBufferBuilder.addShort(2, s11, 0);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, short s11) {
        flatBufferBuilder.addShort(4, s11, 0);
    }

    public static int createCodepointsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static int createMetadataItem(FlatBufferBuilder flatBufferBuilder, int i11, boolean z11, short s11, short s12, short s13, short s14, int i12) {
        flatBufferBuilder.startTable(7);
        addCodepoints(flatBufferBuilder, i12);
        addId(flatBufferBuilder, i11);
        addHeight(flatBufferBuilder, s14);
        addWidth(flatBufferBuilder, s13);
        addCompatAdded(flatBufferBuilder, s12);
        addSdkAdded(flatBufferBuilder, s11);
        addEmojiStyle(flatBufferBuilder, z11);
        return endMetadataItem(flatBufferBuilder);
    }

    public static int endMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer) {
        return getRootAsMetadataItem(byteBuffer, new MetadataItem());
    }

    public static void startCodepointsVector(FlatBufferBuilder flatBufferBuilder, int i11) {
        flatBufferBuilder.startVector(4, i11, 4);
    }

    public static void startMetadataItem(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public MetadataItem __assign(int i11, ByteBuffer byteBuffer) {
        __init(i11, byteBuffer);
        return this;
    }

    public void __init(int i11, ByteBuffer byteBuffer) {
        d(i11, byteBuffer);
    }

    public int codepoints(int i11) {
        int c11 = c(16);
        if (c11 != 0) {
            return this.f35947b.getInt(h(c11) + (i11 * 4));
        }
        return 0;
    }

    public ByteBuffer codepointsAsByteBuffer() {
        return i(16, 4);
    }

    public ByteBuffer codepointsInByteBuffer(ByteBuffer byteBuffer) {
        return j(byteBuffer, 16, 4);
    }

    public int codepointsLength() {
        int c11 = c(16);
        if (c11 != 0) {
            return k(c11);
        }
        return 0;
    }

    public IntVector codepointsVector() {
        return codepointsVector(new IntVector());
    }

    public short compatAdded() {
        int c11 = c(10);
        if (c11 != 0) {
            return this.f35947b.getShort(c11 + this.f35946a);
        }
        return 0;
    }

    public boolean emojiStyle() {
        int c11 = c(6);
        return (c11 == 0 || this.f35947b.get(c11 + this.f35946a) == 0) ? false : true;
    }

    public short height() {
        int c11 = c(14);
        if (c11 != 0) {
            return this.f35947b.getShort(c11 + this.f35946a);
        }
        return 0;
    }

    public int id() {
        int c11 = c(4);
        if (c11 != 0) {
            return this.f35947b.getInt(c11 + this.f35946a);
        }
        return 0;
    }

    public short sdkAdded() {
        int c11 = c(8);
        if (c11 != 0) {
            return this.f35947b.getShort(c11 + this.f35946a);
        }
        return 0;
    }

    public short width() {
        int c11 = c(12);
        if (c11 != 0) {
            return this.f35947b.getShort(c11 + this.f35946a);
        }
        return 0;
    }

    public static MetadataItem getRootAsMetadataItem(ByteBuffer byteBuffer, MetadataItem metadataItem) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataItem.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public IntVector codepointsVector(IntVector intVector) {
        int c11 = c(16);
        if (c11 != 0) {
            return intVector.__assign(h(c11), this.f35947b);
        }
        return null;
    }
}
