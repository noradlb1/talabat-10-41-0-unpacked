package com.deliveryhero.fluid.actions.listeners;

import com.deliveryhero.fluid.template.data.TemplateUiData;
import com.deliveryhero.fluid.widgets.collections.OnCollectionScrollListener;
import com.talabat.fluid.homescreen.data.parser.ComponentMapper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w4.a;
import w4.b;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/actions/listeners/InteractionListeners;", "", "()V", "click", "Lcom/deliveryhero/fluid/actions/listeners/OnClickListener;", "getClick", "()Lcom/deliveryhero/fluid/actions/listeners/OnClickListener;", "collectionScroll", "Lcom/deliveryhero/fluid/widgets/collections/OnCollectionScrollListener;", "getCollectionScroll", "()Lcom/deliveryhero/fluid/widgets/collections/OnCollectionScrollListener;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InteractionListeners {
    @NotNull
    private final OnClickListener click = new a();
    @NotNull
    private final OnCollectionScrollListener collectionScroll = new b();

    /* access modifiers changed from: private */
    /* renamed from: click$lambda-0  reason: not valid java name */
    public static final void m8178click$lambda0(String str, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(str, "url");
        System.out.println("Clicked: `" + str + "`; Data: `" + templateUiData + '`');
    }

    /* access modifiers changed from: private */
    /* renamed from: collectionScroll$lambda-1  reason: not valid java name */
    public static final void m8179collectionScroll$lambda1(int i11, List list, TemplateUiData templateUiData) {
        Intrinsics.checkNotNullParameter(list, ComponentMapper.CELLS);
        Intrinsics.checkNotNullParameter(templateUiData, "collectionData");
        System.out.println("Scrolled collection to: `" + i11 + "`; Cells: `" + list + "`; CollectionData: `" + templateUiData + '`');
    }

    @NotNull
    public OnClickListener getClick() {
        return this.click;
    }

    @NotNull
    public OnCollectionScrollListener getCollectionScroll() {
        return this.collectionScroll;
    }
}
