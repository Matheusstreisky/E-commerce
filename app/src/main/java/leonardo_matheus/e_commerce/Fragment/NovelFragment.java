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
public class NovelFragment extends Fragment {
    public NovelFragment() {
        // Required empty public constructor
    }

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_manga, container, false);

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.recyclerf);
        recyclerView.setHasFixedSize(false);
        FragmentAdapter adapter = new FragmentAdapter(setNovelList());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);


        return rootView;
    }


    public List<Manga> setNovelList() {
        String[] nome = new String[]{"Re:Zero", "No game No Life", "Fate/Zero", "kono subarashii sekai ni shukufuku wo",
                "Shakugan No Shana", "Toradora", "1 Litro de Lágrimas", "Another"};
        String[] autor = new String[]{"Tappey Naqatsuki", "Yuu Kamiya", "Gen Urobuchi", "Natsume Akatsuki",
                "Yashichiro Takahashi", "Yuyuko Takemiya", "Aya Kitou", "Yukito Ayatsuji"};
        int[] cover = new int[]{R.drawable.rezero, R.drawable.ngnl,R.drawable.fate1, R.drawable.konosuba,
                R.drawable.shana, R.drawable.toradora, R.drawable.ichi, R.drawable.another};
        List<Manga> mangas = new ArrayList<>();
        for (int i = 0; i < nome.length; i++) {
            Manga manga = new Manga(nome[i % nome.length], autor[i % autor.length], cover[i % cover.length]);
            mangas.add(manga);
        }
        return (mangas);
    }
}
