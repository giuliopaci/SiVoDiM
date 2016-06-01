package starklabs.sivodim.Drama.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import starklabs.sivodim.Drama.Presenter.ChapterPresenterImpl;
import starklabs.sivodim.Drama.Presenter.CharacterPresenter;
import starklabs.sivodim.Drama.Presenter.CharacterPresenterImpl;
import starklabs.sivodim.R;

public class ListCharacterActivity extends AppCompatActivity implements ListCharacterInterface {
    private static CharacterPresenter characterPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_character);

        if(characterPresenter==null)characterPresenter=new CharacterPresenterImpl(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String screenplayWithCharacters=(String)getIntent().getSerializableExtra("ScreenplayWithCharacters");
        getSupportActionBar().setTitle("Personaggi - "+screenplayWithCharacters);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newCharacterIntent=new Intent(view.getContext(),NewCharacterActivity.class);
                startActivity(newCharacterIntent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
