package id.scode.selfTaught_FancyShowCaseView;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import me.toptas.fancyshowcase.FancyShowCaseView;
import id.scode.scholarshipexpertscodeidev.R;
import me.toptas.fancyshowcase.listener.OnViewInflateListener;

public class FancyMain extends AppCompatActivity implements View.OnClickListener {
    Button btnNoFocus, btnFocus, btnLarger, btnColor, btnLongerText, btnCusAnim, btnCusView;

    FancyShowCaseView mFancy;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_show_case_view);

        btnNoFocus = findViewById(R.id.btnNoFocus);
        btnNoFocus.setOnClickListener(this);

        btnFocus = findViewById(R.id.btnFocus);
        btnFocus.setOnClickListener(this);

        btnLarger = findViewById(R.id.btnLarger);
        btnLarger.setOnClickListener(this);

        btnColor = findViewById(R.id.btnColor);
        btnColor.setOnClickListener(this);

        btnLongerText = findViewById(R.id.btnLongerText);
        btnLongerText.setOnClickListener(this);

        btnCusAnim = findViewById(R.id.btnCusAnim);
        btnCusAnim.setOnClickListener(this);

        btnCusView = findViewById(R.id.btnCusView);
        btnCusView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.btnNoFocus:
                new FancyShowCaseView.Builder(this)
                        .title("No Focus")
                        .build()
                        .show();
                break;
            case R.id.btnFocus:
                new FancyShowCaseView.Builder(this)
                        .title("Focus on")
                        .focusOn(v)
                        .build()
                        .show();
                break;
            case R.id.btnLarger:
                new FancyShowCaseView.Builder(this)
                        .title("Focus on View With Larger circle")
                        .focusOn(v)
                        .focusCircleRadiusFactor(2.0)
                        .build()
                        .show();
                break;
            case R.id.btnLongerText:
                new FancyShowCaseView.Builder(this)
                        .title("Focus on View with larger view")
                        .titleStyle(0, Gravity.TOP)
                        .focusOn(v)
                        .build()
                        .show();
                break;
            case R.id.btnColor:
                new FancyShowCaseView.Builder(this)
                        .title("Background Color")
                        .titleStyle(R.style.myStyleText, Gravity.TOP | Gravity.CENTER)
                        .focusOn(v)
                        .build()
                        .show();
                break;
            case R.id.btnCusAnim:
                showViewCaseWithAnim(v);
                break;
            case R.id.btnCusView:
                showViewCaseCustome(v);
                break;
        }
    }

    private void showViewCaseCustome(View v)
    {
        FancyShowCaseView.Builder builder = new FancyShowCaseView.Builder(this);
        builder.focusOn(v);
        builder.customView(R.layout.for_showcase_fancy, view -> view.findViewById(R.id.btnClose).setOnClickListener(v1 -> {
            mFancy.hide();
        }));
        builder.closeOnTouch(false);
        builder.build();//                .focusOn(v)
//                .customView(R.layout.for_showcase_fancy, new OnViewInflateListener() {
//                    @Override
//                    public void onViewInflated(View view) {
//                        view.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                mFancy.hide();
//                            }
//                        });
//                    }
//                })
        mFancy.show();
    }

    private void showViewCaseWithAnim(View v)
    {
        Animation animationEnter = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        Animation animationExit = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);

        final FancyShowCaseView fancyShowCaseView = new FancyShowCaseView.Builder(this)
//                .focusOn(v)
                .title("Custome Enter and Exit Animation")
                .enterAnimation(animationEnter)
                .exitAnimation(animationExit)
                .build();
        fancyShowCaseView.show();
        animationExit.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fancyShowCaseView.removeView();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
