package com.masudinn.recyclerviewjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.Holder>{
    private Context con;
    private ArrayList<items>mList;
    private OnItemClikListener mListener;

    public interface OnItemClikListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClikListener listener){
        mListener = listener;
    }

    public adapter(Context context,ArrayList<items> list){
        con = context;
        mList = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(con).inflate(R.layout.item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        items currentItems = mList.get(position);
        String url = currentItems.getmImageurl();
        String creator = currentItems.getmCreator();
        String tags = currentItems.getTags();
        int like = currentItems.getmLikes();
        int unduh = currentItems.getUnduh();

        holder.mtags.setText("Tags : "+tags);
        holder.munduh.setText("  "+unduh);
        holder.mTextViewcreator.setText(creator);
        holder.mTextviewlikes.setText("  "+like);
        Picasso.with(con).load(url).fit().centerInside().into(holder.mImageview);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        public ImageView mImageview;
        public TextView mTextViewcreator;
        public TextView mTextviewlikes;
        public TextView mtags;
        public TextView munduh;

        public Holder( View itemView) {
            super(itemView);
            mImageview = itemView.findViewById(R.id.image);
            mTextViewcreator = itemView.findViewById(R.id.txtcreator);
            mTextviewlikes = itemView.findViewById(R.id.like);
            mtags = itemView.findViewById(R.id.txttags);
            munduh = itemView.findViewById(R.id.unduh);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
