package com.example.uplift.consentisrad;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.uplift.consentisrad.R;

import java.util.ArrayList;

public class ContentWarningDialog extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button yes, no;
    private ArrayList<LinearLayout> cwTags;

    public ContentWarningDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
        cwTags = new ArrayList<LinearLayout>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.content_warning_dialog);
        yes = (Button) findViewById(R.id.btn_yes);
        no = (Button) findViewById(R.id.btn_no);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes:
                //c.finish();
                break;
            case R.id.btn_no:
                for (int i = 0; i < cwTags.size(); i++) {
                    cwTags.remove(i);
                }
                dismiss();
                break; 
            default:
                break;
        }
        dismiss();
    }

    public void createLabel() {
        EditText et = (EditText) findViewById(R.id.cwText);
        LinearLayout warningLabel = new LinearLayout(this.getContext());
        warningLabel.setId(R.id.warningLabel);
        RelativeLayout dialog = (RelativeLayout) findViewById(R.id.dialogCW);

        RelativeLayout.LayoutParams q = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        dialog.addView(warningLabel);

        q.addRule(RelativeLayout.BELOW, et.getId());
        warningLabel.setLayoutParams(q);


        warningLabel.setBackgroundColor(Color.parseColor("#B2EBF2"));

        TextView warningText = new TextView(warningLabel.getContext());
        warningText.setText(et.getText().toString());
        RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        rlp.setMargins(5, 5, 5, 5);
        warningLabel.setLayoutParams(rlp);
        warningLabel.addView(warningText);

        LinearLayout labelForList = new LinearLayout(this.getContext());
        labelForList.setId(R.id.labelForList);
        labelForList.setBackgroundColor(Color.parseColor("#B2EBF2"));
        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setMargins(8, 0, 0, 0);
        TextView warningTextForList = new TextView(warningLabel.getContext());
        warningTextForList.setText(et.getText().toString());
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        llp.setMargins(5, 5, 5, 5);
       labelForList.setLayoutParams(llp);
        labelForList.addView(warningTextForList);

        cwTags.add(labelForList);


        LinearLayout tagList = (LinearLayout) c.findViewById(R.id.cwList);
        tagList.addView(labelForList);
    }
}
