package customview.learn.com.seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class HSeeakBar extends AppCompatSeekBar {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float trungduc;
    private View mView;
    private int mWidth;

    private int mProgressColor;
    private int mColorEstimate;


    public float getTrungduc() {
        return trungduc;
    }

    public void setTrungduc(float trungduc) {
        this.trungduc = trungduc;
        invalidate();
    }

    public HSeeakBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HSeeakBar, 0, 0);
        mProgressColor = typedArray.getColor(R.styleable.HSeeakBar_colorTextProgress, Color.BLUE);
        mColorEstimate = typedArray.getColor(R.styleable.HSeeakBar_colorBackgroudEstimate, Color.BLUE);
        typedArray.recycle();


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.layout_indicator, null);
        mView.measure(MeasureSpec.getSize(mView.getMeasuredWidth()), MeasureSpec.getSize(mView.getMeasuredHeight()));
        mView.layout(400, 400, 400, 400);


    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        drawTextProgress(canvas);
        drawTexEstimate(canvas);
    }

    private void drawTexEstimate(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft() + trungduc * mWidth, getPivotY());
//        TextView textArrow = mView.findViewById(R.id.arow);
//        TextView textView = mView.findViewById(R.id.textEstimate);
//        textArrow.setBackgroundColor(mColorEstimate);
//        textView.setBackgroundColor(mColorEstimate);
        mView.draw(canvas);
        canvas.restore();
    }

    private void drawTextProgress(Canvas canvas) {
        mPaint.setColor(mProgressColor);
        mPaint.setTextSize(70);
        mPaint.setFakeBoldText(true);
        String text = getProgress() + "%";
        Rect rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        canvas.drawText(text, (getPaddingLeft() + (float) mWidth * getProgress() / getMax() - rect.width() / 2), getPivotY() - 100, mPaint);
    }
}
