package com.t.cloudmusic.ui.main;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.t.cloudmusic.R;
import com.t.cloudmusic.adapter.MusicAdapter;
import com.t.cloudmusic.base.BFragment;
import com.t.cloudmusic.data.AdapterBean;
import com.t.cloudmusic.data.main.MusicBean;

public class MusicFragment extends BFragment<MainContract.Presenter> implements MainContract.MusicView {

    private RecyclerView recyclerView;
    private MusicAdapter musicAdapter;

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_music;
    }

    @Override
    protected void bindView() {
        recyclerView = findViewById(R.id.recyclerView);
        getP().getMusicDate();
    }

    @Override
    public void showErrorMsg(String message) {

    }

    @Override
    public MainContract.Presenter newP() {
        return new MainPresenter();
    }

    @Override
    public void onDataSuccess(AdapterBean musicBean) {
        musicAdapter = new MusicAdapter(musicBean);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new MusicAdapter.MusicItemDecoration());
        recyclerView.setAdapter(musicAdapter);
    }
}
