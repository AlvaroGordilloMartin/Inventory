package com.example.inventory.iu.preferences;

import android.os.Bundle;

import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.inventory.R;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.setting_preferences);
        initPreferenceAccount();
    }

    private void initPreferenceAccount() {
        Preference accountPreferences = getPreferenceManager().findPreference(getString(R.string.key_account));
        accountPreferences.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                NavHostFragment.findNavController(SettingsFragment.this).navigate(R.id.action_settingsFragment_to_accountFragment,null);
                return true;
            }
        });
    }
}
