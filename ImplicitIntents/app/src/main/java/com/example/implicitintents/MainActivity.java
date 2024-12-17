package com.example.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareEditText;

    /* Initiate app Function */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /* resources */
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareEditText = findViewById(R.id.share_edittext);

        /* Main onCreate Function */
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /* Website onClick Method */
    public void openWebsite(View view) {
        // Get the URL
        String url = mWebsiteEditText.getText().toString();
        // Change the string to url and create intent
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // find the activity and start
        if (intent.resolveActivity(getPackageManager()) == null ) { // pinaltan ng == kasi di nagana pag !
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    /* Location onClick Method */
    public void openLocation(View view) {
        // Get the string for the location
        String loc = mLocationEditText.getText().toString();
        // Parse the location and create the intent
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // find activity and start
        if (intent.resolveActivity(getPackageManager()) != null ) {
            Log.d("ImplicitIntent", "Can't handle this intent!"); // pinag palit sa start
        } else {
            startActivity(intent); // pinnag palit kasi di gumagana
        }
    }

    /* Share onClick Method */
    public void shareText(View view) {
        // Get the string to be shared
        String txt = mShareEditText.getText().toString();
        // define the mime type and create with intent builder
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_text_with)
                .setText(txt)
                .startChooser();

    }

}