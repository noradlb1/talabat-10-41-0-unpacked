package c7;

import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.login.widget.ProfilePictureView;

public final /* synthetic */ class g implements ImageRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfilePictureView f29373a;

    public /* synthetic */ g(ProfilePictureView profilePictureView) {
        this.f29373a = profilePictureView;
    }

    public final void onCompleted(ImageResponse imageResponse) {
        ProfilePictureView.m9008sendImageRequest$lambda2(this.f29373a, imageResponse);
    }
}
