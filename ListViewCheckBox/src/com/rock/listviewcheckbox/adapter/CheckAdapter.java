package com.rock.listviewcheckbox.adapter;

import java.util.List;

import com.rock.listviewcheckbox.R;
import com.rock.listviewcheckbox.model.Model;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class CheckAdapter extends BaseAdapter implements OnClickListener{

	private List<Model> data;
	
	private LayoutInflater inflater;
	
	OnCheckedChanged listener;
	
	public CheckAdapter(Context context,List<Model> data) {
		// TODO Auto-generated constructor stub
		this.data = data;
		inflater = LayoutInflater.from(context);
	}
	
	public void setListener(OnCheckedChanged listener){
		this.listener = listener;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data != null ? data.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item, parent,false);
			holder.chekbox = (CheckBox) convertView.findViewById(R.id.checkbox);
			holder.name = (TextView) convertView.findViewById(R.id.name);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		//初始化数据
		holder.chekbox.setChecked(data.get(position).isChecked());
		
		holder.chekbox.setTag(position);
		holder.chekbox.setOnClickListener(this);
		
		holder.name.setText(data.get(position).getName());
		return convertView;
	}
	
	private static class ViewHolder{
		CheckBox chekbox;
		TextView name;
	}

	
	public interface OnCheckedChanged{
		
		void onCheckedChange(int position);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		listener.onCheckedChange((Integer) v.getTag());
	}

}
