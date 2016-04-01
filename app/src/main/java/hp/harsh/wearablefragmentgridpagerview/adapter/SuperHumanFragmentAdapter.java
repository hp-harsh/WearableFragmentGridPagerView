
/*
* Copyright 2016 Harsh Patel
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package hp.harsh.wearablefragmentgridpagerview.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;

import hp.harsh.wearablefragmentgridpagerview.R;

public class SuperHumanFragmentAdapter extends FragmentGridPagerAdapter {

    private Context mContext;

    public SuperHumanFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    // A simple container for static data in each page
    private static class Page {
        int backgroundRes, titleRes, desRes;

        public Page(int backgroundRes, int titleRes, int desRes) {
            this.backgroundRes = backgroundRes;
            this.titleRes = titleRes;
            this.desRes = desRes;
        }
    }

    @Override
    public Fragment getFragment(int row, int col) {
        Page page = PAGES[row][col];

        CardFragment fragment = CardFragment.create(mContext.getResources().getString(page.titleRes), mContext.getResources().getString(page.desRes));

        return fragment;
    }

    // Create a static set of pages in a 2D array
    private final Page[][] PAGES = {{new Page(R.mipmap.spider1, R.string.titleSpiderman, R.string.desSpiderman), new Page(R.mipmap.spider2, R.string.titleSpiderman, R.string.desSpiderman), new Page(R.mipmap.spider3, R.string.titleSpiderman, R.string.desSpiderman)},
            {new Page(R.mipmap.batman1, R.string.titleBatman, R.string.desBatman), new Page(R.mipmap.batman2, R.string.titleBatman, R.string.desBatman), new Page(R.mipmap.batman3, R.string.titleBatman, R.string.desBatman)},
            {new Page(R.mipmap.ironman1, R.string.titleIronman, R.string.desIronman), new Page(R.mipmap.ironman2, R.string.titleIronman, R.string.desIronman), new Page(R.mipmap.ironman3, R.string.titleIronman, R.string.desIronman)}};

    // Obtain the number of pages (vertical)
    @Override
    public int getRowCount() {
        return PAGES.length;
    }

    // Obtain the number of pages (horizontal)
    @Override
    public int getColumnCount(int rowNum) {
        return PAGES[rowNum].length;
    }

    // Obtain current item background drawable
    @Override
    public Drawable getBackgroundForPage(int row, int col) {
        Page page = PAGES[row][col];
        return mContext.getResources().getDrawable(page.backgroundRes);
    }
}