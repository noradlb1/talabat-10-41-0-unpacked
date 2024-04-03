package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzado implements zzafc {
    private final List<zzab> zza;

    public zzado() {
        this(0);
    }

    private final zzaes zzb(zzafb zzafb) {
        return new zzaes(zzd(zzafb));
    }

    private final zzafg zzc(zzafb zzafb) {
        return new zzafg(zzd(zzafb));
    }

    private final List<zzab> zzd(zzafb zzafb) {
        String str;
        int i11;
        List list;
        zzfd zzfd = new zzfd(zzafb.zzd);
        List<zzab> list2 = this.zza;
        while (zzfd.zza() > 0) {
            int zzk = zzfd.zzk();
            int zzc = zzfd.zzc() + zzfd.zzk();
            if (zzk == 134) {
                list2 = new ArrayList<>();
                int zzk2 = zzfd.zzk() & 31;
                for (int i12 = 0; i12 < zzk2; i12++) {
                    String zzx = zzfd.zzx(3, zzfpt.zzc);
                    int zzk3 = zzfd.zzk();
                    int i13 = zzk3 & 128;
                    if (i13 != 0) {
                        i11 = zzk3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i11 = 1;
                    }
                    byte zzk4 = (byte) zzfd.zzk();
                    zzfd.zzG(1);
                    if (i13 != 0) {
                        int i14 = zzea.zza;
                        list = Collections.singletonList((zzk4 & SignedBytes.MAX_POWER_OF_TWO) != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzz zzz = new zzz();
                    zzz.zzS(str);
                    zzz.zzK(zzx);
                    zzz.zzu(i11);
                    zzz.zzI(list);
                    list2.add(zzz.zzY());
                }
            }
            zzfd.zzF(zzc);
        }
        return list2;
    }

    @Nullable
    public final zzafe zza(int i11, zzafb zzafb) {
        if (i11 != 2) {
            if (i11 == 3 || i11 == 4) {
                return new zzaei(new zzaef(zzafb.zzb));
            }
            if (i11 == 21) {
                return new zzaei(new zzaed());
            }
            if (i11 == 27) {
                return new zzaei(new zzaea(zzb(zzafb), false, false));
            }
            if (i11 == 36) {
                return new zzaei(new zzaec(zzb(zzafb)));
            }
            if (i11 == 89) {
                return new zzaei(new zzadq(zzafb.zzc));
            }
            if (i11 == 138) {
                return new zzaei(new zzadp(zzafb.zzb));
            }
            if (i11 == 172) {
                return new zzaei(new zzadk(zzafb.zzb));
            }
            if (i11 == 257) {
                return new zzaer(new zzaeh(MimeTypes.APPLICATION_AIT));
            }
            if (i11 != 128) {
                if (i11 != 129) {
                    if (i11 == 134) {
                        return new zzaer(new zzaeh(MimeTypes.APPLICATION_SCTE35));
                    }
                    if (i11 != 135) {
                        switch (i11) {
                            case 15:
                                return new zzaei(new zzadn(false, zzafb.zzb));
                            case 16:
                                return new zzaei(new zzadw(zzc(zzafb)));
                            case 17:
                                return new zzaei(new zzaee(zzafb.zzb));
                            default:
                                return null;
                        }
                    }
                }
                return new zzaei(new zzadh(zzafb.zzb));
            }
        }
        return new zzaei(new zzadt(zzc(zzafb)));
    }

    public zzado(int i11) {
        this.zza = zzfss.zzo();
    }
}
