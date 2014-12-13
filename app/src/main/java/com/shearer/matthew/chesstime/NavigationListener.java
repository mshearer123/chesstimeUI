package com.shearer.matthew.chesstime;

import android.os.Bundle;

/**
 * Created by mshearer123 on 13/12/14.
 */
public interface NavigationListener {

    public void changePage(String fragmentName, boolean animate, Bundle args);

}
