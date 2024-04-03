package com.huawei.wearengine.p2p;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface ReceiverCallback extends IInterface {

    public static class Default implements ReceiverCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onReceiveFileMessage(MessageParcel messageParcel) {
        }

        public void onReceiveMessage(byte[] bArr) {
        }
    }

    public static abstract class Stub extends Binder implements ReceiverCallback {
        private static final String DESCRIPTOR = "com.huawei.wearengine.p2p.ReceiverCallback";

        public static class Proxy implements ReceiverCallback {
            public static ReceiverCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onReceiveFileMessage(MessageParcel messageParcel) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (messageParcel != null) {
                        obtain.writeInt(1);
                        messageParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onReceiveFileMessage(messageParcel);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onReceiveMessage(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.readByteArray(bArr);
                    } else {
                        Stub.getDefaultImpl().onReceiveMessage(bArr);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ReceiverCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ReceiverCallback)) ? new Proxy(iBinder) : (ReceiverCallback) queryLocalInterface;
        }

        public static ReceiverCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(ReceiverCallback receiverCallback) {
            if (Proxy.sDefaultImpl != null || receiverCallback == null) {
                return false;
            }
            Proxy.sDefaultImpl = receiverCallback;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                byte[] createByteArray = parcel.createByteArray();
                onReceiveMessage(createByteArray);
                parcel2.writeNoException();
                parcel2.writeByteArray(createByteArray);
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                onReceiveFileMessage(parcel.readInt() != 0 ? MessageParcel.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void onReceiveFileMessage(MessageParcel messageParcel);

    void onReceiveMessage(byte[] bArr);
}
