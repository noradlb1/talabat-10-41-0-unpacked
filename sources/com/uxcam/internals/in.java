package com.uxcam.internals;

import java.nio.ByteBuffer;
import java.util.HashMap;

public class in extends ff {

    /* renamed from: d  reason: collision with root package name */
    public short f13649d;

    /* renamed from: e  reason: collision with root package name */
    public short f13650e;

    /* renamed from: f  reason: collision with root package name */
    public String f13651f;

    /* renamed from: g  reason: collision with root package name */
    public int f13652g;

    /* renamed from: h  reason: collision with root package name */
    public int f13653h;

    /* renamed from: i  reason: collision with root package name */
    public short f13654i;

    /* renamed from: j  reason: collision with root package name */
    public short f13655j;

    /* renamed from: k  reason: collision with root package name */
    public float f13656k;

    /* renamed from: l  reason: collision with root package name */
    public float f13657l;

    /* renamed from: m  reason: collision with root package name */
    public short f13658m;

    /* renamed from: n  reason: collision with root package name */
    public String f13659n;

    /* renamed from: o  reason: collision with root package name */
    public short f13660o;

    /* renamed from: p  reason: collision with root package name */
    public short f13661p;

    public static class aa extends an {
        public aa() {
            HashMap hashMap = new HashMap();
            hashMap.put("pasp", el.class);
            hashMap.put("colr", bb.class);
            hashMap.put("gama", co.class);
            hashMap.put("clap", aw.class);
            hashMap.put("fiel", bw.class);
        }
    }

    static {
        new aa();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public in(da daVar, short s11, short s12, String str, int i11, int i12, short s13, short s14, long j11, long j12, short s15, String str2, short s16, short s17, short s18) {
        super(daVar, s17);
        da daVar2 = daVar;
        this.f13649d = s11;
        this.f13650e = s12;
        this.f13651f = str;
        this.f13652g = i11;
        this.f13653h = i12;
        this.f13654i = s13;
        this.f13655j = s14;
        this.f13656k = (float) j11;
        this.f13657l = (float) j12;
        this.f13658m = s15;
        this.f13659n = str2;
        this.f13660o = s16;
        this.f13661p = s18;
    }

    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putShort(this.f13649d);
        byteBuffer.putShort(this.f13650e);
        byteBuffer.put(dh.a(this.f13651f), 0, 4);
        byteBuffer.putInt(this.f13652g);
        byteBuffer.putInt(this.f13653h);
        byteBuffer.putShort(this.f13654i);
        byteBuffer.putShort(this.f13655j);
        byteBuffer.putInt((int) (this.f13656k * 65536.0f));
        byteBuffer.putInt((int) (this.f13657l * 65536.0f));
        byteBuffer.putInt(0);
        byteBuffer.putShort(this.f13658m);
        eb.a(byteBuffer, this.f13659n, 31);
        byteBuffer.putShort(this.f13660o);
        byteBuffer.putShort(this.f13661p);
        c(byteBuffer);
    }

    public void a(StringBuilder sb2) {
        sb2.append(this.f13001a.f13186a + ": {\n");
        sb2.append("entry: ");
        hc.a(this, sb2, "version", "revision", "vendor", "temporalQual", "spacialQual", "width", "height", "hRes", "vRes", "frameCount", "compressorName", "depth", "clrTbl");
        sb2.append(",\nexts: [\n");
        b(sb2);
        sb2.append("\n]\n");
        sb2.append("}\n");
    }
}
