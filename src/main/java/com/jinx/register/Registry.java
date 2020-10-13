package com.jinx.register;


import com.jinx.common.Node;
import com.jinx.common.URL;


public interface Registry extends Node, RegistryService {

    //TODO 后续研究
    default void reExportRegister(URL url) {
        register(url);
    }
    //TODO 后续研究
    default void reExportUnregister(URL url) {
        unregister(url);
    }
}