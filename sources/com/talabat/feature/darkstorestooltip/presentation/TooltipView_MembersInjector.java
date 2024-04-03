package com.talabat.feature.darkstorestooltip.presentation;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
public final class TooltipView_MembersInjector implements MembersInjector<TooltipView> {
    private final Provider<TooltipViewController> tooltipViewControllerProvider;

    public TooltipView_MembersInjector(Provider<TooltipViewController> provider) {
        this.tooltipViewControllerProvider = provider;
    }

    public static MembersInjector<TooltipView> create(Provider<TooltipViewController> provider) {
        return new TooltipView_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.talabat.feature.darkstorestooltip.presentation.TooltipView.tooltipViewController")
    public static void injectTooltipViewController(TooltipView tooltipView, TooltipViewController tooltipViewController) {
        tooltipView.tooltipViewController = tooltipViewController;
    }

    public void injectMembers(TooltipView tooltipView) {
        injectTooltipViewController(tooltipView, this.tooltipViewControllerProvider.get());
    }
}
