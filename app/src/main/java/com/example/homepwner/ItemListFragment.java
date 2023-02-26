package com.example.homepwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemListFragment extends Fragment {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private TextView nameTextView;
    private TextView valueTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        recyclerView = (RecyclerView) view
                .findViewById(R.id.item_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        ItemLab itemLab = ItemLab.get(getActivity());
        List<Item> items = itemLab.getItems();
        adapter = new ItemAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Item item;
        public ItemHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_detail, parent, false));
            nameTextView = (TextView) itemView.findViewById(R.id.item_name);
            valueTextView = (TextView) itemView.findViewById(R.id.item_value);
            itemView.setOnClickListener(this);

        }

        public void bind(Item item) {
            this.item = item;
            nameTextView.setText(item.getName());
            valueTextView.setText(String.valueOf("$" + item.getValue()));
        }

        @Override
        public void onClick(View view) {

            DetailsFragment detailsFragment = new DetailsFragment();
            Bundle args = new Bundle();
            args.putString("name", item.getName());
            args.putString("id", item.getId());
            args.putString("date", item.getDate().toString());
            args.putString("value", String.valueOf(item.getValue()));

            detailsFragment.setArguments(args);


            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, detailsFragment);

            fragmentTransaction.commit();



        }
    }


    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        private List<Item> items;

        public ItemAdapter(List<Item> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new ItemHolder(layoutInflater, parent);

        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

            Item item = items.get(position);
            holder.bind(item);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }


}
