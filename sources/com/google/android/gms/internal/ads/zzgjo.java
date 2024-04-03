package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

final class zzgjo implements zzgmg {
    private final zzgjn zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgjo(zzgjn zzgjn) {
        zzgkv.zzf(zzgjn, "input");
        this.zza = zzgjn;
        zzgjn.zzc = this;
    }

    private final <T> T zzP(zzgmo<T> zzgmo, zzgjx zzgjx) throws IOException {
        int i11 = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            T zze = zzgmo.zze();
            zzgmo.zzh(zze, this, zzgjx);
            zzgmo.zzf(zze);
            if (this.zzb == this.zzc) {
                return zze;
            }
            throw zzgkx.zzg();
        } finally {
            this.zzc = i11;
        }
    }

    private final <T> T zzQ(zzgmo<T> zzgmo, zzgjx zzgjx) throws IOException {
        int zzn = this.zza.zzn();
        zzgjn zzgjn = this.zza;
        if (zzgjn.zza < zzgjn.zzb) {
            int zze = zzgjn.zze(zzn);
            T zze2 = zzgmo.zze();
            this.zza.zza++;
            zzgmo.zzh(zze2, this, zzgjx);
            zzgmo.zzf(zze2);
            this.zza.zzz(0);
            zzgjn zzgjn2 = this.zza;
            zzgjn2.zza--;
            zzgjn2.zzA(zze);
            return zze2;
        }
        throw new zzgkx("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzR(int i11) throws IOException {
        if (this.zza.zzd() != i11) {
            throw zzgkx.zzj();
        }
    }

    private final void zzS(int i11) throws IOException {
        if ((this.zzb & 7) != i11) {
            throw zzgkx.zza();
        }
    }

    private static final void zzT(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw zzgkx.zzg();
        }
    }

    private static final void zzU(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw zzgkx.zzg();
        }
    }

    public static zzgjo zzq(zzgjn zzgjn) {
        zzgjo zzgjo = zzgjn.zzc;
        return zzgjo != null ? zzgjo : new zzgjo(zzgjn);
    }

    public final void zzA(List<Long> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzglk) {
            zzglk zzglk = (zzglk) list;
            int i11 = this.zzb & 7;
            if (i11 == 1) {
                do {
                    zzglk.zzg(this.zza.zzo());
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
                    zzglk.zzg(this.zza.zzo());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzB(List<Float> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgke) {
            zzgke zzgke = (zzgke) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgke.zze(this.zza.zzc());
                } while (this.zza.zzd() < zzd2);
            } else if (i11 == 5) {
                do {
                    zzgke.zze(this.zza.zzc());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final <T> void zzC(List<T> list, zzgmo<T> zzgmo, zzgjx zzgjx) throws IOException {
        int zzm;
        int i11 = this.zzb;
        if ((i11 & 7) == 3) {
            do {
                list.add(zzP(zzgmo, zzgjx));
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i11);
            this.zzd = zzm;
            return;
        }
        throw zzgkx.zza();
    }

    public final void zzD(List<Integer> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzgkm.zzh(this.zza.zzh());
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
                    zzgkm.zzh(this.zza.zzh());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzE(List<Long> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzglk) {
            zzglk zzglk = (zzglk) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzglk.zzg(this.zza.zzp());
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
                    zzglk.zzg(this.zza.zzp());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final <T> void zzF(List<T> list, zzgmo<T> zzgmo, zzgjx zzgjx) throws IOException {
        int zzm;
        int i11 = this.zzb;
        if ((i11 & 7) == 2) {
            do {
                list.add(zzQ(zzgmo, zzgjx));
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i11);
            this.zzd = zzm;
            return;
        }
        throw zzgkx.zza();
    }

    public final void zzG(List<Integer> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgkm.zzh(this.zza.zzk());
                } while (this.zza.zzd() < zzd2);
            } else if (i11 == 5) {
                do {
                    zzgkm.zzh(this.zza.zzk());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzH(List<Long> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzglk) {
            zzglk zzglk = (zzglk) list;
            int i11 = this.zzb & 7;
            if (i11 == 1) {
                do {
                    zzglk.zzg(this.zza.zzt());
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
                    zzglk.zzg(this.zza.zzt());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzI(List<Integer> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzgkm.zzh(this.zza.zzl());
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
                    zzgkm.zzh(this.zza.zzl());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzJ(List<Long> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzglk) {
            zzglk zzglk = (zzglk) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzglk.zzg(this.zza.zzu());
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
                    zzglk.zzg(this.zza.zzu());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzK(List<String> list, boolean z11) throws IOException {
        String str;
        int zzm;
        int zzm2;
        if ((this.zzb & 7) != 2) {
            throw zzgkx.zza();
        } else if ((list instanceof zzgld) && !z11) {
            zzgld zzgld = (zzgld) list;
            do {
                zzgld.zzi(zzp());
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
                    str = zzu();
                } else {
                    str = zzt();
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

    public final void zzL(List<Integer> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzgkm.zzh(this.zza.zzn());
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
                    zzgkm.zzh(this.zza.zzn());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzM(List<Long> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzglk) {
            zzglk zzglk = (zzglk) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzglk.zzg(this.zza.zzv());
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
                    zzglk.zzg(this.zza.zzv());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
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

    public final zzgjf zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    public final <T> T zzr(zzgmo<T> zzgmo, zzgjx zzgjx) throws IOException {
        zzS(3);
        return zzP(zzgmo, zzgjx);
    }

    public final <T> T zzs(zzgmo<T> zzgmo, zzgjx zzgjx) throws IOException {
        zzS(2);
        return zzQ(zzgmo, zzgjx);
    }

    public final String zzt() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    public final String zzu() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    public final void zzv(List<Boolean> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgis) {
            zzgis zzgis = (zzgis) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzgis.zze(this.zza.zzD());
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
                    zzgis.zze(this.zza.zzD());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzw(List<zzgjf> list) throws IOException {
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
        throw zzgkx.zza();
    }

    public final void zzx(List<Double> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgju) {
            zzgju zzgju = (zzgju) list;
            int i11 = this.zzb & 7;
            if (i11 == 1) {
                do {
                    zzgju.zze(this.zza.zzb());
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
                    zzgju.zze(this.zza.zzb());
                } while (this.zza.zzd() < zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzy(List<Integer> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            int i11 = this.zzb & 7;
            if (i11 == 0) {
                do {
                    zzgkm.zzh(this.zza.zzf());
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
                    zzgkm.zzh(this.zza.zzf());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }

    public final void zzz(List<Integer> list) throws IOException {
        int zzm;
        int zzm2;
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            int i11 = this.zzb & 7;
            if (i11 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzgkm.zzh(this.zza.zzg());
                } while (this.zza.zzd() < zzd2);
            } else if (i11 == 5) {
                do {
                    zzgkm.zzh(this.zza.zzg());
                    if (!this.zza.zzC()) {
                        zzm2 = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm2 == this.zzb);
                this.zzd = zzm2;
            } else {
                throw zzgkx.zza();
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
                throw zzgkx.zza();
            }
        }
    }
}
