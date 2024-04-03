package o30;

import j$.util.function.BiConsumer;
import org.junit.platform.engine.reporting.ReportEntry;

public final /* synthetic */ class a implements BiConsumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReportEntry f27523b;

    public /* synthetic */ a(ReportEntry reportEntry) {
        this.f27523b = reportEntry;
    }

    public final void accept(Object obj, Object obj2) {
        this.f27523b.add((String) obj, (String) obj2);
    }

    public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return BiConsumer.CC.$default$andThen(this, biConsumer);
    }
}
