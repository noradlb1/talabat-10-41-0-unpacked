package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagc  reason: invalid package */
final class zzagc implements zzaiq {
    private final zzagb zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzagc(zzagb zzagb) {
        byte[] bArr = zzahg.zzd;
        this.zza = zzagb;
        zzagb.zzc = this;
    }

    private final void zzP(Object obj, zzair zzair, zzagn zzagn) throws IOException {
        int i11 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzair.zzh(obj, this, zzagn);
            if (this.zzb != this.zzc) {
                throw zzahi.zzg();
            }
        } finally {
            this.zzc = i11;
        }
    }

    private final void zzQ(Object obj, zzair zzair, zzagn zzagn) throws IOException {
        int zzn = this.zza.zzn();
        zzagb zzagb = this.zza;
        if (zzagb.zza < zzagb.zzb) {
            int zze = zzagb.zze(zzn);
            this.zza.zza++;
            zzair.zzh(obj, this, zzagn);
            this.zza.zzz(0);
            zzagb zzagb2 = this.zza;
            zzagb2.zza--;
            zzagb2.zzA(zze);
            return;
        }
        throw new zzahi("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzR(int i11) throws IOException {
        if (this.zza.zzd() != i11) {
            throw zzahi.zzj();
        }
    }

    private final void zzS(int i11) throws IOException {
        if ((this.zzb & 7) != i11) {
            throw zzahi.zza();
        }
    }

    private static final void zzT(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw zzahi.zzg();
        }
    }

    private static final void zzU(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw zzahi.zzg();
        }
    }

    public static zzagc zzq(zzagb zzagb) {
        zzagc zzagc = zzagb.zzc;
        return zzagc != null ? zzagc : new zzagc(zzagb);
    }

    public final void zzA(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahu) {
            zzahu zzahu = (zzahu) list;
            int i11 = this.zzb & 7;
            if (i11 == 1) {
                do {
                    zzahu.zzf(this.zza.zzo());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzahu.zzf(this.zza.zzo());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzB(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagu) {
            zzagu zzagu = (zzagu) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzagu.zze(this.zza.zzc());
                } while (this.zza.zzd() < zzd2);
            } else if (i11 == 5) {
                do {
                    zzagu.zze(this.zza.zzc());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd3);
            } else if (i12 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzahi.zza();
            }
        }
    }

    @Deprecated
    public final void zzC(List list, zzair zzair, zzagn zzagn) throws IOException {
        int zzm;
        int i11 = this.zzb;
        if ((i11 & 7) == 3) {
            do {
                Object zze = zzair.zze();
                zzP(zze, zzair, zzagn);
                zzair.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i11);
            this.zzd = zzm;
            return;
        }
        throw zzahi.zza();
    }

    public final void zzD(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzahb.zzf(this.zza.zzh());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahb.zzf(this.zza.zzh());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzE(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahu) {
            zzahu zzahu = (zzahu) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzahu.zzf(this.zza.zzp());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahu.zzf(this.zza.zzp());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzF(List list, zzair zzair, zzagn zzagn) throws IOException {
        int zzm;
        int i11 = this.zzb;
        if ((i11 & 7) == 2) {
            do {
                Object zze = zzair.zze();
                zzQ(zze, zzair, zzagn);
                zzair.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i11);
            this.zzd = zzm;
            return;
        }
        throw zzahi.zza();
    }

    public final void zzG(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzahb.zzf(this.zza.zzk());
                } while (this.zza.zzd() < zzd2);
            } else if (i11 == 5) {
                do {
                    zzahb.zzf(this.zza.zzk());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd3);
            } else if (i12 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzH(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahu) {
            zzahu zzahu = (zzahu) list;
            int i11 = this.zzb & 7;
            if (i11 == 1) {
                do {
                    zzahu.zzf(this.zza.zzt());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzahu.zzf(this.zza.zzt());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzI(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzahb.zzf(this.zza.zzl());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahb.zzf(this.zza.zzl());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzJ(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahu) {
            zzahu zzahu = (zzahu) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzahu.zzf(this.zza.zzu());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahu.zzf(this.zza.zzu());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzK(List list, boolean z11) throws IOException {
        String str;
        int zzm;
        int zzm2;
        if ((this.zzb & 7) != 2) {
            throw zzahi.zza();
        } else if ((list instanceof zzahn) && !z11) {
            zzahn zzahn = (zzahn) list;
            do {
                zzahn.zzi(zzp());
                if (!this.zza.zzC()) {
                    zzm2 = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm2 == this.zzb);
            this.zzd = zzm2;
        } else {
            do {
                if (z11) {
                    str = zzs();
                } else {
                    str = zzr();
                }
                list.add(str);
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
        }
    }

    public final void zzL(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzahb.zzf(this.zza.zzn());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahb.zzf(this.zza.zzn());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzM(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahu) {
            zzahu zzahu = (zzahu) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzahu.zzf(this.zza.zzv());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahu.zzf(this.zza.zzv());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    public final boolean zzO() throws IOException {
        int i11;
        if (this.zza.zzC() || (i11 = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i11);
    }

    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    public final int zzc() throws IOException {
        int i11 = this.zzd;
        if (i11 != 0) {
            this.zzb = i11;
            this.zzd = 0;
        } else {
            i11 = this.zza.zzm();
            this.zzb = i11;
        }
        if (i11 == 0 || i11 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i11 >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    public final zzafv zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    public final void zzt(Object obj, zzair zzair, zzagn zzagn) throws IOException {
        zzS(3);
        zzP(obj, zzair, zzagn);
    }

    public final void zzu(Object obj, zzair zzair, zzagn zzagn) throws IOException {
        zzS(2);
        zzQ(obj, zzair, zzagn);
    }

    public final void zzv(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzafk) {
            zzafk zzafk = (zzafk) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzafk.zze(this.zza.zzD());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzafk.zze(this.zza.zzD());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        throw zzahi.zza();
    }

    public final void zzx(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzagk) {
            zzagk zzagk = (zzagk) list;
            int i11 = this.zzb & 7;
            if (i11 == 1) {
                do {
                    zzagk.zze(this.zza.zzb());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzagk.zze(this.zza.zzb());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzy(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzahb.zzf(this.zza.zzf());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else if (i11 == 2) {
                int zzd2 = this.zza.zzd() + this.zza.zzn();
                do {
                    zzahb.zzf(this.zza.zzf());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else if (i12 == 2) {
                int zzd3 = this.zza.zzd() + this.zza.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
            } else {
                throw zzahi.zza();
            }
        }
    }

    public final void zzz(List list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzahb.zzf(this.zza.zzg());
                } while (this.zza.zzd() < zzd2);
            } else if (i11 == 5) {
                do {
                    zzahb.zzf(this.zza.zzg());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzahi.zza();
            }
        } else {
            int i12 = this.zzb & 7;
            if (i12 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd3);
            } else if (i12 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                this.zzd = zzm;
            } else {
                throw zzahi.zza();
            }
        }
    }
}
