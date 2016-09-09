package bistu.rookie.u_nity.androidproject_18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.nio.charset.StandardCharsets;


public class MainActivity extends AppCompatActivity {

    private final static String MyFileName="FileTest";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button writeButton = (Button) findViewById(R.id.WriteButton);
        Button readButton = (Button) findViewById(R.id.ReadButton);
        writeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                OutputStream out = null;
                try {
                    FileOutputStream fos = openFileOutput(MyFileName, MODE_PRIVATE);
                    out = new BufferedOutputStream(fos);
                    String content = "U-nity 2014011456 " + MyFileName;
                    try {
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                    }
                    finally {
                        if(out != null)
                            out.close();
                        Toast.makeText(MainActivity.this, "Write Success!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        readButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream in = null;
                try {
                    FileInputStream fis = openFileInput(MyFileName);
                    in = new BufferedInputStream(fis);

                    int c;
                    StringBuilder builder = new StringBuilder("");
                    try{
                        while ((c = in.read()) != -1) {
                            builder.append((char)c);
                        }
                        Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_LONG).show();
                    }
                    finally {
                        if(in != null)
                            in.close();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }


            }
        });
    }
}
