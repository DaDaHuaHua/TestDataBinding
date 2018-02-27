package com.example.testdatabinding.recycler;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testdatabinding.BR;
import com.example.testdatabinding.R;
import com.example.testdatabinding.UserViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 33105 on 2018/2/27.
 */

public class UserAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    public static final int ITEM_VIEW_TYPE_ON = 1;
    public static final int ITEM_VIEW_TYPE_OFF = 2;

    private final LayoutInflater mLayoutInflater;
    private OnItemClickListener mOnItemClickListener;
    private List<UserViewModel> mUserList;

    public UserAdapter(Context context) {
        super();
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mUserList = new ArrayList<>();
    }


    @Override
    public int getItemViewType(int position) {
        final UserViewModel user = mUserList.get(position);
        if (user.visible.get()) {
            return ITEM_VIEW_TYPE_ON;
        } else {
            return ITEM_VIEW_TYPE_OFF;
        }
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == ITEM_VIEW_TYPE_ON) {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_user_visible, parent, false);
        } else {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_user_in_visible, parent, false);
        }
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final UserViewModel user = mUserList.get(position);
        if (getItemViewType(position) == ITEM_VIEW_TYPE_ON) {
            holder.getmBinding().setVariable(BR.visibleUser, user);
        }else{
            holder.getmBinding().setVariable(BR.invisibleUser,user);
        }
        holder.getmBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(user);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(UserViewModel user);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void addAll(List<UserViewModel> users) {
        mUserList.addAll(users);
    }

    Random mRandom = new Random(System.currentTimeMillis());

    public void add(UserViewModel user) {
        int pos = mRandom.nextInt(mUserList.size() + 1);
        mUserList.add(pos, user);
        notifyItemInserted(pos);
    }

    public void remove() {
        if (mUserList.size() == 0) {
            return;
        }
        int pos = mRandom.nextInt(mUserList.size());
        mUserList.remove(pos);
        notifyItemRemoved(pos);
    }
}
