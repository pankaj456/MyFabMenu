package com.shawon.yousuf.myfabmenu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.shawon.yousuf.myfabmenu.R;


/**
 * Created by Yousuf on 7/25/2016.
 */


public class DialogFabMenu {

    private Dialog dialog;


    public interface OnSelect{
        public void onAddSelect();
        public void onSettingSelect();

    }

    OnSelect mOnSelect;



    public DialogFabMenu(Context mContext) {

        dialog = new Dialog(mContext);
        // it remove the dialog title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // set the laytout in the dialog
        dialog.setContentView(R.layout.layout_fab_menu);

        // set the background partial transparent
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
       // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(mContext.getResources().getColor(R.color.colorPrimary)));
        Window window = dialog.getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        // set the layout at right bottom
        param.gravity = Gravity.BOTTOM | Gravity.RIGHT;
        // it dismiss the dialog when click outside the dialog frame
        dialog.setCanceledOnTouchOutside(true);

        // initialize the item of the dialog box, whose id is demo1
        View viewFab =(View) dialog.findViewById(R.id.fab);
        View viewFabMenuAdd = dialog.findViewById(R.id.fabAdd);
        View viewFabMenuSetting = dialog.findViewById(R.id.fabSetting);

        TextView textViewFabMenuAdd = (TextView) dialog.findViewById(R.id.textViewFabMenuAdd);
        TextView textViewFabMenuSetting = (TextView) dialog.findViewById(R.id.textViewFabMenuSetting);




// it call when click on the item whose id is demo1.
        viewFab.setOnClickListener(menuSelectListener);

        viewFabMenuAdd.setOnClickListener(menuSelectListener);
        textViewFabMenuAdd.setOnClickListener(menuSelectListener);

        viewFabMenuSetting.setOnClickListener(menuSelectListener);
        textViewFabMenuSetting.setOnClickListener(menuSelectListener);


    }



    View.OnClickListener menuSelectListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.fab:
                    dialog.dismiss();
                    break;

                case R.id.fabAdd:
                    if( mOnSelect!= null ){
                        mOnSelect.onAddSelect();
                        dialog.dismiss();
                    }
                    break;

                case R.id.textViewFabMenuAdd:
                    if( mOnSelect!= null ){
                        mOnSelect.onAddSelect();
                        dialog.dismiss();
                    }
                    break;

                case R.id.fabSetting:
                    if (mOnSelect != null) {
                        mOnSelect.onSettingSelect();
                        dialog.dismiss();
                    }
                    break;

                case R.id.textViewFabMenuSetting:
                    if (mOnSelect != null) {
                        mOnSelect.onSettingSelect();
                        dialog.dismiss();
                    }
                    break;
            }
        }
    };


    public void setOnSelectListener(OnSelect onSelect){
        this.mOnSelect = onSelect;
    }


    public void show(){

        if (dialog != null) {
            // it show the dialog box
            dialog.show();
        }
    }


}
