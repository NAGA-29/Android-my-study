package android.wings.websarva.mytest01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //保存
        Button btClick = findViewById(R.id.bt_Save);
        //クリアボタン
        Button btClear = findViewById(R.id.bt_Clear);
        //ListViewオブジェクトを取得
        ListView lvMenu = findViewById(R.id.sp_drinkList);

        HelloListener listener = new HelloListener();

        btClick.setOnClickListener(listener);

        btClear.setOnClickListener(listener);
        //ListViewにリスナを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());

    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?>parent, View view, int position, long id){
            //タップされたドリンク名を取得
            String item = (String) parent.getItemAtPosition(position);
            //トーストで表示する文字列を生成
            String show = "あなたが選んだ定食:" + item;

            Toast.makeText(MyMainActivity.this,show,Toast.LENGTH_LONG).show();
        }
    }

    private class HelloListener implements View.OnClickListener{

        @Override
        public void onClick(View view){
            EditText input = findViewById(R.id.input_name);

            TextView output = findViewById(R.id.output_name);

            int id = view.getId();

            switch(id) {
                case R.id.bt_Save:
                    String inputStr = input.getText().toString();
                    output.setText(inputStr + "さん、こんにちは！");
                    break;
                case R.id.bt_Clear:
                    input.setText("");
                    output.setText("");
                    break;
                }
        }
    }
}
