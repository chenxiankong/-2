package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import chapter.android.aweme.ss.com.homework.model.PullParser;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private final ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

   // private Context context;
    private List<Message> datas;
    public MyAdapter(ListItemClickListener listener,List<Message> datas) {
        this.mOnClickListener=listener;
        this.datas=datas;
        viewHolderCount=0;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem =R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MyHolder viewHolder=new MyHolder ( view );
        viewHolderCount++;
       // TextView tv=new TextView ( context );//根布局//--
      //  return viewHolder;

//
//        Context context = viewGroup.getContext();
//        int layoutIdForListItem = R.layout》
//        LayoutInflater inflater = LayoutInflater.from(context);
//        boolean shouldAttachToParentImmediately = false;
//
//        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
//        NumberViewHolder viewHolder = new NumberViewHolder(view);

//        viewHolder.viewHolderIndex.setText("ViewHolder index: " + viewHolderCount);
//
//        int backgroundColorForViewHolder = ColorUtils
//                .getViewHolderBackgroundColorFromInstance(context, viewHolderCount);
//        viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);
//
//        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
//        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder myHolder, int i) {//传数据
           myHolder.bind(datas.get(i));
    }

    @Override
    public int getItemCount() {
        if(datas!=null) return datas.size ();
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final CircleImageView iv_avatars;
        private final ImageView robot_notices;
        private final TextView tv_titles;
        private final TextView tv_descriptions;
        private final TextView tv_times;

        private  TextView mTv;
         public MyHolder(@NonNull View itemView) {
            super ( itemView );
            //关联item组件
            iv_avatars=itemView.findViewById ( R.id.iv_avatar );
            robot_notices=itemView.findViewById ( R.id.robot_notice );
            tv_titles=itemView.findViewById ( R.id.tv_title );
            tv_descriptions=itemView.findViewById ( R.id.tv_description );
            tv_times=itemView.findViewById ( R.id.tv_time );
            itemView.setOnClickListener(this);//设置点击事件
        }
        //给item传入具体数据
        public void bind(Message dataBean) {

             if(dataBean.getIcon ().equals ( "TYPE_ROBOT" )){
                 iv_avatars.setImageResource ( R.drawable.session_robot );
             }
            else if(dataBean.getIcon ().equals ( "TYPE_SYSTEM" )){
                 iv_avatars.setImageResource ( R.drawable.session_system_notice );
             }
            else if(dataBean.getIcon ().equals ( "TYPE_GAME" )){
                 iv_avatars.setImageResource ( R.drawable.icon_micro_game_comment );
             }
            else if(dataBean.getIcon ().equals ( "TYPE_STRANGER" )){
                 iv_avatars.setImageResource (  R.drawable.session_stranger);
             }
            else if(dataBean.getIcon ().equals ( "TYPE_USER" )){
                 iv_avatars.setImageResource ( R.drawable.icon_girl );
             }


            if(dataBean.isOfficial ()) {
                robot_notices.setImageResource (R.drawable.im_icon_notice_official);
                robot_notices.setVisibility ( View.VISIBLE );
            }
            else{
                robot_notices.setVisibility ( View.INVISIBLE );
            }

            tv_titles.setText ( dataBean.getTitle () );
            tv_descriptions.setText ( dataBean.getDescription () );
            tv_times.setText ( dataBean.getTime () );
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }

    }
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
