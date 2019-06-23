package id.scode.exercise04ReyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.scode.scholarshipexpertscodeidev.R;

/**
 * Created by Dani on 12/23/2018.
 * Yogi Arif Widodo
 */

public class AdapterCardView extends RecyclerView.Adapter<AdapterCardView.CardViewHolder>
{
    private Context context;
    private ArrayList<Presiden> listPresident;

    public AdapterCardView(Context context) {
        this.context = context;
    }

    public ArrayList<Presiden> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<Presiden> listPresident) {
        this.listPresident = listPresident;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_president, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, final int position)
    {


        Presiden presiden = getListPresident().get(position);

        cardViewHolder.tvName.setText(presiden.getName());
        cardViewHolder.tvRemarks.setText(presiden.getRemarks());

        cardViewHolder.btnFav.setOnClickListener(new CustomeOnClickListener(position, new CustomeOnClickListener.OnItemClickCallBack() {
            @Override
            public void onItemClicked(View view, int postition) {
                Toast.makeText(context,"Favorite " +getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        cardViewHolder.btnShare.setOnClickListener(new CustomeOnClickListener(position, new CustomeOnClickListener.OnItemClickCallBack() {
            @Override
            public void onItemClicked(View view, int postition) {
                Toast.makeText(context,"Share" +getListPresident().get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        }));

        Glide.with(context)
                .load(presiden.getPhotos())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }



    public class CardViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName;
        TextView tvRemarks;
        Button btnFav;
        Button btnShare;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo_cardview);
            tvName = itemView.findViewById(R.id.tv_item_name_cardview);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks_cardview);
            btnFav = itemView.findViewById(R.id.btn_favorite_cv);
            btnShare = itemView.findViewById(R.id.btn_share_cv);
        }
    }
}
