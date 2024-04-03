package j$.time.temporal;

public final /* synthetic */ class o implements n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28465a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f28466b;

    public /* synthetic */ o(int i11, int i12) {
        this.f28465a = i12;
        this.f28466b = i11;
    }

    public final l k(l lVar) {
        int i11 = this.f28465a;
        int i12 = this.f28466b;
        switch (i11) {
            case 0:
                int f11 = lVar.f(a.DAY_OF_WEEK);
                if (f11 == i12) {
                    return lVar;
                }
                int i13 = f11 - i12;
                return lVar.b((long) (i13 >= 0 ? 7 - i13 : -i13), ChronoUnit.DAYS);
            default:
                int f12 = lVar.f(a.DAY_OF_WEEK);
                if (f12 == i12) {
                    return lVar;
                }
                int i14 = i12 - f12;
                return lVar.d((long) (i14 >= 0 ? 7 - i14 : -i14), ChronoUnit.DAYS);
        }
    }
}
