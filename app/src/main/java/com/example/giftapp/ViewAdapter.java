package com.example.giftapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewAdapterViewHold> {

    private ArrayList<Gift> giftArrayList;
    private Context context;
    private ClickedItem clickedItem;





//    /**
//     * This will bring the passed clicked item into the class
//     * @param clickedItem
//     */
//    public ViewAdapter(ClickedItem clickedItem) {
//        this.clickedItem = clickedItem;
//    }

    /**
     * This will bring the passed Gift list inside the class.
     * @param giftArrayList
     */
    public void setData(ArrayList<Gift> giftArrayList) {
        this.giftArrayList = giftArrayList;
        notifyDataSetChanged();
    }

    /**
     * The view holder for the adapter
     */
    public class ViewAdapterViewHold extends RecyclerView.ViewHolder {


        TextView gift_view_text;

        ImageView imageDel;

        /**
         * Pass through the values that will used when building the recyclerview.
         * @param itemView
         */
        public ViewAdapterViewHold(@NonNull View itemView) {
            super(itemView);
            gift_view_text = itemView.findViewById(R.id.gift_view_text);
            imageDel = itemView.findViewById(R.id.imageDel);

        }
    }

    /**
     * When creating the view holder, find and attach to the rows_of_items activity.
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewAdapter.ViewAdapterViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewAdapter.ViewAdapterViewHold(LayoutInflater.from(context).inflate(R.layout.rows_of_items,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewAdapterViewHold holder, int position) {
        //Gift gift = giftList.get(position);
        final Gift gift = Storage.get_x_element(position);
        String forWhom = "For " + gift.getForWhom() + ":\n";
        String giftName = "Gift: " + gift.getGiftName() + "\n";
        String price = "Price: " + gift.getGiftPrice() + "\n";
        String notes = "Notes: " + gift.getGiftNotes() + "\n";
        String text = forWhom + giftName + price + notes;

        holder.gift_view_text.setText(text);
        holder.imageDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedGift(gift);
            }
        });


    }

    /**
     * Gives the size the recyclerview to improve performance.
     * @return
     */
    @Override
    public int getItemCount() {
        return giftArrayList.size();
    }

    public ViewAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    /**
     * Clicked item interface.
     */
    public interface ClickedItem {
        public void ClickedGift(Gift gift);
    }
}
