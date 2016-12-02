package com.pei.eventbusdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    private FrameLayout leftFrame;
    private FrameLayout rightFrame;

    /**
     * 使用EventBus 进行界面之间的传值
     1, 导包 greenRobot 家的依赖
     2, 新建一个实体类
     3, 在传值界面对EventBus进行初始化 然后使用post方法进行传递
     4, 在接收界面 首先注册EventBus, 然后创建一个方法(传递类) 从这个类中获取你想要的数据
     5, 在接收界面 对应注册的生命进行取消EventBus注册

     ******  使用EventBus 有一点要切记 ,不能将数据传给一个在传值界面生成之后的界面,
     *          只能传给在它生成之前的界面

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftFrame = (FrameLayout) findViewById(R.id.left_frame);
        rightFrame = (FrameLayout) findViewById(R.id.right_frame);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.left_frame,new LeftFragment());
        transaction.replace(R.id.right_frame,new RightFragment());
        transaction.commit();
    }
}
