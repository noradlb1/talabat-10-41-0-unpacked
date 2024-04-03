package l30;

import j$.util.function.Supplier;
import java.util.Collection;
import org.junit.platform.commons.util.CollectionUtils;

public final /* synthetic */ class f0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Collection f26473a;

    public /* synthetic */ f0(Collection collection) {
        this.f26473a = collection;
    }

    public final Object get() {
        return CollectionUtils.lambda$getOnlyElement$0(this.f26473a);
    }
}
