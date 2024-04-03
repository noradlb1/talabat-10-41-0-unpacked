package com.talabat.designhelpers.expandableLayoutHelpers;

public interface ExpandableLayoutListener {
    void onAnimationEnd();

    void onAnimationStart();

    void onClosed();

    void onOpened();

    void onPreClose();

    void onPreOpen();
}
