package fr.esilv.jcdecaux.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.esilv.jcdecaux.R;
import fr.esilv.jcdecaux.interfaces.OnContractSelectedListener;
import fr.esilv.jcdecaux.models.Contract;
import fr.esilv.jcdecaux.models.Example;
import fr.esilv.jcdecaux.models.Item;

public class ContractsViewHolder extends RecyclerView.ViewHolder {

	private TextView title;
	private TextView description;
	private ImageView img;

	private OnContractSelectedListener onContractSelectedListener;

	public ContractsViewHolder(View itemView) {
		super(itemView);
		title = (TextView) itemView.findViewById(R.id.name);
		description = (TextView) itemView.findViewById(R.id.contract_name);
		img = (ImageView) itemView.findViewById(R.id.img);
	}

	public void bind(final Item item) {
		title.setText(item.getSnippet().getChannelTitle());
		description.setText(item.getSnippet().getDescription());
		Picasso.with(itemView.getContext()).load(item.getSnippet().getThumbnails().getMedium().getUrl()).into(img);



		itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onContractSelectedListener == null) {
					return;
				}
				onContractSelectedListener.onContractSelected(item);
			}
		});
	}

	public void setOnContractSelectedListener(OnContractSelectedListener onContractSelectedListener) {
		this.onContractSelectedListener = onContractSelectedListener;
	}
}
