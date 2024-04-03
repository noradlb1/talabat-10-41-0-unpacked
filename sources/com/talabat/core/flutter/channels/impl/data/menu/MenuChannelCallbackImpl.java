package com.talabat.core.flutter.channels.impl.data.menu;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.core.flutter.channels.domain.menu.MenuChannelCallback;
import com.talabat.core.flutter.channels.impl.data.menu.dto.UpdateVendorMenuCallArguments;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.GsonKt;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/menu/MenuChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/menu/MenuChannelCallback;", "()V", "updateVendorMenu", "", "arguments", "", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MenuChannelCallbackImpl implements MenuChannelCallback {
    public void updateVendorMenu(@Nullable Object obj) {
        Object obj2;
        Gson gson = GsonKt.getGson();
        String json$default = GsonKt.toJson$default(obj, (Gson) null, 1, (Object) null);
        Class cls = UpdateVendorMenuCallArguments.class;
        if (!(gson instanceof Gson)) {
            obj2 = gson.fromJson(json$default, cls);
        } else {
            obj2 = GsonInstrumentation.fromJson(gson, json$default, cls);
        }
        GlobalDataModel.JSON.menuItemsResponseModel = ((UpdateVendorMenuCallArguments) obj2).getResult();
    }
}
