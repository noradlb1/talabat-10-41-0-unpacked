package com.talabat.fluid.homescreen.ui.widget.orderstatus;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.homescreen.orderstatus.ui.OrderStatusView;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusDataMapper;", "Lkotlin/Function1;", "", "", "", "Lcom/talabat/homescreen/orderstatus/ui/OrderStatusView$OrderStatusData;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "dataType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "invoke", "data", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusDataMapper implements Function1<Map<String, ? extends String>, List<? extends OrderStatusView.OrderStatusData>> {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String KEY_ACTIVE_ORDERS_DATA = "active_orders";
    private final Type dataType = new OrderStatusDataMapper$dataType$1().getType();
    @NotNull
    private final Gson gson;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/fluid/homescreen/ui/widget/orderstatus/OrderStatusDataMapper$Companion;", "", "()V", "KEY_ACTIVE_ORDERS_DATA", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OrderStatusDataMapper(@NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    @NotNull
    public List<OrderStatusView.OrderStatusData> invoke(@NotNull Map<String, String> map) {
        List<OrderStatusView.OrderStatusData> list;
        Intrinsics.checkNotNullParameter(map, "data");
        String str = map.get(KEY_ACTIVE_ORDERS_DATA);
        if (str != null) {
            Gson gson2 = this.gson;
            Type type = this.dataType;
            list = (List) (!(gson2 instanceof Gson) ? gson2.fromJson(str, type) : GsonInstrumentation.fromJson(gson2, str, type));
        } else {
            list = null;
        }
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }
}
