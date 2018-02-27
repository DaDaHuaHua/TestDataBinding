package com.example.testdatabinding.recycler;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 33105 on 2018/2/27.
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{

    private T mBinding;


    public BindingViewHolder(T  binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public T getmBinding() {
        return mBinding;
    }
}
