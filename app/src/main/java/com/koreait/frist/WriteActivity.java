package com.koreait.frist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class WriteActivity extends AppCompatActivity {

    private EditText etMsg;
    private Button btnSend;
    private RecyclerView rvList; // view 영역

    private List<String> msgList; // data
    private SimpleTextAdapter sta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        etMsg = findViewById(R.id.etMsg); // 연결됐다라고 생각.
        btnSend = findViewById(R.id.btnSend);
        rvList = findViewById(R.id.rvList);

        msgList = new LinkedList<>();


        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvList.setLayoutManager(llm); //위에서 아래로 vertical



        sta = new SimpleTextAdapter(msgList);
        rvList.setAdapter(sta);


        //1. class 작성필요
        View.OnClickListener event2 = new MyOnClickListener();
        btnSend.setOnClickListener(event2);

        //2. 변수 할당 필요
        View.OnClickListener event = new View.OnClickListener() {
            @Override
            public void onClick(View v) {}
        };
        btnSend.setOnClickListener(event);

        //3. 가장 간략하게 작성(가장 많이 씀)
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// 콜백 메소드(Call Back)
                String msg = etMsg.getText().toString();
                Log.i("myLog", msg);
                etMsg.setText("");
                msgList.add(msg);
                //sta.notifyDataSetChanged();
            }
        });
    }

    public void refresh(View v){
        sta.notifyDataSetChanged();
    }
}
//  1번에 필요한 클래스.
class MyOnClickListener implements View.OnClickListener{

    @Override
    public void onClick(View v) {

    }
}

class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.MyViewHolder>{
    private List<String> list;

    SimpleTextAdapter(List<String> list){
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_textview,parent,false);
        return new SimpleTextAdapter.MyViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder  holder, int position) {
        Log.i("myLog","position : "+ position);
        String str = list.get(position);
        holder.tvMsg.setText(str);

    }

    @Override
    public int getItemCount() {
        Log.i("myLog","getItemCount : "+ list.size());
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvMsg;

        public MyViewHolder(View v){
            super(v);
            tvMsg = v.findViewById(R.id.tvMsg);
        }
    }
}
