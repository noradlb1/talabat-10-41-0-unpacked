package com.google.firebase.database.tubesock;

import com.google.common.base.Ascii;
import com.google.firebase.database.tubesock.MessageBuilderFactory;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

class WebSocketReceiver {
    private WebSocketEventHandler eventHandler = null;
    private DataInputStream input = null;
    private byte[] inputHeader = new byte[112];
    private MessageBuilderFactory.Builder pendingBuilder;
    private volatile boolean stop = false;
    private WebSocket websocket = null;

    public WebSocketReceiver(WebSocket webSocket) {
        this.websocket = webSocket;
    }

    private void appendBytes(boolean z11, byte b11, byte[] bArr) {
        if (b11 != 9) {
            MessageBuilderFactory.Builder builder = this.pendingBuilder;
            if (builder != null && b11 != 0) {
                throw new WebSocketException("Failed to continue outstanding frame");
            } else if (builder == null && b11 == 0) {
                throw new WebSocketException("Received continuing frame, but there's nothing to continue");
            } else {
                if (builder == null) {
                    this.pendingBuilder = MessageBuilderFactory.builder(b11);
                }
                if (!this.pendingBuilder.appendBytes(bArr)) {
                    throw new WebSocketException("Failed to decode frame");
                } else if (z11) {
                    WebSocketMessage message = this.pendingBuilder.toMessage();
                    this.pendingBuilder = null;
                    if (message != null) {
                        this.eventHandler.onMessage(message);
                        return;
                    }
                    throw new WebSocketException("Failed to decode whole message");
                }
            }
        } else if (z11) {
            handlePing(bArr);
        } else {
            throw new WebSocketException("PING must not fragment across frames");
        }
    }

    private void handleError(WebSocketException webSocketException) {
        stopit();
        this.websocket.handleReceiverError(webSocketException);
    }

    private void handlePing(byte[] bArr) {
        if (bArr.length <= 125) {
            this.websocket.pong(bArr);
            return;
        }
        throw new WebSocketException("PING frame too long");
    }

    private long parseLong(byte[] bArr, int i11) {
        return (((long) bArr[i11 + 0]) << 56) + (((long) (bArr[i11 + 1] & 255)) << 48) + (((long) (bArr[i11 + 2] & 255)) << 40) + (((long) (bArr[i11 + 3] & 255)) << 32) + (((long) (bArr[i11 + 4] & 255)) << 24) + ((long) ((bArr[i11 + 5] & 255) << Ascii.DLE)) + ((long) ((bArr[i11 + 6] & 255) << 8)) + ((long) ((bArr[i11 + 7] & 255) << 0));
    }

    private int read(byte[] bArr, int i11, int i12) throws IOException {
        this.input.readFully(bArr, i11, i12);
        return i12;
    }

    public boolean isRunning() {
        return !this.stop;
    }

    public void run() {
        boolean z11;
        boolean z12;
        long j11;
        this.eventHandler = this.websocket.getEventHandler();
        while (!this.stop) {
            try {
                int read = read(this.inputHeader, 0, 1) + 0;
                byte[] bArr = this.inputHeader;
                byte b11 = bArr[0];
                if ((b11 & 128) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if ((b11 & 112) != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (!z12) {
                    byte b12 = (byte) (b11 & Ascii.SI);
                    int read2 = read + read(bArr, read, 1);
                    byte[] bArr2 = this.inputHeader;
                    byte b13 = bArr2[1];
                    if (b13 < 126) {
                        j11 = (long) b13;
                    } else if (b13 == 126) {
                        read(bArr2, read2, 2);
                        byte[] bArr3 = this.inputHeader;
                        j11 = (((long) (bArr3[2] & 255)) << 8) | ((long) (bArr3[3] & 255));
                    } else if (b13 == Byte.MAX_VALUE) {
                        j11 = parseLong(this.inputHeader, (read2 + read(bArr2, read2, 8)) - 8);
                    } else {
                        j11 = 0;
                    }
                    int i11 = (int) j11;
                    byte[] bArr4 = new byte[i11];
                    read(bArr4, 0, i11);
                    if (b12 == 8) {
                        this.websocket.onCloseOpReceived();
                    } else if (b12 != 10) {
                        if (!(b12 == 1 || b12 == 2 || b12 == 9)) {
                            if (b12 != 0) {
                                throw new WebSocketException("Unsupported opcode: " + b12);
                            }
                        }
                        appendBytes(z11, b12, bArr4);
                    }
                } else {
                    throw new WebSocketException("Invalid frame received");
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException e11) {
                handleError(new WebSocketException("IO Error", e11));
            } catch (WebSocketException e12) {
                handleError(e12);
            }
        }
    }

    public void setInput(DataInputStream dataInputStream) {
        this.input = dataInputStream;
    }

    public void stopit() {
        this.stop = true;
    }
}
