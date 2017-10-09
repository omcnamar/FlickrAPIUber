package com.olegsagenadatrytwo.flickrapiuber.view.mainactivity;

import com.olegsagenadatrytwo.flickrapiuber.BasePresenter;
import com.olegsagenadatrytwo.flickrapiuber.BaseView;
import com.olegsagenadatrytwo.flickrapiuber.entities.Flicker;

/**
 * Created by omcna on 10/9/2017.
 */

public interface MainActivityContract {
    interface View extends BaseView{

        void updateUI(Flicker data);
    }

    interface Presenter extends BasePresenter<View>{

        void getImages(String query);
        void attachRemote();
    }
}
