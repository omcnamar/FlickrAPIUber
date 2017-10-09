package com.olegsagenadatrytwo.flickrapiuber.view.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.olegsagenadatrytwo.flickrapiuber.R;
import com.olegsagenadatrytwo.flickrapiuber.entities.Flicker;
import com.olegsagenadatrytwo.flickrapiuber.injection.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    /**use Dagger Injections*/
    @Inject
    MainActivityPresenter presenter;

    /**use Butterknife Injections*/
    @BindView(R.id.rvRecyclerImages)
    RecyclerView mRvRecyclerImages;
    @BindView(R.id.etQuery)
    EditText mEtQuery;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemAnimator itemAnimator;
    private ImageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpDagger();
        initRecyclerView();
        presenter.attachView(this);
        presenter.attachRemote();
        presenter.getImages("kittens");
    }

    /**
     * method that initializes Recycler View
     */
    private void initRecyclerView() {
        layoutManager = new GridLayoutManager(this, 3);
        itemAnimator = new DefaultItemAnimator();
        mRvRecyclerImages.setLayoutManager(layoutManager);
        mRvRecyclerImages.setItemAnimator(itemAnimator);
    }

    /**
     * method to set Up Dagger
     */
    private void setUpDagger() {
        DaggerMainActivityComponent.create().insert(this);
    }

    @Override
    public void showError(String error) {

    }

    /**
     * after the Images we received from the Flicker API update UI
     */
    @Override
    public void updateUI(Flicker data) {
        adapter = new ImageAdapter(data.getPhotos().getPhoto(), getApplicationContext());
        mRvRecyclerImages.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * onClick to search
     */
    @OnClick(R.id.btnSubmit)
    public void onViewClicked() {
        String query = mEtQuery.getText().toString();
        if (query.length()!= 0) {
            presenter.getImages(query);
        }else{
            Toast.makeText(this, "Enter a search query", Toast.LENGTH_SHORT).show();
        }
    }
}
