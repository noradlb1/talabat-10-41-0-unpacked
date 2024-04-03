package rs;

import com.talabat.mapper.MappedValues;
import io.reactivex.functions.Consumer;
import java.util.Map;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MappedValues f62879b;

    public /* synthetic */ a(MappedValues mappedValues) {
        this.f62879b = mappedValues;
    }

    public final void accept(Object obj) {
        this.f62879b.lambda$new$0((Map.Entry) obj);
    }
}
