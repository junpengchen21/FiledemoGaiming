package cn.edu.gdmec.s07150705.filedemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private File pd;
    private File espd;
    private File esd;
    private File ds;
    private File dlcd;
    private File rd;
    private String name,path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.result);
        pd=this.getFilesDir();
        espd = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
        esd =Environment.getExternalStorageDirectory();
        ds = Environment.getDataDirectory();
        dlcd =Environment.getDownloadCacheDirectory();
        rd=Environment.getRootDirectory();

        if(Environment.getExternalStorageDirectory().equals(Environment.MEDIA_REMOVED)){
            Button btn = (Button) findViewById(R.id.esd);
            btn.setEnabled(false);
        }

    }
    public void pd(View v){
        path = pd.getPath();
        try{
            FileOutputStream fos =openFileOutput("test.txt",MODE_PRIVATE);
            fos.write("hello".getBytes());
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        listFiles(path);
    }
    public void esd(View v){
        path =espd.getAbsolutePath();
        listFiles(path);
    }
    public void ds(View v){
        path =ds.getAbsolutePath();
        listFiles(path);
    }
    public void dlcd(View v){
        path =dlcd.getAbsolutePath();
        listFiles(path);
    }
    public void rd(View v){
        path =rd.getAbsolutePath();
        listFiles(path);
    }
    private  boolean listFiles(String path){
        name="路径:"+path+"\n文件清单\n";
        File file = new File(path);
        if(file.listFiles()!=null&&file.listFiles().length>0){
            for(File f : file.listFiles()){
                path=f.getAbsolutePath();
                name = name +f.getName()+"\n";
            }
        }
        tv1.setText(name);
        return true;
    }
}