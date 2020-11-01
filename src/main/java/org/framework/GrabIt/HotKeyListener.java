package org.framework.GrabIt;

import java.util.EventListener;

public interface HotKeyListener extends EventListener {
    public void onHotKey(HotKey hotKey);
}
