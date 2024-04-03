package com.talabat.helpcenter.presentation.webview;

import com.talabat.helpcenter.di.HelpCenterFactory;
import com.talabat.helpcenter.presentation.viewModel.GlobalHelpCenterViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/helpcenter/presentation/viewModel/GlobalHelpCenterViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterWebViewActivity$viewModel$2 extends Lambda implements Function0<GlobalHelpCenterViewModel> {
    public static final GlobalHelpCenterWebViewActivity$viewModel$2 INSTANCE = new GlobalHelpCenterWebViewActivity$viewModel$2();

    public GlobalHelpCenterWebViewActivity$viewModel$2() {
        super(0);
    }

    @NotNull
    public final GlobalHelpCenterViewModel invoke() {
        return HelpCenterFactory.INSTANCE.getGlobalHelpCenterViewModel();
    }
}
