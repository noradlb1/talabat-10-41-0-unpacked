package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class zzun extends zzdf {
    private final byte[] zza;
    private final DatagramPacket zzb;
    @Nullable
    private Uri zzc;
    @Nullable
    private DatagramSocket zzd;
    @Nullable
    private MulticastSocket zze;
    @Nullable
    private InetAddress zzf;
    @Nullable
    private InetSocketAddress zzg;
    private boolean zzh;
    private int zzi;

    public zzun() {
        this(2000);
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws zzum {
        if (i12 == 0) {
            return 0;
        }
        if (this.zzi == 0) {
            try {
                this.zzd.receive(this.zzb);
                int length = this.zzb.getLength();
                this.zzi = length;
                zzc(length);
            } catch (SocketTimeoutException e11) {
                throw new zzum(e11, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT);
            } catch (IOException e12) {
                throw new zzum(e12, 2001);
            }
        }
        int length2 = this.zzb.getLength();
        int i13 = this.zzi;
        int min = Math.min(i13, i12);
        System.arraycopy(this.zza, length2 - i13, bArr, i11, min);
        this.zzi -= min;
        return min;
    }

    public final long zzh(zzdm zzdm) throws zzum {
        Uri uri = zzdm.zza;
        this.zzc = uri;
        String host = uri.getHost();
        int port = this.zzc.getPort();
        zze(zzdm);
        try {
            this.zzf = InetAddress.getByName(host);
            this.zzg = new InetSocketAddress(this.zzf, port);
            if (this.zzf.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.zzg);
                this.zze = multicastSocket;
                multicastSocket.joinGroup(this.zzf);
                this.zzd = this.zze;
            } else {
                this.zzd = new DatagramSocket(this.zzg);
            }
            this.zzd.setSoTimeout(8000);
            this.zzh = true;
            zzf(zzdm);
            return -1;
        } catch (SecurityException e11) {
            throw new zzum(e11, PlaybackException.ERROR_CODE_IO_NO_PERMISSION);
        } catch (IOException e12) {
            throw new zzum(e12, 2001);
        }
    }

    @Nullable
    public final Uri zzi() {
        return this.zzc;
    }

    public final void zzj() {
        this.zzc = null;
        MulticastSocket multicastSocket = this.zze;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.zzf);
            } catch (IOException unused) {
            }
            this.zze = null;
        }
        DatagramSocket datagramSocket = this.zzd;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.zzd = null;
        }
        this.zzf = null;
        this.zzg = null;
        this.zzi = 0;
        if (this.zzh) {
            this.zzh = false;
            zzd();
        }
    }

    public zzun(int i11) {
        super(true);
        byte[] bArr = new byte[2000];
        this.zza = bArr;
        this.zzb = new DatagramPacket(bArr, 0, 2000);
    }
}
