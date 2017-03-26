package fr.esilv.jcdecaux.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.esilv.jcdecaux.R;
import fr.esilv.jcdecaux.interfaces.OnContractSelectedListener;
import fr.esilv.jcdecaux.models.Contracts;
import fr.esilv.jcdecaux.models.Example;
import fr.esilv.jcdecaux.models.Item;
import fr.esilv.jcdecaux.viewholders.ContractsViewHolder;

public class ContractsAdapter extends RecyclerView.Adapter<ContractsViewHolder> {

	private final List<Item> examples;
	private OnContractSelectedListener onContractSelectedListener;

	public ContractsAdapter( List<Item> example) {
		this.examples = example;
	}

	@Override
	public ContractsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_contract, parent, false);
		return new ContractsViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ContractsViewHolder holder, int position) {
		holder.setOnContractSelectedListener(onContractSelectedListener);
		holder.bind(examples.get(position));
	}

	@Override
	public int getItemCount() {
		return examples != null ? examples.size() : 0;
	}

	public void setOnContractSelectedListener(OnContractSelectedListener onContractSelectedListener) {
		this.onContractSelectedListener = onContractSelectedListener;
	}
}
