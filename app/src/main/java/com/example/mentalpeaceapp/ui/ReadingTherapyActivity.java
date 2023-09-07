package com.example.mentalpeaceapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.example.mentalpeaceapp.R;
import com.example.mentalpeaceapp.data.models.Quote;
import com.example.mentalpeaceapp.databinding.ActivityReadingTherapyBinding;
import com.example.mentalpeaceapp.ui.util.ImageAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadingTherapyActivity extends AppCompatActivity {

    ActivityReadingTherapyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_therapy);
        binding = ActivityReadingTherapyBinding.inflate(getLayoutInflater());
        Objects.requireNonNull(getSupportActionBar()).hide();


        ViewPager2 motivationalCarousel = binding.motivationalCarousel;
        ViewPager2 inspirationCarousel = binding.inspirartionalCarousel;

        List<Quote> motivationalQuotes = new ArrayList<>();
        motivationalQuotes.add(new Quote(getDrawable(R.drawable.motivation),"Life isn't about finding yourself. Life is about creating yourself."));
        motivationalQuotes.add(new Quote(getDrawable(R.drawable.inspiration),"A mistake that makes you humble is better than an achievement that makes you arrogant."));
        motivationalQuotes.add(new Quote(getDrawable(R.drawable.inspiration_1),"Why do we only rest in peace why don't we live in peace too?"));
        motivationalQuotes.add(new Quote(getDrawable(R.drawable.motivation_3),"Our greatest glory is not in never falling, but in rising every time we fall."));

        ImageAdapter imageAdapter1 = new ImageAdapter(this, motivationalQuotes);
        motivationalCarousel.setAdapter(imageAdapter1);

        List<Quote> inspirationalQuotes = new ArrayList<>();

        inspirationalQuotes.add(new Quote(getDrawable(R.drawable.motivation1),"It’s not the events of our lives that shape us, but our beliefs as to what those events mean."));
        inspirationalQuotes.add(new Quote(getDrawable(R.drawable.woman1),"Breath is the power behind all things…. I breathe in and know that good things will happen."));
        inspirationalQuotes.add(new Quote(getDrawable(R.drawable.job_satisfaction),"You can't control the wind, but you can adjust your sails."));
        inspirationalQuotes.add(new Quote(getDrawable(R.drawable.passion),"There are times when we stop, we sit still. We listen and breezes from a whole other world begin to whisper."));

        ImageAdapter imageAdapter2 = new ImageAdapter(this, motivationalQuotes);
        motivationalCarousel.setAdapter(imageAdapter2);

    }
}