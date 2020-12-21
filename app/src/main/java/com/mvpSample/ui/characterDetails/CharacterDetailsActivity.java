package com.mvpSample.ui.characterDetails;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mvpSample.R;
import com.mvpSample.base.view.BaseActivity;
import com.mvpSample.data.entity.search.Appearance;
import com.mvpSample.data.entity.search.SearchResult;

/**
 * CharacterDetailsActivity
 */
public class CharacterDetailsActivity extends BaseActivity {
    private static final String EXTRA_CHARACTER_DETAILS = "EXTRA_CHARACTER_DETAILS";
    private SearchResult characterDetails;

    @Override
    public int getLayout() {
        return R.layout.activity_character_details;
    }

    /**
     * Create intent.
     *
     * @param mContext the m context
     * @return the intent
     */
    public static Intent createIntent(final Context mContext, final SearchResult characterdetails) {
        Intent intent = new Intent(mContext, CharacterDetailsActivity.class);
        intent.putExtra(EXTRA_CHARACTER_DETAILS, characterdetails);
        return intent;
    }

    @Override
    protected void initView() {
        super.initView();
        if (getIntent() != null && getIntent().hasExtra(EXTRA_CHARACTER_DETAILS)) {
            characterDetails = getIntent().getParcelableExtra(EXTRA_CHARACTER_DETAILS);
        }
        findViewById(R.id.ivBack).setVisibility(View.VISIBLE);
        findViewById(R.id.ivBack).setOnClickListener(view -> onBackPressed());

        setCharacterDetailsDataInUI();
    }

    private void setCharacterDetailsDataInUI() {
        if (characterDetails != null) {
            ((TextView) findViewById(R.id.tvTitle)).setText(characterDetails.getName());
            if (characterDetails.getImage() != null && characterDetails.getImage().getUrl() != null) {
                Glide.with(this).load(characterDetails.getImage().getUrl()).into((ImageView) findViewById(R.id.ivSuperheroImage));
            }
            ((TextView) findViewById(R.id.tvSuperheroName)).setText(characterDetails.getName());
            if (characterDetails.getConnections() != null && characterDetails.getConnections().getGroupAffiliation() != null) {
                ((TextView) findViewById(R.id.tvSuperheroDescription)).setText(characterDetails.getConnections().getGroupAffiliation());
            }
            if (characterDetails.getAppearance() != null) {
                Appearance appearance = characterDetails.getAppearance();
                if (appearance.getRace() != null && !appearance.getRace().isEmpty()) {
                    String race = getString(R.string.text_race) + appearance.getRace();
                    ((TextView) findViewById(R.id.tvSuperheroRace)).setText(race);
                }
                if (appearance.getGender() != null && !appearance.getGender().isEmpty()) {
                    String gender = getString(R.string.text_gender) + appearance.getGender();
                    ((TextView) findViewById(R.id.tvSuperheroGender)).setText(gender);
                }
                if (appearance.getHeight() != null && !appearance.getHeight().isEmpty()) {
                    String height = getString(R.string.text_height) + appearance.getHeight().get(1);
                    ((TextView) findViewById(R.id.tvSuperheroHeight)).setText(height);
                }
                if (appearance.getEyeColor() != null && !appearance.getEyeColor().isEmpty()) {
                    String eyeColor = getString(R.string.text_eye_color) + appearance.getEyeColor();
                    ((TextView) findViewById(R.id.tvSuperheroEyeColor)).setText(eyeColor);
                }
            }
        }
    }
}