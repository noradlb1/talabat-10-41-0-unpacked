package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

final class zzakh implements Runnable {
    private zzakh() {
    }

    public /* synthetic */ zzakh(zzakg zzakg) {
    }

    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzaki.zzc = MessageDigest.getInstance("MD5");
            countDownLatch = zzaki.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzaki.zzb;
        } catch (Throwable th2) {
            zzaki.zzb.countDown();
            throw th2;
        }
        countDownLatch.countDown();
    }
}
