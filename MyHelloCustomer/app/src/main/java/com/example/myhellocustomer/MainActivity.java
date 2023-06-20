package com.example.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタンオブジェクトの用意
        Button btClick = findViewById(R.id.btClick);
        //リスナオブジェクトの用意
        HelloListener Listener =new HelloListener();
        //ボタンにリスナを設定
        btClick.setOnClickListener(Listener);

        //クリアボタンであるButtonオブジェクトを取得
        Button btAdclear=findViewById(R.id.btAdclear);
        Button btNmclear=findViewById(R.id.btNmclear);
        //クリアボタンにリスナを設定
        btAdclear.setOnClickListener(Listener);
        btNmclear.setOnClickListener(Listener);
    }

    //ボタンをクリックしたときのリスナクラス
    private class HelloListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //名前入力欄であるEditTextオブジェクトを取得
            EditText inputN = findViewById(R.id.etName);
            EditText inputA = findViewById(R.id.etAddress);
            //メッセージを表示するTextViewオブジェクトを取得
            TextView output = findViewById(R.id.tvOutput);

            //タップされた画面部品のidのR値を取得
            int id = view.getId();
            //idのR値に応じて処理を分岐
            if(id==R.id.btClick){
                //入力された名前文字列を取得
                String inputStrN = inputN.getText().toString();
                String inputStrA = inputA.getText().toString();

                //メッセージを表示
                output.setText(inputStrA+"にお住いの" +inputStrN + "さん、こんにちは！");
            }else if (id==R.id.btNmclear){
                //名前入力欄を空文字に設定
                inputN.setText("");
            }else if (id==R.id.btAdclear){
                //住所入力欄を空文字に設定
                inputA.setText("");
            }
        }
    }
}