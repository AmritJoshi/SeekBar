package kampfire.verify.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;
public class MainActivity extends AppCompatActivity {
    int counter = 0;
    SeekBar seekbar;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler=new Handler();
        seekbar=findViewById(R.id.seekbar);
        new Thread(new Runnable(){
            public void run() {
                while(counter<100){
                    counter+=5;
                    handler.post(new Runnable(){
                        public void run(){
                       seekbar.setProgress(counter);
                        }
                    });
                    try{
                        Thread.sleep(500);
                    }catch(InterruptedException e){

                    }
                }
            }
        }).start();
    }
}