package com.talabat.darkstores.model.viewstate;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/model/viewstate/TproBannerViewState;", "", "()V", "Hidden", "Shown", "Lcom/talabat/darkstores/model/viewstate/TproBannerViewState$Shown;", "Lcom/talabat/darkstores/model/viewstate/TproBannerViewState$Hidden;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TproBannerViewState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/model/viewstate/TproBannerViewState$Hidden;", "Lcom/talabat/darkstores/model/viewstate/TproBannerViewState;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends TproBannerViewState {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/model/viewstate/TproBannerViewState$Shown;", "Lcom/talabat/darkstores/model/viewstate/TproBannerViewState;", "showSubscribeButton", "", "(Z)V", "getShowSubscribeButton", "()Z", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Shown extends TproBannerViewState {
        private final boolean showSubscribeButton;

        public Shown(boolean z11) {
            super((DefaultConstructorMarker) null);
            this.showSubscribeButton = z11;
        }

        public final boolean getShowSubscribeButton() {
            return this.showSubscribeButton;
        }
    }

    private TproBannerViewState() {
    }

    public /* synthetic */ TproBannerViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
