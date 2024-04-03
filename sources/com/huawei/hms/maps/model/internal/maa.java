package com.huawei.hms.maps.model.internal;

import android.os.IInterface;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public interface maa extends IInterface {
    String getId();

    IObjectWrapper getTag();

    float getZIndex();

    int hashCodeRemote();

    boolean isClickable();

    boolean isVisible();

    void remove();

    void setClickable(boolean z11);

    void setTag(IObjectWrapper iObjectWrapper);

    void setVisible(boolean z11);

    void setZIndex(float f11);
}
