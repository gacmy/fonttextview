package com.gac.fonttextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/29.
 */
public class FontTextView extends TextView {
    private Context mcontext;
    private String typefaceName = "";
    private String themeMode = "";

    //自定义属性使用的构造方法
    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mcontext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.FontTextView,defStyleAttr,0);
        int n = a.getIndexCount();
        for(int i = 0; i < n; i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.FontTextView_typefaceName:
                    typefaceName = a.getString(attr);
                    break;
                case R.styleable.FontTextView_themeMode:
                    themeMode = a.getString(attr);
                    break;

            }

        }
        setTypefaceName(typefaceName);
        setThemeMode(themeMode);
        a.recycle();

    }
    public void setThemeMode(String themeMode){
        this.themeMode = themeMode;
        if(themeMode.equals("night")){
            this.setTextColor(Color.WHITE);
            this.setBackgroundColor(Color.BLACK);
        }else if(themeMode.equals("day")){
            this.setTextColor(Color.BLACK);
            this.setBackgroundColor(Color.WHITE);
        }else if(themeMode.equals("") || (themeMode == null)){

        }
    }


    public String getTypefaceName(){
        return typefaceName;
    }
    public void setTypefaceName(String typefaceName){
        this.typefaceName = typefaceName;
        Typeface typeface = Typeface.createFromAsset(mcontext.getAssets(),"fonts/"+typefaceName+".ttf");
        this.setTypeface(typeface);
        System.gc();
    }
    public FontTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FontTextView(Context context) {
        this(context, null);

    }
}
