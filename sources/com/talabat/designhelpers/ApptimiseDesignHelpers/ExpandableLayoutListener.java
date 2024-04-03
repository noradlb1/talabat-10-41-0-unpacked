package com.talabat.designhelpers.ApptimiseDesignHelpers;

public interface ExpandableLayoutListener {
    void closing();

    void onAnimationEnd();

    void onAnimationStart();

    void onClosed();

    void onOpened();

    void onPreClose();

    void onPreOpen();
}
