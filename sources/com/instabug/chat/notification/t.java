package com.instabug.chat.notification;

import android.media.MediaPlayer;

class t implements MediaPlayer.OnCompletionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaPlayer f46137b;

    public t(v vVar, MediaPlayer mediaPlayer) {
        this.f46137b = mediaPlayer;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f46137b.release();
    }
}
