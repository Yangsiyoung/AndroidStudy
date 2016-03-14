package com.example.yangsiyoung.myapplication.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.yangsiyoung.myapplication.R;
import com.example.yangsiyoung.myapplication.Repo;

import java.util.List;

/**
 * Created by Yang Si Young on 2016-03-14.
 */
public class RepositoryAdapter extends BaseAdapter {

    private Context context;
    private List<Repo> repositoryData;
    private LayoutInflater inflater;

    public RepositoryAdapter(Context context, List<Repo> repositoryData){
        this.context = context;
        this.repositoryData = repositoryData;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return repositoryData.size();
    }

    @Override
    public Object getItem(int position) {
        return repositoryData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            RepositoryViewHolder viewHolder = new RepositoryViewHolder();
            convertView = inflater.inflate(R.layout.list_repositoty_name,parent,false);
            viewHolder.txtRepositoryName = (TextView) convertView.findViewById(R.id.txtRepositoryName);
            convertView.setTag(viewHolder);
        }

        Repo repositoryData = this.repositoryData.get(position);
        RepositoryViewHolder viewHolder = (RepositoryViewHolder) convertView.getTag();

        viewHolder.txtRepositoryName.setText(repositoryData.getName());
        return convertView;
    }

    class RepositoryViewHolder{
        public TextView txtRepositoryName;
    }
}
