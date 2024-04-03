package io.flutter.embedding.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class KeyData {
    private static final int BYTES_PER_FIELD = 8;
    public static final String CHANNEL = "flutter/keydata";
    private static final int FIELD_COUNT = 5;
    private static final String TAG = "KeyData";

    /* renamed from: a  reason: collision with root package name */
    public long f14149a;

    /* renamed from: b  reason: collision with root package name */
    public Type f14150b;

    /* renamed from: c  reason: collision with root package name */
    public long f14151c;

    /* renamed from: d  reason: collision with root package name */
    public long f14152d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14153e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public String f14154f;

    public enum Type {
        kDown(0),
        kUp(1),
        kRepeat(2);
        
        private long value;

        private Type(long j11) {
            this.value = j11;
        }

        public static Type a(long j11) {
            int i11 = (int) j11;
            if (i11 == 0) {
                return kDown;
            }
            if (i11 == 1) {
                return kUp;
            }
            if (i11 == 2) {
                return kRepeat;
            }
            throw new AssertionError("Unexpected Type value");
        }

        public long getValue() {
            return this.value;
        }
    }

    public KeyData() {
    }

    public KeyData(@NonNull ByteBuffer byteBuffer) {
        boolean z11;
        long j11 = byteBuffer.getLong();
        this.f14149a = byteBuffer.getLong();
        this.f14150b = Type.a(byteBuffer.getLong());
        this.f14151c = byteBuffer.getLong();
        this.f14152d = byteBuffer.getLong();
        if (byteBuffer.getLong() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f14153e = z11;
        if (((long) byteBuffer.remaining()) == j11) {
            this.f14154f = null;
            if (j11 != 0) {
                int i11 = (int) j11;
                byte[] bArr = new byte[i11];
                byteBuffer.get(bArr, 0, i11);
                try {
                    this.f14154f = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    throw new AssertionError("UTF-8 unsupported");
                }
            }
        } else {
            throw new AssertionError(String.format("Unexpected char length: charSize is %d while buffer has position %d, capacity %d, limit %d", new Object[]{Long.valueOf(j11), Integer.valueOf(byteBuffer.position()), Integer.valueOf(byteBuffer.capacity()), Integer.valueOf(byteBuffer.limit())}));
        }
    }

    public ByteBuffer a() {
        byte[] bArr;
        int i11;
        long j11;
        try {
            String str = this.f14154f;
            if (str == null) {
                bArr = null;
            } else {
                bArr = str.getBytes("UTF-8");
            }
            if (bArr == null) {
                i11 = 0;
            } else {
                i11 = bArr.length;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i11 + 48);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong((long) i11);
            allocateDirect.putLong(this.f14149a);
            allocateDirect.putLong(this.f14150b.getValue());
            allocateDirect.putLong(this.f14151c);
            allocateDirect.putLong(this.f14152d);
            if (this.f14153e) {
                j11 = 1;
            } else {
                j11 = 0;
            }
            allocateDirect.putLong(j11);
            if (bArr != null) {
                allocateDirect.put(bArr);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
