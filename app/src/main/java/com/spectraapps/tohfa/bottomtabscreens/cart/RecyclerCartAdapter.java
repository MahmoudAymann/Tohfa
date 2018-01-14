package com.spectraapps.tohfa.bottomtabscreens.cart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.spectraapps.tohfa.R;
import com.spectraapps.tohfa.helper.MenueHelper;

import java.util.ArrayList;

/**
 * Created by MahmoudAyman on 03/01/2018.
 */

public class RecyclerCartAdapter extends RecyclerView.Adapter<RecyclerCartAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<CartData> mCartDataList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(CartData cartData);
    }

    RecyclerCartAdapter(Context context, ArrayList<CartData> cartDataList, OnItemClickListener listener) {
        this.mCartDataList = cartDataList;
        this.listener = listener;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_item_cart_view, parent, false);
        return new RecyclerCartAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        CartData listy = mCartDataList.get(position);
        holder.bind(listy, listener);

        holder.overflowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflowMenu);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCartDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  nameTextView;
        TextView  name2TextView;
        ImageView imageView;
        ImageView overflowMenu;
        MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name1);
            name2TextView = itemView.findViewById(R.id.name2);
            imageView = itemView.findViewById(R.id.thumbnail);
            overflowMenu = itemView.findViewById(R.id.overflow);
        }

        private void bind(final CartData cartData, final OnItemClickListener listener) {
            nameTextView.setText(cartData.getName());
            name2TextView.setText(cartData.getName2());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    listener.onItemClick(cartData);
                }
            });
        }
    }//end class MyViewHolder
/////////////////////////////////////////////////////////////////////////////////
    //popup menu"overflow" click listeners.
    private void showPopupMenu(View view) {
        // inflate menu
        MenueHelper popup = new MenueHelper(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.fav_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements MenueHelper.OnMenuItemClickListener {

        MyMenuItemClickListener() {

        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_delete:
                    //action delete here
                    Toast.makeText(mContext, "delete", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }

    }//end class menu
    //////////////////////////////////////////////


}//end class adapter
