package com.talabat.helpcenter.presentation.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.helpcenter.presentation.model.GlobalHelpCenterMessageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/helpcenter/presentation/mapper/GlobalHelpCenterMapper;", "", "()V", "gson", "Lcom/google/gson/Gson;", "convertMessageToGlobalHelpCenterObject", "Lcom/talabat/helpcenter/presentation/model/GlobalHelpCenterMessageModel;", "message", "", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterMapper {
    @NotNull
    public static final GlobalHelpCenterMapper INSTANCE = new GlobalHelpCenterMapper();
    @NotNull
    private static Gson gson = new Gson();

    private GlobalHelpCenterMapper() {
    }

    @Nullable
    public final GlobalHelpCenterMessageModel convertMessageToGlobalHelpCenterObject(@NotNull String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "message");
        try {
            Gson gson2 = gson;
            Class cls = GlobalHelpCenterMessageModel.class;
            if (!(gson2 instanceof Gson)) {
                obj = gson2.fromJson(str, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson2, str, cls);
            }
            return (GlobalHelpCenterMessageModel) obj;
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }
}
