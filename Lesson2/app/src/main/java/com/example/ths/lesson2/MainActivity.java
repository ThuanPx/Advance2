package com.example.ths.lesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Annotation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.bt0)
    Button bt0;
    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.bt3)
    Button bt3;
    @BindView(R.id.bt4)
    Button bt4;
    @BindView(R.id.bt5)
    Button bt5;
    @BindView(R.id.bt6)
    Button bt6;
    @BindView(R.id.bt7)
    Button bt7;
    @BindView(R.id.bt8)
    Button bt8;
    @BindView(R.id.bt9)
    Button bt9;
    @BindView(R.id.tvHienThi)
    TextView tvHienThi;
    @BindView(R.id.btCong)
    Button btCong;
    @BindView(R.id.btChia)
    Button btChia;
    @BindView(R.id.btNhan)
    Button btNhan;
    @BindView(R.id.btTru)
    Button btTru;
    @BindView(R.id.btKetQua)
    Button btKQ;
    @BindView(R.id.btAC)
    Button btAC;
    @BindView(R.id.btC)
    Button btC;
    @BindView(R.id.btCham)
    Button btCham;
    float kq;
    String hienThi;
    int check;
    boolean checkClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        kq = 0;
        hienThi = " ";
        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btKQ.setOnClickListener(this);
        btCong.setOnClickListener(this);
        btTru.setOnClickListener(this);
        btNhan.setOnClickListener(this);
        btChia.setOnClickListener(this);
        btAC.setOnClickListener(this);
        btC.setOnClickListener(this);
        btCham.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt0:
                checkClick = true;
                hienThi += "0";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt1:
                checkClick = true;
                hienThi += "1";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt2:
                checkClick = true;
                hienThi += "2";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt3:
                checkClick = true;
                hienThi += "3";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt4:
                checkClick = true;
                hienThi += "4";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt5:
                checkClick = true;
                hienThi += "5";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt6:
                checkClick = true;
                hienThi += "6";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt7:
                checkClick = true;
                hienThi += "7";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt8:
                checkClick = true;
                hienThi += "8";
                tvHienThi.setText(hienThi);
                break;
            case R.id.bt9:
                checkClick = true;
                hienThi += "9";
                tvHienThi.setText(hienThi);
                break;
            case R.id.btAC:
                checkClick = false;
                kq = 0;
                check = 0;
                hienThi = " ";
                tvHienThi.setText(" ");
                break;
            case R.id.btCong:
                if (checkClick) {
                    check = 1;
                    kq = Float.parseFloat(tvHienThi.getText().toString());
                    tvHienThi.setText(" ");
                    hienThi = " ";
                }
                break;
            case R.id.btTru:
                if (checkClick) {
                    check = 2;
                    kq = Float.parseFloat(tvHienThi.getText().toString());
                    tvHienThi.setText(" ");
                    hienThi = " ";
                }
                break;
            case R.id.btNhan:
                if (checkClick) {
                    check = 3;
                    kq = Float.parseFloat(tvHienThi.getText().toString());
                    tvHienThi.setText(" ");
                    hienThi = " ";
                }
                break;
            case R.id.btChia:
                if (checkClick) {
                    check = 4;
                    kq = Float.parseFloat(tvHienThi.getText().toString());
                    tvHienThi.setText(" ");
                    hienThi = " ";
                }
                break;
            case R.id.btC:
                tvHienThi.setText(" ");
                break;
            case R.id.btKetQua:
                switch (check) {
                    case 1:
                        kq += Float.parseFloat(tvHienThi.getText().toString());
                        tvHienThi.setText(kq + " ");
                        break;
                    case 2:
                        kq -= Float.parseFloat(tvHienThi.getText().toString());
                        tvHienThi.setText(kq + " ");
                        break;
                    case 3:
                        kq *= Float.parseFloat(tvHienThi.getText().toString());
                        tvHienThi.setText(kq + " ");
                        break;
                    case 4:
                        kq /= Float.parseFloat(tvHienThi.getText().toString());
                        tvHienThi.setText(kq + " ");
                        break;
                }
                break;
            case R.id.btCham:
                if (checkClick) {
                    hienThi += ".";
                    tvHienThi.setText(hienThi);
                }
                break;
        }
    }
}
