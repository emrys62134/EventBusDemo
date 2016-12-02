package com.pei.eventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by dllo on 16/12/2.
 */
public class LeftFragment extends Fragment {

    private EditText ed;
    private Button btn;
    private EventBus eventBus; // 声明EventBus
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_left,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ed = (EditText) view.findViewById(R.id.et_left);
        btn = (Button) view.findViewById(R.id.btn_left);
        eventBus = EventBus.getDefault(); // 对EventBus 进行初始化

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 获取 EditText 输入的内容
                String data = ed.getText().toString();
                // 然后将获取的内容设置给实体类
                // 首先实体类进行初始化
                Bean bean = new Bean();
                bean.setContent(data);

                // 然后使用EventBus的post方法将实体类传出去
                eventBus.post(bean);
            }
        });

    }
}
