package com.huawei.wearengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.wearengine.connect.ServiceConnectCallback;

public interface WearEngineManager extends IInterface {

    public static class Default implements WearEngineManager {
        public IBinder asBinder() {
            return null;
        }

        public int registerConnectCallback(ServiceConnectCallback serviceConnectCallback) {
            return 0;
        }

        public int releaseConnection() {
            return 0;
        }

        public int unregisterConnectCallback(ServiceConnectCallback serviceConnectCallback) {
            return 0;
        }
    }

    public static abstract class Stub extends Binder implements WearEngineManager {
        private static final String DESCRIPTOR = "com.huawei.wearengine.WearEngineManager";

        public static class Proxy implements WearEngineManager {
            public static WearEngineManager sDefaultImpl;
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

            public int registerConnectCallback(ServiceConnectCallback serviceConnectCallback) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(serviceConnectCallback != null ? serviceConnectCallback.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().registerConnectCallback(serviceConnectCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int releaseConnection() {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().releaseConnection();
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int unregisterConnectCallback(ServiceConnectCallback serviceConnectCallback) {
                int readInt;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(serviceConnectCallback != null ? serviceConnectCallback.asBinder() : null);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        readInt = obtain2.readInt();
                    } else {
                        readInt = Stub.getDefaultImpl().unregisterConnectCallback(serviceConnectCallback);
                    }
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static WearEngineManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof WearEngineManager)) ? new Proxy(iBinder) : (WearEngineManager) queryLocalInterface;
        }

        public static WearEngineManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(WearEngineManager wearEngineManager) {
            if (Proxy.sDefaultImpl != null || wearEngineManager == null) {
                return false;
            }
            Proxy.sDefaultImpl = wearEngineManager;
            return true;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) {
            int registerConnectCallback;
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                registerConnectCallback = registerConnectCallback(ServiceConnectCallback.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                registerConnectCallback = unregisterConnectCallback(ServiceConnectCallback.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i11 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                registerConnectCallback = releaseConnection();
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel2.writeNoException();
            parcel2.writeInt(registerConnectCallback);
            return true;
        }
    }

    int registerConnectCallback(ServiceConnectCallback serviceConnectCallback);

    int releaseConnection();

    int unregisterConnectCallback(ServiceConnectCallback serviceConnectCallback);
}
