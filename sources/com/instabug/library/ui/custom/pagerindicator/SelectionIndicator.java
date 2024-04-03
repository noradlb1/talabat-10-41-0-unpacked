package com.instabug.library.ui.custom.pagerindicator;

public interface SelectionIndicator {
    int getNumberOfItems();

    int getSelectedItemIndex();

    int getTransitionDuration();

    boolean isVisible();

    void setNumberOfItems(int i11);

    void setSelectedItem(int i11, boolean z11);

    void setTransitionDuration(int i11);

    void setVisibility(boolean z11);
}
