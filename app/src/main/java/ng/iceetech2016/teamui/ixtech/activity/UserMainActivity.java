package ng.iceetech2016.teamui.ixtech.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.javiersantos.bottomdialogs.BottomDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ng.iceetech2016.teamui.ixtech.R;
import ng.iceetech2016.teamui.ixtech.util.iXTechUtils;

public class UserMainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("iXTech: Home");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onBackPressed(){
        new BottomDialog.Builder(this)
                .setTitle("Exit")
                .setContent("Do you want to exit the application?")
                .setCancelable(true)
                .setIcon(R.drawable.ic_exit)
                .setPositiveText(R.string.diag_yes)
                .onPositive(new BottomDialog.ButtonCallback() {
                    @Override
                    public void onClick(@NonNull BottomDialog bottomDialog) {
                        finish();
                    }
                })
                .show();
    }
    
    @OnClick(R.id.UserPosts)
    public void UserPosts(){
        Intent i= new Intent(this,UserViewPostActivity.class);
        i.putExtra(iXTechUtils.POST_TYPE,"User");
        startActivity(i);
    }
    
    @OnClick (R.id.cdnetPost)
    public void CDNetPosts(){
        Intent i= new Intent(this,CDNetViewPostActivity.class);
        i.putExtra(iXTechUtils.POST_TYPE,"User");
        startActivity(i);
    }

    private void ShowPosts(){
        Intent i= new Intent(this,UserViewPostActivity.class);
        i.putExtra(iXTechUtils.POST_TYPE,"User");
        startActivity(i);
    }
}
