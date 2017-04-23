package com.example.mrqiu.photoshop.ui.adapter;

import android.content.Context;
import android.support.v4.content.ParallelExecutorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mrqiu.photoshop.R;

import java.util.List;

/**
 * Created by mrqiu on 2017/4/23.
 */

public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter implements View.OnClickListener {
    private Context mContext;
    private int mLayoutId;
    private List<T> mData;
    private OnItemClickListener mOnItemClickListener;

    public RecyclerAdapter( Context mContext,List<T> mData, int mLayoutId) {
        this.mData = mData;
        this.mLayoutId = mLayoutId;
        this.mContext = mContext;
    }

    public void update(List<T> list){
        mData = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener l){
        mOnItemClickListener = l;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new RViewHolder(li.inflate(mLayoutId,parent,false)) ;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
        onBindViewHolder((RViewHolder) holder,mData.get(position),position);

    }
    public abstract void onBindViewHolder(RViewHolder holder,T t ,int position);

    @Override
    public int getItemCount() {
        return mData == null ? 0: mData.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener !=null){
            mOnItemClickListener.itemClick((Integer) v.getTag(),v);
        }

    }
    public interface OnItemClickListener{
        void itemClick(int position,View v);
    }


    public static class RViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        public RViewHolder(View itemView) {
            super(itemView);
            this.itemView =itemView;
        }
        public <T extends View> T findView(int id){
            return (T) itemView.findViewById(id);
        }

        public RViewHolder setText(int id,String context){
            ((TextView) itemView.findViewById(id)).setText(context);
            return this;
        }

        public View getItemView(){
            return itemView;
        }

    }
}
