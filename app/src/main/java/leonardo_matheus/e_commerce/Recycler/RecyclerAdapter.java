package leonardo_matheus.e_commerce.Recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import leonardo_matheus.e_commerce.R;

/**
 * Created by leoal on 03/10/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    public static ClickRecyclerView_Interface clickRecyclerViewInterface;
    Context mctx;
    private List<Manga> mList;
    private LayoutInflater mLayoutInflater;

    public RecyclerAdapter(Context ctx, List<Manga> list, ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.mList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
        this.mLayoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Precisamos setar no adapter qual é o layout que o item, que está sendo populado, irá possuir.
    // instanciamos a view e passamos justamente como parâmetro o layout do item;
    //onCreateViewHolder é o responsavel pela criação das Views
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.activity_manga, viewGroup, false);
        return new RecyclerViewHolder(v);

    }

    //onBindViewHolder serve para setar valor na nossa List na view
    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {

        viewHolder.imageView.setImageResource(mList.get(i).getCover());
        viewHolder.viewNome.setText(mList.get(i).getNome());
        viewHolder.viewAutor.setText(mList.get(i).getAutor());
    }

    //
    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void addListItem(Manga m, int position) {
        mList.add(m);
        notifyItemInserted(position);
    }


    public void removeListItem(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView viewNome;
        public TextView viewAutor;
        public ImageView imageView;

        public RecyclerViewHolder(final View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.manga_cover);
            viewNome = itemView.findViewById(R.id.manga_nome);
            viewAutor = itemView.findViewById(R.id.manga_autor);


            //Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));

                }
            });
        }
    }
}

