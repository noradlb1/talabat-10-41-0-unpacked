package net.bytebuddy.jar.asm;

abstract class Symbol {

    /* renamed from: a  reason: collision with root package name */
    public final int f27406a;

    /* renamed from: b  reason: collision with root package name */
    public final int f27407b;

    /* renamed from: c  reason: collision with root package name */
    public final String f27408c;

    /* renamed from: d  reason: collision with root package name */
    public final String f27409d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27410e;

    /* renamed from: f  reason: collision with root package name */
    public final long f27411f;

    /* renamed from: g  reason: collision with root package name */
    public int f27412g;

    public Symbol(int i11, int i12, String str, String str2, String str3, long j11) {
        this.f27406a = i11;
        this.f27407b = i12;
        this.f27408c = str;
        this.f27409d = str2;
        this.f27410e = str3;
        this.f27411f = j11;
    }

    public int a() {
        if (this.f27412g == 0) {
            this.f27412g = Type.getArgumentsAndReturnSizes(this.f27410e);
        }
        return this.f27412g;
    }
}
