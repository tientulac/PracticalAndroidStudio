package com.example.practical.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practical.MainActivity;
import com.example.practical.entity.Bookmark;
import com.example.practical.R;
import com.example.practical.entity.Product;
import com.example.practical.room.AppDatabase;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<Product> listFunctions;
    private Activity activity;
    Context ctx;
    AppDatabase db;

    public ListViewAdapter(List<Product> listFunctions, Activity activity) {
        this.listFunctions = listFunctions;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return listFunctions.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_list_view, parent, false);
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView)convertView.findViewById(R.id.tvName);
            holder.tvCode = (TextView)convertView.findViewById(R.id.tvCode);
            holder.ivAvatar = (ImageView)convertView.findViewById(R.id.ivAvatar);
            holder.btnDelete = (Button)convertView.findViewById(R.id.buttonDelete);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Product model = listFunctions.get(position);
        holder.tvName.setText(model.name);
        holder.tvCode.setText(String.valueOf(model.quantity));
//        holder.ivAvatar.setImageResource(model.getFunctionID());
//        Button btnDelete = (Button) convertView.findViewById(R.id.buttonDelete);
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                db = AppDatabase.getAppDatabase(ctx);
//                int id_deleted = model.id;
//                System.out.println(id_deleted);
//                db.bookmarkDao().deleteBookmark(id_deleted);
//                CharSequence charSequence = "Delete Successfully !!!";
//                Toast toast = Toast.makeText(activity.getApplication(), charSequence, Toast.LENGTH_LONG);
//                toast.show();
//            }
//        });

        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvCode;
        ImageView ivAvatar;
        Button btnDelete;
    }
}
