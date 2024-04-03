package com.deliveryhero.fluid.template.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fR(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder;", "", "()V", "newData", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "data", "getData", "()Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "setData", "(Lcom/deliveryhero/fluid/template/data/TemplateUiData;)V", "observers", "", "Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder$Observer;", "observe", "", "observer", "Observer", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateUiDataHolder {
    @Nullable
    private TemplateUiData data;
    @NotNull
    private final List<Observer> observers = new ArrayList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/template/data/TemplateUiDataHolder$Observer;", "", "onChanged", "", "data", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Observer {
        void onChanged(@Nullable TemplateUiData templateUiData);
    }

    @Nullable
    public final TemplateUiData getData() {
        return this.data;
    }

    public final void observe(@NotNull Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.observers.add(observer);
        observer.onChanged(this.data);
    }

    public final void setData(@Nullable TemplateUiData templateUiData) {
        if (!Intrinsics.areEqual((Object) this.data, (Object) templateUiData)) {
            this.data = templateUiData;
            for (Observer onChanged : this.observers) {
                onChanged.onChanged(templateUiData);
            }
        }
    }
}
