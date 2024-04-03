package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class UdpDataSource extends BaseDataSource {
    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 8000;
    public static final int UDP_PORT_UNSET = -1;
    @Nullable
    private InetAddress address;
    @Nullable
    private MulticastSocket multicastSocket;
    private boolean opened;
    private final DatagramPacket packet;
    private final byte[] packetBuffer;
    private int packetRemaining;
    @Nullable
    private DatagramSocket socket;
    private final int socketTimeoutMillis;
    @Nullable
    private Uri uri;

    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    public void close() {
        this.uri = null;
        MulticastSocket multicastSocket2 = this.multicastSocket;
        if (multicastSocket2 != null) {
            try {
                multicastSocket2.leaveGroup((InetAddress) Assertions.checkNotNull(this.address));
            } catch (IOException unused) {
            }
            this.multicastSocket = null;
        }
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.socket = null;
        }
        this.address = null;
        this.packetRemaining = 0;
        if (this.opened) {
            this.opened = false;
            transferEnded();
        }
    }

    public int getLocalPort() {
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    @Nullable
    public Uri getUri() {
        return this.uri;
    }

    public long open(DataSpec dataSpec) throws UdpDataSourceException {
        Uri uri2 = dataSpec.uri;
        this.uri = uri2;
        String str = (String) Assertions.checkNotNull(uri2.getHost());
        int port = this.uri.getPort();
        transferInitializing(dataSpec);
        try {
            this.address = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.address, port);
            if (this.address.isMulticastAddress()) {
                MulticastSocket multicastSocket2 = new MulticastSocket(inetSocketAddress);
                this.multicastSocket = multicastSocket2;
                multicastSocket2.joinGroup(this.address);
                this.socket = this.multicastSocket;
            } else {
                this.socket = new DatagramSocket(inetSocketAddress);
            }
            this.socket.setSoTimeout(this.socketTimeoutMillis);
            this.opened = true;
            transferStarted(dataSpec);
            return -1;
        } catch (SecurityException e11) {
            throw new UdpDataSourceException(e11, PlaybackException.ERROR_CODE_IO_NO_PERMISSION);
        } catch (IOException e12) {
            throw new UdpDataSourceException(e12, 2001);
        }
    }

    public int read(byte[] bArr, int i11, int i12) throws UdpDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        if (this.packetRemaining == 0) {
            try {
                ((DatagramSocket) Assertions.checkNotNull(this.socket)).receive(this.packet);
                int length = this.packet.getLength();
                this.packetRemaining = length;
                bytesTransferred(length);
            } catch (SocketTimeoutException e11) {
                throw new UdpDataSourceException(e11, PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT);
            } catch (IOException e12) {
                throw new UdpDataSourceException(e12, 2001);
            }
        }
        int length2 = this.packet.getLength();
        int i13 = this.packetRemaining;
        int min = Math.min(i13, i12);
        System.arraycopy(this.packetBuffer, length2 - i13, bArr, i11, min);
        this.packetRemaining -= min;
        return min;
    }

    public UdpDataSource(int i11) {
        this(i11, 8000);
    }

    public UdpDataSource(int i11, int i12) {
        super(true);
        this.socketTimeoutMillis = i12;
        byte[] bArr = new byte[i11];
        this.packetBuffer = bArr;
        this.packet = new DatagramPacket(bArr, 0, i11);
    }
}
