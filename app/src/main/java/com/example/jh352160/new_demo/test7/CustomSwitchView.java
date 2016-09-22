package com.example.jh352160.new_demo.test7;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.example.jh352160.new_demo.R;
import com.example.jh352160.new_demo.test7.network.CommonRetrofit;
import com.example.jh352160.new_demo.test7.network.GankItem;
import com.example.jh352160.new_demo.test7.network.GankService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static java.lang.Thread.currentThread;

/**
 * Created by jh352160 on 2016/9/12.
 */

public class CustomSwitchView extends LinearLayout{

    Context context;
    //Button button;
    ViewPager viewPager;
    RecyclerView recyclerView;
    List<String> allImageUrlList;
    List<String> imageUrlList;
    static int current=0;
    GridLayoutManager layoutManager;
    SwipeToLoadLayout swipeToLoadLayout;
    int page=0;
    ViewPagerAdapter viewPagerAdapter;
    float mFirstY=0,mCurrentY=0,mTouchSlop=1;
    int mDirection=0;

    private static final int NETWORK_OK = 0;
    private static final int LIST_CHANGE = 1;
    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case NETWORK_OK:
//                    init();
                    break;
                case LIST_CHANGE:
                    addList(++page);
                    break;
            }
        }
    };

    public CustomSwitchView(Context context) {
        this(context,null);
    }

    public CustomSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        //LinearLayout.inflate(context, R.layout.test7_view,null);
        LayoutInflater.from(context).inflate(R.layout.test7_view, this);
        //button=(Button)findViewById(R.id.button);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        recyclerView=(RecyclerView)findViewById(R.id.swipe_target);
        swipeToLoadLayout=(SwipeToLoadLayout)findViewById(R.id.swipetoload);
        imageUrlList=new ArrayList<>();

        //api
        Retrofit retrofit= CommonRetrofit.getRetrofit();
        GankService gankService=retrofit.create(GankService.class);
        Call<GankItem> call=gankService.getItem(100,1);
        call.enqueue(new Callback<GankItem>() {
            @Override
            public void onResponse(Call<GankItem> call, Response<GankItem> response) {
                Log.i("Message",currentThread().getName());
                allImageUrlList =new ArrayList<>();
                for (int i = 0; i < response.body().getResults().size(); i++) {
                    allImageUrlList.add(response.body().getResults().get(i).getUrl());
                }
//                Message message=new Message();
//                message.what=NETWORK_OK;
//                handler.sendMessage(message);
                init();
            }

            @Override
            public void onFailure(Call<GankItem> call, Throwable t) {

            }
        });
    }

    private void init(){
        layoutManager=new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter recyclerViewAdapter=new RecyclerViewAdapter(context, imageUrlList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

        viewPagerAdapter=new ViewPagerAdapter(context, imageUrlList);
        viewPager.setAdapter(viewPagerAdapter);
        //viewPagerAdapter.notifyDataSetChanged();

        page=0;
        current=0;
        addList(page);

        setListener();
        setLoadMore();
    }

    private void setListener(){

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(viewPager.getVisibility()==View.VISIBLE){
//                    viewPager.setVisibility(View.GONE);
//                    swipeToLoadLayout.setVisibility(View.VISIBLE);
//                    recyclerView.scrollToPosition(current);
//                }else{
//                    swipeToLoadLayout.setVisibility(View.GONE);
//                    viewPager.setVisibility(View.VISIBLE);
//                    viewPager.setCurrentItem(current);
//                }
//            }
//        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                CustomSwitchView.current=position;
                if ((position+4)>imageUrlList.size()){
                    addList(++page);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState== RecyclerView.SCROLL_STATE_IDLE){
                    current=layoutManager.findFirstVisibleItemPosition();
                }
            }
        });
    }

    private void setLoadMore(){
        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        Message message=new Message();
                        message.what=LIST_CHANGE;
                        handler.sendMessage(message);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);
                        swipeToLoadLayout.setLoadingMore(false);
                    }
                }.execute();
            }
        });
    }

    private void addList(int page){
        if ((page*10+10)<allImageUrlList.size()){
            imageUrlList.addAll(allImageUrlList.subList(page * 10, page * 10 + 10));
        }else if(imageUrlList.size()!=allImageUrlList.size()){
            imageUrlList.addAll(allImageUrlList.subList(page * 10, allImageUrlList.size()));
        }else{
            Toast.makeText(context,"已经加载完成............",Toast.LENGTH_SHORT).show();
        }
        /**
         * After ADT 22 the PagerAdapter has gotten very strict about calling notifyDataSetChanged() before calling getCount().
         * It evidently keeps track of what it thinks the count should be and if this is not the same as what getCount() returns it throws this exception.
         * So the solution is simply to call notifyDataSetChanged() on the adapter every time the size of the data changes.
         *
         * 在adt22之后，PagerAdapter对于notifyDataSetChanged()和getCount()的执行顺序是非常严格的，
         * 系统跟踪count的值，如果这个值和getCount返回的值不一致，就会抛出这个异常。
         * 所以为了保证getCount总是返回一个正确的值，
         * 那么在初始化ViewPager时，应先给Adapter初始化内容后再将该adapter传给ViewPager，如果不这样处理，
         * 在更新adapter的内容后，应该调用一下adapter的notifyDataSetChanged方法。
         */
        viewPagerAdapter.notifyDataSetChanged();
    }

    public void switchView(){
        if(viewPager.getVisibility()== View.VISIBLE){
            viewPager.setVisibility(View.GONE);
            swipeToLoadLayout.setVisibility(View.VISIBLE);
            recyclerView.scrollToPosition(current);
        }else{
            swipeToLoadLayout.setVisibility(View.GONE);
            viewPager.setVisibility(View.VISIBLE);
            viewPager.setCurrentItem(current);
        }
    }

    public void changeData(List<String> allImageUrlList){
        this.allImageUrlList=allImageUrlList;
        imageUrlList=new ArrayList<>();
        init();
    }

}
