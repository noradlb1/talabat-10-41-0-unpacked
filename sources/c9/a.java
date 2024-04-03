package c9;

import com.google.common.base.Function;
import com.google.common.escape.Escaper;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Escaper f44499b;

    public /* synthetic */ a(Escaper escaper) {
        this.f44499b = escaper;
    }

    public final Object apply(Object obj) {
        return this.f44499b.escape((String) obj);
    }
}
