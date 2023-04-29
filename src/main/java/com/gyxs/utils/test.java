package com.gyxs.utils;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;


public interface test extends Library {
    /**
     *
     */
    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary((Platform.isWindows() ? "demo" : "c"),
                CLibrary.class);

        void demo(byte[] data, int height, int width, int channels);
    }
}