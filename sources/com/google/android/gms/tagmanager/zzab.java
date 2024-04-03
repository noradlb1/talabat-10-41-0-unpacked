package com.google.android.gms.tagmanager;

final class zzab implements zzac {
    private final /* synthetic */ zzy zzafg;
    private Long zzafh;
    private final /* synthetic */ boolean zzafi;

    public zzab(zzy zzy, boolean z11) {
        this.zzafg = zzy;
        this.zzafi = z11;
    }

    public final boolean zzb(Container container) {
        if (this.zzafi) {
            long lastRefreshTime = container.getLastRefreshTime();
            if (this.zzafh == null) {
                this.zzafh = Long.valueOf(this.zzafg.zzaex.zzhl());
            }
            if (lastRefreshTime + this.zzafh.longValue() >= this.zzafg.zzsd.currentTimeMillis()) {
                return true;
            }
            return false;
        } else if (!container.isDefault()) {
            return true;
        } else {
            return false;
        }
    }
}
