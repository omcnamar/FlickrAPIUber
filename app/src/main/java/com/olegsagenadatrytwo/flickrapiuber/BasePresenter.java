package com.olegsagenadatrytwo.flickrapiuber;

/**
 * Created by omcna on 10/9/2017.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void removeView();
}
