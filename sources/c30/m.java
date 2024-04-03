package c30;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.config.EnumConfigurationParameterConverter;

public final /* synthetic */ class m implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnumConfigurationParameterConverter f58205a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58207c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Enum f58208d;

    public /* synthetic */ m(EnumConfigurationParameterConverter enumConfigurationParameterConverter, String str, String str2, Enum enumR) {
        this.f58205a = enumConfigurationParameterConverter;
        this.f58206b = str;
        this.f58207c = str2;
        this.f58208d = enumR;
    }

    public final Object get() {
        return this.f58205a.lambda$get$1(this.f58206b, this.f58207c, this.f58208d);
    }
}
