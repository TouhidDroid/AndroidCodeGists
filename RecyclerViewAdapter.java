package org.durbinbd.DurbinStudent.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.durbinbd.DurbinStudent.R;

import java.util.ArrayList;

/**
 * Created by touhid on 7/13/16.
 *
 * @author touhid
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.SampleViewHolder> {

    private ArrayList<Object> itemList;

    public RecyclerViewAdapter(ArrayList<Object> itemList) {
        this.itemList = itemList;
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SampleViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.uni_list_item, parent, false
                ));
    }

    @Override
    public void onBindViewHolder(SampleViewHolder holder, int position) {
        Object obj = itemList.get(position);
        // TODO Setup view elements got from the holder parameter
        // Don't finalize param. position,
        // rather (if needed) finalize holder & use holder.getAdapterPosition();
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public void add(int position, Object object) {
        itemList.add(position, object);
        notifyItemInserted(position);
    }

    /**
     * Adds to the last of the list
     */
    public void add(Object object) {
        itemList.add(object);
        notifyItemInserted(getItemCount() - 1);
    }

    public void remove(int position) {
        if (position > getItemCount())
            return;
        itemList.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(Object object) {
        int pos = itemList.indexOf(object);
        itemList.remove(pos);
        notifyItemRemoved(pos);
    }

    public Object getItem(int position) {
        return itemList.get(position);
    }


    public void addUniquely(ArrayList<Object> newChapterList) {
        int nsz = newChapterList.size();
        for (int i = 0; i < nsz; i++) {
            boolean exist = false;
            Object p = newChapterList.get(i);
            int curSz = itemList.size();
            for (int j = 0; j < curSz; j++)
                /* TODO Compare the ID / unique attribute
                if (p.getId() == itemList.get(j).getId()) {
                    exist = true;
                    break;
                }*/
                if (!exist) {
                    itemList.add(p);
                    notifyItemInserted(curSz);
                }
        }
    }

    public void clear() {
        int itemCount = getItemCount();
        itemList.clear();
        notifyItemRangeRemoved(0, itemCount);
        // notifyDataSetChanged();
    }


    public static class SampleViewHolder extends RecyclerView.ViewHolder {

        // TODO Declare the views as publicly accessible elements

        public SampleViewHolder(View itemView) {
            super(itemView);
            // TODO Initialize the declared views from itemView.finViewById(R.id.***);
        }
    }
}
