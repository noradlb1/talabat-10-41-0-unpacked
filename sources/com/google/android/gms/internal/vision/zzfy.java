package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;

final class zzfy implements zzis {
    private int tag;
    private int zzrw;
    private final zzft zzsp;
    private int zzsq = 0;

    private zzfy(zzft zzft) {
        zzft zzft2 = (zzft) zzgt.zza(zzft, "input");
        this.zzsp = zzft2;
        zzft2.zzsi = this;
    }

    public static zzfy zza(zzft zzft) {
        zzfy zzfy = zzft.zzsi;
        if (zzfy != null) {
            return zzfy;
        }
        return new zzfy(zzft);
    }

    private final void zzaj(int i11) throws IOException {
        if ((this.tag & 7) != i11) {
            throw zzhc.zzgr();
        }
    }

    private static void zzak(int i11) throws IOException {
        if ((i11 & 7) != 0) {
            throw zzhc.zzgs();
        }
    }

    private static void zzal(int i11) throws IOException {
        if ((i11 & 3) != 0) {
            throw zzhc.zzgs();
        }
    }

    private final void zzam(int i11) throws IOException {
        if (this.zzsp.zzez() != i11) {
            throw zzhc.zzgm();
        }
    }

    private final <T> T zzd(zzir<T> zzir, zzgd zzgd) throws IOException {
        int i11 = this.zzrw;
        this.zzrw = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzir.newInstance();
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            if (this.tag == this.zzrw) {
                return newInstance;
            }
            throw zzhc.zzgs();
        } finally {
            this.zzrw = i11;
        }
    }

    public final int getTag() {
        return this.tag;
    }

    public final double readDouble() throws IOException {
        zzaj(1);
        return this.zzsp.readDouble();
    }

    public final float readFloat() throws IOException {
        zzaj(5);
        return this.zzsp.readFloat();
    }

    public final String readString() throws IOException {
        zzaj(2);
        return this.zzsp.readString();
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final <T> T zzb(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzin.zzho().zzf(cls), zzgd);
    }

    public final <T> T zzc(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzir, zzgd);
    }

    public final int zzdu() throws IOException {
        int i11 = this.zzsq;
        if (i11 != 0) {
            this.tag = i11;
            this.zzsq = 0;
        } else {
            this.tag = this.zzsp.zzex();
        }
        int i12 = this.tag;
        if (i12 == 0 || i12 == this.zzrw) {
            return Integer.MAX_VALUE;
        }
        return i12 >>> 3;
    }

    public final boolean zzdv() throws IOException {
        int i11;
        if (this.zzsp.zzdt() || (i11 = this.tag) == this.zzrw) {
            return false;
        }
        return this.zzsp.zzar(i11);
    }

    public final long zzdw() throws IOException {
        zzaj(0);
        return this.zzsp.zzdw();
    }

    public final long zzdx() throws IOException {
        zzaj(0);
        return this.zzsp.zzdx();
    }

    public final int zzdy() throws IOException {
        zzaj(0);
        return this.zzsp.zzdy();
    }

    public final long zzdz() throws IOException {
        zzaj(1);
        return this.zzsp.zzdz();
    }

    public final void zze(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i11 = this.tag & 7;
            if (i11 == 0) {
                do {
                    zzgu.zzbl(this.zzsp.zzdy());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzgu.zzbl(this.zzsp.zzdy());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzdy()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzdy()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final int zzea() throws IOException {
        zzaj(5);
        return this.zzsp.zzea();
    }

    public final boolean zzeb() throws IOException {
        zzaj(0);
        return this.zzsp.zzeb();
    }

    public final String zzec() throws IOException {
        zzaj(2);
        return this.zzsp.zzec();
    }

    public final zzfh zzed() throws IOException {
        zzaj(2);
        return this.zzsp.zzed();
    }

    public final int zzee() throws IOException {
        zzaj(0);
        return this.zzsp.zzee();
    }

    public final int zzef() throws IOException {
        zzaj(0);
        return this.zzsp.zzef();
    }

    public final int zzeg() throws IOException {
        zzaj(5);
        return this.zzsp.zzeg();
    }

    public final long zzeh() throws IOException {
        zzaj(1);
        return this.zzsp.zzeh();
    }

    public final int zzei() throws IOException {
        zzaj(0);
        return this.zzsp.zzei();
    }

    public final long zzej() throws IOException {
        zzaj(0);
        return this.zzsp.zzej();
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i11 = this.tag & 7;
            if (i11 == 1) {
                do {
                    zzhq.zzac(this.zzsp.zzdz());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzee = this.zzsp.zzee();
                zzak(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzhq.zzac(this.zzsp.zzdz());
                } while (this.zzsp.zzez() < zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 1) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzdz()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzak(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Long.valueOf(this.zzsp.zzdz()));
                } while (this.zzsp.zzez() < zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i11 = this.tag & 7;
            if (i11 == 2) {
                int zzee = this.zzsp.zzee();
                zzal(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzgu.zzbl(this.zzsp.zzea());
                } while (this.zzsp.zzez() < zzez);
            } else if (i11 == 5) {
                do {
                    zzgu.zzbl(this.zzsp.zzea());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzal(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Integer.valueOf(this.zzsp.zzea()));
                } while (this.zzsp.zzez() < zzez2);
            } else if (i12 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzea()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            int i11 = this.tag & 7;
            if (i11 == 0) {
                do {
                    zzff.addBoolean(this.zzsp.zzeb());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzff.addBoolean(this.zzsp.zzeb());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzsp.zzeb()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Boolean.valueOf(this.zzsp.zzeb()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzj(List<zzfh> list) throws IOException {
        int zzex;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzed());
                if (!this.zzsp.zzdt()) {
                    zzex = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex == this.tag);
            this.zzsq = zzex;
            return;
        }
        throw zzhc.zzgr();
    }

    public final void zzk(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i11 = this.tag & 7;
            if (i11 == 0) {
                do {
                    zzgu.zzbl(this.zzsp.zzee());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzgu.zzbl(this.zzsp.zzee());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzee()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzee()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i11 = this.tag & 7;
            if (i11 == 0) {
                do {
                    zzgu.zzbl(this.zzsp.zzef());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzgu.zzbl(this.zzsp.zzef());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzef()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzef()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i11 = this.tag & 7;
            if (i11 == 2) {
                int zzee = this.zzsp.zzee();
                zzal(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzgu.zzbl(this.zzsp.zzeg());
                } while (this.zzsp.zzez() < zzez);
            } else if (i11 == 5) {
                do {
                    zzgu.zzbl(this.zzsp.zzeg());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzal(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Integer.valueOf(this.zzsp.zzeg()));
                } while (this.zzsp.zzez() < zzez2);
            } else if (i12 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzeg()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i11 = this.tag & 7;
            if (i11 == 1) {
                do {
                    zzhq.zzac(this.zzsp.zzeh());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzee = this.zzsp.zzee();
                zzak(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzhq.zzac(this.zzsp.zzeh());
                } while (this.zzsp.zzez() < zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 1) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzeh()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzak(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Long.valueOf(this.zzsp.zzeh()));
                } while (this.zzsp.zzez() < zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i11 = this.tag & 7;
            if (i11 == 0) {
                do {
                    zzgu.zzbl(this.zzsp.zzei());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzgu.zzbl(this.zzsp.zzei());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzei()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzei()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i11 = this.tag & 7;
            if (i11 == 0) {
                do {
                    zzhq.zzac(this.zzsp.zzej());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzhq.zzac(this.zzsp.zzej());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzej()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Long.valueOf(this.zzsp.zzej()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    private final <T> T zzb(zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzee = this.zzsp.zzee();
        zzft zzft = this.zzsp;
        if (zzft.zzsf < zzft.zzsg) {
            int zzas = zzft.zzas(zzee);
            T newInstance = zzir.newInstance();
            this.zzsp.zzsf++;
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            this.zzsp.zzaq(0);
            zzft zzft2 = this.zzsp;
            zzft2.zzsf--;
            zzft2.zzat(zzas);
            return newInstance;
        }
        throw new zzhc("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public final <T> T zza(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzin.zzho().zzf(cls), zzgd);
    }

    public final void zzc(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i11 = this.tag & 7;
            if (i11 == 0) {
                do {
                    zzhq.zzac(this.zzsp.zzdw());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzhq.zzac(this.zzsp.zzdw());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzdw()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Long.valueOf(this.zzsp.zzdw()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final <T> T zza(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzir, zzgd);
    }

    public final void zza(List<Double> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgb) {
            zzgb zzgb = (zzgb) list;
            int i11 = this.tag & 7;
            if (i11 == 1) {
                do {
                    zzgb.zzc(this.zzsp.readDouble());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzee = this.zzsp.zzee();
                zzak(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzgb.zzc(this.zzsp.readDouble());
                } while (this.zzsp.zzez() < zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 1) {
                do {
                    list.add(Double.valueOf(this.zzsp.readDouble()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzak(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Double.valueOf(this.zzsp.readDouble()));
                } while (this.zzsp.zzez() < zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i11 = this.tag & 7;
            if (i11 == 0) {
                do {
                    zzhq.zzac(this.zzsp.zzdx());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i11 == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzhq.zzac(this.zzsp.zzdx());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzdx()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i12 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Long.valueOf(this.zzsp.zzdx()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzb(List<Float> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgo) {
            zzgo zzgo = (zzgo) list;
            int i11 = this.tag & 7;
            if (i11 == 2) {
                int zzee = this.zzsp.zzee();
                zzal(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzgo.zzu(this.zzsp.readFloat());
                } while (this.zzsp.zzez() < zzez);
            } else if (i11 == 5) {
                do {
                    zzgo.zzu(this.zzsp.readFloat());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i12 = this.tag & 7;
            if (i12 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzal(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Float.valueOf(this.zzsp.readFloat()));
                } while (this.zzsp.zzez() < zzez2);
            } else if (i12 == 5) {
                do {
                    list.add(Float.valueOf(this.zzsp.readFloat()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    private final void zza(List<String> list, boolean z11) throws IOException {
        int zzex;
        int zzex2;
        if ((this.tag & 7) != 2) {
            throw zzhc.zzgr();
        } else if (!(list instanceof zzhj) || z11) {
            do {
                list.add(z11 ? zzec() : readString());
                if (!this.zzsp.zzdt()) {
                    zzex = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex == this.tag);
            this.zzsq = zzex;
        } else {
            zzhj zzhj = (zzhj) list;
            do {
                zzhj.zzc(zzed());
                if (!this.zzsp.zzdt()) {
                    zzex2 = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex2 == this.tag);
            this.zzsq = zzex2;
        }
    }

    public final <T> void zzb(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzex;
        int i11 = this.tag;
        if ((i11 & 7) == 3) {
            do {
                list.add(zzd(zzir, zzgd));
                if (!this.zzsp.zzdt() && this.zzsq == 0) {
                    zzex = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex == i11);
            this.zzsq = zzex;
            return;
        }
        throw zzhc.zzgr();
    }

    public final <T> void zza(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzex;
        int i11 = this.tag;
        if ((i11 & 7) == 2) {
            do {
                list.add(zzb(zzir, zzgd));
                if (!this.zzsp.zzdt() && this.zzsq == 0) {
                    zzex = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex == i11);
            this.zzsq = zzex;
            return;
        }
        throw zzhc.zzgr();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzdv() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.vision.zzhc("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.vision.zzht<K, V> r9, com.google.android.gms.internal.vision.zzgd r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzaj(r0)
            com.google.android.gms.internal.vision.zzft r1 = r7.zzsp
            int r1 = r1.zzee()
            com.google.android.gms.internal.vision.zzft r2 = r7.zzsp
            int r1 = r2.zzas(r1)
            K r2 = r9.zzyn
            V r3 = r9.zzgc
        L_0x0014:
            int r4 = r7.zzdu()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.vision.zzft r5 = r7.zzsp     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzdt()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzdv()     // Catch:{ zzhb -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.vision.zzhc r4 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ zzhb -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzhb -> 0x004e }
            throw r4     // Catch:{ zzhb -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.vision.zzka r4 = r9.zzyo     // Catch:{ zzhb -> 0x004e }
            V r5 = r9.zzgc     // Catch:{ zzhb -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzhb -> 0x004e }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.vision.zzka) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzgd) r10)     // Catch:{ zzhb -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.vision.zzka r4 = r9.zzym     // Catch:{ zzhb -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza((com.google.android.gms.internal.vision.zzka) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzgd) r5)     // Catch:{ zzhb -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzdv()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.vision.zzhc r8 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.vision.zzft r8 = r7.zzsp
            r8.zzat(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.vision.zzft r9 = r7.zzsp
            r9.zzat(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfy.zza(java.util.Map, com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzgd):void");
    }

    private final Object zza(zzka zzka, Class<?> cls, zzgd zzgd) throws IOException {
        switch (zzfx.zzrr[zzka.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzeb());
            case 2:
                return zzed();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzef());
            case 5:
                return Integer.valueOf(zzea());
            case 6:
                return Long.valueOf(zzdz());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdy());
            case 9:
                return Long.valueOf(zzdx());
            case 10:
                return zza(cls, zzgd);
            case 11:
                return Integer.valueOf(zzeg());
            case 12:
                return Long.valueOf(zzeh());
            case 13:
                return Integer.valueOf(zzei());
            case 14:
                return Long.valueOf(zzej());
            case 15:
                return zzec();
            case 16:
                return Integer.valueOf(zzee());
            case 17:
                return Long.valueOf(zzdw());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
