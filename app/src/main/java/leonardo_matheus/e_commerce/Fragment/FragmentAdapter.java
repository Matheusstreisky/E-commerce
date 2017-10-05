package leonardo_matheus.e_commerce.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import leonardo_matheus.e_commerce.R;
import leonardo_matheus.e_commerce.Recycler.Manga;

/**
 * Created by leoal on 05/10/2017.
 */

public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.MyViewHolder> {
    private String[] mDataset;
    private List<Manga> mangaList;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //public TextView textNome;

        public TextView viewNome;
        public TextView viewAutor;
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.manga_cover);
            viewNome = itemView.findViewById(R.id.manga_nome);
            viewAutor = itemView.findViewById(R.id.manga_autor);

        }
    }
//
//    public FragmentAdapter(String[] mDataset) {
//        this.mDataset = mDataset;
//    }

    public FragmentAdapter(List<Manga> mangaList) {
        this.mangaList = mangaList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_manga, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.imageView.setImageResource(mangaList.get(position).getCover());
        holder.viewNome.setText(mangaList.get(position).getNome());
        holder.viewAutor.setText(mangaList.get(position).getAutor());
    }


    @Override
    public int getItemCount() {
        return mangaList.size();
    }

}
