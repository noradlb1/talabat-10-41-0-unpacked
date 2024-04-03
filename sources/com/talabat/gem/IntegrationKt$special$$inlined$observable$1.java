package com.talabat.gem;

import com.talabat.gem.ports.data.DataSourcesPort;
import com.talabat.talabatcommon.extentions.RxKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "a", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
public final class IntegrationKt$special$$inlined$observable$1 extends ObservableProperty<DataSourcesPort> {
    public IntegrationKt$special$$inlined$observable$1(Object obj) {
        super(obj);
    }

    public void a(@NotNull KProperty<?> kProperty, DataSourcesPort dataSourcesPort, DataSourcesPort dataSourcesPort2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        DataSourcesPort dataSourcesPort3 = dataSourcesPort;
        RxKt.plusAssign(IntegrationKt.getDataSourcesObservable(), dataSourcesPort2);
    }
}
