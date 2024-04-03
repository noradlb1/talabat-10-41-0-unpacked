package androidx.datastore.preferences.protobuf;

import java.io.IOException;

class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    /* renamed from: A */
    public UnknownFieldSetLite g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* renamed from: B */
    public int h(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    /* renamed from: C */
    public int i(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }

    /* renamed from: D */
    public UnknownFieldSetLite k(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        if (unknownFieldSetLite2.equals(UnknownFieldSetLite.getDefaultInstance())) {
            return unknownFieldSetLite;
        }
        return UnknownFieldSetLite.e(unknownFieldSetLite, unknownFieldSetLite2);
    }

    /* renamed from: E */
    public UnknownFieldSetLite n() {
        return UnknownFieldSetLite.f();
    }

    /* renamed from: F */
    public void o(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        p(obj, unknownFieldSetLite);
    }

    /* renamed from: G */
    public void p(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* renamed from: H */
    public UnknownFieldSetLite r(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    /* renamed from: I */
    public void s(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.i(writer);
    }

    /* renamed from: J */
    public void t(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.writeTo(writer);
    }

    public void j(Object obj) {
        g(obj).makeImmutable();
    }

    public boolean q(Reader reader) {
        return false;
    }

    /* renamed from: u */
    public void a(UnknownFieldSetLite unknownFieldSetLite, int i11, int i12) {
        unknownFieldSetLite.h(WireFormat.a(i11, 5), Integer.valueOf(i12));
    }

    /* renamed from: v */
    public void b(UnknownFieldSetLite unknownFieldSetLite, int i11, long j11) {
        unknownFieldSetLite.h(WireFormat.a(i11, 1), Long.valueOf(j11));
    }

    /* renamed from: w */
    public void c(UnknownFieldSetLite unknownFieldSetLite, int i11, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.h(WireFormat.a(i11, 3), unknownFieldSetLite2);
    }

    /* renamed from: x */
    public void d(UnknownFieldSetLite unknownFieldSetLite, int i11, ByteString byteString) {
        unknownFieldSetLite.h(WireFormat.a(i11, 2), byteString);
    }

    /* renamed from: y */
    public void e(UnknownFieldSetLite unknownFieldSetLite, int i11, long j11) {
        unknownFieldSetLite.h(WireFormat.a(i11, 0), Long.valueOf(j11));
    }

    /* renamed from: z */
    public UnknownFieldSetLite f(Object obj) {
        UnknownFieldSetLite A = g(obj);
        if (A != UnknownFieldSetLite.getDefaultInstance()) {
            return A;
        }
        UnknownFieldSetLite f11 = UnknownFieldSetLite.f();
        p(obj, f11);
        return f11;
    }
}
