package cn.xiaojii.dapu.Fragment.TopBar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.joanzapata.pdfview.PDFView;

import cn.xiaojii.dapu.Fragment.BaseFragment.BaseFragment;
import cn.xiaojii.dapu.R;

public class FragmentPdfReadPdf extends BaseFragment implements View.OnClickListener {
    private String filename;
    private PDFView pdfView;
    private Button leftButton;

    @SuppressLint("ValidFragment")
    public FragmentPdfReadPdf(String filename) {
        this.filename = filename;
    }

    public FragmentPdfReadPdf() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_bar_pdf_read_pdf, null);
        pdfView = view.findViewById(R.id.id_pdf_read_view);
        pdfView.fromAsset(filename)
                .defaultPage(1)
                .swipeVertical(true)
                .showMinimap(false)
                .enableSwipe(true)
                .load();
        view.findViewById(R.id.id_top_center).setVisibility(View.GONE);
        view.findViewById(R.id.id_top_right).setVisibility(View.GONE);
        leftButton = view.findViewById(R.id.id_top_left);
        leftButton.setText("<资料");
        leftButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_top_left:
                onBack();
                break;

        }
    }
}
