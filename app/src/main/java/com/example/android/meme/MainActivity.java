package com.example.android.meme;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    /*
    1. store all the data somewhere
        res/values/strings.xml
    2. define the structure of a single row of your listView inside single_row.xml
    3. define the listview inside main layout and reference it in your activity
    4. create your customer adapter from BaseAdapter that puts the data for each row inside getView.
     */

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);

        // setting the MemeAdapter to the list
        list.setAdapter(new MemeAdapter(this));
    }
}


class SingleRow {
    String title;
    String description;
    int image;

    SingleRow(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
}


// Customer adaptor is created
class MemeAdapter extends BaseAdapter {

    /*
    u1, u2, u3, u4
    u1 -> composite object: title, description and image
     */

    ArrayList<SingleRow> list;
    Context context;

    // constructor which adds title, description and image
    MemeAdapter(Context c) {
        context = c;

        list = new ArrayList<SingleRow>();
        Resources res = c.getResources();
        String[] titles = res.getStringArray(R.array.titles);
        String[] descriptions = res.getStringArray(R.array.descriptions);
        int[] images = {R.drawable.meme1,
                R.drawable.meme2,
                R.drawable.meme3,
                R.drawable.meme4,
                R.drawable.meme5,
                R.drawable.meme6,
                R.drawable.meme7,
                R.drawable.meme8,
                R.drawable.meme9,
                R.drawable.meme10
        };

        for (int i = 0; i < 10; i++) {
            list.add(new SingleRow(titles[i], descriptions[i], images[i]));
        }
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    1. get the root view (Relative layout in this case in single_row.xml)
    2. use the root view to find other views
    3. set the values
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // LayoutInflater is used to create a new View object everytime
        // findViewById is used to refer to the same view everytime
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // create a new row object by using inflater
        View row = inflater.inflate(R.layout.single_row, parent, false);

        // finding the elements within row that just got created
        TextView title = (TextView) row.findViewById(R.id.memeTitle);
        TextView description = (TextView) row.findViewById(R.id.memeDescription);
        ImageView image = (ImageView) row.findViewById(R.id.imageView);

        // get the contents of each views from listView
        SingleRow temp = list.get(position);

        title.setText(temp.title);
        description.setText(temp.description);
        image.setImageResource(temp.image);

        return row;
    }
}