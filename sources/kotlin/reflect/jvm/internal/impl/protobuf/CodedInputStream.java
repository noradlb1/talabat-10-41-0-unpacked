package kotlin.reflect.jvm.internal.impl.protobuf;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

public final class CodedInputStream {
    private final byte[] buffer;
    private final boolean bufferIsImmutable;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private boolean enableAliasing;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private RefillCallback refillCallback;
    private int sizeLimit;
    private int totalBytesRetired;

    public interface RefillCallback {
        void onRefill();
    }

    private CodedInputStream(InputStream inputStream) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
        this.bufferIsImmutable = false;
    }

    public static CodedInputStream a(LiteralByteString literalByteString) {
        CodedInputStream codedInputStream = new CodedInputStream(literalByteString);
        try {
            codedInputStream.pushLimit(literalByteString.size());
            return codedInputStream;
        } catch (InvalidProtocolBufferException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static int decodeZigZag32(int i11) {
        return (-(i11 & 1)) ^ (i11 >>> 1);
    }

    public static long decodeZigZag64(long j11) {
        return (-(j11 & 1)) ^ (j11 >>> 1);
    }

    private void ensureAvailable(int i11) throws IOException {
        if (this.bufferSize - this.bufferPos < i11) {
            refillBuffer(i11);
        }
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    private byte[] readRawBytesSlowPath(int i11) throws IOException {
        int i12;
        if (i11 > 0) {
            int i13 = this.totalBytesRetired;
            int i14 = this.bufferPos;
            int i15 = i13 + i14 + i11;
            int i16 = this.currentLimit;
            if (i15 > i16) {
                skipRawBytes((i16 - i13) - i14);
                throw InvalidProtocolBufferException.i();
            } else if (i11 < 4096) {
                byte[] bArr = new byte[i11];
                int i17 = this.bufferSize - i14;
                System.arraycopy(this.buffer, i14, bArr, 0, i17);
                this.bufferPos = this.bufferSize;
                int i18 = i11 - i17;
                ensureAvailable(i18);
                System.arraycopy(this.buffer, 0, bArr, i17, i18);
                this.bufferPos = i18;
                return bArr;
            } else {
                int i19 = this.bufferSize;
                this.totalBytesRetired = i13 + i19;
                this.bufferPos = 0;
                this.bufferSize = 0;
                int i21 = i19 - i14;
                int i22 = i11 - i21;
                ArrayList<byte[]> arrayList = new ArrayList<>();
                while (i22 > 0) {
                    int min = Math.min(i22, 4096);
                    byte[] bArr2 = new byte[min];
                    int i23 = 0;
                    while (i23 < min) {
                        InputStream inputStream = this.input;
                        if (inputStream == null) {
                            i12 = -1;
                        } else {
                            i12 = inputStream.read(bArr2, i23, min - i23);
                        }
                        if (i12 != -1) {
                            this.totalBytesRetired += i12;
                            i23 += i12;
                        } else {
                            throw InvalidProtocolBufferException.i();
                        }
                    }
                    i22 -= min;
                    arrayList.add(bArr2);
                }
                byte[] bArr3 = new byte[i11];
                System.arraycopy(this.buffer, i14, bArr3, 0, i21);
                for (byte[] bArr4 : arrayList) {
                    System.arraycopy(bArr4, 0, bArr3, i21, bArr4.length);
                    i21 += bArr4.length;
                }
                return bArr3;
            }
        } else if (i11 == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        } else {
            throw InvalidProtocolBufferException.f();
        }
    }

    private void recomputeBufferSizeAfterLimit() {
        int i11 = this.bufferSize + this.bufferSizeAfterLimit;
        this.bufferSize = i11;
        int i12 = this.totalBytesRetired + i11;
        int i13 = this.currentLimit;
        if (i12 > i13) {
            int i14 = i12 - i13;
            this.bufferSizeAfterLimit = i14;
            this.bufferSize = i11 - i14;
            return;
        }
        this.bufferSizeAfterLimit = 0;
    }

    private void refillBuffer(int i11) throws IOException {
        if (!tryRefillBuffer(i11)) {
            throw InvalidProtocolBufferException.i();
        }
    }

    private void skipRawBytesSlowPath(int i11) throws IOException {
        if (i11 >= 0) {
            int i12 = this.totalBytesRetired;
            int i13 = this.bufferPos;
            int i14 = i12 + i13 + i11;
            int i15 = this.currentLimit;
            if (i14 <= i15) {
                int i16 = this.bufferSize;
                int i17 = i16 - i13;
                this.bufferPos = i16;
                refillBuffer(1);
                while (true) {
                    int i18 = i11 - i17;
                    int i19 = this.bufferSize;
                    if (i18 > i19) {
                        i17 += i19;
                        this.bufferPos = i19;
                        refillBuffer(1);
                    } else {
                        this.bufferPos = i18;
                        return;
                    }
                }
            } else {
                skipRawBytes((i15 - i12) - i13);
                throw InvalidProtocolBufferException.i();
            }
        } else {
            throw InvalidProtocolBufferException.f();
        }
    }

    private boolean tryRefillBuffer(int i11) throws IOException {
        int i12 = this.bufferPos;
        if (i12 + i11 <= this.bufferSize) {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i11);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        } else if (this.totalBytesRetired + i12 + i11 > this.currentLimit) {
            return false;
        } else {
            RefillCallback refillCallback2 = this.refillCallback;
            if (refillCallback2 != null) {
                refillCallback2.onRefill();
            }
            if (this.input != null) {
                int i13 = this.bufferPos;
                if (i13 > 0) {
                    int i14 = this.bufferSize;
                    if (i14 > i13) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i13, bArr, 0, i14 - i13);
                    }
                    this.totalBytesRetired += i13;
                    this.bufferSize -= i13;
                    this.bufferPos = 0;
                }
                InputStream inputStream = this.input;
                byte[] bArr2 = this.buffer;
                int i15 = this.bufferSize;
                int read = inputStream.read(bArr2, i15, bArr2.length - i15);
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    StringBuilder sb3 = new StringBuilder(102);
                    sb3.append("InputStream#read(byte[]) returned invalid result: ");
                    sb3.append(read);
                    sb3.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb3.toString());
                } else if (read > 0) {
                    this.bufferSize += read;
                    if ((this.totalBytesRetired + i11) - this.sizeLimit <= 0) {
                        recomputeBufferSizeAfterLimit();
                        if (this.bufferSize >= i11) {
                            return true;
                        }
                        return tryRefillBuffer(i11);
                    }
                    throw InvalidProtocolBufferException.h();
                }
            }
            return false;
        }
    }

    public long b() throws IOException {
        long j11 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte readRawByte = readRawByte();
            j11 |= ((long) (readRawByte & Byte.MAX_VALUE)) << i11;
            if ((readRawByte & 128) == 0) {
                return j11;
            }
        }
        throw InvalidProtocolBufferException.e();
    }

    public void checkLastTagWas(int i11) throws InvalidProtocolBufferException {
        if (this.lastTag != i11) {
            throw InvalidProtocolBufferException.a();
        }
    }

    public int getBytesUntilLimit() {
        int i11 = this.currentLimit;
        if (i11 == Integer.MAX_VALUE) {
            return -1;
        }
        return i11 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() throws IOException {
        return this.bufferPos == this.bufferSize && !tryRefillBuffer(1);
    }

    public void popLimit(int i11) {
        this.currentLimit = i11;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i11) throws InvalidProtocolBufferException {
        if (i11 >= 0) {
            int i12 = i11 + this.totalBytesRetired + this.bufferPos;
            int i13 = this.currentLimit;
            if (i12 <= i13) {
                this.currentLimit = i12;
                recomputeBufferSizeAfterLimit();
                return i13;
            }
            throw InvalidProtocolBufferException.i();
        }
        throw InvalidProtocolBufferException.f();
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public ByteString readBytes() throws IOException {
        ByteString byteString;
        int readRawVarint32 = readRawVarint32();
        int i11 = this.bufferSize;
        int i12 = this.bufferPos;
        if (readRawVarint32 <= i11 - i12 && readRawVarint32 > 0) {
            if (!this.bufferIsImmutable || !this.enableAliasing) {
                byteString = ByteString.copyFrom(this.buffer, i12, readRawVarint32);
            } else {
                byteString = new BoundedByteString(this.buffer, this.bufferPos, readRawVarint32);
            }
            this.bufferPos += readRawVarint32;
            return byteString;
        } else if (readRawVarint32 == 0) {
            return ByteString.EMPTY;
        } else {
            return new LiteralByteString(readRawBytesSlowPath(readRawVarint32));
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i11, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i12 = this.recursionDepth;
        if (i12 < this.recursionLimit) {
            this.recursionDepth = i12 + 1;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.b(i11, 4));
            this.recursionDepth--;
            return;
        }
        throw InvalidProtocolBufferException.g();
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.g();
    }

    public byte readRawByte() throws IOException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(1);
        }
        byte[] bArr = this.buffer;
        int i11 = this.bufferPos;
        this.bufferPos = i11 + 1;
        return bArr[i11];
    }

    public int readRawLittleEndian32() throws IOException {
        int i11 = this.bufferPos;
        if (this.bufferSize - i11 < 4) {
            refillBuffer(4);
            i11 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i11 + 4;
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    public long readRawLittleEndian64() throws IOException {
        int i11 = this.bufferPos;
        if (this.bufferSize - i11 < 8) {
            refillBuffer(8);
            i11 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i11 + 8;
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
        if (r2[r3] < 0) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readRawVarint32() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.bufferPos
            int r1 = r9.bufferSize
            if (r1 != r0) goto L_0x0008
            goto L_0x007c
        L_0x0008:
            byte[] r2 = r9.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0013
            r9.bufferPos = r3
            return r0
        L_0x0013:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x0019
            goto L_0x007c
        L_0x0019:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x002d
            r5 = -128(0xffffffffffffff80, double:NaN)
        L_0x0029:
            long r2 = r3 ^ r5
            int r0 = (int) r2
            goto L_0x0082
        L_0x002d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            long r7 = (long) r0
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x003f
            r0 = 16256(0x3f80, double:8.0315E-320)
            long r0 = r0 ^ r7
            int r0 = (int) r0
        L_0x003d:
            r1 = r3
            goto L_0x0082
        L_0x003f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            long r3 = (long) r0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x004f
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L_0x0029
        L_0x004f:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            long r4 = (long) r0
            r6 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r4 = r4 ^ r6
            int r0 = (int) r4
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0082
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0082
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x003d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 >= 0) goto L_0x0082
        L_0x007c:
            long r0 = r9.b()
            int r0 = (int) r0
            return r0
        L_0x0082:
            r9.bufferPos = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint32():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
        if (((long) r2[r0]) < 0) goto L_0x00b8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readRawVarint64() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.bufferPos
            int r1 = r9.bufferSize
            if (r1 != r0) goto L_0x0008
            goto L_0x00b8
        L_0x0008:
            byte[] r2 = r9.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0014
            r9.bufferPos = r3
            long r0 = (long) r0
            return r0
        L_0x0014:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L_0x001b
            goto L_0x00b8
        L_0x001b:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            long r3 = (long) r0
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x002f
            r5 = -128(0xffffffffffffff80, double:NaN)
        L_0x002b:
            long r2 = r3 ^ r5
            goto L_0x00bf
        L_0x002f:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            long r7 = (long) r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0042
            r1 = 16256(0x3f80, double:8.0315E-320)
        L_0x003d:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00bf
        L_0x0042:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            int r0 = r0 << 21
            long r7 = (long) r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0052
            r5 = -2080896(0xffffffffffe03f80, double:NaN)
            goto L_0x002b
        L_0x0052:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 28
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0063
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
            goto L_0x003d
        L_0x0063:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0076
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
            goto L_0x002b
        L_0x0076:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0089
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x003d
        L_0x0089:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x009c
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x002b
        L_0x009c:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00bd
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00be
        L_0x00b8:
            long r0 = r9.b()
            return r0
        L_0x00bd:
            r1 = r0
        L_0x00be:
            r2 = r3
        L_0x00bf:
            r9.bufferPos = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.readRawVarint64():long");
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int readRawVarint32 = readRawVarint32();
        int i11 = this.bufferSize;
        int i12 = this.bufferPos;
        if (readRawVarint32 <= i11 - i12 && readRawVarint32 > 0) {
            String str = new String(this.buffer, i12, readRawVarint32, "UTF-8");
            this.bufferPos += readRawVarint32;
            return str;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            return new String(readRawBytesSlowPath(readRawVarint32), "UTF-8");
        }
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] bArr;
        int readRawVarint32 = readRawVarint32();
        int i11 = this.bufferPos;
        if (readRawVarint32 <= this.bufferSize - i11 && readRawVarint32 > 0) {
            bArr = this.buffer;
            this.bufferPos = i11 + readRawVarint32;
        } else if (readRawVarint32 == 0) {
            return "";
        } else {
            bArr = readRawBytesSlowPath(readRawVarint32);
            i11 = 0;
        }
        if (Utf8.isValidUtf8(bArr, i11, i11 + readRawVarint32)) {
            return new String(bArr, i11, readRawVarint32, "UTF-8");
        }
        throw InvalidProtocolBufferException.c();
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        int readRawVarint32 = readRawVarint32();
        this.lastTag = readRawVarint32;
        if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
            return this.lastTag;
        }
        throw InvalidProtocolBufferException.b();
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public boolean skipField(int i11, CodedOutputStream codedOutputStream) throws IOException {
        int a11 = WireFormat.a(i11);
        if (a11 == 0) {
            long readInt64 = readInt64();
            codedOutputStream.writeRawVarint32(i11);
            codedOutputStream.writeUInt64NoTag(readInt64);
            return true;
        } else if (a11 == 1) {
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i11);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        } else if (a11 == 2) {
            ByteString readBytes = readBytes();
            codedOutputStream.writeRawVarint32(i11);
            codedOutputStream.writeBytesNoTag(readBytes);
            return true;
        } else if (a11 == 3) {
            codedOutputStream.writeRawVarint32(i11);
            skipMessage(codedOutputStream);
            int b11 = WireFormat.b(WireFormat.getTagFieldNumber(i11), 4);
            checkLastTagWas(b11);
            codedOutputStream.writeRawVarint32(b11);
            return true;
        } else if (a11 == 4) {
            return false;
        } else {
            if (a11 == 5) {
                int readRawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeRawVarint32(i11);
                codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.d();
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void skipMessage(kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r2) throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r1.readTag()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.skipField(r0, r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream.skipMessage(kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream):void");
    }

    public void skipRawBytes(int i11) throws IOException {
        int i12 = this.bufferSize;
        int i13 = this.bufferPos;
        if (i11 > i12 - i13 || i11 < 0) {
            skipRawBytesSlowPath(i11);
        } else {
            this.bufferPos = i13 + i11;
        }
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t11 = (MessageLite) parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return t11;
        }
        throw InvalidProtocolBufferException.g();
    }

    private CodedInputStream(LiteralByteString literalByteString) {
        this.enableAliasing = false;
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = 67108864;
        this.refillCallback = null;
        this.buffer = literalByteString.f24764b;
        int j11 = literalByteString.j();
        this.bufferPos = j11;
        this.bufferSize = j11 + literalByteString.size();
        this.totalBytesRetired = -this.bufferPos;
        this.input = null;
        this.bufferIsImmutable = true;
    }

    public static int readRawVarint32(int i11, InputStream inputStream) throws IOException {
        if ((i11 & 128) == 0) {
            return i11;
        }
        int i12 = i11 & 127;
        int i13 = 7;
        while (i13 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i12 |= (read & 127) << i13;
                if ((read & 128) == 0) {
                    return i12;
                }
                i13 += 7;
            } else {
                throw InvalidProtocolBufferException.i();
            }
        }
        while (i13 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.i();
            } else if ((read2 & 128) == 0) {
                return i12;
            } else {
                i13 += 7;
            }
        }
        throw InvalidProtocolBufferException.e();
    }
}
