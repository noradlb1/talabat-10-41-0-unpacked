package zr;

import com.talabat.helpers.EntityUpdater;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Field;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EntityUpdater f63099b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f63100c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f63101d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f63102e;

    public /* synthetic */ a(EntityUpdater entityUpdater, Object obj, Object obj2, Object obj3) {
        this.f63099b = entityUpdater;
        this.f63100c = obj;
        this.f63101d = obj2;
        this.f63102e = obj3;
    }

    public final void accept(Object obj) {
        this.f63099b.lambda$apply$0(this.f63100c, this.f63101d, this.f63102e, (Field) obj);
    }
}
