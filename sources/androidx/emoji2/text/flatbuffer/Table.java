package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

public class Table {

    /* renamed from: a  reason: collision with root package name */
    public int f35946a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f35947b;

    /* renamed from: c  reason: collision with root package name */
    public Utf8 f35948c = Utf8.getDefault();
    private int vtable_size;
    private int vtable_start;

    public static int b(int i11, ByteBuffer byteBuffer) {
        return i11 + byteBuffer.getInt(i11);
    }

    public static String f(int i11, ByteBuffer byteBuffer, Utf8 utf8) {
        int i12 = i11 + byteBuffer.getInt(i11);
        return utf8.decodeUtf8(byteBuffer, i12 + 4, byteBuffer.getInt(i12));
    }

    public static Table g(Table table, int i11, ByteBuffer byteBuffer) {
        table.d(b(i11, byteBuffer), byteBuffer);
        return table;
    }

    public void __reset() {
        d(0, (ByteBuffer) null);
    }

    public int a(int i11) {
        return i11 + this.f35947b.getInt(i11);
    }

    public int c(int i11) {
        if (i11 < this.vtable_size) {
            return this.f35947b.getShort(this.vtable_start + i11);
        }
        return 0;
    }

    public void d(int i11, ByteBuffer byteBuffer) {
        this.f35947b = byteBuffer;
        if (byteBuffer != null) {
            this.f35946a = i11;
            int i12 = i11 - byteBuffer.getInt(i11);
            this.vtable_start = i12;
            this.vtable_size = this.f35947b.getShort(i12);
            return;
        }
        this.f35946a = 0;
        this.vtable_start = 0;
        this.vtable_size = 0;
    }

    public String e(int i11) {
        return f(i11, this.f35947b, this.f35948c);
    }

    public ByteBuffer getByteBuffer() {
        return this.f35947b;
    }

    public int h(int i11) {
        int i12 = i11 + this.f35946a;
        return i12 + this.f35947b.getInt(i12) + 4;
    }

    public ByteBuffer i(int i11, int i12) {
        int c11 = c(i11);
        if (c11 == 0) {
            return null;
        }
        ByteBuffer order = this.f35947b.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int h11 = h(c11);
        order.position(h11);
        order.limit(h11 + (k(c11) * i12));
        return order;
    }

    public ByteBuffer j(ByteBuffer byteBuffer, int i11, int i12) {
        int c11 = c(i11);
        if (c11 == 0) {
            return null;
        }
        int h11 = h(c11);
        byteBuffer.rewind();
        byteBuffer.limit((k(c11) * i12) + h11);
        byteBuffer.position(h11);
        return byteBuffer;
    }

    public int k(int i11) {
        int i12 = i11 + this.f35946a;
        return this.f35947b.getInt(i12 + this.f35947b.getInt(i12));
    }

    public int l(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    public void m(int[] iArr, final ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            numArr[i11] = Integer.valueOf(iArr[i11]);
        }
        Arrays.sort(numArr, new Comparator<Integer>() {
            public int compare(Integer num, Integer num2) {
                return Table.this.l(num, num2, byteBuffer);
            }
        });
        for (int i12 = 0; i12 < iArr.length; i12++) {
            iArr[i12] = numArr[i12].intValue();
        }
    }
}
