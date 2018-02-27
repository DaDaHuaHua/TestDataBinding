package com.example.testdatabinding.recycler;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.testdatabinding.R;
import com.example.testdatabinding.UserViewModel;
import com.example.testdatabinding.databinding.MyListBinding;

import java.util.ArrayList;
import java.util.List;


public class ListActivity extends AppCompatActivity {

    public MyListBinding mBinding;
    UserAdapter mUserAdapter;

    public class Presenter {
        public void onClickAddItem(View view){
           mUserAdapter.add(new UserViewModel("new ",999,"89757",true));
        }

        public void onClickRemoveItem(View view){
            mUserAdapter.remove();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        mBinding.setPresenter(new Presenter());
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mUserAdapter = new UserAdapter(this);
        mBinding.recyclerView.setAdapter(mUserAdapter);
        mUserAdapter.setOnItemClickListener(new UserAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(UserViewModel user) {
                Toast.makeText(ListActivity.this, user.name, Toast.LENGTH_SHORT).show();
            }
        });
        List<UserViewModel> users = new ArrayList<>();
        users.add(new UserViewModel("songhua",11,"0001",true));
        users.add(new UserViewModel("aaa",22,"0002",false));
        users.add(new UserViewModel("bbb",113,"00431",true));
        users.add(new UserViewModel("ccc",12,"0001231",true));
        users.add(new UserViewModel("asd",12,"0001231",true));
        users.add(new UserViewModel("ccxcc",12,"0ad00asd1231",false));
        users.add(new UserViewModel("vvvv",12,"00012asd31",true));
        users.add(new UserViewModel("qqqq",12,"0001vcdsd231",false));
        mUserAdapter.addAll(users);
    }

}
