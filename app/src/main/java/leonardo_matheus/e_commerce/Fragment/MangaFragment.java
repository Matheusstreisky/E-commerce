package leonardo_matheus.e_commerce.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import leonardo_matheus.e_commerce.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MangaFragment extends Fragment {
    public MangaFragment() {
        // Required empty public constructor
    }

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //Neste metodo sera "inflado" o fragment com o as caracteristicas do RecyclerView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_manga, container, false);

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerf);
        recyclerView.setHasFixedSize(false);
        FragmentAdapter adapter = new FragmentAdapter(setMangaList());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);


        return rootView;
    }


    public List<Manga> setMangaList() {
        String[] nome = new String[]{"Fullmetal Alchemist", "Hunter x Hunter", "Noragami", "Barakamon"
                , "Evangelion", "Katekyo Hitman Reborn", "Nisekoi", "K-On!"};
        String[] autor = new String[]{"Hiromu Arakawa", "Yoshihiro Togashi", "Adachitoka", "Satsuki Yoshino",
                "Hideaki Anno", "Akira Amano", "Naoshi Komi", "Kakifly"};
        int[] cover = new int[]{R.drawable.fma, R.drawable.hxh, R.drawable.noragami, R.drawable.barakamon
                , R.drawable.eva,  R.drawable.khr, R.drawable.nise, R.drawable.kon};
        List<Manga> mangas = new ArrayList<>();
        for (int i = 0; i < nome.length; i++) {
            Manga manga = new Manga(nome[i % nome.length], autor[i % autor.length], cover[i % cover.length]);
            mangas.add(manga);
        }
        return (mangas);
    }
}
