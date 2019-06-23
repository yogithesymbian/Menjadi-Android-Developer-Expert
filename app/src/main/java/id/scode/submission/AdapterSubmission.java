package id.scode.submission;

import android.content.Context;

import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import id.scode.exercise04ReyclerView.CustomeOnClickListener;
import id.scode.scholarshipexpertscodeidev.R;

/**
 * Created by Dani on 12/24/2018.
 * Yogi Arif Widodo
 */

public class AdapterSubmission extends RecyclerView.Adapter<AdapterSubmission.AdapterSubmissionHolder>
{
    private Context context;
    private ArrayList<BookSubmission> listBookSubmission;

    public AdapterSubmission(Context context)
    {
        this.context = context;
    }


    public ArrayList<BookSubmission> getListBookSubmission() {
        return listBookSubmission;
    }

    public void setListBookSubmission(ArrayList<BookSubmission> listBookSubmission) {
        this.listBookSubmission = listBookSubmission;
    }

    @NonNull
    @Override
    public AdapterSubmissionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewNaBuku = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_submission_yostyle, parent, false);
        return new AdapterSubmissionHolder(viewNaBuku);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSubmissionHolder adapterSubmissionHolder, int position) {

        BookSubmission bookSubmission = getListBookSubmission().get(position);

        adapterSubmissionHolder.news.setText(bookSubmission.getNewsOlder());


        adapterSubmissionHolder.simpanBuku.setOnClickListener(new CustomeOnClickListener(position, new CustomeOnClickListener.OnItemClickCallBack() {
            @Override
            public void onItemClicked(View view, int postition) {
//                Toast.makeText(context,"Buku : " +getListBookSubmission().get(position).getJudulBuku() + " [Tersimpan] " , Toast.LENGTH_SHORT).show();
                Snackbar snackbar = Snackbar
                        .make(view, "[Buku Tersimpan] " +getListBookSubmission().get(position).getJudulBuku() , Snackbar.LENGTH_LONG)
//                        .make(view, "Buku " +getListBookSubmission().get(position).getJudulBuku() + " [Tersimpan] " , Snackbar.LENGTH_LONG)
                        .setAction("BATAL", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(view, "[Unsaved Book] " +getListBookSubmission().get(position).getJudulBuku() , Snackbar.LENGTH_LONG);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
            }
        }));
        adapterSubmissionHolder.cardView.setOnClickListener(new CustomeOnClickListener(position, new CustomeOnClickListener.OnItemClickCallBack() {
            @Override
            public void onItemClicked(View view, int postition) {

//
//                Intent intent = null;
//                switch (position)
//                {
//                    case 0:
//                        FullscreenActivity fullscreenActivity = new FullscreenActivity();
//                        fullscreenActivity.hrgBuku.setText("40000");
//                        intent = new Intent(context, FullscreenActivity.class);
//                        break;
//                }
//                context.startActivity(intent);


//                FullscreenActivity fullscreenActivity = new FullscreenActivity();
//
//                BookSubmission bookSubmission = new BookSubmission();
//                bookSubmission.setHrgBuku(getListBookSubmission().get(position).getHrgBuku());
//
//                Intent moveWithPojo = new Intent(context, FullscreenActivity.class);
//                moveWithPojo.putExtra(FullscreenActivity.EXTRA_BOOK, bookSubmission);
//
//                fullscreenActivity.startActivity(moveWithPojo);




//
//                Intent moveWithObjetPojo = new Intent(IntentScodExercise.this, MoveWithPojo.class);
//                moveWithObjetPojo.putExtra(MoveWithPojo.EXTRA_PERSON, myPersonPojoCalling);
//                startActivity(moveWithObjetPojo);
            }
        }));

        Glide.with(context)
                .load(bookSubmission.getSpoiler())
                .apply(new RequestOptions().override(400, 230))
                .into(adapterSubmissionHolder.imageView);


    }

    @Override
    public int getItemCount() {
        return getListBookSubmission().size();
    }

    class AdapterSubmissionHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        ImageView imgFull;
        TextView news;
        TextView simpanBuku;
        CardView cardView;

        AdapterSubmissionHolder(@NonNull View bookView)
        {
            super(bookView);
            imageView = bookView.findViewById(R.id.item_photo_cardview_submission);
            news = bookView.findViewById(R.id.news_tv);
            simpanBuku = bookView.findViewById(R.id.simpanBuku);
            imgFull = bookView.findViewById(R.id.item_photo_book_full);
            cardView = bookView.findViewById(R.id.card_view_submission);

            context = bookView.getContext();
        }
    }
}
