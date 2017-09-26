package com.rock.listviewcheckbox;

import java.util.ArrayList;
import java.util.List;

import com.rock.listviewcheckbox.adapter.CheckAdapter;
import com.rock.listviewcheckbox.adapter.CheckAdapter.OnCheckedChanged;
import com.rock.listviewcheckbox.model.Model;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener,OnCheckedChanged{

	
	private ListView lv;
	
	private CheckAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}
	
	private void initView(){
		lv = (ListView) this.findViewById(R.id.lv);
		adapter = new CheckAdapter(this, getData());
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(this);
		adapter.setListener(this);
	}
	
	private List<Model> getData(){
		List<Model> data = new ArrayList<Model>();
		for (int i = 0; i < 30; i++) {
			Model model = new Model();
			model.setName("我是数据-->" + i);
			data.add(model);
		}
		return data;
	}

	@Override
	public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int position, long paramLong) {
		// TODO Auto-generated method stub
		Log.e("TAG","onItemClick+position-->" + position);
		if (adapter.getItem(position) instanceof Model) {
			if(((Model) adapter.getItem(position)).isChecked()){
				((Model) adapter.getItem(position)).setChecked(false);
			}else{
				((Model) adapter.getItem(position)).setChecked(true);
			};
			adapter.notifyDataSetChanged();
		}
		
	}

	@Override
	public void onCheckedChange(int position) {
		// TODO Auto-generated method stub
		Log.e("TAG","onCheckedChange+position-->" + position);
		if (adapter.getItem(position) instanceof Model) {
			if(((Model) adapter.getItem(position)).isChecked()){
				((Model) adapter.getItem(position)).setChecked(false);
			}else{
				((Model) adapter.getItem(position)).setChecked(true);
			};
			adapter.notifyDataSetChanged();
		}
	}
	
}
