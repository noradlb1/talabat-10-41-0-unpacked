package xu;

import android.media.MediaPlayer;
import com.talabat.splash.presentation.ui.WelcomeVideoFragment;

public final /* synthetic */ class m implements MediaPlayer.OnCompletionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WelcomeVideoFragment f63053b;

    public /* synthetic */ m(WelcomeVideoFragment welcomeVideoFragment) {
        this.f63053b = welcomeVideoFragment;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        WelcomeVideoFragment.m10925playWelcomeVideo$lambda3(this.f63053b, mediaPlayer);
    }
}
