package com.braze.ui.inappmessage.views;

import com.braze.enums.inappmessage.CropType;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lcom/braze/ui/inappmessage/views/IInAppMessageImageView;", "", "setAspectRatio", "", "aspectRatio", "", "setCornersRadiiPx", "topLeft", "topRight", "bottomLeft", "bottomRight", "setCornersRadiusPx", "cornersRadius", "setInAppMessageImageCropType", "cropType", "Lcom/braze/enums/inappmessage/CropType;", "setToHalfParentHeight", "setToHalfHeight", "", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IInAppMessageImageView {
    void setAspectRatio(float f11);

    void setCornersRadiiPx(float f11, float f12, float f13, float f14);

    void setCornersRadiusPx(float f11);

    void setInAppMessageImageCropType(@Nullable CropType cropType);

    void setToHalfParentHeight(boolean z11);
}
