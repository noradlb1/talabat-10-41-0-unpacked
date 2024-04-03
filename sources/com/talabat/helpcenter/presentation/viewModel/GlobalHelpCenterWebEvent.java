package com.talabat.helpcenter.presentation.viewModel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent;", "", "()V", "HelpCenterClosed", "HelpCenterStarted", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent$HelpCenterStarted;", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent$HelpCenterClosed;", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class GlobalHelpCenterWebEvent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent$HelpCenterClosed;", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent;", "()V", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HelpCenterClosed extends GlobalHelpCenterWebEvent {
        @NotNull
        public static final HelpCenterClosed INSTANCE = new HelpCenterClosed();

        private HelpCenterClosed() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent$HelpCenterStarted;", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterWebEvent;", "()V", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HelpCenterStarted extends GlobalHelpCenterWebEvent {
        @NotNull
        public static final HelpCenterStarted INSTANCE = new HelpCenterStarted();

        private HelpCenterStarted() {
            super((DefaultConstructorMarker) null);
        }
    }

    private GlobalHelpCenterWebEvent() {
    }

    public /* synthetic */ GlobalHelpCenterWebEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
