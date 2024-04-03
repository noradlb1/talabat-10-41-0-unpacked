package com.uxcam.datamodel;

import java.util.List;

public interface UXCamOcclusion {
    boolean getExcludeMentionedScreens();

    List getScreens();

    boolean isWithoutGesture();
}
