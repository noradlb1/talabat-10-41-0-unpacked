package c30;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.config.EnumConfigurationParameterConverter;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnumConfigurationParameterConverter f58202a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Enum f58203b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58204c;

    public /* synthetic */ l(EnumConfigurationParameterConverter enumConfigurationParameterConverter, Enum enumR, String str) {
        this.f58202a = enumConfigurationParameterConverter;
        this.f58203b = enumR;
        this.f58204c = str;
    }

    public final Object get() {
        return this.f58202a.lambda$get$0(this.f58203b, this.f58204c);
    }
}
