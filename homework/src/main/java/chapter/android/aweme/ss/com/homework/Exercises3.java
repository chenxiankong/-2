package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import chapter.android.aweme.ss.com.homework.model.PullParser;
import chapter.android.aweme.ss.com.homework.model.Message;

/**
 * 大作业:实现一个抖音消息页面,
 * 1、所需的data数据放在assets下面的data.xml这里，使用PullParser这个工具类进行xml解析即可
 * <p>如何读取assets目录下的资源，可以参考如下代码</p>
 * <pre class="prettyprint">
 *
 *         @Override
 *     protected void onCreate(@Nullable Bundle savedInstanceState) {
 *         super.onCreate(savedInstanceState);
 *         setContentView(R.layout.activity_xml);
 *         //load data from assets/data.xml
 *         try {
 *             InputStream assetInput = getAssets().open("data.xml");
 *             List<Message> messages = PullParser.pull2xml(assetInput);
 *             for (Message message : messages) {
 *
 *             }
 *         } catch (Exception exception) {
 *             exception.printStackTrace();
 *         }
 *     }
 * </pre>
 * 2、所需UI资源已放在res/drawable-xxhdpi下面
 *
 * 3、作业中的会用到圆形的ImageView,可以参考 widget/CircleImageView.java
 */
public class Exercises3 extends AppCompatActivity implements MyAdapter.ListItemClickListener {
    private RelativeLayout rl1;
    private TextView tv2;

    private  List<Message> messagess=new ArrayList<> (  );

    private RecyclerView MyRecyclerView;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView ( R.layout.activity_tips);

      //    mLifecycleDisplay=findViewById ( R.id.a12 );
          init();
        MyRecyclerView = findViewById ( R.id. rv_list);
          //布局样式
        LinearLayoutManager layoutManager=new LinearLayoutManager ( this );//linner管理器初始化
        layoutManager.setOrientation ( LinearLayoutManager.VERTICAL );//设定为垂直方向
         MyRecyclerView.setLayoutManager ( layoutManager );   //linner管理器与recycleview绑定
          myAdapter=new MyAdapter(this,messagess);
          MyRecyclerView.setAdapter ( myAdapter );

     //      MyRecyclerView.setHasFixedSize ( true );//？？？？

      }
    //读取XML
    public void init() {
        try {
            InputStream assetInput = getAssets().open("data.xml");
            List<Message> messages_temp = PullParser.pull2xml(assetInput);
            for (Message message : messages_temp) {
                messagess.add(message);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent =new Intent();
        intent.putExtra("clickedItemIndex",String.valueOf ( clickedItemIndex ));
        intent.setClass(this,Exercise3_2.class);
        startActivity(intent);
    }
}
