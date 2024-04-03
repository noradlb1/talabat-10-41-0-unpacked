package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.IMultiInstanceInvalidationCallback;

public interface IMultiInstanceInvalidationService extends IInterface {

    public static class Default implements IMultiInstanceInvalidationService {
        public IBinder asBinder() {
            return null;
        }

        public void broadcastInvalidation(int i11, String[] strArr) throws RemoteException {
        }

        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException {
            return 0;
        }

        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i11) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationService {
        private static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationService";

        public static class Proxy implements IMultiInstanceInvalidationService {
            public static IMultiInstanceInvalidationService sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void broadcastInvalidation(int i11, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeStringArray(strArr);
                    if (this.mRemote.transact(3, obtain, (Parcel) null, 1) || Stub.getDefaultImpl() == null) {
                        obtain.recycle();
                    } else {
                        Stub.getDefaultImpl().broadcastInvalidation(i11, strArr);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMultiInstanceInvalidationCallback != null) {
                        iBinder = iMultiInstanceInvalidationCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().registerCallback(iMultiInstanceInvalidationCallback, str);
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i11) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (iMultiInstanceInvalidationCallback != null) {
                        iBinder = iMultiInstanceInvalidationCallback.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i11);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().unregisterCallback(iMultiInstanceInvalidationCallback, i11);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMultiInstanceInvalidationService)) {
                return new Proxy(iBinder);
            }
            return (IMultiInstanceInvalidationService) queryLocalInterface;
        }

        public static IMultiInstanceInvalidationService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IMultiInstanceInvalidationService iMultiInstanceInvalidationService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iMultiInstanceInvalidationService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iMultiInstanceInvalidationService;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int registerCallback = registerCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(registerCallback);
                return true;
            } else if (i11 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                unregisterCallback(IMultiInstanceInvalidationCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i11 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
                return true;
            } else if (i11 != 1598968902) {
                return super.onTransact(i11, parcel, parcel2, i12);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void broadcastInvalidation(int i11, String[] strArr) throws RemoteException;

    int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) throws RemoteException;

    void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i11) throws RemoteException;
}
