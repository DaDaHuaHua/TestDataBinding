package com.example.testdatabinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.testdatabinding.databinding.SongBinding;
import com.example.testdatabinding.recycler.ListActivity;

public class MainActivity extends AppCompatActivity {

    private SongBinding mBinding;
    private Handler mHandler;
    private UserViewModel mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mHandler = new Handler();
        mUser = new UserViewModel("song", 11, "00001", true);
        mUser.nickName = "Nick";
        mBinding.setUserViewModel(mUser);
        mBinding.setPresenter(new Presenter());
        mBinding.viewStub.getViewStub().inflate();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mUser.name = "hua";
//                mUser.age = "22";
//                mBinding.setUserViewModel(mUser);
////                mBinding.setVariable(BR.userViewModel,user1);Z
//            }
//        }, 3000);
    }

    public class Presenter extends com.example.testdatabinding.Presenter {
        public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
            mUser.name = text.toString();
            mUser.visible.set(!mUser.visible.get());
//            mBinding.setUserViewModel(mUser);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, mUser.name, Toast.LENGTH_SHORT).show();
        }

        public void onClick(View view, String child) {
            Toast.makeText(MainActivity.this, child, Toast.LENGTH_SHORT).show();
        }

        public void onClickBinding(UserViewModel user, View v) {
            Toast.makeText(MainActivity.this, v.toString(), Toast.LENGTH_SHORT).show();
        }

        public void onClickToList(View v){
            startActivity(new Intent(MainActivity.this ,ListActivity.class));
        }

    }
}
