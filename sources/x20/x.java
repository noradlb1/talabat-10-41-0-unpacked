package x20;

import j$.util.function.Supplier;
import org.junit.jupiter.api.DisplayNameGenerator;

public final /* synthetic */ class x implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f57974a;

    public /* synthetic */ x(Class cls) {
        this.f57974a = cls;
    }

    public final Object get() {
        return DisplayNameGenerator.IndicativeSentences.getGeneratorFor(this.f57974a).generateDisplayNameForNestedClass(this.f57974a);
    }
}
