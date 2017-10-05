package leonardo_matheus.e_commerce.Recycler;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import leonardo_matheus.e_commerce.R;

public class RecyclerMain extends AppCompatActivity implements ClickRecyclerView_Interface {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerAdapter adapter;
    private List<Manga> mangaList = new ArrayList<>();
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        setRecyclerView();

        setButtons();
        listenersButtons();
    }


    private void setRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerAdapter(this, mangaList, this);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager llm = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                RecyclerAdapter adapter = (RecyclerAdapter) mRecyclerView.getAdapter();

                if (mangaList.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {
                    List<Manga> listAux = setMangaList(10);

                    for (int i = 0; i < listAux.size(); i++) {
                        adapter.addListItem(listAux.get(i), mangaList.size());
                    }
                }
            }
        });

    }

    private void setButtons() {
        floatingActionButton = (FloatingActionButton) findViewById(R.id.buttonr);
    }

    private void listenersButtons() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Manga manga = new Manga();

                //Adiciona o manga e avisa o adapter que o conteúdo
                //da lista foi alterado
                mangaList.add(manga);
                adapter.notifyDataSetChanged();

            }
        });
    }


    /**
     * Aqui é o método onde trata o clique em um item da lista
     */

    @Override
    public void onCustomClick(Object object) {
        Manga manga = (Manga) object;
        String nome = manga.getNome();
        String autor = manga.getAutor();

    }


    public List<Manga> setMangaList(int qnt) {
        String[] nome = new String[]{"Re:Zero", "Fullmetal Alchemist", "Hunter x Hunter", "Noragami", "Barakamon"
                , "Evangelion", "No game No Life", "Katekyo Hitman Reborn", "Fate/Zero", "Nisekoi"};
        String[] autor = new String[]{"Tappey Naqatsuki", "Hiromu Arakawa", "Yoshihiro Togashi", "Adachitoka", "Satsuki Yoshino",
                "Hideaki Anno", "Yuu Kamiya", "Akira Amano", "Gen Urobuchi", "Naoshi Komi"};
        int[] cover = new int[]{R.drawable.rezero, R.drawable.fma, R.drawable.hxh, R.drawable.noragami, R.drawable.barakamon
                , R.drawable.eva, R.drawable.ngnl, R.drawable.khr, R.drawable.fate1, R.drawable.nise};
        List<Manga> mangas = new ArrayList<>();
        for (int i = 0; i < qnt; i++) {
            Manga manga = new Manga(nome[i % nome.length], autor[i % autor.length], cover[i % cover.length]);
            mangas.add(manga);
        }
        return (mangas);
    }
}
