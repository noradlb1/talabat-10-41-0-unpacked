package com.google.firebase.database.tubesock;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class WebSocketWriter {
    private WritableByteChannel channel;
    private boolean closeSent = false;
    private final Thread innerThread = WebSocket.getThreadFactory().newThread(new Runnable() {
        public void run() {
            WebSocketWriter.this.runWriter();
        }
    });
    private BlockingQueue<ByteBuffer> pendingBuffers;
    private final Random random = new Random();
    private volatile boolean stop = false;
    private WebSocket websocket;

    public WebSocketWriter(WebSocket webSocket, String str, int i11) {
        ThreadInitializer intializer = WebSocket.getIntializer();
        Thread innerThread2 = getInnerThread();
        intializer.setName(innerThread2, str + "Writer-" + i11);
        this.websocket = webSocket;
        this.pendingBuffers = new LinkedBlockingQueue();
    }

    private ByteBuffer frameInBuffer(byte b11, boolean z11, byte[] bArr) throws IOException {
        int i11;
        int i12;
        if (z11) {
            i11 = 6;
        } else {
            i11 = 2;
        }
        int length = bArr.length;
        int i13 = 126;
        if (length >= 126) {
            if (length <= 65535) {
                i11 += 2;
            } else {
                i11 += 8;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + i11);
        allocate.put((byte) (b11 | Byte.MIN_VALUE));
        if (length < 126) {
            if (z11) {
                length |= 128;
            }
            allocate.put((byte) length);
        } else if (length <= 65535) {
            if (z11) {
                i13 = 254;
            }
            allocate.put((byte) i13);
            allocate.putShort((short) length);
        } else {
            if (z11) {
                i12 = 255;
            } else {
                i12 = 127;
            }
            allocate.put((byte) i12);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z11) {
            byte[] generateMask = generateMask();
            allocate.put(generateMask);
            for (int i14 = 0; i14 < bArr.length; i14++) {
                allocate.put((byte) (bArr[i14] ^ generateMask[i14 % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] generateMask() {
        byte[] bArr = new byte[4];
        this.random.nextBytes(bArr);
        return bArr;
    }

    private void handleError(WebSocketException webSocketException) {
        this.websocket.handleReceiverError(webSocketException);
    }

    /* access modifiers changed from: private */
    public void runWriter() {
        while (!this.stop && !Thread.interrupted()) {
            try {
                writeMessage();
            } catch (IOException e11) {
                handleError(new WebSocketException("IO Exception", e11));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i11 = 0; i11 < this.pendingBuffers.size(); i11++) {
            writeMessage();
        }
    }

    private void writeMessage() throws InterruptedException, IOException {
        this.channel.write(this.pendingBuffers.take());
    }

    public Thread getInnerThread() {
        return this.innerThread;
    }

    public synchronized void send(byte b11, boolean z11, byte[] bArr) throws IOException {
        ByteBuffer frameInBuffer = frameInBuffer(b11, z11, bArr);
        if (this.stop) {
            if (this.closeSent || b11 != 8) {
                throw new WebSocketException("Shouldn't be sending");
            }
        }
        if (b11 == 8) {
            this.closeSent = true;
        }
        this.pendingBuffers.add(frameInBuffer);
    }

    public void setOutput(OutputStream outputStream) {
        this.channel = Channels.newChannel(outputStream);
    }

    public void stopIt() {
        this.stop = true;
    }
}
