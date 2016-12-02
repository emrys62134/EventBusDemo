package com.pei.eventbusdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by dllo on 16/12/2.
 */
public class RightFragment extends Fragment {

    private TextView tv;

    // EventBus接收界面
    // 如果是在Fragment 需要在OnAttach生命周期进行注册


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        EventBus.getDefault().register(this); // 注册
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_right,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = (TextView) view.findViewById(R.id.tv_right);
    }

    // 需要添加@Subscribe 注释 表明这是一个EventBus的一个接收的方法
    // (threadMode = ThreadMode.MAIN) 表明在主线程
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getData(Bean bean){
        tv.setText(bean.getContent());
    }

    // 获取到想要的数据之后 需要对EventBus进行取消注册
    // 在Fragment onDetach生命周期取消

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this);
    }
}
