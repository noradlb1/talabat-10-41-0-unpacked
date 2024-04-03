package xu;

import android.media.MediaPlayer;
import com.talabat.splash.presentation.ui.WelcomeVideoFragment;

public final /* synthetic */ class l implements MediaPlayer.OnPreparedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WelcomeVideoFragment f63052b;

    public /* synthetic */ l(WelcomeVideoFragment welcomeVideoFragment) {
        this.f63052b = welcomeVideoFragment;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        WelcomeVideoFragment.m10924playWelcomeVideo$lambda2(this.f63052b, mediaPlayer);
    }
}
