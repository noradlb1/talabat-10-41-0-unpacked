package com.braze.ui.inappmessage;

@Deprecated
public class InAppMessageCloser {
    private final IInAppMessageViewWrapper mInAppMessageViewWrapper;

    public InAppMessageCloser(IInAppMessageViewWrapper iInAppMessageViewWrapper) {
        this.mInAppMessageViewWrapper = iInAppMessageViewWrapper;
    }

    public void close(boolean z11) {
        this.mInAppMessageViewWrapper.getInAppMessage().setAnimateOut(z11);
        this.mInAppMessageViewWrapper.close();
    }
}
