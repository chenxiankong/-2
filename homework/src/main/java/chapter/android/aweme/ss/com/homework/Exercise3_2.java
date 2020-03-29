package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Exercise3_2 extends AppCompatActivity {
    private  String clickedItemIndex;
    private TextView tv_count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView (R.layout.activity_chatroom );
        clickedItemIndex = getIntent().getStringExtra("clickedItemIndex");
        tv_count=findViewById ( R.id.tv_content_info );
        tv_count.setText ( "这是第"+clickedItemIndex+"个Item" );

    }
}
